package com.antutu.benchmark.platform.p057h.p058a;

import android.content.Context;
import android.util.Log;
import com.antutu.benchmark.platform.p057h.p059b.C1596a;
import com.antutu.benchmark.platform.p057h.p061d.C1598a;
import com.antutu.benchmark.platform.p057h.p062e.C1600b;
import java.io.BufferedInputStream;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.benchmark.platform.h.a.a */
public class C1595a {
    private Context f5574a;

    /* renamed from: com.antutu.benchmark.platform.h.a.a.d */
    private abstract class C1590d extends Thread {
        private final CountDownLatch f5562a;
        final /* synthetic */ C1595a f5563b;
        private final Queue<C1593c> f5564c;
        private final String f5565d;
        private final int f5566e;

        public C1590d(C1595a c1595a, CountDownLatch countDownLatch, Queue<C1593c> queue, String str, int i) {
            this.f5563b = c1595a;
            this.f5562a = countDownLatch;
            this.f5564c = queue;
            this.f5565d = str;
            this.f5566e = i;
        }

        protected abstract C1593c m6289a();

        public void run() {
            try {
                this.f5564c.offer(m6289a());
            } catch (Throwable e) {
                Log.e("Nano_benchmark", "unmarshalling failed.", e);
                C1593c c1593c = new C1593c();
                c1593c.f5569a = true;
                this.f5564c.offer(c1593c);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.platform.h.a.a.a */
    private class C1591a extends C1590d {
        final /* synthetic */ C1595a f5567a;

        public C1591a(C1595a c1595a, CountDownLatch countDownLatch, Queue<C1593c> queue, String str, int i) {
            this.f5567a = c1595a;
            super(c1595a, countDownLatch, queue, str, i);
        }

        protected C1593c m6290a() {
            double nanoTime;
            List a;
            this.f5562a.countDown();
            this.f5562a.await();
            double nanoTime2 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
            int i = 0;
            do {
                a = C1596a.m6295a(new BufferedInputStream(this.f5567a.f5574a.getAssets().open(this.f5565d), SpdyProtocol.SLIGHTSSL_0_RTT_MODE));
                nanoTime = ((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime2;
                i++;
            } while (nanoTime < ((double) this.f5566e));
            C1593c c1593c = new C1593c();
            c1593c.f5572d = i;
            c1593c.f5570b = nanoTime;
            c1593c.f5571c = a.size();
            return c1593c;
        }
    }

    /* renamed from: com.antutu.benchmark.platform.h.a.a.b */
    private class C1592b extends C1590d {
        final /* synthetic */ C1595a f5568a;

        public C1592b(C1595a c1595a, CountDownLatch countDownLatch, Queue<C1593c> queue, String str, int i) {
            this.f5568a = c1595a;
            super(c1595a, countDownLatch, queue, str, i);
        }

        protected C1593c m6291a() {
            double nanoTime;
            List a;
            this.f5562a.countDown();
            this.f5562a.await();
            double nanoTime2 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
            int i = 0;
            do {
                a = C1598a.m6304a(new BufferedInputStream(this.f5568a.f5574a.getAssets().open(this.f5565d), SpdyProtocol.SLIGHTSSL_0_RTT_MODE));
                nanoTime = ((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime2;
                i++;
            } while (nanoTime < ((double) this.f5566e));
            C1593c c1593c = new C1593c();
            c1593c.f5572d = i;
            c1593c.f5570b = nanoTime;
            c1593c.f5571c = a.size();
            return c1593c;
        }
    }

    /* renamed from: com.antutu.benchmark.platform.h.a.a.c */
    private static class C1593c {
        public boolean f5569a;
        public double f5570b;
        public int f5571c;
        public int f5572d;

        private C1593c() {
            this.f5569a = false;
            this.f5570b = 0.0d;
            this.f5571c = 0;
            this.f5572d = 0;
        }
    }

    /* renamed from: com.antutu.benchmark.platform.h.a.a.e */
    private class C1594e extends C1590d {
        final /* synthetic */ C1595a f5573a;

        public C1594e(C1595a c1595a, CountDownLatch countDownLatch, Queue<C1593c> queue, String str, int i) {
            this.f5573a = c1595a;
            super(c1595a, countDownLatch, queue, str, i);
        }

        protected C1593c m6292a() {
            double nanoTime;
            List a;
            this.f5562a.countDown();
            this.f5562a.await();
            double nanoTime2 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
            int i = 0;
            do {
                a = C1600b.m6306a(new BufferedInputStream(this.f5573a.f5574a.getAssets().open(this.f5565d), SpdyProtocol.SLIGHTSSL_0_RTT_MODE));
                nanoTime = ((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime2;
                i++;
            } while (nanoTime < ((double) this.f5566e));
            C1593c c1593c = new C1593c();
            c1593c.f5572d = i;
            c1593c.f5570b = nanoTime;
            c1593c.f5571c = a.size();
            return c1593c;
        }
    }

    public C1595a() {
        this.f5574a = null;
    }

    public double m6294a(Context context, String str, int i, double d) {
        C1590d c1591a;
        this.f5574a = context;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Queue linkedBlockingQueue = new LinkedBlockingQueue();
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                c1591a = new C1591a(this, countDownLatch, linkedBlockingQueue, str, (int) (d * 1000.0d));
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                c1591a = new C1592b(this, countDownLatch, linkedBlockingQueue, str, (int) (d * 1000.0d));
                break;
            default:
                c1591a = new C1594e(this, countDownLatch, linkedBlockingQueue, str, (int) (d * 1000.0d));
                break;
        }
        c1591a.start();
        try {
            C1593c c1593c = (C1593c) linkedBlockingQueue.take();
            return (((double) c1593c.f5572d) * 1000.0d) / c1593c.f5570b;
        } catch (Exception e) {
            return 0.0d;
        }
    }
}
