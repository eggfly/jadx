package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UserAttributeParcel extends AbstractSafeParcelable {
    public static final j CREATOR;
    public final String DW;
    public final long FH;
    public final Long Hw;
    public final String VH;
    public final String Zo;
    public final Double gn;
    public final int j6;
    public final Float v5;

    static {
        CREATOR = new j();
    }

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.j6 = i;
        this.DW = str;
        this.FH = j;
        this.Hw = l;
        this.v5 = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.gn = d2;
        } else {
            this.gn = d;
        }
        this.Zo = str2;
        this.VH = str3;
    }

    UserAttributeParcel(k kVar) {
        this(kVar.DW, kVar.FH, kVar.Hw, kVar.j6);
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        b.j6(str);
        this.j6 = 2;
        this.DW = str;
        this.FH = j;
        this.VH = str2;
        if (obj == null) {
            this.Hw = null;
            this.v5 = null;
            this.gn = null;
            this.Zo = null;
        } else if (obj instanceof Long) {
            this.Hw = (Long) obj;
            this.v5 = null;
            this.gn = null;
            this.Zo = null;
        } else if (obj instanceof String) {
            this.Hw = null;
            this.v5 = null;
            this.gn = null;
            this.Zo = (String) obj;
        } else if (obj instanceof Double) {
            this.Hw = null;
            this.v5 = null;
            this.gn = (Double) obj;
            this.Zo = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object j6() {
        return this.Hw != null ? this.Hw : this.gn != null ? this.gn : this.Zo != null ? this.Zo : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.j6(this, parcel, i);
    }
}
