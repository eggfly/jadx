package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Scope extends AbstractSafeParcelable {
    public static final Creator<Scope> CREATOR;
    private final String DW;
    final int j6;

    static {
        CREATOR = new n();
    }

    Scope(int i, String str) {
        b.j6(str, (Object) "scopeUri must not be null or empty");
        this.j6 = i;
        this.DW = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.DW.equals(((Scope) obj).DW);
    }

    public int hashCode() {
        return this.DW.hashCode();
    }

    public String j6() {
        return this.DW;
    }

    public String toString() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n.j6(this, parcel, i);
    }
}
