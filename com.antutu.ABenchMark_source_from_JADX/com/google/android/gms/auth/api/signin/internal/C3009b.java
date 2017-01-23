package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.api.signin.internal.b */
public class C3009b implements Creator<SignInConfiguration> {
    static void m11703a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, signInConfiguration.f10169a);
        C3508b.m14565a(parcel, 2, signInConfiguration.m11695a(), false);
        C3508b.m14565a(parcel, 3, signInConfiguration.m11696b(), false);
        C3508b.m14562a(parcel, 4, signInConfiguration.m11697c(), i, false);
        C3508b.m14562a(parcel, 5, signInConfiguration.m11698d(), i, false);
        C3508b.m14565a(parcel, 7, signInConfiguration.m11699e(), false);
        C3508b.m14555a(parcel, a);
    }

    public SignInConfiguration m11704a(Parcel parcel) {
        String str = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    emailSignInOptions = (EmailSignInOptions) C3507a.m14523a(parcel, a, EmailSignInOptions.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    googleSignInOptions = (GoogleSignInOptions) C3507a.m14523a(parcel, a, GoogleSignInOptions.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInConfiguration(i, str3, str2, emailSignInOptions, googleSignInOptions, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public SignInConfiguration[] m11705a(int i) {
        return new SignInConfiguration[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11704a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11705a(i);
    }
}
