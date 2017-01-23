package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Status extends AbstractSafeParcelable implements e {
    public static final Creator<Status> CREATOR;
    public static final Status DW;
    public static final Status FH;
    public static final Status Hw;
    public static final Status Zo;
    public static final Status j6;
    public static final Status v5;
    private final int VH;
    private final int gn;
    private final PendingIntent tp;
    private final String u7;

    static {
        j6 = new Status(0);
        DW = new Status(14);
        FH = new Status(8);
        Hw = new Status(15);
        v5 = new Status(16);
        Zo = new Status(17);
        CREATOR = new o();
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.VH = i;
        this.gn = i2;
        this.u7 = str;
        this.tp = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String VH() {
        return this.u7 != null ? this.u7 : b.j6(this.gn);
    }

    public Status DW() {
        return this;
    }

    public String FH() {
        return this.u7;
    }

    int Hw() {
        return this.VH;
    }

    public int Zo() {
        return this.gn;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.VH == status.VH && this.gn == status.gn && ae.j6(this.u7, status.u7) && ae.j6(this.tp, status.tp);
    }

    public int hashCode() {
        return ae.j6(Integer.valueOf(this.VH), Integer.valueOf(this.gn), this.u7, this.tp);
    }

    PendingIntent j6() {
        return this.tp;
    }

    public String toString() {
        return ae.j6((Object) this).j6("statusCode", VH()).j6("resolution", this.tp).toString();
    }

    public boolean v5() {
        return this.gn <= 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        o.j6(this, parcel, i);
    }
}
