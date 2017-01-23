package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public final class AdLauncherIntentInfoParcel extends AbstractSafeParcelable {
    public static final b CREATOR;
    public final String DW;
    public final String FH;
    public final String Hw;
    public final String VH;
    public final String Zo;
    public final String gn;
    public final int j6;
    public final Intent u7;
    public final String v5;

    static {
        CREATOR = new b();
    }

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.j6 = i;
        this.DW = str;
        this.FH = str2;
        this.Hw = str3;
        this.v5 = str4;
        this.Zo = str5;
        this.VH = str6;
        this.gn = str7;
        this.u7 = intent;
    }

    public AdLauncherIntentInfoParcel(Intent intent) {
        this(2, null, null, null, null, null, null, null, intent);
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(2, str, str2, str3, str4, str5, str6, str7, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
