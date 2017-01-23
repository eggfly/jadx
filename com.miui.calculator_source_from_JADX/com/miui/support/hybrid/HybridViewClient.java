package com.miui.support.hybrid;

import android.graphics.Bitmap;
import android.net.http.SslError;
import com.miui.support.internal.hybrid.HybridManager;
import com.miui.support.internal.webkit.WebViewClientDelegate;
import java.io.IOException;
import java.util.UUID;

public class HybridViewClient {
    private HybridManager f2061a;
    private WebViewClientDelegate f2062b;

    public HybridViewClient() {
        this.f2062b = new WebViewClientDelegate();
    }

    public void m3532a(HybridManager hybridManager) {
        this.f2061a = hybridManager;
    }

    public void m3530a(HybridView hybridView, String str, Bitmap bitmap) {
        PageContext pageContext = new PageContext();
        pageContext.m3548a(UUID.randomUUID().toString());
        pageContext.m3549b(str);
        this.f2061a.m4041a(pageContext);
        this.f2061a.m4046c();
        hybridView.setWebProvider(str);
        hybridView.setLoadingError(false);
        this.f2062b.m4607a(hybridView.getWebView(), str, bitmap);
    }

    public void m3529a(HybridView hybridView, String str) {
        if (this.f2061a.m4044b().getActionBar() != null) {
            this.f2061a.m4044b().getActionBar().setTitle(hybridView.getTitle());
        }
        this.f2062b.m4610b(hybridView.getWebView(), str);
    }

    public HybridResourceResponse m3533b(HybridView hybridView, String str) {
        if (str != null && str.startsWith("http")) {
            int indexOf = str.indexOf("android_asset/hybrid/");
            if (indexOf >= 0 && "android_asset/hybrid/".length() + indexOf < str.length()) {
                try {
                    return new HybridResourceResponse(null, null, this.f2061a.m4044b().getAssets().open("hybrid/" + str.substring(indexOf + "android_asset/hybrid/".length())));
                } catch (IOException e) {
                    return null;
                }
            }
        }
        return null;
    }

    public boolean m3534c(HybridView hybridView, String str) {
        return this.f2062b.m4609a(hybridView.getWebView(), str);
    }

    public void m3528a(HybridView hybridView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.m3561a();
    }

    public void m3527a(HybridView hybridView, int i, String str, String str2) {
        hybridView.setLoadingError(true);
        hybridView.m3525e();
    }

    public void m3531a(HybridView hybridView, String str, String str2, String str3) {
        this.f2062b.m4608a(hybridView.getWebView(), str, str2, str3);
    }
}
