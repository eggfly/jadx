package com.miui.support.hybrid;

import java.io.InputStream;

public class HybridResourceResponse {
    private String f2043a;
    private String f2044b;
    private InputStream f2045c;

    public HybridResourceResponse(String str, String str2, InputStream inputStream) {
        this.f2043a = str;
        this.f2044b = str2;
        this.f2045c = inputStream;
    }

    public String m3512a() {
        return this.f2043a;
    }

    public String m3513b() {
        return this.f2044b;
    }

    public InputStream m3514c() {
        return this.f2045c;
    }
}
