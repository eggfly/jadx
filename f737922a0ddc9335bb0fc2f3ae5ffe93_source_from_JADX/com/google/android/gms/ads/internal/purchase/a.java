package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void j6(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, gInAppPurchaseManagerInfoParcel.j6);
        b.j6(parcel, 3, gInAppPurchaseManagerInfoParcel.DW(), false);
        b.j6(parcel, 4, gInAppPurchaseManagerInfoParcel.FH(), false);
        b.j6(parcel, 5, gInAppPurchaseManagerInfoParcel.Hw(), false);
        b.j6(parcel, 6, gInAppPurchaseManagerInfoParcel.j6(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public GInAppPurchaseManagerInfoParcel j6(Parcel parcel) {
        IBinder iBinder = null;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.a.Ws(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.a.Ws(parcel, j6);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.a.Ws(parcel, j6);
                    break;
                case 6:
                    iBinder = com.google.android.gms.common.internal.safeparcel.a.Ws(parcel, j6);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public GInAppPurchaseManagerInfoParcel[] j6(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
