package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.em */
public class em {
    private final ii f10791a;
    private final boolean f10792b;
    private final String f10793c;

    public em(ii iiVar, Map<String, String> map) {
        this.f10791a = iiVar;
        this.f10793c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f10792b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.f10792b = true;
        }
    }

    public void m12609a() {
        if (this.f10791a == null) {
            C2972b.m11583d("AdWebView is null");
            return;
        }
        int b = "portrait".equalsIgnoreCase(this.f10793c) ? C2968s.m11527g().m13089b() : "landscape".equalsIgnoreCase(this.f10793c) ? C2968s.m11527g().m13075a() : this.f10792b ? -1 : C2968s.m11527g().m13092c();
        this.f10791a.m13234b(b);
    }
}
