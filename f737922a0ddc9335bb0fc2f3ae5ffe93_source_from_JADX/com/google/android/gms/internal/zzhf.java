package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@eh
public class zzhf implements ds {
    private final Context DW;
    final Set<WebView> j6;

    class 1 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ zzhf FH;
        final /* synthetic */ String j6;

        class 1 extends WebViewClient {
            final /* synthetic */ 1 DW;
            final /* synthetic */ WebView j6;

            1(1 1, WebView webView) {
                this.DW = 1;
                this.j6 = webView;
            }

            public void onPageFinished(WebView webView, String str) {
                b.j6("Loading assets have finished");
                this.DW.FH.j6.remove(this.j6);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                b.Hw("Loading assets have failed.");
                this.DW.FH.j6.remove(this.j6);
            }
        }

        1(zzhf com_google_android_gms_internal_zzhf, String str, String str2) {
            this.FH = com_google_android_gms_internal_zzhf;
            this.j6 = str;
            this.DW = str2;
        }

        public void run() {
            WebView j6 = this.FH.j6();
            j6.setWebViewClient(new 1(this, j6));
            this.FH.j6.add(j6);
            j6.loadDataWithBaseURL(this.j6, this.DW, "text/html", "UTF-8", null);
            b.j6("Fetching assets finished.");
        }
    }

    public zzhf(Context context) {
        this.j6 = Collections.synchronizedSet(new HashSet());
        this.DW = context;
    }

    public WebView j6() {
        WebView webView = new WebView(this.DW);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }

    public void j6(String str, String str2, String str3) {
        b.j6("Fetching assets for the given html");
        et.j6.post(new 1(this, str2, str3));
    }
}
