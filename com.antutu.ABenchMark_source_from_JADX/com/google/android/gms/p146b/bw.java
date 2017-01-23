package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.bw */
public final class bw implements cb {
    private final bx f10385a;

    public bw(bx bxVar) {
        this.f10385a = bxVar;
    }

    public void m11967a(ii iiVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            C2972b.m11583d("App event with no name parameter.");
        } else {
            this.f10385a.m10418a(str, (String) map.get("info"));
        }
    }
}
