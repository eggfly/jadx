package p000a.p001a.p009g;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import p000a.C0134u;
import p000a.C0135v;
import p000a.p001a.p008h.C0087b;
import p000a.p001a.p008h.C0096a;
import p000a.p001a.p008h.C0099e;

/* renamed from: a.a.g.e */
public class C0090e {
    private static final C0090e f336a;
    private static final Logger f337b;

    static {
        f336a = C0090e.m387a();
        f337b = Logger.getLogger(C0134u.class.getName());
    }

    private static C0090e m387a() {
        C0090e a = C0091a.m400a();
        if (a != null) {
            return a;
        }
        a = C0092b.m409a();
        if (a != null) {
            return a;
        }
        a = C0094c.m412a();
        return a == null ? new C0090e() : a;
    }

    public static List<String> m388a(List<C0135v> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C0135v c0135v = (C0135v) list.get(i);
            if (c0135v != C0135v.HTTP_1_0) {
                arrayList.add(c0135v.toString());
            }
        }
        return arrayList;
    }

    public static C0090e m389b() {
        return f336a;
    }

    static byte[] m390b(List<C0135v> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C0135v c0135v = (C0135v) list.get(i);
            if (c0135v != C0135v.HTTP_1_0) {
                buffer.writeByte(c0135v.toString().length());
                buffer.writeUtf8(c0135v.toString());
            }
        }
        return buffer.readByteArray();
    }

    public C0087b m391a(X509TrustManager x509TrustManager) {
        return new C0096a(C0099e.m439a(x509TrustManager));
    }

    public Object m392a(String str) {
        return f337b.isLoggable(Level.FINE) ? new Throwable(str) : null;
    }

    public String m393a(SSLSocket sSLSocket) {
        return null;
    }

    public void m394a(int i, String str, Throwable th) {
        f337b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void m395a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        m394a(5, str, (Throwable) obj);
    }

    public void m396a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void m397a(SSLSocket sSLSocket, String str, List<C0135v> list) {
    }

    public void m398b(SSLSocket sSLSocket) {
    }

    public boolean m399b(String str) {
        return true;
    }
}
