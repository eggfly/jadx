package com.google.android.gms.internal;

public abstract class t {
    protected volatile int J8;

    public t() {
        this.J8 = -1;
    }

    public abstract t DW(l lVar);

    protected int FH() {
        return 0;
    }

    public int VH() {
        int FH = FH();
        this.J8 = FH;
        return FH;
    }

    public int Zo() {
        if (this.J8 < 0) {
            VH();
        }
        return this.J8;
    }

    public /* synthetic */ Object clone() {
        return v5();
    }

    public void j6(m mVar) {
    }

    public String toString() {
        return u.j6(this);
    }

    public t v5() {
        return (t) super.clone();
    }
}
