package com.github.mikephil.charting.p144h;

import com.github.mikephil.charting.p139f.p140a.C2544b;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.k */
public abstract class C2596k {
    protected C2621g f9010o;
    protected int f9011p;
    protected int f9012q;

    public C2596k(C2621g c2621g) {
        this.f9011p = 0;
        this.f9012q = 0;
        this.f9010o = c2621g;
    }

    public void m9935a(C2544b c2544b, int i) {
        int lowestVisibleXIndex = c2544b.getLowestVisibleXIndex();
        int highestVisibleXIndex = c2544b.getHighestVisibleXIndex();
        this.f9011p = Math.max(((lowestVisibleXIndex / i) * i) - (lowestVisibleXIndex % i == 0 ? i : 0), 0);
        this.f9012q = Math.min(((highestVisibleXIndex / i) * i) + i, (int) c2544b.getXChartMax());
    }
}
