package com.github.mikephil.charting.p039d;

import com.github.mikephil.charting.data.C2569g;
import com.github.mikephil.charting.p139f.p140a.C2547d;
import com.github.mikephil.charting.p139f.p141b.C2574e;

/* renamed from: com.github.mikephil.charting.d.a */
public class C2553a implements C2552e {
    public float m9736a(C2574e c2574e, C2547d c2547d) {
        float yChartMax = c2547d.getYChartMax();
        float yChartMin = c2547d.getYChartMin();
        C2569g lineData = c2547d.getLineData();
        if (c2574e.m9794p() > 0.0f && c2574e.m9793o() < 0.0f) {
            return 0.0f;
        }
        if (lineData.m9763g() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.m9762f() < 0.0f) {
            yChartMin = 0.0f;
        }
        if (c2574e.m9793o() < 0.0f) {
            yChartMin = yChartMax;
        }
        return yChartMin;
    }
}
