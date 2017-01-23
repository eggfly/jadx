package com.miui.support.internal.hybrid.webkit;

public class SslErrorHandler extends com.miui.support.hybrid.SslErrorHandler {
    private android.webkit.SslErrorHandler f2493a;

    public SslErrorHandler(android.webkit.SslErrorHandler sslErrorHandler) {
        this.f2493a = sslErrorHandler;
    }

    public void m4140a() {
        this.f2493a.cancel();
    }
}
