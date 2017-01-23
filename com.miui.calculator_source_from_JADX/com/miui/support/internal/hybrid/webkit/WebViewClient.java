package com.miui.support.internal.hybrid.webkit;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.miui.support.hybrid.HybridResourceResponse;
import com.miui.support.hybrid.HybridView;
import com.miui.support.hybrid.HybridViewClient;
import com.miui.support.internal.hybrid.provider.AbsWebViewClient;

public class WebViewClient extends AbsWebViewClient {

    class InternalWebViewClient extends android.webkit.WebViewClient {
        final /* synthetic */ WebViewClient f2498a;

        InternalWebViewClient(WebViewClient webViewClient) {
            this.f2498a = webViewClient;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f2498a.m4185a(this.f2498a.b, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            this.f2498a.m4184a(this.f2498a.b, str);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            HybridResourceResponse b = this.f2498a.m4187b(this.f2498a.b, str);
            return b == null ? null : new WebResourceResponce(b);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return this.f2498a.m4188c(this.f2498a.b, str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f2498a.m4183a(this.f2498a.b, new SslErrorHandler(sslErrorHandler), sslError);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f2498a.m4182a(this.f2498a.b, i, str, str2);
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            this.f2498a.m4186a(this.f2498a.b, str, str2, str3);
        }
    }

    public WebViewClient(HybridViewClient hybridViewClient, HybridView hybridView) {
        super(hybridViewClient, hybridView);
    }

    public Object m4181a() {
        return new InternalWebViewClient(this);
    }

    public void m4185a(HybridView hybridView, String str, Bitmap bitmap) {
        this.a.m3530a(hybridView, str, bitmap);
    }

    public void m4184a(HybridView hybridView, String str) {
        this.a.m3529a(hybridView, str);
    }

    public HybridResourceResponse m4187b(HybridView hybridView, String str) {
        return this.a.m3533b(hybridView, str);
    }

    public boolean m4188c(HybridView hybridView, String str) {
        return this.a.m3534c(hybridView, str);
    }

    public void m4183a(HybridView hybridView, com.miui.support.hybrid.SslErrorHandler sslErrorHandler, SslError sslError) {
        this.a.m3528a(hybridView, sslErrorHandler, sslError);
    }

    public void m4182a(HybridView hybridView, int i, String str, String str2) {
        this.a.m3527a(hybridView, i, str, str2);
    }

    public void m4186a(HybridView hybridView, String str, String str2, String str3) {
        this.a.m3531a(hybridView, str, str2, str3);
    }
}
