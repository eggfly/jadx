package p000a.p001a.p002a;

import anet.channel.util.HttpConstant;
import com.qq.p035e.comm.constants.ErrorCode.AdError;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.util.HttpRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import p000a.C0108d;
import p000a.C0127q;
import p000a.C0127q.C0126a;
import p000a.C0139x;
import p000a.C0143z;
import p000a.C0143z.C0142a;
import p000a.p001a.C0010a;
import p000a.p001a.p005c.C0027d;
import p000a.p001a.p005c.C0028e;

/* renamed from: a.a.a.c */
public final class C0005c {
    public final C0139x f18a;
    public final C0143z f19b;

    /* renamed from: a.a.a.c.a */
    public static class C0004a {
        final long f6a;
        final C0139x f7b;
        final C0143z f8c;
        private Date f9d;
        private String f10e;
        private Date f11f;
        private String f12g;
        private Date f13h;
        private long f14i;
        private long f15j;
        private String f16k;
        private int f17l;

        public C0004a(long j, C0139x c0139x, C0143z c0143z) {
            this.f17l = -1;
            this.f6a = j;
            this.f7b = c0139x;
            this.f8c = c0143z;
            if (c0143z != null) {
                this.f14i = c0143z.m703h();
                this.f15j = c0143z.m704i();
                C0127q d = c0143z.m699d();
                int a = d.m548a();
                for (int i = 0; i < a; i++) {
                    String a2 = d.m549a(i);
                    String b = d.m552b(i);
                    if (HttpRequest.f14560m.equalsIgnoreCase(a2)) {
                        this.f9d = C0027d.m103a(b);
                        this.f10e = b;
                    } else if (HttpRequest.f14562o.equalsIgnoreCase(a2)) {
                        this.f13h = C0027d.m103a(b);
                    } else if (HttpRequest.f14564q.equalsIgnoreCase(a2)) {
                        this.f11f = C0027d.m103a(b);
                        this.f12g = b;
                    } else if (HttpRequest.f14561n.equalsIgnoreCase(a2)) {
                        this.f16k = b;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.f17l = C0028e.m110b(b, -1);
                    }
                }
            }
        }

        private static boolean m9a(C0139x c0139x) {
            return (c0139x.m662a("If-Modified-Since") == null && c0139x.m662a(HttpRequest.f14563p) == null) ? false : true;
        }

        private C0005c m10b() {
            long j = 0;
            if (this.f8c == null) {
                return new C0005c(this.f7b, null);
            }
            if (this.f7b.m668g() && this.f8c.m698c() == null) {
                return new C0005c(this.f7b, null);
            }
            if (!C0005c.m15a(this.f8c, this.f7b)) {
                return new C0005c(this.f7b, null);
            }
            C0108d f = this.f7b.m667f();
            if (f.m471a() || C0004a.m9a(this.f7b)) {
                return new C0005c(this.f7b, null);
            }
            long d = m12d();
            long c = m11c();
            if (f.m473c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) f.m473c()));
            }
            long toMillis = f.m478h() != -1 ? TimeUnit.SECONDS.toMillis((long) f.m478h()) : 0;
            C0108d g = this.f8c.m702g();
            if (!(g.m476f() || f.m477g() == -1)) {
                j = TimeUnit.SECONDS.toMillis((long) f.m477g());
            }
            if (g.m471a() || d + toMillis >= r4 + c) {
                String str;
                String str2;
                if (this.f16k != null) {
                    str = HttpRequest.f14563p;
                    str2 = this.f16k;
                } else if (this.f11f != null) {
                    str = "If-Modified-Since";
                    str2 = this.f12g;
                } else if (this.f9d == null) {
                    return new C0005c(this.f7b, null);
                } else {
                    str = "If-Modified-Since";
                    str2 = this.f10e;
                }
                C0126a b = this.f7b.m664c().m551b();
                C0010a.f46a.m35a(b, str, str2);
                return new C0005c(this.f7b.m666e().m653a(b.m543a()).m659a(), this.f8c);
            }
            C0142a f2 = this.f8c.m701f();
            if (toMillis + d >= c) {
                f2.m689a("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (d > C4156a.f13948j && m13e()) {
                f2.m689a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new C0005c(null, f2.m690a());
        }

        private long m11c() {
            C0108d g = this.f8c.m702g();
            if (g.m473c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) g.m473c());
            }
            long time;
            if (this.f13h != null) {
                time = this.f13h.getTime() - (this.f9d != null ? this.f9d.getTime() : this.f15j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.f11f == null || this.f8c.m694a().m661a().m603k() != null) {
                return 0;
            } else {
                time = (this.f9d != null ? this.f9d.getTime() : this.f14i) - this.f11f.getTime();
                return time > 0 ? time / 10 : 0;
            }
        }

        private long m12d() {
            long j = 0;
            if (this.f9d != null) {
                j = Math.max(0, this.f15j - this.f9d.getTime());
            }
            if (this.f17l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f17l));
            }
            return (j + (this.f15j - this.f14i)) + (this.f6a - this.f15j);
        }

        private boolean m13e() {
            return this.f8c.m702g().m473c() == -1 && this.f13h == null;
        }

        public C0005c m14a() {
            C0005c b = m10b();
            return (b.f18a == null || !this.f7b.m667f().m479i()) ? b : new C0005c(null, null);
        }
    }

    C0005c(C0139x c0139x, C0143z c0143z) {
        this.f18a = c0139x;
        this.f19b = c0143z;
    }

    public static boolean m15a(C0143z c0143z, C0139x c0139x) {
        switch (c0143z.m697b()) {
            case Constants.COMMAND_HANDSHAKE /*200*/:
            case 203:
            case 204:
            case ErrorCode.APP_NOT_BIND /*300*/:
            case Constants.COMMAND_STOP_FOR_ELECTION /*301*/:
            case 308:
            case NetWorkError.TIME_OUT_ERROR /*404*/:
            case NetWorkError.RESOURCE_LOAD_FAIL_ERROR /*405*/:
            case 410:
            case 414:
            case AdError.NO_FILL_ERROR /*501*/:
                break;
            case ErrorCode.DM_DEVICEID_INVALID /*302*/:
            case HttpConstant.SC_TEMPORARY_REDIRECT /*307*/:
                if (c0143z.m695a(HttpRequest.f14562o) == null && c0143z.m702g().m473c() == -1 && !c0143z.m702g().m475e() && !c0143z.m702g().m474d()) {
                    return false;
                }
            default:
                return false;
        }
        return (c0143z.m702g().m472b() || c0139x.m667f().m472b()) ? false : true;
    }
}
