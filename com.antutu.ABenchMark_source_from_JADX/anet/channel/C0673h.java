package anet.channel;

import anet.channel.SessionRequest.C0642a;

/* renamed from: anet.channel.h */
class C0673h implements Runnable {
    final /* synthetic */ Session f2230a;
    final /* synthetic */ C0642a f2231b;

    C0673h(C0642a c0642a, Session session) {
        this.f2231b = c0642a;
        this.f2230a = session;
    }

    public void run() {
        try {
            this.f2231b.f2159b.m2748a(this.f2231b.f2160c, this.f2230a.getConnType().getTypeLevel(), null);
        } catch (Exception e) {
        }
    }
}
