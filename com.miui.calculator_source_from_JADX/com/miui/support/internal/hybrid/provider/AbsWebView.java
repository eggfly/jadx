package com.miui.support.internal.hybrid.provider;

import android.content.Context;
import android.view.View;
import com.miui.support.hybrid.HybridSettings;
import com.miui.support.hybrid.HybridView;

public abstract class AbsWebView {
    protected Context f2485a;
    protected HybridView f2486b;

    public AbsWebView(Context context, HybridView hybridView) {
        this.f2485a = context;
        this.f2486b = hybridView;
    }

    public View m4108a() {
        return null;
    }

    public void m4111a(AbsWebViewClient absWebViewClient) {
    }

    public void m4110a(AbsWebChromeClient absWebChromeClient) {
    }

    public void m4113a(String str) {
    }

    public void m4112a(Object obj, String str) {
    }

    public HybridSettings m4114b() {
        return null;
    }

    public void m4115c() {
    }

    public void m4116d() {
    }

    public boolean m4117e() {
        return false;
    }

    public boolean m4118f() {
        return false;
    }

    public void m4119g() {
    }

    public String m4120h() {
        return null;
    }

    public String m4121i() {
        return null;
    }

    public int m4122j() {
        return 0;
    }

    public float m4123k() {
        return 1.0f;
    }

    public Context m4124l() {
        return null;
    }

    public void m4109a(int i) {
    }

    public View m4125m() {
        return null;
    }
}
