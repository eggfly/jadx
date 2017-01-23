package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.p139f.p141b.C2570g;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.j */
public abstract class C2571j<T extends Entry> extends C2567c<T> implements C2570g<T> {
    protected boolean f8949o;
    protected boolean f8950p;
    protected float f8951q;
    protected DashPathEffect f8952r;

    public C2571j(List<T> list, String str) {
        super(list, str);
        this.f8949o = true;
        this.f8950p = true;
        this.f8951q = 0.5f;
        this.f8952r = null;
        this.f8951q = C2620f.m10053a(0.5f);
    }

    public boolean m9829F() {
        return this.f8949o;
    }

    public boolean m9830G() {
        return this.f8950p;
    }

    public float m9831H() {
        return this.f8951q;
    }

    public DashPathEffect m9832I() {
        return this.f8952r;
    }
}
