package com.antutu.benchmark.p042e;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.CompareActivity;
import com.antutu.benchmark.activity.DetailScoreActivity;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.activity.TestResultActivity;
import com.antutu.benchmark.model.C1537o;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.Utils;
import com.antutu.utils.widget.WebBrowserActivity;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.e.h */
public class C1468h extends C1338c {
    public static String f5016b;
    WebView f5017c;
    String f5018d;
    private View f5019e;
    private View f5020f;
    private View f5021g;
    private Button f5022h;
    private boolean f5023i;
    private boolean f5024j;
    private boolean f5025k;
    private final String f5026l;
    private final String f5027m;
    private final String f5028n;
    private final String f5029o;
    private String f5030p;
    private String f5031q;
    private C1466a f5032r;

    /* renamed from: com.antutu.benchmark.e.h.1 */
    class C14611 extends Thread {
        final /* synthetic */ C1468h f5008a;

        C14611(C1468h c1468h) {
            this.f5008a = c1468h;
        }

        public void run() {
            super.run();
            try {
                String str = this.f5008a.getContext().getFilesDir().getAbsolutePath() + "/" + "391ranking_data.gz";
                String httpGet = Methods.httpGet("http://cdn.antutu.com/web/v6/ranking_data.data");
                if (httpGet.length() > 10 && httpGet.contains("\"myDevice\"") && httpGet.contains("\"scores\"")) {
                    int indexOf = httpGet.indexOf("\n");
                    if (indexOf > 10 && indexOf < httpGet.length()) {
                        Methods.writeToFile(httpGet.getBytes(), str);
                        this.f5008a.f5030p = httpGet.substring(0, indexOf).trim();
                        this.f5008a.f5031q = httpGet.substring(indexOf + 1, httpGet.length()).trim();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.h.2 */
    class C14622 extends WebChromeClient {
        final /* synthetic */ C1468h f5009a;

        C14622(C1468h c1468h) {
            this.f5009a = c1468h;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            MLog.m6871i("onJsAlert", str2);
            return true;
        }
    }

    /* renamed from: com.antutu.benchmark.e.h.3 */
    class C14633 extends WebViewClient {
        final /* synthetic */ C1468h f5010a;

        C14633(C1468h c1468h) {
            this.f5010a = c1468h;
        }

        public void onPageFinished(WebView webView, String str) {
            try {
                webView.getSettings().setCacheMode(1);
                this.f5010a.f5025k = false;
                this.f5010a.f5032r.sendEmptyMessage(0);
            } catch (Exception e) {
            }
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            webView.getSettings().setCacheMode(1);
            this.f5010a.f5025k = false;
            this.f5010a.m5769e();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (!Utils.isNetworkConnected(webView.getContext())) {
                    return true;
                }
            } catch (Exception e) {
            }
            try {
                WebBrowserActivity.openURL(webView.getContext(), str, BuildConfig.FLAVOR);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.h.4 */
    class C14644 implements OnClickListener {
        final /* synthetic */ C1468h f5011a;

        C14644(C1468h c1468h) {
            this.f5011a = c1468h;
        }

        public void onClick(View view) {
            this.f5011a.f5024j = !Utils.isNetworkConnected(view.getContext());
            this.f5011a.f5020f.setVisibility(8);
            this.f5011a.m5775h();
        }
    }

    /* renamed from: com.antutu.benchmark.e.h.5 */
    class C14655 extends Thread {
        final /* synthetic */ C1468h f5012a;

        C14655(C1468h c1468h) {
            this.f5012a = c1468h;
        }

        public void run() {
            int i = 0;
            super.run();
            do {
                try {
                    if (!this.f5012a.f5025k) {
                        break;
                    }
                    C14655.sleep(500);
                    i++;
                } catch (Exception e) {
                    return;
                }
            } while (i <= 12);
            if (this.f5012a.f5025k) {
                this.f5012a.f5025k = false;
                this.f5012a.f5024j = true;
                this.f5012a.f5032r.sendEmptyMessage(2);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.h.a */
    static class C1466a extends Handler {
        WeakReference<C1468h> f5013a;

        C1466a(C1468h c1468h) {
            this.f5013a = new WeakReference(c1468h);
        }

        public void handleMessage(Message message) {
            try {
                ((C1468h) this.f5013a.get()).m5756a(message.what);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.h.b */
    public class C1467b {
        Context f5014a;
        final /* synthetic */ C1468h f5015b;

        C1467b(C1468h c1468h, Context context) {
            this.f5015b = c1468h;
            this.f5014a = context;
        }

        @JavascriptInterface
        public void callBackCmp(String str) {
            if (C1503b.m5915c().m5972y()) {
                MobclickAgent.onEvent(this.f5015b.a, MobclickAgentConstants.click_compare);
                C1537o c1537o = new C1537o();
                c1537o.m6085a(str);
                CompareActivity.m5014a(c1537o);
                Intent intent = new Intent();
                intent.setClass(this.f5014a, CompareActivity.class);
                this.f5014a.startActivity(intent);
                this.f5015b.a.overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
                return;
            }
            Methods.showToast(this.f5015b.a, (int) C1082R.string.prompt_rank, 0);
            Message message = new Message();
            message.what = 1;
            message.arg1 = 0;
            message.obj = null;
            MainActivity.m5138a(message);
        }

        @JavascriptInterface
        public void callBackMy() {
            if (Utils.isCn(this.f5015b.a)) {
                this.f5015b.m5395a(new Intent(this.f5015b.a, TestResultActivity.class));
            } else {
                this.f5015b.m5395a(new Intent(this.f5015b.a, DetailScoreActivity.class));
            }
        }

        @JavascriptInterface
        public String getJsonDataRaw() {
            return this.f5015b.f5031q;
        }

        @JavascriptInterface
        public String getJsonStr() {
            return this.f5015b.f5030p;
        }
    }

    public C1468h() {
        this.f5019e = null;
        this.f5020f = null;
        this.f5021g = null;
        this.f5022h = null;
        this.f5023i = false;
        this.f5024j = false;
        this.f5025k = false;
        this.f5017c = null;
        this.f5018d = BuildConfig.FLAVOR;
        this.f5026l = "http://autovote.antutu.net/chart/Archive/?gpv=";
        this.f5027m = "file:///android_asset/ranking/index.html";
        this.f5028n = "http://cdn.antutu.com/web/v6/ranking_data.data";
        this.f5029o = "391ranking_data.gz";
        this.f5030p = BuildConfig.FLAVOR;
        this.f5031q = BuildConfig.FLAVOR;
        this.f5032r = new C1466a(this);
    }

    private void m5756a(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                try {
                    this.f5019e.setVisibility(8);
                } catch (Exception e) {
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f5019e.setVisibility(8);
                this.f5020f.setVisibility(0);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f5017c.stopLoading();
                this.f5017c.loadUrl("file:///android_asset/ranking/index.html" + m5772f());
            default:
        }
    }

    private void m5757a(View view) {
        this.f5019e = view.findViewById(C1082R.id.loading);
        this.f5020f = view.findViewById(C1082R.id.no_network);
        this.f5021g = view.findViewById(C1082R.id.main_ranking_layout);
        this.f5022h = (Button) view.findViewById(C1082R.id.reload_btn);
        this.f5017c = (WebView) view.findViewById(C1082R.id.wv_main_ranking_webview);
        this.f5017c.setBackgroundColor(Color.rgb(28, 28, 28));
        this.f5017c.getSettings().setLoadWithOverviewMode(true);
        this.f5017c.getSettings().setUseWideViewPort(true);
        this.f5017c.getSettings().setSupportZoom(false);
        this.f5017c.getSettings().setBuiltInZoomControls(false);
        this.f5017c.getSettings().setJavaScriptEnabled(true);
        this.f5017c.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        if (Methods.isWifi(getContext()) == 1) {
            m5767d();
            this.f5017c.getSettings().setCacheMode(-1);
        } else {
            this.f5017c.getSettings().setCacheMode(1);
        }
        this.f5017c.setScrollBarStyle(0);
        this.f5017c.addJavascriptInterface(new C1467b(this, this.a), "WebInterface");
        this.f5017c.setWebChromeClient(new C14622(this));
        this.f5017c.setWebViewClient(new C14633(this));
        this.f5021g.setVisibility(0);
        this.f5024j = false;
        m5775h();
        this.f5022h.setOnClickListener(new C14644(this));
        this.f5023i = true;
    }

    private void m5766c() {
        try {
            String trim = Methods.convertStreamToString(new FileInputStream(getContext().getFilesDir().getAbsolutePath() + "/" + "391ranking_data.gz")).trim();
            if (trim.length() > 10 && trim.contains("\"myDevice\"") && trim.contains("\"scores\"")) {
                int indexOf = trim.indexOf("\n");
                if (indexOf > 10 && indexOf < trim.length()) {
                    this.f5030p = trim.substring(0, indexOf).trim();
                    this.f5031q = trim.substring(indexOf + 1, trim.length()).trim();
                }
            }
        } catch (Exception e) {
        }
    }

    private void m5767d() {
        new C14611(this).start();
    }

    private void m5769e() {
        this.f5024j = true;
        m5775h();
    }

    private String m5772f() {
        return C1503b.m5915c().m5945f(getContext());
    }

    private void m5775h() {
        if (!this.f5025k) {
            if (this.f5024j) {
                this.f5017c.loadUrl("file:///android_asset/ranking/index.html" + m5772f());
                return;
            }
            this.f5025k = true;
            this.f5017c.loadUrl("http://autovote.antutu.net/chart/Archive/?gpv=" + this.f5018d);
            new C14655(this).start();
        }
    }

    public void m5781a() {
        super.m5394a();
        if (this.f5017c != null && this.f5023i) {
            this.f5023i = false;
            this.f5017c.getSettings().setCacheMode(1);
            m5775h();
        }
    }

    public void m5782a(Object obj) {
        this.f5018d = C1503b.m5915c().m5947g(getContext());
        if (this.f5017c != null) {
            m5775h();
            this.f5023i = true;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f5016b = ABenchmarkApplication.getContext().getResources().getString(C1082R.string.my_device);
        this.f5018d = C1503b.m5915c().m5947g(getContext());
        m5766c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.ranking_layout, viewGroup, false);
        m5757a(inflate);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
    }
}
