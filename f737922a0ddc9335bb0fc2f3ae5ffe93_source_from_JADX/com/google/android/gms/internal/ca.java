package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@eh
public class ca implements by {
    private final cb j6;

    public ca(cb cbVar) {
        this.j6 = cbVar;
    }

    public void j6(fj fjVar, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.j6.j6(equals);
                this.j6.j6(equals2, parseFloat);
            }
        } catch (Throwable e) {
            b.DW("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.j6.j6(equals);
        this.j6.j6(equals2, parseFloat);
    }
}
