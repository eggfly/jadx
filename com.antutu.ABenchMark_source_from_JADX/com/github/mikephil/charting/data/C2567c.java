package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.p139f.p141b.C2566b;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.c */
public abstract class C2567c<T extends Entry> extends C2565f<T> implements C2566b<T> {
    protected int f8944a;

    public C2567c(List<T> list, String str) {
        super(list, str);
        this.f8944a = Color.rgb(MotionEventCompat.ACTION_MASK, 187, 115);
    }

    public int m9823a() {
        return this.f8944a;
    }

    public void m9824a(int i) {
        this.f8944a = i;
    }
}
