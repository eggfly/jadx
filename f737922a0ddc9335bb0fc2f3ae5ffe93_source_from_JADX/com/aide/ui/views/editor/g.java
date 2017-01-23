package com.aide.ui.views.editor;

import android.graphics.Color;

public class g {
    public static final g DW;
    public static final g FH;
    public static final g Hw;
    public static final g VH;
    public static final g Zo;
    public static final g gn;
    public static final g j6;
    public static final g u7;
    public static final g v5;
    private int tp;

    static {
        j6 = new g(-256);
        DW = new g(-65536);
        FH = new g(-16711936);
        Hw = new g(-256);
        v5 = new g(-16776961);
        Zo = new g(-16777216);
        VH = new g(-5592406);
        gn = new g(-1);
        u7 = new g(0);
    }

    public g(int i) {
        this.tp = i;
    }

    public g(int i, int i2, int i3) {
        this.tp = Color.rgb(i, i2, i3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && ((g) obj).tp == this.tp;
    }

    public int j6() {
        return this.tp;
    }

    public int DW() {
        return Color.red(this.tp);
    }

    public int FH() {
        return Color.green(this.tp);
    }

    public int Hw() {
        return Color.blue(this.tp);
    }
}
