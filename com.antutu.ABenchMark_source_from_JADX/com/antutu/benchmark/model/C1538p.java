package com.antutu.benchmark.model;

import android.widget.CompoundButton.OnCheckedChangeListener;

/* renamed from: com.antutu.benchmark.model.p */
public class C1538p {
    private String f5351a;
    private int f5352b;
    private int f5353c;
    private boolean f5354d;
    private int f5355e;
    private boolean f5356f;
    private OnCheckedChangeListener f5357g;

    public C1538p(int i, int i2) {
        this.f5351a = "NORMAL_TYPE";
        this.f5352b = i;
        this.f5353c = i2;
    }

    public C1538p(int i, int i2, int i3, boolean z, OnCheckedChangeListener onCheckedChangeListener) {
        this.f5351a = "SWITCH_TYPE";
        this.f5352b = i;
        this.f5353c = i2;
        this.f5355e = i3;
        this.f5357g = onCheckedChangeListener;
        this.f5356f = z;
    }

    public int m6089a() {
        return this.f5352b;
    }

    public void m6090a(boolean z) {
        this.f5356f = z;
    }

    public int m6091b() {
        return this.f5353c;
    }

    public boolean m6092c() {
        return this.f5354d;
    }

    public String m6093d() {
        return this.f5351a;
    }

    public int m6094e() {
        return this.f5355e;
    }

    public OnCheckedChangeListener m6095f() {
        return this.f5357g;
    }

    public boolean m6096g() {
        return this.f5356f;
    }
}
