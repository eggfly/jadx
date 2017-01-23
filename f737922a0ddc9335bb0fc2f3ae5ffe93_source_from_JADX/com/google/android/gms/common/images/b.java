package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<WebImage> {
    static void j6(WebImage webImage, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, webImage.j6());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, webImage.DW(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, webImage.FH());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, webImage.Hw());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public WebImage j6(Parcel parcel) {
        int i = 0;
        int DW = a.DW(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < DW) {
            Uri uri2;
            int Hw;
            int j6 = a.j6(parcel);
            int i4;
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    Hw = a.Hw(parcel, j6);
                    j6 = i4;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i3;
                    i4 = i2;
                    uri2 = (Uri) a.j6(parcel, j6, Uri.CREATOR);
                    j6 = i;
                    i = i4;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    uri2 = uri;
                    Hw = i3;
                    i4 = i;
                    i = a.Hw(parcel, j6);
                    j6 = i4;
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    j6 = a.Hw(parcel, j6);
                    i = i2;
                    uri2 = uri;
                    Hw = i3;
                    break;
                default:
                    a.DW(parcel, j6);
                    j6 = i;
                    i = i2;
                    uri2 = uri;
                    Hw = i3;
                    break;
            }
            i3 = Hw;
            uri = uri2;
            i2 = i;
            i = j6;
        }
        if (parcel.dataPosition() == DW) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public WebImage[] j6(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
