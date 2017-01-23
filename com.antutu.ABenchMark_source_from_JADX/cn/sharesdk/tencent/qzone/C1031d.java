package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
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
import com.baidu.mobads.openad.p079d.C1899b;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.tencent.qzone.d */
public class C1031d extends FakeActivity {
    private String f3468a;
    private boolean f3469b;
    private PlatformActionListener f3470c;
    private RegisterView f3471d;
    private WebView f3472e;
    private String f3473f;
    private boolean f3474g;
    private boolean f3475h;
    private QZoneWebShareAdapter f3476i;

    /* renamed from: cn.sharesdk.tencent.qzone.d.1 */
    class C10291 implements OnClickListener {
        final /* synthetic */ C1031d f3466a;

        /* renamed from: cn.sharesdk.tencent.qzone.d.1.1 */
        class C10281 extends Thread {
            final /* synthetic */ C10291 f3465a;

            C10281(C10291 c10291) {
                this.f3465a = c10291;
            }

            public void run() {
                try {
                    new Instrumentation().sendKeyDownUpSync(4);
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                    this.f3465a.f3466a.finish();
                    this.f3465a.f3466a.f3470c.onCancel(null, 0);
                }
            }
        }

        C10291(C1031d c1031d) {
            this.f3466a = c1031d;
        }

        public void onClick(View view) {
            new C10281(this).start();
        }
    }

    /* renamed from: cn.sharesdk.tencent.qzone.d.2 */
    class C10302 extends C0919d {
        final /* synthetic */ C1031d f3467a;

        C10302(C1031d c1031d) {
            this.f3467a = c1031d;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith(this.f3467a.f3473f)) {
                this.f3467a.m4583b(str);
            } else if (str != null && str.startsWith("mqzone://")) {
                this.f3467a.m4585c(str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private QZoneWebShareAdapter m4580b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), SpdyProtocol.SLIGHTSSLV2).metaData.getString("QZoneWebShareAdapter");
            if (string == null || string.length() <= 0) {
                return null;
            }
            Object newInstance = Class.forName(string).newInstance();
            return !(newInstance instanceof QZoneWebShareAdapter) ? null : (QZoneWebShareAdapter) newInstance;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return null;
        }
    }

    private void m4583b(String str) {
        String str2 = str == null ? BuildConfig.FLAVOR : new String(str);
        Bundle urlToBundle = C4021R.urlToBundle(str);
        if (urlToBundle == null) {
            this.f3475h = true;
            finish();
            this.f3470c.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = urlToBundle.getString(PushConsts.CMD_ACTION);
        if ("share".equals(string) || "shareToQzone".equals(string)) {
            string = urlToBundle.getString("result");
            if ("cancel".equals(string)) {
                finish();
                this.f3470c.onCancel(null, 0);
                return;
            } else if (C1899b.COMPLETE.equals(string)) {
                String string2 = urlToBundle.getString("response");
                if (TextUtils.isEmpty(string2)) {
                    this.f3475h = true;
                    finish();
                    this.f3470c.onError(null, 0, new Throwable("response empty" + str2));
                    return;
                }
                this.f3474g = true;
                finish();
                this.f3470c.onComplete(null, 0, new Hashon().fromJson(string2));
                return;
            } else {
                this.f3475h = true;
                finish();
                this.f3470c.onError(null, 0, new Throwable("operation failed: " + str2));
                return;
            }
        }
        this.f3475h = true;
        finish();
        this.f3470c.onError(null, 0, new Throwable("action error: " + str2));
    }

    private void m4584c() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f3468a));
            intent.putExtra("pkg_name", this.activity.getPackageName());
            if (VERSION.SDK_INT >= 11) {
                intent.setFlags(268468224);
            }
            this.activity.startActivity(intent);
            FakeActivity.registerExecutor(this.f3473f, this);
            finish();
        } catch (Throwable th) {
            if (this.f3470c != null) {
                this.f3470c.onError(null, 0, th);
            }
        }
    }

    private void m4585c(String str) {
        List queryIntentActivities;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            queryIntentActivities = this.activity.getPackageManager().queryIntentActivities(intent, 1);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            queryIntentActivities = null;
        }
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            startActivity(intent);
        }
    }

    private void m4586d() {
        this.f3471d = m4587a();
        try {
            int stringRes = C4021R.getStringRes(getContext(), "ssdk_share_to_qzone");
            if (stringRes > 0) {
                this.f3471d.m4115c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            this.f3471d.m4115c().setVisibility(8);
        }
        this.f3476i.setBodyView(this.f3471d.m4116d());
        this.f3476i.setWebView(this.f3471d.m4114b());
        this.f3476i.setTitleView(this.f3471d.m4115c());
        this.f3476i.onCreate();
        this.activity.setContentView(this.f3471d);
        if (PushBuildConfig.sdk_conf_debug_level.equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f3475h = true;
            finish();
            this.f3470c.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        this.f3471d.m4114b().loadUrl(this.f3468a);
    }

    protected RegisterView m4587a() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m4115c().getChildAt(registerView.m4115c().getChildCount() - 1).setVisibility(8);
        registerView.m4112a().setOnClickListener(new C10291(this));
        this.f3472e = registerView.m4114b();
        WebSettings settings = this.f3472e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        settings.setSavePassword(false);
        this.f3472e.setVerticalScrollBarEnabled(false);
        this.f3472e.setHorizontalScrollBarEnabled(false);
        this.f3472e.setWebViewClient(new C10302(this));
        return registerView;
    }

    public void m4588a(PlatformActionListener platformActionListener) {
        this.f3470c = platformActionListener;
    }

    public void m4589a(String str) {
        this.f3473f = "tencent" + str;
    }

    public void m4590a(String str, boolean z) {
        this.f3468a = str;
        this.f3469b = z;
    }

    public void onCreate() {
        Intent intent = this.activity.getIntent();
        String scheme = intent.getScheme();
        if (scheme != null && scheme.startsWith(this.f3473f)) {
            finish();
            Bundle urlToBundle = C4021R.urlToBundle(intent.getDataString());
            scheme = String.valueOf(urlToBundle.get("result"));
            String valueOf = String.valueOf(urlToBundle.get(PushConsts.CMD_ACTION));
            if ("shareToQQ".equals(valueOf) || "shareToQzone".equals(valueOf)) {
                if (C1899b.COMPLETE.equals(scheme)) {
                    if (this.f3470c != null) {
                        this.f3470c.onComplete(null, 9, new Hashon().fromJson(String.valueOf(urlToBundle.get("response"))));
                    }
                } else if (C4233j.f14375B.equals(scheme)) {
                    if (this.f3470c != null) {
                        this.f3470c.onError(null, 9, new Throwable(String.valueOf(urlToBundle.get("response"))));
                    }
                } else if (this.f3470c != null) {
                    this.f3470c.onCancel(null, 9);
                }
            }
            intent = new Intent("android.intent.action.VIEW");
            intent.setClass(this.activity, MobUIShell.class);
            intent.setFlags(335544320);
            startActivity(intent);
        } else if (this.f3469b) {
            m4584c();
        } else {
            m4586d();
        }
    }

    public void onDestroy() {
        if (!(this.f3469b || this.f3475h || this.f3474g)) {
            this.f3470c.onCancel(null, 0);
        }
        if (this.f3476i != null) {
            this.f3476i.onDestroy();
        }
    }

    public boolean onFinish() {
        return this.f3476i != null ? this.f3476i.onFinish() : super.onFinish();
    }

    public void onPause() {
        if (this.f3476i != null) {
            this.f3476i.onPause();
        }
    }

    public void onRestart() {
        if (this.f3476i != null) {
            this.f3476i.onRestart();
        }
    }

    public void onResume() {
        if (this.f3476i != null) {
            this.f3476i.onResume();
        }
    }

    public void onStart() {
        if (this.f3476i != null) {
            this.f3476i.onStart();
        }
    }

    public void onStop() {
        if (this.f3476i != null) {
            this.f3476i.onStop();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f3476i == null) {
            this.f3476i = m4580b();
            if (this.f3476i == null) {
                this.f3476i = new QZoneWebShareAdapter();
            }
        }
        this.f3476i.setActivity(activity);
    }
}
