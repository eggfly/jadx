package com.cmcm.p074a.p075a.p112a;

import android.content.IntentFilter;
import com.cmcm.p074a.p075a.p114c.C2152q;
import com.igexin.sdk.PushConsts;

/* renamed from: com.cmcm.a.a.a.t */
final class C2127t implements Runnable {
    C2127t() {
    }

    public void run() {
        if ((C2126s.f7463e & 6) != 6) {
            IntentFilter intentFilter = new IntentFilter();
            if ((C2126s.f7463e & 2) == 0) {
                intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            }
            if ((C2126s.f7463e & 4) == 0) {
                intentFilter.addAction("com.cmplay.activesdk.cloud_cfg.update");
            }
            C2126s.f7468j = new C2130w();
            C2126s.m8031a(C2126s.f7468j, intentFilter);
        }
        C2152q c2152q = new C2152q();
        c2152q.m8129b();
        C2126s.f7465g = c2152q;
        if (C2133z.f7482a) {
            ad.m7931a("ContextUtils", "WORKING", new Object[0]);
        }
        C2126s.m8042c(1);
    }
}
