package cn.sharesdk.facebook;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.C0919d;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.C0979d;
import com.igexin.sdk.PushBuildConfig;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.DeviceHelper;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.facebook.e */
public class C0928e extends FakeActivity {
    private String f3156a;
    private PlatformActionListener f3157b;
    private C0915a f3158c;
    private RegisterView f3159d;
    private WebView f3160e;
    private boolean f3161f;
    private boolean f3162g;

    /* renamed from: cn.sharesdk.facebook.e.1 */
    class C09261 implements OnClickListener {
        final /* synthetic */ C0928e f3154a;

        /* renamed from: cn.sharesdk.facebook.e.1.1 */
        class C09251 extends Thread {
            final /* synthetic */ C09261 f3153a;

            C09251(C09261 c09261) {
                this.f3153a = c09261;
            }

            public void run() {
                try {
                    new Instrumentation().sendKeyDownUpSync(4);
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                    this.f3153a.f3154a.finish();
                    this.f3153a.f3154a.f3157b.onCancel(null, 0);
                }
            }
        }

        C09261(C0928e c0928e) {
            this.f3154a = c0928e;
        }

        public void onClick(View view) {
            new C09251(this).start();
        }
    }

    /* renamed from: cn.sharesdk.facebook.e.2 */
    class C09272 extends C0919d {
        final /* synthetic */ C0928e f3155a;

        C09272(C0928e c0928e) {
            this.f3155a = c0928e;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith("fbconnect://success")) {
                this.f3155a.m4065b(str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private C0915a m4064b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), SpdyProtocol.SLIGHTSSLV2).metaData.getString("FBWebShareAdapter");
            if (string == null || string.length() <= 0) {
                return null;
            }
            Object newInstance = Class.forName(string).newInstance();
            return !(newInstance instanceof C0915a) ? null : (C0915a) newInstance;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return null;
        }
    }

    private void m4065b(String str) {
        String str2 = str == null ? BuildConfig.FLAVOR : new String(str);
        Bundle urlToBundle = C4021R.urlToBundle(str);
        if (urlToBundle == null) {
            this.f3161f = true;
            finish();
            this.f3157b.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        CharSequence string = urlToBundle.getString("post_id");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(string)) {
            hashMap.put("post_id", string);
        }
        if (urlToBundle.containsKey("error_code") || urlToBundle.containsKey(C4233j.f14375B)) {
            if (this.f3157b != null) {
                this.f3157b.onError(null, 9, new Throwable(C4021R.encodeUrl(urlToBundle)));
            }
            this.f3161f = true;
            finish();
            return;
        }
        this.f3162g = true;
        finish();
        this.f3157b.onComplete(null, 0, hashMap);
    }

    protected RegisterView m4066a() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m4115c().getChildAt(registerView.m4115c().getChildCount() - 1).setVisibility(8);
        registerView.m4112a().setOnClickListener(new C09261(this));
        this.f3160e = registerView.m4114b();
        WebSettings settings = this.f3160e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.f3160e.setVerticalScrollBarEnabled(false);
        this.f3160e.setHorizontalScrollBarEnabled(false);
        this.f3160e.setWebViewClient(new C09272(this));
        return registerView;
    }

    public void m4067a(PlatformActionListener platformActionListener) {
        this.f3157b = platformActionListener;
    }

    public void m4068a(String str) {
        this.f3156a = str;
    }

    public void onCreate() {
        this.f3159d = m4066a();
        try {
            int stringRes = C4021R.getStringRes(getContext(), "ssdk_share_to_facebook");
            if (stringRes > 0) {
                this.f3159d.m4115c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            this.f3159d.m4115c().setVisibility(8);
        }
        this.f3158c.m4022a(this.f3159d.m4116d());
        this.f3158c.m4021a(this.f3159d.m4114b());
        this.f3158c.m4023a(this.f3159d.m4115c());
        this.f3158c.m4019a();
        this.activity.setContentView(this.f3159d);
        if (PushBuildConfig.sdk_conf_debug_level.equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f3161f = true;
            finish();
            this.f3157b.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        this.f3159d.m4114b().loadUrl(this.f3156a);
    }

    public void onDestroy() {
        if (!(this.f3161f || this.f3162g)) {
            this.f3157b.onCancel(null, 0);
        }
        if (this.f3158c != null) {
            this.f3158c.m4024b();
        }
    }

    public boolean onFinish() {
        return this.f3158c != null ? this.f3158c.m4030h() : super.onFinish();
    }

    public void onPause() {
        if (this.f3158c != null) {
            this.f3158c.m4026d();
        }
    }

    public void onRestart() {
        if (this.f3158c != null) {
            this.f3158c.m4029g();
        }
    }

    public void onResume() {
        if (this.f3158c != null) {
            this.f3158c.m4027e();
        }
    }

    public void onStart() {
        if (this.f3158c != null) {
            this.f3158c.m4025c();
        }
    }

    public void onStop() {
        if (this.f3158c != null) {
            this.f3158c.m4028f();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f3158c == null) {
            this.f3158c = m4064b();
            if (this.f3158c == null) {
                this.f3158c = new C0915a();
            }
        }
        this.f3158c.m4020a(activity);
    }
}
