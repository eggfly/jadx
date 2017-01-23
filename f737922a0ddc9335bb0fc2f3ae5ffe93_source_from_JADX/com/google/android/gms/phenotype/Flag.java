package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag extends AbstractSafeParcelable implements Comparable<Flag> {
    public static final Creator<Flag> CREATOR;
    private static final Charset EQ;
    public static final a tp;
    public final String DW;
    final long FH;
    final boolean Hw;
    final byte[] VH;
    final String Zo;
    public final int gn;
    final int j6;
    public final int u7;
    final double v5;

    public static class a implements Comparator<Flag> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((Flag) obj, (Flag) obj2);
        }

        public int j6(Flag flag, Flag flag2) {
            return flag.u7 == flag2.u7 ? flag.DW.compareTo(flag2.DW) : flag.u7 - flag2.u7;
        }
    }

    static {
        CREATOR = new b();
        EQ = Charset.forName("UTF-8");
        tp = new a();
    }

    Flag(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.j6 = i;
        this.DW = str;
        this.FH = j;
        this.Hw = z;
        this.v5 = d;
        this.Zo = str2;
        this.VH = bArr;
        this.gn = i2;
        this.u7 = i3;
    }

    private static int j6(byte b, byte b2) {
        return b - b2;
    }

    private static int j6(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    private static int j6(long j, long j2) {
        return j < j2 ? -1 : j == j2 ? 0 : 1;
    }

    private static int j6(String str, String str2) {
        return str == str2 ? 0 : str == null ? -1 : str2 == null ? 1 : str.compareTo(str2);
    }

    private static int j6(boolean z, boolean z2) {
        return z == z2 ? 0 : z ? 1 : -1;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return j6((Flag) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        if (this.j6 != flag.j6 || !ae.j6(this.DW, flag.DW) || this.gn != flag.gn || this.u7 != flag.u7) {
            return false;
        }
        switch (this.gn) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return this.FH == flag.FH;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return this.Hw == flag.Hw;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return this.v5 == flag.v5;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return ae.j6(this.Zo, flag.Zo);
            case 5:
                return Arrays.equals(this.VH, flag.VH);
            default:
                throw new AssertionError("Invalid enum value: " + this.gn);
        }
    }

    public int j6(Flag flag) {
        int i = 0;
        int compareTo = this.DW.compareTo(flag.DW);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = j6(this.gn, flag.gn);
        if (compareTo != 0) {
            return compareTo;
        }
        switch (this.gn) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return j6(this.FH, flag.FH);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return j6(this.Hw, flag.Hw);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return Double.compare(this.v5, flag.v5);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return j6(this.Zo, flag.Zo);
            case 5:
                if (this.VH == flag.VH) {
                    return 0;
                }
                if (this.VH == null) {
                    return -1;
                }
                if (flag.VH == null) {
                    return 1;
                }
                while (i < Math.min(this.VH.length, flag.VH.length)) {
                    compareTo = j6(this.VH[i], flag.VH[i]);
                    if (compareTo != 0) {
                        return compareTo;
                    }
                    i++;
                }
                return j6(this.VH.length, flag.VH.length);
            default:
                throw new AssertionError("Invalid enum value: " + this.gn);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Flag(");
        stringBuilder.append(this.j6);
        stringBuilder.append(", ");
        stringBuilder.append(this.DW);
        stringBuilder.append(", ");
        switch (this.gn) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuilder.append(this.FH);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuilder.append(this.Hw);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                stringBuilder.append(this.v5);
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuilder.append("'");
                stringBuilder.append(this.Zo);
                stringBuilder.append("'");
                break;
            case 5:
                if (this.VH != null) {
                    stringBuilder.append("'");
                    stringBuilder.append(new String(this.VH, EQ));
                    stringBuilder.append("'");
                    break;
                }
                stringBuilder.append("null");
                break;
            default:
                throw new AssertionError("Invalid enum value: " + this.gn);
        }
        stringBuilder.append(", ");
        stringBuilder.append(this.gn);
        stringBuilder.append(", ");
        stringBuilder.append(this.u7);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
