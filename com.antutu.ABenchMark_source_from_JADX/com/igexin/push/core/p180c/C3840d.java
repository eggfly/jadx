package com.igexin.push.core.p180c;

import com.igexin.push.core.p176a.C3777e;
import java.util.TimerTask;

/* renamed from: com.igexin.push.core.c.d */
class C3840d extends TimerTask {
    final /* synthetic */ C3839c f12887a;

    C3840d(C3839c c3839c) {
        this.f12887a = c3839c;
    }

    public void run() {
        C3777e.m15491a().m15520a(this.f12887a.f12884g, this.f12887a.f12885h, this.f12887a.f12886i);
        this.f12887a.f12885h.m15950a(this.f12887a.f12885h.m15949a() + 1);
    }
}
