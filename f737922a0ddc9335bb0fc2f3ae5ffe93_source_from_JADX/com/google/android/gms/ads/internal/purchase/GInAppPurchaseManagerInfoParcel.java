package com.google.android.gms.ads.internal.purchase;

import agg$a;
import agh;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eh;

@eh
public final class GInAppPurchaseManagerInfoParcel extends AbstractSafeParcelable {
    public static final a CREATOR;
    public final d DW;
    public final dt FH;
    public final Context Hw;
    public final int j6;
    public final c v5;

    static {
        CREATOR = new a();
    }

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.j6 = i;
        this.DW = (d) agh.j6(agg$a.j6(iBinder));
        this.FH = (dt) agh.j6(agg$a.j6(iBinder2));
        this.Hw = (Context) agh.j6(agg$a.j6(iBinder3));
        this.v5 = (c) agh.j6(agg$a.j6(iBinder4));
    }

    IBinder DW() {
        return agh.j6(this.DW).asBinder();
    }

    IBinder FH() {
        return agh.j6(this.FH).asBinder();
    }

    IBinder Hw() {
        return agh.j6(this.Hw).asBinder();
    }

    IBinder j6() {
        return agh.j6(this.v5).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
