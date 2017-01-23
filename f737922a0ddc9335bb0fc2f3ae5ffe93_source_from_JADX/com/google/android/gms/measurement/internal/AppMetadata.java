package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AppMetadata extends AbstractSafeParcelable {
    public static final m CREATOR;
    public final String DW;
    public final long EQ;
    public final String FH;
    public final String Hw;
    public final long VH;
    public final long Zo;
    public final String gn;
    public final int j6;
    public final boolean tp;
    public final boolean u7;
    public final String v5;
    public final String we;

    static {
        CREATOR = new m();
    }

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6) {
        this.j6 = i;
        this.DW = str;
        this.FH = str2;
        this.Hw = str3;
        if (i < 5) {
            j3 = -2147483648L;
        }
        this.EQ = j3;
        this.v5 = str4;
        this.Zo = j;
        this.VH = j2;
        this.gn = str5;
        if (i >= 3) {
            this.u7 = z;
        } else {
            this.u7 = true;
        }
        this.tp = z2;
        this.we = str6;
    }

    AppMetadata(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6) {
        b.j6(str);
        this.j6 = 6;
        this.DW = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.FH = str2;
        this.Hw = str3;
        this.EQ = j;
        this.v5 = str4;
        this.Zo = j2;
        this.VH = j3;
        this.gn = str5;
        this.u7 = z;
        this.tp = z2;
        this.we = str6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        m.j6(this, parcel, i);
    }
}
