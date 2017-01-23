package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;

public final class gc extends n<gc> {
    public boolean DW;
    public String j6;

    public boolean DW() {
        return this.DW;
    }

    public String j6() {
        return this.j6;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((gc) nVar);
    }

    public void j6(gc gcVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            gcVar.j6(this.j6);
        }
        if (this.DW) {
            gcVar.j6(this.DW);
        }
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public void j6(boolean z) {
        this.DW = z;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.j6);
        hashMap.put("fatal", Boolean.valueOf(this.DW));
        return n.j6((Object) hashMap);
    }
}
