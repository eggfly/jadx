package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.e */
public class C3456e implements Creator<ConnectionResult> {
    static void m14266a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, connectionResult.f11814b);
        C3508b.m14557a(parcel, 2, connectionResult.m13953c());
        C3508b.m14562a(parcel, 3, connectionResult.m13954d(), i, false);
        C3508b.m14565a(parcel, 4, connectionResult.m13955e(), false);
        C3508b.m14555a(parcel, a);
    }

    public ConnectionResult m14267a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C3507a.m14521a(parcel);
            String str3;
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C3507a.m14531d(parcel, a);
                    str2 = str3;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C3507a.m14531d(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C3507a.m14523a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str2 = C3507a.m14539l(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m14268a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14267a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14268a(i);
    }
}
