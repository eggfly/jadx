package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class fu extends n<fu> {
    private String DW;
    private String FH;
    private String Hw;
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

    public String Hw() {
        return this.Hw;
    }

    public void Hw(String str) {
        this.Hw = str;
    }

    public String j6() {
        return this.j6;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((fu) nVar);
    }

    public void j6(fu fuVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            fuVar.j6(this.j6);
        }
        if (!TextUtils.isEmpty(this.DW)) {
            fuVar.DW(this.DW);
        }
        if (!TextUtils.isEmpty(this.FH)) {
            fuVar.FH(this.FH);
        }
        if (!TextUtils.isEmpty(this.Hw)) {
            fuVar.Hw(this.Hw);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.j6);
        hashMap.put("appVersion", this.DW);
        hashMap.put("appId", this.FH);
        hashMap.put("appInstallerId", this.Hw);
        return n.j6((Object) hashMap);
    }
}
