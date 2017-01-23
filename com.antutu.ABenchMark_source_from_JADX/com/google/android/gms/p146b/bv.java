package com.google.android.gms.p146b;

import anet.channel.strategy.dispatch.C0720e;

/* renamed from: com.google.android.gms.b.bv */
public class bv implements ju {
    private int f10381a;
    private int f10382b;
    private final int f10383c;
    private final float f10384d;

    public bv() {
        this(C0720e.REQUEST_MERGE_PERIOD, 1, 1.0f);
    }

    public bv(int i, int i2, float f) {
        this.f10381a = i;
        this.f10383c = i2;
        this.f10384d = f;
    }

    public int m11963a() {
        return this.f10381a;
    }

    public void m11964a(jz jzVar) {
        this.f10382b++;
        this.f10381a = (int) (((float) this.f10381a) + (((float) this.f10381a) * this.f10384d));
        if (!m11966c()) {
            throw jzVar;
        }
    }

    public int m11965b() {
        return this.f10382b;
    }

    protected boolean m11966c() {
        return this.f10382b <= this.f10383c;
    }
}
