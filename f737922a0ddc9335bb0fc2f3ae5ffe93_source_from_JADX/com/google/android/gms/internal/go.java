package com.google.android.gms.internal;

import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.ae;

public final class go<O extends a> {
    private final O DW;
    private final com.google.android.gms.common.api.a<O> j6;

    public String DW() {
        return this.j6.v5();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof go)) {
            return false;
        }
        go goVar = (go) obj;
        return ae.j6(this.j6, goVar.j6) && ae.j6(this.DW, goVar.DW);
    }

    public int hashCode() {
        return ae.j6(this.j6, this.DW);
    }

    public d<?> j6() {
        return this.j6.FH();
    }
}
