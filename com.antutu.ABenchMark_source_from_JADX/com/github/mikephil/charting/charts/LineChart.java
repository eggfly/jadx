package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.C2569g;
import com.github.mikephil.charting.p139f.p140a.C2547d;
import com.github.mikephil.charting.p144h.C2605f;

public class LineChart extends C2545a<C2569g> implements C2547d {
    public LineChart(Context context) {
        super(context);
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void m9700a() {
        super.m9669a();
        this.H = new C2605f(this, this.K, this.J);
    }

    protected void m9701b() {
        super.m9675b();
        if (this.z == 0.0f && ((C2569g) this.t).m9765i() > 0) {
            this.z = 1.0f;
        }
    }

    public C2569g getLineData() {
        return (C2569g) this.t;
    }

    protected void onDetachedFromWindow() {
        if (this.H != null && (this.H instanceof C2605f)) {
            ((C2605f) this.H).m9975b();
        }
        super.onDetachedFromWindow();
    }
}
