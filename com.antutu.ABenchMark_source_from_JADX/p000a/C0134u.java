package p000a;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000a.C0127q.C0126a;
import p000a.p001a.C0010a;
import p000a.p001a.C0037c;
import p000a.p001a.p002a.C0009e;
import p000a.p001a.p003b.C0015c;
import p000a.p001a.p003b.C0016d;
import p000a.p001a.p003b.C0020g;
import p000a.p001a.p008h.C0087b;
import p000a.p001a.p008h.C0098d;

/* renamed from: a.u */
public class C0134u implements Cloneable {
    static final List<C0135v> f582a;
    static final List<C0118k> f583b;
    final int f584A;
    final int f585B;
    final C0122n f586c;
    final Proxy f587d;
    final List<C0135v> f588e;
    final List<C0118k> f589f;
    final List<C0001s> f590g;
    final List<C0001s> f591h;
    final ProxySelector f592i;
    final C0120m f593j;
    final C0106c f594k;
    final C0009e f595l;
    final SocketFactory f596m;
    final SSLSocketFactory f597n;
    final C0087b f598o;
    final HostnameVerifier f599p;
    final C0113g f600q;
    final C0104b f601r;
    final C0104b f602s;
    final C0116j f603t;
    final C0123o f604u;
    final boolean f605v;
    final boolean f606w;
    final boolean f607x;
    final int f608y;
    final int f609z;

    /* renamed from: a.u.1 */
    static class C01321 extends C0010a {
        C01321() {
        }

        public C0015c m610a(C0116j c0116j, C0102a c0102a, C0020g c0020g) {
            return c0116j.m495a(c0102a, c0020g);
        }

        public C0016d m611a(C0116j c0116j) {
            return c0116j.f480a;
        }

        public void m612a(C0118k c0118k, SSLSocket sSLSocket, boolean z) {
            c0118k.m506a(sSLSocket, z);
        }

        public void m613a(C0126a c0126a, String str) {
            c0126a.m541a(str);
        }

        public void m614a(C0126a c0126a, String str, String str2) {
            c0126a.m545b(str, str2);
        }

        public boolean m615a(C0116j c0116j, C0015c c0015c) {
            return c0116j.m497b(c0015c);
        }

        public void m616b(C0116j c0116j, C0015c c0015c) {
            c0116j.m496a(c0015c);
        }
    }

    /* renamed from: a.u.a */
    public static final class C0133a {
        C0122n f556a;
        Proxy f557b;
        List<C0135v> f558c;
        List<C0118k> f559d;
        final List<C0001s> f560e;
        final List<C0001s> f561f;
        ProxySelector f562g;
        C0120m f563h;
        C0106c f564i;
        C0009e f565j;
        SocketFactory f566k;
        SSLSocketFactory f567l;
        C0087b f568m;
        HostnameVerifier f569n;
        C0113g f570o;
        C0104b f571p;
        C0104b f572q;
        C0116j f573r;
        C0123o f574s;
        boolean f575t;
        boolean f576u;
        boolean f577v;
        int f578w;
        int f579x;
        int f580y;
        int f581z;

        public C0133a() {
            this.f560e = new ArrayList();
            this.f561f = new ArrayList();
            this.f556a = new C0122n();
            this.f558c = C0134u.f582a;
            this.f559d = C0134u.f583b;
            this.f562g = ProxySelector.getDefault();
            this.f563h = C0120m.f511a;
            this.f566k = SocketFactory.getDefault();
            this.f569n = C0098d.f365a;
            this.f570o = C0113g.f422a;
            this.f571p = C0104b.f393a;
            this.f572q = C0104b.f393a;
            this.f573r = new C0116j();
            this.f574s = C0123o.f519a;
            this.f575t = true;
            this.f576u = true;
            this.f577v = true;
            this.f578w = 10000;
            this.f579x = 10000;
            this.f580y = 10000;
            this.f581z = 0;
        }
    }

    static {
        f582a = C0037c.m156a(C0135v.HTTP_2, C0135v.HTTP_1_1);
        f583b = C0037c.m156a(C0118k.f490a, C0118k.f491b, C0118k.f492c);
        C0010a.f46a = new C01321();
    }

    public C0134u() {
        this(new C0133a());
    }

    C0134u(C0133a c0133a) {
        this.f586c = c0133a.f556a;
        this.f587d = c0133a.f557b;
        this.f588e = c0133a.f558c;
        this.f589f = c0133a.f559d;
        this.f590g = C0037c.m155a(c0133a.f560e);
        this.f591h = C0037c.m155a(c0133a.f561f);
        this.f592i = c0133a.f562g;
        this.f593j = c0133a.f563h;
        this.f594k = c0133a.f564i;
        this.f595l = c0133a.f565j;
        this.f596m = c0133a.f566k;
        Object obj = null;
        for (C0118k a : this.f589f) {
            Object obj2 = (obj != null || a.m507a()) ? 1 : null;
            obj = obj2;
        }
        if (c0133a.f567l != null || obj == null) {
            this.f597n = c0133a.f567l;
            this.f598o = c0133a.f568m;
        } else {
            X509TrustManager x = m618x();
            this.f597n = m617a(x);
            this.f598o = C0087b.m381a(x);
        }
        this.f599p = c0133a.f569n;
        this.f600q = c0133a.f570o.m488a(this.f598o);
        this.f601r = c0133a.f571p;
        this.f602s = c0133a.f572q;
        this.f603t = c0133a.f573r;
        this.f604u = c0133a.f574s;
        this.f605v = c0133a.f575t;
        this.f606w = c0133a.f576u;
        this.f607x = c0133a.f577v;
        this.f608y = c0133a.f578w;
        this.f609z = c0133a.f579x;
        this.f584A = c0133a.f580y;
        this.f585B = c0133a.f581z;
    }

    private SSLSocketFactory m617a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    private X509TrustManager m618x() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    public int m619a() {
        return this.f608y;
    }

    public C0109e m620a(C0139x c0139x) {
        return new C0137w(this, c0139x, false);
    }

    public int m621b() {
        return this.f609z;
    }

    public int m622c() {
        return this.f584A;
    }

    public Proxy m623d() {
        return this.f587d;
    }

    public ProxySelector m624e() {
        return this.f592i;
    }

    public C0120m m625f() {
        return this.f593j;
    }

    C0009e m626g() {
        return this.f594k != null ? this.f594k.f394a : this.f595l;
    }

    public C0123o m627h() {
        return this.f604u;
    }

    public SocketFactory m628i() {
        return this.f596m;
    }

    public SSLSocketFactory m629j() {
        return this.f597n;
    }

    public HostnameVerifier m630k() {
        return this.f599p;
    }

    public C0113g m631l() {
        return this.f600q;
    }

    public C0104b m632m() {
        return this.f602s;
    }

    public C0104b m633n() {
        return this.f601r;
    }

    public C0116j m634o() {
        return this.f603t;
    }

    public boolean m635p() {
        return this.f605v;
    }

    public boolean m636q() {
        return this.f606w;
    }

    public boolean m637r() {
        return this.f607x;
    }

    public C0122n m638s() {
        return this.f586c;
    }

    public List<C0135v> m639t() {
        return this.f588e;
    }

    public List<C0118k> m640u() {
        return this.f589f;
    }

    public List<C0001s> m641v() {
        return this.f590g;
    }

    public List<C0001s> m642w() {
        return this.f591h;
    }
}
