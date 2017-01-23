package com.miui.support.net.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequestParams {
    public static String f3438a;
    private String f3439b;
    private ConcurrentHashMap<String, Object> f3440c;
    private boolean f3441d;

    static class FileWrapper {
        public InputStream f3434a;
        public long f3435b;
        public String f3436c;
        public String f3437d;
    }

    static {
        f3438a = "UTF-8";
    }

    public HttpRequestParams() {
        this.f3439b = f3438a;
        this.f3440c = new ConcurrentHashMap();
        this.f3441d = false;
    }

    public String m5135a() {
        return URLEncodedUtils.format(m5134c(), this.f3439b);
    }

    HttpEntity m5136b() {
        try {
            if (this.f3441d) {
                return new SimpleMultipartEntity(this.f3439b, this.f3440c);
            }
            return new UrlEncodedFormEntity(m5134c(), this.f3439b);
        } catch (IOException e) {
            return null;
        }
    }

    private List<BasicNameValuePair> m5134c() {
        List<BasicNameValuePair> linkedList = new LinkedList();
        for (Entry entry : this.f3440c.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) value));
            } else if (value instanceof List) {
                for (String basicNameValuePair : (List) value) {
                    linkedList.add(new BasicNameValuePair((String) entry.getKey(), basicNameValuePair));
                }
            }
        }
        return linkedList;
    }
}
