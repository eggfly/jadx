package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.v */
public class C3513v implements Creator<ResolveAccountRequest> {
    static void m14591a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, resolveAccountRequest.f12036a);
        C3508b.m14562a(parcel, 2, resolveAccountRequest.m14316a(), i, false);
        C3508b.m14557a(parcel, 3, resolveAccountRequest.m14317b());
        C3508b.m14562a(parcel, 4, resolveAccountRequest.m14318c(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public ResolveAccountRequest m14592a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int d;
            GoogleSignInAccount googleSignInAccount2;
            int a = C3507a.m14521a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = C3507a.m14531d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    d = i2;
                    int i4 = i;
                    account2 = (Account) C3507a.m14523a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    account2 = account;
                    d = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C3507a.m14531d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    googleSignInAccount2 = (GoogleSignInAccount) C3507a.m14523a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
            }
            i2 = d;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] m14593a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14592a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14593a(i);
    }
}
