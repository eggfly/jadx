package com.google.android.gms.ads.internal.reward.client;

import afe;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.eh;

@eh
public class e implements afe {
    private final a j6;

    public e(a aVar) {
        this.j6 = aVar;
    }

    public int DW() {
        int i = 0;
        if (this.j6 != null) {
            try {
                i = this.j6.DW();
            } catch (Throwable e) {
                b.FH("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }

    public String j6() {
        String str = null;
        if (this.j6 != null) {
            try {
                str = this.j6.j6();
            } catch (Throwable e) {
                b.FH("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }
}
