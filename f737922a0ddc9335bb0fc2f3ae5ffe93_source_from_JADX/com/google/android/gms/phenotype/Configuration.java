package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
    public static final Creator<Configuration> CREATOR;
    public final int DW;
    public final Flag[] FH;
    public final String[] Hw;
    final int j6;
    public final Map<String, Flag> v5;

    static {
        CREATOR = new a();
    }

    Configuration(int i, int i2, Flag[] flagArr, String[] strArr) {
        this.j6 = i;
        this.DW = i2;
        this.FH = flagArr;
        this.v5 = new TreeMap();
        for (Flag flag : flagArr) {
            this.v5.put(flag.DW, flag);
        }
        this.Hw = strArr;
        if (this.Hw != null) {
            Arrays.sort(this.Hw);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return j6((Configuration) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return this.j6 == configuration.j6 && this.DW == configuration.DW && ae.j6(this.v5, configuration.v5) && Arrays.equals(this.Hw, configuration.Hw);
    }

    public int j6(Configuration configuration) {
        return this.DW - configuration.DW;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Configuration(");
        stringBuilder.append(this.j6);
        stringBuilder.append(", ");
        stringBuilder.append(this.DW);
        stringBuilder.append(", ");
        stringBuilder.append("(");
        for (Flag append : this.v5.values()) {
            stringBuilder.append(append);
            stringBuilder.append(", ");
        }
        stringBuilder.append(")");
        stringBuilder.append(", ");
        stringBuilder.append("(");
        if (this.Hw != null) {
            for (String append2 : this.Hw) {
                stringBuilder.append(append2);
                stringBuilder.append(", ");
            }
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
