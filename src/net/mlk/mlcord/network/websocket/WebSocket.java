package net.mlk.mlcord.network.websocket;

import net.mlk.mlcord.network.websocket.utils.WebSocketCloseCode;
import net.mlk.mlcord.network.websocket.utils.WebSocketFrame;
import net.mlk.mlcord.network.websocket.utils.WebSocketListener;

import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class WebSocket {
    private URI uri;
    private Socket socket;
    private BufferedInputStream inputStream;
    private BufferedOutputStream outputStream;
    private WebSocketListener listener;
    private Thread listenerThread;

    /**
     * Initialize the websocket with uri
     * @param uri uri of the resource to connect
     */
    public WebSocket(URI uri) {
        this.uri = uri;
    }

    /**
     * start connection to specified uri
     */
    public WebSocket connect() throws IOException {
        return this.connect(this.uri);
    }

    /**
     * start connection to a new uri
     * @param uri new uri of the resource
     */
    public WebSocket connect(URI uri) throws IOException {
        if (this.uri != uri) {
            this.setUri(uri);
        }

        if (this.uri.getScheme().equalsIgnoreCase("wss")) {
            this.socket = SSLSocketFactory.getDefault().createSocket(uri.getHost(), this.getPort());
        } else {
            this.socket = new Socket(uri.getHost(), this.getPort());
        }

        this.inputStream = new BufferedInputStream(this.socket.getInputStream());
        this.outputStream = new BufferedOutputStream(this.socket.getOutputStream());

        try {
            this.startHandShake();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Can't find SHA-1 algorithm on your device. Please install it and try later.");
        }
        return this;
    }

    /**
     * @return read message from connection
     */
    public String receive() {
        try {
            int firstByte = this.inputStream.read();
            if (firstByte == -1) {
                return null;
            }
            int secondByte = this.inputStream.read();
            boolean isTextFrame = firstByte == 0x81;
            boolean isCloseFrame = firstByte == WebSocketFrame.CLOSE_FRAME.getFrameByte() ||
                    firstByte == WebSocketFrame.CLOSE_FRAME_WITH_REASON.getFrameByte();
            int length = -1;
            int closeCode = -1;

            if (isTextFrame) {
                if (secondByte == 126) { // Extended TextFrame
                    length = (this.inputStream.read() << 8) | this.inputStream.read();
                } else if (secondByte == 127) { // Extended Payload
                    length = 0;
                    for (int i = 0; i < 8; i++) {
                        length |= (long) (this.inputStream.read() & 0xFF) << (8 * (7 - i));
                    }
                } else { // Default TextFrame
                    length = secondByte;
                }
            } else if (isCloseFrame) {
                closeCode = ((this.inputStream.read() & 0xFF) << 8) | (this.inputStream.read() & 0xFF);
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!isTextFrame && !isCloseFrame) { // It may be a letters! Let's add them
                byteArrayOutputStream.write((byte) firstByte);
                byteArrayOutputStream.write((byte) secondByte);
            }
            int ch;
            while ((isTextFrame || this.inputStream.available() != 0) && byteArrayOutputStream.size() != length) {
                ch = this.inputStream.read();
                byteArrayOutputStream.write(ch);
            }

            if (isCloseFrame) {
                this.handleCloseCode(closeCode, byteArrayOutputStream.toString());
                return null;
            }

            return this.recieveString(isTextFrame, byteArrayOutputStream.toByteArray());
        } catch (SocketTimeoutException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Send string message to websocket
     * @param message json
     */
    public final void send(String message) {
        this.send(message.getBytes());
    }

    /**
     * send data to websocket
     * @param messageBytes message bytes for send
     */
    public final void send(byte[] messageBytes) {
        this.send(messageBytes, WebSocketFrame.TEXT_FRAME);
    }

    /**
     * send data to websocket
     * @param messageBytes message bytes for send in specified frame
     * @param frame frame to send
     */
    public final void send(byte[] messageBytes, WebSocketFrame frame) {
        try {
            byte[] mask = new byte[4];
            new Random().nextBytes(mask);
            for (int i = 0; i < messageBytes.length; i++) {
                messageBytes[i] ^= mask[i % 4];
            }
            ByteArrayOutputStream frameStream = new ByteArrayOutputStream();
            int length = messageBytes.length;
            frameStream.write(frame.getFrameByte());
            if (length <= 125) {
                frameStream.write((byte) length | 0x80);
            } else if (length <= 65535) {
                frameStream.write((byte) 0xfe);
                frameStream.write((byte) (length >> 8));
                frameStream.write((byte) length);
            } else {
                frameStream.write((byte) 0xff);
                for (int i = 7; i >= 0; i--) {
                    frameStream.write((byte) (length >> (i * 8)));
                }
            }
            frameStream.write(mask);
            frameStream.write(messageBytes);
            this.outputStream.write(frameStream.toByteArray());
            this.outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * close connection with default code 1000
     */
    public final void close() {
        this.close(1000);
    }

    /**
     * close connection with specified close code
     * @param closeCode close code
     */
    public final void close(int closeCode) {
        this.close(closeCode, "");
    }

    /**
     * close connection with close code and message
     * @param closeCode close code
     * @param message message
     */
    public final void close(int closeCode, String message) {
        this.onClose();
        byte[] closeMessage = new byte[message.length() + 2];
        closeMessage[0] = (byte) (closeCode >> 8);
        closeMessage[1] = (byte) (closeCode & 0xFF);
        System.arraycopy(message.getBytes(), 0, closeMessage, 2, message.length());
        if (this.isConnected()) {
            try {
                this.send(closeMessage, WebSocketFrame.CLOSE_FRAME_WITH_REASON);
                if (this.listenerThread != null && this.listenerThread.isAlive()) {
                    this.listenerThread.interrupt();
                }
                this.socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * send headers to open websocket connection
     */
    protected void startHandShake() throws IOException, NoSuchAlgorithmException {
        String headers = String.format(
                "GET /%s HTTP/1.1\r\n" +
                        "Host: %s\r\n" +
                        "Upgrade: websocket\r\n" +
                        "Connection: Upgrade\r\n" +
                        "Sec-WebSocket-Key: %s\r\n" +
                        "Sec-WebSocket-Version: 13\r\n\r\n",
                "?" + uri.getQuery(), uri.getHost(), this.generateWebSocketKey());
        this.outputStream.write(headers.getBytes());
        this.outputStream.flush();

        StringBuilder builder = new StringBuilder();
        int ch = this.inputStream.read();
        while (this.inputStream.available() > 0) {
            builder.append((char) ch);
            ch = this.inputStream.read();
        }
        if (builder.toString().contains("HTTP/1.1 101 Switching Protocols")) {
            this.startListener();
        }
    }

    /**
     * Generates the Sec-WebSocket-Key
     * @return key if sha-1 algorithm exists
     * @throws RuntimeException if sha-1 algorithm not found
     */
    protected String generateWebSocketKey() throws NoSuchAlgorithmException {
        byte[] inputBytes = new byte[20];
        new Random().nextBytes(inputBytes);
        ByteBuffer buffer = ByteBuffer.wrap(inputBytes);
        long timestamp = System.currentTimeMillis() / 1000;
        buffer.putLong(12, timestamp);
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] outputBytes = md.digest(inputBytes);
        return Base64.getEncoder().encodeToString(outputBytes);
    }

    /**
     * starts current websocket listener
     */
    protected void startListener() {
        if (this.listener == null || !this.isConnected()) {
            return;
        } else if (this.listenerThread != null && this.listenerThread.isAlive()) {
            this.listenerThread.interrupt();
        }

        this.listenerThread = new Thread(() -> {
            while (!this.listenerThread.isInterrupted()) {
                String response = this.receive();
                if (response != null) {
                    this.listener.onMessage(response);
                }
            }
        });
        this.listenerThread.start();
    }

    /**
     * @param listener listener to set
     * @return instance
     */
    public WebSocket setListener(WebSocketListener listener) {
        this.listener = listener;
        this.startListener();
        return this;
    }

    /**
     * @return true if connected
     */
    public boolean isConnected() {
        return this.socket != null && !this.socket.isClosed() && this.socket.isConnected();
    }

    /**
     * change websocket uri to a new and reconnect
     * @param uri new uri of the resource
     * @return instance of the WebSocket
     */
    public WebSocket setUri(URI uri) {
        this.uri = uri;
        return this;
    }

    /**
     * validate uri with the websocket standard
     * @param uri uri to validate
     * @return true if valid
     */
    public boolean isUriValid(URI uri) {
        if (uri == null) {
            throw new NullPointerException("URI is null");
        }

        String scheme = uri.getScheme();
        return scheme.equalsIgnoreCase("wss") || scheme.equalsIgnoreCase("ws");
    }

    /**
     * @return connection port
     */
    public int getPort() {
        int port = this.uri.getPort();
        if (port == -1) {
            if (this.uri.getScheme().equalsIgnoreCase("wss")) {
                port = 443;
            } else {
                port = 80;
            }
        }
        return port;
    }

    /**
     * @return socket input stream
     */
    public BufferedInputStream getInputStream() {
        return this.inputStream;
    }

    /**
     * @return socket output stream
     */
    public BufferedOutputStream getOutputStream() {
        return this.outputStream;
    }

    /**
     * @return socket
     */
    public Socket getSocket() {
        return this.socket;
    }

    /**
     * method that you can override to get specific string by receive method
     * @param isTextFrame true if message is TextFrame
     * @param responseBytes bytes of response
     * @return message
     */
    protected String recieveString(boolean isTextFrame, byte[] responseBytes) {
        return new String(responseBytes, StandardCharsets.UTF_8);
    }

    /**
     * Method that called when connection start closing
     */
    protected void onClose() {

    }

    /**
     * Method that contains and work with websocket close codes
     * you can overwrite it with yours
     *
     * @param code received code
     */
    protected void handleCloseCode(int code, String message) {
        WebSocketCloseCode closeCode = WebSocketCloseCode.getByCode(code);

        if (closeCode == WebSocketCloseCode.NORMAL_CLOSE) {
            this.close();
        } else if (closeCode == WebSocketCloseCode.GOING_AWAY) {
            this.close();
        } else if (closeCode == WebSocketCloseCode.PROTOCOL_ERROR) {
            this.close();
            throw new RuntimeException("The endpoint is terminating the connection due to a protocol error.");
        } else if (closeCode == WebSocketCloseCode.UNSUPPORTED_DATA) {
            this.close();
            throw new RuntimeException("The connection is being terminated because the endpoint received data of a type it cannot accept.");
        } else if (closeCode == WebSocketCloseCode.RESERVED) {
            this.close();
        } else if (closeCode == WebSocketCloseCode.NO_STATUS_RECEIVED) {
            this.close();
            throw new RuntimeException("No status code received");
        } else if (closeCode == WebSocketCloseCode.ABNORMAL_CLOSE) {
            this.close();
            throw new RuntimeException("The connection was closed abnormally when a status code is expected.");
        } else if (closeCode == WebSocketCloseCode.INVALID_FRAME_PAYLOAD_DATA) {
            this.close();
            throw new RuntimeException("The endpoint is terminating the connection because a message was received that contained inconsistent data.");
        } else if (closeCode == WebSocketCloseCode.POLICY_VIOLATION) {
            this.close();
            throw new RuntimeException("The endpoint is terminating the connection because it received a message that violates its policy.");
        } else if (closeCode == WebSocketCloseCode.MESSAGE_TOO_BIG) {
            this.close();
            throw new RuntimeException("The endpoint is terminating the connection because a data frame was received that is too large.");
        } else if (closeCode == WebSocketCloseCode.MANDATORY_EXT) {
            this.close();
            throw new RuntimeException("The client is terminating the connection because it expected the server to negotiate one or more extension, but the server didn't.");
        } else if (closeCode == WebSocketCloseCode.INTERNAL_ERROR) {
            this.close();
            throw new RuntimeException("The server is terminating the connection because it encountered an unexpected condition that prevented it from fulfilling the request.");
        } else if (closeCode == WebSocketCloseCode.SERVICE_RESTART) {
            this.close();
            throw new RuntimeException("The server is terminating the connection because it is restarting.");
        } else if (closeCode == WebSocketCloseCode.TRY_AGAIN_LATER) {
            this.close();
            throw new RuntimeException("The server is terminating the connection due to a temporary condition");
        } else if (closeCode == WebSocketCloseCode.BAD_GATEWAY) {
            this.close();
            throw new RuntimeException("The server was acting as a gateway or proxy and received an invalid response from the upstream server.");
        } else if (closeCode == WebSocketCloseCode.TLS_HANDSHAKE) {
            this.close();
            throw new RuntimeException("The connection was closed due to a failure to perform a TLS handshake.");
        } else {
            this.close();
            throw new RuntimeException("Undefined close code " + code + " with message: \"" + message + "\"");
        }
    }

}
