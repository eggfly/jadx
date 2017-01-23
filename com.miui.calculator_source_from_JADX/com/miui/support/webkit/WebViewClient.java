package com.miui.support.webkit;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.miui.support.internal.webkit.WebViewClientDelegate;
import com.miui.support.internal.webkit.WebViewWrapper;

public class WebViewClient extends android.webkit.WebViewClient {
    private WebViewClientDelegate f3938a;

    public WebViewClient() {
        this.f3938a = new WebViewClientDelegate();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f3938a.m4609a(new WebViewWrapper(webView), str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f3938a.m4607a(new WebViewWrapper(webView), str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f3938a.m4610b(new WebViewWrapper(webView), str);
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        this.f3938a.m4608a(new WebViewWrapper(webView), str, str2, str3);
    }
}
