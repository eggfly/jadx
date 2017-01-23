package com.aide.engine;

public class q implements l {
    private final boolean DW;
    private final String FH;
    private final String Hw;
    private final boolean j6;
    private final l v5;

    public q(boolean z, boolean z2, String str, String str2, l lVar) {
        this.j6 = z;
        this.DW = z2;
        this.FH = str;
        this.Hw = str2;
        this.v5 = lVar;
    }

    public String toString() {
        return (this.j6 ? "" : this.v5 + ".") + "(" + this.FH + ")." + this.Hw;
    }
}
