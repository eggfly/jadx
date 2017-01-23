package com.aide.engine;

public final class k {
    private final String DW;
    private final String FH;
    private final String j6;

    public /* synthetic */ Object clone() {
        return Hw();
    }

    public k(String str, String str2, String str3) {
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
    }

    public String j6() {
        return this.j6;
    }

    public String DW() {
        return this.DW;
    }

    public String FH() {
        return this.FH;
    }

    public k Hw() {
        return new k(this.j6, this.DW, this.FH);
    }

    public int hashCode() {
        return (this.j6.hashCode() + this.DW.hashCode()) + this.FH.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.j6.equals(kVar.j6) && this.DW.equals(kVar.DW) && this.FH.equals(kVar.FH)) {
            return true;
        }
        return false;
    }
}
