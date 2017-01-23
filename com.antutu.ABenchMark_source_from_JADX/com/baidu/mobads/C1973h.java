package com.baidu.mobads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.h */
class C1973h extends Handler {
    final /* synthetic */ AppActivity f6867a;

    C1973h(AppActivity appActivity, Looper looper) {
        this.f6867a = appActivity;
        super(looper);
    }

    public void handleMessage(Message message) {
        C1991m.m7449a().m7464m();
        IXAdURIUitls i = C1991m.m7449a().m7460i();
        StringBuilder stringBuilder = new StringBuilder("type=" + message.what + "&");
        String str = BuildConfig.FLAVOR;
        if (message.what == AppActivity.f6445F) {
            str = this.f6867a.f6479z.toString();
        }
        try {
            C2024d c2024d = new C2024d(i.addParameters("http://mobads-logs.baidu.com/dz.zb?" + stringBuilder.append(str).toString(), null), BuildConfig.FLAVOR);
            c2024d.f7057e = 1;
            new C2021a().m7545a(c2024d);
        } catch (Exception e) {
            this.f6867a.f6450C.m7393d(AppActivity.f6447o, e.getMessage());
        }
    }
}
