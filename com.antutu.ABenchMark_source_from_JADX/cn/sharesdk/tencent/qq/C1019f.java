package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import cn.sharesdk.framework.C0919d;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.C0979d;
import com.baidu.mobads.openad.p079d.C1899b;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.tencent.qq.f */
public class C1019f extends FakeActivity {
    private String f3436a;
    private PlatformActionListener f3437b;
    private String f3438c;
    private QQWebShareAdapter f3439d;
    private RegisterView f3440e;
    private WebView f3441f;
    private boolean f3442g;
    private boolean f3443h;

    /* renamed from: cn.sharesdk.tencent.qq.f.1 */
    class C10171 implements OnClickListener {
        final /* synthetic */ C1019f f3434a;

        /* renamed from: cn.sharesdk.tencent.qq.f.1.1 */
        class C10161 extends Thread {
            final /* synthetic */ C10171 f3433a;

            C10161(C10171 c10171) {
                this.f3433a = c10171;
            }

            public void run() {
                try {
                    new Instrumentation().sendKeyDownUpSync(4);
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                    this.f3433a.f3434a.finish();
                    this.f3433a.f3434a.f3437b.onCancel(null, 0);
                }
            }
        }

        C10171(C1019f c1019f) {
            this.f3434a = c1019f;
        }

        public void onClick(View view) {
            new C10161(this).start();
        }
    }

    /* renamed from: cn.sharesdk.tencent.qq.f.2 */
    class C10182 extends C0919d {
        final /* synthetic */ C1019f f3435a;

        C10182(C1019f c1019f) {
            this.f3435a = c1019f;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (str == null || !str.startsWith("wtloginmqq://")) {
                super.onPageStarted(webView, str, bitmap);
                return;
            }
            int stringRes = C4021R.getStringRes(this.f3435a.activity, "ssdk_use_login_button");
            if (stringRes > 0) {
                Toast.makeText(this.f3435a.activity, stringRes, 0).show();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith(this.f3435a.f3438c)) {
                this.f3435a.m4529c(str);
            } else if (str != null && str.startsWith("http://www.myapp.com/down/")) {
                this.f3435a.f3443h = true;
            } else if (str != null && str.startsWith("wtloginmqq://")) {
                int stringRes = C4021R.getStringRes(this.f3435a.activity, "ssdk_use_login_button");
                if (stringRes <= 0) {
                    return true;
                }
                Toast.makeText(this.f3435a.activity, stringRes, 0).show();
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private QQWebShareAdapter m4526b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), SpdyProtocol.SLIGHTSSLV2).metaData.getString("QQWebShareAdapter");
            if (string == null || string.length() <= 0) {
                return null;
            }
            Object newInstance = Class.forName(string).newInstance();
            return !(newInstance instanceof QQWebShareAdapter) ? null : (QQWebShareAdapter) newInstance;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return null;
        }
    }

    private void m4529c(String str) {
        String str2 = str == null ? BuildConfig.FLAVOR : new String(str);
        Bundle urlToBundle = C4021R.urlToBundle(str);
        if (urlToBundle == null) {
            this.f3442g = true;
            finish();
            this.f3437b.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = urlToBundle.getString(PushConsts.CMD_ACTION);
        if ("share".equals(string) || "shareToQQ".equals(string)) {
            string = urlToBundle.getString("result");
            if ("cancel".equals(string)) {
                finish();
                this.f3437b.onCancel(null, 0);
                return;
            } else if (C1899b.COMPLETE.equals(string)) {
                String string2 = urlToBundle.getString("response");
                if (TextUtils.isEmpty(string2)) {
                    this.f3442g = true;
                    finish();
                    this.f3437b.onError(null, 0, new Throwable("response empty" + str2));
                    return;
                }
                this.f3443h = true;
                finish();
                this.f3437b.onComplete(null, 0, new Hashon().fromJson(string2));
                return;
            } else {
                this.f3442g = true;
                finish();
                this.f3437b.onError(null, 0, new Throwable("operation failed: " + str2));
                return;
            }
        }
        this.f3442g = true;
        finish();
        this.f3437b.onError(null, 0, new Throwable("action error: " + str2));
    }

    protected RegisterView m4533a() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m4115c().getChildAt(registerView.m4115c().getChildCount() - 1).setVisibility(8);
        registerView.m4112a().setOnClickListener(new C10171(this));
        this.f3441f = registerView.m4114b();
        WebSettings settings = this.f3441f.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.f3441f.setVerticalScrollBarEnabled(false);
        this.f3441f.setHorizontalScrollBarEnabled(false);
        this.f3441f.setWebViewClient(new C10182(this));
        return registerView;
    }

    public void m4534a(PlatformActionListener platformActionListener) {
        this.f3437b = platformActionListener;
    }

    public void m4535a(String str) {
        this.f3436a = str;
    }

    public void m4536b(String str) {
        this.f3438c = "tencent" + str;
    }

    public void onCreate() {
        this.f3440e = m4533a();
        try {
            int stringRes = C4021R.getStringRes(getContext(), "ssdk_share_to_qq");
            if (stringRes > 0) {
                this.f3440e.m4115c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            this.f3440e.m4115c().setVisibility(8);
        }
        this.f3439d.setBodyView(this.f3440e.m4116d());
        this.f3439d.setWebView(this.f3440e.m4114b());
        this.f3439d.setTitleView(this.f3440e.m4115c());
        this.f3439d.onCreate();
        this.activity.setContentView(this.f3440e);
        if (PushBuildConfig.sdk_conf_debug_level.equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f3442g = true;
            finish();
            this.f3437b.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        this.f3440e.m4114b().loadUrl(this.f3436a);
    }

    public void onDestroy() {
        if (!(this.f3442g || this.f3443h)) {
            this.f3437b.onCancel(null, 0);
        }
        if (this.f3439d != null) {
            this.f3439d.onDestroy();
        }
    }

    public boolean onFinish() {
        return this.f3439d != null ? this.f3439d.onFinish() : super.onFinish();
    }

    public void onPause() {
        if (this.f3439d != null) {
            this.f3439d.onPause();
        }
    }

    public void onRestart() {
        if (this.f3439d != null) {
            this.f3439d.onRestart();
        }
    }

    public void onResume() {
        if (this.f3439d != null) {
            this.f3439d.onResume();
        }
    }

    public void onStart() {
        if (this.f3439d != null) {
            this.f3439d.onStart();
        }
    }

    public void onStop() {
        if (this.f3439d != null) {
            this.f3439d.onStop();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f3439d == null) {
            this.f3439d = m4526b();
            if (this.f3439d == null) {
                this.f3439d = new QQWebShareAdapter();
            }
        }
        this.f3439d.setActivity(activity);
    }
}
