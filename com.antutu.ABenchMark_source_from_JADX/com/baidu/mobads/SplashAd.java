package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.p102e.C2048a;

public class SplashAd {
    private C2048a f6635a;
    private volatile String f6636b;
    private SplashAdListener f6637c;
    private IOAdEventListener f6638d;

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z) {
        this.f6636b = "init";
        this.f6637c = new ad(this);
        this.f6638d = new ae(this);
        if (splashAdListener != null) {
            try {
                this.f6637c = splashAdListener;
            } catch (Throwable e) {
                C1991m.m7449a().m7457f().m7395d(e);
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.f6637c.onAdFailed("\u8bf7\u60a8\u8f93\u5165\u6b63\u786e\u7684\u5e7f\u544a\u4f4dID");
            return;
        }
        View alVar = new al(context);
        alVar.m7214a(new ag(this, context, alVar, str, z));
        alVar.setLayoutParams(new LayoutParams(-1, -1));
        viewGroup.addView(alVar);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        C1991m.m7449a().m7464m().setAppId(str);
    }
}
