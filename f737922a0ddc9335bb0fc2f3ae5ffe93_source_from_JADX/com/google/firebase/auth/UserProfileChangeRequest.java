package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Creator<UserProfileChangeRequest> CREATOR;
    private String DW;
    private String FH;
    private boolean Hw;
    private Uri Zo;
    public final int j6;
    private boolean v5;

    static {
        CREATOR = new a();
    }

    UserProfileChangeRequest(int i, String str, String str2, boolean z, boolean z2) {
        this.j6 = i;
        this.DW = str;
        this.FH = str2;
        this.Hw = z;
        this.v5 = z2;
        this.Zo = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String DW() {
        return this.FH;
    }

    public boolean FH() {
        return this.Hw;
    }

    public boolean Hw() {
        return this.v5;
    }

    public String j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
