package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.p039d.C2552e;
import com.github.mikephil.charting.p039d.C2553a;
import com.github.mikephil.charting.p139f.p141b.C2574e;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.h */
public class C2575h extends C2573i<Entry> implements C2574e {
    private boolean f8958A;
    private List<Integer> f8959s;
    private int f8960t;
    private float f8961u;
    private float f8962v;
    private DashPathEffect f8963w;
    private C2552e f8964x;
    private boolean f8965y;
    private boolean f8966z;

    public C2575h(List<Entry> list, String str) {
        super(list, str);
        this.f8959s = null;
        this.f8960t = -1;
        this.f8961u = 8.0f;
        this.f8962v = 0.2f;
        this.f8963w = null;
        this.f8964x = new C2553a();
        this.f8965y = true;
        this.f8966z = false;
        this.f8958A = true;
        this.f8959s = new ArrayList();
        this.f8959s.add(Integer.valueOf(Color.rgb(140, 234, MotionEventCompat.ACTION_MASK)));
    }

    public void m9854a(float f) {
        this.f8961u = C2620f.m10053a(f);
    }

    public void m9855b(boolean z) {
        this.f8958A = z;
    }

    public int m9856h(int i) {
        return ((Integer) this.f8959s.get(i % this.f8959s.size())).intValue();
    }

    public void m9857i(int i) {
        m9864w();
        this.f8959s.add(Integer.valueOf(i));
    }

    public float m9858q() {
        return this.f8962v;
    }

    public float m9859r() {
        return this.f8961u;
    }

    public boolean m9860s() {
        return this.f8963w != null;
    }

    public DashPathEffect m9861t() {
        return this.f8963w;
    }

    public boolean m9862u() {
        return this.f8965y;
    }

    public boolean m9863v() {
        return this.f8966z;
    }

    public void m9864w() {
        this.f8959s = new ArrayList();
    }

    public int m9865x() {
        return this.f8960t;
    }

    public boolean m9866y() {
        return this.f8958A;
    }

    public C2552e m9867z() {
        return this.f8964x;
    }
}
