package com.github.mikephil.charting.data;

import com.github.mikephil.charting.p139f.p141b.C2584a;

/* renamed from: com.github.mikephil.charting.data.a */
public class C2562a extends C2561b<C2584a> {
    private float f8930i;

    public C2562a() {
        this.f8930i = 0.8f;
    }

    public float m9771a() {
        return this.h.size() <= 1 ? 0.0f : this.f8930i;
    }

    public boolean m9772b() {
        return this.h.size() > 1;
    }
}
