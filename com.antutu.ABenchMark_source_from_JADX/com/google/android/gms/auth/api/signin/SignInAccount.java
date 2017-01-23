package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInAccount implements SafeParcelable {
    public static final Creator<SignInAccount> CREATOR;
    final int f10160a;
    private String f10161b;
    private String f10162c;
    private String f10163d;
    private String f10164e;
    private Uri f10165f;
    private GoogleSignInAccount f10166g;
    private String f10167h;
    private String f10168i;

    static {
        CREATOR = new C3007d();
    }

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.f10160a = i;
        this.f10163d = C3512u.m14583a(str3, (Object) "Email cannot be empty.");
        this.f10164e = str4;
        this.f10165f = uri;
        this.f10161b = str;
        this.f10162c = str2;
        this.f10166g = googleSignInAccount;
        this.f10167h = C3512u.m14582a(str5);
        this.f10168i = str6;
    }

    public String m11675a() {
        return this.f10162c;
    }

    public String m11676b() {
        return this.f10163d;
    }

    public String m11677c() {
        return this.f10164e;
    }

    public Uri m11678d() {
        return this.f10165f;
    }

    public int describeContents() {
        return 0;
    }

    public GoogleSignInAccount m11679e() {
        return this.f10166g;
    }

    public String m11680f() {
        return this.f10167h;
    }

    public String m11681g() {
        return this.f10168i;
    }

    String m11682h() {
        return this.f10161b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3007d.m11692a(this, parcel, i);
    }
}
