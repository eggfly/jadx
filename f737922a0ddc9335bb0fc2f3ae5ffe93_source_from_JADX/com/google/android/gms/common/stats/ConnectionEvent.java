package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ConnectionEvent extends StatsEvent {
    public static final Creator<ConnectionEvent> CREATOR;
    private final long DW;
    private final long EQ;
    private int FH;
    private final String Hw;
    private final String VH;
    private final String Zo;
    private final String gn;
    final int j6;
    private final long tp;
    private final String u7;
    private final String v5;
    private long we;

    static {
        CREATOR = new a();
    }

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.j6 = i;
        this.DW = j;
        this.FH = i2;
        this.Hw = str;
        this.v5 = str2;
        this.Zo = str3;
        this.VH = str4;
        this.we = -1;
        this.gn = str5;
        this.u7 = str6;
        this.tp = j2;
        this.EQ = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int DW() {
        return this.FH;
    }

    public long EQ() {
        return this.tp;
    }

    public String FH() {
        return this.Hw;
    }

    public String Hw() {
        return this.v5;
    }

    public String VH() {
        return this.gn;
    }

    public String Zo() {
        return this.VH;
    }

    public String gn() {
        return this.u7;
    }

    public long j6() {
        return this.DW;
    }

    public long tp() {
        return this.EQ;
    }

    public long u7() {
        return this.we;
    }

    public String v5() {
        return this.Zo;
    }

    public String we() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(FH());
        String valueOf3 = String.valueOf(Hw());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(v5());
        String valueOf6 = String.valueOf(Zo());
        String valueOf7 = String.valueOf("\t");
        String str = this.gn == null ? "" : this.gn;
        String valueOf8 = String.valueOf("\t");
        return new StringBuilder(((((((((String.valueOf(valueOf).length() + 22) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(valueOf7).length()) + String.valueOf(str).length()) + String.valueOf(valueOf8).length()).append(valueOf).append(valueOf2).append("/").append(valueOf3).append(valueOf4).append(valueOf5).append("/").append(valueOf6).append(valueOf7).append(str).append(valueOf8).append(tp()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
