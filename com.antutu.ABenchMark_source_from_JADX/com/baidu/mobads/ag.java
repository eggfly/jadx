package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import com.baidu.mobads.al.C1910a;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.p102e.C2048a;

class ag implements C1910a {
    final /* synthetic */ Context f6675a;
    final /* synthetic */ al f6676b;
    final /* synthetic */ String f6677c;
    final /* synthetic */ boolean f6678d;
    final /* synthetic */ SplashAd f6679e;

    ag(SplashAd splashAd, Context context, al alVar, String str, boolean z) {
        this.f6679e = splashAd;
        this.f6675a = context;
        this.f6676b = alVar;
        this.f6677c = str;
        this.f6678d = z;
    }

    @SuppressLint({"MissingSuperCall"})
    public void m7208a() {
        if (this.f6679e.f6635a != null) {
            this.f6679e.f6635a.m7593j();
        }
    }

    public void m7209a(int i) {
        if (this.f6679e.f6635a != null) {
            this.f6679e.f6635a.m7564a(i);
        }
    }

    public void m7210a(int i, int i2) {
        if (this.f6679e.f6635a == null) {
            float screenDensity = C1991m.m7449a().m7464m().getScreenDensity(this.f6675a);
            if (((float) i) < 200.0f * screenDensity || ((float) i2) < screenDensity * 150.0f) {
                C1991m.m7449a().m7457f().m7397e(C1991m.m7449a().m7468q().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "\u5f00\u5c4f\u663e\u793a\u533a\u57df\u592a\u5c0f,\u5bbd\u5ea6\u81f3\u5c11200dp,\u9ad8\u5ea6\u81f3\u5c11150dp"));
                this.f6679e.f6637c.onAdDismissed();
                return;
            }
            this.f6679e.f6635a = new C2048a(this.f6675a, this.f6676b, this.f6677c, this.f6678d, i, i2);
            this.f6679e.f6635a.addEventListener("AdUserClick", this.f6679e.f6638d);
            this.f6679e.f6635a.addEventListener(IXAdEvent.AD_LOADED, this.f6679e.f6638d);
            this.f6679e.f6635a.addEventListener(IXAdEvent.AD_STARTED, this.f6679e.f6638d);
            this.f6679e.f6635a.addEventListener(IXAdEvent.AD_STOPPED, this.f6679e.f6638d);
            this.f6679e.f6635a.addEventListener(IXAdEvent.AD_ERROR, this.f6679e.f6638d);
            this.f6679e.f6635a.request();
        }
    }

    public void m7211a(boolean z) {
        if (this.f6679e.f6635a != null) {
            this.f6679e.f6635a.m7573a(z);
        }
    }

    public boolean m7212a(int i, KeyEvent keyEvent) {
        return false;
    }

    public void m7213b() {
        if (this.f6679e.f6635a != null) {
            this.f6679e.f6635a.m7592i();
        }
    }
}
