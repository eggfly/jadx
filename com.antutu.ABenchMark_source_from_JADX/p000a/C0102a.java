package p000a;

import anet.channel.util.HttpConstant;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p000a.C0130r.C0129a;
import p000a.p001a.C0037c;

/* renamed from: a.a */
public final class C0102a {
    final C0130r f369a;
    final C0123o f370b;
    final SocketFactory f371c;
    final C0104b f372d;
    final List<C0135v> f373e;
    final List<C0118k> f374f;
    final ProxySelector f375g;
    final Proxy f376h;
    final SSLSocketFactory f377i;
    final HostnameVerifier f378j;
    final C0113g f379k;

    public C0102a(String str, int i, C0123o c0123o, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C0113g c0113g, C0104b c0104b, Proxy proxy, List<C0135v> list, List<C0118k> list2, ProxySelector proxySelector) {
        this.f369a = new C0129a().m570a(sSLSocketFactory != null ? HttpConstant.HTTPS : HttpConstant.HTTP).m575d(str).m569a(i).m574c();
        if (c0123o == null) {
            throw new NullPointerException("dns == null");
        }
        this.f370b = c0123o;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f371c = socketFactory;
        if (c0104b == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f372d = c0104b;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f373e = C0037c.m155a((List) list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f374f = C0037c.m155a((List) list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f375g = proxySelector;
        this.f376h = proxy;
        this.f377i = sSLSocketFactory;
        this.f378j = hostnameVerifier;
        this.f379k = c0113g;
    }

    public C0130r m444a() {
        return this.f369a;
    }

    public C0123o m445b() {
        return this.f370b;
    }

    public SocketFactory m446c() {
        return this.f371c;
    }

    public C0104b m447d() {
        return this.f372d;
    }

    public List<C0135v> m448e() {
        return this.f373e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0102a)) {
            return false;
        }
        C0102a c0102a = (C0102a) obj;
        return this.f369a.equals(c0102a.f369a) && this.f370b.equals(c0102a.f370b) && this.f372d.equals(c0102a.f372d) && this.f373e.equals(c0102a.f373e) && this.f374f.equals(c0102a.f374f) && this.f375g.equals(c0102a.f375g) && C0037c.m163a(this.f376h, c0102a.f376h) && C0037c.m163a(this.f377i, c0102a.f377i) && C0037c.m163a(this.f378j, c0102a.f378j) && C0037c.m163a(this.f379k, c0102a.f379k);
    }

    public List<C0118k> m449f() {
        return this.f374f;
    }

    public ProxySelector m450g() {
        return this.f375g;
    }

    public Proxy m451h() {
        return this.f376h;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f378j != null ? this.f378j.hashCode() : 0) + (((this.f377i != null ? this.f377i.hashCode() : 0) + (((this.f376h != null ? this.f376h.hashCode() : 0) + ((((((((((((this.f369a.hashCode() + 527) * 31) + this.f370b.hashCode()) * 31) + this.f372d.hashCode()) * 31) + this.f373e.hashCode()) * 31) + this.f374f.hashCode()) * 31) + this.f375g.hashCode()) * 31)) * 31)) * 31)) * 31;
        if (this.f379k != null) {
            i = this.f379k.hashCode();
        }
        return hashCode + i;
    }

    public SSLSocketFactory m452i() {
        return this.f377i;
    }

    public HostnameVerifier m453j() {
        return this.f378j;
    }

    public C0113g m454k() {
        return this.f379k;
    }
}
