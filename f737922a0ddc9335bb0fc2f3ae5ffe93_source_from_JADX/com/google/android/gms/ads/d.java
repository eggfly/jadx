package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.w;

public final class d {
    public static final d DW;
    public static final d FH;
    public static final d Hw;
    public static final d VH;
    public static final d Zo;
    public static final d gn;
    public static final d j6;
    public static final d u7;
    public static final d v5;
    private final int EQ;
    private final int tp;
    private final String we;

    static {
        j6 = new d(320, 50, "320x50_mb");
        DW = new d(468, 60, "468x60_as");
        FH = new d(320, 100, "320x100_as");
        Hw = new d(728, 90, "728x90_as");
        v5 = new d(300, 250, "300x250_as");
        Zo = new d(160, 600, "160x600_as");
        VH = new d(-1, -2, "smart_banner");
        gn = new d(-3, -4, "fluid");
        u7 = new d(-3, 0, "search_v2");
    }

    public d(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        String valueOf3 = String.valueOf("_as");
        this(i, i2, new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append("x").append(valueOf2).append(valueOf3).toString());
    }

    d(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.tp = i;
            this.EQ = i2;
            this.we = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public int DW() {
        return this.tp;
    }

    public int DW(Context context) {
        switch (this.tp) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.j6(context.getResources().getDisplayMetrics());
            default:
                return w.j6().j6(context, this.tp);
        }
    }

    public boolean FH() {
        return this.tp == -3 && this.EQ == -4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.tp == dVar.tp && this.EQ == dVar.EQ && this.we.equals(dVar.we);
    }

    public int hashCode() {
        return this.we.hashCode();
    }

    public int j6() {
        return this.EQ;
    }

    public int j6(Context context) {
        switch (this.EQ) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.DW(context.getResources().getDisplayMetrics());
            default:
                return w.j6().j6(context, this.EQ);
        }
    }

    public String toString() {
        return this.we;
    }
}
