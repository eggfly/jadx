package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@eh
public class di {
    private final boolean DW;
    private final String FH;
    private final fj j6;

    public di(fj fjVar, Map<String, String> map) {
        this.j6 = fjVar;
        this.FH = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.DW = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.DW = true;
        }
    }

    public void j6() {
        if (this.j6 == null) {
            b.Hw("AdWebView is null");
            return;
        }
        int DW = "portrait".equalsIgnoreCase(this.FH) ? f.v5().DW() : "landscape".equalsIgnoreCase(this.FH) ? f.v5().j6() : this.DW ? -1 : f.v5().FH();
        this.j6.DW(DW);
    }
}
