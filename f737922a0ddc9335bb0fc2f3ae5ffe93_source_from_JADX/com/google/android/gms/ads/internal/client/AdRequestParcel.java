package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;
import java.util.List;

@eh
public final class AdRequestParcel extends AbstractSafeParcelable {
    public static final r CREATOR;
    public final long DW;
    public final Location EQ;
    public final Bundle FH;
    public final int Hw;
    public final Bundle J0;
    public final Bundle J8;
    public final String QX;
    public final int VH;
    public final List<String> Ws;
    public final String XL;
    public final boolean Zo;
    public final boolean aM;
    public final boolean gn;
    public final int j6;
    public final SearchAdRequestParcel tp;
    public final String u7;
    public final List<String> v5;
    public final String we;

    static {
        CREATOR = new r();
    }

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.j6 = i;
        this.DW = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.FH = bundle;
        this.Hw = i2;
        this.v5 = list;
        this.Zo = z;
        this.VH = i3;
        this.gn = z2;
        this.u7 = str;
        this.tp = searchAdRequestParcel;
        this.EQ = location;
        this.we = str2;
        this.J0 = bundle2;
        this.J8 = bundle3;
        this.Ws = list2;
        this.QX = str3;
        this.XL = str4;
        this.aM = z3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.j6 == adRequestParcel.j6 && this.DW == adRequestParcel.DW && ae.j6(this.FH, adRequestParcel.FH) && this.Hw == adRequestParcel.Hw && ae.j6(this.v5, adRequestParcel.v5) && this.Zo == adRequestParcel.Zo && this.VH == adRequestParcel.VH && this.gn == adRequestParcel.gn && ae.j6(this.u7, adRequestParcel.u7) && ae.j6(this.tp, adRequestParcel.tp) && ae.j6(this.EQ, adRequestParcel.EQ) && ae.j6(this.we, adRequestParcel.we) && ae.j6(this.J0, adRequestParcel.J0) && ae.j6(this.J8, adRequestParcel.J8) && ae.j6(this.Ws, adRequestParcel.Ws) && ae.j6(this.QX, adRequestParcel.QX) && ae.j6(this.XL, adRequestParcel.XL) && this.aM == adRequestParcel.aM;
    }

    public int hashCode() {
        return ae.j6(Integer.valueOf(this.j6), Long.valueOf(this.DW), this.FH, Integer.valueOf(this.Hw), this.v5, Boolean.valueOf(this.Zo), Integer.valueOf(this.VH), Boolean.valueOf(this.gn), this.u7, this.tp, this.EQ, this.we, this.J0, this.J8, this.Ws, this.QX, this.XL, Boolean.valueOf(this.aM));
    }

    public void writeToParcel(Parcel parcel, int i) {
        r.j6(this, parcel, i);
    }
}
