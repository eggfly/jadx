package anet.channel.session;

import anet.channel.Session.Status;
import anet.channel.entity.C0667d;
import anet.channel.entity.C0668b;
import anet.channel.entity.EventType;
import anet.channel.request.Request;
import anet.channel.session.C0690c.C0689a;
import anet.channel.util.ErrorConstant;
import anet.channel.util.StringUtils;

/* renamed from: anet.channel.session.f */
class C0693f implements Runnable {
    final /* synthetic */ Request f2275a;
    final /* synthetic */ C0692e f2276b;

    C0693f(C0692e c0692e, Request request) {
        this.f2276b = c0692e;
        this.f2275a = request;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        C0689a a = C0690c.m2820a(this.f2275a, null);
        if (a.f2270a > 0) {
            C0667d c0668b = new C0668b(EventType.CONNECTED);
            c0668b.f2220a = System.currentTimeMillis() - currentTimeMillis;
            this.f2276b.notifyStatus(Status.AUTH_SUCC, c0668b);
            return;
        }
        if (a.f2270a == ErrorConstant.ERROR_SSL_ERROR || a.f2270a == ErrorConstant.ERROR_HOST_NOT_VERIFY_ERROR) {
            C0692e.f2274a.add(StringUtils.buildString(this.f2276b.mHost, this.f2276b.mIp, String.valueOf(this.f2276b.mPort)));
        }
        this.f2276b.handleCallbacks(EventType.CONNECT_FAIL, new C0667d(EventType.CONNECT_FAIL, a.f2270a, "Http connect fail"));
    }
}
