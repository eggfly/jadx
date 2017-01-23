package com.baidu.mobads;

import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.baidu.mobads.AppActivity.C1905b;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.j */
class C1998j extends WebViewClient {
    final /* synthetic */ C1905b f6973a;
    final /* synthetic */ AppActivity f6974b;

    C1998j(AppActivity appActivity, C1905b c1905b) {
        this.f6974b = appActivity;
        this.f6973a = c1905b;
    }

    private void m7478a(String str) {
        if (this.f6974b.f6469p != null) {
            try {
                if (this.f6973a.f6628d) {
                    this.f6974b.f6479z.f7283n = str;
                    if (this.f6974b.f6479z.f7295z == 0) {
                        this.f6974b.f6479z.f7295z = System.currentTimeMillis();
                    }
                    this.f6974b.f6479z.f7284o = this.f6974b.f6470q = this.f6974b.f6470q + 1;
                    if (this.f6974b.curWebview != null) {
                        this.f6974b.f6479z.f7285p = this.f6974b.curWebview.getContentHeight();
                        this.f6974b.f6479z.f7286q = this.f6974b.curWebview.getProgress();
                    }
                    this.f6974b.f6479z.f7290u = System.currentTimeMillis() - this.f6974b.f6471r;
                    this.f6974b.f6479z.f7291v = this.f6974b.f6474u;
                    this.f6974b.f6479z.f7293x = this.f6974b.f6459e;
                    this.f6973a.f6628d = false;
                    return;
                }
                this.f6974b.f6450C.m7402i(AppActivity.f6447o, "App2Activity - not send 37");
            } catch (Exception e) {
                this.f6974b.f6450C.m7393d(AppActivity.f6447o, e.getMessage());
            }
        }
    }

    private void m7479a(String str, int i) {
        if (this.f6974b.f6469p != null) {
            try {
                this.f6974b.f6479z.f7283n = str;
                if (this.f6974b.f6479z.f7275A == 0) {
                    this.f6974b.f6479z.f7275A = System.currentTimeMillis();
                }
                this.f6974b.f6479z.f7284o = this.f6974b.f6470q = this.f6974b.f6470q + 1;
                this.f6974b.f6479z.f7291v = this.f6974b.f6474u;
                this.f6974b.f6479z.f7293x = this.f6974b.f6459e;
                if (this.f6974b.curWebview != null) {
                    this.f6974b.f6479z.f7285p = this.f6974b.curWebview.getContentHeight();
                    this.f6974b.f6479z.f7286q = this.f6974b.curWebview.getProgress();
                }
                this.f6974b.f6479z.f7290u = System.currentTimeMillis() - this.f6974b.f6471r;
                this.f6973a.f6628d = true;
            } catch (Exception e) {
                this.f6974b.f6450C.m7393d(AppActivity.f6447o, e.getMessage());
            }
        }
    }

    public void onLoadResource(WebView webView, String str) {
        try {
            if (!(this.f6973a.f6627c || str.equals(this.f6973a.f6626b) || this.f6973a.f6625a)) {
                this.f6973a.f6627c = true;
                if (this.f6974b.f6461g == -1) {
                    this.f6974b.f6461g = (int) (System.currentTimeMillis() - this.f6974b.f6471r);
                }
                m7479a(this.f6973a.f6626b, 0);
            }
            HitTestResult hitTestResult = webView.getHitTestResult();
            if (hitTestResult != null && hitTestResult.getType() > 0) {
                this.f6974b.m7128a(webView, str, new C2000l(this), null);
            }
        } catch (Exception e) {
            this.f6974b.f6450C.m7393d(AppActivity.f6447o, e.getMessage());
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.f6973a.f6625a && this.f6973a.f6626b.equals(str)) {
            if (this.f6974b.f6461g == -1) {
                this.f6974b.f6461g = (int) (System.currentTimeMillis() - this.f6974b.f6471r);
            }
            if (!this.f6973a.f6627c) {
                this.f6973a.f6627c = true;
                m7479a(this.f6973a.f6626b, 0);
            }
        }
        this.f6973a.f6625a = false;
        this.f6973a.f6626b = BuildConfig.FLAVOR;
        if (this.f6974b.f6453G != null) {
            this.f6974b.f6453G.onPageFinished(webView);
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (!(this.f6974b.curWebview == null || str == null)) {
            this.f6974b.curWebview.f7328a = str;
        }
        this.f6973a.f6626b = str;
        this.f6973a.f6627c = false;
        if (!this.f6973a.f6625a) {
            m7478a(str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Builder builder = new Builder(this.f6974b);
        builder.setMessage("ssl\u8bc1\u4e66\u9a8c\u8bc1\u5931\u8d25\uff0c\u662f\u5426\u7ee7\u7eed\u8bbf\u95ee\u8be5\u7f51\u9875\uff1f");
        builder.setPositiveButton("\u7ee7\u7eed", new C2001m(this, sslErrorHandler));
        builder.setNegativeButton("\u53d6\u6d88", new C2002n(this, sslErrorHandler));
        builder.setOnKeyListener(new C2003o(this, sslErrorHandler));
        builder.create().show();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            try {
                if (!str.equals("about:blank")) {
                    this.f6974b.m7128a(webView, str, null, new C1999k(this, str));
                    HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult == null || hitTestResult.getType() != 0) {
                        return true;
                    }
                    this.f6974b.f6450C.m7393d(AppActivity.f6447o, "AppActivity shouldOverrideUrlLoading and hitType==0");
                    this.f6973a.f6625a = true;
                    return true;
                }
            } catch (Exception e) {
                this.f6974b.f6450C.m7393d(AppActivity.f6447o, e.getMessage());
                return true;
            }
        }
        return false;
    }
}
