package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class fv extends n<fv> {
    private String DW;
    private String FH;
    private String Hw;
    private String VH;
    private String Zo;
    private String gn;
    private String j6;
    private String tp;
    private String u7;
    private String v5;

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

    public String Hw() {
        return this.Hw;
    }

    public void Hw(String str) {
        this.Hw = str;
    }

    public String VH() {
        return this.VH;
    }

    public void VH(String str) {
        this.VH = str;
    }

    public String Zo() {
        return this.Zo;
    }

    public void Zo(String str) {
        this.Zo = str;
    }

    public String gn() {
        return this.gn;
    }

    public void gn(String str) {
        this.gn = str;
    }

    public String j6() {
        return this.j6;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((fv) nVar);
    }

    public void j6(fv fvVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            fvVar.j6(this.j6);
        }
        if (!TextUtils.isEmpty(this.DW)) {
            fvVar.DW(this.DW);
        }
        if (!TextUtils.isEmpty(this.FH)) {
            fvVar.FH(this.FH);
        }
        if (!TextUtils.isEmpty(this.Hw)) {
            fvVar.Hw(this.Hw);
        }
        if (!TextUtils.isEmpty(this.v5)) {
            fvVar.v5(this.v5);
        }
        if (!TextUtils.isEmpty(this.Zo)) {
            fvVar.Zo(this.Zo);
        }
        if (!TextUtils.isEmpty(this.VH)) {
            fvVar.VH(this.VH);
        }
        if (!TextUtils.isEmpty(this.gn)) {
            fvVar.gn(this.gn);
        }
        if (!TextUtils.isEmpty(this.u7)) {
            fvVar.u7(this.u7);
        }
        if (!TextUtils.isEmpty(this.tp)) {
            fvVar.tp(this.tp);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.j6);
        hashMap.put("source", this.DW);
        hashMap.put("medium", this.FH);
        hashMap.put("keyword", this.Hw);
        hashMap.put("content", this.v5);
        hashMap.put("id", this.Zo);
        hashMap.put("adNetworkId", this.VH);
        hashMap.put("gclid", this.gn);
        hashMap.put("dclid", this.u7);
        hashMap.put("aclid", this.tp);
        return n.j6((Object) hashMap);
    }

    public String tp() {
        return this.tp;
    }

    public void tp(String str) {
        this.tp = str;
    }

    public String u7() {
        return this.u7;
    }

    public void u7(String str) {
        this.u7 = str;
    }

    public String v5() {
        return this.v5;
    }

    public void v5(String str) {
        this.v5 = str;
    }
}
