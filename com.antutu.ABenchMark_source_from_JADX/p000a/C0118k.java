package p000a;

import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p000a.p001a.C0037c;

/* renamed from: a.k */
public final class C0118k {
    public static final C0118k f490a;
    public static final C0118k f491b;
    public static final C0118k f492c;
    private static final C0114h[] f493h;
    final boolean f494d;
    final boolean f495e;
    final String[] f496f;
    final String[] f497g;

    /* renamed from: a.k.a */
    public static final class C0117a {
        boolean f486a;
        String[] f487b;
        String[] f488c;
        boolean f489d;

        public C0117a(C0118k c0118k) {
            this.f486a = c0118k.f494d;
            this.f487b = c0118k.f496f;
            this.f488c = c0118k.f497g;
            this.f489d = c0118k.f495e;
        }

        C0117a(boolean z) {
            this.f486a = z;
        }

        public C0117a m498a(boolean z) {
            if (this.f486a) {
                this.f489d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C0117a m499a(ac... acVarArr) {
            if (this.f486a) {
                String[] strArr = new String[acVarArr.length];
                for (int i = 0; i < acVarArr.length; i++) {
                    strArr[i] = acVarArr[i].f392f;
                }
                return m503b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C0117a m500a(C0114h... c0114hArr) {
            if (this.f486a) {
                String[] strArr = new String[c0114hArr.length];
                for (int i = 0; i < c0114hArr.length; i++) {
                    strArr[i] = c0114hArr[i].bi;
                }
                return m501a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0117a m501a(String... strArr) {
            if (!this.f486a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f487b = (String[]) strArr.clone();
                return this;
            }
        }

        public C0118k m502a() {
            return new C0118k(this);
        }

        public C0117a m503b(String... strArr) {
            if (!this.f486a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f488c = (String[]) strArr.clone();
                return this;
            }
        }
    }

    static {
        f493h = new C0114h[]{C0114h.aW, C0114h.ba, C0114h.aX, C0114h.bb, C0114h.bh, C0114h.bg, C0114h.ax, C0114h.aH, C0114h.ay, C0114h.aI, C0114h.af, C0114h.ag, C0114h.f428D, C0114h.f432H, C0114h.f458h};
        f490a = new C0117a(true).m500a(f493h).m499a(ac.TLS_1_3, ac.TLS_1_2, ac.TLS_1_1, ac.TLS_1_0).m498a(true).m502a();
        f491b = new C0117a(f490a).m499a(ac.TLS_1_0).m498a(true).m502a();
        f492c = new C0117a(false).m502a();
    }

    C0118k(C0117a c0117a) {
        this.f494d = c0117a.f486a;
        this.f496f = c0117a.f487b;
        this.f497g = c0117a.f488c;
        this.f495e = c0117a.f489d;
    }

    private static boolean m504a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (Object a : strArr) {
            if (C0037c.m150a((Object[]) strArr2, a) != -1) {
                return true;
            }
        }
        return false;
    }

    private C0118k m505b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites = this.f496f != null ? (String[]) C0037c.m165a(String.class, this.f496f, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] enabledProtocols = this.f497g != null ? (String[]) C0037c.m165a(String.class, this.f497g, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z && C0037c.m150a(sSLSocket.getSupportedCipherSuites(), (Object) "TLS_FALLBACK_SCSV") != -1) {
            enabledCipherSuites = C0037c.m166a(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        return new C0117a(this).m501a(enabledCipherSuites).m503b(enabledProtocols).m502a();
    }

    void m506a(SSLSocket sSLSocket, boolean z) {
        C0118k b = m505b(sSLSocket, z);
        if (b.f497g != null) {
            sSLSocket.setEnabledProtocols(b.f497g);
        }
        if (b.f496f != null) {
            sSLSocket.setEnabledCipherSuites(b.f496f);
        }
    }

    public boolean m507a() {
        return this.f494d;
    }

    public boolean m508a(SSLSocket sSLSocket) {
        return !this.f494d ? false : (this.f497g == null || C0118k.m504a(this.f497g, sSLSocket.getEnabledProtocols())) ? this.f496f == null || C0118k.m504a(this.f496f, sSLSocket.getEnabledCipherSuites()) : false;
    }

    public List<C0114h> m509b() {
        if (this.f496f == null) {
            return null;
        }
        List arrayList = new ArrayList(this.f496f.length);
        for (String a : this.f496f) {
            arrayList.add(C0114h.m491a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<ac> m510c() {
        if (this.f497g == null) {
            return null;
        }
        List arrayList = new ArrayList(this.f497g.length);
        for (String a : this.f497g) {
            arrayList.add(ac.m462a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean m511d() {
        return this.f495e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0118k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C0118k c0118k = (C0118k) obj;
        return this.f494d == c0118k.f494d ? !this.f494d || (Arrays.equals(this.f496f, c0118k.f496f) && Arrays.equals(this.f497g, c0118k.f497g) && this.f495e == c0118k.f495e) : false;
    }

    public int hashCode() {
        if (!this.f494d) {
            return 17;
        }
        return (this.f495e ? 0 : 1) + ((((Arrays.hashCode(this.f496f) + 527) * 31) + Arrays.hashCode(this.f497g)) * 31);
    }

    public String toString() {
        if (!this.f494d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f496f != null ? m509b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f497g != null ? m510c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f495e + C4233j.f14397t;
    }
}
