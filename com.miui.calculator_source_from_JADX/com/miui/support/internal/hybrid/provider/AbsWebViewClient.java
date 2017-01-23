package com.miui.support.internal.hybrid.provider;

import android.graphics.Bitmap;
import android.net.http.SslError;
import com.miui.support.hybrid.HybridResourceResponse;
import com.miui.support.hybrid.HybridView;
import com.miui.support.hybrid.HybridViewClient;
import com.miui.support.hybrid.SslErrorHandler;

public abstract class AbsWebViewClient {
    protected HybridViewClient f2487a;
    protected HybridView f2488b;

    public AbsWebViewClient(HybridViewClient hybridViewClient, HybridView hybridView) {
        this.f2487a = hybridViewClient;
        this.f2488b = hybridView;
    }

    public Object m4126a() {
        return null;
    }

    public void m4130a(HybridView hybridView, String str, Bitmap bitmap) {
    }

    public void m4129a(HybridView hybridView, String str) {
    }

    public HybridResourceResponse m4132b(HybridView hybridView, String str) {
        return null;
    }

    public boolean m4133c(HybridView hybridView, String str) {
        return false;
    }

    public void m4128a(HybridView hybridView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public void m4127a(HybridView hybridView, int i, String str, String str2) {
    }

    public void m4131a(HybridView hybridView, String str, String str2, String str3) {
    }
}
