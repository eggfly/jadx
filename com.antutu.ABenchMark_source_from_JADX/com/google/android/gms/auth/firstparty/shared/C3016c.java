package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.firstparty.shared.c */
public class C3016c implements Creator<ScopeDetail> {
    static void m11726a(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, scopeDetail.f10193a);
        C3508b.m14565a(parcel, 2, scopeDetail.f10194b, false);
        C3508b.m14565a(parcel, 3, scopeDetail.f10195c, false);
        C3508b.m14565a(parcel, 4, scopeDetail.f10196d, false);
        C3508b.m14565a(parcel, 5, scopeDetail.f10197e, false);
        C3508b.m14565a(parcel, 6, scopeDetail.f10198f, false);
        C3508b.m14566a(parcel, 7, scopeDetail.f10199g, false);
        C3508b.m14562a(parcel, 8, scopeDetail.f10200h, i, false);
        C3508b.m14555a(parcel, a);
    }

    public ScopeDetail m11727a(Parcel parcel) {
        FACLData fACLData = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        List arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str5 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    arrayList = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    fACLData = (FACLData) C3507a.m14523a(parcel, a, FACLData.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ScopeDetail[] m11728a(int i) {
        return new ScopeDetail[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11727a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11728a(i);
    }
}
