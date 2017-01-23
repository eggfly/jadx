package com.taobao.accs.internal;

import com.taobao.accs.utl.ALog;

/* renamed from: com.taobao.accs.internal.f */
class C4109f implements Runnable {
    final /* synthetic */ C4103b f13751a;

    C4109f(C4103b c4103b) {
        this.f13751a = c4103b;
    }

    public void run() {
        ALog.m16903e("ElectionServiceImpl", "serverElection time out", new Object[0]);
        this.f13751a.m16779a(null, -9);
    }
}
