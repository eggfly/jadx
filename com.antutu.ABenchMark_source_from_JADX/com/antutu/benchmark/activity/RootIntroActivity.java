package com.antutu.benchmark.activity;

import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.utils.widget.WebBrowserActivity;
import com.xiaomi.pushsdk.BuildConfig;

public class RootIntroActivity extends C1197a {
    private WebView f4396a;
    private View f4397b;

    /* renamed from: com.antutu.benchmark.activity.RootIntroActivity.1 */
    class C12841 implements OnClickListener {
        final /* synthetic */ RootIntroActivity f4392a;

        C12841(RootIntroActivity rootIntroActivity) {
            this.f4392a = rootIntroActivity;
        }

        public void onClick(View view) {
            this.f4392a.finish();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.RootIntroActivity.2 */
    class C12862 extends WebChromeClient {
        final /* synthetic */ RootIntroActivity f4394a;

        /* renamed from: com.antutu.benchmark.activity.RootIntroActivity.2.1 */
        class C12851 extends WebViewClient {
            final /* synthetic */ C12862 f4393a;

            C12851(C12862 c12862) {
                this.f4393a = c12862;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                try {
                    WebBrowserActivity.openURL(this.f4393a.f4394a, str, BuildConfig.FLAVOR);
                } catch (Exception e) {
                }
                webView.stopLoading();
                super.onPageStarted(webView, str, bitmap);
            }
        }

        C12862(RootIntroActivity rootIntroActivity) {
            this.f4394a = rootIntroActivity;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            try {
                WebView webView2 = new WebView(webView.getContext());
                ((WebViewTransport) message.obj).setWebView(webView2);
                webView2.setWebViewClient(new C12851(this));
                message.sendToTarget();
                return true;
            } catch (Exception e) {
                return super.onCreateWindow(webView, z, z2, message);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.RootIntroActivity.3 */
    class C12873 extends WebViewClient {
        final /* synthetic */ RootIntroActivity f4395a;

        C12873(RootIntroActivity rootIntroActivity) {
            this.f4395a = rootIntroActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f4395a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return true;
                }
            } catch (Exception e) {
            }
            try {
                WebBrowserActivity.openURL(this.f4395a, str, BuildConfig.FLAVOR);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    private void m5244a() {
        this.f4397b = findViewById(C1082R.id.menu_back_img);
        this.f4397b.setOnClickListener(new C12841(this));
        ((TextView) findViewById(C1082R.id.title_text)).setText(getString(C1082R.string.root_page_title));
        this.f4396a = (WebView) findViewById(C1082R.id.web_view);
        this.f4396a.getSettings().setJavaScriptEnabled(true);
        this.f4396a.getSettings().setLoadsImagesAutomatically(true);
        this.f4396a.setWebChromeClient(new C12862(this));
        this.f4396a.setWebViewClient(new C12873(this));
        this.f4396a.loadUrl("http://autovote.antutu.net/chart/setting/getroot.html");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.rootintro);
        m5244a();
    }
}
