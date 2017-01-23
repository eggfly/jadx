package com.igexin.push.core.p180c;

import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.p182d.p185c.C3877a;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.igexin.push.core.c.e */
class C3841e extends TimerTask {
    final /* synthetic */ PushTaskBean f12888a;
    final /* synthetic */ C3877a f12889b;
    final /* synthetic */ C3839c f12890c;

    C3841e(C3839c c3839c, PushTaskBean pushTaskBean, C3877a c3877a) {
        this.f12890c = c3839c;
        this.f12888a = pushTaskBean;
        this.f12889b = c3877a;
    }

    public void run() {
        if (C3855g.aj.containsKey(this.f12888a.getTaskId())) {
            ((Timer) C3855g.aj.get(this.f12888a.getTaskId())).cancel();
            C3855g.aj.remove(this.f12888a.getTaskId());
        }
        this.f12890c.m15811a(this.f12888a, this.f12889b);
        this.f12889b.m15952b(this.f12889b.m15953c() + 1);
    }
}
