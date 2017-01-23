package com.github.mikephil.charting.p142e;

import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p140a.C2544b;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p145i.C2617c;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.e.b */
public class C2579b<T extends C2544b> {
    protected T f8967a;

    public C2579b(T t) {
        this.f8967a = t;
    }

    protected int m9872a(float f) {
        float[] fArr = new float[2];
        fArr[0] = f;
        this.f8967a.m9665a(C2539a.LEFT).m10049b(fArr);
        return Math.round(fArr[0]);
    }

    protected int m9873a(int i, float f, float f2) {
        List a = m9875a(i);
        return C2620f.m10057a(a, f2, C2620f.m10068b(a, f2, C2539a.LEFT) < C2620f.m10068b(a, f2, C2539a.RIGHT) ? C2539a.LEFT : C2539a.RIGHT);
    }

    public C2581c m9874a(float f, float f2) {
        int a = m9872a(f);
        if (a == -2147483647) {
            return null;
        }
        int a2 = m9873a(a, f, f2);
        return a2 != -2147483647 ? new C2581c(a, a2) : null;
    }

    protected List<C2617c> m9875a(int i) {
        List<C2617c> arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < this.f8967a.getData().m9761e(); i2++) {
            C2563d a = this.f8967a.getData().m9756a(i2);
            if (a.m9784f()) {
                float g = a.m9785g(i);
                if (g != Float.NaN) {
                    fArr[1] = g;
                    this.f8967a.m9665a(a.m9791l()).m10044a(fArr);
                    if (!Float.isNaN(fArr[1])) {
                        arrayList.add(new C2617c(fArr[1], i2, a));
                    }
                }
            }
        }
        return arrayList;
    }
}
