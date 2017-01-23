package com.p063b.p064a;

import android.view.animation.Interpolator;
import com.p063b.p064a.C1861g.C1862a;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.b.a.h */
class C1858h {
    int f6343a;
    C1861g f6344b;
    C1861g f6345c;
    Interpolator f6346d;
    ArrayList<C1861g> f6347e;
    C1856l f6348f;

    public C1858h(C1861g... c1861gArr) {
        this.f6343a = c1861gArr.length;
        this.f6347e = new ArrayList();
        this.f6347e.addAll(Arrays.asList(c1861gArr));
        this.f6344b = (C1861g) this.f6347e.get(0);
        this.f6345c = (C1861g) this.f6347e.get(this.f6343a - 1);
        this.f6346d = this.f6345c.m6947d();
    }

    public static C1858h m6930a(float... fArr) {
        int i = 1;
        int length = fArr.length;
        C1862a[] c1862aArr = new C1862a[Math.max(length, 2)];
        if (length == 1) {
            c1862aArr[0] = (C1862a) C1861g.m6940a(0.0f);
            c1862aArr[1] = (C1862a) C1861g.m6941a(1.0f, fArr[0]);
        } else {
            c1862aArr[0] = (C1862a) C1861g.m6941a(0.0f, fArr[0]);
            while (i < length) {
                c1862aArr[i] = (C1862a) C1861g.m6941a(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        return new C1859e(c1862aArr);
    }

    public Object m6931a(float f) {
        if (this.f6343a == 2) {
            if (this.f6346d != null) {
                f = this.f6346d.getInterpolation(f);
            }
            return this.f6348f.m6927a(f, this.f6344b.m6945b(), this.f6345c.m6945b());
        } else if (f <= 0.0f) {
            r0 = (C1861g) this.f6347e.get(1);
            r1 = r0.m6947d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = this.f6344b.m6946c();
            return this.f6348f.m6927a((f - r1) / (r0.m6946c() - r1), this.f6344b.m6945b(), r0.m6945b());
        } else if (f >= 1.0f) {
            r0 = (C1861g) this.f6347e.get(this.f6343a - 2);
            r1 = this.f6345c.m6947d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = r0.m6946c();
            return this.f6348f.m6927a((f - r1) / (this.f6345c.m6946c() - r1), r0.m6945b(), this.f6345c.m6945b());
        } else {
            C1861g c1861g = this.f6344b;
            int i = 1;
            while (i < this.f6343a) {
                r0 = (C1861g) this.f6347e.get(i);
                if (f < r0.m6946c()) {
                    r1 = r0.m6947d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    r1 = c1861g.m6946c();
                    return this.f6348f.m6927a((f - r1) / (r0.m6946c() - r1), c1861g.m6945b(), r0.m6945b());
                }
                i++;
                c1861g = r0;
            }
            return this.f6345c.m6945b();
        }
    }

    public void m6932a(C1856l c1856l) {
        this.f6348f = c1856l;
    }

    public C1858h m6933b() {
        ArrayList arrayList = this.f6347e;
        int size = this.f6347e.size();
        C1861g[] c1861gArr = new C1861g[size];
        for (int i = 0; i < size; i++) {
            c1861gArr[i] = ((C1861g) arrayList.get(i)).m6948e();
        }
        return new C1858h(c1861gArr);
    }

    public /* synthetic */ Object clone() {
        return m6933b();
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f6343a) {
            String str2 = str + ((C1861g) this.f6347e.get(i)).m6945b() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
