package com.github.mikephil.charting.p138c;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.c.a */
public abstract class C2529a extends C2528b {
    protected boolean f8709a;
    protected boolean f8710b;
    protected boolean f8711c;
    protected List<C2535d> f8712d;
    protected boolean f8713e;
    private int f8714l;
    private float f8715m;
    private int f8716n;
    private float f8717o;
    private DashPathEffect f8718p;

    public C2529a() {
        this.f8714l = -7829368;
        this.f8715m = 1.0f;
        this.f8716n = -7829368;
        this.f8717o = 1.0f;
        this.f8709a = true;
        this.f8710b = true;
        this.f8711c = true;
        this.f8718p = null;
        this.f8713e = false;
        this.j = C2620f.m10053a(10.0f);
        this.g = C2620f.m10053a(5.0f);
        this.h = C2620f.m10053a(5.0f);
        this.f8712d = new ArrayList();
    }

    public void m9566a(boolean z) {
        this.f8709a = z;
    }

    public boolean m9567a() {
        return this.f8709a;
    }

    public void m9568b(boolean z) {
        this.f8710b = z;
    }

    public boolean m9569b() {
        return this.f8710b;
    }

    public int m9570c() {
        return this.f8714l;
    }

    public float m9571d() {
        return this.f8717o;
    }

    public float m9572e() {
        return this.f8715m;
    }

    public int m9573f() {
        return this.f8716n;
    }

    public boolean m9574g() {
        return this.f8711c;
    }

    public List<C2535d> m9575h() {
        return this.f8712d;
    }

    public boolean m9576i() {
        return this.f8713e;
    }

    public DashPathEffect m9577j() {
        return this.f8718p;
    }
}
