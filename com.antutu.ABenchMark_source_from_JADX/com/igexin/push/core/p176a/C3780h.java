package com.igexin.push.core.p176a;

import android.content.Intent;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.p169f.p170b.C3732h;

/* renamed from: com.igexin.push.core.a.h */
class C3780h extends C3732h {
    final /* synthetic */ String f12707a;
    final /* synthetic */ String f12708b;
    final /* synthetic */ C3777e f12709c;

    C3780h(C3777e c3777e, long j, String str, String str2) {
        this.f12709c = c3777e;
        this.f12707a = str;
        this.f12708b = str2;
        super(j);
    }

    protected void m15581a() {
        Object obj = null;
        try {
            Intent intent = new Intent();
            intent.setClassName(this.f12707a, "com.igexin.sdk.GActivity");
            intent.setFlags(268435456);
            C3855g.f12969g.startActivity(intent);
            obj = 1;
            C3688a.m15097b(this.l + "|startActivity success pkg = " + this.f12707a + " activityName = " + "com.igexin.sdk.GActivity");
        } catch (Exception e) {
            C3688a.m15097b(this.l + "|startActivity exception pkg = " + this.f12707a + " activityName = " + "com.igexin.sdk.GActivity" + " " + e.toString());
        }
        if (obj == null) {
            this.f12709c.m15499e(this.f12707a, this.f12708b);
        }
    }

    public int m15582b() {
        return 0;
    }
}
