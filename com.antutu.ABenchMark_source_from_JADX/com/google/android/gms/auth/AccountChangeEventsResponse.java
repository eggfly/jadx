package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Creator<AccountChangeEventsResponse> CREATOR;
    final int f10116a;
    final List<AccountChangeEvent> f10117b;

    static {
        CREATOR = new C3012c();
    }

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.f10116a = i;
        this.f10117b = (List) C3512u.m14580a((Object) list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3012c.m11714a(this, parcel, i);
    }
}
