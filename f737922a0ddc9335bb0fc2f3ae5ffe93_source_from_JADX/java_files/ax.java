public class ax {
    private cc j6;

    public ax(cc ccVar) {
        this.j6 = ccVar;
    }

    public void j6(bv bvVar, int i, int i2) {
        this.j6.rN.DW();
        cj FH = this.j6.sh.FH(bvVar, i, 1);
        if (!(FH == null || FH.tp().v5() == null)) {
            FH.tp().v5().DW(bvVar, i, i2);
        }
        this.j6.rN.FH();
    }

    public void DW(bv bvVar, int i, int i2) {
        this.j6.rN.DW();
        cj FH = this.j6.sh.FH(bvVar, i, 1);
        if (!(FH == null || FH.tp().v5() == null)) {
            FH.tp().v5().j6(bvVar, i, i2);
        }
        this.j6.rN.FH();
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, boolean z) {
        int v5;
        int ro;
        int i5;
        int i6;
        cj FH = this.j6.sh.FH(bvVar, i, i2);
        if (z) {
            int gn = FH.gn(i, i2, i3, i4);
            v5 = FH.v5(i, i2, i3, i4);
            if (gn == -1 || gn == v5) {
                do DW = FH.DW(i, i2, i3, i4);
                if (DW != null) {
                    i = FH.nw(DW.FH(0));
                    i2 = FH.KD(DW.FH(0));
                    i3 = FH.SI(DW.FH(DW.Hw() - 1));
                    ro = FH.ro(DW.FH(DW.Hw() - 1));
                    i5 = i3;
                    i6 = i2;
                    v5 = i;
                    this.j6.vy.j6(FH.tp(), v5, i6, i5, ro, z);
                }
            }
            i = FH.nw(gn);
            i2 = FH.KD(gn);
            i3 = FH.SI(gn);
            ro = FH.ro(gn);
            i5 = i3;
            i6 = i2;
            v5 = i;
            this.j6.vy.j6(FH.tp(), v5, i6, i5, ro, z);
        }
        ro = i4;
        i5 = i3;
        i6 = i2;
        v5 = i;
        this.j6.vy.j6(FH.tp(), v5, i6, i5, ro, z);
    }

    public void FH(bv bvVar, int i, int i2) {
        cj FH = this.j6.sh.FH(bvVar, i, i2);
        if (FH.tp().v5() != null) {
            FH.tp().v5().j6(FH, i, i2);
        } else {
            this.j6.sh.j6(FH);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(bv r10, int r11, int r12, int r13, int r14) {
        /*
        r9 = this;
        r3 = -1;
        r5 = 1;
        if (r11 > r13) goto L_0x0008;
    L_0x0004:
        if (r11 != r13) goto L_0x000e;
    L_0x0006:
        if (r12 <= r14) goto L_0x000e;
    L_0x0008:
        r7 = r12;
        r12 = r14;
        r14 = r7;
        r8 = r11;
        r11 = r13;
        r13 = r8;
    L_0x000e:
        r0 = r10.BT();
        if (r0 == 0) goto L_0x00c0;
    L_0x0014:
        r0 = r9.j6;
        r0 = r0.sh;
        r1 = r0.FH(r10, r11, r12);
        r0 = r1.j6(r11, r12, r13, r14);
        if (r0 == r3) goto L_0x00b9;
    L_0x0022:
        r2 = r1.nw(r0);
        if (r11 != r2) goto L_0x003a;
    L_0x0028:
        r2 = r1.KD(r0);
        if (r12 != r2) goto L_0x003a;
    L_0x002e:
        r2 = r1.SI(r0);
        if (r13 != r2) goto L_0x003a;
    L_0x0034:
        r2 = r1.ro(r0);
        if (r14 == r2) goto L_0x0052;
    L_0x003a:
        r2 = r1.nw(r0);
        if (r2 <= 0) goto L_0x0052;
    L_0x0040:
        r2 = r1.KD(r0);
        if (r2 <= 0) goto L_0x0052;
    L_0x0046:
        r2 = r1.SI(r0);
        if (r2 <= 0) goto L_0x0052;
    L_0x004c:
        r2 = r1.ro(r0);
        if (r2 > 0) goto L_0x005d;
    L_0x0052:
        r2 = r1.aM(r0);
        if (r2 == r3) goto L_0x005d;
    L_0x0058:
        r0 = r1.aM(r0);
        goto L_0x0022;
    L_0x005d:
        r2 = r1.aM(r0);
        if (r2 == r3) goto L_0x00b9;
    L_0x0063:
        r2 = r1.nw(r0);
        if (r2 <= 0) goto L_0x00b9;
    L_0x0069:
        r2 = r1.KD(r0);
        if (r2 <= 0) goto L_0x00b9;
    L_0x006f:
        r2 = r1.SI(r0);
        if (r2 <= 0) goto L_0x00b9;
    L_0x0075:
        r2 = r1.ro(r0);
        if (r2 <= 0) goto L_0x00b9;
    L_0x007b:
        r2 = r1.nw(r0);
        r3 = r1.KD(r0);
        r4 = r1.SI(r0);
        r0 = r1.ro(r0);
        r6 = r9.j6;
        r6 = r6.sh;
        r6.j6(r1);
    L_0x0092:
        if (r11 != r2) goto L_0x00d0;
    L_0x0094:
        if (r12 != r3) goto L_0x00d0;
    L_0x0096:
        if (r13 != r4) goto L_0x00d0;
    L_0x0098:
        if (r14 != r0) goto L_0x00d0;
    L_0x009a:
        r0 = r10.a8();
        r4 = r0 + 1;
        r3 = r5;
        r2 = r5;
    L_0x00a2:
        r0 = r9.j6;
        r0 = r0.rN;
        r0.DW();
        r0 = r9.j6;
        r0 = r0.rN;
        r1 = r10;
        r0.FH(r1, r2, r3, r4, r5);
        r0 = r9.j6;
        r0 = r0.rN;
        r0.we();
        return;
    L_0x00b9:
        r0 = r9.j6;
        r0 = r0.sh;
        r0.j6(r1);
    L_0x00c0:
        if (r11 != r13) goto L_0x00d2;
    L_0x00c2:
        r0 = r10.DW(r11);
        r0 = r0.length();
        r0 = r0 + 1;
        r4 = r13;
        r3 = r5;
        r2 = r11;
        goto L_0x0092;
    L_0x00d0:
        r5 = r0;
        goto L_0x00a2;
    L_0x00d2:
        r0 = r14;
        r4 = r13;
        r3 = r12;
        r2 = r11;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: ax.j6(bv, int, int, int, int):void");
    }
}
