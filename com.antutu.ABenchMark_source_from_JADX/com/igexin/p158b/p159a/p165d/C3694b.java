package com.igexin.p158b.p159a.p165d;

import com.igexin.p158b.p159a.p165d.p166a.C3693g;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.b.a.d.b */
public abstract class C3694b implements C3693g {
    protected boolean f12446a;

    public C3694b() {
        this.f12446a = true;
    }

    public void m15108a() {
        this.f12446a = false;
    }

    public boolean m15109a(long j, C3666d c3666d) {
        return TimeUnit.SECONDS.toMillis((long) c3666d.f12352y) < j - c3666d.f12350w;
    }

    public long m15110b(long j, C3666d c3666d) {
        return (TimeUnit.SECONDS.toMillis((long) c3666d.f12352y) + c3666d.f12350w) - j;
    }
}
