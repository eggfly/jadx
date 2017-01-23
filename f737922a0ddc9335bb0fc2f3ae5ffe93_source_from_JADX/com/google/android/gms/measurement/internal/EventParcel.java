package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class EventParcel extends AbstractSafeParcelable {
    public static final v CREATOR;
    public final String DW;
    public final EventParams FH;
    public final String Hw;
    public final int j6;
    public final long v5;

    static {
        CREATOR = new v();
    }

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.j6 = i;
        this.DW = str;
        this.FH = eventParams;
        this.Hw = str2;
        this.v5 = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.j6 = 1;
        this.DW = str;
        this.FH = eventParams;
        this.Hw = str2;
        this.v5 = j;
    }

    public String toString() {
        String str = this.Hw;
        String str2 = this.DW;
        String valueOf = String.valueOf(this.FH);
        return new StringBuilder(((String.valueOf(str).length() + 21) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        v.j6(this, parcel, i);
    }
}
