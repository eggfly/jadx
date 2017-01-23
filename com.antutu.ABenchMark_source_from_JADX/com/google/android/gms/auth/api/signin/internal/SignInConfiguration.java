package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR;
    final int f10169a;
    private final String f10170b;
    private String f10171c;
    private EmailSignInOptions f10172d;
    private GoogleSignInOptions f10173e;
    private String f10174f;

    static {
        CREATOR = new C3009b();
    }

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String str3) {
        this.f10169a = i;
        this.f10170b = C3512u.m14582a(str);
        this.f10171c = str2;
        this.f10172d = emailSignInOptions;
        this.f10173e = googleSignInOptions;
        this.f10174f = str3;
    }

    public String m11695a() {
        return this.f10170b;
    }

    public String m11696b() {
        return this.f10171c;
    }

    public EmailSignInOptions m11697c() {
        return this.f10172d;
    }

    public GoogleSignInOptions m11698d() {
        return this.f10173e;
    }

    public int describeContents() {
        return 0;
    }

    public String m11699e() {
        return this.f10174f;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.f10170b.equals(signInConfiguration.m11695a())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f10171c)) {
                if (!TextUtils.isEmpty(signInConfiguration.m11696b())) {
                    return false;
                }
            } else if (!this.f10171c.equals(signInConfiguration.m11696b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f10174f)) {
                if (!TextUtils.isEmpty(signInConfiguration.m11699e())) {
                    return false;
                }
            } else if (!this.f10174f.equals(signInConfiguration.m11699e())) {
                return false;
            }
            if (this.f10172d == null) {
                if (signInConfiguration.m11697c() != null) {
                    return false;
                }
            } else if (!this.f10172d.equals(signInConfiguration.m11697c())) {
                return false;
            }
            if (this.f10173e == null) {
                if (signInConfiguration.m11698d() != null) {
                    return false;
                }
            } else if (!this.f10173e.equals(signInConfiguration.m11698d())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new C3008a().m11701a(this.f10170b).m11701a(this.f10171c).m11701a(this.f10174f).m11701a(this.f10172d).m11701a(this.f10173e).m11700a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3009b.m11703a(this, parcel, i);
    }
}
