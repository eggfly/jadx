package p000a.p001a.p003b;

import anet.channel.util.HttpConstant;
import com.igexin.sdk.PushBuildConfig;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import p000a.C0014i;
import p000a.C0102a;
import p000a.C0113g;
import p000a.C0118k;
import p000a.C0125p;
import p000a.C0130r;
import p000a.C0135v;
import p000a.C0139x;
import p000a.C0139x.C0138a;
import p000a.C0143z;
import p000a.ab;
import p000a.p001a.C0037c;
import p000a.p001a.C0046d;
import p000a.p001a.p004e.C0048b;
import p000a.p001a.p004e.C0070g;
import p000a.p001a.p004e.C0070g.C0013b;
import p000a.p001a.p004e.C0070g.C0063a;
import p000a.p001a.p004e.C0076i;
import p000a.p001a.p005c.C0028e;
import p000a.p001a.p006d.C0045a;
import p000a.p001a.p008h.C0098d;
import p000a.p001a.p009g.C0090e;

/* renamed from: a.a.b.c */
public final class C0015c extends C0013b implements C0014i {
    public Socket f53a;
    public volatile C0070g f54b;
    public int f55c;
    public BufferedSource f56d;
    public BufferedSink f57e;
    public int f58f;
    public final List<Reference<C0020g>> f59g;
    public boolean f60h;
    public long f61i;
    private final ab f62k;
    private Socket f63l;
    private C0125p f64m;
    private C0135v f65n;

    public C0015c(ab abVar) {
        this.f59g = new ArrayList();
        this.f61i = Long.MAX_VALUE;
        this.f62k = abVar;
    }

    private C0139x m45a(int i, int i2, C0139x c0139x, C0130r c0130r) {
        String str = "CONNECT " + C0037c.m151a(c0130r, true) + " HTTP/1.1";
        C0143z a;
        do {
            C0045a c0045a = new C0045a(null, null, this.f56d, this.f57e);
            this.f56d.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.f57e.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            c0045a.m180a(c0139x.m664c(), str);
            c0045a.m179a();
            a = c0045a.m185c().m686a(c0139x).m690a();
            long a2 = C0028e.m107a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            Source b = c0045a.m184b(a2);
            C0037c.m169b(b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b.close();
            switch (a.m697b()) {
                case Constants.COMMAND_HANDSHAKE /*200*/:
                    if (this.f56d.buffer().exhausted() && this.f57e.buffer().exhausted()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case NetWorkError.RETRY_TIME_JS_ERROR /*407*/:
                    c0139x = this.f62k.m458a().m447d().m463a(this.f62k, a);
                    if (c0139x != null) {
                        break;
                    }
                    throw new IOException("Failed to authenticate with proxy");
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + a.m697b());
            }
        } while (!"close".equalsIgnoreCase(a.m695a(HttpConstant.CONNECTION)));
        return c0139x;
    }

    private void m46a(int i, int i2) {
        Proxy b = this.f62k.m459b();
        Socket createSocket = (b.type() == Type.DIRECT || b.type() == Type.HTTP) ? this.f62k.m458a().m446c().createSocket() : new Socket(b);
        this.f63l = createSocket;
        this.f63l.setSoTimeout(i2);
        try {
            C0090e.m389b().m396a(this.f63l, this.f62k.m460c(), i);
            this.f56d = Okio.buffer(Okio.source(this.f63l));
            this.f57e = Okio.buffer(Okio.sink(this.f63l));
        } catch (Throwable e) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f62k.m460c());
            connectException.initCause(e);
            throw connectException;
        }
    }

    private void m47a(int i, int i2, int i3, C0012b c0012b) {
        C0139x e = m51e();
        C0130r a = e.m661a();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                break;
            }
            m46a(i, i2);
            e = m45a(i2, i3, e, a);
            if (e == null) {
                m48a(i2, i3, c0012b);
                return;
            }
            C0037c.m161a(this.f63l);
            this.f63l = null;
            this.f57e = null;
            this.f56d = null;
        }
        throw new ProtocolException("Too many tunnel connections attempted: " + 21);
    }

    private void m48a(int i, int i2, C0012b c0012b) {
        if (this.f62k.m458a().m452i() != null) {
            m50b(i, i2, c0012b);
        } else {
            this.f65n = C0135v.HTTP_1_1;
            this.f53a = this.f63l;
        }
        if (this.f65n == C0135v.HTTP_2) {
            this.f53a.setSoTimeout(0);
            C0070g a = new C0063a(true).m237a(this.f53a, this.f62k.m458a().m444a().m598f(), this.f56d, this.f57e).m236a(this).m238a();
            a.m285c();
            this.f58f = a.m266a();
            this.f54b = a;
            return;
        }
        this.f58f = 1;
    }

    private void m49b(int i, int i2, int i3, C0012b c0012b) {
        m46a(i, i2);
        m48a(i2, i3, c0012b);
    }

    private void m50b(int i, int i2, C0012b c0012b) {
        Throwable th;
        Socket socket;
        AssertionError assertionError;
        Throwable th2;
        String str = null;
        C0102a a = this.f62k.m458a();
        try {
            Socket socket2 = (SSLSocket) a.m452i().createSocket(this.f63l, a.m444a().m598f(), a.m444a().m599g(), true);
            try {
                C0118k a2 = c0012b.m40a((SSLSocket) socket2);
                if (a2.m511d()) {
                    C0090e.m389b().m397a((SSLSocket) socket2, a.m444a().m598f(), a.m448e());
                }
                socket2.startHandshake();
                C0125p a3 = C0125p.m537a(socket2.getSession());
                if (a.m453j().verify(a.m444a().m598f(), socket2.getSession())) {
                    a.m454k().m490a(a.m444a().m598f(), a3.m539b());
                    if (a2.m511d()) {
                        str = C0090e.m389b().m393a((SSLSocket) socket2);
                    }
                    this.f53a = socket2;
                    this.f56d = Okio.buffer(Okio.source(this.f53a));
                    this.f57e = Okio.buffer(Okio.sink(this.f53a));
                    this.f64m = a3;
                    this.f65n = str != null ? C0135v.m643a(str) : C0135v.HTTP_1_1;
                    if (socket2 != null) {
                        C0090e.m389b().m398b((SSLSocket) socket2);
                        return;
                    }
                    return;
                }
                Certificate certificate = (X509Certificate) a3.m539b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + a.m444a().m598f() + " not verified:\n    certificate: " + C0113g.m485a(certificate) + "\n    DN: " + certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + C0098d.m433a(certificate));
            } catch (Throwable e) {
                th = e;
                socket = socket2;
                assertionError = th;
                try {
                    if (C0037c.m162a(assertionError)) {
                        throw new IOException(assertionError);
                    }
                    throw assertionError;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (Throwable e2) {
                th = e2;
                socket = socket2;
                th2 = th;
                if (socket != null) {
                    C0090e.m389b().m398b((SSLSocket) socket);
                }
                C0037c.m161a(socket);
                throw th2;
            }
        } catch (AssertionError e3) {
            assertionError = e3;
            if (C0037c.m162a(assertionError)) {
                throw new IOException(assertionError);
            }
            throw assertionError;
        }
    }

    private C0139x m51e() {
        return new C0138a().m654a(this.f62k.m458a().m444a()).m658a(HttpConstant.HOST, C0037c.m151a(this.f62k.m458a().m444a(), true)).m658a("Proxy-Connection", "Keep-Alive").m658a(HttpRequest.f14569v, C0046d.m189a()).m659a();
    }

    public ab m52a() {
        return this.f62k;
    }

    public void m53a(int i, int i2, int i3, List<C0118k> list, boolean z) {
        if (this.f65n != null) {
            throw new IllegalStateException("already connected");
        }
        C0012b c0012b = new C0012b(list);
        if (this.f62k.m458a().m452i() == null) {
            if (list.contains(C0118k.f492c)) {
                String f = this.f62k.m458a().m444a().m598f();
                if (!C0090e.m389b().m399b(f)) {
                    throw new C0017e(new UnknownServiceException("CLEARTEXT communication to " + f + " not permitted by network security policy"));
                }
            }
            throw new C0017e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
        }
        C0017e c0017e = null;
        while (this.f65n == null) {
            try {
                if (this.f62k.m461d()) {
                    m47a(i, i2, i3, c0012b);
                } else {
                    m49b(i, i2, i3, c0012b);
                }
            } catch (IOException e) {
                C0037c.m161a(this.f53a);
                C0037c.m161a(this.f63l);
                this.f53a = null;
                this.f63l = null;
                this.f56d = null;
                this.f57e = null;
                this.f64m = null;
                this.f65n = null;
                if (c0017e == null) {
                    c0017e = new C0017e(e);
                } else {
                    c0017e.m65a(e);
                }
                if (!z || !c0012b.m41a(e)) {
                    throw c0017e;
                }
            }
        }
    }

    public void m54a(C0070g c0070g) {
        this.f58f = c0070g.m266a();
    }

    public void m55a(C0076i c0076i) {
        c0076i.m313a(C0048b.REFUSED_STREAM);
    }

    public boolean m56a(boolean z) {
        if (this.f53a.isClosed() || this.f53a.isInputShutdown() || this.f53a.isOutputShutdown()) {
            return false;
        }
        if (this.f54b != null) {
            return !this.f54b.m287d();
        } else {
            if (!z) {
                return true;
            }
            int soTimeout;
            try {
                soTimeout = this.f53a.getSoTimeout();
                this.f53a.setSoTimeout(1);
                if (this.f56d.exhausted()) {
                    this.f53a.setSoTimeout(soTimeout);
                    return false;
                }
                this.f53a.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException e) {
                return true;
            } catch (IOException e2) {
                return false;
            } catch (Throwable th) {
                this.f53a.setSoTimeout(soTimeout);
            }
        }
    }

    public Socket m57b() {
        return this.f53a;
    }

    public C0125p m58c() {
        return this.f64m;
    }

    public boolean m59d() {
        return this.f54b != null;
    }

    public String toString() {
        return "Connection{" + this.f62k.m458a().m444a().m598f() + ":" + this.f62k.m458a().m444a().m599g() + ", proxy=" + this.f62k.m459b() + " hostAddress=" + this.f62k.m460c() + " cipherSuite=" + (this.f64m != null ? this.f64m.m538a() : PushBuildConfig.sdk_conf_debug_level) + " protocol=" + this.f65n + '}';
    }
}
