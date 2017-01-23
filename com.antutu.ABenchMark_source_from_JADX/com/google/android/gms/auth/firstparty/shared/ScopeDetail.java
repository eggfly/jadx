package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
    public static final C3016c CREATOR;
    final int f10193a;
    String f10194b;
    String f10195c;
    String f10196d;
    String f10197e;
    String f10198f;
    List<String> f10199g;
    public FACLData f10200h;

    static {
        CREATOR = new C3016c();
    }

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List<String> list, FACLData fACLData) {
        this.f10193a = i;
        this.f10194b = str;
        this.f10195c = str2;
        this.f10196d = str3;
        this.f10197e = str4;
        this.f10198f = str5;
        this.f10199g = list;
        this.f10200h = fACLData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3016c.m11726a(this, parcel, i);
    }
}
