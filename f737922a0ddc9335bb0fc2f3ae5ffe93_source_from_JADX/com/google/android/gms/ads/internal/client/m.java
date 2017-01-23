package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<VideoOptionsParcel> {
    static void j6(VideoOptionsParcel videoOptionsParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, videoOptionsParcel.j6);
        b.j6(parcel, 2, videoOptionsParcel.DW);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public VideoOptionsParcel j6(Parcel parcel) {
        boolean z = false;
        int DW = a.DW(parcel);
        int i = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    z = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new VideoOptionsParcel(i, z);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public VideoOptionsParcel[] j6(int i) {
        return new VideoOptionsParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
