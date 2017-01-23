package p000a.p001a.p008h;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: a.a.h.a */
public final class C0096a extends C0087b {
    private final C0099e f357a;

    public C0096a(C0099e c0099e) {
        this.f357a = c0099e;
    }

    private boolean m423a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }

    public List<Certificate> m424a(List<Certificate> list, String str) {
        Deque arrayDeque = new ArrayDeque(list);
        List<Certificate> arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        int i = 0;
        Object obj = null;
        while (i < 9) {
            Object obj2;
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate a = this.f357a.m441a(x509Certificate);
            if (a != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(a)) {
                    arrayList.add(a);
                }
                if (m423a(a, a)) {
                    return arrayList;
                }
                obj2 = 1;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    a = (X509Certificate) it.next();
                    if (m423a(x509Certificate, a)) {
                        it.remove();
                        arrayList.add(a);
                        obj2 = obj;
                    }
                }
                if (obj != null) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            i++;
            obj = obj2;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj instanceof C0096a) && ((C0096a) obj).f357a.equals(this.f357a);
    }

    public int hashCode() {
        return this.f357a.hashCode();
    }
}
