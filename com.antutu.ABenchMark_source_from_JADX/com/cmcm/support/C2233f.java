package com.cmcm.support;

import com.cmcm.support.p116a.C2188a;
import com.cmcm.support.p116a.C2188a.C2186a;
import com.cmcm.support.p116a.C2188a.C2187b;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.cmcm.support.f */
public class C2233f {
    private C2188a<C2232b> f7699a;
    private C2229e f7700b;

    /* renamed from: com.cmcm.support.f.1 */
    class C22301 implements C2187b<C2232b> {
        final /* synthetic */ C2233f f7692a;

        C22301(C2233f c2233f) {
            this.f7692a = c2233f;
        }

        public void m8409a(C2232b c2232b) {
            this.f7692a.m8412a(c2232b);
        }
    }

    /* renamed from: com.cmcm.support.f.a */
    public interface C2231a {
        void m8411a(boolean z);
    }

    /* renamed from: com.cmcm.support.f.b */
    private static class C2232b {
        String f7693a;
        String f7694b;
        int f7695c;
        int f7696d;
        boolean f7697e;
        C2231a f7698f;

        public C2232b(String str, String str2) {
            this.f7693a = null;
            this.f7694b = null;
            this.f7695c = 0;
            this.f7696d = 0;
            this.f7697e = false;
            this.f7693a = str;
            this.f7694b = str2;
        }
    }

    public C2233f() {
        this.f7699a = null;
        this.f7700b = null;
    }

    private boolean m8412a(C2232b c2232b) {
        boolean z = false;
        switch (c2232b.f7696d) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                z = this.f7700b.m8402a(c2232b.f7693a, c2232b.f7694b, c2232b.f7697e);
                if (c2232b.f7698f != null) {
                    c2232b.f7698f.m8411a(z);
                    break;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                z = this.f7700b.m8399a(Integer.parseInt(c2232b.f7694b), c2232b.f7695c, c2232b.f7693a);
                if (c2232b.f7698f != null) {
                    c2232b.f7698f.m8411a(z);
                    break;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                z = this.f7700b.m8404b(c2232b.f7695c);
                if (c2232b.f7698f != null) {
                    c2232b.f7698f.m8411a(z);
                    break;
                }
                break;
        }
        return z;
    }

    public void m8414a(int i) {
        if (this.f7699a != null) {
            Object c2232b = new C2232b(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            c2232b.f7695c = i;
            c2232b.f7696d = 2;
            this.f7699a.m8230a(c2232b);
        }
    }

    public void m8415a(String str, String str2) {
        m8416a(str, str2, false);
    }

    public void m8416a(String str, String str2, boolean z) {
        if (this.f7699a != null) {
            Object c2232b = new C2232b(str, str2);
            c2232b.f7696d = 0;
            c2232b.f7697e = z;
            this.f7699a.m8230a(c2232b);
        }
    }

    public boolean m8417a(C1821b c1821b) {
        return m8418a(c1821b, null);
    }

    public boolean m8418a(C1821b c1821b, C2198a c2198a) {
        this.f7700b = new C2229e();
        if (this.f7700b == null || !this.f7700b.m8400a(c1821b, c2198a)) {
            return false;
        }
        this.f7699a = new C2186a().m8221a(10000).m8222a(new C22301(this)).m8223a();
        m8414a(2);
        return true;
    }
}
