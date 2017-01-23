package com.miui.support.internal.webkit;

import com.miui.support.internal.hybrid.webkit.WebView;

public class WebViewWrapper extends WebView {
    public WebViewWrapper(android.webkit.WebView webView) {
        super(webView.getContext(), null);
        this.c = webView;
    }
}
