package p000a.p001a.p008h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* renamed from: a.a.h.e */
public abstract class C0099e {

    /* renamed from: a.a.h.e.a */
    static final class C0100a extends C0099e {
        private final X509TrustManager f366a;
        private final Method f367b;

        C0100a(X509TrustManager x509TrustManager, Method method) {
            this.f367b = method;
            this.f366a = x509TrustManager;
        }

        public X509Certificate m442a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f367b.invoke(this.f366a, new Object[]{x509Certificate});
                return trustAnchor != null ? trustAnchor.getTrustedCert() : null;
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0100a)) {
                return false;
            }
            C0100a c0100a = (C0100a) obj;
            return this.f366a.equals(c0100a.f366a) && this.f367b.equals(c0100a.f367b);
        }

        public int hashCode() {
            return this.f366a.hashCode() + (this.f367b.hashCode() * 31);
        }
    }

    /* renamed from: a.a.h.e.b */
    static final class C0101b extends C0099e {
        private final Map<X500Principal, Set<X509Certificate>> f368a;

        public C0101b(X509Certificate... x509CertificateArr) {
            this.f368a = new LinkedHashMap();
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set set = (Set) this.f368a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet(1);
                    this.f368a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        public X509Certificate m443a(X509Certificate x509Certificate) {
            Set<X509Certificate> set = (Set) this.f368a.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception e) {
                }
            }
            return null;
        }

        public boolean equals(Object obj) {
            return obj == this ? true : (obj instanceof C0101b) && ((C0101b) obj).f368a.equals(this.f368a);
        }

        public int hashCode() {
            return this.f368a.hashCode();
        }
    }

    public static C0099e m439a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C0100a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return C0099e.m440a(x509TrustManager.getAcceptedIssuers());
        }
    }

    public static C0099e m440a(X509Certificate... x509CertificateArr) {
        return new C0101b(x509CertificateArr);
    }

    public abstract X509Certificate m441a(X509Certificate x509Certificate);
}
