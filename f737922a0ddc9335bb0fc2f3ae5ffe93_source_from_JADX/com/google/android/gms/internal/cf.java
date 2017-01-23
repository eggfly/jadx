package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@eh
class cf implements by {
    cf() {
    }

    private int j6(Map<String, String> map) {
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        return (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
    }

    public void j6(fj fjVar, Map<String, String> map) {
        Throwable e;
        if (((Boolean) aq.cT.FH()).booleanValue()) {
            fn fnVar;
            fn rN = fjVar.rN();
            if (rN == null) {
                try {
                    rN = new fn(fjVar, Float.parseFloat((String) map.get("duration")));
                    fjVar.j6(rN);
                    fnVar = rN;
                } catch (NullPointerException e2) {
                    e = e2;
                    b.DW("Unable to parse videoMeta message.", e);
                    f.Zo().j6(e, true);
                    return;
                } catch (NumberFormatException e3) {
                    e = e3;
                    b.DW("Unable to parse videoMeta message.", e);
                    f.Zo().j6(e, true);
                    return;
                }
            }
            fnVar = rN;
            fnVar.j6(Float.parseFloat((String) map.get("currentTime")), j6(map), "1".equals(map.get("muted")));
        }
    }
}
