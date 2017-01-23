package com.google.android.gms.internal;

import java.lang.reflect.Array;

public class o<M extends n<M>, T> {
    protected final Class<T> DW;
    public final int FH;
    protected final boolean Hw;
    protected final int j6;

    protected int DW(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += FH(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void DW(Object obj, m mVar) {
        try {
            mVar.v5(this.FH);
            switch (this.j6) {
                case 10:
                    t tVar = (t) obj;
                    int DW = w.DW(this.FH);
                    mVar.j6(tVar);
                    mVar.FH(DW, 4);
                    return;
                case 11:
                    mVar.DW((t) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.j6);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int FH(Object obj) {
        int DW = w.DW(this.FH);
        switch (this.j6) {
            case 10:
                return m.DW(DW, (t) obj);
            case 11:
                return m.FH(DW, (t) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.j6);
        }
    }

    protected void FH(Object obj, m mVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                DW(obj2, mVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.j6 == oVar.j6 && this.DW == oVar.DW && this.FH == oVar.FH && this.Hw == oVar.Hw;
    }

    public int hashCode() {
        return (this.Hw ? 1 : 0) + ((((((this.j6 + 1147) * 31) + this.DW.hashCode()) * 31) + this.FH) * 31);
    }

    int j6(Object obj) {
        return this.Hw ? DW(obj) : FH(obj);
    }

    void j6(Object obj, m mVar) {
        if (this.Hw) {
            FH(obj, mVar);
        } else {
            DW(obj, mVar);
        }
    }
}
