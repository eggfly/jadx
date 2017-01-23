package com.antutu.benchmark.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;

public class WebViewActivity extends C1197a {
    private WebView f4503a;
    private String f4504b;

    /* renamed from: com.antutu.benchmark.activity.WebViewActivity.1 */
    class C13161 extends WebViewClient {
        final /* synthetic */ WebViewActivity f4501a;

        C13161(WebViewActivity webViewActivity) {
            this.f4501a = webViewActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.contains("act=notologin") && str.contains("action=web")) {
                this.f4501a.f4504b = this.f4501a.f4503a.getUrl();
            } else {
                webView.loadUrl(str);
            }
            return true;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.WebViewActivity.2 */
    class C13172 extends WebChromeClient {
        final /* synthetic */ WebViewActivity f4502a;

        C13172(WebViewActivity webViewActivity) {
            this.f4502a = webViewActivity;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
    }

    public WebViewActivity() {
        this.f4504b = BuildConfig.FLAVOR;
    }

    private void m5313a() {
        WebSettings settings = this.f4503a.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName(HttpRequest.f14548a);
        this.f4503a.setWebViewClient(new C13161(this));
        this.f4503a.setWebChromeClient(new C13172(this));
    }

    public static void m5314a(Context context, String str) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("INTENT_URL", str);
        context.startActivity(intent);
    }

    private void m5315b() {
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(BuildConfig.FLAVOR).m6413a(this.j).m6418b(false).m6411a());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_web_view);
        m5315b();
        this.f4503a = (WebView) findViewById(C1082R.id.wv_evaluate_detail);
        m5313a();
        this.f4503a.loadUrl(getIntent().getStringExtra("INTENT_URL"));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f4503a.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f4503a.goBack();
        return true;
    }
}
