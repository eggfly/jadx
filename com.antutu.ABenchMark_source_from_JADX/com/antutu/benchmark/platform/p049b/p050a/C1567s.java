package com.antutu.benchmark.platform.p049b.p050a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.s */
public class C1567s implements Cloneable {
    public static List<Integer> f5449a;
    public static C1563o<Integer, C1550m> f5450b;
    public static boolean f5451c;
    C1563o<Integer, C1550m> f5452d;
    private int f5453e;

    static {
        f5449a = Arrays.asList(new Integer[]{Integer.valueOf(39), Integer.valueOf(37), Integer.valueOf(35), Integer.valueOf(33), Integer.valueOf(32), Integer.valueOf(34), Integer.valueOf(36), Integer.valueOf(38), Integer.valueOf(40), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(42), Integer.valueOf(0), Integer.valueOf(43), Integer.valueOf(0), Integer.valueOf(44), Integer.valueOf(0), Integer.valueOf(45), Integer.valueOf(0), Integer.valueOf(46), Integer.valueOf(0), Integer.valueOf(47), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(27), Integer.valueOf(0), Integer.valueOf(28), Integer.valueOf(0), Integer.valueOf(29), Integer.valueOf(0), Integer.valueOf(30), Integer.valueOf(0), Integer.valueOf(31), Integer.valueOf(0), Integer.valueOf(25), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(26), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(23), Integer.valueOf(21), Integer.valueOf(19), Integer.valueOf(17), Integer.valueOf(16), Integer.valueOf(18), Integer.valueOf(20), Integer.valueOf(22), Integer.valueOf(24)});
        f5450b = new C1563o(C1562n.m6180a(0, 10, 10));
        f5451c = false;
    }

    public C1567s() {
        m6194e();
    }

    public static void m6192a() {
        Iterator it = f5449a.iterator();
        for (int i = 0; i <= 9; i++) {
            for (int i2 = 0; i2 <= 8; i2++) {
                if (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    C1550m a = C1562n.m6180a(intValue, i2, i);
                    if (intValue != 0) {
                        f5450b.put(Integer.valueOf(a.m6139a()), a);
                    }
                }
            }
        }
    }

    private void m6193b(C1563o<Integer, C1550m> c1563o) {
        this.f5452d = c1563o;
    }

    private void m6194e() {
        if (f5450b.size() == 0) {
            C1567s.m6192a();
        }
        this.f5452d = f5450b;
    }

    private C1563o<Integer, C1550m> m6195f() {
        C1563o<Integer, C1550m> c1563o = new C1563o(C1562n.m6180a(0, 10, 10));
        for (C1550m c1550m : this.f5452d.values()) {
            c1563o.put(Integer.valueOf(c1550m.m6139a()), (C1550m) c1550m.clone());
        }
        return c1563o;
    }

    public String m6196a(C1563o<Integer, C1550m> c1563o) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("y\\x   0  1  2  3  4  5  6  7  8    x/y\n");
        stringBuffer.append("    ==============================\n");
        int i = 0;
        while (i <= 9) {
            stringBuffer.append(String.valueOf(i) + " ||");
            for (int i2 = 0; i2 <= 8; i2++) {
                stringBuffer.append("  ");
                C1550m c1550m = (C1550m) c1563o.get(Integer.valueOf(C1568t.m6202a(i2, i)));
                stringBuffer.append(f5451c ? String.valueOf(c1550m.m6142b()) : c1550m.toString());
            }
            stringBuffer.append("   || " + String.valueOf(i));
            stringBuffer.append(i == 4 ? "\n    ==============================\n" : "\n");
            i++;
        }
        stringBuffer.append("    ==============================\n");
        stringBuffer.append("y\\x   0  1  2  3  4  5  6  7  8    x/y\n");
        return stringBuffer.toString();
    }

    public void m6197a(int i) {
        this.f5453e = i;
    }

    public C1563o<Integer, C1550m> m6198b() {
        return this.f5452d;
    }

    public List<C1561l> m6199b(int i) {
        List<C1561l> arrayList = new ArrayList();
        for (C1550m c1550m : this.f5452d.values()) {
            if (c1550m.m6145c() == i) {
                arrayList.addAll(c1550m.m6143b(this, c1550m.m6146d(), c1550m.m6147e()));
            }
        }
        return arrayList;
    }

    public void m6200c() {
        this.f5453e = C1557h.m6167a(this);
    }

    protected Object clone() {
        C1567s c1567s = (C1567s) super.clone();
        c1567s.m6193b(m6195f());
        return c1567s;
    }

    public int m6201d() {
        return this.f5453e;
    }

    public String toString() {
        return m6196a(this.f5452d);
    }
}
