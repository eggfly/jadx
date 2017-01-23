package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.p100d.C2036a;
import com.baidu.mobads.production.p100d.C2044b;
import com.baidu.mobads.production.p101c.C2038b;

public class InterstitialAd {
    public static final String TAG;
    IOAdEventListener f6630a;
    private AdSize f6631b;
    private C2036a f6632c;
    private final IXAdLogger f6633d;
    private InterstitialAdListener f6634e;

    static {
        TAG = InterstitialAd.class.getSimpleName();
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.f6633d = C1991m.m7449a().m7457f();
        this.f6634e = new C2072v(this);
        this.f6630a = new C2079w(this);
        RelativeLayout alVar = new al(context);
        alVar.m7214a(new C2081y(this));
        this.f6631b = adSize;
        if (m7186a()) {
            this.f6632c = new C2044b(context, alVar, Boolean.valueOf(true), str);
        } else if (m7188b()) {
            this.f6632c = new C2038b(context, alVar, Boolean.valueOf(true), adSize, str);
        }
        this.f6632c.addEventListener(IXAdEvent.AD_LOADED, this.f6630a);
        this.f6632c.addEventListener(IXAdEvent.AD_ERROR, this.f6630a);
        this.f6632c.addEventListener(IXAdEvent.AD_STOPPED, this.f6630a);
        this.f6632c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f6630a);
        this.f6632c.addEventListener(IXAdEvent.AD_STARTED, this.f6630a);
        this.f6632c.addEventListener("AdUserClick", this.f6630a);
        this.f6632c.request();
    }

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    private boolean m7186a() {
        return this.f6631b.getValue() <= AdSize.InterstitialOther.getValue() && this.f6631b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean m7188b() {
        return this.f6631b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.f6631b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        C1991m.m7449a().m7464m().setAppId(str);
    }

    public void destroy() {
        this.f6632c.m7655k();
    }

    public boolean isAdReady() {
        return this.f6632c.m7657q();
    }

    public void loadAd() {
        this.f6632c.m7656l();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.f6632c.m7651a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.f6634e = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.f6632c.m7652a(activity);
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.f6632c.m7653a(activity, relativeLayout);
    }
}
