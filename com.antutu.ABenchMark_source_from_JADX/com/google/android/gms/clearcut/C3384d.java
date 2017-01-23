package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.clearcut.d */
public class C3384d implements Creator<LogEventParcelable> {
    static void m13946a(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, logEventParcelable.f11776a);
        C3508b.m14562a(parcel, 2, logEventParcelable.f11777b, i, false);
        C3508b.m14568a(parcel, 3, logEventParcelable.f11778c, false);
        C3508b.m14569a(parcel, 4, logEventParcelable.f11779d, false);
        C3508b.m14555a(parcel, a);
    }

    public LogEventParcelable m13947a(Parcel parcel) {
        int[] iArr = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        byte[] bArr = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < b) {
            byte[] bArr2;
            PlayLoggerContext playLoggerContext2;
            int d;
            int[] iArr2;
            int a = C3507a.m14521a(parcel);
            int[] iArr3;
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    iArr3 = iArr;
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    d = C3507a.m14531d(parcel, a);
                    iArr2 = iArr3;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    d = i;
                    byte[] bArr3 = bArr;
                    playLoggerContext2 = (PlayLoggerContext) C3507a.m14523a(parcel, a, PlayLoggerContext.CREATOR);
                    iArr2 = iArr;
                    bArr2 = bArr3;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    playLoggerContext2 = playLoggerContext;
                    d = i;
                    iArr3 = iArr;
                    bArr2 = C3507a.m14542o(parcel, a);
                    iArr2 = iArr3;
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    iArr2 = C3507a.m14544q(parcel, a);
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    d = i;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    iArr2 = iArr;
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    d = i;
                    break;
            }
            i = d;
            playLoggerContext = playLoggerContext2;
            bArr = bArr2;
            iArr = iArr2;
        }
        if (parcel.dataPosition() == b) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public LogEventParcelable[] m13948a(int i) {
        return new LogEventParcelable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13947a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m13948a(i);
    }
}
