package p000a.p001a.p003b;

import cn.sharesdk.framework.Platform;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import p000a.C0102a;
import p000a.C0130r;
import p000a.ab;
import p000a.p001a.C0037c;

/* renamed from: a.a.b.f */
public final class C0018f {
    private final C0102a f69a;
    private final C0016d f70b;
    private Proxy f71c;
    private InetSocketAddress f72d;
    private List<Proxy> f73e;
    private int f74f;
    private List<InetSocketAddress> f75g;
    private int f76h;
    private final List<ab> f77i;

    public C0018f(C0102a c0102a, C0016d c0016d) {
        this.f73e = Collections.emptyList();
        this.f75g = Collections.emptyList();
        this.f77i = new ArrayList();
        this.f69a = c0102a;
        this.f70b = c0016d;
        m67a(c0102a.m444a(), c0102a.m451h());
    }

    static String m66a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void m67a(C0130r c0130r, Proxy proxy) {
        if (proxy != null) {
            this.f73e = Collections.singletonList(proxy);
        } else {
            List select = this.f69a.m450g().select(c0130r.m591a());
            if (select == null || select.isEmpty()) {
                select = C0037c.m156a(Proxy.NO_PROXY);
            } else {
                select = C0037c.m155a(select);
            }
            this.f73e = select;
        }
        this.f74f = 0;
    }

    private void m68a(Proxy proxy) {
        int g;
        String str;
        this.f75g = new ArrayList();
        String f;
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            f = this.f69a.m444a().m598f();
            g = this.f69a.m444a().m599g();
            str = f;
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                f = C0018f.m66a(inetSocketAddress);
                g = inetSocketAddress.getPort();
                str = f;
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (g < 1 || g > Platform.CUSTOMER_ACTION_MASK) {
            throw new SocketException("No route to " + str + ":" + g + "; port is out of range");
        }
        if (proxy.type() == Type.SOCKS) {
            this.f75g.add(InetSocketAddress.createUnresolved(str, g));
        } else {
            List a = this.f69a.m445b().m535a(str);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                this.f75g.add(new InetSocketAddress((InetAddress) a.get(i), g));
            }
        }
        this.f76h = 0;
    }

    private boolean m69c() {
        return this.f74f < this.f73e.size();
    }

    private Proxy m70d() {
        if (m69c()) {
            List list = this.f73e;
            int i = this.f74f;
            this.f74f = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m68a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f69a.m444a().m598f() + "; exhausted proxy configurations: " + this.f73e);
    }

    private boolean m71e() {
        return this.f76h < this.f75g.size();
    }

    private InetSocketAddress m72f() {
        if (m71e()) {
            List list = this.f75g;
            int i = this.f76h;
            this.f76h = i + 1;
            return (InetSocketAddress) list.get(i);
        }
        throw new SocketException("No route to " + this.f69a.m444a().m598f() + "; exhausted inet socket addresses: " + this.f75g);
    }

    private boolean m73g() {
        return !this.f77i.isEmpty();
    }

    private ab m74h() {
        return (ab) this.f77i.remove(0);
    }

    public void m75a(ab abVar, IOException iOException) {
        if (!(abVar.m459b().type() == Type.DIRECT || this.f69a.m450g() == null)) {
            this.f69a.m450g().connectFailed(this.f69a.m444a().m591a(), abVar.m459b().address(), iOException);
        }
        this.f70b.m60a(abVar);
    }

    public boolean m76a() {
        return m71e() || m69c() || m73g();
    }

    public ab m77b() {
        if (!m71e()) {
            if (m69c()) {
                this.f71c = m70d();
            } else if (m73g()) {
                return m74h();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.f72d = m72f();
        ab abVar = new ab(this.f69a, this.f71c, this.f72d);
        if (!this.f70b.m62c(abVar)) {
            return abVar;
        }
        this.f77i.add(abVar);
        return m77b();
    }
}
