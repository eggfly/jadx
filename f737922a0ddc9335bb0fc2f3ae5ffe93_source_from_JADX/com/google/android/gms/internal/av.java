package com.google.android.gms.internal;

public class av implements gu {
    private int DW;
    private final int FH;
    private final float Hw;
    private int j6;

    public av() {
        this(2500, 1, 1.0f);
    }

    public av(int i, int i2, float f) {
        this.j6 = i;
        this.FH = i2;
        this.Hw = f;
    }

    public int DW() {
        return this.DW;
    }

    protected boolean FH() {
        return this.DW <= this.FH;
    }

    public int j6() {
        return this.j6;
    }

    public void j6(hp hpVar) {
        this.DW++;
        this.j6 = (int) (((float) this.j6) + (((float) this.j6) * this.Hw));
        if (!FH()) {
            throw hpVar;
        }
    }
}
