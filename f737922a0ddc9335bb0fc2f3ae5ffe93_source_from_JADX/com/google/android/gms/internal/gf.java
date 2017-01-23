package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class gf extends n<gf> {
    public String DW;
    public String FH;
    public String j6;

    public String DW() {
        return this.DW;
    }

    public void DW(String str) {
        this.DW = str;
    }

    public String FH() {
        return this.FH;
    }

    public void FH(String str) {
        this.FH = str;
    }

    public String j6() {
        return this.j6;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((gf) nVar);
    }

    public void j6(gf gfVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            gfVar.j6(this.j6);
        }
        if (!TextUtils.isEmpty(this.DW)) {
            gfVar.DW(this.DW);
        }
        if (!TextUtils.isEmpty(this.FH)) {
            gfVar.FH(this.FH);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.j6);
        hashMap.put("action", this.DW);
        hashMap.put("target", this.FH);
        return n.j6((Object) hashMap);
    }
}
