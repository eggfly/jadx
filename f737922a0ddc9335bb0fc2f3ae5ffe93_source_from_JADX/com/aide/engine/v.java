package com.aide.engine;

public final class v {
    private final int DW;
    private final String FH;
    private final int j6;

    public /* synthetic */ Object clone() {
        return Hw();
    }

    public v(String str, int i, int i2) {
        this.j6 = i;
        this.DW = i2;
        this.FH = str;
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public String FH() {
        return this.FH;
    }

    public v Hw() {
        return new v(this.FH, this.j6, this.DW);
    }

    public int hashCode() {
        return (this.FH.hashCode() + this.j6) + this.DW;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.j6 == vVar.j6 && this.DW == vVar.DW && this.FH.equals(vVar.FH)) {
            return true;
        }
        return false;
    }
}
