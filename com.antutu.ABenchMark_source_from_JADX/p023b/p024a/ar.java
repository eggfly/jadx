package p023b.p024a;

import android.content.Context;
import com.umeng.analytics.C4156a;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: b.a.ar */
public class ar {

    /* renamed from: b.a.ar.h */
    public static class C0820h {
        public boolean m3398a() {
            return true;
        }

        public boolean m3399a(boolean z) {
            return true;
        }
    }

    /* renamed from: b.a.ar.a */
    public static class C0821a extends C0820h {
        private final long f2687a;
        private C0892u f2688b;

        public C0821a(C0892u c0892u) {
            this.f2687a = 15000;
            this.f2688b = c0892u;
        }

        public boolean m3400a(boolean z) {
            return System.currentTimeMillis() - this.f2688b.f2982c >= 15000;
        }
    }

    /* renamed from: b.a.ar.b */
    public static class C0822b extends C0820h {
        private C0911y f2689a;
        private C0892u f2690b;

        public C0822b(C0892u c0892u, C0911y c0911y) {
            this.f2690b = c0892u;
            this.f2689a = c0911y;
        }

        public boolean m3401a() {
            return this.f2689a.m3999b();
        }

        public boolean m3402a(boolean z) {
            return System.currentTimeMillis() - this.f2690b.f2982c >= this.f2689a.m3994a();
        }
    }

    /* renamed from: b.a.ar.c */
    public static class C0823c extends C0820h {
        private long f2691a;
        private long f2692b;

        public C0823c(int i) {
            this.f2692b = 0;
            this.f2691a = (long) i;
            this.f2692b = System.currentTimeMillis();
        }

        public boolean m3403a() {
            return System.currentTimeMillis() - this.f2692b < this.f2691a;
        }

        public boolean m3404a(boolean z) {
            return System.currentTimeMillis() - this.f2692b >= this.f2691a;
        }
    }

    /* renamed from: b.a.ar.d */
    public static class C0824d extends C0820h {
        public boolean m3405a(boolean z) {
            return z;
        }
    }

    /* renamed from: b.a.ar.e */
    public static class C0825e extends C0820h {
        private static long f2693a;
        private static long f2694b;
        private long f2695c;
        private C0892u f2696d;

        static {
            f2693a = 90000;
            f2694b = C4156a.f13948j;
        }

        public C0825e(C0892u c0892u, long j) {
            this.f2696d = c0892u;
            m3406a(j);
        }

        public void m3406a(long j) {
            if (j < f2693a || j > f2694b) {
                this.f2695c = f2693a;
            } else {
                this.f2695c = j;
            }
        }

        public boolean m3407a(boolean z) {
            return System.currentTimeMillis() - this.f2696d.f2982c >= this.f2695c;
        }
    }

    /* renamed from: b.a.ar.f */
    public static class C0826f extends C0820h {
        private long f2697a;
        private C0892u f2698b;

        public C0826f(C0892u c0892u) {
            this.f2697a = C4156a.f13948j;
            this.f2698b = c0892u;
        }

        public boolean m3408a(boolean z) {
            return System.currentTimeMillis() - this.f2698b.f2982c >= this.f2697a;
        }
    }

    /* renamed from: b.a.ar.g */
    public static class C0827g extends C0820h {
        public boolean m3409a(boolean z) {
            return true;
        }
    }

    /* renamed from: b.a.ar.i */
    public static class C0828i extends C0820h {
        private Context f2699a;

        public C0828i(Context context) {
            this.f2699a = null;
            this.f2699a = context;
        }

        public boolean m3410a(boolean z) {
            return am.m3351i(this.f2699a);
        }
    }

    /* renamed from: b.a.ar.j */
    public static class C0829j extends C0820h {
        private final long f2700a;
        private C0892u f2701b;

        public C0829j(C0892u c0892u) {
            this.f2700a = 10800000;
            this.f2701b = c0892u;
        }

        public boolean m3411a(boolean z) {
            return System.currentTimeMillis() - this.f2701b.f2982c >= 10800000;
        }
    }

    public static boolean m3412a(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return true;
            default:
                return false;
        }
    }
}
