package com.xiaomi.mistatistic.sdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.mistatistic.sdk.controller.C0565g;
import com.xiaomi.mistatistic.sdk.data.HttpEvent;
import java.util.HashMap;
import java.util.Map;

public class MIWebView extends WebView {

    /* renamed from: com.xiaomi.mistatistic.sdk.MIWebView.a */
    class C0525a extends WebViewClient {
        final /* synthetic */ MIWebView f4647a;
        private WebViewClient f4648b;
        private Map<String, Long> f4649c;

        public C0525a(MIWebView mIWebView, WebViewClient webViewClient) {
            this.f4647a = mIWebView;
            this.f4649c = new HashMap();
            this.f4648b = webViewClient;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.f4648b != null) {
                return this.f4648b.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.f4648b != null) {
                this.f4648b.onPageStarted(webView, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            this.f4649c.put(str, Long.valueOf(System.currentTimeMillis()));
        }

        public void onPageFinished(WebView webView, String str) {
            if (this.f4648b != null) {
                this.f4648b.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
            Long l = (Long) this.f4649c.get(str);
            if (l != null) {
                C0565g.m6398a().m6404a(new HttpEvent(str, System.currentTimeMillis() - l.longValue()));
            }
        }

        public void onLoadResource(WebView webView, String str) {
            if (this.f4648b != null) {
                this.f4648b.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (this.f4648b != null) {
                return this.f4648b.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            if (this.f4648b != null) {
                this.f4648b.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (this.f4648b != null) {
                this.f4648b.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            Long l = (Long) this.f4649c.get(str2);
            if (l != null) {
                C0565g.m6398a().m6404a(new HttpEvent(str2, System.currentTimeMillis() - l.longValue(), (long) i));
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (this.f4648b != null) {
                this.f4648b.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (this.f4648b != null) {
                this.f4648b.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.f4648b != null) {
                this.f4648b.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (this.f4648b != null) {
                this.f4648b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.f4648b != null) {
                return this.f4648b.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.f4648b != null) {
                this.f4648b.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public void onScaleChanged(WebView webView, float f, float f2) {
            if (this.f4648b != null) {
                this.f4648b.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (this.f4648b != null) {
                this.f4648b.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new C0525a(this, webViewClient));
    }
}
