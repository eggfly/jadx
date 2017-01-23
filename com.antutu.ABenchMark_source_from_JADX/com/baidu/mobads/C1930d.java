package com.baidu.mobads;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.mobads.AppActivity.C1904a;

/* renamed from: com.baidu.mobads.d */
class C1930d extends WebChromeClient {
    final /* synthetic */ C1904a f6767a;
    final /* synthetic */ AppActivity f6768b;

    C1930d(AppActivity appActivity, C1904a c1904a) {
        this.f6768b = appActivity;
        this.f6767a = c1904a;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.f6767a != null) {
            this.f6767a.m7184a(i);
            if (i > 50) {
                this.f6768b.m7153i();
                this.f6767a.setVisibility(i >= 100 ? 4 : 0);
            }
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f6768b.f6457c != null) {
            this.f6768b.f6457c.m7281a(str);
        }
    }
}
