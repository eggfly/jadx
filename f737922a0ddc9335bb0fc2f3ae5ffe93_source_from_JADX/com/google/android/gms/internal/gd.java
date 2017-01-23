package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import com.google.android.gms.common.internal.b;
import java.util.HashMap;
import java.util.Map;

public final class gd extends n<gd> {
    private String DW;
    private String FH;
    private String Hw;
    private boolean VH;
    private String Zo;
    private double gn;
    private String j6;
    private boolean v5;

    public String DW() {
        return this.DW;
    }

    public void DW(String str) {
        this.DW = str;
    }

    public void DW(boolean z) {
        this.VH = z;
    }

    public String FH() {
        return this.FH;
    }

    public void FH(String str) {
        this.FH = str;
    }

    public String Hw() {
        return this.Hw;
    }

    public void Hw(String str) {
        this.Hw = str;
    }

    public boolean VH() {
        return this.VH;
    }

    public String Zo() {
        return this.Zo;
    }

    public double gn() {
        return this.gn;
    }

    public String j6() {
        return this.j6;
    }

    public void j6(double d) {
        boolean z = d >= 0.0d && d <= 100.0d;
        b.DW(z, "Sample rate must be between 0% and 100%");
        this.gn = d;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((gd) nVar);
    }

    public void j6(gd gdVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            gdVar.j6(this.j6);
        }
        if (!TextUtils.isEmpty(this.DW)) {
            gdVar.DW(this.DW);
        }
        if (!TextUtils.isEmpty(this.FH)) {
            gdVar.FH(this.FH);
        }
        if (!TextUtils.isEmpty(this.Hw)) {
            gdVar.Hw(this.Hw);
        }
        if (this.v5) {
            gdVar.j6(true);
        }
        if (!TextUtils.isEmpty(this.Zo)) {
            gdVar.v5(this.Zo);
        }
        if (this.VH) {
            gdVar.DW(this.VH);
        }
        if (this.gn != 0.0d) {
            gdVar.j6(this.gn);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public void j6(boolean z) {
        this.v5 = z;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.j6);
        hashMap.put("clientId", this.DW);
        hashMap.put("userId", this.FH);
        hashMap.put("androidAdId", this.Hw);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.v5));
        hashMap.put("sessionControl", this.Zo);
        hashMap.put("nonInteraction", Boolean.valueOf(this.VH));
        hashMap.put("sampleRate", Double.valueOf(this.gn));
        return n.j6((Object) hashMap);
    }

    public void v5(String str) {
        this.Zo = str;
    }

    public boolean v5() {
        return this.v5;
    }
}
