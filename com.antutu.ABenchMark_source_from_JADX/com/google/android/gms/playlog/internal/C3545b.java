package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.playlog.internal.b */
public class C3545b implements Creator<PlayLoggerContext> {
    static void m14751a(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, playLoggerContext.f12236a);
        C3508b.m14565a(parcel, 2, playLoggerContext.f12237b, false);
        C3508b.m14557a(parcel, 3, playLoggerContext.f12238c);
        C3508b.m14557a(parcel, 4, playLoggerContext.f12239d);
        C3508b.m14565a(parcel, 5, playLoggerContext.f12240e, false);
        C3508b.m14565a(parcel, 6, playLoggerContext.f12241f, false);
        C3508b.m14567a(parcel, 7, playLoggerContext.f12242g);
        C3508b.m14565a(parcel, 8, playLoggerContext.f12243h, false);
        C3508b.m14567a(parcel, 9, playLoggerContext.f12244i);
        C3508b.m14557a(parcel, 10, playLoggerContext.f12245j);
        C3508b.m14555a(parcel, a);
    }

    public PlayLoggerContext m14752a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public PlayLoggerContext[] m14753a(int i) {
        return new PlayLoggerContext[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14752a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14753a(i);
    }
}
