package com.baidu.mobads.p093h;

import android.os.Build;
import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.h.l */
class C1966l implements Runnable {
    final /* synthetic */ C1965k f6848a;

    C1966l(C1965k c1965k) {
        this.f6848a = c1965k;
    }

    public void run() {
        try {
            IXAdURIUitls i = C1991m.m7449a().m7460i();
            double d = this.f6848a.f6846a ? C1960g.f6832b.f6800a : 0.0d;
            IOAdEventListener c1967m;
            HashMap hashMap;
            C2024d c2024d;
            if (this.f6848a.f6846a) {
                c1967m = new C1967m(this, d);
                hashMap = new HashMap();
                hashMap.put(IXAdRequestInfo.f6909V, BuildConfig.FLAVOR + d);
                hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
                hashMap.put(IXAdRequestInfo.PHONE_TYPE, C1991m.m7449a().m7464m().getTextEncoder(Build.MODEL));
                hashMap.put(IXAdRequestInfo.BDR, C1991m.m7449a().m7464m().getTextEncoder(VERSION.SDK));
                c2024d = new C2024d(i.addParameters(C1960g.f6835h, hashMap), BuildConfig.FLAVOR);
                c2024d.f7057e = 1;
                this.f6848a.f6847b.f6839i = new C2021a();
                this.f6848a.f6847b.f6839i.addEventListener("URLLoader.Load.Complete", c1967m);
                this.f6848a.f6847b.f6839i.addEventListener("URLLoader.Load.Error", c1967m);
                this.f6848a.f6847b.f6839i.m7545a(c2024d);
            } else {
                c1967m = new C1967m(this, d);
                hashMap = new HashMap();
                hashMap.put(IXAdRequestInfo.f6909V, BuildConfig.FLAVOR + d);
                hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
                hashMap.put(IXAdRequestInfo.PHONE_TYPE, C1991m.m7449a().m7464m().getTextEncoder(Build.MODEL));
                hashMap.put(IXAdRequestInfo.BDR, C1991m.m7449a().m7464m().getTextEncoder(VERSION.SDK));
                c2024d = new C2024d(i.addParameters(C1960g.f6835h, hashMap), BuildConfig.FLAVOR);
                c2024d.f7057e = 1;
                this.f6848a.f6847b.f6839i = new C2021a();
                this.f6848a.f6847b.f6839i.addEventListener("URLLoader.Load.Complete", c1967m);
                this.f6848a.f6847b.f6839i.addEventListener("URLLoader.Load.Error", c1967m);
                this.f6848a.f6847b.f6839i.m7545a(c2024d);
            }
        } catch (Exception e) {
        }
    }
}
