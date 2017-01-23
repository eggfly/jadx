package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;

public class LogEvent implements SafeParcelable {
    public static final C3544a CREATOR;
    public final int f12230a;
    public final long f12231b;
    public final long f12232c;
    public final String f12233d;
    public final byte[] f12234e;
    public final Bundle f12235f;

    static {
        CREATOR = new C3544a();
    }

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.f12230a = i;
        this.f12231b = j;
        this.f12232c = j2;
        this.f12233d = str;
        this.f12234e = bArr;
        this.f12235f = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.f12233d).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("eventTime=").append(this.f12231b).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("eventUptime=").append(this.f12232c).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (!(this.f12235f == null || this.f12235f.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.f12235f.keySet()) {
                stringBuilder.append(C4233j.f14396s).append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(this.f12235f.getString(str)).append(C4233j.f14397t);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3544a.m14748a(this, parcel, i);
    }
}
