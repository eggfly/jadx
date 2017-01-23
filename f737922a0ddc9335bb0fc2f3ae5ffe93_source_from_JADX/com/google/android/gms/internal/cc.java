package com.google.android.gms.internal;

import afr;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.ads.internal.zze;
import java.util.Map;

@eh
public class cc implements by {
    static final Map<String, Integer> j6;
    private final zze DW;
    private final dh FH;

    static {
        j6 = afr.j6("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    }

    public cc(zze com_google_android_gms_ads_internal_zze, dh dhVar) {
        this.DW = com_google_android_gms_ads_internal_zze;
        this.FH = dhVar;
    }

    public void j6(fj fjVar, Map<String, String> map) {
        int intValue = ((Integer) j6.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.DW == null || this.DW.j6()) {
            switch (intValue) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.FH.j6((Map) map);
                    return;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    new dj(fjVar, map).j6();
                    return;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    new dg(fjVar, map).j6();
                    return;
                case 5:
                    new di(fjVar, map).j6();
                    return;
                case 6:
                    this.FH.j6(true);
                    return;
                default:
                    b.FH("Unknown MRAID command called.");
                    return;
            }
        }
        this.DW.j6(null);
    }
}
