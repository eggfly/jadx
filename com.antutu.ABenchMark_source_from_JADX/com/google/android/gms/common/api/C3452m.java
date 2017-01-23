package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.ads.AdError;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.api.m */
public class C3452m implements Creator<Status> {
    static void m14262a(Status status, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, status.m13964f());
        C3508b.m14557a(parcel, (int) AdError.NETWORK_ERROR_CODE, status.m13962d());
        C3508b.m14565a(parcel, 2, status.m13961c(), false);
        C3508b.m14562a(parcel, 3, status.m13960b(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public Status m14263a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    pendingIntent = (PendingIntent) C3507a.m14523a(parcel, a, PendingIntent.CREATOR);
                    break;
                case AdError.NETWORK_ERROR_CODE /*1000*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public Status[] m14264a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14263a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14264a(i);
    }
}
