package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.C0532u;
import android.support.v7.widget.ar.C0583a;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: android.support.v7.widget.e */
class C0605e implements C0583a {
    final ArrayList<C0604b> f2047a;
    final ArrayList<C0604b> f2048b;
    final C0507a f2049c;
    Runnable f2050d;
    final boolean f2051e;
    final ar f2052f;
    private Pool<C0604b> f2053g;
    private int f2054h;

    /* renamed from: android.support.v7.widget.e.a */
    interface C0507a {
        C0532u m1773a(int i);

        void m1774a(int i, int i2);

        void m1775a(int i, int i2, Object obj);

        void m1776a(C0604b c0604b);

        void m1777b(int i, int i2);

        void m1778b(C0604b c0604b);

        void m1779c(int i, int i2);

        void m1780d(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.e.b */
    static class C0604b {
        int f2043a;
        int f2044b;
        Object f2045c;
        int f2046d;

        C0604b(int i, int i2, int i3, Object obj) {
            this.f2043a = i;
            this.f2044b = i2;
            this.f2046d = i3;
            this.f2045c = obj;
        }

        String m2615a() {
            switch (this.f2043a) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return "add";
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return "rm";
                case SpdyProtocol.QUIC /*4*/:
                    return "up";
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    return "mv";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0604b c0604b = (C0604b) obj;
            return this.f2043a != c0604b.f2043a ? false : (this.f2043a == 8 && Math.abs(this.f2046d - this.f2044b) == 1 && this.f2046d == c0604b.f2044b && this.f2044b == c0604b.f2046d) ? true : this.f2046d != c0604b.f2046d ? false : this.f2044b != c0604b.f2044b ? false : this.f2045c != null ? this.f2045c.equals(c0604b.f2045c) : c0604b.f2045c == null;
        }

        public int hashCode() {
            return (((this.f2043a * 31) + this.f2044b) * 31) + this.f2046d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m2615a() + ",s:" + this.f2044b + "c:" + this.f2046d + ",p:" + this.f2045c + "]";
        }
    }

    C0605e(C0507a c0507a) {
        this(c0507a, false);
    }

    C0605e(C0507a c0507a, boolean z) {
        this.f2053g = new SimplePool(30);
        this.f2047a = new ArrayList();
        this.f2048b = new ArrayList();
        this.f2054h = 0;
        this.f2049c = c0507a;
        this.f2051e = z;
        this.f2052f = new ar(this);
    }

    private void m2616b(C0604b c0604b) {
        m2623g(c0604b);
    }

    private void m2617c(C0604b c0604b) {
        int i = c0604b.f2044b;
        int i2 = c0604b.f2044b + c0604b.f2046d;
        Object obj = -1;
        int i3 = c0604b.f2044b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f2049c.m1773a(i3) != null || m2620d(i3)) {
                if (obj == null) {
                    m2621e(m2625a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m2623g(m2625a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c0604b.f2046d) {
            m2627a(c0604b);
            c0604b = m2625a(2, i, i4, null);
        }
        if (obj == null) {
            m2621e(c0604b);
        } else {
            m2623g(c0604b);
        }
    }

    private int m2618d(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f2048b.size() - 1; size >= 0; size--) {
            C0604b c0604b = (C0604b) this.f2048b.get(size);
            if (c0604b.f2043a == 8) {
                int i5;
                int i6;
                if (c0604b.f2044b < c0604b.f2046d) {
                    i5 = c0604b.f2044b;
                    i3 = c0604b.f2046d;
                } else {
                    i5 = c0604b.f2046d;
                    i3 = c0604b.f2044b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0604b.f2044b) {
                        if (i2 == 1) {
                            c0604b.f2044b++;
                            c0604b.f2046d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c0604b.f2044b--;
                            c0604b.f2046d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0604b.f2044b) {
                    if (i2 == 1) {
                        c0604b.f2046d++;
                    } else if (i2 == 2) {
                        c0604b.f2046d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c0604b.f2044b++;
                    } else if (i2 == 2) {
                        c0604b.f2044b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0604b.f2044b <= i4) {
                if (c0604b.f2043a == 1) {
                    i4 -= c0604b.f2046d;
                } else if (c0604b.f2043a == 2) {
                    i4 += c0604b.f2046d;
                }
            } else if (i2 == 1) {
                c0604b.f2044b++;
            } else if (i2 == 2) {
                c0604b.f2044b--;
            }
        }
        for (i3 = this.f2048b.size() - 1; i3 >= 0; i3--) {
            c0604b = (C0604b) this.f2048b.get(i3);
            if (c0604b.f2043a == 8) {
                if (c0604b.f2046d == c0604b.f2044b || c0604b.f2046d < 0) {
                    this.f2048b.remove(i3);
                    m2627a(c0604b);
                }
            } else if (c0604b.f2046d <= 0) {
                this.f2048b.remove(i3);
                m2627a(c0604b);
            }
        }
        return i4;
    }

    private void m2619d(C0604b c0604b) {
        int i = c0604b.f2044b;
        int i2 = c0604b.f2044b + c0604b.f2046d;
        int i3 = c0604b.f2044b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f2049c.m1773a(i3) != null || m2620d(i3)) {
                if (obj == null) {
                    m2621e(m2625a(4, i, i4, c0604b.f2045c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m2623g(m2625a(4, i, i4, c0604b.f2045c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0604b.f2046d) {
            Object obj4 = c0604b.f2045c;
            m2627a(c0604b);
            c0604b = m2625a(4, i, i4, obj4);
        }
        if (obj == null) {
            m2621e(c0604b);
        } else {
            m2623g(c0604b);
        }
    }

    private boolean m2620d(int i) {
        int size = this.f2048b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0604b c0604b = (C0604b) this.f2048b.get(i2);
            if (c0604b.f2043a == 8) {
                if (m2624a(c0604b.f2046d, i2 + 1) == i) {
                    return true;
                }
            } else if (c0604b.f2043a == 1) {
                int i3 = c0604b.f2044b + c0604b.f2046d;
                for (int i4 = c0604b.f2044b; i4 < i3; i4++) {
                    if (m2624a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m2621e(C0604b c0604b) {
        if (c0604b.f2043a == 1 || c0604b.f2043a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int d = m2618d(c0604b.f2044b, c0604b.f2043a);
        int i2 = c0604b.f2044b;
        switch (c0604b.f2043a) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                i = 0;
                break;
            case SpdyProtocol.QUIC /*4*/:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0604b);
        }
        int i3 = 1;
        int i4 = d;
        d = i2;
        for (i2 = 1; i2 < c0604b.f2046d; i2++) {
            Object obj;
            int d2 = m2618d(c0604b.f2044b + (i * i2), c0604b.f2043a);
            int i5;
            switch (c0604b.f2043a) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (d2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (d2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C0604b a = m2625a(c0604b.f2043a, i4, i3, c0604b.f2045c);
                m2628a(a, d);
                m2627a(a);
                if (c0604b.f2043a == 4) {
                    d += i3;
                }
                i3 = 1;
                i4 = d2;
            }
        }
        Object obj2 = c0604b.f2045c;
        m2627a(c0604b);
        if (i3 > 0) {
            C0604b a2 = m2625a(c0604b.f2043a, i4, i3, obj2);
            m2628a(a2, d);
            m2627a(a2);
        }
    }

    private void m2622f(C0604b c0604b) {
        m2623g(c0604b);
    }

    private void m2623g(C0604b c0604b) {
        this.f2048b.add(c0604b);
        switch (c0604b.f2043a) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f2049c.m1779c(c0604b.f2044b, c0604b.f2046d);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f2049c.m1777b(c0604b.f2044b, c0604b.f2046d);
            case SpdyProtocol.QUIC /*4*/:
                this.f2049c.m1775a(c0604b.f2044b, c0604b.f2046d, c0604b.f2045c);
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                this.f2049c.m1780d(c0604b.f2044b, c0604b.f2046d);
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0604b);
        }
    }

    int m2624a(int i, int i2) {
        int size = this.f2048b.size();
        int i3 = i;
        while (i2 < size) {
            C0604b c0604b = (C0604b) this.f2048b.get(i2);
            if (c0604b.f2043a == 8) {
                if (c0604b.f2044b == i3) {
                    i3 = c0604b.f2046d;
                } else {
                    if (c0604b.f2044b < i3) {
                        i3--;
                    }
                    if (c0604b.f2046d <= i3) {
                        i3++;
                    }
                }
            } else if (c0604b.f2044b > i3) {
                continue;
            } else if (c0604b.f2043a == 2) {
                if (i3 < c0604b.f2044b + c0604b.f2046d) {
                    return -1;
                }
                i3 -= c0604b.f2046d;
            } else if (c0604b.f2043a == 1) {
                i3 += c0604b.f2046d;
            }
            i2++;
        }
        return i3;
    }

    public C0604b m2625a(int i, int i2, int i3, Object obj) {
        C0604b c0604b = (C0604b) this.f2053g.acquire();
        if (c0604b == null) {
            return new C0604b(i, i2, i3, obj);
        }
        c0604b.f2043a = i;
        c0604b.f2044b = i2;
        c0604b.f2046d = i3;
        c0604b.f2045c = obj;
        return c0604b;
    }

    void m2626a() {
        m2629a(this.f2047a);
        m2629a(this.f2048b);
        this.f2054h = 0;
    }

    public void m2627a(C0604b c0604b) {
        if (!this.f2051e) {
            c0604b.f2045c = null;
            this.f2053g.release(c0604b);
        }
    }

    void m2628a(C0604b c0604b, int i) {
        this.f2049c.m1776a(c0604b);
        switch (c0604b.f2043a) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f2049c.m1774a(i, c0604b.f2046d);
            case SpdyProtocol.QUIC /*4*/:
                this.f2049c.m1775a(i, c0604b.f2046d, c0604b.f2045c);
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void m2629a(List<C0604b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m2627a((C0604b) list.get(i));
        }
        list.clear();
    }

    boolean m2630a(int i) {
        return (this.f2054h & i) != 0;
    }

    boolean m2631a(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f2047a.add(m2625a(8, i, i2, null));
        this.f2054h |= 8;
        if (this.f2047a.size() != 1) {
            z = false;
        }
        return z;
    }

    boolean m2632a(int i, int i2, Object obj) {
        this.f2047a.add(m2625a(4, i, i2, obj));
        this.f2054h |= 4;
        return this.f2047a.size() == 1;
    }

    int m2633b(int i) {
        return m2624a(i, 0);
    }

    void m2634b() {
        this.f2052f.m2380a(this.f2047a);
        int size = this.f2047a.size();
        for (int i = 0; i < size; i++) {
            C0604b c0604b = (C0604b) this.f2047a.get(i);
            switch (c0604b.f2043a) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m2622f(c0604b);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    m2617c(c0604b);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    m2619d(c0604b);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    m2616b(c0604b);
                    break;
            }
            if (this.f2050d != null) {
                this.f2050d.run();
            }
        }
        this.f2047a.clear();
    }

    boolean m2635b(int i, int i2) {
        this.f2047a.add(m2625a(1, i, i2, null));
        this.f2054h |= 1;
        return this.f2047a.size() == 1;
    }

    public int m2636c(int i) {
        int size = this.f2047a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C0604b c0604b = (C0604b) this.f2047a.get(i3);
            switch (c0604b.f2043a) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (c0604b.f2044b > i2) {
                        break;
                    }
                    i2 += c0604b.f2046d;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (c0604b.f2044b <= i2) {
                        if (c0604b.f2044b + c0604b.f2046d <= i2) {
                            i2 -= c0604b.f2046d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (c0604b.f2044b != i2) {
                        if (c0604b.f2044b < i2) {
                            i2--;
                        }
                        if (c0604b.f2046d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c0604b.f2046d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    void m2637c() {
        int size = this.f2048b.size();
        for (int i = 0; i < size; i++) {
            this.f2049c.m1778b((C0604b) this.f2048b.get(i));
        }
        m2629a(this.f2048b);
        this.f2054h = 0;
    }

    boolean m2638c(int i, int i2) {
        this.f2047a.add(m2625a(2, i, i2, null));
        this.f2054h |= 2;
        return this.f2047a.size() == 1;
    }

    boolean m2639d() {
        return this.f2047a.size() > 0;
    }

    void m2640e() {
        m2637c();
        int size = this.f2047a.size();
        for (int i = 0; i < size; i++) {
            C0604b c0604b = (C0604b) this.f2047a.get(i);
            switch (c0604b.f2043a) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f2049c.m1778b(c0604b);
                    this.f2049c.m1779c(c0604b.f2044b, c0604b.f2046d);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f2049c.m1778b(c0604b);
                    this.f2049c.m1774a(c0604b.f2044b, c0604b.f2046d);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    this.f2049c.m1778b(c0604b);
                    this.f2049c.m1775a(c0604b.f2044b, c0604b.f2046d, c0604b.f2045c);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    this.f2049c.m1778b(c0604b);
                    this.f2049c.m1780d(c0604b.f2044b, c0604b.f2046d);
                    break;
            }
            if (this.f2050d != null) {
                this.f2050d.run();
            }
        }
        m2629a(this.f2047a);
        this.f2054h = 0;
    }

    boolean m2641f() {
        return (this.f2048b.isEmpty() || this.f2047a.isEmpty()) ? false : true;
    }
}
