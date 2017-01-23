package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class q implements Cloneable {
    private Object DW;
    private List<v> FH;
    private o<?, ?> j6;

    q() {
        this.FH = new ArrayList();
    }

    private byte[] FH() {
        byte[] bArr = new byte[j6()];
        j6(m.j6(bArr));
        return bArr;
    }

    public final q DW() {
        q qVar = new q();
        try {
            qVar.j6 = this.j6;
            if (this.FH == null) {
                qVar.FH = null;
            } else {
                qVar.FH.addAll(this.FH);
            }
            if (this.DW != null) {
                if (this.DW instanceof t) {
                    qVar.DW = (t) ((t) this.DW).clone();
                } else if (this.DW instanceof byte[]) {
                    qVar.DW = ((byte[]) this.DW).clone();
                } else if (this.DW instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.DW;
                    r4 = new byte[bArr.length][];
                    qVar.DW = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.DW instanceof boolean[]) {
                    qVar.DW = ((boolean[]) this.DW).clone();
                } else if (this.DW instanceof int[]) {
                    qVar.DW = ((int[]) this.DW).clone();
                } else if (this.DW instanceof long[]) {
                    qVar.DW = ((long[]) this.DW).clone();
                } else if (this.DW instanceof float[]) {
                    qVar.DW = ((float[]) this.DW).clone();
                } else if (this.DW instanceof double[]) {
                    qVar.DW = ((double[]) this.DW).clone();
                } else if (this.DW instanceof t[]) {
                    t[] tVarArr = (t[]) this.DW;
                    r4 = new t[tVarArr.length];
                    qVar.DW = r4;
                    for (r2 = 0; r2 < tVarArr.length; r2++) {
                        r4[r2] = (t) tVarArr[r2].clone();
                    }
                }
            }
            return qVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return DW();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.DW != null && qVar.DW != null) {
            return this.j6 == qVar.j6 ? !this.j6.DW.isArray() ? this.DW.equals(qVar.DW) : this.DW instanceof byte[] ? Arrays.equals((byte[]) this.DW, (byte[]) qVar.DW) : this.DW instanceof int[] ? Arrays.equals((int[]) this.DW, (int[]) qVar.DW) : this.DW instanceof long[] ? Arrays.equals((long[]) this.DW, (long[]) qVar.DW) : this.DW instanceof float[] ? Arrays.equals((float[]) this.DW, (float[]) qVar.DW) : this.DW instanceof double[] ? Arrays.equals((double[]) this.DW, (double[]) qVar.DW) : this.DW instanceof boolean[] ? Arrays.equals((boolean[]) this.DW, (boolean[]) qVar.DW) : Arrays.deepEquals((Object[]) this.DW, (Object[]) qVar.DW) : false;
        } else {
            if (this.FH != null && qVar.FH != null) {
                return this.FH.equals(qVar.FH);
            }
            try {
                return Arrays.equals(FH(), qVar.FH());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(FH()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    int j6() {
        if (this.DW != null) {
            return this.j6.j6(this.DW);
        }
        int i = 0;
        for (v j6 : this.FH) {
            i = j6.j6() + i;
        }
        return i;
    }

    void j6(m mVar) {
        if (this.DW != null) {
            this.j6.j6(this.DW, mVar);
            return;
        }
        for (v j6 : this.FH) {
            j6.j6(mVar);
        }
    }

    void j6(v vVar) {
        this.FH.add(vVar);
    }
}
