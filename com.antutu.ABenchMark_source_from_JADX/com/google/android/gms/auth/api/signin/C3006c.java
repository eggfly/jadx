package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.api.signin.c */
public class C3006c implements Creator<GoogleSignInOptions> {
    static void m11689a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, googleSignInOptions.f10152e);
        C3508b.m14574b(parcel, 2, googleSignInOptions.m11668a(), false);
        C3508b.m14562a(parcel, 3, googleSignInOptions.m11669b(), i, false);
        C3508b.m14567a(parcel, 4, googleSignInOptions.m11670c());
        C3508b.m14567a(parcel, 5, googleSignInOptions.m11671d());
        C3508b.m14567a(parcel, 6, googleSignInOptions.m11672e());
        C3508b.m14565a(parcel, 7, googleSignInOptions.m11673f(), false);
        C3508b.m14565a(parcel, 8, googleSignInOptions.m11674g(), false);
        C3508b.m14555a(parcel, a);
    }

    public GoogleSignInOptions m11690a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    arrayList = C3507a.m14529c(parcel, a, Scope.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    account = (Account) C3507a.m14523a(parcel, a, Account.CREATOR);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    z3 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInOptions[] m11691a(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11690a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11691a(i);
    }
}
