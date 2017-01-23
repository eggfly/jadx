package com.google.android.gms.internal;

import java.util.Arrays;

final class v {
    final byte[] DW;
    final int j6;

    v(int i, byte[] bArr) {
        this.j6 = i;
        this.DW = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.j6 == vVar.j6 && Arrays.equals(this.DW, vVar.DW);
    }

    public int hashCode() {
        return ((this.j6 + 527) * 31) + Arrays.hashCode(this.DW);
    }

    int j6() {
        return (m.Zo(this.j6) + 0) + this.DW.length;
    }

    void j6(m mVar) {
        mVar.v5(this.j6);
        mVar.Hw(this.DW);
    }
}
