package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.ExposureListModel;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.ShareUtil;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;

public class ExposureDetailActivity extends C1197a {
    private WebView f4198a;
    private ProgressBar f4199b;
    private ExposureListModel f4200c;
    private String f4201d;
    private OnClickListener f4202e;

    /* renamed from: com.antutu.benchmark.activity.ExposureDetailActivity.1 */
    class C12361 extends WebChromeClient {
        final /* synthetic */ ExposureDetailActivity f4195a;

        C12361(ExposureDetailActivity exposureDetailActivity) {
            this.f4195a = exposureDetailActivity;
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i <= 0 || i >= 100) {
                try {
                    this.f4195a.f4199b.setVisibility(8);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.f4195a.f4199b.setVisibility(0);
            this.f4195a.f4199b.setProgress(i);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ExposureDetailActivity.2 */
    class C12372 implements OnClickListener {
        final /* synthetic */ ExposureDetailActivity f4196a;

        C12372(ExposureDetailActivity exposureDetailActivity) {
            this.f4196a = exposureDetailActivity;
        }

        public void onClick(View view) {
            if (this.f4196a.f4200c != null) {
                ShareUtil.showShare(this.f4196a, this.f4196a.f4201d, this.f4196a.f4200c.getModelpic(), this.f4196a.getString(C1082R.string.exposure_share, new Object[]{this.f4196a.f4200c.getModel(), this.f4196a.f4200c.getScore()}), BuildConfig.FLAVOR);
                return;
            }
            ShareUtil.showShare(this.f4196a, this.f4196a.f4201d, null, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ExposureDetailActivity.a */
    private class C1238a {
        final /* synthetic */ ExposureDetailActivity f4197a;

        private C1238a(ExposureDetailActivity exposureDetailActivity) {
            this.f4197a = exposureDetailActivity;
        }

        @JavascriptInterface
        public void callBackPublish() {
            MobclickAgent.onEvent(this.f4197a, MobclickAgentConstants.click_exposure_phone_publish);
        }

        @JavascriptInterface
        public void callBackTongji(String str) {
            Map hashMap = new HashMap();
            hashMap.put(this.f4197a.getString(C1082R.string.biaoti), str);
            MobclickAgent.onEvent(this.f4197a, MobclickAgentConstants.exposure_detail_title, hashMap);
        }
    }

    public ExposureDetailActivity() {
        this.f4202e = new C12372(this);
    }

    private void m5069a() {
        this.f4198a.getSettings().setLoadWithOverviewMode(true);
        this.f4198a.getSettings().setUseWideViewPort(true);
        this.f4198a.getSettings().setSupportZoom(false);
        this.f4198a.getSettings().setBuiltInZoomControls(false);
        this.f4198a.getSettings().setJavaScriptEnabled(true);
        this.f4198a.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        this.f4198a.getSettings().setCacheMode(-1);
        this.f4198a.setScrollBarStyle(0);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_exposure_detail);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(getResources().getString(C1082R.string.detail)).m6413a(this.j).m6416b((int) C1082R.drawable.share).m6418b(true).m6420d(false).m6417b(this.f4202e).m6411a());
        this.f4198a = (WebView) findViewById(C1082R.id.wv_detail_exposure);
        this.f4199b = (ProgressBar) findViewById(C1082R.id.progressWeb);
        m5069a();
        this.f4198a.setWebChromeClient(new C12361(this));
        this.f4198a.addJavascriptInterface(new C1238a(), "WebInterface");
        this.f4200c = (ExposureListModel) getIntent().getSerializableExtra("ITEM");
        if (this.f4200c == null) {
            finish();
        }
        this.f4201d = this.f4200c.getUrl();
        this.f4198a.loadUrl(this.f4201d);
    }
}
