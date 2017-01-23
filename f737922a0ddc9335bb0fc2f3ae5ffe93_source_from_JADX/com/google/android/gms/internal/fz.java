package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class fz extends n<fz> {
    public int DW;
    public int FH;
    public int Hw;
    private String Zo;
    public int j6;
    public int v5;

    public int DW() {
        return this.DW;
    }

    public void DW(int i) {
        this.DW = i;
    }

    public int FH() {
        return this.FH;
    }

    public void FH(int i) {
        this.FH = i;
    }

    public int Hw() {
        return this.Hw;
    }

    public void Hw(int i) {
        this.Hw = i;
    }

    public String Zo() {
        return this.Zo;
    }

    public int j6() {
        return this.j6;
    }

    public void j6(int i) {
        this.j6 = i;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((fz) nVar);
    }

    public void j6(fz fzVar) {
        if (this.j6 != 0) {
            fzVar.j6(this.j6);
        }
        if (this.DW != 0) {
            fzVar.DW(this.DW);
        }
        if (this.FH != 0) {
            fzVar.FH(this.FH);
        }
        if (this.Hw != 0) {
            fzVar.Hw(this.Hw);
        }
        if (this.v5 != 0) {
            fzVar.v5(this.v5);
        }
        if (!TextUtils.isEmpty(this.Zo)) {
            fzVar.j6(this.Zo);
        }
    }

    public void j6(String str) {
        this.Zo = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.Zo);
        hashMap.put("screenColors", Integer.valueOf(this.j6));
        hashMap.put("screenWidth", Integer.valueOf(this.DW));
        hashMap.put("screenHeight", Integer.valueOf(this.FH));
        hashMap.put("viewportWidth", Integer.valueOf(this.Hw));
        hashMap.put("viewportHeight", Integer.valueOf(this.v5));
        return n.j6((Object) hashMap);
    }

    public int v5() {
        return this.v5;
    }

    public void v5(int i) {
        this.v5 = i;
    }
}
