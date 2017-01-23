package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR;
    private final long DW;
    private int EQ;
    private int FH;
    private final String Hw;
    private final float J0;
    private final long J8;
    private final int VH;
    private long Ws;
    private final String Zo;
    private final List<String> gn;
    final int j6;
    private final long tp;
    private final String u7;
    private final String v5;
    private final String we;

    static {
        CREATOR = new g();
    }

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.j6 = i;
        this.DW = j;
        this.FH = i2;
        this.Hw = str;
        this.v5 = str3;
        this.Zo = str5;
        this.VH = i3;
        this.Ws = -1;
        this.gn = list;
        this.u7 = str2;
        this.tp = j2;
        this.EQ = i4;
        this.we = str4;
        this.J0 = f;
        this.J8 = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public int DW() {
        return this.FH;
    }

    public int EQ() {
        return this.EQ;
    }

    public String FH() {
        return this.Hw;
    }

    public String Hw() {
        return this.v5;
    }

    public String J0() {
        return this.we;
    }

    public float J8() {
        return this.J0;
    }

    public List<String> VH() {
        return this.gn;
    }

    public long Ws() {
        return this.J8;
    }

    public int Zo() {
        return this.VH;
    }

    public String gn() {
        return this.u7;
    }

    public long j6() {
        return this.DW;
    }

    public long tp() {
        return this.tp;
    }

    public long u7() {
        return this.Ws;
    }

    public String v5() {
        return this.Zo;
    }

    public String we() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(FH());
        String valueOf3 = String.valueOf("\t");
        int Zo = Zo();
        String valueOf4 = String.valueOf("\t");
        String join = VH() == null ? "" : TextUtils.join(",", VH());
        String valueOf5 = String.valueOf("\t");
        int EQ = EQ();
        String valueOf6 = String.valueOf("\t");
        String Hw = Hw() == null ? "" : Hw();
        String valueOf7 = String.valueOf("\t");
        String J0 = J0() == null ? "" : J0();
        String valueOf8 = String.valueOf("\t");
        float J8 = J8();
        String valueOf9 = String.valueOf("\t");
        String v5 = v5() == null ? "" : v5();
        return new StringBuilder(((((((((((((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(join).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(Hw).length()) + String.valueOf(valueOf7).length()) + String.valueOf(J0).length()) + String.valueOf(valueOf8).length()) + String.valueOf(valueOf9).length()) + String.valueOf(v5).length()).append(valueOf).append(valueOf2).append(valueOf3).append(Zo).append(valueOf4).append(join).append(valueOf5).append(EQ).append(valueOf6).append(Hw).append(valueOf7).append(J0).append(valueOf8).append(J8).append(valueOf9).append(v5).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.j6(this, parcel, i);
    }
}
