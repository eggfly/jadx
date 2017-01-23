package com.antutu.benchmark.platform.p054e;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* renamed from: com.antutu.benchmark.platform.e.b */
public class C1577b {
    private String f5479a;

    public C1577b() {
        this.f5479a = "public_timeline.json";
    }

    private double m6241a(Context context, C1576a c1576a, int i) {
        try {
            double nanoTime;
            double nanoTime2 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
            int i2 = 0;
            do {
                c1576a.m6240a(m6243a(context, this.f5479a));
                nanoTime = ((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime2;
                i2++;
            } while (nanoTime < ((double) i));
            return (((double) i2) * 1000.0d) / nanoTime;
        } catch (Exception e) {
            return 0.0d;
        }
    }

    private int m6242a(Context context, C1576a c1576a) {
        if (C1577b.m6244a(c1576a.m6240a(m6243a(context, this.f5479a)))) {
            for (int i = 0; i < 10; i++) {
                c1576a.m6240a(m6243a(context, this.f5479a));
            }
        }
        return 0;
    }

    private InputStream m6243a(Context context, String str) {
        try {
            return context.getAssets().open(str);
        } catch (IOException e) {
            return null;
        }
    }

    private static boolean m6244a(List<Map> list) {
        if (list.size() != 20) {
            return false;
        }
        for (Map size : list) {
            if (size.size() != 52) {
                return false;
            }
        }
        return true;
    }

    public double m6245a(Context context, String str, double d) {
        this.f5479a = str;
        C1576a c1576a = new C1576a();
        m6242a(context, c1576a);
        return m6241a(context, c1576a, (int) (1000.0d * d));
    }
}
