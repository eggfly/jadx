final class ags {
    private static final int[] Ws;
    int DW;
    int[] EQ;
    int[] FH;
    int Hw;
    int[] J0;
    int J8;
    private final agx QX;
    int VH;
    private final agr XL;
    int Zo;
    int gn;
    int j6;
    byte tp;
    byte u7;
    int v5;
    int we;

    static {
        int[] iArr = new int[17];
        iArr[1] = 1;
        iArr[2] = 3;
        iArr[3] = 7;
        iArr[4] = 15;
        iArr[5] = 31;
        iArr[6] = 63;
        iArr[7] = 127;
        iArr[8] = 255;
        iArr[9] = 511;
        iArr[10] = 1023;
        iArr[11] = 2047;
        iArr[12] = 4095;
        iArr[13] = 8191;
        iArr[14] = 16383;
        iArr[15] = 32767;
        iArr[16] = 65535;
        Ws = iArr;
    }

    ags(agx agx, agr agr) {
        this.Hw = 0;
        this.QX = agx;
        this.XL = agr;
    }

    void j6(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        this.j6 = 0;
        this.u7 = (byte) i;
        this.tp = (byte) i2;
        this.EQ = iArr;
        this.we = i3;
        this.J0 = iArr2;
        this.J8 = i4;
        this.FH = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int j6(int r12) {
        /*
        r11 = this;
        r0 = r11.QX;
        r3 = r0.DW;
        r0 = r11.QX;
        r2 = r0.FH;
        r0 = r11.XL;
        r5 = r0.XL;
        r0 = r11.XL;
        r4 = r0.QX;
        r0 = r11.XL;
        r1 = r0.a8;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x0050;
    L_0x001a:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x0021:
        r6 = r11.j6;
        switch(r6) {
            case 0: goto L_0x0056;
            case 1: goto L_0x00d8;
            case 2: goto L_0x01b0;
            case 3: goto L_0x01d1;
            case 4: goto L_0x02d2;
            case 5: goto L_0x02e7;
            case 6: goto L_0x03f1;
            case 7: goto L_0x0496;
            case 8: goto L_0x04f8;
            case 9: goto L_0x0523;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = -2;
        r6 = r11.XL;
        r6.XL = r5;
        r5 = r11.XL;
        r5.QX = r4;
        r4 = r11.QX;
        r4.FH = r2;
        r2 = r11.QX;
        r4 = r2.Hw;
        r6 = r11.QX;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r11.QX;
        r2.DW = r3;
        r2 = r11.XL;
        r2.a8 = r1;
        r1 = r11.XL;
        r0 = r1.DW(r0);
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x0021;
    L_0x0056:
        r6 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
        if (r0 < r6) goto L_0x00c9;
    L_0x005a:
        r6 = 10;
        if (r2 < r6) goto L_0x00c9;
    L_0x005e:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r4;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r6 = (long) r2;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r1 = r11.u7;
        r2 = r11.tp;
        r3 = r11.EQ;
        r4 = r11.we;
        r5 = r11.J0;
        r6 = r11.J8;
        r7 = r11.XL;
        r8 = r11.QX;
        r0 = r11;
        r12 = r0.j6(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r11.QX;
        r3 = r0.DW;
        r0 = r11.QX;
        r2 = r0.FH;
        r0 = r11.XL;
        r5 = r0.XL;
        r0 = r11.XL;
        r4 = r0.QX;
        r0 = r11.XL;
        r1 = r0.a8;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x00c0;
    L_0x00af:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x00b6:
        if (r12 == 0) goto L_0x00c9;
    L_0x00b8:
        r6 = 1;
        if (r12 != r6) goto L_0x00c6;
    L_0x00bb:
        r6 = 7;
    L_0x00bc:
        r11.j6 = r6;
        goto L_0x0021;
    L_0x00c0:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x00b6;
    L_0x00c6:
        r6 = 9;
        goto L_0x00bc;
    L_0x00c9:
        r6 = r11.u7;
        r11.v5 = r6;
        r6 = r11.EQ;
        r11.FH = r6;
        r6 = r11.we;
        r11.Hw = r6;
        r6 = 1;
        r11.j6 = r6;
    L_0x00d8:
        r7 = r11.v5;
        r6 = r4;
    L_0x00db:
        if (r6 < r7) goto L_0x0109;
    L_0x00dd:
        r4 = r11.Hw;
        r8 = Ws;
        r7 = r8[r7];
        r7 = r7 & r5;
        r4 = r4 + r7;
        r7 = r4 * 3;
        r4 = r11.FH;
        r8 = r7 + 1;
        r4 = r4[r8];
        r5 = r5 >>> r4;
        r4 = r11.FH;
        r8 = r7 + 1;
        r4 = r4[r8];
        r4 = r6 - r4;
        r6 = r11.FH;
        r6 = r6[r7];
        if (r6 != 0) goto L_0x0149;
    L_0x00fc:
        r6 = r11.FH;
        r7 = r7 + 2;
        r6 = r6[r7];
        r11.Zo = r6;
        r6 = 6;
        r11.j6 = r6;
        goto L_0x0021;
    L_0x0109:
        if (r2 == 0) goto L_0x011f;
    L_0x010b:
        r12 = 0;
        r2 = r2 + -1;
        r4 = r11.QX;
        r8 = r4.j6;
        r4 = r3 + 1;
        r3 = r8[r3];
        r3 = r3 & 255;
        r3 = r3 << r6;
        r5 = r5 | r3;
        r3 = r6 + 8;
        r6 = r3;
        r3 = r4;
        goto L_0x00db;
    L_0x011f:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r6;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r6 = (long) r2;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r12);
        goto L_0x004f;
    L_0x0149:
        r8 = r6 & 16;
        if (r8 == 0) goto L_0x015e;
    L_0x014d:
        r6 = r6 & 15;
        r11.VH = r6;
        r6 = r11.FH;
        r7 = r7 + 2;
        r6 = r6[r7];
        r11.DW = r6;
        r6 = 2;
        r11.j6 = r6;
        goto L_0x0021;
    L_0x015e:
        r8 = r6 & 64;
        if (r8 != 0) goto L_0x0171;
    L_0x0162:
        r11.v5 = r6;
        r6 = r7 / 3;
        r8 = r11.FH;
        r7 = r7 + 2;
        r7 = r8[r7];
        r6 = r6 + r7;
        r11.Hw = r6;
        goto L_0x0021;
    L_0x0171:
        r6 = r6 & 32;
        if (r6 == 0) goto L_0x017a;
    L_0x0175:
        r6 = 7;
        r11.j6 = r6;
        goto L_0x0021;
    L_0x017a:
        r0 = 9;
        r11.j6 = r0;
        r0 = r11.QX;
        r6 = "invalid literal/length code";
        r0.u7 = r6;
        r0 = -3;
        r6 = r11.XL;
        r6.XL = r5;
        r5 = r11.XL;
        r5.QX = r4;
        r4 = r11.QX;
        r4.FH = r2;
        r2 = r11.QX;
        r4 = r2.Hw;
        r6 = r11.QX;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r11.QX;
        r2.DW = r3;
        r2 = r11.XL;
        r2.a8 = r1;
        r1 = r11.XL;
        r0 = r1.DW(r0);
        goto L_0x004f;
    L_0x01b0:
        r7 = r11.VH;
        r6 = r4;
    L_0x01b3:
        if (r6 < r7) goto L_0x0208;
    L_0x01b5:
        r4 = r11.DW;
        r8 = Ws;
        r8 = r8[r7];
        r8 = r8 & r5;
        r4 = r4 + r8;
        r11.DW = r4;
        r5 = r5 >> r7;
        r4 = r6 - r7;
        r6 = r11.tp;
        r11.v5 = r6;
        r6 = r11.J0;
        r11.FH = r6;
        r6 = r11.J8;
        r11.Hw = r6;
        r6 = 3;
        r11.j6 = r6;
    L_0x01d1:
        r7 = r11.v5;
        r6 = r4;
    L_0x01d4:
        if (r6 < r7) goto L_0x0248;
    L_0x01d6:
        r4 = r11.Hw;
        r8 = Ws;
        r7 = r8[r7];
        r7 = r7 & r5;
        r4 = r4 + r7;
        r7 = r4 * 3;
        r4 = r11.FH;
        r8 = r7 + 1;
        r4 = r4[r8];
        r5 = r5 >> r4;
        r4 = r11.FH;
        r8 = r7 + 1;
        r4 = r4[r8];
        r4 = r6 - r4;
        r6 = r11.FH;
        r6 = r6[r7];
        r8 = r6 & 16;
        if (r8 == 0) goto L_0x0289;
    L_0x01f7:
        r6 = r6 & 15;
        r11.VH = r6;
        r6 = r11.FH;
        r7 = r7 + 2;
        r6 = r6[r7];
        r11.gn = r6;
        r6 = 4;
        r11.j6 = r6;
        goto L_0x0021;
    L_0x0208:
        if (r2 == 0) goto L_0x021e;
    L_0x020a:
        r12 = 0;
        r2 = r2 + -1;
        r4 = r11.QX;
        r8 = r4.j6;
        r4 = r3 + 1;
        r3 = r8[r3];
        r3 = r3 & 255;
        r3 = r3 << r6;
        r5 = r5 | r3;
        r3 = r6 + 8;
        r6 = r3;
        r3 = r4;
        goto L_0x01b3;
    L_0x021e:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r6;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r6 = (long) r2;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r12);
        goto L_0x004f;
    L_0x0248:
        if (r2 == 0) goto L_0x025f;
    L_0x024a:
        r12 = 0;
        r2 = r2 + -1;
        r4 = r11.QX;
        r8 = r4.j6;
        r4 = r3 + 1;
        r3 = r8[r3];
        r3 = r3 & 255;
        r3 = r3 << r6;
        r5 = r5 | r3;
        r3 = r6 + 8;
        r6 = r3;
        r3 = r4;
        goto L_0x01d4;
    L_0x025f:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r6;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r6 = (long) r2;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r12);
        goto L_0x004f;
    L_0x0289:
        r8 = r6 & 64;
        if (r8 != 0) goto L_0x029c;
    L_0x028d:
        r11.v5 = r6;
        r6 = r7 / 3;
        r8 = r11.FH;
        r7 = r7 + 2;
        r7 = r8[r7];
        r6 = r6 + r7;
        r11.Hw = r6;
        goto L_0x0021;
    L_0x029c:
        r0 = 9;
        r11.j6 = r0;
        r0 = r11.QX;
        r6 = "invalid distance code";
        r0.u7 = r6;
        r0 = -3;
        r6 = r11.XL;
        r6.XL = r5;
        r5 = r11.XL;
        r5.QX = r4;
        r4 = r11.QX;
        r4.FH = r2;
        r2 = r11.QX;
        r4 = r2.Hw;
        r6 = r11.QX;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r11.QX;
        r2.DW = r3;
        r2 = r11.XL;
        r2.a8 = r1;
        r1 = r11.XL;
        r0 = r1.DW(r0);
        goto L_0x004f;
    L_0x02d2:
        r7 = r11.VH;
        r6 = r4;
    L_0x02d5:
        if (r6 < r7) goto L_0x02f6;
    L_0x02d7:
        r4 = r11.gn;
        r8 = Ws;
        r8 = r8[r7];
        r8 = r8 & r5;
        r4 = r4 + r8;
        r11.gn = r4;
        r5 = r5 >> r7;
        r4 = r6 - r7;
        r6 = 5;
        r11.j6 = r6;
    L_0x02e7:
        r6 = r11.gn;
        r6 = r1 - r6;
    L_0x02eb:
        if (r6 < 0) goto L_0x0336;
    L_0x02ed:
        r7 = r11.DW;
        if (r7 != 0) goto L_0x033c;
    L_0x02f1:
        r6 = 0;
        r11.j6 = r6;
        goto L_0x0021;
    L_0x02f6:
        if (r2 == 0) goto L_0x030c;
    L_0x02f8:
        r12 = 0;
        r2 = r2 + -1;
        r4 = r11.QX;
        r8 = r4.j6;
        r4 = r3 + 1;
        r3 = r8[r3];
        r3 = r3 & 255;
        r3 = r3 << r6;
        r5 = r5 | r3;
        r3 = r6 + 8;
        r6 = r3;
        r3 = r4;
        goto L_0x02d5;
    L_0x030c:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r6;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r6 = (long) r2;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r12);
        goto L_0x004f;
    L_0x0336:
        r7 = r11.XL;
        r7 = r7.Mr;
        r6 = r6 + r7;
        goto L_0x02eb;
    L_0x033c:
        if (r0 != 0) goto L_0x03cd;
    L_0x033e:
        r7 = r11.XL;
        r7 = r7.Mr;
        if (r1 != r7) goto L_0x0358;
    L_0x0344:
        r7 = r11.XL;
        r7 = r7.U2;
        if (r7 == 0) goto L_0x0358;
    L_0x034a:
        r1 = 0;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x03bb;
    L_0x0351:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x0358:
        if (r0 != 0) goto L_0x03cd;
    L_0x035a:
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r12 = r0.DW(r12);
        r0 = r11.XL;
        r1 = r0.a8;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x03c1;
    L_0x036e:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x0375:
        r7 = r11.XL;
        r7 = r7.Mr;
        if (r1 != r7) goto L_0x038f;
    L_0x037b:
        r7 = r11.XL;
        r7 = r7.U2;
        if (r7 == 0) goto L_0x038f;
    L_0x0381:
        r1 = 0;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x03c7;
    L_0x0388:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x038f:
        if (r0 != 0) goto L_0x03cd;
    L_0x0391:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r4;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r6 = (long) r2;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r12);
        goto L_0x004f;
    L_0x03bb:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x0358;
    L_0x03c1:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x0375;
    L_0x03c7:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x038f;
    L_0x03cd:
        r7 = r11.XL;
        r9 = r7.j3;
        r7 = r1 + 1;
        r8 = r11.XL;
        r10 = r8.j3;
        r8 = r6 + 1;
        r6 = r10[r6];
        r9[r1] = r6;
        r1 = r0 + -1;
        r0 = r11.XL;
        r0 = r0.Mr;
        if (r8 != r0) goto L_0x054e;
    L_0x03e5:
        r0 = 0;
    L_0x03e6:
        r6 = r11.DW;
        r6 = r6 + -1;
        r11.DW = r6;
        r6 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x02ed;
    L_0x03f1:
        if (r0 != 0) goto L_0x0482;
    L_0x03f3:
        r6 = r11.XL;
        r6 = r6.Mr;
        if (r1 != r6) goto L_0x040d;
    L_0x03f9:
        r6 = r11.XL;
        r6 = r6.U2;
        if (r6 == 0) goto L_0x040d;
    L_0x03ff:
        r1 = 0;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x0470;
    L_0x0406:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x040d:
        if (r0 != 0) goto L_0x0482;
    L_0x040f:
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r6 = r0.DW(r12);
        r0 = r11.XL;
        r1 = r0.a8;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x0476;
    L_0x0423:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x042a:
        r7 = r11.XL;
        r7 = r7.Mr;
        if (r1 != r7) goto L_0x0444;
    L_0x0430:
        r7 = r11.XL;
        r7 = r7.U2;
        if (r7 == 0) goto L_0x0444;
    L_0x0436:
        r1 = 0;
        r0 = r11.XL;
        r0 = r0.U2;
        if (r1 >= r0) goto L_0x047c;
    L_0x043d:
        r0 = r11.XL;
        r0 = r0.U2;
        r0 = r0 - r1;
        r0 = r0 + -1;
    L_0x0444:
        if (r0 != 0) goto L_0x0482;
    L_0x0446:
        r0 = r11.XL;
        r0.XL = r5;
        r0 = r11.XL;
        r0.QX = r4;
        r0 = r11.QX;
        r0.FH = r2;
        r0 = r11.QX;
        r4 = r0.Hw;
        r2 = r11.QX;
        r2 = r2.DW;
        r2 = r3 - r2;
        r8 = (long) r2;
        r4 = r4 + r8;
        r0.Hw = r4;
        r0 = r11.QX;
        r0.DW = r3;
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r6);
        goto L_0x004f;
    L_0x0470:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x040d;
    L_0x0476:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x042a;
    L_0x047c:
        r0 = r11.XL;
        r0 = r0.Mr;
        r0 = r0 - r1;
        goto L_0x0444;
    L_0x0482:
        r6 = r1;
        r12 = 0;
        r1 = r11.XL;
        r7 = r1.j3;
        r1 = r6 + 1;
        r8 = r11.Zo;
        r8 = (byte) r8;
        r7[r6] = r8;
        r0 = r0 + -1;
        r6 = 0;
        r11.j6 = r6;
        goto L_0x0021;
    L_0x0496:
        r0 = 7;
        if (r4 <= r0) goto L_0x049f;
    L_0x0499:
        r4 = r4 + -8;
        r2 = r2 + 1;
        r3 = r3 + -1;
    L_0x049f:
        r0 = r11.XL;
        r0.a8 = r1;
        r0 = r11.XL;
        r0 = r0.DW(r12);
        r1 = r11.XL;
        r1 = r1.a8;
        r6 = r11.XL;
        r6 = r6.U2;
        if (r1 >= r6) goto L_0x04ee;
    L_0x04b3:
        r6 = r11.XL;
        r6 = r6.U2;
        r6 = r6 - r1;
        r6 = r6 + -1;
    L_0x04ba:
        r6 = r11.XL;
        r6 = r6.U2;
        r7 = r11.XL;
        r7 = r7.a8;
        if (r6 == r7) goto L_0x04f4;
    L_0x04c4:
        r6 = r11.XL;
        r6.XL = r5;
        r5 = r11.XL;
        r5.QX = r4;
        r4 = r11.QX;
        r4.FH = r2;
        r2 = r11.QX;
        r4 = r2.Hw;
        r6 = r11.QX;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r11.QX;
        r2.DW = r3;
        r2 = r11.XL;
        r2.a8 = r1;
        r1 = r11.XL;
        r0 = r1.DW(r0);
        goto L_0x004f;
    L_0x04ee:
        r6 = r11.XL;
        r6 = r6.Mr;
        r6 = r6 - r1;
        goto L_0x04ba;
    L_0x04f4:
        r0 = 8;
        r11.j6 = r0;
    L_0x04f8:
        r0 = 1;
        r6 = r11.XL;
        r6.XL = r5;
        r5 = r11.XL;
        r5.QX = r4;
        r4 = r11.QX;
        r4.FH = r2;
        r2 = r11.QX;
        r4 = r2.Hw;
        r6 = r11.QX;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r11.QX;
        r2.DW = r3;
        r2 = r11.XL;
        r2.a8 = r1;
        r1 = r11.XL;
        r0 = r1.DW(r0);
        goto L_0x004f;
    L_0x0523:
        r0 = -3;
        r6 = r11.XL;
        r6.XL = r5;
        r5 = r11.XL;
        r5.QX = r4;
        r4 = r11.QX;
        r4.FH = r2;
        r2 = r11.QX;
        r4 = r2.Hw;
        r6 = r11.QX;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r11.QX;
        r2.DW = r3;
        r2 = r11.XL;
        r2.a8 = r1;
        r1 = r11.XL;
        r0 = r1.DW(r0);
        goto L_0x004f;
    L_0x054e:
        r0 = r8;
        goto L_0x03e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: ags.j6(int):int");
    }

    void j6(agx agx) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int j6(int r18, int r19, int[] r20, int r21, int[] r22, int r23, agr r24, agx r25) {
        /*
        r17 = this;
        r0 = r25;
        r9 = r0.DW;
        r0 = r25;
        r8 = r0.FH;
        r0 = r24;
        r4 = r0.XL;
        r0 = r24;
        r3 = r0.QX;
        r0 = r24;
        r7 = r0.a8;
        r0 = r24;
        r2 = r0.U2;
        if (r7 >= r2) goto L_0x0094;
    L_0x001a:
        r0 = r24;
        r2 = r0.U2;
        r2 = r2 - r7;
        r2 = r2 + -1;
    L_0x0021:
        r5 = Ws;
        r15 = r5[r18];
        r5 = Ws;
        r16 = r5[r19];
        r14 = r2;
    L_0x002a:
        r2 = 20;
        if (r3 < r2) goto L_0x009a;
    L_0x002e:
        r6 = r4 & r15;
        r2 = r21 + r6;
        r2 = r2 * 3;
        r5 = r20[r2];
        if (r5 != 0) goto L_0x00ad;
    L_0x0038:
        r5 = r2 + 1;
        r5 = r20[r5];
        r4 = r4 >> r5;
        r5 = r2 + 1;
        r5 = r20[r5];
        r3 = r3 - r5;
        r0 = r24;
        r5 = r0.j3;
        r6 = r7 + 1;
        r2 = r2 + 2;
        r2 = r20[r2];
        r2 = (byte) r2;
        r5[r7] = r2;
        r2 = r14 + -1;
        r5 = r3;
        r7 = r4;
        r3 = r8;
        r4 = r9;
    L_0x0055:
        r8 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
        if (r2 < r8) goto L_0x005d;
    L_0x0059:
        r8 = 10;
        if (r3 >= r8) goto L_0x02f0;
    L_0x005d:
        r0 = r25;
        r2 = r0.FH;
        r2 = r2 - r3;
        r8 = r5 >> 3;
        if (r8 >= r2) goto L_0x0068;
    L_0x0066:
        r2 = r5 >> 3;
    L_0x0068:
        r3 = r3 + r2;
        r4 = r4 - r2;
        r2 = r2 << 3;
        r2 = r5 - r2;
        r0 = r24;
        r0.XL = r7;
        r0 = r24;
        r0.QX = r2;
        r0 = r25;
        r0.FH = r3;
        r0 = r25;
        r2 = r0.Hw;
        r0 = r25;
        r5 = r0.DW;
        r5 = r4 - r5;
        r8 = (long) r5;
        r2 = r2 + r8;
        r0 = r25;
        r0.Hw = r2;
        r0 = r25;
        r0.DW = r4;
        r0 = r24;
        r0.a8 = r6;
        r2 = 0;
    L_0x0093:
        return r2;
    L_0x0094:
        r0 = r24;
        r2 = r0.Mr;
        r2 = r2 - r7;
        goto L_0x0021;
    L_0x009a:
        r8 = r8 + -1;
        r0 = r25;
        r5 = r0.j6;
        r2 = r9 + 1;
        r5 = r5[r9];
        r5 = r5 & 255;
        r5 = r5 << r3;
        r4 = r4 | r5;
        r3 = r3 + 8;
        r9 = r2;
        goto L_0x002a;
    L_0x00ad:
        r10 = r2 + 1;
        r10 = r20[r10];
        r4 = r4 >> r10;
        r10 = r2 + 1;
        r10 = r20[r10];
        r3 = r3 - r10;
        r10 = r5 & 16;
        if (r10 == 0) goto L_0x023a;
    L_0x00bb:
        r5 = r5 & 15;
        r2 = r2 + 2;
        r2 = r20[r2];
        r6 = Ws;
        r6 = r6[r5];
        r6 = r6 & r4;
        r13 = r2 + r6;
        r4 = r4 >> r5;
        r3 = r3 - r5;
        r10 = r9;
        r9 = r8;
    L_0x00cc:
        r2 = 15;
        if (r3 < r2) goto L_0x0150;
    L_0x00d0:
        r6 = r4 & r16;
        r2 = r23 + r6;
        r2 = r2 * 3;
        r5 = r22[r2];
    L_0x00d8:
        r8 = r2 + 1;
        r8 = r22[r8];
        r4 = r4 >> r8;
        r8 = r2 + 1;
        r8 = r22[r8];
        r3 = r3 - r8;
        r8 = r5 & 16;
        if (r8 == 0) goto L_0x01e1;
    L_0x00e6:
        r6 = r5 & 15;
        r5 = r4;
        r4 = r3;
    L_0x00ea:
        if (r4 < r6) goto L_0x0163;
    L_0x00ec:
        r2 = r2 + 2;
        r2 = r22[r2];
        r3 = Ws;
        r3 = r3[r6];
        r3 = r3 & r5;
        r2 = r2 + r3;
        r12 = r5 >> r6;
        r11 = r4 - r6;
        r8 = r14 - r13;
        if (r7 < r2) goto L_0x0189;
    L_0x00fe:
        r2 = r7 - r2;
        r3 = r7 - r2;
        if (r3 <= 0) goto L_0x0176;
    L_0x0104:
        r3 = 2;
        r4 = r7 - r2;
        if (r3 <= r4) goto L_0x0176;
    L_0x0109:
        r0 = r24;
        r3 = r0.j3;
        r5 = r7 + 1;
        r0 = r24;
        r4 = r0.j3;
        r6 = r2 + 1;
        r2 = r4[r2];
        r3[r7] = r2;
        r0 = r24;
        r3 = r0.j3;
        r4 = r5 + 1;
        r0 = r24;
        r7 = r0.j3;
        r2 = r6 + 1;
        r6 = r7[r6];
        r3[r5] = r6;
        r3 = r13 + -2;
    L_0x012b:
        r5 = r4 - r2;
        if (r5 <= 0) goto L_0x01cc;
    L_0x012f:
        r5 = r4 - r2;
        if (r3 <= r5) goto L_0x01cc;
    L_0x0133:
        r5 = r4;
        r4 = r3;
    L_0x0135:
        r0 = r24;
        r7 = r0.j3;
        r6 = r5 + 1;
        r0 = r24;
        r13 = r0.j3;
        r3 = r2 + 1;
        r2 = r13[r2];
        r7[r5] = r2;
        r2 = r4 + -1;
        if (r2 != 0) goto L_0x02f8;
    L_0x0149:
        r2 = r8;
        r3 = r9;
        r4 = r10;
        r5 = r11;
        r7 = r12;
        goto L_0x0055;
    L_0x0150:
        r9 = r9 + -1;
        r0 = r25;
        r5 = r0.j6;
        r2 = r10 + 1;
        r5 = r5[r10];
        r5 = r5 & 255;
        r5 = r5 << r3;
        r4 = r4 | r5;
        r3 = r3 + 8;
        r10 = r2;
        goto L_0x00cc;
    L_0x0163:
        r9 = r9 + -1;
        r0 = r25;
        r8 = r0.j6;
        r3 = r10 + 1;
        r8 = r8[r10];
        r8 = r8 & 255;
        r8 = r8 << r4;
        r5 = r5 | r8;
        r4 = r4 + 8;
        r10 = r3;
        goto L_0x00ea;
    L_0x0176:
        r0 = r24;
        r3 = r0.j3;
        r0 = r24;
        r4 = r0.j3;
        r5 = 2;
        java.lang.System.arraycopy(r3, r2, r4, r7, r5);
        r4 = r7 + 2;
        r2 = r2 + 2;
        r3 = r13 + -2;
        goto L_0x012b;
    L_0x0189:
        r2 = r7 - r2;
    L_0x018b:
        r0 = r24;
        r3 = r0.Mr;
        r2 = r2 + r3;
        if (r2 < 0) goto L_0x018b;
    L_0x0192:
        r0 = r24;
        r3 = r0.Mr;
        r3 = r3 - r2;
        if (r13 <= r3) goto L_0x0302;
    L_0x0199:
        r13 = r13 - r3;
        r4 = r7 - r2;
        if (r4 <= 0) goto L_0x01bd;
    L_0x019e:
        r4 = r7 - r2;
        if (r3 <= r4) goto L_0x01bd;
    L_0x01a2:
        r4 = r7;
        r6 = r3;
    L_0x01a4:
        r0 = r24;
        r7 = r0.j3;
        r5 = r4 + 1;
        r0 = r24;
        r14 = r0.j3;
        r3 = r2 + 1;
        r2 = r14[r2];
        r7[r4] = r2;
        r2 = r6 + -1;
        if (r2 != 0) goto L_0x02fd;
    L_0x01b8:
        r2 = 0;
        r3 = r13;
        r4 = r5;
        goto L_0x012b;
    L_0x01bd:
        r0 = r24;
        r4 = r0.j3;
        r0 = r24;
        r5 = r0.j3;
        java.lang.System.arraycopy(r4, r2, r5, r7, r3);
        r5 = r7 + r3;
        r2 = r2 + r3;
        goto L_0x01b8;
    L_0x01cc:
        r0 = r24;
        r5 = r0.j3;
        r0 = r24;
        r6 = r0.j3;
        java.lang.System.arraycopy(r5, r2, r6, r4, r3);
        r6 = r4 + r3;
        r2 = r2 + r3;
        r2 = r8;
        r3 = r9;
        r4 = r10;
        r5 = r11;
        r7 = r12;
        goto L_0x0055;
    L_0x01e1:
        r8 = r5 & 64;
        if (r8 != 0) goto L_0x01f9;
    L_0x01e5:
        r2 = r2 + 2;
        r2 = r22[r2];
        r2 = r2 + r6;
        r6 = Ws;
        r5 = r6[r5];
        r5 = r5 & r4;
        r6 = r2 + r5;
        r2 = r23 + r6;
        r2 = r2 * 3;
        r5 = r22[r2];
        goto L_0x00d8;
    L_0x01f9:
        r2 = "invalid distance code";
        r0 = r25;
        r0.u7 = r2;
        r0 = r25;
        r2 = r0.FH;
        r2 = r2 - r9;
        r5 = r3 >> 3;
        if (r5 >= r2) goto L_0x020b;
    L_0x0209:
        r2 = r3 >> 3;
    L_0x020b:
        r5 = r9 + r2;
        r6 = r10 - r2;
        r2 = r2 << 3;
        r2 = r3 - r2;
        r0 = r24;
        r0.XL = r4;
        r0 = r24;
        r0.QX = r2;
        r0 = r25;
        r0.FH = r5;
        r0 = r25;
        r2 = r0.Hw;
        r0 = r25;
        r4 = r0.DW;
        r4 = r6 - r4;
        r4 = (long) r4;
        r2 = r2 + r4;
        r0 = r25;
        r0.Hw = r2;
        r0 = r25;
        r0.DW = r6;
        r0 = r24;
        r0.a8 = r7;
        r2 = -3;
        goto L_0x0093;
    L_0x023a:
        r10 = r5 & 64;
        if (r10 != 0) goto L_0x0271;
    L_0x023e:
        r2 = r2 + 2;
        r2 = r20[r2];
        r2 = r2 + r6;
        r6 = Ws;
        r5 = r6[r5];
        r5 = r5 & r4;
        r6 = r2 + r5;
        r2 = r21 + r6;
        r2 = r2 * 3;
        r5 = r20[r2];
        if (r5 != 0) goto L_0x00ad;
    L_0x0252:
        r5 = r2 + 1;
        r5 = r20[r5];
        r4 = r4 >> r5;
        r5 = r2 + 1;
        r5 = r20[r5];
        r3 = r3 - r5;
        r0 = r24;
        r5 = r0.j3;
        r6 = r7 + 1;
        r2 = r2 + 2;
        r2 = r20[r2];
        r2 = (byte) r2;
        r5[r7] = r2;
        r2 = r14 + -1;
        r5 = r3;
        r7 = r4;
        r3 = r8;
        r4 = r9;
        goto L_0x0055;
    L_0x0271:
        r2 = r5 & 32;
        if (r2 == 0) goto L_0x02af;
    L_0x0275:
        r0 = r25;
        r2 = r0.FH;
        r2 = r2 - r8;
        r5 = r3 >> 3;
        if (r5 >= r2) goto L_0x0280;
    L_0x027e:
        r2 = r3 >> 3;
    L_0x0280:
        r5 = r8 + r2;
        r6 = r9 - r2;
        r2 = r2 << 3;
        r2 = r3 - r2;
        r0 = r24;
        r0.XL = r4;
        r0 = r24;
        r0.QX = r2;
        r0 = r25;
        r0.FH = r5;
        r0 = r25;
        r2 = r0.Hw;
        r0 = r25;
        r4 = r0.DW;
        r4 = r6 - r4;
        r4 = (long) r4;
        r2 = r2 + r4;
        r0 = r25;
        r0.Hw = r2;
        r0 = r25;
        r0.DW = r6;
        r0 = r24;
        r0.a8 = r7;
        r2 = 1;
        goto L_0x0093;
    L_0x02af:
        r2 = "invalid literal/length code";
        r0 = r25;
        r0.u7 = r2;
        r0 = r25;
        r2 = r0.FH;
        r2 = r2 - r8;
        r5 = r3 >> 3;
        if (r5 >= r2) goto L_0x02c1;
    L_0x02bf:
        r2 = r3 >> 3;
    L_0x02c1:
        r5 = r8 + r2;
        r6 = r9 - r2;
        r2 = r2 << 3;
        r2 = r3 - r2;
        r0 = r24;
        r0.XL = r4;
        r0 = r24;
        r0.QX = r2;
        r0 = r25;
        r0.FH = r5;
        r0 = r25;
        r2 = r0.Hw;
        r0 = r25;
        r4 = r0.DW;
        r4 = r6 - r4;
        r4 = (long) r4;
        r2 = r2 + r4;
        r0 = r25;
        r0.Hw = r2;
        r0 = r25;
        r0.DW = r6;
        r0 = r24;
        r0.a8 = r7;
        r2 = -3;
        goto L_0x0093;
    L_0x02f0:
        r14 = r2;
        r8 = r3;
        r9 = r4;
        r3 = r5;
        r4 = r7;
        r7 = r6;
        goto L_0x002a;
    L_0x02f8:
        r4 = r2;
        r5 = r6;
        r2 = r3;
        goto L_0x0135;
    L_0x02fd:
        r4 = r5;
        r6 = r2;
        r2 = r3;
        goto L_0x01a4;
    L_0x0302:
        r3 = r13;
        r4 = r7;
        goto L_0x012b;
        */
        throw new UnsupportedOperationException("Method not decompiled: ags.j6(int, int, int[], int, int[], int, agr, agx):int");
    }
}
