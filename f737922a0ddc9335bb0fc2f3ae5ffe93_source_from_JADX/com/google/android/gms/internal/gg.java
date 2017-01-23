package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class gg extends n<gg> {
    public long DW;
    public String FH;
    public String Hw;
    public String j6;

    public long DW() {
        return this.DW;
    }

    public void DW(String str) {
        this.FH = str;
    }

    public String FH() {
        return this.FH;
    }

    public void FH(String str) {
        this.Hw = str;
    }

    public String Hw() {
        return this.Hw;
    }

    public String j6() {
        return this.j6;
    }

    public void j6(long j) {
        this.DW = j;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((gg) nVar);
    }

    public void j6(gg ggVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            ggVar.j6(this.j6);
        }
        if (this.DW != 0) {
            ggVar.j6(this.DW);
        }
        if (!TextUtils.isEmpty(this.FH)) {
            ggVar.DW(this.FH);
        }
        if (!TextUtils.isEmpty(this.Hw)) {
            ggVar.FH(this.Hw);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.j6);
        hashMap.put("timeInMillis", Long.valueOf(this.DW));
        hashMap.put("category", this.FH);
        hashMap.put("label", this.Hw);
        return n.j6((Object) hashMap);
    }
}
