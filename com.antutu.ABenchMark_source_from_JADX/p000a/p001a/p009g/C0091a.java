package p000a.p001a.p009g;

import android.util.Log;
import com.antutu.utils.RSAUtil;
import com.igexin.sdk.PushBuildConfig;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p000a.C0135v;
import p000a.p001a.C0037c;
import p000a.p001a.p008h.C0087b;

/* renamed from: a.a.g.a */
class C0091a extends C0090e {
    private final Class<?> f338a;
    private final C0095d<Socket> f339b;
    private final C0095d<Socket> f340c;
    private final C0095d<Socket> f341d;
    private final C0095d<Socket> f342e;
    private final C0089b f343f;

    /* renamed from: a.a.g.a.a */
    static final class C0088a extends C0087b {
        private final Object f331a;
        private final Method f332b;

        C0088a(Object obj, Method method) {
            this.f331a = obj;
            this.f332b = method;
        }

        public List<Certificate> m383a(List<Certificate> list, String str) {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f332b.invoke(this.f331a, new Object[]{x509CertificateArr, RSAUtil.KEY_ALGORITHM, str});
            } catch (Throwable e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0088a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: a.a.g.a.b */
    static final class C0089b {
        private final Method f333a;
        private final Method f334b;
        private final Method f335c;

        C0089b(Method method, Method method2, Method method3) {
            this.f333a = method;
            this.f334b = method2;
            this.f335c = method3;
        }

        static C0089b m384a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod(PushBuildConfig.sdk_conf_channelid, new Class[]{String.class});
                method3 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception e) {
                method2 = method3;
                method = method3;
            }
            return new C0089b(method, method2, method3);
        }

        Object m385a(String str) {
            if (this.f333a != null) {
                try {
                    Object invoke = this.f333a.invoke(null, new Object[0]);
                    this.f334b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception e) {
                }
            }
            return null;
        }

        boolean m386a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f335c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public C0091a(Class<?> cls, C0095d<Socket> c0095d, C0095d<Socket> c0095d2, C0095d<Socket> c0095d3, C0095d<Socket> c0095d4) {
        this.f343f = C0089b.m384a();
        this.f338a = cls;
        this.f339b = c0095d;
        this.f340c = c0095d2;
        this.f341d = c0095d3;
        this.f342e = c0095d4;
    }

    public static C0090e m400a() {
        Class cls;
        C0095d c0095d;
        C0095d c0095d2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        try {
            C0095d c0095d3 = new C0095d(null, "setUseSessionTickets", Boolean.TYPE);
            C0095d c0095d4 = new C0095d(null, "setHostname", String.class);
            C0095d c0095d5;
            try {
                Class.forName("android.net.Network");
                c0095d5 = new C0095d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    c0095d = new C0095d(null, "setAlpnProtocols", byte[].class);
                    c0095d2 = c0095d5;
                } catch (ClassNotFoundException e2) {
                    c0095d = null;
                    c0095d2 = c0095d5;
                    return new C0091a(cls, c0095d3, c0095d4, c0095d2, c0095d);
                }
            } catch (ClassNotFoundException e3) {
                c0095d5 = null;
                c0095d = null;
                c0095d2 = c0095d5;
                return new C0091a(cls, c0095d3, c0095d4, c0095d2, c0095d);
            }
            return new C0091a(cls, c0095d3, c0095d4, c0095d2, c0095d);
        } catch (ClassNotFoundException e4) {
            return null;
        }
    }

    public C0087b m401a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0088a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception e) {
            return super.m391a(x509TrustManager);
        }
    }

    public Object m402a(String str) {
        return this.f343f.m385a(str);
    }

    public String m403a(SSLSocket sSLSocket) {
        if (this.f341d == null || !this.f341d.m419a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f341d.m422d(sSLSocket, new Object[0]);
        return bArr != null ? new String(bArr, C0037c.f120e) : null;
    }

    public void m404a(int i, String str, Throwable th) {
        int i2 = i == 5 ? 5 : 3;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int min;
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public void m405a(String str, Object obj) {
        if (!this.f343f.m386a(obj)) {
            m404a(5, str, null);
        }
    }

    public void m406a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C0037c.m162a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (Throwable e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public void m407a(SSLSocket sSLSocket, String str, List<C0135v> list) {
        if (str != null) {
            this.f339b.m420b(sSLSocket, Boolean.valueOf(true));
            this.f340c.m420b(sSLSocket, str);
        }
        if (this.f342e != null && this.f342e.m419a((Object) sSLSocket)) {
            this.f342e.m422d(sSLSocket, C0090e.m390b((List) list));
        }
    }

    public boolean m408b(String str) {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException e) {
            return super.m399b(str);
        } catch (NoSuchMethodException e2) {
            return super.m399b(str);
        } catch (IllegalAccessException e3) {
            throw new AssertionError();
        } catch (IllegalArgumentException e4) {
            throw new AssertionError();
        } catch (InvocationTargetException e5) {
            throw new AssertionError();
        }
    }
}
