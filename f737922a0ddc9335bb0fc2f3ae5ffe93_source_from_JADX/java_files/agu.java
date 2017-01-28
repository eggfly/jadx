import java.io.ByteArrayOutputStream;

final class agu {
    private static byte[] J8;
    int DW;
    private int EQ;
    long FH;
    long Hw;
    private byte[] J0;
    int VH;
    private ByteArrayOutputStream Ws;
    int Zo;
    agr gn;
    int j6;
    private final agx tp;
    agq u7;
    int v5;
    private int we;

    int j6() {
        if (this.tp == null) {
            return -2;
        }
        agx agx = this.tp;
        this.tp.gn = 0;
        agx.Hw = 0;
        this.tp.u7 = null;
        this.j6 = 14;
        this.we = -1;
        this.gn.j6();
        return 0;
    }

    int DW() {
        if (this.gn != null) {
            this.gn.DW();
        }
        return 0;
    }

    agu(agx agx) {
        this.FH = -1;
        this.we = -1;
        this.J0 = new byte[4];
        this.u7 = null;
        this.Ws = null;
        this.tp = agx;
    }

    int j6(int i) {
        this.tp.u7 = null;
        this.gn = null;
        this.Zo = 0;
        if (i < 0) {
            i = -i;
        } else if ((1073741824 & i) != 0) {
            this.Zo = 4;
            i &= -1073741825;
            if (i < 48) {
                i &= 15;
            }
        } else if ((i & -32) != 0) {
            this.Zo = 4;
            i &= 15;
        } else {
            this.Zo = (i >> 4) + 1;
            if (i < 48) {
                i &= 15;
            }
        }
        if (i < 8 || i > 15) {
            DW();
            return -2;
        }
        if (!(this.gn == null || this.VH == i)) {
            this.gn.DW();
            this.gn = null;
        }
        this.VH = i;
        this.gn = new agr(this.tp, 1 << i);
        j6();
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int DW(int r14) {
        /*
        r13 = this;
        r12 = 0;
        r1 = 0;
        r11 = 4;
        r3 = 2;
        r10 = 13;
        r0 = r13.tp;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = r13.tp;
        r0 = r0.j6;
        if (r0 != 0) goto L_0x001c;
    L_0x0010:
        if (r14 != r11) goto L_0x001a;
    L_0x0012:
        r0 = r13.j6;
        r2 = 14;
        if (r0 != r2) goto L_0x001a;
    L_0x0018:
        r2 = r1;
    L_0x0019:
        return r2;
    L_0x001a:
        r2 = -2;
        goto L_0x0019;
    L_0x001c:
        if (r14 != r11) goto L_0x0027;
    L_0x001e:
        r0 = -5;
    L_0x001f:
        r2 = -5;
    L_0x0020:
        r4 = r13.j6;
        switch(r4) {
            case 2: goto L_0x011b;
            case 3: goto L_0x0151;
            case 4: goto L_0x0187;
            case 5: goto L_0x05a1;
            case 6: goto L_0x01fd;
            case 7: goto L_0x020b;
            case 8: goto L_0x023f;
            case 9: goto L_0x0276;
            case 10: goto L_0x02ae;
            case 11: goto L_0x02e6;
            case 12: goto L_0x03b9;
            case 13: goto L_0x03d6;
            case 14: goto L_0x0029;
            case 15: goto L_0x035b;
            case 16: goto L_0x0421;
            case 17: goto L_0x043f;
            case 18: goto L_0x046b;
            case 19: goto L_0x0496;
            case 20: goto L_0x04c3;
            case 21: goto L_0x04e2;
            case 22: goto L_0x0501;
            case 23: goto L_0x03d9;
            default: goto L_0x0025;
        };
    L_0x0025:
        r2 = -2;
        goto L_0x0019;
    L_0x0027:
        r0 = r1;
        goto L_0x001f;
    L_0x0029:
        r4 = r13.Zo;
        if (r4 != 0) goto L_0x0031;
    L_0x002d:
        r4 = 7;
        r13.j6 = r4;
        goto L_0x0020;
    L_0x0031:
        r4 = 2;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x006d }
        r4 = r13.Zo;
        if (r4 == r11) goto L_0x0040;
    L_0x003a:
        r4 = r13.Zo;
        r4 = r4 & 2;
        if (r4 == 0) goto L_0x0071;
    L_0x0040:
        r4 = r13.Hw;
        r6 = 35615; // 0x8b1f float:4.9907E-41 double:1.7596E-319;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 != 0) goto L_0x0071;
    L_0x0049:
        r4 = r13.Zo;
        if (r4 != r11) goto L_0x004f;
    L_0x004d:
        r13.Zo = r3;
    L_0x004f:
        r4 = r13.tp;
        r5 = new agn;
        r5.<init>();
        r4.J0 = r5;
        r4 = r13.Hw;
        r13.j6(r3, r4);
        r4 = r13.u7;
        if (r4 != 0) goto L_0x0068;
    L_0x0061:
        r4 = new agq;
        r4.<init>();
        r13.u7 = r4;
    L_0x0068:
        r4 = 23;
        r13.j6 = r4;
        goto L_0x0020;
    L_0x006d:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0071:
        r4 = r13.Zo;
        r4 = r4 & 2;
        if (r4 == 0) goto L_0x0081;
    L_0x0077:
        r13.j6 = r10;
        r4 = r13.tp;
        r5 = "incorrect header check";
        r4.u7 = r5;
        goto L_0x0020;
    L_0x0081:
        r13.EQ = r1;
        r4 = r13.Hw;
        r4 = (int) r4;
        r4 = r4 & 255;
        r13.DW = r4;
        r4 = r13.Hw;
        r6 = 8;
        r4 = r4 >> r6;
        r4 = (int) r4;
        r4 = r4 & 255;
        r5 = r13.Zo;
        r5 = r5 & 1;
        if (r5 == 0) goto L_0x00a1;
    L_0x0098:
        r5 = r13.DW;
        r5 = r5 << 8;
        r5 = r5 + r4;
        r5 = r5 % 31;
        if (r5 == 0) goto L_0x00d8;
    L_0x00a1:
        r5 = r13.DW;
        r5 = r5 & 15;
        r6 = 8;
        if (r5 == r6) goto L_0x00d8;
    L_0x00a9:
        r4 = r13.Zo;
        if (r4 != r11) goto L_0x00cd;
    L_0x00ad:
        r4 = r13.tp;
        r5 = r4.DW;
        r5 = r5 + -2;
        r4.DW = r5;
        r4 = r13.tp;
        r5 = r4.FH;
        r5 = r5 + 2;
        r4.FH = r5;
        r4 = r13.tp;
        r6 = r4.Hw;
        r8 = 2;
        r6 = r6 - r8;
        r4.Hw = r6;
        r13.Zo = r1;
        r4 = 7;
        r13.j6 = r4;
        goto L_0x0020;
    L_0x00cd:
        r13.j6 = r10;
        r4 = r13.tp;
        r5 = "incorrect header check";
        r4.u7 = r5;
        goto L_0x0020;
    L_0x00d8:
        r5 = r13.DW;
        r5 = r5 & 15;
        r6 = 8;
        if (r5 == r6) goto L_0x00eb;
    L_0x00e0:
        r13.j6 = r10;
        r4 = r13.tp;
        r5 = "unknown compression method";
        r4.u7 = r5;
        goto L_0x0020;
    L_0x00eb:
        r5 = r13.Zo;
        if (r5 != r11) goto L_0x00f2;
    L_0x00ef:
        r5 = 1;
        r13.Zo = r5;
    L_0x00f2:
        r5 = r13.DW;
        r5 = r5 >> 4;
        r5 = r5 + 8;
        r6 = r13.VH;
        if (r5 <= r6) goto L_0x0107;
    L_0x00fc:
        r13.j6 = r10;
        r4 = r13.tp;
        r5 = "invalid window size";
        r4.u7 = r5;
        goto L_0x0020;
    L_0x0107:
        r5 = r13.tp;
        r6 = new agm;
        r6.<init>();
        r5.J0 = r6;
        r4 = r4 & 32;
        if (r4 != 0) goto L_0x0119;
    L_0x0114:
        r4 = 7;
        r13.j6 = r4;
        goto L_0x0020;
    L_0x0119:
        r13.j6 = r3;
    L_0x011b:
        r1 = r13.tp;
        r1 = r1.FH;
        if (r1 == 0) goto L_0x0019;
    L_0x0121:
        r1 = r13.tp;
        r2 = r1.FH;
        r2 = r2 + -1;
        r1.FH = r2;
        r1 = r13.tp;
        r4 = r1.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r1.Hw = r4;
        r1 = r13.tp;
        r1 = r1.j6;
        r2 = r13.tp;
        r4 = r2.DW;
        r5 = r4 + 1;
        r2.DW = r5;
        r1 = r1[r4];
        r1 = r1 & 255;
        r1 = r1 << 24;
        r4 = (long) r1;
        r6 = 4278190080; // 0xff000000 float:-1.7014118E38 double:2.113706745E-314;
        r4 = r4 & r6;
        r13.Hw = r4;
        r1 = 3;
        r13.j6 = r1;
        r2 = r0;
    L_0x0151:
        r1 = r13.tp;
        r1 = r1.FH;
        if (r1 == 0) goto L_0x0019;
    L_0x0157:
        r1 = r13.tp;
        r2 = r1.FH;
        r2 = r2 + -1;
        r1.FH = r2;
        r1 = r13.tp;
        r4 = r1.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r1.Hw = r4;
        r4 = r13.Hw;
        r1 = r13.tp;
        r1 = r1.j6;
        r2 = r13.tp;
        r6 = r2.DW;
        r7 = r6 + 1;
        r2.DW = r7;
        r1 = r1[r6];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r6 = (long) r1;
        r8 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;
        r6 = r6 & r8;
        r4 = r4 + r6;
        r13.Hw = r4;
        r13.j6 = r11;
        r2 = r0;
    L_0x0187:
        r1 = r13.tp;
        r1 = r1.FH;
        if (r1 == 0) goto L_0x0019;
    L_0x018d:
        r1 = r13.tp;
        r2 = r1.FH;
        r2 = r2 + -1;
        r1.FH = r2;
        r1 = r13.tp;
        r4 = r1.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r1.Hw = r4;
        r4 = r13.Hw;
        r1 = r13.tp;
        r1 = r1.j6;
        r2 = r13.tp;
        r6 = r2.DW;
        r7 = r6 + 1;
        r2.DW = r7;
        r1 = r1[r6];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r6 = (long) r1;
        r8 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r6 = r6 & r8;
        r4 = r4 + r6;
        r13.Hw = r4;
        r1 = 5;
        r13.j6 = r1;
    L_0x01bd:
        r1 = r13.tp;
        r1 = r1.FH;
        if (r1 != 0) goto L_0x01c6;
    L_0x01c3:
        r2 = r0;
        goto L_0x0019;
    L_0x01c6:
        r0 = r13.tp;
        r1 = r0.FH;
        r1 = r1 + -1;
        r0.FH = r1;
        r0 = r13.tp;
        r4 = r0.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r0.Hw = r4;
        r0 = r13.Hw;
        r2 = r13.tp;
        r2 = r2.j6;
        r4 = r13.tp;
        r5 = r4.DW;
        r6 = r5 + 1;
        r4.DW = r6;
        r2 = r2[r5];
        r4 = (long) r2;
        r6 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = r4 & r6;
        r0 = r0 + r4;
        r13.Hw = r0;
        r0 = r13.tp;
        r0 = r0.J0;
        r4 = r13.Hw;
        r0.j6(r4);
        r0 = 6;
        r13.j6 = r0;
        r2 = r3;
        goto L_0x0019;
    L_0x01fd:
        r13.j6 = r10;
        r0 = r13.tp;
        r2 = "need dictionary";
        r0.u7 = r2;
        r13.v5 = r1;
        r2 = -2;
        goto L_0x0019;
    L_0x020b:
        r4 = r13.gn;
        r2 = r4.j6(r2);
        r4 = -3;
        if (r2 != r4) goto L_0x021a;
    L_0x0214:
        r13.j6 = r10;
        r13.v5 = r1;
        goto L_0x0020;
    L_0x021a:
        if (r2 != 0) goto L_0x021d;
    L_0x021c:
        r2 = r0;
    L_0x021d:
        r4 = 1;
        if (r2 != r4) goto L_0x0019;
    L_0x0220:
        r2 = r13.tp;
        r2 = r2.J0;
        r4 = r2.DW();
        r13.FH = r4;
        r2 = r13.gn;
        r2.j6();
        r2 = r13.Zo;
        if (r2 != 0) goto L_0x023a;
    L_0x0233:
        r2 = 12;
        r13.j6 = r2;
        r2 = r0;
        goto L_0x0020;
    L_0x023a:
        r2 = 8;
        r13.j6 = r2;
        r2 = r0;
    L_0x023f:
        r4 = r13.tp;
        r4 = r4.FH;
        if (r4 == 0) goto L_0x0019;
    L_0x0245:
        r2 = r13.tp;
        r4 = r2.FH;
        r4 = r4 + -1;
        r2.FH = r4;
        r2 = r13.tp;
        r4 = r2.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r2.Hw = r4;
        r2 = r13.tp;
        r2 = r2.j6;
        r4 = r13.tp;
        r5 = r4.DW;
        r6 = r5 + 1;
        r4.DW = r6;
        r2 = r2[r5];
        r2 = r2 & 255;
        r2 = r2 << 24;
        r4 = (long) r2;
        r6 = 4278190080; // 0xff000000 float:-1.7014118E38 double:2.113706745E-314;
        r4 = r4 & r6;
        r13.Hw = r4;
        r2 = 9;
        r13.j6 = r2;
        r2 = r0;
    L_0x0276:
        r4 = r13.tp;
        r4 = r4.FH;
        if (r4 == 0) goto L_0x0019;
    L_0x027c:
        r2 = r13.tp;
        r4 = r2.FH;
        r4 = r4 + -1;
        r2.FH = r4;
        r2 = r13.tp;
        r4 = r2.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r2.Hw = r4;
        r4 = r13.Hw;
        r2 = r13.tp;
        r2 = r2.j6;
        r6 = r13.tp;
        r7 = r6.DW;
        r8 = r7 + 1;
        r6.DW = r8;
        r2 = r2[r7];
        r2 = r2 & 255;
        r2 = r2 << 16;
        r6 = (long) r2;
        r8 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;
        r6 = r6 & r8;
        r4 = r4 + r6;
        r13.Hw = r4;
        r2 = 10;
        r13.j6 = r2;
        r2 = r0;
    L_0x02ae:
        r4 = r13.tp;
        r4 = r4.FH;
        if (r4 == 0) goto L_0x0019;
    L_0x02b4:
        r2 = r13.tp;
        r4 = r2.FH;
        r4 = r4 + -1;
        r2.FH = r4;
        r2 = r13.tp;
        r4 = r2.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r2.Hw = r4;
        r4 = r13.Hw;
        r2 = r13.tp;
        r2 = r2.j6;
        r6 = r13.tp;
        r7 = r6.DW;
        r8 = r7 + 1;
        r6.DW = r8;
        r2 = r2[r7];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r6 = (long) r2;
        r8 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r6 = r6 & r8;
        r4 = r4 + r6;
        r13.Hw = r4;
        r2 = 11;
        r13.j6 = r2;
        r2 = r0;
    L_0x02e6:
        r4 = r13.tp;
        r4 = r4.FH;
        if (r4 == 0) goto L_0x0019;
    L_0x02ec:
        r2 = r13.tp;
        r4 = r2.FH;
        r4 = r4 + -1;
        r2.FH = r4;
        r2 = r13.tp;
        r4 = r2.Hw;
        r6 = 1;
        r4 = r4 + r6;
        r2.Hw = r4;
        r4 = r13.Hw;
        r2 = r13.tp;
        r2 = r2.j6;
        r6 = r13.tp;
        r7 = r6.DW;
        r8 = r7 + 1;
        r6.DW = r8;
        r2 = r2[r7];
        r6 = (long) r2;
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6 = r6 & r8;
        r4 = r4 + r6;
        r13.Hw = r4;
        r2 = r13.EQ;
        if (r2 == 0) goto L_0x0347;
    L_0x0318:
        r4 = r13.Hw;
        r6 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r4 = r4 & r6;
        r2 = 24;
        r4 = r4 >> r2;
        r6 = r13.Hw;
        r8 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;
        r6 = r6 & r8;
        r2 = 8;
        r6 = r6 >> r2;
        r4 = r4 | r6;
        r6 = r13.Hw;
        r8 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r6 = r6 & r8;
        r2 = 8;
        r6 = r6 << r2;
        r4 = r4 | r6;
        r6 = r13.Hw;
        r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r8;
        r2 = 24;
        r6 = r6 << r2;
        r4 = r4 | r6;
        r6 = 4294967295; // 0xffffffff float:NaN double:2.1219957905E-314;
        r4 = r4 & r6;
        r13.Hw = r4;
    L_0x0347:
        r4 = r13.FH;
        r2 = (int) r4;
        r4 = r13.Hw;
        r4 = (int) r4;
        if (r2 == r4) goto L_0x0382;
    L_0x034f:
        r2 = r13.tp;
        r4 = "incorrect data check";
        r2.u7 = r4;
    L_0x0356:
        r2 = 15;
        r13.j6 = r2;
        r2 = r0;
    L_0x035b:
        r4 = r13.Zo;
        if (r4 == 0) goto L_0x03bc;
    L_0x035f:
        r4 = r13.EQ;
        if (r4 == 0) goto L_0x03bc;
    L_0x0363:
        r4 = 4;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x0391 }
        r4 = r13.tp;
        r4 = r4.u7;
        if (r4 == 0) goto L_0x0396;
    L_0x036e:
        r4 = r13.tp;
        r4 = r4.u7;
        r5 = "incorrect data check";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0396;
    L_0x037b:
        r13.j6 = r10;
        r4 = 5;
        r13.v5 = r4;
        goto L_0x0020;
    L_0x0382:
        r2 = r13.EQ;
        if (r2 == 0) goto L_0x0356;
    L_0x0386:
        r2 = r13.u7;
        if (r2 == 0) goto L_0x0356;
    L_0x038a:
        r2 = r13.u7;
        r4 = r13.Hw;
        r2.u7 = r4;
        goto L_0x0356;
    L_0x0391:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0396:
        r4 = r13.Hw;
        r6 = r13.tp;
        r6 = r6.gn;
        r8 = 4294967295; // 0xffffffff float:NaN double:2.1219957905E-314;
        r6 = r6 & r8;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x03b1;
    L_0x03a6:
        r4 = r13.tp;
        r5 = "incorrect length check";
        r4.u7 = r5;
        r13.j6 = r10;
        goto L_0x0020;
    L_0x03b1:
        r0 = r13.tp;
        r0.u7 = r12;
    L_0x03b5:
        r0 = 12;
        r13.j6 = r0;
    L_0x03b9:
        r2 = 1;
        goto L_0x0019;
    L_0x03bc:
        r4 = r13.tp;
        r4 = r4.u7;
        if (r4 == 0) goto L_0x03b5;
    L_0x03c2:
        r4 = r13.tp;
        r4 = r4.u7;
        r5 = "incorrect data check";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x03b5;
    L_0x03cf:
        r13.j6 = r10;
        r4 = 5;
        r13.v5 = r4;
        goto L_0x0020;
    L_0x03d6:
        r2 = -3;
        goto L_0x0019;
    L_0x03d9:
        r4 = 2;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x03fa }
        r4 = r13.Hw;
        r4 = (int) r4;
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r4 = r4 & r5;
        r13.EQ = r4;
        r4 = r13.EQ;
        r4 = r4 & 255;
        r5 = 8;
        if (r4 == r5) goto L_0x03ff;
    L_0x03ef:
        r4 = r13.tp;
        r5 = "unknown compression method";
        r4.u7 = r5;
        r13.j6 = r10;
        goto L_0x0020;
    L_0x03fa:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x03ff:
        r4 = r13.EQ;
        r5 = 57344; // 0xe000 float:8.0356E-41 double:2.83317E-319;
        r4 = r4 & r5;
        if (r4 == 0) goto L_0x0412;
    L_0x0407:
        r4 = r13.tp;
        r5 = "unknown header flags set";
        r4.u7 = r5;
        r13.j6 = r10;
        goto L_0x0020;
    L_0x0412:
        r4 = r13.EQ;
        r4 = r4 & 512;
        if (r4 == 0) goto L_0x041d;
    L_0x0418:
        r4 = r13.Hw;
        r13.j6(r3, r4);
    L_0x041d:
        r4 = 16;
        r13.j6 = r4;
    L_0x0421:
        r4 = 4;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x053b }
        r4 = r13.u7;
        if (r4 == 0) goto L_0x0430;
    L_0x042a:
        r4 = r13.u7;
        r6 = r13.Hw;
        r4.DW = r6;
    L_0x0430:
        r4 = r13.EQ;
        r4 = r4 & 512;
        if (r4 == 0) goto L_0x043b;
    L_0x0436:
        r4 = r13.Hw;
        r13.j6(r11, r4);
    L_0x043b:
        r4 = 17;
        r13.j6 = r4;
    L_0x043f:
        r4 = 2;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x0540 }
        r4 = r13.u7;
        if (r4 == 0) goto L_0x045c;
    L_0x0448:
        r4 = r13.u7;
        r6 = r13.Hw;
        r5 = (int) r6;
        r5 = r5 & 255;
        r4.FH = r5;
        r4 = r13.u7;
        r6 = r13.Hw;
        r5 = (int) r6;
        r5 = r5 >> 8;
        r5 = r5 & 255;
        r4.Hw = r5;
    L_0x045c:
        r4 = r13.EQ;
        r4 = r4 & 512;
        if (r4 == 0) goto L_0x0467;
    L_0x0462:
        r4 = r13.Hw;
        r13.j6(r3, r4);
    L_0x0467:
        r4 = 18;
        r13.j6 = r4;
    L_0x046b:
        r4 = r13.EQ;
        r4 = r4 & 1024;
        if (r4 == 0) goto L_0x054a;
    L_0x0471:
        r4 = 2;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x0545 }
        r4 = r13.u7;
        if (r4 == 0) goto L_0x0487;
    L_0x047a:
        r4 = r13.u7;
        r6 = r13.Hw;
        r5 = (int) r6;
        r6 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r5 = r5 & r6;
        r5 = new byte[r5];
        r4.v5 = r5;
    L_0x0487:
        r4 = r13.EQ;
        r4 = r4 & 512;
        if (r4 == 0) goto L_0x0492;
    L_0x048d:
        r4 = r13.Hw;
        r13.j6(r3, r4);
    L_0x0492:
        r4 = 19;
        r13.j6 = r4;
    L_0x0496:
        r4 = r13.EQ;
        r4 = r4 & 1024;
        if (r4 == 0) goto L_0x0566;
    L_0x049c:
        r2 = r13.DW(r2, r0);	 Catch:{ agu$a -> 0x0561 }
        r4 = r13.u7;	 Catch:{ agu$a -> 0x0561 }
        if (r4 == 0) goto L_0x04bf;
    L_0x04a4:
        r4 = r13.Ws;	 Catch:{ agu$a -> 0x0561 }
        r4 = r4.toByteArray();	 Catch:{ agu$a -> 0x0561 }
        r5 = 0;
        r13.Ws = r5;	 Catch:{ agu$a -> 0x0561 }
        r5 = r4.length;	 Catch:{ agu$a -> 0x0561 }
        r6 = r13.u7;	 Catch:{ agu$a -> 0x0561 }
        r6 = r6.v5;	 Catch:{ agu$a -> 0x0561 }
        r6 = r6.length;	 Catch:{ agu$a -> 0x0561 }
        if (r5 != r6) goto L_0x0554;
    L_0x04b5:
        r5 = 0;
        r6 = r13.u7;	 Catch:{ agu$a -> 0x0561 }
        r6 = r6.v5;	 Catch:{ agu$a -> 0x0561 }
        r7 = 0;
        r8 = r4.length;	 Catch:{ agu$a -> 0x0561 }
        java.lang.System.arraycopy(r4, r5, r6, r7, r8);	 Catch:{ agu$a -> 0x0561 }
    L_0x04bf:
        r4 = 20;
        r13.j6 = r4;
    L_0x04c3:
        r4 = r13.EQ;
        r4 = r4 & 2048;
        if (r4 == 0) goto L_0x0575;
    L_0x04c9:
        r2 = r13.j6(r2, r0);	 Catch:{ agu$a -> 0x0570 }
        r4 = r13.u7;	 Catch:{ agu$a -> 0x0570 }
        if (r4 == 0) goto L_0x04db;
    L_0x04d1:
        r4 = r13.u7;	 Catch:{ agu$a -> 0x0570 }
        r5 = r13.Ws;	 Catch:{ agu$a -> 0x0570 }
        r5 = r5.toByteArray();	 Catch:{ agu$a -> 0x0570 }
        r4.Zo = r5;	 Catch:{ agu$a -> 0x0570 }
    L_0x04db:
        r4 = 0;
        r13.Ws = r4;	 Catch:{ agu$a -> 0x0570 }
    L_0x04de:
        r4 = 21;
        r13.j6 = r4;
    L_0x04e2:
        r4 = r13.EQ;
        r4 = r4 & 4096;
        if (r4 == 0) goto L_0x0584;
    L_0x04e8:
        r2 = r13.j6(r2, r0);	 Catch:{ agu$a -> 0x057f }
        r4 = r13.u7;	 Catch:{ agu$a -> 0x057f }
        if (r4 == 0) goto L_0x04fa;
    L_0x04f0:
        r4 = r13.u7;	 Catch:{ agu$a -> 0x057f }
        r5 = r13.Ws;	 Catch:{ agu$a -> 0x057f }
        r5 = r5.toByteArray();	 Catch:{ agu$a -> 0x057f }
        r4.VH = r5;	 Catch:{ agu$a -> 0x057f }
    L_0x04fa:
        r4 = 0;
        r13.Ws = r4;	 Catch:{ agu$a -> 0x057f }
    L_0x04fd:
        r4 = 22;
        r13.j6 = r4;
    L_0x0501:
        r4 = r13.EQ;
        r4 = r4 & 512;
        if (r4 == 0) goto L_0x0593;
    L_0x0507:
        r4 = 2;
        r2 = r13.j6(r4, r2, r0);	 Catch:{ agu$a -> 0x058e }
        r4 = r13.u7;
        if (r4 == 0) goto L_0x051b;
    L_0x0510:
        r4 = r13.u7;
        r6 = r13.Hw;
        r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r8;
        r5 = (int) r6;
        r4.gn = r5;
    L_0x051b:
        r4 = r13.Hw;
        r6 = r13.tp;
        r6 = r6.J0;
        r6 = r6.DW();
        r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r8;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0593;
    L_0x052d:
        r13.j6 = r10;
        r4 = r13.tp;
        r5 = "header crc mismatch";
        r4.u7 = r5;
        r4 = 5;
        r13.v5 = r4;
        goto L_0x0020;
    L_0x053b:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0540:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0545:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x054a:
        r4 = r13.u7;
        if (r4 == 0) goto L_0x0492;
    L_0x054e:
        r4 = r13.u7;
        r4.v5 = r12;
        goto L_0x0492;
    L_0x0554:
        r4 = r13.tp;	 Catch:{ agu$a -> 0x0561 }
        r5 = "bad extra field length";
        r4.u7 = r5;	 Catch:{ agu$a -> 0x0561 }
        r4 = 13;
        r13.j6 = r4;	 Catch:{ agu$a -> 0x0561 }
        goto L_0x0020;
    L_0x0561:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0566:
        r4 = r13.u7;
        if (r4 == 0) goto L_0x04bf;
    L_0x056a:
        r4 = r13.u7;
        r4.v5 = r12;
        goto L_0x04bf;
    L_0x0570:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0575:
        r4 = r13.u7;
        if (r4 == 0) goto L_0x04de;
    L_0x0579:
        r4 = r13.u7;
        r4.Zo = r12;
        goto L_0x04de;
    L_0x057f:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0584:
        r4 = r13.u7;
        if (r4 == 0) goto L_0x04fd;
    L_0x0588:
        r4 = r13.u7;
        r4.VH = r12;
        goto L_0x04fd;
    L_0x058e:
        r0 = move-exception;
        r2 = r0.j6;
        goto L_0x0019;
    L_0x0593:
        r4 = r13.tp;
        r5 = new agn;
        r5.<init>();
        r4.J0 = r5;
        r4 = 7;
        r13.j6 = r4;
        goto L_0x0020;
    L_0x05a1:
        r0 = r2;
        goto L_0x01bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: agu.DW(int):int");
    }

    static {
        byte[] bArr = new byte[4];
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        J8 = bArr;
    }

    private int j6(int i, int i2, int i3) {
        if (this.we == -1) {
            this.we = i;
            this.Hw = 0;
        }
        while (this.we > 0) {
            if (this.tp.FH == 0) {
                throw new agu$a(this, i2);
            }
            agx agx = this.tp;
            agx.FH--;
            agx = this.tp;
            agx.Hw++;
            long j = this.Hw;
            byte[] bArr = this.tp.j6;
            agx agx2 = this.tp;
            int i4 = agx2.DW;
            agx2.DW = i4 + 1;
            this.Hw = j | ((long) ((bArr[i4] & 255) << ((i - this.we) * 8)));
            this.we--;
            i2 = i3;
        }
        if (i == 2) {
            this.Hw &= 65535;
        } else if (i == 4) {
            this.Hw &= 4294967295L;
        }
        this.we = -1;
        return i2;
    }

    private int j6(int i, int i2) {
        if (this.Ws == null) {
            this.Ws = new ByteArrayOutputStream();
        }
        while (this.tp.FH != 0) {
            agx agx = this.tp;
            agx.FH--;
            agx = this.tp;
            agx.Hw++;
            byte b = this.tp.j6[this.tp.DW];
            if (b != null) {
                this.Ws.write(this.tp.j6, this.tp.DW, 1);
            }
            this.tp.J0.j6(this.tp.j6, this.tp.DW, 1);
            agx agx2 = this.tp;
            agx2.DW++;
            if (b == null) {
                return i2;
            }
            i = i2;
        }
        throw new agu$a(this, i);
    }

    private int DW(int i, int i2) {
        if (this.Ws == null) {
            this.Ws = new ByteArrayOutputStream();
        }
        while (this.Hw > 0) {
            if (this.tp.FH == 0) {
                throw new agu$a(this, i);
            }
            agx agx = this.tp;
            agx.FH--;
            agx = this.tp;
            agx.Hw++;
            byte b = this.tp.j6[this.tp.DW];
            this.Ws.write(this.tp.j6, this.tp.DW, 1);
            this.tp.J0.j6(this.tp.j6, this.tp.DW, 1);
            agx = this.tp;
            agx.DW++;
            this.Hw--;
            i = i2;
        }
        return i;
    }

    private void j6(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            this.J0[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        this.tp.J0.j6(this.J0, 0, i);
    }
}
