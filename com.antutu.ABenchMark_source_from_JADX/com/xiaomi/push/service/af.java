package com.xiaomi.push.service;

import com.qq.p035e.comm.constants.ErrorCode.AdError;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4388c;
import com.xiaomi.stats.C4509f;

class af {
    private static int f15014e;
    private XMPushService f15015a;
    private int f15016b;
    private long f15017c;
    private int f15018d;

    static {
        f15014e = 300000;
    }

    public af(XMPushService xMPushService) {
        this.f15018d = 0;
        this.f15015a = xMPushService;
        this.f15016b = AdError.PLACEMENT_ERROR;
        this.f15017c = 0;
    }

    private int m18129b() {
        if (this.f15018d > 8) {
            return 300000;
        }
        if (this.f15018d > 4) {
            return 60000;
        }
        if (this.f15018d > 1) {
            return 10000;
        }
        if (this.f15017c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f15017c >= 300000) {
            this.f15016b = AdError.PLACEMENT_ERROR;
            return 0;
        } else if (this.f15016b >= f15014e) {
            return this.f15016b;
        } else {
            int i = this.f15016b;
            this.f15016b = (int) (((double) this.f15016b) * 1.5d);
            return i;
        }
    }

    public void m18130a() {
        this.f15017c = System.currentTimeMillis();
        this.f15015a.m18078a(1);
        this.f15018d = 0;
    }

    public void m18131a(boolean z) {
        if (!this.f15015a.m18093a()) {
            C4302b.m17653c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f15015a.m18098b(1)) {
                this.f15018d++;
            }
            this.f15015a.m18078a(1);
            XMPushService xMPushService = this.f15015a;
            XMPushService xMPushService2 = this.f15015a;
            xMPushService2.getClass();
            xMPushService.m18080a(new C4388c(xMPushService2));
        } else if (!this.f15015a.m18098b(1)) {
            int b = m18129b();
            if (!this.f15015a.m18098b(1)) {
                this.f15018d++;
            }
            C4302b.m17649a("schedule reconnect in " + b + "ms");
            XMPushService xMPushService3 = this.f15015a;
            XMPushService xMPushService4 = this.f15015a;
            xMPushService4.getClass();
            xMPushService3.m18081a(new C4388c(xMPushService4), (long) b);
            if (this.f15018d == 2 && C4509f.m18692a().m18700c()) {
                C4439t.m18349b();
            }
            if (this.f15018d == 3) {
                C4439t.m18346a();
            }
        }
    }
}
