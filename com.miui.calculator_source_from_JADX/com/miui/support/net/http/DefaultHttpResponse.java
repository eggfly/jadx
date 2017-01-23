package com.miui.support.net.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

class DefaultHttpResponse implements HttpResponse {
    private int f3409a;
    private InputStream f3410b;
    private String f3411c;
    private String f3412d;
    private long f3413e;
    private Map<String, String> f3414f;

    public DefaultHttpResponse(int i, Map<String, String> map, InputStream inputStream, long j, String str, String str2) {
        this.f3409a = i;
        this.f3410b = inputStream;
        this.f3413e = j;
        this.f3411c = str;
        this.f3412d = str2;
        this.f3414f = map;
    }

    public void m5102a(InputStream inputStream, long j) {
        this.f3410b = inputStream;
        this.f3413e = j;
    }

    public InputStream m5101a() {
        return this.f3410b;
    }

    public long m5103b() {
        return this.f3413e;
    }

    public String m5104c() {
        return this.f3412d;
    }

    public Map<String, String> m5105d() {
        return this.f3414f;
    }

    public void m5106e() {
        try {
            if (this.f3410b != null) {
                this.f3410b.close();
            }
        } catch (IOException e) {
        }
        this.f3410b = null;
    }
}
