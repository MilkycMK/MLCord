package net.mlk.mlcord.network.http.utils;

import java.util.HashMap;

public class HttpRequest {
    private final String url;
    private final String payload;
    private final HttpMethod method;
    private HashMap<String, String> headers = new HashMap<>();

    public HttpRequest(String url, String payload, HttpMethod method) {
        this.url = url;
        this.payload = payload;
        this.method = method;
    }

    public HttpRequest(String url, String payload, HashMap<String, String> headers, HttpMethod method) {
        this(url, payload, method);
        this.headers = headers;
    }

    /**
     * @return request method
     */
    public HttpMethod getMethod() {
        return this.method;
    }

    /**
     * @return request url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return request payload
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     * @return request headers
     */
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    /**
     * @param key key of header
     * @param value header value
     */
    public void setHeader(String key, String value) {
        this.headers.put(key, value);
    }
}
