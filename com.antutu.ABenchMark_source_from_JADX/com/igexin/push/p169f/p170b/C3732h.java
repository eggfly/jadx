package com.igexin.push.p169f.p170b;

import com.igexin.p158b.p159a.p165d.C3666d;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.h */
public abstract class C3732h extends C3666d {
    long f12594d;

    public C3732h(long j) {
        this(0, j);
    }

    public C3732h(long j, long j2) {
        super(5);
        if (j > 0) {
            j2 += j - System.currentTimeMillis();
        }
        this.f12594d = j2;
        m14954a(this.f12594d, TimeUnit.MILLISECONDS);
    }

    protected abstract void m15302a();

    public final void a_() {
        super.a_();
        m15302a();
    }

    protected void m15303e() {
    }
}
