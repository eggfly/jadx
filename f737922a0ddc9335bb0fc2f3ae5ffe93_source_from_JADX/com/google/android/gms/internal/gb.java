package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class gb extends n<gb> {
    private String DW;
    private String FH;
    private long Hw;
    private String j6;

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

    public long Hw() {
        return this.Hw;
    }

    public String j6() {
        return this.j6;
    }

    public void j6(long j) {
        this.Hw = j;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((gb) nVar);
    }

    public void j6(gb gbVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            gbVar.j6(this.j6);
        }
        if (!TextUtils.isEmpty(this.DW)) {
            gbVar.DW(this.DW);
        }
        if (!TextUtils.isEmpty(this.FH)) {
            gbVar.FH(this.FH);
        }
        if (this.Hw != 0) {
            gbVar.j6(this.Hw);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.j6);
        hashMap.put("action", this.DW);
        hashMap.put("label", this.FH);
        hashMap.put("value", Long.valueOf(this.Hw));
        return n.j6((Object) hashMap);
    }
}
