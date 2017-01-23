package p000a;

import org.android.spdy.SpdyRequest;
import p000a.C0127q.C0126a;
import p000a.p001a.p005c.C0029f;

/* renamed from: a.x */
public final class C0139x {
    final C0130r f628a;
    final String f629b;
    final C0127q f630c;
    final C0140y f631d;
    final Object f632e;
    private volatile C0108d f633f;

    /* renamed from: a.x.a */
    public static class C0138a {
        C0130r f623a;
        String f624b;
        C0126a f625c;
        C0140y f626d;
        Object f627e;

        public C0138a() {
            this.f624b = SpdyRequest.GET_METHOD;
            this.f625c = new C0126a();
        }

        C0138a(C0139x c0139x) {
            this.f623a = c0139x.f628a;
            this.f624b = c0139x.f629b;
            this.f626d = c0139x.f631d;
            this.f627e = c0139x.f632e;
            this.f625c = c0139x.f630c.m551b();
        }

        public C0138a m653a(C0127q c0127q) {
            this.f625c = c0127q.m551b();
            return this;
        }

        public C0138a m654a(C0130r c0130r) {
            if (c0130r == null) {
                throw new NullPointerException("url == null");
            }
            this.f623a = c0130r;
            return this;
        }

        public C0138a m655a(C0140y c0140y) {
            return m657a(SpdyRequest.POST_METHOD, c0140y);
        }

        public C0138a m656a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
            }
            C0130r e = C0130r.m590e(str);
            if (e != null) {
                return m654a(e);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        public C0138a m657a(String str, C0140y c0140y) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (c0140y != null && !C0029f.m114c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (c0140y == null && C0029f.m113b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.f624b = str;
                this.f626d = c0140y;
                return this;
            }
        }

        public C0138a m658a(String str, String str2) {
            this.f625c.m546c(str, str2);
            return this;
        }

        public C0139x m659a() {
            if (this.f623a != null) {
                return new C0139x(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0138a m660b(String str) {
            this.f625c.m544b(str);
            return this;
        }
    }

    C0139x(C0138a c0138a) {
        Object obj;
        this.f628a = c0138a.f623a;
        this.f629b = c0138a.f624b;
        this.f630c = c0138a.f625c.m543a();
        this.f631d = c0138a.f626d;
        if (c0138a.f627e != null) {
            obj = c0138a.f627e;
        } else {
            C0139x c0139x = this;
        }
        this.f632e = obj;
    }

    public C0130r m661a() {
        return this.f628a;
    }

    public String m662a(String str) {
        return this.f630c.m550a(str);
    }

    public String m663b() {
        return this.f629b;
    }

    public C0127q m664c() {
        return this.f630c;
    }

    public C0140y m665d() {
        return this.f631d;
    }

    public C0138a m666e() {
        return new C0138a(this);
    }

    public C0108d m667f() {
        C0108d c0108d = this.f633f;
        if (c0108d != null) {
            return c0108d;
        }
        c0108d = C0108d.m469a(this.f630c);
        this.f633f = c0108d;
        return c0108d;
    }

    public boolean m668g() {
        return this.f628a.m594c();
    }

    public String toString() {
        return "Request{method=" + this.f629b + ", url=" + this.f628a + ", tag=" + (this.f632e != this ? this.f632e : null) + '}';
    }
}
