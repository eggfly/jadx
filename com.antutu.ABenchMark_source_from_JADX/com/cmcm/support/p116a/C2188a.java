package com.cmcm.support.p116a;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.cmcm.support.a.a */
public class C2188a<E> {
    private Thread f7578a;
    private final Queue<E> f7579b;
    private final int f7580c;
    private final C2187b<E> f7581d;

    /* renamed from: com.cmcm.support.a.a.1 */
    class C21851 extends Thread {
        final /* synthetic */ C2188a f7575a;

        C21851(C2188a c2188a) {
            this.f7575a = c2188a;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r4 = this;
        L_0x0000:
            r0 = r4.f7575a;
            r1 = r0.f7579b;
            monitor-enter(r1);
            r0 = r4.f7575a;	 Catch:{ all -> 0x0040 }
            r0 = r0.f7579b;	 Catch:{ all -> 0x0040 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0043;
        L_0x0013:
            r0 = r4.f7575a;	 Catch:{ InterruptedException -> 0x0037 }
            r0 = r0.f7579b;	 Catch:{ InterruptedException -> 0x0037 }
            r2 = r4.f7575a;	 Catch:{ InterruptedException -> 0x0037 }
            r2 = r2.f7580c;	 Catch:{ InterruptedException -> 0x0037 }
            r2 = (long) r2;	 Catch:{ InterruptedException -> 0x0037 }
            r0.wait(r2);	 Catch:{ InterruptedException -> 0x0037 }
            r0 = r4.f7575a;	 Catch:{ InterruptedException -> 0x0037 }
            r0 = r0.f7579b;	 Catch:{ InterruptedException -> 0x0037 }
            r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0037 }
            if (r0 == 0) goto L_0x0043;
        L_0x002f:
            r0 = r4.f7575a;	 Catch:{ InterruptedException -> 0x0037 }
            r2 = 0;
            r0.f7578a = r2;	 Catch:{ InterruptedException -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        L_0x0036:
            return;
        L_0x0037:
            r0 = move-exception;
            r0 = r4.f7575a;	 Catch:{ all -> 0x0040 }
            r2 = 0;
            r0.f7578a = r2;	 Catch:{ all -> 0x0040 }
            monitor-exit(r1);	 Catch:{ all -> 0x0040 }
            goto L_0x0036;
        L_0x0040:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0040 }
            throw r0;
        L_0x0043:
            r0 = r4.f7575a;	 Catch:{ all -> 0x0040 }
            r0 = r0.f7579b;	 Catch:{ all -> 0x0040 }
            r0 = r0.poll();	 Catch:{ all -> 0x0040 }
            monitor-exit(r1);	 Catch:{ all -> 0x0040 }
            r1 = r4.f7575a;
            r1 = r1.f7581d;
            if (r1 == 0) goto L_0x0000;
        L_0x0056:
            r1 = r4.f7575a;
            r1 = r1.f7581d;
            r1.m8224a(r0);
            goto L_0x0000;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cmcm.support.a.a.1.run():void");
        }
    }

    /* renamed from: com.cmcm.support.a.a.a */
    public static class C2186a<E> {
        private int f7576a;
        private C2187b<E> f7577b;

        public C2186a() {
            this.f7576a = 17000;
            this.f7577b = null;
        }

        public C2186a<E> m8221a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The wait time should be positive integer.");
            }
            this.f7576a = i;
            return this;
        }

        public C2186a<E> m8222a(C2187b<E> c2187b) {
            this.f7577b = c2187b;
            return this;
        }

        public C2188a<E> m8223a() {
            return new C2188a();
        }
    }

    /* renamed from: com.cmcm.support.a.a.b */
    public interface C2187b<E> {
        void m8224a(E e);
    }

    private C2188a(C2186a<E> c2186a) {
        this.f7578a = null;
        this.f7579b = new LinkedList();
        this.f7580c = c2186a.f7576a;
        this.f7581d = c2186a.f7577b;
    }

    private void m8227a() {
        this.f7578a = new C21851(this);
        this.f7578a.start();
    }

    public void m8230a(E e) {
        if (e != null) {
            synchronized (this.f7579b) {
                this.f7579b.offer(e);
                if (this.f7578a == null) {
                    m8227a();
                }
                this.f7579b.notify();
            }
        }
    }
}
