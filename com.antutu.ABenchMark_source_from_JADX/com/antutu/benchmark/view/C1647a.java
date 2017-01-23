package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.WebViewActivity;

/* renamed from: com.antutu.benchmark.view.a */
public class C1647a extends LinearLayout {
    private Context f5898a;
    private WebView f5899b;
    private boolean f5900c;

    /* renamed from: com.antutu.benchmark.view.a.1 */
    class C16421 extends WebViewClient {
        final /* synthetic */ C1647a f5892a;

        C16421(C1647a c1647a) {
            this.f5892a = c1647a;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                WebViewActivity.m5314a(webView.getContext(), str);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public C1647a(Context context) {
        super(context);
        this.f5900c = true;
        m6494a(context, null, 0);
    }

    private void m6494a(Context context, AttributeSet attributeSet, int i) {
        this.f5898a = context;
        View.inflate(context, C1082R.layout.view_banner_ad_58, this);
        this.f5899b = (WebView) findViewById(C1082R.id.web_view);
        this.f5899b.getSettings().setJavaScriptEnabled(true);
        this.f5899b.setWebViewClient(new C16421(this));
    }

    public void m6495a(String str) {
        if (this.f5899b == null || this.f5900c) {
            this.f5899b.loadUrl(str);
            this.f5900c = false;
        }
    }
}
