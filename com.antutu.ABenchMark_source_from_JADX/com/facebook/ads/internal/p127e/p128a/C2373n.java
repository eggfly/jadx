package com.facebook.ads.internal.p127e.p128a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.e.a.n */
public class C2373n {
    private int f8266a;
    private String f8267b;
    private Map<String, List<String>> f8268c;
    private byte[] f8269d;

    public C2373n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f8266a = httpURLConnection.getResponseCode();
            this.f8267b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f8268c = httpURLConnection.getHeaderFields();
        this.f8269d = bArr;
    }

    public int m9134a() {
        return this.f8266a;
    }

    public String m9135b() {
        return this.f8267b;
    }

    public Map<String, List<String>> m9136c() {
        return this.f8268c;
    }

    public byte[] m9137d() {
        return this.f8269d;
    }

    public String m9138e() {
        return this.f8269d != null ? new String(this.f8269d) : null;
    }
}
