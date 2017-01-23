package com.github.mikephil.charting.p138c;

import android.graphics.Typeface;
import com.antutu.utils.widget.SystemBarTintManager;

/* renamed from: com.github.mikephil.charting.c.b */
public abstract class C2528b {
    protected boolean f8703f;
    protected float f8704g;
    protected float f8705h;
    protected Typeface f8706i;
    protected float f8707j;
    protected int f8708k;

    public C2528b() {
        this.f8703f = true;
        this.f8704g = 5.0f;
        this.f8705h = 5.0f;
        this.f8706i = null;
        this.f8707j = 10.0f;
        this.f8708k = SystemBarTintManager.DEFAULT_TINT_COLOR;
    }

    public void m9559a(Typeface typeface) {
        this.f8706i = typeface;
    }

    public float m9560k() {
        return this.f8704g;
    }

    public float m9561l() {
        return this.f8705h;
    }

    public Typeface m9562m() {
        return this.f8706i;
    }

    public float m9563n() {
        return this.f8707j;
    }

    public int m9564o() {
        return this.f8708k;
    }

    public boolean m9565p() {
        return this.f8703f;
    }
}
