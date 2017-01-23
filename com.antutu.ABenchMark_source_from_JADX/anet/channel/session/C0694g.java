package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;

/* renamed from: anet.channel.session.g */
class C0694g implements Runnable {
    final /* synthetic */ Request f2277a;
    final /* synthetic */ RequestCb f2278b;
    final /* synthetic */ C0692e f2279c;

    C0694g(C0692e c0692e, Request request, RequestCb requestCb) {
        this.f2279c = c0692e;
        this.f2277a = request;
        this.f2278b = requestCb;
    }

    public void run() {
        C0690c.m2820a(this.f2277a, new C0695h(this));
    }
}
