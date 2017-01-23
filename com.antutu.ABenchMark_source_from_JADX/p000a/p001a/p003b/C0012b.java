package p000a.p001a.p003b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import p000a.C0118k;
import p000a.p001a.C0010a;

/* renamed from: a.a.b.b */
public final class C0012b {
    private final List<C0118k> f48a;
    private int f49b;
    private boolean f50c;
    private boolean f51d;

    public C0012b(List<C0118k> list) {
        this.f49b = 0;
        this.f48a = list;
    }

    private boolean m39b(SSLSocket sSLSocket) {
        for (int i = this.f49b; i < this.f48a.size(); i++) {
            if (((C0118k) this.f48a.get(i)).m508a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public C0118k m40a(SSLSocket sSLSocket) {
        C0118k c0118k;
        int i = this.f49b;
        int size = this.f48a.size();
        for (int i2 = i; i2 < size; i2++) {
            c0118k = (C0118k) this.f48a.get(i2);
            if (c0118k.m508a(sSLSocket)) {
                this.f49b = i2 + 1;
                break;
            }
        }
        c0118k = null;
        if (c0118k == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f51d + ", modes=" + this.f48a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f50c = m39b(sSLSocket);
        C0010a.f46a.m33a(c0118k, sSLSocket, this.f51d);
        return c0118k;
    }

    public boolean m41a(IOException iOException) {
        this.f51d = true;
        return (!this.f50c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : (iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException);
    }
}
