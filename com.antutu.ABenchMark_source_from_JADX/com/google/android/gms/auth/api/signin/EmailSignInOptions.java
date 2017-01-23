package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.C3008a;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class EmailSignInOptions implements SafeParcelable {
    public static final Creator<EmailSignInOptions> CREATOR;
    final int f10124a;
    private final Uri f10125b;
    private String f10126c;
    private Uri f10127d;

    static {
        CREATOR = new C3004a();
    }

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        C3512u.m14581a((Object) uri, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        C3512u.m14583a(uri.toString(), (Object) "Server widget url cannot be null in order to use email/password sign in.");
        C3512u.m14589b(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.f10124a = i;
        this.f10125b = uri;
        this.f10126c = str;
        this.f10127d = uri2;
    }

    public Uri m11647a() {
        return this.f10125b;
    }

    public Uri m11648b() {
        return this.f10127d;
    }

    public String m11649c() {
        return this.f10126c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.f10125b.equals(emailSignInOptions.m11647a())) {
                return false;
            }
            if (this.f10127d == null) {
                if (emailSignInOptions.m11648b() != null) {
                    return false;
                }
            } else if (!this.f10127d.equals(emailSignInOptions.m11648b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f10126c)) {
                if (!TextUtils.isEmpty(emailSignInOptions.m11649c())) {
                    return false;
                }
            } else if (!this.f10126c.equals(emailSignInOptions.m11649c())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new C3008a().m11701a(this.f10125b).m11701a(this.f10127d).m11701a(this.f10126c).m11700a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3004a.m11683a(this, parcel, i);
    }
}
