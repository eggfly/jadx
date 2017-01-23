package com.antutu.benchmark.p042e;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.utils.Utils;
import com.antutu.utils.widget.WebBrowserActivity;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.e.i */
public class C1470i extends C1338c {
    private WebView f5034b;
    private String f5035c;

    /* renamed from: com.antutu.benchmark.e.i.1 */
    class C14691 extends WebViewClient {
        final /* synthetic */ C1470i f5033a;

        C14691(C1470i c1470i) {
            this.f5033a = c1470i;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (!Utils.isNetworkConnected(webView.getContext())) {
                    return true;
                }
            } catch (Exception e) {
            }
            try {
                WebBrowserActivity.openURLInApp(webView.getContext(), str, BuildConfig.FLAVOR);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    private void m5783c() {
        this.f5034b.setBackgroundColor(Color.rgb(28, 28, 28));
        this.f5034b.getSettings().setLoadWithOverviewMode(true);
        this.f5034b.getSettings().setUseWideViewPort(true);
        this.f5034b.getSettings().setSupportZoom(false);
        this.f5034b.getSettings().setBuiltInZoomControls(false);
        this.f5034b.getSettings().setJavaScriptEnabled(true);
        this.f5034b.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        this.f5034b.getSettings().setCacheMode(-1);
        this.f5034b.setScrollBarStyle(0);
        this.f5034b.setWebViewClient(new C14691(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f5035c = arguments.getString("KEY_URL");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.fragment_ranking_detail, null);
        this.f5034b = (WebView) inflate.findViewById(C1082R.id.wv_main_ranking_webview);
        m5783c();
        this.f5034b.loadUrl(this.f5035c);
        return inflate;
    }
}
