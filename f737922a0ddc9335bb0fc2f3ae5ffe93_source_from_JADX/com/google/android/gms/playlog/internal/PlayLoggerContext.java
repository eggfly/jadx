package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class PlayLoggerContext extends AbstractSafeParcelable {
    public static final b CREATOR;
    public final String DW;
    public final int FH;
    public final int Hw;
    public final boolean VH;
    public final String Zo;
    public final String gn;
    public final int j6;
    public final int tp;
    public final boolean u7;
    public final String v5;

    static {
        CREATOR = new b();
    }

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.j6 = i;
        this.DW = str;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = str2;
        this.Zo = str3;
        this.VH = z;
        this.gn = str4;
        this.u7 = z2;
        this.tp = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.j6 == playLoggerContext.j6 && this.DW.equals(playLoggerContext.DW) && this.FH == playLoggerContext.FH && this.Hw == playLoggerContext.Hw && ae.j6(this.gn, playLoggerContext.gn) && ae.j6(this.v5, playLoggerContext.v5) && ae.j6(this.Zo, playLoggerContext.Zo) && this.VH == playLoggerContext.VH && this.u7 == playLoggerContext.u7 && this.tp == playLoggerContext.tp;
    }

    public int hashCode() {
        return ae.j6(Integer.valueOf(this.j6), this.DW, Integer.valueOf(this.FH), Integer.valueOf(this.Hw), this.gn, this.v5, this.Zo, Boolean.valueOf(this.VH), Boolean.valueOf(this.u7), Integer.valueOf(this.tp));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.j6).append(',');
        stringBuilder.append("package=").append(this.DW).append(',');
        stringBuilder.append("packageVersionCode=").append(this.FH).append(',');
        stringBuilder.append("logSource=").append(this.Hw).append(',');
        stringBuilder.append("logSourceName=").append(this.gn).append(',');
        stringBuilder.append("uploadAccount=").append(this.v5).append(',');
        stringBuilder.append("loggingId=").append(this.Zo).append(',');
        stringBuilder.append("logAndroidId=").append(this.VH).append(',');
        stringBuilder.append("isAnonymous=").append(this.u7).append(',');
        stringBuilder.append("qosTier=").append(this.tp);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
