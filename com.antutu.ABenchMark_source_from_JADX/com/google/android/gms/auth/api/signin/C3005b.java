package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.api.signin.b */
public class C3005b implements Creator<GoogleSignInAccount> {
    static void m11686a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, googleSignInAccount.f10130b);
        C3508b.m14565a(parcel, 2, googleSignInAccount.m11654a(), false);
        C3508b.m14565a(parcel, 3, googleSignInAccount.m11656b(), false);
        C3508b.m14565a(parcel, 4, googleSignInAccount.m11657c(), false);
        C3508b.m14565a(parcel, 5, googleSignInAccount.m11658d(), false);
        C3508b.m14562a(parcel, 6, googleSignInAccount.m11659e(), i, false);
        C3508b.m14565a(parcel, 7, googleSignInAccount.m11660f(), false);
        C3508b.m14558a(parcel, 8, googleSignInAccount.m11661g());
        C3508b.m14565a(parcel, 9, googleSignInAccount.m11662h(), false);
        C3508b.m14574b(parcel, 10, googleSignInAccount.f10131c, false);
        C3508b.m14555a(parcel, a);
    }

    public GoogleSignInAccount m11687a(Parcel parcel) {
        List list = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str6 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str5 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    uri = (Uri) C3507a.m14523a(parcel, a, Uri.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    list = C3507a.m14529c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str6, str5, str4, str3, uri, str2, j, str, list);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m11688a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11687a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11688a(i);
    }
}
