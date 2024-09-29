package net.mlk.mlcord.network.websocket.utils;

public enum WebSocketFrame {
    /*
     WebSocket text frame
     */
    TEXT_FRAME(0x81),

    /*
     WebSocket close frame where you can set close code and reason
     */
    CLOSE_FRAME_WITH_REASON(0x88),

    /*
     Default WebSocket close frame
     */
    CLOSE_FRAME(0x8);

    private final int frameByte;
    WebSocketFrame(int i) {
        this.frameByte = i;
    }

    /**
     * @return byte of the frame
     */
    public int getFrameByte() {
        return this.frameByte;
    }
}
