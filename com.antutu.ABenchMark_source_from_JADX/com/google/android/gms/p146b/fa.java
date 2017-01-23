package com.google.android.gms.p146b;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.umeng.message.util.HttpRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@gb
/* renamed from: com.google.android.gms.b.fa */
public class fa implements ex {
    final Set<WebView> f10901a;
    private final Context f10902b;

    /* renamed from: com.google.android.gms.b.fa.1 */
    class C31921 implements Runnable {
        final /* synthetic */ String f10898a;
        final /* synthetic */ String f10899b;
        final /* synthetic */ fa f10900c;

        /* renamed from: com.google.android.gms.b.fa.1.1 */
        class C31911 extends WebViewClient {
            final /* synthetic */ WebView f10896a;
            final /* synthetic */ C31921 f10897b;

            C31911(C31921 c31921, WebView webView) {
                this.f10897b = c31921;
                this.f10896a = webView;
            }

            public void onPageFinished(WebView webView, String str) {
                C2972b.m11576a("Loading assets have finished");
                this.f10897b.f10900c.f10901a.remove(this.f10896a);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                C2972b.m11583d("Loading assets have failed.");
                this.f10897b.f10900c.f10901a.remove(this.f10896a);
            }
        }

        C31921(fa faVar, String str, String str2) {
            this.f10900c = faVar;
            this.f10898a = str;
            this.f10899b = str2;
        }

        public void run() {
            WebView a = this.f10900c.m12679a();
            a.setWebViewClient(new C31911(this, a));
            this.f10900c.f10901a.add(a);
            a.loadDataWithBaseURL(this.f10898a, this.f10899b, "text/html", HttpRequest.f14548a, null);
            C2972b.m11576a("Fetching assets finished.");
        }
    }

    public fa(Context context) {
        this.f10901a = Collections.synchronizedSet(new HashSet());
        this.f10902b = context;
    }

    public WebView m12679a() {
        WebView webView = new WebView(this.f10902b);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }

    public void m12680a(String str, String str2, String str3) {
        C2972b.m11576a("Fetching assets for the given html");
        hj.f11297a.post(new C31921(this, str2, str3));
    }
}
