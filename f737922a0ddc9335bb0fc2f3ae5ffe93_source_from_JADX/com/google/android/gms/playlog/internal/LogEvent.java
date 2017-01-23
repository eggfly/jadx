package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class LogEvent extends AbstractSafeParcelable {
    public static final a CREATOR;
    public final long DW;
    public final long FH;
    public final String Hw;
    public final Bundle Zo;
    public final int j6;
    public final byte[] v5;

    static {
        CREATOR = new a();
    }

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.j6 = i;
        this.DW = j;
        this.FH = j2;
        this.Hw = str;
        this.v5 = bArr;
        this.Zo = bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.Hw).append(",");
        stringBuilder.append("eventTime=").append(this.DW).append(",");
        stringBuilder.append("eventUptime=").append(this.FH).append(",");
        if (!(this.Zo == null || this.Zo.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.Zo.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.Zo.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
