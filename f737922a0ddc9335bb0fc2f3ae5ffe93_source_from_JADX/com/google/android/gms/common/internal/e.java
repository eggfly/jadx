package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<SignInButtonConfig> {
    static void j6(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, signInButtonConfig.j6);
        b.j6(parcel, 2, signInButtonConfig.j6());
        b.j6(parcel, 3, signInButtonConfig.DW());
        b.j6(parcel, 4, signInButtonConfig.FH(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public SignInButtonConfig j6(Parcel parcel) {
        int i = 0;
        int DW = a.DW(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    scopeArr = (Scope[]) a.DW(parcel, j6, Scope.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public SignInButtonConfig[] j6(int i) {
        return new SignInButtonConfig[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
