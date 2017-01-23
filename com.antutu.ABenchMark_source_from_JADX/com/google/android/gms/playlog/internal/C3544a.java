package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.playlog.internal.a */
public class C3544a implements Creator<LogEvent> {
    static void m14748a(LogEvent logEvent, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, logEvent.f12230a);
        C3508b.m14558a(parcel, 2, logEvent.f12231b);
        C3508b.m14565a(parcel, 3, logEvent.f12233d, false);
        C3508b.m14568a(parcel, 4, logEvent.f12234e, false);
        C3508b.m14559a(parcel, 5, logEvent.f12235f, false);
        C3508b.m14558a(parcel, 6, logEvent.f12232c);
        C3508b.m14555a(parcel, a);
    }

    public LogEvent m14749a(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    j2 = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    bArr = C3507a.m14542o(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    bundle = C3507a.m14541n(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public LogEvent[] m14750a(int i) {
        return new LogEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14749a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14750a(i);
    }
}
