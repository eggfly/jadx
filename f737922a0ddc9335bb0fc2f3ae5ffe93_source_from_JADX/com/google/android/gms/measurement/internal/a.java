package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.b;

class a {
    private final String DW;
    private long EQ;
    private String FH;
    private String Hw;
    private long J0;
    private long J8;
    private long Mr;
    private long QX;
    private boolean U2;
    private long VH;
    private boolean Ws;
    private long XL;
    private String Zo;
    private long a8;
    private long aM;
    private long gn;
    private long j3;
    private final ai j6;
    private long lg;
    private String tp;
    private long u7;
    private String v5;
    private String we;

    a(ai aiVar, String str) {
        b.j6((Object) aiVar);
        b.j6(str);
        this.j6 = aiVar;
        this.DW = str;
        this.j6.er();
    }

    public String DW() {
        this.j6.er();
        return this.DW;
    }

    public void DW(long j) {
        this.j6.er();
        this.U2 = (this.u7 != j ? 1 : 0) | this.U2;
        this.u7 = j;
    }

    public void DW(String str) {
        this.j6.er();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.U2 = (!l.FH(this.Hw, str) ? 1 : 0) | this.U2;
        this.Hw = str;
    }

    public String EQ() {
        this.j6.er();
        return this.we;
    }

    public void EQ(long j) {
        this.j6.er();
        this.U2 = (this.aM != j ? 1 : 0) | this.U2;
        this.aM = j;
    }

    public String FH() {
        this.j6.er();
        return this.FH;
    }

    public void FH(long j) {
        this.j6.er();
        this.U2 = (this.EQ != j ? 1 : 0) | this.U2;
        this.EQ = j;
    }

    public void FH(String str) {
        this.j6.er();
        this.U2 = (!l.FH(this.v5, str) ? 1 : 0) | this.U2;
        this.v5 = str;
    }

    public String Hw() {
        this.j6.er();
        return this.Hw;
    }

    public void Hw(long j) {
        this.j6.er();
        this.U2 = (this.J0 != j ? 1 : 0) | this.U2;
        this.J0 = j;
    }

    public void Hw(String str) {
        this.j6.er();
        this.U2 = (!l.FH(this.Zo, str) ? 1 : 0) | this.U2;
        this.Zo = str;
    }

    public long J0() {
        this.j6.er();
        return this.J8;
    }

    public void J0(long j) {
        this.j6.er();
        this.U2 = (this.Mr != j ? 1 : 0) | this.U2;
        this.Mr = j;
    }

    public boolean J8() {
        this.j6.er();
        return this.Ws;
    }

    public long Mr() {
        this.j6.er();
        return this.XL;
    }

    public long QX() {
        this.j6.er();
        return this.a8;
    }

    public long U2() {
        this.j6.er();
        return this.aM;
    }

    public long VH() {
        this.j6.er();
        return this.gn;
    }

    public void VH(long j) {
        this.j6.er();
        this.U2 = (this.a8 != j ? 1 : 0) | this.U2;
        this.a8 = j;
    }

    public long Ws() {
        this.j6.er();
        return this.VH;
    }

    public long XL() {
        this.j6.er();
        return this.lg;
    }

    public String Zo() {
        this.j6.er();
        return this.Zo;
    }

    public void Zo(long j) {
        int i = 1;
        b.DW(j >= 0);
        this.j6.er();
        boolean z = this.U2;
        if (this.VH == j) {
            i = 0;
        }
        this.U2 = z | i;
        this.VH = j;
    }

    public void Zo(String str) {
        this.j6.er();
        this.U2 = (!l.FH(this.we, str) ? 1 : 0) | this.U2;
        this.we = str;
    }

    public long a8() {
        this.j6.er();
        return this.j3;
    }

    public void aM() {
        this.j6.er();
        long j = this.VH + 1;
        if (j > 2147483647L) {
            this.j6.Zo().yS().j6("Bundle index overflow");
            j = 0;
        }
        this.U2 = true;
        this.VH = j;
    }

    public long gn() {
        this.j6.er();
        return this.u7;
    }

    public void gn(long j) {
        this.j6.er();
        this.U2 = (this.lg != j ? 1 : 0) | this.U2;
        this.lg = j;
    }

    public long j3() {
        this.j6.er();
        return this.QX;
    }

    public void j6() {
        this.j6.er();
        this.U2 = false;
    }

    public void j6(long j) {
        this.j6.er();
        this.U2 = (this.gn != j ? 1 : 0) | this.U2;
        this.gn = j;
    }

    public void j6(String str) {
        this.j6.er();
        this.U2 = (!l.FH(this.FH, str) ? 1 : 0) | this.U2;
        this.FH = str;
    }

    public void j6(boolean z) {
        this.j6.er();
        this.U2 = (this.Ws != z ? 1 : 0) | this.U2;
        this.Ws = z;
    }

    public long lg() {
        this.j6.er();
        return this.Mr;
    }

    public long tp() {
        this.j6.er();
        return this.EQ;
    }

    public void tp(long j) {
        this.j6.er();
        this.U2 = (this.XL != j ? 1 : 0) | this.U2;
        this.XL = j;
    }

    public String u7() {
        this.j6.er();
        return this.tp;
    }

    public void u7(long j) {
        this.j6.er();
        this.U2 = (this.QX != j ? 1 : 0) | this.U2;
        this.QX = j;
    }

    public String v5() {
        this.j6.er();
        return this.v5;
    }

    public void v5(long j) {
        this.j6.er();
        this.U2 = (this.J8 != j ? 1 : 0) | this.U2;
        this.J8 = j;
    }

    public void v5(String str) {
        this.j6.er();
        this.U2 = (!l.FH(this.tp, str) ? 1 : 0) | this.U2;
        this.tp = str;
    }

    public long we() {
        this.j6.er();
        return this.J0;
    }

    public void we(long j) {
        this.j6.er();
        this.U2 = (this.j3 != j ? 1 : 0) | this.U2;
        this.j3 = j;
    }
}
