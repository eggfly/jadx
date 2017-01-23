package com.google.android.gms.internal;

import aeo$a;
import aeo$b;
import aep;
import com.aide.uidesigner.ProxyTextView;
import com.google.ads.mediation.b;
import com.google.android.gms.ads.h;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Date;
import java.util.HashSet;

@eh
public final class df {

    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] DW;
        static final /* synthetic */ int[] j6;

        static {
            DW = new int[aeo$a.values().length];
            try {
                DW[aeo$a.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                DW[aeo$a.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                DW[aeo$a.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                DW[aeo$a.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            j6 = new int[aeo$b.values().length];
            try {
                j6[aeo$b.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                j6[aeo$b.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                j6[aeo$b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int j6(aeo$a aeo_a) {
        switch (1.DW[aeo_a.ordinal()]) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return 1;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return 2;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static aeo$b j6(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return aeo$b.MALE;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return aeo$b.FEMALE;
            default:
                return aeo$b.UNKNOWN;
        }
    }

    public static aep j6(AdSizeParcel adSizeParcel) {
        int i = 0;
        aep[] aepArr = new aep[]{aep.j6, aep.DW, aep.FH, aep.Hw, aep.v5, aep.Zo};
        while (i < 6) {
            if (aepArr[i].j6() == adSizeParcel.Zo && aepArr[i].DW() == adSizeParcel.FH) {
                return aepArr[i];
            }
            i++;
        }
        return new aep(h.j6(adSizeParcel.Zo, adSizeParcel.FH, adSizeParcel.DW));
    }

    public static b j6(AdRequestParcel adRequestParcel) {
        return new b(new Date(adRequestParcel.DW), j6(adRequestParcel.Hw), adRequestParcel.v5 != null ? new HashSet(adRequestParcel.v5) : null, adRequestParcel.Zo, adRequestParcel.EQ);
    }
}
