package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.ads.AdError;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import p023b.p024a.C0909w.C0900g;
import p023b.p024a.C0909w.C0907n;
import p023b.p024a.ar.C0820h;
import p023b.p024a.ar.C0821a;
import p023b.p024a.ar.C0822b;
import p023b.p024a.ar.C0823c;
import p023b.p024a.ar.C0824d;
import p023b.p024a.ar.C0825e;
import p023b.p024a.ar.C0826f;
import p023b.p024a.ar.C0827g;
import p023b.p024a.ar.C0828i;
import p023b.p024a.ar.C0829j;
import p023b.p024a.ct.C0863a;

/* renamed from: b.a.f */
public final class C0872f implements C0870j, C0871q {
    private static Context f2922p;
    String f2923a;
    private final long f2924b;
    private final int f2925c;
    private C0884m f2926d;
    private at f2927e;
    private C0892u f2928f;
    private C0911y f2929g;
    private C0910x f2930h;
    private C0912z f2931i;
    private C0869a f2932j;
    private C0863a f2933k;
    private int f2934l;
    private long f2935m;
    private int f2936n;
    private int f2937o;

    /* renamed from: b.a.f.1 */
    class C08681 extends as {
        final /* synthetic */ C0872f f2915a;

        C08681(C0872f c0872f) {
            this.f2915a = c0872f;
        }

        public void m3846a() {
            this.f2915a.m3876a();
        }
    }

    /* renamed from: b.a.f.a */
    public class C0869a {
        final /* synthetic */ C0872f f2916a;
        private C0820h f2917b;
        private int f2918c;
        private int f2919d;
        private int f2920e;
        private int f2921f;

        public C0869a(C0872f c0872f) {
            this.f2916a = c0872f;
            this.f2918c = -1;
            this.f2919d = -1;
            this.f2920e = -1;
            this.f2921f = -1;
            int[] a = c0872f.f2933k.m3811a(-1, -1);
            this.f2918c = a[0];
            this.f2919d = a[1];
        }

        private C0820h m3847a(int i, int i2) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return this.f2917b instanceof C0827g ? this.f2917b : new C0827g();
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return this.f2917b instanceof C0824d ? this.f2917b : new C0824d();
                case SpdyProtocol.QUIC /*4*/:
                    return this.f2917b instanceof C0826f ? this.f2917b : new C0826f(this.f2916a.f2928f);
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    return this.f2917b instanceof C0828i ? this.f2917b : new C0828i(C0872f.f2922p);
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (!(this.f2917b instanceof C0825e)) {
                        return new C0825e(this.f2916a.f2928f, (long) i2);
                    }
                    C0820h c0820h = this.f2917b;
                    ((C0825e) c0820h).m3406a((long) i2);
                    return c0820h;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    return this.f2917b instanceof C0829j ? this.f2917b : new C0829j(this.f2916a.f2928f);
                default:
                    return this.f2917b instanceof C0824d ? this.f2917b : new C0824d();
            }
        }

        public void m3848a(C0863a c0863a) {
            int[] a = c0863a.m3811a(-1, -1);
            this.f2918c = a[0];
            this.f2919d = a[1];
        }

        protected void m3849a(boolean z) {
            int i = 1;
            int i2 = 0;
            if (this.f2916a.f2929g.m3999b()) {
                if (!((this.f2917b instanceof C0822b) && this.f2917b.m3398a())) {
                    i = 0;
                }
                this.f2917b = i != 0 ? this.f2917b : new C0822b(this.f2916a.f2928f, this.f2916a.f2929g);
                return;
            }
            if (!((this.f2917b instanceof C0823c) && this.f2917b.m3398a())) {
                i = 0;
            }
            if (i != 0) {
                return;
            }
            if (z && this.f2916a.f2931i.m4002a()) {
                this.f2917b = new C0823c((int) this.f2916a.f2931i.m4003b());
                this.f2916a.m3864b((int) this.f2916a.f2931i.m4003b());
            } else if (ap.f2680a && this.f2916a.f2933k.m3814b()) {
                ap.m3381a("Debug: send log every 15 seconds");
                this.f2917b = new C0821a(this.f2916a.f2928f);
            } else if (this.f2916a.f2930h.m3991a()) {
                ap.m3381a("Start A/B Test");
                if (this.f2916a.f2930h.m3992b() == 6) {
                    i2 = this.f2916a.f2933k.m3810a() ? this.f2916a.f2933k.m3817d(90000) : this.f2919d > 0 ? this.f2919d : this.f2921f;
                }
                this.f2917b = m3847a(this.f2916a.f2930h.m3992b(), i2);
            } else {
                i = this.f2920e;
                i2 = this.f2921f;
                if (this.f2918c != -1) {
                    i = this.f2918c;
                    i2 = this.f2919d;
                }
                this.f2917b = m3847a(i, i2);
            }
        }

        public C0820h m3850b(boolean z) {
            m3849a(z);
            return this.f2917b;
        }
    }

    public C0872f(Context context) {
        this.f2924b = 28800000;
        this.f2925c = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f2926d = null;
        this.f2927e = null;
        this.f2928f = null;
        this.f2929g = null;
        this.f2930h = null;
        this.f2931i = null;
        this.f2932j = null;
        this.f2933k = null;
        this.f2934l = 10;
        this.f2935m = 0;
        this.f2936n = 0;
        this.f2937o = 0;
        this.f2923a = null;
        f2922p = context;
        this.f2926d = new C0884m(context);
        this.f2928f = new C0892u(context);
        this.f2927e = at.m3424a(context);
        this.f2933k = ct.m3820a(context).m3828b();
        this.f2932j = new C0869a(this);
        this.f2930h = C0910x.m3983a(f2922p);
        this.f2929g = C0911y.m3993a(f2922p);
        this.f2931i = C0912z.m4000a(f2922p, this.f2928f);
        SharedPreferences a = C0888r.m3932a(f2922p);
        this.f2935m = a.getLong("thtstart", 0);
        this.f2936n = a.getInt("gkvc", 0);
        this.f2937o = a.getInt("ekvc", 0);
        this.f2923a = ct.m3820a(f2922p).m3828b().m3808a(null);
    }

    private void m3858a(int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f2928f.m3973l());
        m3861a(m3875a(i, currentTimeMillis));
        aq.m3395a(new C08681(this), (long) i);
    }

    private void m3859a(int i, int i2, C0909w c0909w) {
        List list;
        int size;
        int size2;
        if (i > 0) {
            list = c0909w.f3095b.f3026b;
            if (list.size() >= i) {
                size = list.size() - i;
                for (size2 = list.size() - 1; size2 >= size; size2--) {
                    list.remove(size2);
                }
            } else {
                size2 = i - list.size();
                list.clear();
            }
        }
        if (i2 > 0) {
            list = c0909w.f3095b.f3025a;
            if (list.size() >= i2) {
                size = list.size() - i2;
                for (size2 = list.size() - 1; size2 >= size; size2--) {
                    list.remove(size2);
                }
                return;
            }
            size2 = i2 - list.size();
            list.clear();
        }
    }

    private void m3861a(C0909w c0909w) {
        if (c0909w != null) {
            try {
                cr a = cr.m3793a(f2922p);
                a.m3797a();
                try {
                    c0909w.f3094a.f3054T = Base64.encodeToString(new bb().m3488a(a.m3799b()), 0);
                } catch (Exception e) {
                }
                byte[] b = at.m3424a(f2922p).m3442b(m3868c(c0909w));
                if (b != null && !ak.m3323a(f2922p, b)) {
                    b = (m3874g() ? cp.m3778b(f2922p, AnalyticsConfig.getAppkey(f2922p), b) : cp.m3775a(f2922p, AnalyticsConfig.getAppkey(f2922p), b)).m3787c();
                    at a2 = at.m3424a(f2922p);
                    a2.m3447g();
                    a2.m3438a(b);
                    a.m3800c();
                    C0909w.f3093c = 0;
                }
            } catch (Exception e2) {
            }
        }
    }

    private void m3862a(boolean z) {
        boolean e = this.f2928f.m3966e();
        if (e) {
            C0909w.f3093c = this.f2928f.m3972k();
        }
        if (m3866b(z)) {
            m3873f();
        } else if (e || m3872e()) {
            m3879b();
        }
    }

    private void m3864b(int i) {
        m3858a(i);
    }

    private boolean m3865b(C0909w c0909w) {
        return c0909w != null && c0909w.m3982a();
    }

    private boolean m3866b(boolean z) {
        if (am.m3352j(f2922p)) {
            return this.f2928f.m3966e() ? true : this.f2932j.m3850b(z).m3399a(z);
        } else {
            ap.m3381a("network is unavailable");
            return false;
        }
    }

    private C0909w m3868c(C0909w c0909w) {
        int i;
        int i2;
        int i3 = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        if (c0909w.f3095b.f3025a != null) {
            i = 0;
            for (i2 = 0; i2 < c0909w.f3095b.f3025a.size(); i2++) {
                i += ((C0900g) c0909w.f3095b.f3025a.get(i2)).f3007b.size();
            }
        } else {
            i = 0;
        }
        if (c0909w.f3095b.f3026b != null) {
            for (i2 = 0; i2 < c0909w.f3095b.f3026b.size(); i2++) {
                i += ((C0900g) c0909w.f3095b.f3026b.get(i2)).f3007b.size();
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f2935m > 28800000) {
            int i4 = i - 5000;
            if (i4 > 0) {
                m3859a(-5000, i4, c0909w);
            }
            this.f2936n = 0;
            if (i4 > 0) {
                i = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
            }
            this.f2937o = i;
            this.f2935m = currentTimeMillis;
        } else {
            int i5 = this.f2936n > BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT ? 0 : (this.f2936n + 0) - 5000;
            i2 = this.f2937o > BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT ? i : (this.f2937o + i) - 5000;
            if (i5 > 0 || i2 > 0) {
                m3859a(i5, i2, c0909w);
            }
            this.f2936n = i5 > 0 ? BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT : this.f2936n + 0;
            if (i2 <= 0) {
                i3 = this.f2937o + i;
            }
            this.f2937o = i3;
        }
        return c0909w;
    }

    private boolean m3872e() {
        return this.f2926d.m3918a() > this.f2934l;
    }

    private void m3873f() {
        try {
            if (this.f2927e.m3448h()) {
                C0890s c0890s = new C0890s(f2922p, this.f2928f);
                c0890s.m3945a((C0871q) this);
                if (this.f2929g.m3999b()) {
                    c0890s.m3948b(true);
                }
                c0890s.m3944a();
                return;
            }
            C0909w a = m3875a(new int[0]);
            if (m3865b(a)) {
                C0890s c0890s2 = new C0890s(f2922p, this.f2928f);
                c0890s2.m3945a((C0871q) this);
                if (this.f2929g.m3999b()) {
                    c0890s2.m3948b(true);
                }
                c0890s2.m3946a(m3868c(a));
                c0890s2.m3947a(m3874g());
                c0890s2.m3944a();
            }
        } catch (Throwable th) {
            if (th instanceof OutOfMemoryError) {
                if (th != null) {
                    th.printStackTrace();
                }
            } else if (th != null) {
                th.printStackTrace();
            }
        }
    }

    private boolean m3874g() {
        switch (this.f2933k.m3815c(-1)) {
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                return AnalyticsConfig.sEncrypt;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return true;
            default:
                return false;
        }
    }

    protected C0909w m3875a(int... iArr) {
        Object obj = null;
        try {
            if (TextUtils.isEmpty(AnalyticsConfig.getAppkey(f2922p))) {
                ap.m3391d("Appkey is missing ,Please check AndroidManifest.xml");
                return null;
            }
            C0909w f = at.m3424a(f2922p).m3446f();
            if (f == null && this.f2926d.m3918a() == 0) {
                return null;
            }
            if (f == null) {
                f = new C0909w();
            }
            this.f2926d.m3920a(f);
            if (f.f3095b.f3027c != null && ap.f2680a && f.f3095b.f3027c.size() > 0) {
                for (C0907n c0907n : f.f3095b.f3027c) {
                    obj = c0907n.f3087g.size() > 0 ? 1 : obj;
                }
                if (obj == null) {
                    ap.m3389c("missing Activities or PageViews");
                }
            }
            this.f2929g.m3997a(f, f2922p);
            if (iArr != null && iArr.length == 2) {
                f.f3095b.f3029e.f3003a = Integer.valueOf(iArr[0] / AdError.NETWORK_ERROR_CODE);
                f.f3095b.f3029e.f3004b = (long) iArr[1];
                f.f3095b.f3029e.f3005c = true;
            }
            return f;
        } catch (Throwable e) {
            ap.m3383a("Fail to construct message ...", e);
            at.m3424a(f2922p).m3447g();
            ap.m3385a(e);
            return null;
        }
    }

    public void m3876a() {
        if (am.m3352j(f2922p)) {
            m3873f();
        } else {
            ap.m3381a("network is unavailable");
        }
    }

    public void m3877a(C0863a c0863a) {
        this.f2930h.m3988a(c0863a);
        this.f2929g.m3996a(c0863a);
        this.f2931i.m4001a(c0863a);
        this.f2932j.m3848a(c0863a);
        this.f2923a = ct.m3820a(f2922p).m3828b().m3808a(null);
    }

    public void m3878a(C0882k c0882k) {
        if (c0882k != null) {
            this.f2926d.m3919a(c0882k);
        }
        m3862a(c0882k instanceof C0907n);
    }

    public void m3879b() {
        if (this.f2926d.m3918a() > 0) {
            try {
                this.f2927e.m3435a(m3875a(new int[0]));
            } catch (Throwable th) {
                ap.m3385a(th);
                if (th instanceof OutOfMemoryError) {
                    this.f2927e.m3447g();
                }
                if (th != null) {
                    th.printStackTrace();
                }
            }
        }
        C0888r.m3932a(f2922p).edit().putLong("thtstart", this.f2935m).putInt("gkvc", this.f2936n).putInt("ekvc", this.f2937o).commit();
    }

    public void m3880b(C0882k c0882k) {
        this.f2926d.m3919a(c0882k);
    }

    public void m3881c() {
        m3861a(m3875a(new int[0]));
    }
}
