package com.antutu.benchmark.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;

public class WebTestActivity extends C1197a {
    private WebView f4500a;

    /* renamed from: com.antutu.benchmark.activity.WebTestActivity.1 */
    class C13151 extends WebChromeClient {
        final /* synthetic */ WebTestActivity f4499a;

        C13151(WebTestActivity webTestActivity) {
            this.f4499a = webTestActivity;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            Toast.makeText(this.f4499a, str2, 1).show();
            return false;
        }
    }

    public WebTestActivity() {
        this.f4500a = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_web);
        this.f4500a = (WebView) findViewById(C1082R.id.webView);
        this.f4500a.setBackgroundColor(Color.rgb(0, 0, 0));
        this.f4500a.getSettings().setJavaScriptEnabled(true);
        this.f4500a.getSettings().setUseWideViewPort(true);
        this.f4500a.getSettings().setSupportZoom(false);
        this.f4500a.getSettings().setBuiltInZoomControls(false);
        this.f4500a.setWebChromeClient(new C13151(this));
        this.f4500a.loadUrl("www.antutu.com/html5/");
    }
}
