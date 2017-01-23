package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.a.a;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.x.d;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable extends AbstractSafeParcelable {
    public static final c CREATOR;
    public PlayLoggerContext DW;
    public byte[] FH;
    public int[] Hw;
    public final a VH;
    public final a Zo;
    public final int j6;
    public final d v5;

    static {
        CREATOR = new c();
    }

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.j6 = i;
        this.DW = playLoggerContext;
        this.FH = bArr;
        this.Hw = iArr;
        this.v5 = null;
        this.Zo = null;
        this.VH = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.j6 == logEventParcelable.j6 && ae.j6(this.DW, logEventParcelable.DW) && Arrays.equals(this.FH, logEventParcelable.FH) && Arrays.equals(this.Hw, logEventParcelable.Hw) && ae.j6(this.v5, logEventParcelable.v5) && ae.j6(this.Zo, logEventParcelable.Zo) && ae.j6(this.VH, logEventParcelable.VH);
    }

    public int hashCode() {
        return ae.j6(Integer.valueOf(this.j6), this.DW, this.FH, this.Hw, this.v5, this.Zo, this.VH);
    }

    public String toString() {
        String str = null;
        StringBuilder append = new StringBuilder("LogEventParcelable[").append(this.j6).append(", ").append(this.DW).append(", ").append("LogEventBytes: ").append(this.FH == null ? null : new String(this.FH)).append(", ").append("TestCodes: ");
        if (this.Hw != null) {
            str = ac.j6(", ").j6(Arrays.asList(new int[][]{this.Hw}));
        }
        return append.append(str).append(", ").append("LogEvent: ").append(this.v5).append(", ").append("ExtensionProducer: ").append(this.Zo).append(", ").append("VeProducer: ").append(this.VH).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.j6(this, parcel, i);
    }
}
