package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.ResizeLayout.OnResizeListener;
import cn.sharesdk.framework.utils.C0979d;
import com.igexin.sdk.PushBuildConfig;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import com.umeng.message.proguard.C4233j;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.framework.authorize.e */
public class C0942e extends C0936a implements Callback, OnResizeListener {
    protected AuthorizeListener f3201b;
    private AuthorizeAdapter f3202c;
    private RegisterView f3203d;
    private WebView f3204e;

    /* renamed from: cn.sharesdk.framework.authorize.e.1 */
    class C09391 implements OnClickListener {
        final /* synthetic */ C0942e f3198a;

        /* renamed from: cn.sharesdk.framework.authorize.e.1.1 */
        class C09381 extends Thread {
            final /* synthetic */ C09391 f3197a;

            C09381(C09391 c09391) {
                this.f3197a = c09391;
            }

            public void run() {
                try {
                    new Instrumentation().sendKeyDownUpSync(4);
                } catch (Throwable th) {
                    C0979d.m4390a().m4388w(th);
                    AuthorizeListener authorizeListener = this.f3197a.f3198a.a.getAuthorizeListener();
                    if (authorizeListener != null) {
                        authorizeListener.onCancel();
                    }
                    this.f3197a.f3198a.finish();
                }
            }
        }

        C09391(C0942e c0942e) {
            this.f3198a = c0942e;
        }

        public void onClick(View view) {
            new C09381(this).start();
        }
    }

    /* renamed from: cn.sharesdk.framework.authorize.e.2 */
    class C09402 extends Thread {
        final /* synthetic */ C0942e f3199a;

        C09402(C0942e c0942e) {
            this.f3199a = c0942e;
        }

        public void run() {
            try {
                Message message = new Message();
                message.what = 2;
                if (PushBuildConfig.sdk_conf_debug_level.equals(DeviceHelper.getInstance(this.f3199a.activity).getDetailNetworkTypeForStatic())) {
                    message.arg1 = 1;
                    UIHandler.sendMessage(message, this.f3199a);
                    return;
                }
                if (ShareSDK.isRemoveCookieOnAuthorize()) {
                    CookieSyncManager.createInstance(this.f3199a.activity);
                    CookieManager.getInstance().removeAllCookie();
                }
                message.obj = this.f3199a.a.getAuthorizeUrl();
                UIHandler.sendMessage(message, this.f3199a);
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.authorize.e.a */
    private static class C0941a implements Interpolator {
        private float[] f3200a;

        private C0941a() {
            this.f3200a = new float[]{0.0f, 0.02692683f, 0.053847015f, 0.080753915f, 0.10764089f, 0.13450131f, 0.16132854f, 0.18811597f, 0.21485697f, 0.24154496f, 0.26817337f, 0.2947356f, 0.3212251f, 0.34763536f, 0.37395984f, 0.40019205f, 0.42632553f, 0.4523538f, 0.47827047f, 0.50406915f, 0.52974343f, 0.555287f, 0.5806936f, 0.60595685f, 0.6310707f, 0.65602875f, 0.68082494f, 0.70545316f, 0.72990733f, 0.75418144f, 0.7782694f, 0.8021654f, 0.8258634f, 0.8493577f, 0.8726424f, 0.89571184f, 0.9185602f, 0.94118196f, 0.9635715f, 0.9857233f, 1.0076319f, 1.0292919f, 1.0506978f, 1.0718446f, 1.0927268f, 1.1133395f, 1.1336775f, 1.1537358f, 1.1735094f, 1.1929934f, 1.1893399f, 1.1728106f, 1.1565471f, 1.1405534f, 1.1248333f, 1.1093911f, 1.0942302f, 1.0793544f, 1.0647675f, 1.050473f, 1.0364745f, 1.0227754f, 1.0093791f, 0.99628896f, 0.9835081f, 0.9710398f, 0.958887f, 0.9470527f, 0.93553996f, 0.9243516f, 0.91349024f, 0.90295863f, 0.90482706f, 0.9114033f, 0.91775465f, 0.9238795f, 0.9297765f, 0.93544406f, 0.9408808f, 0.94608533f, 0.95105654f, 0.955793f, 0.9602937f, 0.9645574f, 0.96858317f, 0.9723699f, 0.97591674f, 0.97922283f, 0.9822872f, 0.9851093f, 0.98768836f, 0.9900237f, 0.9921147f, 0.993961f, 0.99556196f, 0.9969173f, 0.9980267f, 0.99888986f, 0.99950653f, 0.9998766f, 1.0f};
        }

        public float getInterpolation(float f) {
            int i = 100;
            int i2 = (int) (100.0f * f);
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 <= 100) {
                i = i2;
            }
            return this.f3200a[i];
        }
    }

    private AuthorizeAdapter m4122c() {
        try {
            ActivityInfo activityInfo = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), SpdyProtocol.SLIGHTSSLV2);
            if (activityInfo.metaData == null || activityInfo.metaData.isEmpty()) {
                return null;
            }
            String string = activityInfo.metaData.getString("AuthorizeAdapter");
            if (string == null || string.length() <= 0) {
                string = activityInfo.metaData.getString("Adapter");
                if (string == null || string.length() <= 0) {
                    return null;
                }
            }
            Object newInstance = Class.forName(string).newInstance();
            return !(newInstance instanceof AuthorizeAdapter) ? null : (AuthorizeAdapter) newInstance;
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return null;
        }
    }

    public void OnResize(int i, int i2, int i3, int i4) {
        if (this.f3202c != null) {
            this.f3202c.onResize(i, i2, i3, i4);
        }
    }

    public void m4123a(AuthorizeListener authorizeListener) {
        this.f3201b = authorizeListener;
    }

    protected RegisterView m4124b() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m4112a().setOnClickListener(new C09391(this));
        this.f3204e = registerView.m4114b();
        WebSettings settings = this.f3204e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        this.f3204e.setVerticalScrollBarEnabled(false);
        this.f3204e.setHorizontalScrollBarEnabled(false);
        this.f3204e.setWebViewClient(this.a.getAuthorizeWebviewClient(this));
        new C09402(this).start();
        return registerView;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                AuthorizeListener authorizeListener;
                if (message.arg1 != 1) {
                    String str = (String) message.obj;
                    if (!TextUtils.isEmpty(str)) {
                        this.f3204e.loadUrl(str);
                        break;
                    }
                    finish();
                    authorizeListener = this.a.getAuthorizeListener();
                    if (authorizeListener != null) {
                        authorizeListener.onError(new Throwable("Authorize URL is empty (platform: " + this.a.getPlatform().getName() + C4233j.f14397t));
                        break;
                    }
                }
                authorizeListener = this.a.getAuthorizeListener();
                if (authorizeListener != null) {
                    authorizeListener.onError(new Throwable("Network error (platform: " + this.a.getPlatform().getName() + C4233j.f14397t));
                    break;
                }
                break;
        }
        return false;
    }

    public void onCreate() {
        if (this.f3203d == null) {
            this.f3203d = m4124b();
            this.f3203d.m4108a(this);
            this.f3203d.m4113a(this.f3202c.isNotitle());
            this.f3202c.setBodyView(this.f3203d.m4116d());
            this.f3202c.setWebView(this.f3203d.m4114b());
            TitleLayout c = this.f3203d.m4115c();
            this.f3202c.setTitleView(c);
            String name = this.a.getPlatform().getName();
            this.f3202c.setPlatformName(this.a.getPlatform().getName());
            try {
                c.getTvTitle().setText(C4021R.getStringRes(getContext(), "ssdk_" + name.toLowerCase()));
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
        this.f3202c.onCreate();
        if (!(this.f3202c == null || this.f3202c.isPopUpAnimationDisable())) {
            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(550);
            scaleAnimation.setInterpolator(new C0941a());
            this.f3203d.setAnimation(scaleAnimation);
        }
        this.activity.setContentView(this.f3203d);
    }

    public void onDestroy() {
        if (this.f3202c != null) {
            this.f3202c.onDestroy();
        }
    }

    public boolean onFinish() {
        if (this.f3202c != null) {
            return this.f3202c.onFinish();
        }
        if (this.f3204e != null) {
            this.f3204e.destroy();
            this.f3204e.removeAllViews();
        }
        if (this.activity != null) {
            ((ViewGroup) this.activity.getWindow().getDecorView()).removeAllViews();
        }
        return super.onFinish();
    }

    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (this.f3202c != null) {
            z = this.f3202c.onKeyEvent(i, keyEvent);
        }
        if (!z && i == 4 && keyEvent.getAction() == 0) {
            AuthorizeListener authorizeListener = this.a.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onCancel();
            }
        }
        return z ? true : super.onKeyEvent(i, keyEvent);
    }

    public void onPause() {
        if (this.f3202c != null) {
            this.f3202c.onPause();
        }
    }

    public void onRestart() {
        if (this.f3202c != null) {
            this.f3202c.onRestart();
        }
    }

    public void onResume() {
        if (this.f3202c != null) {
            this.f3202c.onResume();
        }
    }

    public void onStart() {
        if (this.f3202c != null) {
            this.f3202c.onStart();
        }
    }

    public void onStop() {
        if (this.f3202c != null) {
            this.f3202c.onStop();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f3202c == null) {
            this.f3202c = m4122c();
            if (this.f3202c == null) {
                this.f3202c = new AuthorizeAdapter();
            }
        }
        this.f3202c.setActivity(activity);
    }
}
