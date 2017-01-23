package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class o implements ae {
    public double DW;
    public int FH;
    public int Hw;
    public Map<String, String> VH;
    public int Zo;
    public String j6;
    public int v5;

    public o() {
        this.DW = -1.0d;
        this.FH = -1;
        this.Hw = -1;
        this.v5 = -1;
        this.Zo = -1;
        this.VH = new HashMap();
    }

    public String DW() {
        return this.j6;
    }

    public boolean EQ() {
        return this.Zo == 1;
    }

    public boolean FH() {
        return this.DW >= 0.0d;
    }

    public double Hw() {
        return this.DW;
    }

    public boolean VH() {
        return this.Hw != -1;
    }

    public int Zo() {
        return this.FH;
    }

    public boolean gn() {
        return this.Hw == 1;
    }

    public String j6(Activity activity) {
        return j6(activity.getClass().getCanonicalName());
    }

    public String j6(String str) {
        String str2 = (String) this.VH.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean j6() {
        return this.j6 != null;
    }

    public boolean tp() {
        return this.v5 == 1;
    }

    public boolean u7() {
        return this.v5 != -1;
    }

    public boolean v5() {
        return this.FH >= 0;
    }
}
