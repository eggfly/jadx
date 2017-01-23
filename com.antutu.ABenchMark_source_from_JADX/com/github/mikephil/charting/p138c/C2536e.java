package com.github.mikephil.charting.p138c;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p142e.C2581c;

/* renamed from: com.github.mikephil.charting.c.e */
public abstract class C2536e extends RelativeLayout {
    private void setupLayoutResource(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, this);
        inflate.setLayoutParams(new LayoutParams(-2, -2));
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public abstract int m9609a(float f);

    public void m9610a(Canvas canvas, float f, float f2) {
        float a = ((float) m9609a(f)) + f;
        float b = ((float) m9612b(f2)) + f2;
        canvas.translate(a, b);
        draw(canvas);
        canvas.translate(-a, -b);
    }

    public abstract void m9611a(Entry entry, C2581c c2581c);

    public abstract int m9612b(float f);
}
