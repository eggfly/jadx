package p000a;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: a.ab */
public final class ab {
    final C0102a f383a;
    final Proxy f384b;
    final InetSocketAddress f385c;

    public ab(C0102a c0102a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c0102a == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f383a = c0102a;
            this.f384b = proxy;
            this.f385c = inetSocketAddress;
        }
    }

    public C0102a m458a() {
        return this.f383a;
    }

    public Proxy m459b() {
        return this.f384b;
    }

    public InetSocketAddress m460c() {
        return this.f385c;
    }

    public boolean m461d() {
        return this.f383a.f377i != null && this.f384b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return this.f383a.equals(abVar.f383a) && this.f384b.equals(abVar.f384b) && this.f385c.equals(abVar.f385c);
    }

    public int hashCode() {
        return ((((this.f383a.hashCode() + 527) * 31) + this.f384b.hashCode()) * 31) + this.f385c.hashCode();
    }
}
