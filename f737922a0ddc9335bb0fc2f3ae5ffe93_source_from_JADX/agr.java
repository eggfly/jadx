final class agr {
    static final int[] j6;
    private static final int[] lg;
    int DW;
    int[][] EQ;
    int FH;
    int Hw;
    int[] J0;
    int[] J8;
    int Mr;
    int QX;
    int U2;
    int[] VH;
    int Ws;
    int XL;
    int[] Zo;
    int a8;
    int[] aM;
    private boolean er;
    private final agx gW;
    int[] gn;
    byte[] j3;
    private final ags rN;
    int[] tp;
    int[] u7;
    int v5;
    int[][] we;
    private final agt yS;

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
        lg = iArr;
        iArr = new int[19];
        iArr[0] = 16;
        iArr[1] = 17;
        iArr[2] = 18;
        iArr[4] = 8;
        iArr[5] = 7;
        iArr[6] = 9;
        iArr[7] = 6;
        iArr[8] = 10;
        iArr[9] = 5;
        iArr[10] = 11;
        iArr[11] = 4;
        iArr[12] = 12;
        iArr[13] = 3;
        iArr[14] = 13;
        iArr[15] = 2;
        iArr[16] = 14;
        iArr[17] = 1;
        iArr[18] = 15;
        j6 = iArr;
    }

    agr(agx agx, int i) {
        boolean z = true;
        this.VH = new int[1];
        this.gn = new int[1];
        this.u7 = new int[1];
        this.tp = new int[1];
        this.EQ = new int[1][];
        this.we = new int[1][];
        this.J0 = new int[1];
        this.J8 = new int[1];
        this.yS = new agt();
        this.gW = agx;
        this.rN = new ags(this.gW, this);
        this.aM = new int[4320];
        this.j3 = new byte[i];
        this.Mr = i;
        if (agx.EQ.Zo == 0) {
            z = false;
        }
        this.er = z;
        this.DW = 0;
        j6();
    }

    void j6() {
        if (this.DW != 4) {
        }
        if (this.DW == 6) {
            this.rN.j6(this.gW);
        }
        this.DW = 0;
        this.QX = 0;
        this.XL = 0;
        this.a8 = 0;
        this.U2 = 0;
        if (this.er) {
            this.gW.J0.j6();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int j6(int r18) {
        /*
        r17 = this;
        r0 = r17;
        r2 = r0.gW;
        r5 = r2.DW;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.FH;
        r0 = r17;
        r7 = r0.XL;
        r0 = r17;
        r6 = r0.QX;
        r0 = r17;
        r3 = r0.a8;
        r0 = r17;
        r2 = r0.U2;
        if (r3 >= r2) goto L_0x0062;
    L_0x001e:
        r0 = r17;
        r2 = r0.U2;
        r2 = r2 - r3;
        r2 = r2 + -1;
    L_0x0025:
        r9 = r2;
        r12 = r3;
        r2 = r4;
        r3 = r5;
    L_0x0029:
        r0 = r17;
        r4 = r0.DW;
        switch(r4) {
            case 0: goto L_0x0068;
            case 1: goto L_0x0194;
            case 2: goto L_0x023a;
            case 3: goto L_0x0362;
            case 4: goto L_0x0416;
            case 5: goto L_0x0907;
            case 6: goto L_0x090e;
            case 7: goto L_0x0915;
            case 8: goto L_0x091a;
            case 9: goto L_0x08c7;
            default: goto L_0x0030;
        };
    L_0x0030:
        r4 = -2;
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r5 = r0.gW;
        r5.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r6 = r2.Hw;
        r0 = r17;
        r5 = r0.gW;
        r5 = r5.DW;
        r5 = r3 - r5;
        r8 = (long) r5;
        r6 = r6 + r8;
        r2.Hw = r6;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r4);
    L_0x0061:
        return r2;
    L_0x0062:
        r0 = r17;
        r2 = r0.Mr;
        r2 = r2 - r3;
        goto L_0x0025;
    L_0x0068:
        r10 = r2;
        r11 = r3;
        r13 = r6;
        r14 = r7;
    L_0x006c:
        r2 = 3;
        if (r13 < r2) goto L_0x0081;
    L_0x006f:
        r2 = r14 & 7;
        r3 = r2 & 1;
        r0 = r17;
        r0.Ws = r3;
        r2 = r2 >>> 1;
        switch(r2) {
            case 0: goto L_0x00c8;
            case 1: goto L_0x00dd;
            case 2: goto L_0x0128;
            case 3: goto L_0x0137;
            default: goto L_0x007c;
        };
    L_0x007c:
        r2 = r10;
        r3 = r11;
        r6 = r13;
        r7 = r14;
        goto L_0x0029;
    L_0x0081:
        if (r10 == 0) goto L_0x0099;
    L_0x0083:
        r18 = 0;
        r10 = r10 + -1;
        r0 = r17;
        r2 = r0.gW;
        r2 = r2.j6;
        r3 = r11 + 1;
        r2 = r2[r11];
        r2 = r2 & 255;
        r2 = r2 << r13;
        r14 = r14 | r2;
        r13 = r13 + 8;
        r11 = r3;
        goto L_0x006c;
    L_0x0099:
        r0 = r17;
        r0.XL = r14;
        r0 = r17;
        r0.QX = r13;
        r0 = r17;
        r2 = r0.gW;
        r2.FH = r10;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r3 = r0.gW;
        r3 = r3.DW;
        r3 = r11 - r3;
        r6 = (long) r3;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r11;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x00c8:
        r2 = r14 >>> 3;
        r3 = r13 + -3;
        r5 = r3 & 7;
        r4 = r2 >>> r5;
        r2 = r3 - r5;
        r3 = 1;
        r0 = r17;
        r0.DW = r3;
        r3 = r11;
        r6 = r2;
        r7 = r4;
        r2 = r10;
        goto L_0x0029;
    L_0x00dd:
        r0 = r17;
        r2 = r0.u7;
        r0 = r17;
        r3 = r0.tp;
        r0 = r17;
        r4 = r0.EQ;
        r0 = r17;
        r5 = r0.we;
        r0 = r17;
        r6 = r0.gW;
        agt.j6(r2, r3, r4, r5, r6);
        r0 = r17;
        r2 = r0.rN;
        r0 = r17;
        r3 = r0.u7;
        r4 = 0;
        r3 = r3[r4];
        r0 = r17;
        r4 = r0.tp;
        r5 = 0;
        r4 = r4[r5];
        r0 = r17;
        r5 = r0.EQ;
        r6 = 0;
        r5 = r5[r6];
        r6 = 0;
        r0 = r17;
        r7 = r0.we;
        r8 = 0;
        r7 = r7[r8];
        r8 = 0;
        r2.j6(r3, r4, r5, r6, r7, r8);
        r4 = r14 >>> 3;
        r2 = r13 + -3;
        r3 = 6;
        r0 = r17;
        r0.DW = r3;
        r3 = r11;
        r6 = r2;
        r7 = r4;
        r2 = r10;
        goto L_0x0029;
    L_0x0128:
        r4 = r14 >>> 3;
        r2 = r13 + -3;
        r3 = 3;
        r0 = r17;
        r0.DW = r3;
        r3 = r11;
        r6 = r2;
        r7 = r4;
        r2 = r10;
        goto L_0x0029;
    L_0x0137:
        r2 = r14 >>> 3;
        r3 = r13 + -3;
        r4 = 9;
        r0 = r17;
        r0.DW = r4;
        r0 = r17;
        r4 = r0.gW;
        r5 = "invalid block type";
        r4.u7 = r5;
        r4 = -3;
        r0 = r17;
        r0.XL = r2;
        r0 = r17;
        r0.QX = r3;
        r0 = r17;
        r2 = r0.gW;
        r2.FH = r10;
        r0 = r17;
        r2 = r0.gW;
        r6 = r2.Hw;
        r0 = r17;
        r3 = r0.gW;
        r3 = r3.DW;
        r3 = r11 - r3;
        r8 = (long) r3;
        r6 = r6 + r8;
        r2.Hw = r6;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r11;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r4);
        goto L_0x0061;
    L_0x017d:
        if (r2 == 0) goto L_0x01e8;
    L_0x017f:
        r18 = 0;
        r2 = r2 + -1;
        r0 = r17;
        r4 = r0.gW;
        r5 = r4.j6;
        r4 = r3 + 1;
        r3 = r5[r3];
        r3 = r3 & 255;
        r3 = r3 << r6;
        r7 = r7 | r3;
        r6 = r6 + 8;
        r3 = r4;
    L_0x0194:
        r4 = 32;
        if (r6 < r4) goto L_0x017d;
    L_0x0198:
        r4 = r7 ^ -1;
        r4 = r4 >>> 16;
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r4 = r4 & r5;
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r5 = r5 & r7;
        if (r4 == r5) goto L_0x0218;
    L_0x01a6:
        r4 = 9;
        r0 = r17;
        r0.DW = r4;
        r0 = r17;
        r4 = r0.gW;
        r5 = "invalid stored block lengths";
        r4.u7 = r5;
        r4 = -3;
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r5 = r0.gW;
        r5.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r6 = r2.Hw;
        r0 = r17;
        r5 = r0.gW;
        r5 = r5.DW;
        r5 = r3 - r5;
        r8 = (long) r5;
        r6 = r6 + r8;
        r2.Hw = r6;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r4);
        goto L_0x0061;
    L_0x01e8:
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r4 = r0.gW;
        r4.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x0218:
        r4 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r4 = r4 & r7;
        r0 = r17;
        r0.FH = r4;
        r4 = 0;
        r0 = r17;
        r5 = r0.FH;
        if (r5 == 0) goto L_0x0230;
    L_0x0227:
        r5 = 2;
    L_0x0228:
        r0 = r17;
        r0.DW = r5;
        r6 = r4;
        r7 = r4;
        goto L_0x0029;
    L_0x0230:
        r0 = r17;
        r5 = r0.Ws;
        if (r5 == 0) goto L_0x0238;
    L_0x0236:
        r5 = 7;
        goto L_0x0228;
    L_0x0238:
        r5 = 0;
        goto L_0x0228;
    L_0x023a:
        if (r2 != 0) goto L_0x026c;
    L_0x023c:
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r4 = r0.gW;
        r4.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x026c:
        if (r9 != 0) goto L_0x0305;
    L_0x026e:
        r0 = r17;
        r4 = r0.Mr;
        if (r12 != r4) goto L_0x0289;
    L_0x0274:
        r0 = r17;
        r4 = r0.U2;
        if (r4 == 0) goto L_0x0289;
    L_0x027a:
        r12 = 0;
        r0 = r17;
        r4 = r0.U2;
        if (r12 >= r4) goto L_0x02f3;
    L_0x0281:
        r0 = r17;
        r4 = r0.U2;
        r4 = r4 - r12;
        r4 = r4 + -1;
    L_0x0288:
        r9 = r4;
    L_0x0289:
        if (r9 != 0) goto L_0x0305;
    L_0x028b:
        r0 = r17;
        r0.a8 = r12;
        r5 = r17.DW(r18);
        r0 = r17;
        r12 = r0.a8;
        r0 = r17;
        r4 = r0.U2;
        if (r12 >= r4) goto L_0x02f9;
    L_0x029d:
        r0 = r17;
        r4 = r0.U2;
        r4 = r4 - r12;
        r4 = r4 + -1;
    L_0x02a4:
        r0 = r17;
        r8 = r0.Mr;
        if (r12 != r8) goto L_0x0904;
    L_0x02aa:
        r0 = r17;
        r8 = r0.U2;
        if (r8 == 0) goto L_0x0904;
    L_0x02b0:
        r12 = 0;
        r0 = r17;
        r4 = r0.U2;
        if (r12 >= r4) goto L_0x02ff;
    L_0x02b7:
        r0 = r17;
        r4 = r0.U2;
        r4 = r4 - r12;
        r4 = r4 + -1;
    L_0x02be:
        r9 = r4;
    L_0x02bf:
        if (r9 != 0) goto L_0x0305;
    L_0x02c1:
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r4 = r0.gW;
        r4.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r6 = r2.Hw;
        r0 = r17;
        r4 = r0.gW;
        r4 = r4.DW;
        r4 = r3 - r4;
        r8 = (long) r4;
        r6 = r6 + r8;
        r2.Hw = r6;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r5);
        goto L_0x0061;
    L_0x02f3:
        r0 = r17;
        r4 = r0.Mr;
        r4 = r4 - r12;
        goto L_0x0288;
    L_0x02f9:
        r0 = r17;
        r4 = r0.Mr;
        r4 = r4 - r12;
        goto L_0x02a4;
    L_0x02ff:
        r0 = r17;
        r4 = r0.Mr;
        r4 = r4 - r12;
        goto L_0x02be;
    L_0x0305:
        r18 = 0;
        r0 = r17;
        r4 = r0.FH;
        if (r4 <= r2) goto L_0x030e;
    L_0x030d:
        r4 = r2;
    L_0x030e:
        if (r4 <= r9) goto L_0x0901;
    L_0x0310:
        r8 = r9;
    L_0x0311:
        r0 = r17;
        r4 = r0.gW;
        r4 = r4.j6;
        r0 = r17;
        r5 = r0.j3;
        java.lang.System.arraycopy(r4, r3, r5, r12, r8);
        r5 = r3 + r8;
        r4 = r2 - r8;
        r3 = r12 + r8;
        r2 = r9 - r8;
        r0 = r17;
        r9 = r0.FH;
        r8 = r9 - r8;
        r0 = r17;
        r0.FH = r8;
        if (r8 == 0) goto L_0x0338;
    L_0x0332:
        r9 = r2;
        r12 = r3;
        r2 = r4;
        r3 = r5;
        goto L_0x0029;
    L_0x0338:
        r0 = r17;
        r8 = r0.Ws;
        if (r8 == 0) goto L_0x0349;
    L_0x033e:
        r8 = 7;
    L_0x033f:
        r0 = r17;
        r0.DW = r8;
        r9 = r2;
        r12 = r3;
        r2 = r4;
        r3 = r5;
        goto L_0x0029;
    L_0x0349:
        r8 = 0;
        goto L_0x033f;
    L_0x034b:
        if (r2 == 0) goto L_0x03bc;
    L_0x034d:
        r18 = 0;
        r2 = r2 + -1;
        r0 = r17;
        r4 = r0.gW;
        r5 = r4.j6;
        r4 = r3 + 1;
        r3 = r5[r3];
        r3 = r3 & 255;
        r3 = r3 << r6;
        r7 = r7 | r3;
        r6 = r6 + 8;
        r3 = r4;
    L_0x0362:
        r4 = 14;
        if (r6 < r4) goto L_0x034b;
    L_0x0366:
        r4 = r7 & 16383;
        r0 = r17;
        r0.Hw = r4;
        r5 = r4 & 31;
        r8 = 29;
        if (r5 > r8) goto L_0x037a;
    L_0x0372:
        r5 = r4 >> 5;
        r5 = r5 & 31;
        r8 = 29;
        if (r5 <= r8) goto L_0x03ec;
    L_0x037a:
        r4 = 9;
        r0 = r17;
        r0.DW = r4;
        r0 = r17;
        r4 = r0.gW;
        r5 = "too many length or distance symbols";
        r4.u7 = r5;
        r4 = -3;
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r5 = r0.gW;
        r5.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r6 = r2.Hw;
        r0 = r17;
        r5 = r0.gW;
        r5 = r5.DW;
        r5 = r3 - r5;
        r8 = (long) r5;
        r6 = r6 + r8;
        r2.Hw = r6;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r4);
        goto L_0x0061;
    L_0x03bc:
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r4 = r0.gW;
        r4.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x03ec:
        r5 = r4 & 31;
        r5 = r5 + 258;
        r4 = r4 >> 5;
        r4 = r4 & 31;
        r5 = r5 + r4;
        r0 = r17;
        r4 = r0.Zo;
        if (r4 == 0) goto L_0x0402;
    L_0x03fb:
        r0 = r17;
        r4 = r0.Zo;
        r4 = r4.length;
        if (r4 >= r5) goto L_0x0496;
    L_0x0402:
        r4 = new int[r5];
        r0 = r17;
        r0.Zo = r4;
    L_0x0408:
        r7 = r7 >>> 14;
        r6 = r6 + -14;
        r4 = 0;
        r0 = r17;
        r0.v5 = r4;
        r4 = 4;
        r0 = r17;
        r0.DW = r4;
    L_0x0416:
        r8 = r2;
        r9 = r3;
        r10 = r6;
        r11 = r7;
    L_0x041a:
        r0 = r17;
        r2 = r0.v5;
        r0 = r17;
        r3 = r0.Hw;
        r3 = r3 >>> 10;
        r3 = r3 + 4;
        if (r2 < r3) goto L_0x08fd;
    L_0x0428:
        r0 = r17;
        r2 = r0.v5;
        r3 = 19;
        if (r2 < r3) goto L_0x050d;
    L_0x0430:
        r0 = r17;
        r2 = r0.VH;
        r3 = 0;
        r4 = 7;
        r2[r3] = r4;
        r0 = r17;
        r2 = r0.yS;
        r0 = r17;
        r3 = r0.Zo;
        r0 = r17;
        r4 = r0.VH;
        r0 = r17;
        r5 = r0.gn;
        r0 = r17;
        r6 = r0.aM;
        r0 = r17;
        r7 = r0.gW;
        r2 = r2.j6(r3, r4, r5, r6, r7);
        if (r2 == 0) goto L_0x0524;
    L_0x0456:
        r3 = -3;
        if (r2 != r3) goto L_0x0464;
    L_0x0459:
        r3 = 0;
        r0 = r17;
        r0.Zo = r3;
        r3 = 9;
        r0 = r17;
        r0.DW = r3;
    L_0x0464:
        r0 = r17;
        r0.XL = r11;
        r0 = r17;
        r0.QX = r10;
        r0 = r17;
        r3 = r0.gW;
        r3.FH = r8;
        r0 = r17;
        r3 = r0.gW;
        r4 = r3.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r9 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r3.Hw = r4;
        r0 = r17;
        r3 = r0.gW;
        r3.DW = r9;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r2);
        goto L_0x0061;
    L_0x0496:
        r4 = 0;
    L_0x0497:
        if (r4 >= r5) goto L_0x0408;
    L_0x0499:
        r0 = r17;
        r8 = r0.Zo;
        r9 = 0;
        r8[r4] = r9;
        r4 = r4 + 1;
        goto L_0x0497;
    L_0x04a3:
        if (r2 == 0) goto L_0x04dd;
    L_0x04a5:
        r18 = 0;
        r2 = r2 + -1;
        r0 = r17;
        r4 = r0.gW;
        r4 = r4.j6;
        r9 = r3 + 1;
        r3 = r4[r3];
        r3 = r3 & 255;
        r3 = r3 << r10;
        r11 = r11 | r3;
        r10 = r10 + 8;
        r3 = r9;
    L_0x04ba:
        r4 = 3;
        if (r10 < r4) goto L_0x04a3;
    L_0x04bd:
        r0 = r17;
        r4 = r0.Zo;
        r5 = j6;
        r0 = r17;
        r6 = r0.v5;
        r7 = r6 + 1;
        r0 = r17;
        r0.v5 = r7;
        r5 = r5[r6];
        r6 = r11 & 7;
        r4[r5] = r6;
        r7 = r11 >>> 3;
        r6 = r10 + -3;
        r8 = r2;
        r9 = r3;
        r10 = r6;
        r11 = r7;
        goto L_0x041a;
    L_0x04dd:
        r0 = r17;
        r0.XL = r11;
        r0 = r17;
        r0.QX = r10;
        r0 = r17;
        r4 = r0.gW;
        r4.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r3 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x050d:
        r0 = r17;
        r2 = r0.Zo;
        r3 = j6;
        r0 = r17;
        r4 = r0.v5;
        r5 = r4 + 1;
        r0 = r17;
        r0.v5 = r5;
        r3 = r3[r4];
        r4 = 0;
        r2[r3] = r4;
        goto L_0x0428;
    L_0x0524:
        r2 = 0;
        r0 = r17;
        r0.v5 = r2;
        r2 = 5;
        r0 = r17;
        r0.DW = r2;
        r13 = r8;
        r14 = r9;
        r15 = r10;
        r16 = r11;
    L_0x0533:
        r0 = r17;
        r2 = r0.Hw;
        r0 = r17;
        r3 = r0.v5;
        r4 = r2 & 31;
        r4 = r4 + 258;
        r2 = r2 >> 5;
        r2 = r2 & 31;
        r2 = r2 + r4;
        if (r3 < r2) goto L_0x05d5;
    L_0x0546:
        r0 = r17;
        r2 = r0.gn;
        r3 = 0;
        r4 = -1;
        r2[r3] = r4;
        r0 = r17;
        r2 = r0.u7;
        r3 = 0;
        r4 = 9;
        r2[r3] = r4;
        r0 = r17;
        r2 = r0.tp;
        r3 = 0;
        r4 = 6;
        r2[r3] = r4;
        r0 = r17;
        r4 = r0.Hw;
        r0 = r17;
        r2 = r0.yS;
        r3 = r4 & 31;
        r3 = r3 + 257;
        r4 = r4 >> 5;
        r4 = r4 & 31;
        r4 = r4 + 1;
        r0 = r17;
        r5 = r0.Zo;
        r0 = r17;
        r6 = r0.u7;
        r0 = r17;
        r7 = r0.tp;
        r0 = r17;
        r8 = r0.J0;
        r0 = r17;
        r9 = r0.J8;
        r0 = r17;
        r10 = r0.aM;
        r0 = r17;
        r11 = r0.gW;
        r2 = r2.j6(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        if (r2 == 0) goto L_0x0774;
    L_0x0593:
        r3 = -3;
        if (r2 != r3) goto L_0x05a1;
    L_0x0596:
        r3 = 0;
        r0 = r17;
        r0.Zo = r3;
        r3 = 9;
        r0 = r17;
        r0.DW = r3;
    L_0x05a1:
        r0 = r16;
        r1 = r17;
        r1.XL = r0;
        r0 = r17;
        r0.QX = r15;
        r0 = r17;
        r3 = r0.gW;
        r3.FH = r13;
        r0 = r17;
        r3 = r0.gW;
        r4 = r3.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r14 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r3.Hw = r4;
        r0 = r17;
        r3 = r0.gW;
        r3.DW = r14;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r2);
        goto L_0x0061;
    L_0x05d5:
        r0 = r17;
        r2 = r0.VH;
        r3 = 0;
        r2 = r2[r3];
        r8 = r13;
        r9 = r14;
        r3 = r15;
        r4 = r16;
    L_0x05e1:
        if (r3 < r2) goto L_0x0637;
    L_0x05e3:
        r0 = r17;
        r5 = r0.gn;
        r6 = 0;
        r5 = r5[r6];
        r0 = r17;
        r5 = r0.aM;
        r0 = r17;
        r6 = r0.gn;
        r7 = 0;
        r6 = r6[r7];
        r7 = lg;
        r2 = r7[r2];
        r2 = r2 & r4;
        r2 = r2 + r6;
        r2 = r2 * 3;
        r2 = r2 + 1;
        r7 = r5[r2];
        r0 = r17;
        r2 = r0.aM;
        r0 = r17;
        r5 = r0.gn;
        r6 = 0;
        r5 = r5[r6];
        r6 = lg;
        r6 = r6[r7];
        r6 = r6 & r4;
        r5 = r5 + r6;
        r5 = r5 * 3;
        r5 = r5 + 2;
        r13 = r2[r5];
        r2 = 16;
        if (r13 >= r2) goto L_0x067f;
    L_0x061c:
        r11 = r4 >>> r7;
        r10 = r3 - r7;
        r0 = r17;
        r2 = r0.Zo;
        r0 = r17;
        r3 = r0.v5;
        r4 = r3 + 1;
        r0 = r17;
        r0.v5 = r4;
        r2[r3] = r13;
        r13 = r8;
        r14 = r9;
        r15 = r10;
        r16 = r11;
        goto L_0x0533;
    L_0x0637:
        if (r8 == 0) goto L_0x064f;
    L_0x0639:
        r18 = 0;
        r8 = r8 + -1;
        r0 = r17;
        r5 = r0.gW;
        r5 = r5.j6;
        r14 = r9 + 1;
        r5 = r5[r9];
        r5 = r5 & 255;
        r5 = r5 << r3;
        r4 = r4 | r5;
        r3 = r3 + 8;
        r9 = r14;
        goto L_0x05e1;
    L_0x064f:
        r0 = r17;
        r0.XL = r4;
        r0 = r17;
        r0.QX = r3;
        r0 = r17;
        r2 = r0.gW;
        r2.FH = r8;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r3 = r0.gW;
        r3 = r3.DW;
        r3 = r9 - r3;
        r6 = (long) r3;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r9;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x067f:
        r2 = 18;
        if (r13 != r2) goto L_0x0700;
    L_0x0683:
        r2 = 7;
        r6 = r2;
    L_0x0685:
        r2 = 18;
        if (r13 != r2) goto L_0x0704;
    L_0x0689:
        r2 = 11;
    L_0x068b:
        r5 = r4;
        r4 = r3;
    L_0x068d:
        r3 = r7 + r6;
        if (r4 < r3) goto L_0x0706;
    L_0x0691:
        r5 = r5 >>> r7;
        r4 = r4 - r7;
        r3 = lg;
        r3 = r3[r6];
        r3 = r3 & r5;
        r3 = r3 + r2;
        r11 = r5 >>> r6;
        r10 = r4 - r6;
        r0 = r17;
        r4 = r0.v5;
        r0 = r17;
        r2 = r0.Hw;
        r5 = r4 + r3;
        r6 = r2 & 31;
        r6 = r6 + 258;
        r2 = r2 >> 5;
        r2 = r2 & 31;
        r2 = r2 + r6;
        if (r5 > r2) goto L_0x06b9;
    L_0x06b2:
        r2 = 16;
        if (r13 != r2) goto L_0x074f;
    L_0x06b6:
        r2 = 1;
        if (r4 >= r2) goto L_0x074f;
    L_0x06b9:
        r2 = 0;
        r0 = r17;
        r0.Zo = r2;
        r2 = 9;
        r0 = r17;
        r0.DW = r2;
        r0 = r17;
        r2 = r0.gW;
        r3 = "invalid bit length repeat";
        r2.u7 = r3;
        r2 = -3;
        r0 = r17;
        r0.XL = r11;
        r0 = r17;
        r0.QX = r10;
        r0 = r17;
        r3 = r0.gW;
        r3.FH = r8;
        r0 = r17;
        r3 = r0.gW;
        r4 = r3.Hw;
        r0 = r17;
        r6 = r0.gW;
        r6 = r6.DW;
        r6 = r9 - r6;
        r6 = (long) r6;
        r4 = r4 + r6;
        r3.Hw = r4;
        r0 = r17;
        r3 = r0.gW;
        r3.DW = r9;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r2);
        goto L_0x0061;
    L_0x0700:
        r2 = r13 + -14;
        r6 = r2;
        goto L_0x0685;
    L_0x0704:
        r2 = 3;
        goto L_0x068b;
    L_0x0706:
        if (r8 == 0) goto L_0x071f;
    L_0x0708:
        r18 = 0;
        r8 = r8 + -1;
        r0 = r17;
        r3 = r0.gW;
        r10 = r3.j6;
        r3 = r9 + 1;
        r9 = r10[r9];
        r9 = r9 & 255;
        r9 = r9 << r4;
        r5 = r5 | r9;
        r4 = r4 + 8;
        r9 = r3;
        goto L_0x068d;
    L_0x071f:
        r0 = r17;
        r0.XL = r5;
        r0 = r17;
        r0.QX = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.FH = r8;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r3 = r0.gW;
        r3 = r3.DW;
        r3 = r9 - r3;
        r6 = (long) r3;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r9;
        r0 = r17;
        r0.a8 = r12;
        r2 = r17.DW(r18);
        goto L_0x0061;
    L_0x074f:
        r2 = 16;
        if (r13 != r2) goto L_0x0772;
    L_0x0753:
        r0 = r17;
        r2 = r0.Zo;
        r5 = r4 + -1;
        r2 = r2[r5];
    L_0x075b:
        r0 = r17;
        r6 = r0.Zo;
        r5 = r4 + 1;
        r6[r4] = r2;
        r3 = r3 + -1;
        if (r3 != 0) goto L_0x08fa;
    L_0x0767:
        r0 = r17;
        r0.v5 = r5;
        r13 = r8;
        r14 = r9;
        r15 = r10;
        r16 = r11;
        goto L_0x0533;
    L_0x0772:
        r2 = 0;
        goto L_0x075b;
    L_0x0774:
        r0 = r17;
        r2 = r0.rN;
        r0 = r17;
        r3 = r0.u7;
        r4 = 0;
        r3 = r3[r4];
        r0 = r17;
        r4 = r0.tp;
        r5 = 0;
        r4 = r4[r5];
        r0 = r17;
        r5 = r0.aM;
        r0 = r17;
        r6 = r0.J0;
        r7 = 0;
        r6 = r6[r7];
        r0 = r17;
        r7 = r0.aM;
        r0 = r17;
        r8 = r0.J8;
        r9 = 0;
        r8 = r8[r9];
        r2.j6(r3, r4, r5, r6, r7, r8);
        r2 = 6;
        r0 = r17;
        r0.DW = r2;
    L_0x07a4:
        r0 = r16;
        r1 = r17;
        r1.XL = r0;
        r0 = r17;
        r0.QX = r15;
        r0 = r17;
        r2 = r0.gW;
        r2.FH = r13;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.Hw;
        r0 = r17;
        r3 = r0.gW;
        r3 = r3.DW;
        r3 = r14 - r3;
        r6 = (long) r3;
        r4 = r4 + r6;
        r2.Hw = r4;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r14;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.rN;
        r0 = r18;
        r2 = r2.j6(r0);
        r3 = 1;
        if (r2 == r3) goto L_0x07e5;
    L_0x07dd:
        r0 = r17;
        r2 = r0.DW(r2);
        goto L_0x0061;
    L_0x07e5:
        r18 = 0;
        r0 = r17;
        r2 = r0.rN;
        r0 = r17;
        r3 = r0.gW;
        r2.j6(r3);
        r0 = r17;
        r2 = r0.gW;
        r5 = r2.DW;
        r0 = r17;
        r2 = r0.gW;
        r4 = r2.FH;
        r0 = r17;
        r7 = r0.XL;
        r0 = r17;
        r6 = r0.QX;
        r0 = r17;
        r3 = r0.a8;
        r0 = r17;
        r2 = r0.U2;
        if (r3 >= r2) goto L_0x0828;
    L_0x0810:
        r0 = r17;
        r2 = r0.U2;
        r2 = r2 - r3;
        r2 = r2 + -1;
    L_0x0817:
        r0 = r17;
        r8 = r0.Ws;
        if (r8 != 0) goto L_0x082e;
    L_0x081d:
        r8 = 0;
        r0 = r17;
        r0.DW = r8;
        r9 = r2;
        r12 = r3;
        r2 = r4;
        r3 = r5;
        goto L_0x0029;
    L_0x0828:
        r0 = r17;
        r2 = r0.Mr;
        r2 = r2 - r3;
        goto L_0x0817;
    L_0x082e:
        r2 = 7;
        r0 = r17;
        r0.DW = r2;
    L_0x0833:
        r0 = r17;
        r0.a8 = r3;
        r2 = r17.DW(r18);
        r0 = r17;
        r12 = r0.a8;
        r0 = r17;
        r3 = r0.U2;
        if (r12 >= r3) goto L_0x0888;
    L_0x0845:
        r0 = r17;
        r3 = r0.U2;
        r3 = r3 - r12;
        r3 = r3 + -1;
    L_0x084c:
        r0 = r17;
        r3 = r0.U2;
        r0 = r17;
        r8 = r0.a8;
        if (r3 == r8) goto L_0x088e;
    L_0x0856:
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r3 = r0.gW;
        r3.FH = r4;
        r0 = r17;
        r3 = r0.gW;
        r6 = r3.Hw;
        r0 = r17;
        r4 = r0.gW;
        r4 = r4.DW;
        r4 = r5 - r4;
        r8 = (long) r4;
        r6 = r6 + r8;
        r3.Hw = r6;
        r0 = r17;
        r3 = r0.gW;
        r3.DW = r5;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r2);
        goto L_0x0061;
    L_0x0888:
        r0 = r17;
        r3 = r0.Mr;
        r3 = r3 - r12;
        goto L_0x084c;
    L_0x088e:
        r2 = 8;
        r0 = r17;
        r0.DW = r2;
    L_0x0894:
        r2 = 1;
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r3 = r0.gW;
        r3.FH = r4;
        r0 = r17;
        r3 = r0.gW;
        r6 = r3.Hw;
        r0 = r17;
        r4 = r0.gW;
        r4 = r4.DW;
        r4 = r5 - r4;
        r8 = (long) r4;
        r6 = r6 + r8;
        r3.Hw = r6;
        r0 = r17;
        r3 = r0.gW;
        r3.DW = r5;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r2);
        goto L_0x0061;
    L_0x08c7:
        r4 = -3;
        r0 = r17;
        r0.XL = r7;
        r0 = r17;
        r0.QX = r6;
        r0 = r17;
        r5 = r0.gW;
        r5.FH = r2;
        r0 = r17;
        r2 = r0.gW;
        r6 = r2.Hw;
        r0 = r17;
        r5 = r0.gW;
        r5 = r5.DW;
        r5 = r3 - r5;
        r8 = (long) r5;
        r6 = r6 + r8;
        r2.Hw = r6;
        r0 = r17;
        r2 = r0.gW;
        r2.DW = r3;
        r0 = r17;
        r0.a8 = r12;
        r0 = r17;
        r2 = r0.DW(r4);
        goto L_0x0061;
    L_0x08fa:
        r4 = r5;
        goto L_0x075b;
    L_0x08fd:
        r2 = r8;
        r3 = r9;
        goto L_0x04ba;
    L_0x0901:
        r8 = r4;
        goto L_0x0311;
    L_0x0904:
        r9 = r4;
        goto L_0x02bf;
    L_0x0907:
        r13 = r2;
        r14 = r3;
        r15 = r6;
        r16 = r7;
        goto L_0x0533;
    L_0x090e:
        r13 = r2;
        r14 = r3;
        r15 = r6;
        r16 = r7;
        goto L_0x07a4;
    L_0x0915:
        r4 = r2;
        r5 = r3;
        r3 = r12;
        goto L_0x0833;
    L_0x091a:
        r4 = r2;
        r5 = r3;
        goto L_0x0894;
        */
        throw new UnsupportedOperationException("Method not decompiled: agr.j6(int):int");
    }

    void DW() {
        j6();
        this.j3 = null;
        this.aM = null;
    }

    int DW(int i) {
        int i2;
        int i3 = this.gW.Zo;
        int i4 = this.U2;
        int i5 = (i4 <= this.a8 ? this.a8 : this.Mr) - i4;
        if (i5 > this.gW.VH) {
            i5 = this.gW.VH;
        }
        if (i5 != 0 && i == -5) {
            i = 0;
        }
        agx agx = this.gW;
        agx.VH -= i5;
        agx = this.gW;
        agx.gn += (long) i5;
        if (this.er && i5 > 0) {
            this.gW.J0.j6(this.j3, i4, i5);
        }
        System.arraycopy(this.j3, i4, this.gW.v5, i3, i5);
        i3 += i5;
        i5 += i4;
        if (i5 == this.Mr) {
            if (this.a8 == this.Mr) {
                this.a8 = 0;
            }
            i5 = this.a8 - 0;
            if (i5 > this.gW.VH) {
                i5 = this.gW.VH;
            }
            if (i5 != 0 && r12 == -5) {
                i = 0;
            }
            agx agx2 = this.gW;
            agx2.VH -= i5;
            agx2 = this.gW;
            agx2.gn += (long) i5;
            if (this.er && i5 > 0) {
                this.gW.J0.j6(this.j3, 0, i5);
            }
            System.arraycopy(this.j3, 0, this.gW.v5, i3, i5);
            i3 += i5;
            i5 += 0;
            i2 = i3;
        } else {
            i2 = i3;
        }
        this.gW.Zo = i2;
        this.U2 = i5;
        return i;
    }
}
