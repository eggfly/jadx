package com.google.ads;

import com.google.android.gms.ads.C2719d;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.ErrorCode;

@Deprecated
/* renamed from: com.google.ads.b */
public final class C2632b {
    public static final C2632b f9165a;
    public static final C2632b f9166b;
    public static final C2632b f9167c;
    public static final C2632b f9168d;
    public static final C2632b f9169e;
    public static final C2632b f9170f;
    private final C2719d f9171g;

    static {
        f9165a = new C2632b(-1, -2, "mb");
        f9166b = new C2632b(320, 50, "mb");
        f9167c = new C2632b(ErrorCode.APP_NOT_BIND, 250, "as");
        f9168d = new C2632b(468, 60, "as");
        f9169e = new C2632b(728, 90, "as");
        f9170f = new C2632b(160, OtherError.CONTAINER_INVISIBLE_ERROR, "as");
    }

    private C2632b(int i, int i2, String str) {
        this(new C2719d(i, i2));
    }

    public C2632b(C2719d c2719d) {
        this.f9171g = c2719d;
    }

    public int m10135a() {
        return this.f9171g.m10346b();
    }

    public int m10136b() {
        return this.f9171g.m10344a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2632b)) {
            return false;
        }
        return this.f9171g.equals(((C2632b) obj).f9171g);
    }

    public int hashCode() {
        return this.f9171g.hashCode();
    }

    public String toString() {
        return this.f9171g.toString();
    }
}
