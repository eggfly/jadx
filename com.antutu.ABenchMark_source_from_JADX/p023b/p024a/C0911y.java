package p023b.p024a;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import org.android.spdy.SpdyProtocol;
import p023b.p024a.C0909w.C0907n;
import p023b.p024a.ct.C0863a;

/* renamed from: b.a.y */
public class C0911y implements C0871q {
    private static C0911y f3104c;
    private int f3105a;
    private final long f3106b;

    static {
        f3104c = null;
    }

    private C0911y() {
        this.f3105a = 0;
        this.f3106b = 60000;
    }

    public static synchronized C0911y m3993a(Context context) {
        C0911y c0911y;
        synchronized (C0911y.class) {
            if (f3104c == null) {
                f3104c = new C0911y();
                f3104c.m3995a(ct.m3820a(context).m3828b().m3806a(0));
            }
            c0911y = f3104c;
        }
        return c0911y;
    }

    public long m3994a() {
        switch (this.f3105a) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return Constants.ST_UPLOAD_TIME_INTERVAL;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return 28800000;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return C4156a.f13948j;
            default:
                return 0;
        }
    }

    public void m3995a(int i) {
        if (i >= 0 && i <= 3) {
            this.f3105a = i;
        }
    }

    public void m3996a(C0863a c0863a) {
        m3995a(c0863a.m3806a(0));
    }

    public void m3997a(C0909w c0909w, Context context) {
        if (this.f3105a == 1) {
            c0909w.f3095b.f3033i = null;
            c0909w.f3095b.f3025a = null;
            c0909w.f3095b.f3026b = null;
            c0909w.f3095b.f3032h = null;
        } else if (this.f3105a == 2) {
            c0909w.f3095b.f3027c.clear();
            c0909w.f3095b.f3027c.add(m3998b(context));
            c0909w.f3095b.f3033i = null;
            c0909w.f3095b.f3025a = null;
            c0909w.f3095b.f3026b = null;
            c0909w.f3095b.f3032h = null;
        } else if (this.f3105a == 3) {
            c0909w.f3095b.f3027c = null;
            c0909w.f3095b.f3033i = null;
            c0909w.f3095b.f3025a = null;
            c0909w.f3095b.f3026b = null;
            c0909w.f3095b.f3032h = null;
        }
    }

    public C0907n m3998b(Context context) {
        C0907n c0907n = new C0907n();
        c0907n.f3082b = C0891t.m3953g(context);
        long currentTimeMillis = System.currentTimeMillis();
        c0907n.f3083c = currentTimeMillis;
        c0907n.f3084d = currentTimeMillis + 60000;
        c0907n.f3085e = 60000;
        return c0907n;
    }

    public boolean m3999b() {
        return this.f3105a != 0;
    }
}
