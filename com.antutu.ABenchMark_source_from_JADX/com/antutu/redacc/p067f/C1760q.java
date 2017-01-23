package com.antutu.redacc.p067f;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import com.umeng.analytics.MobclickAgent.UMAnalyticsConfig;

/* renamed from: com.antutu.redacc.f.q */
public class C1760q {
    private static volatile C1760q f6194a;

    static {
        f6194a = null;
    }

    public static C1760q m6767a() {
        if (f6194a == null) {
            synchronized (C1760q.class) {
                if (f6194a == null) {
                    f6194a = new C1760q();
                }
            }
        }
        return f6194a;
    }

    public void m6768a(Context context) {
        MobclickAgent.startWithConfigure(new UMAnalyticsConfig(context, "56a0440c67e58e66e7000a16", C1762r.m6776e().m6806h(), EScenarioType.E_UM_NORMAL, true));
        MobclickAgent.enableEncrypt(true);
        MobclickAgent.setCheckDevice(false);
        MobclickAgent.setDebugMode(false);
    }
}
