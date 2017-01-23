package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.C4302b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.channel.commonutils.misc.f */
public class C4312f {
    private C4310a f14742a;
    private Handler f14743b;
    private volatile boolean f14744c;
    private final boolean f14745d;
    private int f14746e;
    private volatile C4311b f14747f;

    /* renamed from: com.xiaomi.channel.commonutils.misc.f.a */
    private class C4310a extends Thread {
        final /* synthetic */ C4312f f14740a;
        private final LinkedBlockingQueue<C4311b> f14741b;

        public C4310a(C4312f c4312f) {
            this.f14740a = c4312f;
            super("PackageProcessor");
            this.f14741b = new LinkedBlockingQueue();
        }

        public void m17675a(C4311b c4311b) {
            this.f14741b.add(c4311b);
        }

        public void run() {
            int a = this.f14740a.f14746e > 0 ? this.f14740a.f14746e : 1;
            while (!this.f14740a.f14744c) {
                try {
                    this.f14740a.f14747f = (C4311b) this.f14741b.poll((long) a, TimeUnit.SECONDS);
                    if (this.f14740a.f14747f != null) {
                        this.f14740a.f14743b.sendMessage(this.f14740a.f14743b.obtainMessage(0, this.f14740a.f14747f));
                        this.f14740a.f14747f.m17677b();
                        this.f14740a.f14743b.sendMessage(this.f14740a.f14743b.obtainMessage(1, this.f14740a.f14747f));
                    } else if (this.f14740a.f14746e > 0) {
                        this.f14740a.m17681a();
                    }
                } catch (Throwable e) {
                    C4302b.m17651a(e);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.channel.commonutils.misc.f.b */
    public static abstract class C4311b {
        public void m17676a() {
        }

        public abstract void m17677b();

        public void m17678c() {
        }
    }

    public C4312f() {
        this(false);
    }

    public C4312f(boolean z) {
        this(z, 0);
    }

    public C4312f(boolean z, int i) {
        this.f14743b = null;
        this.f14744c = false;
        this.f14746e = 0;
        this.f14743b = new C4313g(this, Looper.getMainLooper());
        this.f14745d = z;
        this.f14746e = i;
    }

    private synchronized void m17681a() {
        this.f14742a = null;
        this.f14744c = true;
    }

    public synchronized void m17686a(C4311b c4311b) {
        if (this.f14742a == null) {
            this.f14742a = new C4310a(this);
            this.f14742a.setDaemon(this.f14745d);
            this.f14744c = false;
            this.f14742a.start();
        }
        this.f14742a.m17675a(c4311b);
    }

    public void m17687a(C4311b c4311b, long j) {
        this.f14743b.postDelayed(new C4314h(this, c4311b), j);
    }
}
