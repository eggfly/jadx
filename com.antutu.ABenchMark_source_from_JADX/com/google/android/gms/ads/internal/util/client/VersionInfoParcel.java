package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import org.android.agoo.message.MessageService;

@gb
public final class VersionInfoParcel implements SafeParcelable {
    public static final C2973c CREATOR;
    public final int f10080a;
    public String f10081b;
    public int f10082c;
    public int f10083d;
    public boolean f10084e;

    static {
        CREATOR = new C2973c();
    }

    public VersionInfoParcel(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? MessageService.MSG_DB_READY_REPORT : MessageService.MSG_DB_NOTIFY_REACHED), i, i2, z);
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.f10080a = i;
        this.f10081b = str;
        this.f10082c = i2;
        this.f10083d = i3;
        this.f10084e = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2973c.m11585a(this, parcel, i);
    }
}
