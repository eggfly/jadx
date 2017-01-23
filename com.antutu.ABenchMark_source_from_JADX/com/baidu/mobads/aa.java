package com.baidu.mobads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class aa extends WebViewClient {
    private void m7199a(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Exception e) {
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m7199a(webView, str);
        return true;
    }
}
