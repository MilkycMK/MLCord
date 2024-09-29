package net.mlk.mlcord.network.http;

import net.mlk.mlcord.network.http.utils.HttpMethod;
import net.mlk.mlcord.network.http.utils.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class HttpRequestManager {
    private final CopyOnWriteArrayList<HttpRequest> requests = new CopyOnWriteArrayList<>();
    private HashMap<String, String> headers = new HashMap<>();
    private boolean started = false;
    private Thread requestsThread;

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public void setHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public void createRequest(String url, String payload) {
        this.createRequest(url, payload, HttpMethod.GET);
    }

    public void createRequest(String url, String payload, HttpMethod method) {
        this.createRequest(new HttpRequest(url, payload, method));
    }

    public void createRequest(String url, String payload, HashMap<String, String> headers) {
        this.createRequest(url, payload, headers, HttpMethod.GET);
    }

    public void createRequest(String url, String payload, HashMap<String, String> headers, HttpMethod method) {
        this.createRequest(new HttpRequest(url, payload, method));
    }

    public void createRequest(HttpRequest request) {
        this.requests.add(request);
    }

    public boolean isEnabled() {
        return this.started;
    }

    public void stop() {
        if (this.requestsThread != null && this.requestsThread.isAlive()) {
            this.requestsThread.interrupt();
        }
        this.started = false;
    }

    public void start() {
        if (this.started && requestsThread.isAlive()) {
            this.requestsThread.interrupt();
        }

        this.requestsThread = new Thread(() -> {
            this.started = true;
            while (!Thread.currentThread().isInterrupted()) {
                for (HttpRequest request : this.requests) {
                    this.requests.remove(request);
                    try {
                        String response = this.send(request.getUrl(), request.getPayload(), request.getHeaders(), request.getMethod());
                        this.onMessage(response);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        this.requestsThread.start();
    }

    public String send(String url) {
        return this.send(url, "", new HashMap<>(), HttpMethod.GET);
    }

    public String send(String url, String payload) {
        return this.send(url, payload, new HashMap<>(), HttpMethod.GET);
    }

    public String send(String url, String payload, HashMap<String, String> headers) {
        return this.send(url, payload, headers, HttpMethod.GET);
    }

    public String send(String url, String payload, HttpMethod method) {
        return this.send(url, payload, new HashMap<>(), method);
    }

    public String send(String url, String payload, HashMap<String, String> headers, HttpMethod method) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            this.setHeaders(connection);
            this.setHeaders(connection, headers);
            connection.connect();

            if (method == HttpMethod.POST && payload != null && payload.length() != 0) {
                byte[] data = payload.getBytes();
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(data);
                outputStream.flush();
            }

            BufferedReader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            connection.disconnect();
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    protected void onMessage(String message) {

    }

    private String toQueryString(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            String value = map.get(key);
            sb.append(key).append("=").append(value).append("&");
        }
        sb.deleteCharAt(sb.length() - 1); // удалить последний символ &
        return "?" + sb;
    }

    private void setHeaders(HttpURLConnection connection) {
        this.setHeaders(connection, this.headers);
    }

    private void setHeaders(HttpURLConnection connection, HashMap<String, String> headers) {
        for (String key : headers.keySet()) {
            connection.setRequestProperty(key, headers.get(key));
        }
    }
}
