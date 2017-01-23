package p023b.p024a;

import android.content.Context;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;
import p023b.p024a.at.C0836b;
import p023b.p024a.bh.C0842a;

/* renamed from: b.a.s */
public class C0890s {
    private static Context f2966d;
    private cr f2967a;
    private ct f2968b;
    private final int f2969c;
    private C0892u f2970e;
    private C0885n f2971f;
    private C0909w f2972g;
    private boolean f2973h;
    private boolean f2974i;

    /* renamed from: b.a.s.1 */
    class C08891 implements C0836b {
        final /* synthetic */ C0890s f2965a;

        C08891(C0890s c0890s) {
            this.f2965a = c0890s;
        }

        public void m3934a(File file) {
        }

        public boolean m3935b(File file) {
            Throwable th;
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] b = an.m3376b(fileInputStream);
                    try {
                        an.m3377c(fileInputStream);
                        byte[] a = this.f2965a.f2971f.m3926a(b);
                        return this.f2965a.f2974i || (a == null ? 1 : this.f2965a.m3938a(a)) != 1;
                    } catch (Exception e) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    an.m3377c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                an.m3377c(fileInputStream);
                throw th;
            }
        }

        public void m3936c(File file) {
            this.f2965a.f2970e.m3971j();
        }
    }

    public C0890s(Context context, C0892u c0892u) {
        this.f2969c = 1;
        this.f2973h = false;
        this.f2967a = cr.m3793a(context);
        this.f2968b = ct.m3820a(context);
        f2966d = context;
        this.f2970e = c0892u;
        this.f2971f = new C0885n(context);
        this.f2971f.m3925a(this.f2970e);
    }

    private int m3938a(byte[] bArr) {
        ah ahVar = new ah();
        try {
            new ay(new C0842a()).m3468a(ahVar, bArr);
            if (ahVar.f2627a == 1) {
                this.f2968b.m3829b(ahVar.m3258d());
                this.f2968b.m3831d();
            }
            ap.m3386b("send log:" + ahVar.m3253b());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ahVar.f2627a == 1 ? 2 : 3;
    }

    private void m3940b() {
        at.m3424a(f2966d).m3449i().m3418a(new C08891(this));
    }

    private void m3943c() {
        this.f2967a.m3797a();
        C0909w c0909w = this.f2972g;
        try {
            c0909w.f3094a.f3054T = Base64.encodeToString(new bb().m3488a(this.f2967a.m3799b()), 0);
        } catch (Throwable e) {
            ap.m3385a(e);
        }
        byte[] b = at.m3424a(f2966d).m3442b(c0909w);
        if (!ak.m3323a(f2966d, b)) {
            if (b == null) {
                ap.m3391d("message is null");
                return;
            }
            byte[] c = (!this.f2973h ? cp.m3775a(f2966d, AnalyticsConfig.getAppkey(f2966d), b) : cp.m3778b(f2966d, AnalyticsConfig.getAppkey(f2966d), b)).m3787c();
            at.m3424a(f2966d).m3447g();
            b = this.f2971f.m3926a(c);
            switch (b == null ? 1 : m3938a(b)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (!this.f2974i) {
                        at.m3424a(f2966d).m3438a(c);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f2967a.m3800c();
                    this.f2970e.m3971j();
                    C0909w.f3093c = 0;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f2970e.m3971j();
                default:
            }
        }
    }

    public void m3944a() {
        try {
            if (this.f2972g != null) {
                m3943c();
            } else {
                m3940b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m3945a(C0871q c0871q) {
        this.f2968b.m3826a(c0871q);
    }

    public void m3946a(C0909w c0909w) {
        this.f2972g = c0909w;
    }

    public void m3947a(boolean z) {
        this.f2973h = z;
    }

    public void m3948b(boolean z) {
        this.f2974i = z;
    }
}
