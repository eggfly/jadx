package p000a;

import java.io.Closeable;
import p000a.C0127q.C0126a;

/* renamed from: a.z */
public final class C0143z implements Closeable {
    final C0139x f650a;
    final C0135v f651b;
    final int f652c;
    final String f653d;
    final C0125p f654e;
    final C0127q f655f;
    final aa f656g;
    final C0143z f657h;
    final C0143z f658i;
    final C0143z f659j;
    final long f660k;
    final long f661l;
    private volatile C0108d f662m;

    /* renamed from: a.z.a */
    public static class C0142a {
        C0139x f638a;
        C0135v f639b;
        int f640c;
        String f641d;
        C0125p f642e;
        C0126a f643f;
        aa f644g;
        C0143z f645h;
        C0143z f646i;
        C0143z f647j;
        long f648k;
        long f649l;

        public C0142a() {
            this.f640c = -1;
            this.f643f = new C0126a();
        }

        C0142a(C0143z c0143z) {
            this.f640c = -1;
            this.f638a = c0143z.f650a;
            this.f639b = c0143z.f651b;
            this.f640c = c0143z.f652c;
            this.f641d = c0143z.f653d;
            this.f642e = c0143z.f654e;
            this.f643f = c0143z.f655f.m551b();
            this.f644g = c0143z.f656g;
            this.f645h = c0143z.f657h;
            this.f646i = c0143z.f658i;
            this.f647j = c0143z.f659j;
            this.f648k = c0143z.f660k;
            this.f649l = c0143z.f661l;
        }

        private void m678a(String str, C0143z c0143z) {
            if (c0143z.f656g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (c0143z.f657h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (c0143z.f658i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (c0143z.f659j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private void m679d(C0143z c0143z) {
            if (c0143z.f656g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public C0142a m680a(int i) {
            this.f640c = i;
            return this;
        }

        public C0142a m681a(long j) {
            this.f648k = j;
            return this;
        }

        public C0142a m682a(aa aaVar) {
            this.f644g = aaVar;
            return this;
        }

        public C0142a m683a(C0125p c0125p) {
            this.f642e = c0125p;
            return this;
        }

        public C0142a m684a(C0127q c0127q) {
            this.f643f = c0127q.m551b();
            return this;
        }

        public C0142a m685a(C0135v c0135v) {
            this.f639b = c0135v;
            return this;
        }

        public C0142a m686a(C0139x c0139x) {
            this.f638a = c0139x;
            return this;
        }

        public C0142a m687a(C0143z c0143z) {
            if (c0143z != null) {
                m678a("networkResponse", c0143z);
            }
            this.f645h = c0143z;
            return this;
        }

        public C0142a m688a(String str) {
            this.f641d = str;
            return this;
        }

        public C0142a m689a(String str, String str2) {
            this.f643f.m542a(str, str2);
            return this;
        }

        public C0143z m690a() {
            if (this.f638a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f639b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f640c >= 0) {
                return new C0143z(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.f640c);
            }
        }

        public C0142a m691b(long j) {
            this.f649l = j;
            return this;
        }

        public C0142a m692b(C0143z c0143z) {
            if (c0143z != null) {
                m678a("cacheResponse", c0143z);
            }
            this.f646i = c0143z;
            return this;
        }

        public C0142a m693c(C0143z c0143z) {
            if (c0143z != null) {
                m679d(c0143z);
            }
            this.f647j = c0143z;
            return this;
        }
    }

    C0143z(C0142a c0142a) {
        this.f650a = c0142a.f638a;
        this.f651b = c0142a.f639b;
        this.f652c = c0142a.f640c;
        this.f653d = c0142a.f641d;
        this.f654e = c0142a.f642e;
        this.f655f = c0142a.f643f.m543a();
        this.f656g = c0142a.f644g;
        this.f657h = c0142a.f645h;
        this.f658i = c0142a.f646i;
        this.f659j = c0142a.f647j;
        this.f660k = c0142a.f648k;
        this.f661l = c0142a.f649l;
    }

    public C0139x m694a() {
        return this.f650a;
    }

    public String m695a(String str) {
        return m696a(str, null);
    }

    public String m696a(String str, String str2) {
        String a = this.f655f.m550a(str);
        return a != null ? a : str2;
    }

    public int m697b() {
        return this.f652c;
    }

    public C0125p m698c() {
        return this.f654e;
    }

    public void close() {
        this.f656g.close();
    }

    public C0127q m699d() {
        return this.f655f;
    }

    public aa m700e() {
        return this.f656g;
    }

    public C0142a m701f() {
        return new C0142a(this);
    }

    public C0108d m702g() {
        C0108d c0108d = this.f662m;
        if (c0108d != null) {
            return c0108d;
        }
        c0108d = C0108d.m469a(this.f655f);
        this.f662m = c0108d;
        return c0108d;
    }

    public long m703h() {
        return this.f660k;
    }

    public long m704i() {
        return this.f661l;
    }

    public String toString() {
        return "Response{protocol=" + this.f651b + ", code=" + this.f652c + ", message=" + this.f653d + ", url=" + this.f650a.m661a() + '}';
    }
}
