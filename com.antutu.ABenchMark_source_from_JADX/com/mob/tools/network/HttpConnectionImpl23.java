package com.mob.tools.network;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpConnectionImpl23 implements HttpConnection {
    private HttpURLConnection conn;

    public HttpConnectionImpl23(HttpURLConnection httpURLConnection) {
        this.conn = httpURLConnection;
    }

    public InputStream getErrorStream() {
        return this.conn.getErrorStream();
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.conn.getHeaderFields();
    }

    public InputStream getInputStream() {
        return this.conn.getInputStream();
    }

    public int getResponseCode() {
        return this.conn.getResponseCode();
    }
}
