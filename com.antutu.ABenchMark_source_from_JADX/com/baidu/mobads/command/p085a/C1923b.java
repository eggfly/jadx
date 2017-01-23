package com.baidu.mobads.command.p085a;

import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.command.p085a.C1922a.C1920a;
import com.baidu.mobads.p084c.C1918a;
import java.util.TimerTask;

/* renamed from: com.baidu.mobads.command.a.b */
class C1923b extends TimerTask {
    final /* synthetic */ C1922a f6726a;
    final /* synthetic */ C1924a f6727b;
    final /* synthetic */ C1920a f6728c;

    C1923b(C1920a c1920a, C1922a c1922a, C1924a c1924a) {
        this.f6728c = c1920a;
        this.f6726a = c1922a;
        this.f6727b = c1924a;
    }

    public void run() {
        try {
            if (System.currentTimeMillis() > this.f6728c.f6718c) {
                this.f6728c.f6717b.cancel();
            } else if (this.f6728c.m7237a(this.f6728c.f6720e, this.f6728c.f6719d)) {
                C1918a.m7217a().m7229c(this.f6728c.f6720e, this.f6727b);
                this.f6728c.f6717b.cancel();
            }
        } catch (Throwable e) {
            this.f6728c.f6716a.e.m7395d(e);
        }
    }
}
