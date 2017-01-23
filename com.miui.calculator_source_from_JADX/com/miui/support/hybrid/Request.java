package com.miui.support.hybrid;

import android.view.View;

public class Request {
    private String f2066a;
    private String f2067b;
    private Callback f2068c;
    private PageContext f2069d;
    private NativeInterface f2070e;
    private View f2071f;

    public String m3550a() {
        return this.f2066a;
    }

    public void m3555a(String str) {
        this.f2066a = str;
    }

    public String m3556b() {
        return this.f2067b;
    }

    public void m3557b(String str) {
        this.f2067b = str;
    }

    public Callback m3558c() {
        return this.f2068c;
    }

    public void m3552a(Callback callback) {
        this.f2068c = callback;
    }

    public PageContext m3559d() {
        return this.f2069d;
    }

    public void m3554a(PageContext pageContext) {
        this.f2069d = pageContext;
    }

    public NativeInterface m3560e() {
        return this.f2070e;
    }

    public void m3553a(NativeInterface nativeInterface) {
        this.f2070e = nativeInterface;
    }

    public void m3551a(View view) {
        this.f2071f = view;
    }
}
