package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p140a.C2546a;
import com.github.mikephil.charting.p142e.C2580a;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p144h.C2599b;
import com.github.mikephil.charting.p144h.C2609m;

public class BarChart extends C2545a<C2562a> implements C2546a {
    private boolean f8880Q;
    private boolean f8881R;
    private boolean f8882S;

    public BarChart(Context context) {
        super(context);
        this.f8880Q = false;
        this.f8881R = true;
        this.f8882S = false;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8880Q = false;
        this.f8881R = true;
        this.f8882S = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8880Q = false;
        this.f8881R = true;
        this.f8882S = false;
    }

    public C2581c m9694a(float f, float f2) {
        if (this.t != null) {
            return getHighlighter().m9874a(f, f2);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    protected void m9695a() {
        super.m9669a();
        this.H = new C2599b(this, this.K, this.J);
        this.r = new C2609m(this.J, this.m, this.p, this);
        setHighlighter(new C2580a(this));
        this.A = -0.5f;
    }

    protected void m9696b() {
        super.m9675b();
        this.z += 0.5f;
        this.z = ((float) ((C2562a) this.t).m9761e()) * this.z;
        float a = ((C2562a) this.t).m9771a();
        this.z = (((float) ((C2562a) this.t).m9768l()) * a) + this.z;
        this.B = this.z - this.A;
    }

    public boolean m9697c() {
        return this.f8880Q;
    }

    public boolean m9698d() {
        return this.f8881R;
    }

    public boolean m9699e() {
        return this.f8882S;
    }

    public C2562a getBarData() {
        return (C2562a) this.t;
    }

    public int getHighestVisibleXIndex() {
        float e = (float) ((C2562a) this.t).m9761e();
        float a = e <= 1.0f ? 1.0f : ((C2562a) this.t).m9771a() + e;
        float[] fArr = new float[]{this.J.m10094g(), this.J.m10096h()};
        m9668a(C2539a.LEFT).m10049b(fArr);
        return (int) (fArr[0] >= getXChartMax() ? getXChartMax() / a : fArr[0] / a);
    }

    public int getLowestVisibleXIndex() {
        float e = (float) ((C2562a) this.t).m9761e();
        float a = e <= 1.0f ? 1.0f : ((C2562a) this.t).m9771a() + e;
        float[] fArr = new float[]{this.J.m10092f(), this.J.m10096h()};
        m9668a(C2539a.LEFT).m10049b(fArr);
        return (int) (fArr[0] <= getXChartMin() ? 0.0f : (fArr[0] / a) + 1.0f);
    }

    public void setDrawBarShadow(boolean z) {
        this.f8882S = z;
    }

    public void setDrawHighlightArrow(boolean z) {
        this.f8880Q = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.f8881R = z;
    }
}
