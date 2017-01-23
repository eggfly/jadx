package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<SafeParcelResponse> {
    static void j6(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, safeParcelResponse.Hw());
        b.j6(parcel, 2, safeParcelResponse.v5(), false);
        b.j6(parcel, 3, safeParcelResponse.Zo(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public SafeParcelResponse j6(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int DW = a.DW(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel2 = a.gW(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    fieldMappingDictionary = (FieldMappingDictionary) a.j6(parcel, j6, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public SafeParcelResponse[] j6(int i) {
        return new SafeParcelResponse[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
