package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.signin.internal.f */
public class C3552f implements Creator<RecordConsentRequest> {
    static void m14795a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, recordConsentRequest.f12252a);
        C3508b.m14562a(parcel, 2, recordConsentRequest.m14757a(), i, false);
        C3508b.m14570a(parcel, 3, recordConsentRequest.m14758b(), i, false);
        C3508b.m14565a(parcel, 4, recordConsentRequest.m14759c(), false);
        C3508b.m14555a(parcel, a);
    }

    public RecordConsentRequest m14796a(Parcel parcel) {
        String str = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int d;
            String str2;
            int a = C3507a.m14521a(parcel);
            String str3;
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = C3507a.m14531d(parcel, a);
                    str2 = str3;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    d = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C3507a.m14523a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    account2 = account;
                    d = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C3507a.m14528b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str2 = C3507a.m14539l(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
            }
            i = d;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] m14797a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14796a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14797a(i);
    }
}
