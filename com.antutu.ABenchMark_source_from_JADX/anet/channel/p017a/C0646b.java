package anet.channel.p017a;

import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* renamed from: anet.channel.a.b */
public class C0646b {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";
    private final TreeSet<C0644a> f2175a;
    private final C0644a f2176b;
    private final Random f2177c;
    private long f2178d;
    private long f2179e;

    /* renamed from: anet.channel.a.b.a */
    static class C0645a {
        public static C0646b f2174a;

        static {
            f2174a = new C0646b();
        }

        C0645a() {
        }
    }

    public C0646b() {
        this.f2175a = new TreeSet();
        this.f2176b = C0644a.m2753a(0);
        this.f2177c = new Random();
        this.f2178d = 0;
        this.f2179e = 0;
    }

    public synchronized C0644a m2763a(int i) {
        C0644a a;
        if (i >= MAX_POOL_SIZE) {
            a = C0644a.m2753a(i);
        } else {
            this.f2176b.f2172b = i;
            a = (C0644a) this.f2175a.ceiling(this.f2176b);
            if (a == null) {
                a = C0644a.m2753a(i);
            } else {
                Arrays.fill(a.f2171a, (byte) 0);
                a.f2173c = 0;
                this.f2175a.remove(a);
                this.f2178d -= (long) a.f2172b;
                this.f2179e += (long) i;
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d(TAG, "ByteArray Pool retrieve", null, "retrieve", Integer.valueOf(i), "reused", Long.valueOf(this.f2179e));
                }
            }
        }
        return a;
    }

    public C0644a m2764a(byte[] bArr, int i) {
        C0644a a = m2763a(i);
        System.arraycopy(bArr, 0, a.f2171a, 0, i);
        a.f2173c = i;
        return a;
    }

    public synchronized void m2765a(C0644a c0644a) {
        if (c0644a != null) {
            if (c0644a.f2172b < MAX_POOL_SIZE) {
                this.f2178d += (long) c0644a.f2172b;
                this.f2175a.add(c0644a);
                while (this.f2178d > 524288) {
                    this.f2178d -= (long) (this.f2177c.nextBoolean() ? (C0644a) this.f2175a.pollFirst() : (C0644a) this.f2175a.pollLast()).f2172b;
                }
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d(TAG, "ByteArray Pool refund", null, "refund", Integer.valueOf(c0644a.m2760b()), "total", Long.valueOf(this.f2178d));
                }
            }
        }
    }
}
