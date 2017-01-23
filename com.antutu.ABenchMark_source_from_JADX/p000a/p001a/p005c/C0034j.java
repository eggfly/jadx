package p000a.p001a.p005c;

import anet.channel.util.HttpConstant;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;
import p000a.C0001s;
import p000a.C0001s.C0030a;
import p000a.C0014i;
import p000a.C0102a;
import p000a.C0113g;
import p000a.C0130r;
import p000a.C0134u;
import p000a.C0139x;
import p000a.C0139x.C0138a;
import p000a.C0140y;
import p000a.C0143z;
import p000a.ab;
import p000a.p001a.C0037c;
import p000a.p001a.p003b.C0017e;
import p000a.p001a.p003b.C0020g;
import p000a.p001a.p004e.C0047a;

/* renamed from: a.a.c.j */
public final class C0034j implements C0001s {
    private final C0134u f108a;
    private final boolean f109b;
    private C0020g f110c;
    private Object f111d;
    private volatile boolean f112e;

    public C0034j(C0134u c0134u, boolean z) {
        this.f108a = c0134u;
        this.f109b = z;
    }

    private C0102a m138a(C0130r c0130r) {
        SSLSocketFactory j;
        HostnameVerifier k;
        C0113g c0113g = null;
        if (c0130r.m594c()) {
            j = this.f108a.m629j();
            k = this.f108a.m630k();
            c0113g = this.f108a.m631l();
        } else {
            k = null;
            j = null;
        }
        return new C0102a(c0130r.m598f(), c0130r.m599g(), this.f108a.m627h(), this.f108a.m628i(), j, k, c0113g, this.f108a.m633n(), this.f108a.m623d(), this.f108a.m639t(), this.f108a.m640u(), this.f108a.m624e());
    }

    private C0139x m139a(C0143z c0143z) {
        C0140y c0140y = null;
        if (c0143z == null) {
            throw new IllegalStateException();
        }
        C0014i b = this.f110c.m88b();
        ab a = b != null ? b.m44a() : null;
        int b2 = c0143z.m697b();
        String b3 = c0143z.m694a().m663b();
        switch (b2) {
            case ErrorCode.APP_NOT_BIND /*300*/:
            case Constants.COMMAND_STOP_FOR_ELECTION /*301*/:
            case ErrorCode.DM_DEVICEID_INVALID /*302*/:
            case ErrorCode.DM_APPKEY_INVALID /*303*/:
                break;
            case HttpConstant.SC_TEMPORARY_REDIRECT /*307*/:
            case 308:
                if (!(b3.equals(SpdyRequest.GET_METHOD) || b3.equals(HttpRequest.f14572y))) {
                    return null;
                }
            case Constants.COMMAND_GET_VERSION /*401*/:
                return this.f108a.m632m().m463a(a, c0143z);
            case NetWorkError.RETRY_TIME_JS_ERROR /*407*/:
                if ((a != null ? a.m459b() : this.f108a.m623d()).type() == Type.HTTP) {
                    return this.f108a.m633n().m463a(a, c0143z);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                return !(c0143z.m694a().m665d() instanceof C0036l) ? c0143z.m694a() : null;
            default:
                return null;
        }
        if (!this.f108a.m636q()) {
            return null;
        }
        String a2 = c0143z.m695a(HttpRequest.f14565r);
        if (a2 == null) {
            return null;
        }
        C0130r c = c0143z.m694a().m661a().m593c(a2);
        if (c == null) {
            return null;
        }
        if (!c.m592b().equals(c0143z.m694a().m661a().m592b()) && !this.f108a.m635p()) {
            return null;
        }
        C0138a e = c0143z.m694a().m666e();
        if (C0029f.m114c(b3)) {
            boolean d = C0029f.m115d(b3);
            if (C0029f.m116e(b3)) {
                e.m657a(SpdyRequest.GET_METHOD, null);
            } else {
                if (d) {
                    c0140y = c0143z.m694a().m665d();
                }
                e.m657a(b3, c0140y);
            }
            if (!d) {
                e.m660b("Transfer-Encoding");
                e.m660b(HttpRequest.f14558k);
                e.m660b(MIME.CONTENT_TYPE);
            }
        }
        if (!m140a(c0143z, c)) {
            e.m660b(HttpRequest.f14555h);
        }
        return e.m654a(c).m659a();
    }

    private boolean m140a(C0143z c0143z, C0130r c0130r) {
        C0130r a = c0143z.m694a().m661a();
        return a.m598f().equals(c0130r.m598f()) && a.m599g() == c0130r.m599g() && a.m592b().equals(c0130r.m592b());
    }

    private boolean m141a(IOException iOException, boolean z) {
        boolean z2 = true;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        } else {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                z2 = false;
            }
            return z2;
        }
    }

    private boolean m142a(IOException iOException, boolean z, C0139x c0139x) {
        this.f110c.m86a(iOException);
        return !this.f108a.m637r() ? false : !(z && (c0139x.m665d() instanceof C0036l)) && m141a(iOException, z) && this.f110c.m91e();
    }

    public C0143z m143a(C0030a c0030a) {
        C0139x a = c0030a.m117a();
        this.f110c = new C0020g(this.f108a.m634o(), m138a(a.m661a()), this.f111d);
        C0143z c0143z = null;
        int i = 0;
        C0139x c0139x = a;
        while (!this.f112e) {
            try {
                C0143z a2 = ((C0031g) c0030a).m122a(c0139x, this.f110c, null, null);
                if (c0143z != null) {
                    a2 = a2.m701f().m693c(c0143z.m701f().m682a(null).m690a()).m690a();
                }
                c0139x = m139a(a2);
                if (c0139x == null) {
                    if (!this.f109b) {
                        this.f110c.m89c();
                    }
                    return a2;
                }
                C0037c.m160a(a2.m700e());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.f110c.m89c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (c0139x.m665d() instanceof C0036l) {
                    this.f110c.m89c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.m697b());
                } else {
                    if (!m140a(a2, c0139x.m661a())) {
                        this.f110c.m89c();
                        this.f110c = new C0020g(this.f108a.m634o(), m138a(c0139x.m661a()), this.f111d);
                    } else if (this.f110c.m83a() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    i = i2;
                    c0143z = a2;
                }
            } catch (C0017e e) {
                if (!m142a(e.m64a(), false, c0139x)) {
                    throw e.m64a();
                }
            } catch (IOException e2) {
                if (!m142a(e2, !(e2 instanceof C0047a), c0139x)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.f110c.m86a(null);
                this.f110c.m89c();
            }
        }
        this.f110c.m89c();
        throw new IOException("Canceled");
    }

    public void m144a(Object obj) {
        this.f111d = obj;
    }

    public boolean m145a() {
        return this.f112e;
    }
}
