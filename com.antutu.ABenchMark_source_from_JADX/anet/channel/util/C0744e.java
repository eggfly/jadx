package anet.channel.util;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: anet.channel.util.e */
public class C0744e {
    public static final HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER;
    public static final SSLSocketFactory TRUST_ALL_SSL_SOCKET_FACTORY;
    static SSLSocketFactory f2430a;
    static HostnameVerifier f2431b;

    /* renamed from: anet.channel.util.e.a */
    private static class C0741a implements HostnameVerifier {
        private C0741a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: anet.channel.util.e.b */
    private static class C0743b {

        /* renamed from: anet.channel.util.e.b.a */
        private static class C0742a implements X509TrustManager {
            private C0742a() {
            }

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }

        private C0743b() {
        }

        public static SSLSocketFactory m2976a() {
            SSLSocketFactory sSLSocketFactory = null;
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, new TrustManager[]{new C0742a()}, null);
                sSLSocketFactory = instance.getSocketFactory();
            } catch (Throwable th) {
                ALog.m2965w("awcn.SSLTrustAllSocketFactory", "getSocketFactory error :" + th.getMessage(), sSLSocketFactory, new Object[0]);
                th.printStackTrace();
            }
            return sSLSocketFactory;
        }
    }

    static {
        ALLOW_ALL_HOSTNAME_VERIFIER = new C0741a();
        TRUST_ALL_SSL_SOCKET_FACTORY = C0743b.m2976a();
    }

    public static SSLSocketFactory m2977a() {
        return f2430a;
    }

    public static void m2978a(HostnameVerifier hostnameVerifier) {
        f2431b = hostnameVerifier;
    }

    public static void m2979a(SSLSocketFactory sSLSocketFactory) {
        f2430a = sSLSocketFactory;
    }

    public static HostnameVerifier m2980b() {
        return f2431b;
    }
}
