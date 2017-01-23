package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p149d.C2718a;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.reward.client.d */
public class C2959d implements C2718a {
    private final C2950a f10009a;

    public C2959d(C2950a c2950a) {
        this.f10009a = c2950a;
    }

    public String m11472a() {
        String str = null;
        if (this.f10009a != null) {
            try {
                str = this.f10009a.m11449a();
            } catch (Throwable e) {
                C2972b.m11584d("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }

    public int m11473b() {
        int i = 0;
        if (this.f10009a != null) {
            try {
                i = this.f10009a.m11450b();
            } catch (Throwable e) {
                C2972b.m11584d("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }
}
