package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.util.client.c */
public class C2973c implements Creator<VersionInfoParcel> {
    static void m11585a(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, versionInfoParcel.f10080a);
        C3508b.m14565a(parcel, 2, versionInfoParcel.f10081b, false);
        C3508b.m14557a(parcel, 3, versionInfoParcel.f10082c);
        C3508b.m14557a(parcel, 4, versionInfoParcel.f10083d);
        C3508b.m14567a(parcel, 5, versionInfoParcel.f10084e);
        C3508b.m14555a(parcel, a);
    }

    public VersionInfoParcel m11586a(Parcel parcel) {
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public VersionInfoParcel[] m11587a(int i) {
        return new VersionInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11586a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11587a(i);
    }
}
