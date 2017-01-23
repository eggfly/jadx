package android.support.v7.widget;

import android.support.v7.widget.C0605e.C0604b;
import java.util.List;
import org.android.spdy.SpdyProtocol;

class ar {
    final C0583a f1885a;

    /* renamed from: android.support.v7.widget.ar.a */
    interface C0583a {
        C0604b m2375a(int i, int i2, int i3, Object obj);

        void m2376a(C0604b c0604b);
    }

    public ar(C0583a c0583a) {
        this.f1885a = c0583a;
    }

    private void m2377a(List<C0604b> list, int i, int i2) {
        C0604b c0604b = (C0604b) list.get(i);
        C0604b c0604b2 = (C0604b) list.get(i2);
        switch (c0604b2.f2043a) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m2379c(list, i, c0604b, i2, c0604b2);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m2381a(list, i, c0604b, i2, c0604b2);
            case SpdyProtocol.QUIC /*4*/:
                m2382b(list, i, c0604b, i2, c0604b2);
            default:
        }
    }

    private int m2378b(List<C0604b> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0604b) list.get(size)).f2043a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void m2379c(List<C0604b> list, int i, C0604b c0604b, int i2, C0604b c0604b2) {
        int i3 = 0;
        if (c0604b.f2046d < c0604b2.f2044b) {
            i3 = -1;
        }
        if (c0604b.f2044b < c0604b2.f2044b) {
            i3++;
        }
        if (c0604b2.f2044b <= c0604b.f2044b) {
            c0604b.f2044b += c0604b2.f2046d;
        }
        if (c0604b2.f2044b <= c0604b.f2046d) {
            c0604b.f2046d += c0604b2.f2046d;
        }
        c0604b2.f2044b = i3 + c0604b2.f2044b;
        list.set(i, c0604b2);
        list.set(i2, c0604b);
    }

    void m2380a(List<C0604b> list) {
        while (true) {
            int b = m2378b(list);
            if (b != -1) {
                m2377a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void m2381a(List<C0604b> list, int i, C0604b c0604b, int i2, C0604b c0604b2) {
        int i3;
        C0604b c0604b3;
        int i4 = 0;
        if (c0604b.f2044b < c0604b.f2046d) {
            i3 = (c0604b2.f2044b == c0604b.f2044b && c0604b2.f2046d == c0604b.f2046d - c0604b.f2044b) ? 1 : 0;
        } else if (c0604b2.f2044b == c0604b.f2046d + 1 && c0604b2.f2046d == c0604b.f2044b - c0604b.f2046d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0604b.f2046d < c0604b2.f2044b) {
            c0604b2.f2044b--;
        } else if (c0604b.f2046d < c0604b2.f2044b + c0604b2.f2046d) {
            c0604b2.f2046d--;
            c0604b.f2043a = 2;
            c0604b.f2046d = 1;
            if (c0604b2.f2046d == 0) {
                list.remove(i2);
                this.f1885a.m2376a(c0604b2);
                return;
            }
            return;
        }
        if (c0604b.f2044b <= c0604b2.f2044b) {
            c0604b2.f2044b++;
            c0604b3 = null;
        } else if (c0604b.f2044b < c0604b2.f2044b + c0604b2.f2046d) {
            c0604b3 = this.f1885a.m2375a(2, c0604b.f2044b + 1, (c0604b2.f2044b + c0604b2.f2046d) - c0604b.f2044b, null);
            c0604b2.f2046d = c0604b.f2044b - c0604b2.f2044b;
        } else {
            c0604b3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0604b2);
            list.remove(i2);
            this.f1885a.m2376a(c0604b);
            return;
        }
        if (i4 != 0) {
            if (c0604b3 != null) {
                if (c0604b.f2044b > c0604b3.f2044b) {
                    c0604b.f2044b -= c0604b3.f2046d;
                }
                if (c0604b.f2046d > c0604b3.f2044b) {
                    c0604b.f2046d -= c0604b3.f2046d;
                }
            }
            if (c0604b.f2044b > c0604b2.f2044b) {
                c0604b.f2044b -= c0604b2.f2046d;
            }
            if (c0604b.f2046d > c0604b2.f2044b) {
                c0604b.f2046d -= c0604b2.f2046d;
            }
        } else {
            if (c0604b3 != null) {
                if (c0604b.f2044b >= c0604b3.f2044b) {
                    c0604b.f2044b -= c0604b3.f2046d;
                }
                if (c0604b.f2046d >= c0604b3.f2044b) {
                    c0604b.f2046d -= c0604b3.f2046d;
                }
            }
            if (c0604b.f2044b >= c0604b2.f2044b) {
                c0604b.f2044b -= c0604b2.f2046d;
            }
            if (c0604b.f2046d >= c0604b2.f2044b) {
                c0604b.f2046d -= c0604b2.f2046d;
            }
        }
        list.set(i, c0604b2);
        if (c0604b.f2044b != c0604b.f2046d) {
            list.set(i2, c0604b);
        } else {
            list.remove(i2);
        }
        if (c0604b3 != null) {
            list.add(i, c0604b3);
        }
    }

    void m2382b(List<C0604b> list, int i, C0604b c0604b, int i2, C0604b c0604b2) {
        Object obj;
        Object obj2 = null;
        if (c0604b.f2046d < c0604b2.f2044b) {
            c0604b2.f2044b--;
            obj = null;
        } else if (c0604b.f2046d < c0604b2.f2044b + c0604b2.f2046d) {
            c0604b2.f2046d--;
            obj = this.f1885a.m2375a(4, c0604b.f2044b, 1, c0604b2.f2045c);
        } else {
            obj = null;
        }
        if (c0604b.f2044b <= c0604b2.f2044b) {
            c0604b2.f2044b++;
        } else if (c0604b.f2044b < c0604b2.f2044b + c0604b2.f2046d) {
            int i3 = (c0604b2.f2044b + c0604b2.f2046d) - c0604b.f2044b;
            obj2 = this.f1885a.m2375a(4, c0604b.f2044b + 1, i3, c0604b2.f2045c);
            c0604b2.f2046d -= i3;
        }
        list.set(i2, c0604b);
        if (c0604b2.f2046d > 0) {
            list.set(i, c0604b2);
        } else {
            list.remove(i);
            this.f1885a.m2376a(c0604b2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
