package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public final class SearchAdRequestParcel extends AbstractSafeParcelable {
    public static final k CREATOR;
    public final int DW;
    public final int EQ;
    public final int FH;
    public final int Hw;
    public final int J0;
    public final int J8;
    public final int VH;
    public final String Ws;
    public final int Zo;
    public final int gn;
    public final int j6;
    public final String tp;
    public final int u7;
    public final int v5;
    public final String we;

    static {
        CREATOR = new k();
    }

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = i4;
        this.v5 = i5;
        this.Zo = i6;
        this.VH = i7;
        this.gn = i8;
        this.u7 = i9;
        this.tp = str;
        this.EQ = i10;
        this.we = str2;
        this.J0 = i11;
        this.J8 = i12;
        this.Ws = str3;
    }

    public SearchAdRequestParcel(a aVar) {
        this.j6 = 1;
        this.DW = aVar.j6();
        this.FH = aVar.DW();
        this.Hw = aVar.FH();
        this.v5 = aVar.Hw();
        this.Zo = aVar.v5();
        this.VH = aVar.Zo();
        this.gn = aVar.VH();
        this.u7 = aVar.gn();
        this.tp = aVar.u7();
        this.EQ = aVar.tp();
        this.we = aVar.EQ();
        this.J0 = aVar.we();
        this.J8 = aVar.J0();
        this.Ws = aVar.J8();
    }

    public void writeToParcel(Parcel parcel, int i) {
        k.j6(this, parcel, i);
    }
}
