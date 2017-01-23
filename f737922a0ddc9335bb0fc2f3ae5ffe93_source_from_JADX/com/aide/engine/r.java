package com.aide.engine;

import java.util.List;

public class r implements l {
    private final String DW;
    private final String FH;
    private final String Hw;
    private final l Zo;
    private final boolean j6;
    private final List<l> v5;

    public r(boolean z, String str, String str2, String str3, List<l> list, l lVar) {
        this.j6 = z;
        this.DW = str;
        this.FH = str2;
        this.Hw = str3;
        this.v5 = list;
        this.Zo = lVar;
    }

    public String toString() {
        String str = (this.j6 ? "" : this.Zo + ".") + "(" + this.DW + ")." + this.FH + "(";
        String str2 = str;
        for (l lVar : this.v5) {
            str2 = str2 + lVar + ",";
        }
        return str2 + ")";
    }
}
