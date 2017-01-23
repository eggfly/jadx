package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.k */
public class C2894k {
    private final String f9795a;

    public C2894k(String str) {
        this.f9795a = str;
    }

    public String m11261a() {
        return C2968s.m11525e().m13058c();
    }

    public boolean m11262a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String b = C2968s.m11535o().m11258b(intent);
        String c = C2968s.m11535o().m11260c(intent);
        if (b == null || c == null) {
            return false;
        }
        if (!str.equals(C2968s.m11535o().m11255a(b))) {
            C2972b.m11583d("Developer payload not match.");
            return false;
        } else if (this.f9795a == null || C2895l.m11264a(this.f9795a, b, c)) {
            return true;
        } else {
            C2972b.m11583d("Fail to verify signature.");
            return false;
        }
    }
}
