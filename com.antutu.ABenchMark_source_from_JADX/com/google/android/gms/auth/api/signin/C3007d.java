package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.api.signin.d */
public class C3007d implements Creator<SignInAccount> {
    static void m11692a(SignInAccount signInAccount, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, signInAccount.f10160a);
        C3508b.m14565a(parcel, 2, signInAccount.m11682h(), false);
        C3508b.m14565a(parcel, 3, signInAccount.m11675a(), false);
        C3508b.m14565a(parcel, 4, signInAccount.m11676b(), false);
        C3508b.m14565a(parcel, 5, signInAccount.m11677c(), false);
        C3508b.m14562a(parcel, 6, signInAccount.m11678d(), i, false);
        C3508b.m14562a(parcel, 7, signInAccount.m11679e(), i, false);
        C3508b.m14565a(parcel, 8, signInAccount.m11680f(), false);
        C3508b.m14565a(parcel, 9, signInAccount.m11681g(), false);
        C3508b.m14555a(parcel, a);
    }

    public SignInAccount m11693a(Parcel parcel) {
        String str = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        String str2 = BuildConfig.FLAVOR;
        GoogleSignInAccount googleSignInAccount = null;
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
                    googleSignInAccount = (GoogleSignInAccount) C3507a.m14523a(parcel, a, GoogleSignInAccount.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInAccount(i, str6, str5, str4, str3, uri, googleSignInAccount, str2, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public SignInAccount[] m11694a(int i) {
        return new SignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11693a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11694a(i);
    }
}
