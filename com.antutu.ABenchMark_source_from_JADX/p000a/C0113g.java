package p000a;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;
import p000a.p001a.C0037c;
import p000a.p001a.p008h.C0087b;

/* renamed from: a.g */
public final class C0113g {
    public static final C0113g f422a;
    private final Set<C0112b> f423b;
    private final C0087b f424c;

    /* renamed from: a.g.a */
    public static final class C0111a {
        private final List<C0112b> f417a;

        public C0111a() {
            this.f417a = new ArrayList();
        }

        public C0113g m483a() {
            return new C0113g(new LinkedHashSet(this.f417a), null);
        }
    }

    /* renamed from: a.g.b */
    static final class C0112b {
        final String f418a;
        final String f419b;
        final String f420c;
        final ByteString f421d;

        boolean m484a(String str) {
            if (!this.f418a.startsWith("*.")) {
                return str.equals(this.f419b);
            }
            return str.regionMatches(false, str.indexOf(46) + 1, this.f419b, 0, this.f419b.length());
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0112b) && this.f418a.equals(((C0112b) obj).f418a) && this.f420c.equals(((C0112b) obj).f420c) && this.f421d.equals(((C0112b) obj).f421d);
        }

        public int hashCode() {
            return ((((this.f418a.hashCode() + 527) * 31) + this.f420c.hashCode()) * 31) + this.f421d.hashCode();
        }

        public String toString() {
            return this.f420c + this.f421d.base64();
        }
    }

    static {
        f422a = new C0111a().m483a();
    }

    C0113g(Set<C0112b> set, C0087b c0087b) {
        this.f423b = set;
        this.f424c = c0087b;
    }

    public static String m485a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + C0113g.m487b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString m486a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static ByteString m487b(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    C0113g m488a(C0087b c0087b) {
        return C0037c.m163a(this.f424c, (Object) c0087b) ? this : new C0113g(this.f423b, c0087b);
    }

    List<C0112b> m489a(String str) {
        List<C0112b> emptyList = Collections.emptyList();
        for (C0112b c0112b : this.f423b) {
            if (c0112b.m484a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(c0112b);
            }
        }
        return emptyList;
    }

    public void m490a(String str, List<Certificate> list) {
        List a = m489a(str);
        if (!a.isEmpty()) {
            List a2;
            int i;
            if (this.f424c != null) {
                a2 = this.f424c.m382a(list, str);
            }
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) a2.get(i2);
                int size2 = a.size();
                int i3 = 0;
                Object obj = null;
                Object obj2 = null;
                while (i3 < size2) {
                    C0112b c0112b = (C0112b) a.get(i3);
                    if (c0112b.f420c.equals("sha256/")) {
                        if (obj == null) {
                            obj = C0113g.m487b(x509Certificate);
                        }
                        if (c0112b.f421d.equals(obj)) {
                            return;
                        }
                    } else if (c0112b.f420c.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = C0113g.m486a(x509Certificate);
                        }
                        if (c0112b.f421d.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    Object obj3 = obj;
                    i3++;
                    obj2 = obj2;
                    obj = obj3;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size3 = a2.size();
            for (i = 0; i < size3; i++) {
                Certificate certificate = (X509Certificate) a2.get(i);
                append.append("\n    ").append(C0113g.m485a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            size3 = a.size();
            for (i = 0; i < size3; i++) {
                append.append("\n    ").append((C0112b) a.get(i));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof C0113g) && C0037c.m163a(this.f424c, ((C0113g) obj).f424c) && this.f423b.equals(((C0113g) obj).f423b);
        return z;
    }

    public int hashCode() {
        return ((this.f424c != null ? this.f424c.hashCode() : 0) * 31) + this.f423b.hashCode();
    }
}
