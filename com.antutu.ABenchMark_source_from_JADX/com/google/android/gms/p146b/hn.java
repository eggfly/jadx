package com.google.android.gms.p146b;

import com.google.android.gms.common.internal.C3511t;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.hn */
public class hn {
    private final String[] f11322a;
    private final double[] f11323b;
    private final double[] f11324c;
    private final int[] f11325d;
    private int f11326e;

    /* renamed from: com.google.android.gms.b.hn.a */
    public static class C3265a {
        public final String f11314a;
        public final double f11315b;
        public final double f11316c;
        public final double f11317d;
        public final int f11318e;

        public C3265a(String str, double d, double d2, double d3, int i) {
            this.f11314a = str;
            this.f11316c = d;
            this.f11315b = d2;
            this.f11317d = d3;
            this.f11318e = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3265a)) {
                return false;
            }
            C3265a c3265a = (C3265a) obj;
            return C3511t.m14579a(this.f11314a, c3265a.f11314a) && this.f11315b == c3265a.f11315b && this.f11316c == c3265a.f11316c && this.f11318e == c3265a.f11318e && Double.compare(this.f11317d, c3265a.f11317d) == 0;
        }

        public int hashCode() {
            return C3511t.m14577a(this.f11314a, Double.valueOf(this.f11315b), Double.valueOf(this.f11316c), Double.valueOf(this.f11317d), Integer.valueOf(this.f11318e));
        }

        public String toString() {
            return C3511t.m14578a((Object) this).m14576a("name", this.f11314a).m14576a("minBound", Double.valueOf(this.f11316c)).m14576a("maxBound", Double.valueOf(this.f11315b)).m14576a("percent", Double.valueOf(this.f11317d)).m14576a("count", Integer.valueOf(this.f11318e)).toString();
        }
    }

    /* renamed from: com.google.android.gms.b.hn.b */
    public static class C3266b {
        private final List<String> f11319a;
        private final List<Double> f11320b;
        private final List<Double> f11321c;

        public C3266b() {
            this.f11319a = new ArrayList();
            this.f11320b = new ArrayList();
            this.f11321c = new ArrayList();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.p146b.hn.C3266b m13130a(java.lang.String r7, double r8, double r10) {
            /*
            r6 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            r0 = r6.f11319a;
            r0 = r0.size();
            if (r1 >= r0) goto L_0x0026;
        L_0x000a:
            r0 = r6.f11321c;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r2 = r0.doubleValue();
            r0 = r6.f11320b;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r4 = r0.doubleValue();
            r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x003e;
        L_0x0026:
            r0 = r6.f11319a;
            r0.add(r1, r7);
            r0 = r6.f11321c;
            r2 = java.lang.Double.valueOf(r8);
            r0.add(r1, r2);
            r0 = r6.f11320b;
            r2 = java.lang.Double.valueOf(r10);
            r0.add(r1, r2);
            return r6;
        L_0x003e:
            r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r0 != 0) goto L_0x0046;
        L_0x0042:
            r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
            if (r0 < 0) goto L_0x0026;
        L_0x0046:
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0002;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.hn.b.a(java.lang.String, double, double):com.google.android.gms.b.hn$b");
        }

        public hn m13131a() {
            return new hn();
        }
    }

    private hn(C3266b c3266b) {
        int size = c3266b.f11320b.size();
        this.f11322a = (String[]) c3266b.f11319a.toArray(new String[size]);
        this.f11323b = m13132a(c3266b.f11320b);
        this.f11324c = m13132a(c3266b.f11321c);
        this.f11325d = new int[size];
        this.f11326e = 0;
    }

    private double[] m13132a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<C3265a> m13133a() {
        List<C3265a> arrayList = new ArrayList(this.f11322a.length);
        for (int i = 0; i < this.f11322a.length; i++) {
            arrayList.add(new C3265a(this.f11322a[i], this.f11324c[i], this.f11323b[i], ((double) this.f11325d[i]) / ((double) this.f11326e), this.f11325d[i]));
        }
        return arrayList;
    }

    public void m13134a(double d) {
        this.f11326e++;
        int i = 0;
        while (i < this.f11324c.length) {
            if (this.f11324c[i] <= d && d < this.f11323b[i]) {
                int[] iArr = this.f11325d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.f11324c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
