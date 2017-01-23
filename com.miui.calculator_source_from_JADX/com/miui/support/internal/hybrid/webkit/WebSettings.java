package com.miui.support.internal.hybrid.webkit;

import com.miui.support.hybrid.HybridSettings;

public class WebSettings extends HybridSettings {
    private android.webkit.WebSettings f2496a;

    public WebSettings(android.webkit.WebSettings webSettings) {
        this.f2496a = webSettings;
    }

    public void m4155a(boolean z) {
        this.f2496a.setJavaScriptEnabled(z);
    }

    public void m4154a(String str) {
        this.f2496a.setUserAgentString(str);
    }

    public String m4153a() {
        return this.f2496a.getUserAgentString();
    }
}
