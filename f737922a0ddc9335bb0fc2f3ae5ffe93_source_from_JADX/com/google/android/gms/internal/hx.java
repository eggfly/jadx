package com.google.android.gms.internal;

import com.google.android.gms.common.api.a.a.d;

public final class hx implements d {
    public static final hx j6;
    private final boolean DW;
    private final boolean FH;
    private final String Hw;
    private final boolean VH;
    private final String Zo;
    private final boolean v5;

    public static final class a {
        public hx j6() {
            return new hx(false, null, false, null, false, null);
        }
    }

    static {
        j6 = new a().j6();
    }

    private hx(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4) {
        this.DW = z;
        this.FH = z2;
        this.Hw = str;
        this.v5 = z3;
        this.VH = z4;
        this.Zo = str2;
    }

    public boolean DW() {
        return this.FH;
    }

    public String FH() {
        return this.Hw;
    }

    public boolean Hw() {
        return this.v5;
    }

    public boolean Zo() {
        return this.VH;
    }

    public boolean j6() {
        return this.DW;
    }

    public String v5() {
        return this.Zo;
    }
}
