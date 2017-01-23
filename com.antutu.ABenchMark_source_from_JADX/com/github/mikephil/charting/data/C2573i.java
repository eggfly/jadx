package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.p139f.p141b.C2572f;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.i */
public abstract class C2573i<T extends Entry> extends C2571j<T> implements C2572f<T> {
    protected Drawable f8953n;
    private int f8954s;
    private int f8955t;
    private float f8956u;
    private boolean f8957v;

    public C2573i(List<T> list, String str) {
        super(list, str);
        this.f8954s = Color.rgb(140, 234, MotionEventCompat.ACTION_MASK);
        this.f8955t = 85;
        this.f8956u = 2.5f;
        this.f8957v = false;
    }

    public int m9838A() {
        return this.f8954s;
    }

    public Drawable m9839B() {
        return this.f8953n;
    }

    public int m9840C() {
        return this.f8955t;
    }

    public float m9841D() {
        return this.f8956u;
    }

    public boolean m9842E() {
        return this.f8957v;
    }

    public void m9843b(float f) {
        float f2 = 10.0f;
        float f3 = 0.2f;
        if (f >= 0.2f) {
            f3 = f;
        }
        if (f3 <= 10.0f) {
            f2 = f3;
        }
        this.f8956u = C2620f.m10053a(f2);
    }
}
