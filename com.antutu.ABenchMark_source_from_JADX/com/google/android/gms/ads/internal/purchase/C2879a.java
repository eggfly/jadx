package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.purchase.a */
public class C2879a implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void m11197a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, gInAppPurchaseManagerInfoParcel.f9746a);
        C3508b.m14560a(parcel, 3, gInAppPurchaseManagerInfoParcel.m11194b(), false);
        C3508b.m14560a(parcel, 4, gInAppPurchaseManagerInfoParcel.m11195c(), false);
        C3508b.m14560a(parcel, 5, gInAppPurchaseManagerInfoParcel.m11196d(), false);
        C3508b.m14560a(parcel, 6, gInAppPurchaseManagerInfoParcel.m11193a(), false);
        C3508b.m14555a(parcel, a);
    }

    public GInAppPurchaseManagerInfoParcel m11198a(Parcel parcel) {
        IBinder iBinder = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    iBinder4 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    iBinder3 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    iBinder2 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    iBinder = C3507a.m14540m(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public GInAppPurchaseManagerInfoParcel[] m11199a(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11198a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11199a(i);
    }
}
