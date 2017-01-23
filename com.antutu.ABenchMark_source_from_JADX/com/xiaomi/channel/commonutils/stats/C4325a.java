package com.xiaomi.channel.commonutils.stats;

import java.util.LinkedList;

/* renamed from: com.xiaomi.channel.commonutils.stats.a */
public class C4325a {
    private LinkedList<C4324a> f14769a;

    /* renamed from: com.xiaomi.channel.commonutils.stats.a.a */
    public static class C4324a {
        private static final C4325a f14765d;
        public int f14766a;
        public String f14767b;
        public Object f14768c;

        static {
            f14765d = new C4325a();
        }

        C4324a(int i, Object obj) {
            this.f14766a = i;
            this.f14768c = obj;
        }
    }

    public C4325a() {
        this.f14769a = new LinkedList();
    }

    public static C4325a m17726a() {
        return C4324a.f14765d;
    }

    private void m17727d() {
        if (this.f14769a.size() > 100) {
            this.f14769a.removeFirst();
        }
    }

    public synchronized void m17728a(Object obj) {
        this.f14769a.add(new C4324a(0, obj));
        m17727d();
    }

    public synchronized int m17729b() {
        return this.f14769a.size();
    }

    public synchronized LinkedList<C4324a> m17730c() {
        LinkedList<C4324a> linkedList;
        linkedList = this.f14769a;
        this.f14769a = new LinkedList();
        return linkedList;
    }
}
