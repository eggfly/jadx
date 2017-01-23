package p000a;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p000a.p001a.C0037c;

/* renamed from: a.p */
public final class C0125p {
    private final ac f520a;
    private final C0114h f521b;
    private final List<Certificate> f522c;
    private final List<Certificate> f523d;

    private C0125p(ac acVar, C0114h c0114h, List<Certificate> list, List<Certificate> list2) {
        this.f520a = acVar;
        this.f521b = c0114h;
        this.f522c = list;
        this.f523d = list2;
    }

    public static C0125p m537a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        C0114h a = C0114h.m491a(cipherSuite);
        cipherSuite = sSLSession.getProtocol();
        if (cipherSuite == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        ac a2 = ac.m462a(cipherSuite);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        List a3 = peerCertificates != null ? C0037c.m156a(peerCertificates) : Collections.emptyList();
        Object[] localCertificates = sSLSession.getLocalCertificates();
        return new C0125p(a2, a, a3, localCertificates != null ? C0037c.m156a(localCertificates) : Collections.emptyList());
    }

    public C0114h m538a() {
        return this.f521b;
    }

    public List<Certificate> m539b() {
        return this.f522c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0125p)) {
            return false;
        }
        C0125p c0125p = (C0125p) obj;
        return C0037c.m163a(this.f521b, c0125p.f521b) && this.f521b.equals(c0125p.f521b) && this.f522c.equals(c0125p.f522c) && this.f523d.equals(c0125p.f523d);
    }

    public int hashCode() {
        return (((((((this.f520a != null ? this.f520a.hashCode() : 0) + 527) * 31) + this.f521b.hashCode()) * 31) + this.f522c.hashCode()) * 31) + this.f523d.hashCode();
    }
}
