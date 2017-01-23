package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class c implements Creator<LogEventParcelable> {
    static void j6(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, logEventParcelable.j6);
        b.j6(parcel, 2, logEventParcelable.DW, i, false);
        b.j6(parcel, 3, logEventParcelable.FH, false);
        b.j6(parcel, 4, logEventParcelable.Hw, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public LogEventParcelable j6(Parcel parcel) {
        int[] iArr = null;
        int DW = a.DW(parcel);
        int i = 0;
        byte[] bArr = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < DW) {
            byte[] bArr2;
            PlayLoggerContext playLoggerContext2;
            int Hw;
            int[] iArr2;
            int j6 = a.j6(parcel);
            int[] iArr3;
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    iArr3 = iArr;
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    Hw = a.Hw(parcel, j6);
                    iArr2 = iArr3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i;
                    byte[] bArr3 = bArr;
                    playLoggerContext2 = (PlayLoggerContext) a.j6(parcel, j6, PlayLoggerContext.CREATOR);
                    iArr2 = iArr;
                    bArr2 = bArr3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    playLoggerContext2 = playLoggerContext;
                    Hw = i;
                    iArr3 = iArr;
                    bArr2 = a.XL(parcel, j6);
                    iArr2 = iArr3;
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    iArr2 = a.j3(parcel, j6);
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    Hw = i;
                    break;
                default:
                    a.DW(parcel, j6);
                    iArr2 = iArr;
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    Hw = i;
                    break;
            }
            i = Hw;
            playLoggerContext = playLoggerContext2;
            bArr = bArr2;
            iArr = iArr2;
        }
        if (parcel.dataPosition() == DW) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public LogEventParcelable[] j6(int i) {
        return new LogEventParcelable[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
