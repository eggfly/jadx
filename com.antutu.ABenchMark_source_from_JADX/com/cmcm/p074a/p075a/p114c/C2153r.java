package com.cmcm.p074a.p075a.p114c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.cmcm.a.a.c.r */
class C2153r extends BroadcastReceiver {
    final /* synthetic */ C2152q f7511a;

    C2153r(C2152q c2152q) {
        this.f7511a = c2152q;
    }

    public void onReceive(Context context, Intent intent) {
        if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
            try {
                String action = intent.getAction();
                String substring = intent.getDataString().substring(8);
                if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                    if (!this.f7511a.f7509b.contains(substring)) {
                        this.f7511a.f7509b.add(substring);
                        this.f7511a.m8124a(this.f7511a.f7509b);
                        C2148m c2148m = (C2148m) this.f7511a.m8121a("inst_app");
                        if (c2148m != null && c2148m.m8073e()) {
                            c2148m.m8108b(substring);
                        }
                    }
                } else if (this.f7511a.f7509b.contains(substring)) {
                    this.f7511a.f7509b.remove(substring);
                    this.f7511a.m8124a(this.f7511a.f7509b);
                    C2158w c2158w = (C2158w) this.f7511a.m8121a("uninst_app");
                    if (c2158w != null && c2158w.m8073e()) {
                        c2158w.m8142b(substring);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
