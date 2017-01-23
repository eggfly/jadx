package com.xiaomi.push.service;

import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.xiaomi.channel.commonutils.logger.C4302b;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.xiaomi.push.service.d */
public class C4414d {
    private static long f15071a;
    private final C4412c f15072b;
    private final C4410a f15073c;

    /* renamed from: com.xiaomi.push.service.d.b */
    public static abstract class C4384b implements Runnable {
        protected int f14936a;

        C4384b(int i) {
            this.f14936a = i;
        }
    }

    /* renamed from: com.xiaomi.push.service.d.a */
    private static final class C4410a {
        private final C4412c f15054a;

        C4410a(C4412c c4412c) {
            this.f15054a = c4412c;
        }

        protected void finalize() {
            try {
                synchronized (this.f15054a) {
                    this.f15054a.f15063e = true;
                    this.f15054a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.d.c */
    private static final class C4412c extends Thread {
        private volatile long f15059a;
        private volatile boolean f15060b;
        private long f15061c;
        private boolean f15062d;
        private boolean f15063e;
        private C4411a f15064f;

        /* renamed from: com.xiaomi.push.service.d.c.a */
        private static final class C4411a {
            private int f15055a;
            private C4413d[] f15056b;
            private int f15057c;
            private int f15058d;

            private C4411a() {
                this.f15055a = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                this.f15056b = new C4413d[this.f15055a];
                this.f15057c = 0;
                this.f15058d = 0;
            }

            private int m18194b(C4413d c4413d) {
                for (int i = 0; i < this.f15056b.length; i++) {
                    if (this.f15056b[i] == c4413d) {
                        return i;
                    }
                }
                return -1;
            }

            private void m18195d(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.f15057c && this.f15057c > 0) {
                    int i3 = (i2 + 1 >= this.f15057c || this.f15056b[i2 + 1].f15067c >= this.f15056b[i2].f15067c) ? i2 : i2 + 1;
                    if (this.f15056b[i].f15067c >= this.f15056b[i3].f15067c) {
                        C4413d c4413d = this.f15056b[i];
                        this.f15056b[i] = this.f15056b[i3];
                        this.f15056b[i3] = c4413d;
                        i2 = (i3 * 2) + 1;
                        i = i3;
                    } else {
                        return;
                    }
                }
            }

            private void m18196e() {
                int i = this.f15057c - 1;
                for (int i2 = (i - 1) / 2; this.f15056b[i].f15067c < this.f15056b[i2].f15067c; i2 = (i2 - 1) / 2) {
                    C4413d c4413d = this.f15056b[i];
                    this.f15056b[i] = this.f15056b[i2];
                    this.f15056b[i2] = c4413d;
                    i = i2;
                }
            }

            public C4413d m18197a() {
                return this.f15056b[0];
            }

            public void m18198a(int i, C4384b c4384b) {
                for (int i2 = 0; i2 < this.f15057c; i2++) {
                    if (this.f15056b[i2].f15068d == c4384b) {
                        this.f15056b[i2].m18214a();
                    }
                }
                m18205d();
            }

            public void m18199a(C4413d c4413d) {
                if (this.f15056b.length == this.f15057c) {
                    Object obj = new C4413d[(this.f15057c * 2)];
                    System.arraycopy(this.f15056b, 0, obj, 0, this.f15057c);
                    this.f15056b = obj;
                }
                C4413d[] c4413dArr = this.f15056b;
                int i = this.f15057c;
                this.f15057c = i + 1;
                c4413dArr[i] = c4413d;
                m18196e();
            }

            public boolean m18200a(int i) {
                for (int i2 = 0; i2 < this.f15057c; i2++) {
                    if (this.f15056b[i2].f15069e == i) {
                        return true;
                    }
                }
                return false;
            }

            public void m18201b(int i) {
                for (int i2 = 0; i2 < this.f15057c; i2++) {
                    if (this.f15056b[i2].f15069e == i) {
                        this.f15056b[i2].m18214a();
                    }
                }
                m18205d();
            }

            public boolean m18202b() {
                return this.f15057c == 0;
            }

            public void m18203c() {
                this.f15056b = new C4413d[this.f15055a];
                this.f15057c = 0;
            }

            public void m18204c(int i) {
                if (i >= 0 && i < this.f15057c) {
                    C4413d[] c4413dArr = this.f15056b;
                    C4413d[] c4413dArr2 = this.f15056b;
                    int i2 = this.f15057c - 1;
                    this.f15057c = i2;
                    c4413dArr[i] = c4413dArr2[i2];
                    this.f15056b[this.f15057c] = null;
                    m18195d(i);
                }
            }

            public void m18205d() {
                int i = 0;
                while (i < this.f15057c) {
                    if (this.f15056b[i].f15066b) {
                        this.f15058d++;
                        m18204c(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        C4412c(String str, boolean z) {
            this.f15059a = 0;
            this.f15060b = false;
            this.f15061c = 50;
            this.f15064f = new C4411a();
            setName(str);
            setDaemon(z);
            start();
        }

        private void m18208a(C4413d c4413d) {
            this.f15064f.m18199a(c4413d);
            notify();
        }

        public synchronized void m18211a() {
            this.f15062d = true;
            this.f15064f.m18203c();
            notify();
        }

        public boolean m18212b() {
            return this.f15060b && SystemClock.uptimeMillis() - this.f15059a > 600000;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r8 = this;
        L_0x0000:
            monitor-enter(r8);
            r0 = r8.f15062d;	 Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
        L_0x0006:
            return;
        L_0x0007:
            r0 = r8.f15064f;	 Catch:{ all -> 0x0015 }
            r0 = r0.m18202b();	 Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x001d;
        L_0x000f:
            r0 = r8.f15063e;	 Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0018;
        L_0x0013:
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            goto L_0x0006;
        L_0x0015:
            r0 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            throw r0;
        L_0x0018:
            r8.wait();	 Catch:{ InterruptedException -> 0x00c4 }
        L_0x001b:
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            goto L_0x0000;
        L_0x001d:
            r0 = com.xiaomi.push.service.C4414d.m18215a();	 Catch:{ all -> 0x0015 }
            r2 = r8.f15064f;	 Catch:{ all -> 0x0015 }
            r2 = r2.m18197a();	 Catch:{ all -> 0x0015 }
            r3 = r2.f15065a;	 Catch:{ all -> 0x0015 }
            monitor-enter(r3);	 Catch:{ all -> 0x0015 }
            r4 = r2.f15066b;	 Catch:{ all -> 0x0062 }
            if (r4 == 0) goto L_0x0037;
        L_0x002e:
            r0 = r8.f15064f;	 Catch:{ all -> 0x0062 }
            r1 = 0;
            r0.m18204c(r1);	 Catch:{ all -> 0x0062 }
            monitor-exit(r3);	 Catch:{ all -> 0x0062 }
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            goto L_0x0000;
        L_0x0037:
            r4 = r2.f15067c;	 Catch:{ all -> 0x0062 }
            r0 = r4 - r0;
            monitor-exit(r3);	 Catch:{ all -> 0x0062 }
            r4 = 0;
            r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r3 <= 0) goto L_0x0065;
        L_0x0042:
            r2 = r8.f15061c;	 Catch:{ all -> 0x0015 }
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x004a;
        L_0x0048:
            r0 = r8.f15061c;	 Catch:{ all -> 0x0015 }
        L_0x004a:
            r2 = r8.f15061c;	 Catch:{ all -> 0x0015 }
            r4 = 50;
            r2 = r2 + r4;
            r8.f15061c = r2;	 Catch:{ all -> 0x0015 }
            r2 = r8.f15061c;	 Catch:{ all -> 0x0015 }
            r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 <= 0) goto L_0x005d;
        L_0x0059:
            r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            r8.f15061c = r2;	 Catch:{ all -> 0x0015 }
        L_0x005d:
            r8.wait(r0);	 Catch:{ InterruptedException -> 0x00c7 }
        L_0x0060:
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            goto L_0x0000;
        L_0x0062:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0062 }
            throw r0;	 Catch:{ all -> 0x0015 }
        L_0x0065:
            r0 = 50;
            r8.f15061c = r0;	 Catch:{ all -> 0x0015 }
            r1 = r2.f15065a;	 Catch:{ all -> 0x0015 }
            monitor-enter(r1);	 Catch:{ all -> 0x0015 }
            r0 = 0;
            r3 = r8.f15064f;	 Catch:{ all -> 0x00be }
            r3 = r3.m18197a();	 Catch:{ all -> 0x00be }
            r4 = r3.f15067c;	 Catch:{ all -> 0x00be }
            r6 = r2.f15067c;	 Catch:{ all -> 0x00be }
            r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r3 == 0) goto L_0x0081;
        L_0x007b:
            r0 = r8.f15064f;	 Catch:{ all -> 0x00be }
            r0 = r0.m18194b(r2);	 Catch:{ all -> 0x00be }
        L_0x0081:
            r3 = r2.f15066b;	 Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x0094;
        L_0x0085:
            r0 = r8.f15064f;	 Catch:{ all -> 0x00be }
            r3 = r8.f15064f;	 Catch:{ all -> 0x00be }
            r2 = r3.m18194b(r2);	 Catch:{ all -> 0x00be }
            r0.m18204c(r2);	 Catch:{ all -> 0x00be }
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            goto L_0x0000;
        L_0x0094:
            r4 = r2.f15067c;	 Catch:{ all -> 0x00be }
            r2.m18213a(r4);	 Catch:{ all -> 0x00be }
            r3 = r8.f15064f;	 Catch:{ all -> 0x00be }
            r3.m18204c(r0);	 Catch:{ all -> 0x00be }
            r4 = 0;
            r2.f15067c = r4;	 Catch:{ all -> 0x00be }
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            monitor-exit(r8);	 Catch:{ all -> 0x0015 }
            r0 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x00b7 }
            r8.f15059a = r0;	 Catch:{ all -> 0x00b7 }
            r0 = 1;
            r8.f15060b = r0;	 Catch:{ all -> 0x00b7 }
            r0 = r2.f15068d;	 Catch:{ all -> 0x00b7 }
            r0.run();	 Catch:{ all -> 0x00b7 }
            r0 = 0;
            r8.f15060b = r0;	 Catch:{ all -> 0x00b7 }
            goto L_0x0000;
        L_0x00b7:
            r0 = move-exception;
            monitor-enter(r8);
            r1 = 1;
            r8.f15062d = r1;	 Catch:{ all -> 0x00c1 }
            monitor-exit(r8);	 Catch:{ all -> 0x00c1 }
            throw r0;
        L_0x00be:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            throw r0;	 Catch:{ all -> 0x0015 }
        L_0x00c1:
            r0 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x00c1 }
            throw r0;
        L_0x00c4:
            r0 = move-exception;
            goto L_0x001b;
        L_0x00c7:
            r0 = move-exception;
            goto L_0x0060;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.d.c.run():void");
        }
    }

    /* renamed from: com.xiaomi.push.service.d.d */
    static class C4413d {
        final Object f15065a;
        boolean f15066b;
        long f15067c;
        C4384b f15068d;
        int f15069e;
        private long f15070f;

        C4413d() {
            this.f15065a = new Object();
        }

        void m18213a(long j) {
            synchronized (this.f15065a) {
                this.f15070f = j;
            }
        }

        public boolean m18214a() {
            boolean z = true;
            synchronized (this.f15065a) {
                if (this.f15066b || this.f15067c <= 0) {
                    z = false;
                }
                this.f15066b = true;
            }
            return z;
        }
    }

    public C4414d() {
        this(false);
    }

    public C4414d(String str) {
        this(str, false);
    }

    public C4414d(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f15072b = new C4412c(str, z);
        this.f15073c = new C4410a(this.f15072b);
    }

    public C4414d(boolean z) {
        this("Timer-" + C4414d.m18217e(), z);
    }

    static long m18215a() {
        return SystemClock.elapsedRealtime();
    }

    private void m18216b(C4384b c4384b, long j) {
        synchronized (this.f15072b) {
            if (this.f15072b.f15062d) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a = C4414d.m18215a() + j;
            if (a < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a);
            }
            C4413d c4413d = new C4413d();
            c4413d.f15069e = c4384b.f14936a;
            c4413d.f15068d = c4384b;
            c4413d.f15067c = a;
            this.f15072b.m18208a(c4413d);
        }
    }

    private static synchronized long m18217e() {
        long j;
        synchronized (C4414d.class) {
            j = f15071a;
            f15071a = 1 + j;
        }
        return j;
    }

    public void m18218a(int i, C4384b c4384b) {
        synchronized (this.f15072b) {
            this.f15072b.f15064f.m18198a(i, c4384b);
        }
    }

    public void m18219a(C4384b c4384b) {
        if (C4302b.m17643a() >= 1 || Thread.currentThread() == this.f15072b) {
            c4384b.run();
        } else {
            C4302b.m17654d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void m18220a(C4384b c4384b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: " + j);
        }
        m18216b(c4384b, j);
    }

    public boolean m18221a(int i) {
        boolean a;
        synchronized (this.f15072b) {
            a = this.f15072b.f15064f.m18200a(i);
        }
        return a;
    }

    public void m18222b() {
        this.f15072b.m18211a();
    }

    public void m18223b(int i) {
        synchronized (this.f15072b) {
            this.f15072b.f15064f.m18201b(i);
        }
    }

    public void m18224c() {
        synchronized (this.f15072b) {
            this.f15072b.f15064f.m18203c();
        }
    }

    public boolean m18225d() {
        return this.f15072b.m18212b();
    }
}
