package com.miui.support.internal.hybrid.webkit;

public class JsResult extends com.miui.support.hybrid.JsResult {
    private android.webkit.JsResult f2492a;

    public JsResult(android.webkit.JsResult jsResult) {
        this.f2492a = jsResult;
    }

    public void m4138a() {
        this.f2492a.confirm();
    }

    public void m4139b() {
        this.f2492a.cancel();
    }
}
