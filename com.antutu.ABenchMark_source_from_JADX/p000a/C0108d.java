package p000a;

import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p005c.C0028e;

/* renamed from: a.d */
public final class C0108d {
    public static final C0108d f403a;
    public static final C0108d f404b;
    String f405c;
    private final boolean f406d;
    private final boolean f407e;
    private final int f408f;
    private final int f409g;
    private final boolean f410h;
    private final boolean f411i;
    private final boolean f412j;
    private final int f413k;
    private final int f414l;
    private final boolean f415m;
    private final boolean f416n;

    /* renamed from: a.d.a */
    public static final class C0107a {
        boolean f396a;
        boolean f397b;
        int f398c;
        int f399d;
        int f400e;
        boolean f401f;
        boolean f402g;

        public C0107a() {
            this.f398c = -1;
            this.f399d = -1;
            this.f400e = -1;
        }

        public C0107a m465a() {
            this.f396a = true;
            return this;
        }

        public C0107a m466a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.f399d = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
            return this;
        }

        public C0107a m467b() {
            this.f401f = true;
            return this;
        }

        public C0108d m468c() {
            return new C0108d(this);
        }
    }

    static {
        f403a = new C0107a().m465a().m468c();
        f404b = new C0107a().m467b().m466a(Integer.MAX_VALUE, TimeUnit.SECONDS).m468c();
    }

    C0108d(C0107a c0107a) {
        this.f406d = c0107a.f396a;
        this.f407e = c0107a.f397b;
        this.f408f = c0107a.f398c;
        this.f409g = -1;
        this.f410h = false;
        this.f411i = false;
        this.f412j = false;
        this.f413k = c0107a.f399d;
        this.f414l = c0107a.f400e;
        this.f415m = c0107a.f401f;
        this.f416n = c0107a.f402g;
    }

    private C0108d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f406d = z;
        this.f407e = z2;
        this.f408f = i;
        this.f409g = i2;
        this.f410h = z3;
        this.f411i = z4;
        this.f412j = z5;
        this.f413k = i3;
        this.f414l = i4;
        this.f415m = z6;
        this.f416n = z7;
        this.f405c = str;
    }

    public static C0108d m469a(C0127q c0127q) {
        boolean z = false;
        int i = -1;
        int i2 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int a = c0127q.m548a();
        int i5 = 0;
        String str = null;
        boolean z7 = false;
        while (i5 < a) {
            boolean z8;
            String a2 = c0127q.m549a(i5);
            String b = c0127q.m552b(i5);
            if (a2.equalsIgnoreCase(HttpRequest.f14556i)) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a2.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z8 = z7;
                i5++;
                z7 = z8;
            }
            z8 = z7;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a3 = C0028e.m105a(b, i6, "=,;");
                String trim = b.substring(i6, a3).trim();
                if (a3 == b.length() || b.charAt(a3) == ',' || b.charAt(a3) == ';') {
                    i6 = a3 + 1;
                    str2 = null;
                } else {
                    i6 = C0028e.m104a(b, a3 + 1);
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a3 = C0028e.m105a(b, i6, ",;");
                        trim2 = b.substring(i6, a3).trim();
                        i6 = a3;
                        str2 = trim2;
                    } else {
                        i6++;
                        a3 = C0028e.m105a(b, i6, "\"");
                        trim2 = b.substring(i6, a3);
                        i6 = a3 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else {
                    if ("no-store".equalsIgnoreCase(trim)) {
                        z = true;
                    } else {
                        if ("max-age".equalsIgnoreCase(trim)) {
                            i = C0028e.m110b(str2, -1);
                        } else {
                            if ("s-maxage".equalsIgnoreCase(trim)) {
                                i2 = C0028e.m110b(str2, -1);
                            } else {
                                if ("private".equalsIgnoreCase(trim)) {
                                    z2 = true;
                                } else {
                                    if ("public".equalsIgnoreCase(trim)) {
                                        z3 = true;
                                    } else {
                                        if ("must-revalidate".equalsIgnoreCase(trim)) {
                                            z4 = true;
                                        } else {
                                            if ("max-stale".equalsIgnoreCase(trim)) {
                                                i3 = C0028e.m110b(str2, Integer.MAX_VALUE);
                                            } else {
                                                if ("min-fresh".equalsIgnoreCase(trim)) {
                                                    i4 = C0028e.m110b(str2, -1);
                                                } else {
                                                    if ("only-if-cached".equalsIgnoreCase(trim)) {
                                                        z5 = true;
                                                    } else {
                                                        if ("no-transform".equalsIgnoreCase(trim)) {
                                                            z6 = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i5++;
            z7 = z8;
        }
        return new C0108d(z7, z, i, i2, z2, z3, z4, i3, i4, z5, z6, obj == null ? null : str);
    }

    private String m470j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f406d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.f407e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f408f != -1) {
            stringBuilder.append("max-age=").append(this.f408f).append(", ");
        }
        if (this.f409g != -1) {
            stringBuilder.append("s-maxage=").append(this.f409g).append(", ");
        }
        if (this.f410h) {
            stringBuilder.append("private, ");
        }
        if (this.f411i) {
            stringBuilder.append("public, ");
        }
        if (this.f412j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.f413k != -1) {
            stringBuilder.append("max-stale=").append(this.f413k).append(", ");
        }
        if (this.f414l != -1) {
            stringBuilder.append("min-fresh=").append(this.f414l).append(", ");
        }
        if (this.f415m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.f416n) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }

    public boolean m471a() {
        return this.f406d;
    }

    public boolean m472b() {
        return this.f407e;
    }

    public int m473c() {
        return this.f408f;
    }

    public boolean m474d() {
        return this.f410h;
    }

    public boolean m475e() {
        return this.f411i;
    }

    public boolean m476f() {
        return this.f412j;
    }

    public int m477g() {
        return this.f413k;
    }

    public int m478h() {
        return this.f414l;
    }

    public boolean m479i() {
        return this.f415m;
    }

    public String toString() {
        String str = this.f405c;
        if (str != null) {
            return str;
        }
        str = m470j();
        this.f405c = str;
        return str;
    }
}
