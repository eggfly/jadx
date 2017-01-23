package com.p063b.p064a;

import com.p063b.p064a.C1861g.C1862a;
import java.util.ArrayList;

/* renamed from: com.b.a.e */
class C1859e extends C1858h {
    private float f6349g;
    private float f6350h;
    private float f6351i;
    private boolean f6352j;

    public C1859e(C1862a... c1862aArr) {
        super(c1862aArr);
        this.f6352j = true;
    }

    public C1859e m6934a() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        C1862a[] c1862aArr = new C1862a[size];
        for (int i = 0; i < size; i++) {
            c1862aArr[i] = (C1862a) ((C1861g) arrayList.get(i)).m6948e();
        }
        return new C1859e(c1862aArr);
    }

    public Object m6935a(float f) {
        return Float.valueOf(m6936b(f));
    }

    public float m6936b(float f) {
        int i = 1;
        if (this.a == 2) {
            if (this.f6352j) {
                this.f6352j = false;
                this.f6349g = ((C1862a) this.e.get(0)).m6952f();
                this.f6350h = ((C1862a) this.e.get(1)).m6952f();
                this.f6351i = this.f6350h - this.f6349g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            return this.f == null ? this.f6349g + (this.f6351i * f) : ((Number) this.f.m6927a(f, Float.valueOf(this.f6349g), Float.valueOf(this.f6350h))).floatValue();
        } else if (f <= 0.0f) {
            r0 = (C1862a) this.e.get(0);
            r1 = (C1862a) this.e.get(1);
            r2 = r0.m6952f();
            r3 = r1.m6952f();
            r0 = r0.m6946c();
            r4 = r1.m6946c();
            r1 = r1.m6947d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? (r0 * (r3 - r2)) + r2 : ((Number) this.f.m6927a(r0, Float.valueOf(r2), Float.valueOf(r3))).floatValue();
        } else if (f >= 1.0f) {
            r0 = (C1862a) this.e.get(this.a - 2);
            r1 = (C1862a) this.e.get(this.a - 1);
            r2 = r0.m6952f();
            r3 = r1.m6952f();
            r0 = r0.m6946c();
            r4 = r1.m6946c();
            r1 = r1.m6947d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? (r0 * (r3 - r2)) + r2 : ((Number) this.f.m6927a(r0, Float.valueOf(r2), Float.valueOf(r3))).floatValue();
        } else {
            C1862a c1862a = (C1862a) this.e.get(0);
            while (i < this.a) {
                r0 = (C1862a) this.e.get(i);
                if (f < r0.m6946c()) {
                    r1 = r0.m6947d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    float c = (f - c1862a.m6946c()) / (r0.m6946c() - c1862a.m6946c());
                    r2 = c1862a.m6952f();
                    r0 = r0.m6952f();
                    return this.f == null ? ((r0 - r2) * c) + r2 : ((Number) this.f.m6927a(c, Float.valueOf(r2), Float.valueOf(r0))).floatValue();
                } else {
                    i++;
                    c1862a = r0;
                }
            }
            return ((Number) ((C1861g) this.e.get(this.a - 1)).m6945b()).floatValue();
        }
    }

    public /* synthetic */ C1858h m6937b() {
        return m6934a();
    }

    public /* synthetic */ Object clone() {
        return m6934a();
    }
}
