package com.github.mikephil.charting.p144h;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.a */
public abstract class C2597a extends C2596k {
    protected C2618d f9013a;
    protected Paint f9014b;
    protected Paint f9015c;
    protected Paint f9016d;
    protected Paint f9017e;

    public C2597a(C2621g c2621g, C2618d c2618d) {
        super(c2621g);
        this.f9013a = c2618d;
        this.f9015c = new Paint(1);
        this.f9014b = new Paint();
        this.f9014b.setColor(-7829368);
        this.f9014b.setStrokeWidth(1.0f);
        this.f9014b.setStyle(Style.STROKE);
        this.f9014b.setAlpha(90);
        this.f9016d = new Paint();
        this.f9016d.setColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.f9016d.setStrokeWidth(1.0f);
        this.f9016d.setStyle(Style.STROKE);
        this.f9017e = new Paint(1);
        this.f9017e.setStyle(Style.STROKE);
    }

    public Paint m9936a() {
        return this.f9015c;
    }
}
