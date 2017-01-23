package com.miui.support.internal.hybrid.webkit;

public class ValueCallback<T> implements com.miui.support.hybrid.ValueCallback<T> {
    private android.webkit.ValueCallback<T> f2494a;

    public ValueCallback(android.webkit.ValueCallback<T> valueCallback) {
        this.f2494a = valueCallback;
    }

    public void m4141a(T t) {
        this.f2494a.onReceiveValue(t);
    }
}
