package com.cmcm.p074a.p075a.p112a;

import android.content.Intent;
import java.util.Map;

/* renamed from: com.cmcm.a.a.a.m */
class C2119m implements Runnable {
    final /* synthetic */ Map f7443a;
    final /* synthetic */ C2116j f7444b;

    C2119m(C2116j c2116j, Map map) {
        this.f7444b = c2116j;
        this.f7443a = map;
    }

    public void run() {
        long j;
        if (this.f7443a != null) {
            this.f7444b.f7436e = this.f7443a;
            this.f7444b.f7432a.sendBroadcast(new Intent("com.cmplay.activesdk.cloud_cfg.update"));
            j = 21600000;
        } else {
            j = 7200000;
        }
        this.f7444b.f7440i = false;
        this.f7444b.f7439h.m7951a(new C2120n(this), j);
    }
}
