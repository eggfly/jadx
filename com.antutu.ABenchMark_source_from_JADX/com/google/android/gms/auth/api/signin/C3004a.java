package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.api.signin.a */
public class C3004a implements Creator<EmailSignInOptions> {
    static void m11683a(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, emailSignInOptions.f10124a);
        C3508b.m14562a(parcel, 2, emailSignInOptions.m11647a(), i, false);
        C3508b.m14565a(parcel, 3, emailSignInOptions.m11649c(), false);
        C3508b.m14562a(parcel, 4, emailSignInOptions.m11648b(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public EmailSignInOptions m11684a(Parcel parcel) {
        Uri uri = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        String str = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < b) {
            String str2;
            Uri uri3;
            int d;
            Uri uri4;
            int a = C3507a.m14521a(parcel);
            Uri uri5;
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    uri5 = uri;
                    str2 = str;
                    uri3 = uri2;
                    d = C3507a.m14531d(parcel, a);
                    uri4 = uri5;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    d = i;
                    String str3 = str;
                    uri3 = (Uri) C3507a.m14523a(parcel, a, Uri.CREATOR);
                    uri4 = uri;
                    str2 = str3;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    uri3 = uri2;
                    d = i;
                    uri5 = uri;
                    str2 = C3507a.m14539l(parcel, a);
                    uri4 = uri5;
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    uri4 = (Uri) C3507a.m14523a(parcel, a, Uri.CREATOR);
                    str2 = str;
                    uri3 = uri2;
                    d = i;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    uri4 = uri;
                    str2 = str;
                    uri3 = uri2;
                    d = i;
                    break;
            }
            i = d;
            uri2 = uri3;
            str = str2;
            uri = uri4;
        }
        if (parcel.dataPosition() == b) {
            return new EmailSignInOptions(i, uri2, str, uri);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public EmailSignInOptions[] m11685a(int i) {
        return new EmailSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11684a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11685a(i);
    }
}
