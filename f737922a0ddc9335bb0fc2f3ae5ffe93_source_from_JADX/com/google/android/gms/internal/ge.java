package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.n;
import com.google.android.gms.common.internal.b;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ge extends n<ge> {
    private int DW;
    private int FH;
    private String Hw;
    private boolean VH;
    private boolean Zo;
    private String j6;
    private String v5;

    public ge() {
        this(false);
    }

    public ge(boolean z) {
        this(z, j6());
    }

    public ge(boolean z, int i) {
        b.j6(i);
        this.DW = i;
        this.VH = z;
    }

    static int j6() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Integer.MAX_VALUE;
    }

    private void v5() {
    }

    public String DW() {
        return this.j6;
    }

    public void DW(int i) {
        v5();
        this.FH = i;
    }

    public void DW(String str) {
        v5();
        this.Hw = str;
    }

    public void DW(boolean z) {
        v5();
        this.Zo = z;
    }

    public int FH() {
        return this.DW;
    }

    public void FH(String str) {
        v5();
        if (TextUtils.isEmpty(str)) {
            this.v5 = null;
        } else {
            this.v5 = str;
        }
    }

    public String Hw() {
        return this.v5;
    }

    public void j6(int i) {
        v5();
        this.DW = i;
    }

    public /* synthetic */ void j6(n nVar) {
        j6((ge) nVar);
    }

    public void j6(ge geVar) {
        if (!TextUtils.isEmpty(this.j6)) {
            geVar.j6(this.j6);
        }
        if (this.DW != 0) {
            geVar.j6(this.DW);
        }
        if (this.FH != 0) {
            geVar.DW(this.FH);
        }
        if (!TextUtils.isEmpty(this.Hw)) {
            geVar.DW(this.Hw);
        }
        if (!TextUtils.isEmpty(this.v5)) {
            geVar.FH(this.v5);
        }
        if (this.Zo) {
            geVar.DW(this.Zo);
        }
        if (this.VH) {
            geVar.j6(this.VH);
        }
    }

    public void j6(String str) {
        v5();
        this.j6 = str;
    }

    public void j6(boolean z) {
        v5();
        this.VH = z;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.j6);
        hashMap.put("interstitial", Boolean.valueOf(this.Zo));
        hashMap.put("automatic", Boolean.valueOf(this.VH));
        hashMap.put("screenId", Integer.valueOf(this.DW));
        hashMap.put("referrerScreenId", Integer.valueOf(this.FH));
        hashMap.put("referrerScreenName", this.Hw);
        hashMap.put("referrerUri", this.v5);
        return n.j6((Object) hashMap);
    }
}
