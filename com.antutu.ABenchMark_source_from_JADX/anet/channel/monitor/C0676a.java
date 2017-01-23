package anet.channel.monitor;

import anet.channel.p019c.C0660c;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: anet.channel.monitor.a */
public class C0676a {
    static int f2235a;
    static long f2236b;
    static long f2237c;
    static long f2238d;
    static long f2239e;
    static long f2240f;
    static double f2241g;
    static double f2242h;
    static double f2243i;
    static double f2244j;
    private static volatile boolean f2245k;
    private int f2246l;
    private int f2247m;
    private CopyOnWriteArrayList<INetworkQualityChangeListener> f2248n;
    private C0679d f2249o;

    /* renamed from: anet.channel.monitor.a.a */
    static class C0675a {
        static C0676a f2234a;

        static {
            f2234a = new C0676a();
        }

        C0675a() {
        }
    }

    static {
        f2245k = false;
        f2235a = 0;
        f2236b = 0;
        f2237c = 0;
        f2238d = 0;
        f2239e = 0;
        f2240f = 0;
        f2241g = 0.0d;
        f2242h = 0.0d;
        f2243i = 0.0d;
        f2244j = 40.0d;
    }

    private C0676a() {
        this.f2246l = 5;
        this.f2247m = 0;
        this.f2248n = new CopyOnWriteArrayList();
        this.f2249o = new C0679d();
        NetworkStatusHelper.m2841a(new C0677b(this));
    }

    public static C0676a m2806a() {
        return C0675a.f2234a;
    }

    public void m2810a(long j, long j2, long j3) {
        if (ALog.isPrintLog(1)) {
            ALog.m2960d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j), "mRequestFinishedTime", Long.valueOf(j2), "mRequestDataSize", Long.valueOf(j3));
        }
        if (f2245k && j3 > 3000 && j < j2) {
            f2235a++;
            f2239e += j3;
            if (f2235a == 1) {
                f2238d = j2 - j;
            }
            if (f2235a >= 2 && f2235a <= 3) {
                if (j >= f2237c) {
                    f2238d += j2 - j;
                } else if (j < f2237c && j2 >= f2237c) {
                    f2238d += j2 - j;
                    f2238d -= f2237c - j;
                }
            }
            f2236b = j;
            f2237c = j2;
            if (f2235a == 3) {
                f2243i = (double) ((long) this.f2249o.m2816a((double) f2239e, (double) f2238d));
                f2240f++;
                this.f2247m++;
                if (f2240f > 30) {
                    this.f2249o.m2817a();
                    f2240f = 3;
                }
                double d = ((f2243i * 0.68d) + (f2242h * 0.27d)) + (f2241g * 0.05d);
                f2241g = f2242h;
                f2242h = f2243i;
                if (f2243i < 0.65d * f2241g || f2243i > 2.0d * f2241g) {
                    f2243i = d;
                }
                int i = 5;
                if (f2243i < f2244j) {
                    i = 1;
                }
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(f2239e), "mKalmanTimeUsed", Long.valueOf(f2238d), "speed", Double.valueOf(f2243i), "tmpspeed", Integer.valueOf(i), "mSpeedKalmanCount", Long.valueOf(f2240f));
                }
                if (i != this.f2246l) {
                    ALog.m2963i("awcn.BandWidthSampler", "NetworkSpeed change!", null, "From", Integer.valueOf(this.f2246l), "To", Integer.valueOf(i), "mSinceLastNotification", Integer.valueOf(this.f2247m));
                    if (this.f2247m > 5 || f2240f == 2) {
                        this.f2247m = 0;
                        this.f2246l = i;
                        ALog.m2963i("awcn.BandWidthSampler", "NetworkSpeed change!", null, "Send Network quality change notification.");
                        C0660c.m2783a(new C0678c(this));
                    }
                }
                f2238d = 0;
                f2239e = 0;
                f2235a = 0;
            }
        }
    }

    public void m2811a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f2248n.add(iNetworkQualityChangeListener);
    }

    public int m2812b() {
        return NetworkStatusHelper.m2839a() == NetworkStatus.G2 ? 1 : this.f2246l;
    }

    public void m2813b(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f2248n.remove(iNetworkQualityChangeListener);
    }

    public synchronized void m2814c() {
        try {
            ALog.m2963i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.m2839a());
            if (NetworkStatusHelper.m2839a() == NetworkStatus.G2) {
                f2245k = false;
            } else {
                f2245k = true;
            }
        } catch (Throwable e) {
            ALog.m2964w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e, new Object[0]);
        }
    }

    public void m2815d() {
        f2245k = false;
    }
}
