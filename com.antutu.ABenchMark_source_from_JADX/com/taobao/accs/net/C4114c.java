package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* renamed from: com.taobao.accs.net.c */
class C4114c implements Runnable {
    final /* synthetic */ String f13767a;
    final /* synthetic */ C4112a f13768b;

    C4114c(C4112a c4112a, String str) {
        this.f13768b = c4112a;
        this.f13767a = str;
    }

    public void run() {
        Message b = this.f13768b.f13759c.m16756b(this.f13767a);
        if (b != null) {
            this.f13768b.f13759c.m16750a(b, -9);
            this.f13768b.m16811a(this.f13767a, "receive data time out");
            ALog.m16903e(this.f13768b.m16820e(), this.f13768b.f13757a + "receive data time out! ", new Object[0]);
        }
    }
}
