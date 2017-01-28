import com.aide.uidesigner.ProxyTextView;

public class hs {
    private by DW;
    private boolean EQ;
    private bj FH;
    private bj Hw;
    private ev J0;
    private boolean VH;
    private int[] Zo;
    private boolean gn;
    private bu j6;
    private char[] tp;
    private bv u7;
    private char[] v5;
    private hs$a we;

    public hs(by byVar, bu buVar, bj bjVar, bj bjVar2) {
        this.v5 = new char[10000];
        this.Zo = new int[10000];
        this.tp = new char[1000];
        this.EQ = true;
        this.we = new hs$a();
        this.J0 = new ev();
        this.j6 = buVar;
        this.DW = byVar;
        this.FH = bjVar;
        this.Hw = bjVar2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(bv r32, java.io.Reader r33, boolean r34, boolean r35, boolean r36, boolean r37, cm r38, cm r39) {
        /*
        r31 = this;
        r0 = r34;
        r1 = r31;
        r1.VH = r0;
        r0 = r35;
        r1 = r31;
        r1.gn = r0;
        r0 = r32;
        r1 = r31;
        r1.u7 = r0;
        r0 = r31;
        r5 = r0.J0;
        r0 = r33;
        r5.j6(r0);
        r0 = r31;
        r5 = r0.we;
        r0 = r31;
        r6 = r0.J0;
        r0 = r31;
        r7 = r0.EQ;
        r5.j6(r6, r7);
        r0 = r31;
        r5 = r0.we;
        r0 = r31;
        r6 = r0.Zo;
        r0 = r31;
        r7 = r0.v5;
        r8 = 0;
        r0 = r31;
        r9 = r0.v5;
        r9 = r9.length;
        r23 = r5.j6(r6, r7, r8, r9);
        r22 = 0;
        r21 = 0;
        r0 = r31;
        r0 = r0.Zo;
        r20 = r0;
        r0 = r31;
        r0 = r0.v5;
        r19 = r0;
        r0 = r38;
        r0 = r0.j6;
        r18 = r0;
        r0 = r38;
        r0 = r0.DW;
        r17 = r0;
        r0 = r38;
        r0 = r0.FH;
        r16 = r0;
        r0 = r38;
        r15 = r0.Hw;
        r0 = r38;
        r14 = r0.v5;
        r0 = r38;
        r13 = r0.Zo;
        r12 = 0;
        r0 = r39;
        r11 = r0.j6;
        r0 = r39;
        r10 = r0.DW;
        r0 = r39;
        r9 = r0.FH;
        r0 = r39;
        r8 = r0.Hw;
        r0 = r39;
        r7 = r0.v5;
        r0 = r39;
        r6 = r0.Zo;
        r5 = 0;
    L_0x0088:
        r24 = 0;
        r25 = -1;
    L_0x008c:
        r0 = r23;
        r1 = r22;
        if (r0 <= r1) goto L_0x00b5;
    L_0x0092:
        r26 = r19[r22];
        r27 = r26;
    L_0x0096:
        switch(r24) {
            case 0: goto L_0x00bb;
            case 1: goto L_0x08dc;
            case 2: goto L_0x0929;
            case 3: goto L_0x09df;
            case 4: goto L_0x0a04;
            case 5: goto L_0x0a5b;
            case 6: goto L_0x0ac5;
            case 7: goto L_0x0b08;
            case 8: goto L_0x0b62;
            case 9: goto L_0x0bc6;
            case 10: goto L_0x0c44;
            case 11: goto L_0x0c72;
            case 12: goto L_0x0cb5;
            case 13: goto L_0x0ce3;
            case 14: goto L_0x0d3d;
            case 15: goto L_0x0d8d;
            case 16: goto L_0x0ddd;
            case 17: goto L_0x0e0b;
            case 18: goto L_0x0e13;
            case 19: goto L_0x0e1b;
            case 20: goto L_0x0e23;
            case 21: goto L_0x0e2b;
            case 22: goto L_0x0e33;
            case 23: goto L_0x0e3b;
            case 24: goto L_0x0e43;
            case 25: goto L_0x07fd;
            case 26: goto L_0x0e4b;
            case 27: goto L_0x0e65;
            case 28: goto L_0x0e87;
            case 29: goto L_0x0e8f;
            case 30: goto L_0x0eae;
            case 31: goto L_0x0eb6;
            case 32: goto L_0x0ebe;
            case 33: goto L_0x0ec6;
            case 34: goto L_0x0ece;
            case 35: goto L_0x0ed6;
            case 36: goto L_0x0ef5;
            case 37: goto L_0x0efd;
            case 38: goto L_0x0f05;
            case 39: goto L_0x0f1f;
            case 40: goto L_0x0f27;
            case 41: goto L_0x0f41;
            case 42: goto L_0x0f49;
            case 43: goto L_0x0f63;
            case 44: goto L_0x0f85;
            case 45: goto L_0x0f9f;
            case 46: goto L_0x0fa7;
            case 47: goto L_0x0fc6;
            case 48: goto L_0x0fce;
            case 49: goto L_0x0fd6;
            case 50: goto L_0x0ff5;
            case 51: goto L_0x0ffd;
            case 52: goto L_0x101a;
            case 53: goto L_0x1039;
            case 54: goto L_0x1041;
            case 55: goto L_0x1056;
            case 56: goto L_0x105e;
            case 57: goto L_0x107d;
            case 58: goto L_0x1085;
            case 59: goto L_0x10a4;
            case 60: goto L_0x10ac;
            case 61: goto L_0x10c1;
            case 62: goto L_0x10c9;
            case 63: goto L_0x112c;
            case 64: goto L_0x1183;
            case 65: goto L_0x11b2;
            case 66: goto L_0x11f5;
            case 67: goto L_0x121c;
            case 68: goto L_0x1236;
            case 69: goto L_0x1250;
            case 70: goto L_0x126a;
            case 71: goto L_0x1005;
            case 72: goto L_0x0099;
            case 73: goto L_0x0099;
            case 74: goto L_0x0099;
            case 75: goto L_0x0099;
            case 76: goto L_0x12a3;
            case 77: goto L_0x12ea;
            case 78: goto L_0x0099;
            case 79: goto L_0x0099;
            case 80: goto L_0x0c2a;
            case 81: goto L_0x0099;
            case 82: goto L_0x0973;
            case 83: goto L_0x09b5;
            case 84: goto L_0x09bf;
            case 85: goto L_0x0e7f;
            case 86: goto L_0x0f7d;
            case 87: goto L_0x0099;
            case 88: goto L_0x0099;
            case 89: goto L_0x0099;
            case 90: goto L_0x098a;
            case 91: goto L_0x099e;
            default: goto L_0x0099;
        };
    L_0x0099:
        r5 = new java.lang.RuntimeException;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Illegal state: ";
        r6 = r6.append(r7);
        r0 = r24;
        r6 = r6.append(r0);
        r6 = r6.toString();
        r5.<init>(r6);
        throw r5;
    L_0x00b5:
        r27 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r26 = -1;
        goto L_0x0096;
    L_0x00bb:
        switch(r26) {
            case -1: goto L_0x0131;
            case 0: goto L_0x00be;
            case 1: goto L_0x00be;
            case 2: goto L_0x00be;
            case 3: goto L_0x00be;
            case 4: goto L_0x00be;
            case 5: goto L_0x00be;
            case 6: goto L_0x00be;
            case 7: goto L_0x00be;
            case 8: goto L_0x00be;
            case 9: goto L_0x075e;
            case 10: goto L_0x075e;
            case 11: goto L_0x00be;
            case 12: goto L_0x075e;
            case 13: goto L_0x00be;
            case 14: goto L_0x00be;
            case 15: goto L_0x00be;
            case 16: goto L_0x00be;
            case 17: goto L_0x00be;
            case 18: goto L_0x00be;
            case 19: goto L_0x00be;
            case 20: goto L_0x00be;
            case 21: goto L_0x00be;
            case 22: goto L_0x00be;
            case 23: goto L_0x00be;
            case 24: goto L_0x00be;
            case 25: goto L_0x00be;
            case 26: goto L_0x00be;
            case 27: goto L_0x00be;
            case 28: goto L_0x00be;
            case 29: goto L_0x00be;
            case 30: goto L_0x00be;
            case 31: goto L_0x00be;
            case 32: goto L_0x075e;
            case 33: goto L_0x05d2;
            case 34: goto L_0x0222;
            case 35: goto L_0x00be;
            case 36: goto L_0x00be;
            case 37: goto L_0x05a0;
            case 38: goto L_0x0636;
            case 39: goto L_0x0252;
            case 40: goto L_0x034a;
            case 41: goto L_0x037c;
            case 42: goto L_0x056e;
            case 43: goto L_0x0474;
            case 44: goto L_0x03e0;
            case 45: goto L_0x053c;
            case 46: goto L_0x0412;
            case 47: goto L_0x01ca;
            case 48: goto L_0x06fe;
            case 49: goto L_0x072e;
            case 50: goto L_0x072e;
            case 51: goto L_0x072e;
            case 52: goto L_0x072e;
            case 53: goto L_0x072e;
            case 54: goto L_0x072e;
            case 55: goto L_0x072e;
            case 56: goto L_0x072e;
            case 57: goto L_0x072e;
            case 58: goto L_0x050a;
            case 59: goto L_0x03ae;
            case 60: goto L_0x069a;
            case 61: goto L_0x0442;
            case 62: goto L_0x06cc;
            case 63: goto L_0x04d8;
            case 64: goto L_0x00be;
            case 65: goto L_0x0796;
            case 66: goto L_0x0796;
            case 67: goto L_0x0796;
            case 68: goto L_0x0796;
            case 69: goto L_0x0796;
            case 70: goto L_0x0796;
            case 71: goto L_0x0796;
            case 72: goto L_0x0796;
            case 73: goto L_0x0796;
            case 74: goto L_0x0796;
            case 75: goto L_0x0796;
            case 76: goto L_0x0796;
            case 77: goto L_0x0796;
            case 78: goto L_0x0796;
            case 79: goto L_0x0796;
            case 80: goto L_0x0796;
            case 81: goto L_0x0796;
            case 82: goto L_0x0796;
            case 83: goto L_0x0796;
            case 84: goto L_0x0796;
            case 85: goto L_0x0796;
            case 86: goto L_0x0796;
            case 87: goto L_0x0796;
            case 88: goto L_0x0796;
            case 89: goto L_0x0796;
            case 90: goto L_0x0796;
            case 91: goto L_0x02e6;
            case 92: goto L_0x00be;
            case 93: goto L_0x0318;
            case 94: goto L_0x0604;
            case 95: goto L_0x00be;
            case 96: goto L_0x00be;
            case 97: goto L_0x0766;
            case 98: goto L_0x0766;
            case 99: goto L_0x0766;
            case 100: goto L_0x0766;
            case 101: goto L_0x0766;
            case 102: goto L_0x0766;
            case 103: goto L_0x0766;
            case 104: goto L_0x0766;
            case 105: goto L_0x0766;
            case 106: goto L_0x0766;
            case 107: goto L_0x0766;
            case 108: goto L_0x0766;
            case 109: goto L_0x0766;
            case 110: goto L_0x0766;
            case 111: goto L_0x0766;
            case 112: goto L_0x0766;
            case 113: goto L_0x0766;
            case 114: goto L_0x0766;
            case 115: goto L_0x0766;
            case 116: goto L_0x0766;
            case 117: goto L_0x0766;
            case 118: goto L_0x0766;
            case 119: goto L_0x0766;
            case 120: goto L_0x0766;
            case 121: goto L_0x0766;
            case 122: goto L_0x0766;
            case 123: goto L_0x0282;
            case 124: goto L_0x0668;
            case 125: goto L_0x02b4;
            case 126: goto L_0x04a6;
            default: goto L_0x00be;
        };
    L_0x00be:
        r27 = java.lang.Character.isJavaIdentifierStart(r27);
        if (r27 == 0) goto L_0x07c6;
    L_0x00c4:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 1;
        r25 = r24;
        r24 = r22;
    L_0x00f2:
        r26 = r20[r22];
        r26 = r26 + r21;
        r21 = r22 + 1;
        r0 = r21;
        r1 = r23;
        if (r0 < r1) goto L_0x0125;
    L_0x00fe:
        if (r23 < 0) goto L_0x0125;
    L_0x0100:
        r21 = -1;
        r0 = r24;
        r1 = r21;
        if (r0 != r1) goto L_0x130e;
    L_0x0108:
        r0 = r31;
        r0 = r0.we;
        r21 = r0;
        r22 = 0;
        r0 = r19;
        r0 = r0.length;
        r23 = r0;
        r0 = r21;
        r1 = r20;
        r2 = r19;
        r3 = r22;
        r4 = r23;
        r23 = r0.j6(r1, r2, r3, r4);
        r21 = 0;
    L_0x0125:
        r22 = r21;
        r21 = r26;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x008c;
    L_0x0131:
        r10 = 0;
        r18[r12] = r10;
        r0 = r31;
        r10 = r0.J0;
        r17 = 1;
        r0 = r21;
        r1 = r17;
        r10 = r10.j6(r0, r1);
        r16[r12] = r10;
        r0 = r31;
        r10 = r0.J0;
        r16 = 1;
        r0 = r21;
        r1 = r16;
        r10 = r10.DW(r0, r1);
        r14[r12] = r10;
        r0 = r31;
        r10 = r0.J0;
        r14 = 1;
        r0 = r21;
        r10 = r10.j6(r0, r14);
        r15[r12] = r10;
        r0 = r31;
        r10 = r0.J0;
        r14 = 1;
        r0 = r21;
        r10 = r10.DW(r0, r14);
        r13[r12] = r10;
        r10 = r12 + 1;
        r0 = r38;
        r0.u7 = r10;
        r10 = 0;
        r11[r5] = r10;
        r0 = r31;
        r10 = r0.J0;
        r11 = 1;
        r0 = r21;
        r10 = r10.j6(r0, r11);
        r9[r5] = r10;
        r0 = r31;
        r9 = r0.J0;
        r10 = 1;
        r0 = r21;
        r9 = r9.DW(r0, r10);
        r7[r5] = r9;
        r0 = r31;
        r7 = r0.J0;
        r9 = 1;
        r0 = r21;
        r7 = r7.j6(r0, r9);
        r8[r5] = r7;
        r0 = r31;
        r7 = r0.J0;
        r8 = 1;
        r0 = r21;
        r7 = r7.DW(r0, r8);
        r6[r5] = r7;
        r5 = r5 + 1;
        r0 = r39;
        r0.u7 = r5;
        r0 = r20;
        r1 = r31;
        r1.Zo = r0;
        r0 = r19;
        r1 = r31;
        r1.v5 = r0;
        r0 = r31;
        r5 = r0.we;
        r5.j6();
        r5 = 0;
        r0 = r31;
        r0.u7 = r5;
        return;
    L_0x01ca:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r9[r5] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r7[r5] = r24;
        r24 = 2;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x0222:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 6;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x0252:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 11;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x0282:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 17;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x02b4:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 18;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x02e6:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 19;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0318:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 20;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x034a:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 21;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x037c:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 22;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x03ae:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 23;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x03e0:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 24;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0412:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 71;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x0442:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 26;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0474:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 29;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x04a6:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 32;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x04d8:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 33;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x050a:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 34;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x053c:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 35;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x056e:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 38;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x05a0:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 40;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x05d2:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 42;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0604:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 44;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0636:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 46;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0668:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 49;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x069a:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 52;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x06cc:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 56;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x06fe:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 62;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x072e:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 63;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x075e:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0766:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 25;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x0796:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 1;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x07c6:
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x07fd:
        switch(r26) {
            case 32: goto L_0x0884;
            case 33: goto L_0x0800;
            case 34: goto L_0x0800;
            case 35: goto L_0x0800;
            case 36: goto L_0x0800;
            case 37: goto L_0x0800;
            case 38: goto L_0x0800;
            case 39: goto L_0x0800;
            case 40: goto L_0x0884;
            case 41: goto L_0x0800;
            case 42: goto L_0x0800;
            case 43: goto L_0x0800;
            case 44: goto L_0x0884;
            case 45: goto L_0x0800;
            case 46: goto L_0x0884;
            case 47: goto L_0x0800;
            case 48: goto L_0x0800;
            case 49: goto L_0x0800;
            case 50: goto L_0x0800;
            case 51: goto L_0x0800;
            case 52: goto L_0x0800;
            case 53: goto L_0x0800;
            case 54: goto L_0x0800;
            case 55: goto L_0x0800;
            case 56: goto L_0x0800;
            case 57: goto L_0x0800;
            case 58: goto L_0x0800;
            case 59: goto L_0x0800;
            case 60: goto L_0x0800;
            case 61: goto L_0x0800;
            case 62: goto L_0x0800;
            case 63: goto L_0x0800;
            case 64: goto L_0x0800;
            case 65: goto L_0x087a;
            case 66: goto L_0x087a;
            case 67: goto L_0x087a;
            case 68: goto L_0x087a;
            case 69: goto L_0x087a;
            case 70: goto L_0x087a;
            case 71: goto L_0x087a;
            case 72: goto L_0x087a;
            case 73: goto L_0x087a;
            case 74: goto L_0x087a;
            case 75: goto L_0x087a;
            case 76: goto L_0x087a;
            case 77: goto L_0x087a;
            case 78: goto L_0x087a;
            case 79: goto L_0x087a;
            case 80: goto L_0x087a;
            case 81: goto L_0x087a;
            case 82: goto L_0x087a;
            case 83: goto L_0x087a;
            case 84: goto L_0x087a;
            case 85: goto L_0x087a;
            case 86: goto L_0x087a;
            case 87: goto L_0x087a;
            case 88: goto L_0x087a;
            case 89: goto L_0x087a;
            case 90: goto L_0x087a;
            case 91: goto L_0x0884;
            case 92: goto L_0x0800;
            case 93: goto L_0x0800;
            case 94: goto L_0x0800;
            case 95: goto L_0x0800;
            case 96: goto L_0x0800;
            case 97: goto L_0x0872;
            case 98: goto L_0x0872;
            case 99: goto L_0x0872;
            case 100: goto L_0x0872;
            case 101: goto L_0x0872;
            case 102: goto L_0x0872;
            case 103: goto L_0x0872;
            case 104: goto L_0x0872;
            case 105: goto L_0x0872;
            case 106: goto L_0x0872;
            case 107: goto L_0x0872;
            case 108: goto L_0x0872;
            case 109: goto L_0x0872;
            case 110: goto L_0x0872;
            case 111: goto L_0x0872;
            case 112: goto L_0x0872;
            case 113: goto L_0x0872;
            case 114: goto L_0x0872;
            case 115: goto L_0x0872;
            case 116: goto L_0x0872;
            case 117: goto L_0x0872;
            case 118: goto L_0x0872;
            case 119: goto L_0x0872;
            case 120: goto L_0x0872;
            case 121: goto L_0x0872;
            case 122: goto L_0x0872;
            default: goto L_0x0800;
        };
    L_0x0800:
        r24 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r24 != 0) goto L_0x08d2;
    L_0x0806:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r26 = r0.DW(r1, r2, r3);
        r27 = -1;
        r0 = r26;
        r1 = r27;
        if (r0 == r1) goto L_0x08b8;
    L_0x081c:
        r18[r12] = r26;
    L_0x081e:
        r24 = 0;
    L_0x0820:
        if (r24 == 0) goto L_0x13b1;
    L_0x0822:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 0;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r8[r5] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 0;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r6[r5] = r24;
        r5 = r5 + 1;
        r0 = r8.length;
        r24 = r0;
        r0 = r24;
        if (r5 < r0) goto L_0x0088;
    L_0x0853:
        r0 = r39;
        r0.j6(r5);
        r0 = r39;
        r11 = r0.j6;
        r0 = r39;
        r10 = r0.DW;
        r0 = r39;
        r9 = r0.FH;
        r0 = r39;
        r8 = r0.Hw;
        r0 = r39;
        r7 = r0.v5;
        r0 = r39;
        r6 = r0.Zo;
        goto L_0x0088;
    L_0x0872:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x087a:
        r24 = 1;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0884:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r26 = r0.DW(r1, r2, r3);
        r27 = -1;
        r0 = r26;
        r1 = r27;
        if (r0 == r1) goto L_0x089f;
    L_0x089a:
        r18[r12] = r26;
    L_0x089c:
        r24 = 0;
        goto L_0x0820;
    L_0x089f:
        r0 = r31;
        r0 = r0.DW;
        r26 = r0;
        r0 = r26;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
        r24 = 1;
        r18[r12] = r24;
        goto L_0x089c;
    L_0x08b8:
        r0 = r31;
        r0 = r0.DW;
        r26 = r0;
        r0 = r26;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
        r24 = 1;
        r18[r12] = r24;
        goto L_0x081e;
    L_0x08d2:
        r24 = 1;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x08dc:
        switch(r26) {
            case 32: goto L_0x090b;
            case 33: goto L_0x08df;
            case 34: goto L_0x08df;
            case 35: goto L_0x08df;
            case 36: goto L_0x08df;
            case 37: goto L_0x08df;
            case 38: goto L_0x08df;
            case 39: goto L_0x08df;
            case 40: goto L_0x090b;
            case 41: goto L_0x08df;
            case 42: goto L_0x08df;
            case 43: goto L_0x08df;
            case 44: goto L_0x090b;
            case 45: goto L_0x08df;
            case 46: goto L_0x090b;
            case 47: goto L_0x08df;
            case 48: goto L_0x08df;
            case 49: goto L_0x08df;
            case 50: goto L_0x08df;
            case 51: goto L_0x08df;
            case 52: goto L_0x08df;
            case 53: goto L_0x08df;
            case 54: goto L_0x08df;
            case 55: goto L_0x08df;
            case 56: goto L_0x08df;
            case 57: goto L_0x08df;
            case 58: goto L_0x08df;
            case 59: goto L_0x08df;
            case 60: goto L_0x08df;
            case 61: goto L_0x08df;
            case 62: goto L_0x08df;
            case 63: goto L_0x08df;
            case 64: goto L_0x08df;
            case 65: goto L_0x0903;
            case 66: goto L_0x0903;
            case 67: goto L_0x0903;
            case 68: goto L_0x0903;
            case 69: goto L_0x0903;
            case 70: goto L_0x0903;
            case 71: goto L_0x0903;
            case 72: goto L_0x0903;
            case 73: goto L_0x0903;
            case 74: goto L_0x0903;
            case 75: goto L_0x0903;
            case 76: goto L_0x0903;
            case 77: goto L_0x0903;
            case 78: goto L_0x0903;
            case 79: goto L_0x0903;
            case 80: goto L_0x0903;
            case 81: goto L_0x0903;
            case 82: goto L_0x0903;
            case 83: goto L_0x0903;
            case 84: goto L_0x0903;
            case 85: goto L_0x0903;
            case 86: goto L_0x0903;
            case 87: goto L_0x0903;
            case 88: goto L_0x0903;
            case 89: goto L_0x0903;
            case 90: goto L_0x0903;
            case 91: goto L_0x090b;
            case 92: goto L_0x08df;
            case 93: goto L_0x08df;
            case 94: goto L_0x08df;
            case 95: goto L_0x08df;
            case 96: goto L_0x08df;
            case 97: goto L_0x0903;
            case 98: goto L_0x0903;
            case 99: goto L_0x0903;
            case 100: goto L_0x0903;
            case 101: goto L_0x0903;
            case 102: goto L_0x0903;
            case 103: goto L_0x0903;
            case 104: goto L_0x0903;
            case 105: goto L_0x0903;
            case 106: goto L_0x0903;
            case 107: goto L_0x0903;
            case 108: goto L_0x0903;
            case 109: goto L_0x0903;
            case 110: goto L_0x0903;
            case 111: goto L_0x0903;
            case 112: goto L_0x0903;
            case 113: goto L_0x0903;
            case 114: goto L_0x0903;
            case 115: goto L_0x0903;
            case 116: goto L_0x0903;
            case 117: goto L_0x0903;
            case 118: goto L_0x0903;
            case 119: goto L_0x0903;
            case 120: goto L_0x0903;
            case 121: goto L_0x0903;
            case 122: goto L_0x0903;
            default: goto L_0x08df;
        };
    L_0x08df:
        r26 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r26 != 0) goto L_0x140d;
    L_0x08e5:
        r24 = r22 - r25;
        r0 = r31;
        r0 = r0.DW;
        r26 = r0;
        r0 = r26;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
        r24 = 1;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0903:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x090b:
        r24 = r22 - r25;
        r0 = r31;
        r0 = r0.DW;
        r26 = r0;
        r0 = r26;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
        r24 = 1;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0929:
        switch(r26) {
            case 42: goto L_0x0951;
            case 47: goto L_0x0947;
            case 92: goto L_0x095b;
            default: goto L_0x092c;
        };
    L_0x092c:
        if (r12 <= 0) goto L_0x0965;
    L_0x092e:
        r24 = r12 + -1;
        r24 = r18[r24];
    L_0x0932:
        switch(r24) {
            case 8: goto L_0x0968;
            case 9: goto L_0x0968;
            case 10: goto L_0x0968;
            case 12: goto L_0x0968;
            case 14: goto L_0x0968;
            case 15: goto L_0x0968;
            case 17: goto L_0x0968;
            case 18: goto L_0x0968;
            case 19: goto L_0x0968;
            case 20: goto L_0x0968;
            case 21: goto L_0x0968;
            case 23: goto L_0x0968;
            case 25: goto L_0x0968;
            case 26: goto L_0x0968;
            case 27: goto L_0x0968;
            case 29: goto L_0x0968;
            case 30: goto L_0x0968;
            case 31: goto L_0x0968;
            case 32: goto L_0x0968;
            case 33: goto L_0x0968;
            case 34: goto L_0x0968;
            case 35: goto L_0x0968;
            case 36: goto L_0x0968;
            case 37: goto L_0x0968;
            case 38: goto L_0x0968;
            case 39: goto L_0x0968;
            case 40: goto L_0x0968;
            case 41: goto L_0x0968;
            case 42: goto L_0x0968;
            case 43: goto L_0x0968;
            case 44: goto L_0x0968;
            case 45: goto L_0x0968;
            case 46: goto L_0x0968;
            case 47: goto L_0x0968;
            case 48: goto L_0x0968;
            case 49: goto L_0x0968;
            case 50: goto L_0x0968;
            case 51: goto L_0x0968;
            case 52: goto L_0x0968;
            case 53: goto L_0x0968;
            case 85: goto L_0x0968;
            case 115: goto L_0x0968;
            case 116: goto L_0x0968;
            default: goto L_0x0935;
        };
    L_0x0935:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 != r1) goto L_0x096b;
    L_0x093d:
        r24 = 28;
    L_0x093f:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0947:
        r24 = 3;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0951:
        r24 = 4;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x095b:
        r24 = 83;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0965:
        r24 = -1;
        goto L_0x0932;
    L_0x0968:
        r24 = 82;
        goto L_0x093f;
    L_0x096b:
        r24 = 19;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0973:
        switch(r26) {
            case -1: goto L_0x0984;
            case 10: goto L_0x0984;
            case 47: goto L_0x0981;
            case 91: goto L_0x0987;
            case 92: goto L_0x097e;
            default: goto L_0x0976;
        };
    L_0x0976:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x097e:
        r24 = 83;
        goto L_0x0976;
    L_0x0981:
        r24 = 84;
        goto L_0x0976;
    L_0x0984:
        r24 = 84;
        goto L_0x0976;
    L_0x0987:
        r24 = 90;
        goto L_0x0976;
    L_0x098a:
        switch(r26) {
            case -1: goto L_0x099b;
            case 10: goto L_0x099b;
            case 92: goto L_0x0995;
            case 93: goto L_0x0998;
            default: goto L_0x098d;
        };
    L_0x098d:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0995:
        r24 = 91;
        goto L_0x098d;
    L_0x0998:
        r24 = 82;
        goto L_0x098d;
    L_0x099b:
        r24 = 84;
        goto L_0x098d;
    L_0x099e:
        switch(r26) {
            case -1: goto L_0x09ab;
            case 10: goto L_0x09ab;
            default: goto L_0x09a1;
        };
    L_0x09a1:
        r24 = 90;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09ab:
        r24 = 84;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09b5:
        r24 = 82;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09bf:
        r26 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r26 != 0) goto L_0x140d;
    L_0x09c5:
        if (r36 == 0) goto L_0x09d7;
    L_0x09c7:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x09d7:
        r24 = 2;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x09df:
        switch(r26) {
            case -1: goto L_0x09ea;
            case 10: goto L_0x09ea;
            default: goto L_0x09e2;
        };
    L_0x09e2:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09ea:
        if (r37 == 0) goto L_0x09fc;
    L_0x09ec:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x09fc:
        r24 = 1;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x0820;
    L_0x0a04:
        switch(r26) {
            case -1: goto L_0x0a12;
            case 42: goto L_0x0a0f;
            default: goto L_0x0a07;
        };
    L_0x0a07:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a0f:
        r24 = 5;
        goto L_0x0a07;
    L_0x0a12:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r27 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r27;
        r24 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r24;
        r2 = r27;
        r3 = r26;
        r0.DW(r1, r2, r3);
        if (r37 == 0) goto L_0x0a53;
    L_0x0a43:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x0a53:
        r24 = 2;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x0820;
    L_0x0a5b:
        switch(r26) {
            case -1: goto L_0x0a7c;
            case 42: goto L_0x0a72;
            case 47: goto L_0x0a68;
            default: goto L_0x0a5e;
        };
    L_0x0a5e:
        r24 = 4;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a68:
        r24 = 80;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a72:
        r24 = 5;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a7c:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r27 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r27;
        r24 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r24;
        r2 = r27;
        r3 = r26;
        r0.DW(r1, r2, r3);
        if (r37 == 0) goto L_0x0abd;
    L_0x0aad:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x0abd:
        r24 = 2;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x0820;
    L_0x0ac5:
        switch(r26) {
            case -1: goto L_0x0ad6;
            case 10: goto L_0x0ad6;
            case 34: goto L_0x0ad0;
            case 92: goto L_0x0ad3;
            default: goto L_0x0ac8;
        };
    L_0x0ac8:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ad0:
        r24 = 10;
        goto L_0x0ac8;
    L_0x0ad3:
        r24 = 7;
        goto L_0x0ac8;
    L_0x0ad6:
        r24 = 10;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        goto L_0x0ac8;
    L_0x0b08:
        switch(r26) {
            case -1: goto L_0x0b15;
            case 48: goto L_0x0b4e;
            case 49: goto L_0x0b4e;
            case 50: goto L_0x0b4e;
            case 51: goto L_0x0b4e;
            case 52: goto L_0x0b58;
            case 53: goto L_0x0b58;
            case 54: goto L_0x0b58;
            case 55: goto L_0x0b58;
            default: goto L_0x0b0b;
        };
    L_0x0b0b:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b15:
        r24 = 10;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b4e:
        r24 = 8;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b58:
        r24 = 9;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b62:
        switch(r26) {
            case -1: goto L_0x0b6f;
            case 10: goto L_0x0b6f;
            case 34: goto L_0x0ba8;
            case 48: goto L_0x0bbc;
            case 49: goto L_0x0bbc;
            case 50: goto L_0x0bbc;
            case 51: goto L_0x0bbc;
            case 52: goto L_0x0bbc;
            case 53: goto L_0x0bbc;
            case 54: goto L_0x0bbc;
            case 55: goto L_0x0bbc;
            case 92: goto L_0x0bb2;
            default: goto L_0x0b65;
        };
    L_0x0b65:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b6f:
        r24 = 10;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ba8:
        r24 = 10;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bb2:
        r24 = 7;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bbc:
        r24 = 9;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bc6:
        switch(r26) {
            case -1: goto L_0x0bd3;
            case 10: goto L_0x0bd3;
            case 34: goto L_0x0c0c;
            case 48: goto L_0x0c20;
            case 49: goto L_0x0c20;
            case 50: goto L_0x0c20;
            case 51: goto L_0x0c20;
            case 52: goto L_0x0c20;
            case 53: goto L_0x0c20;
            case 54: goto L_0x0c20;
            case 55: goto L_0x0c20;
            case 92: goto L_0x0c16;
            default: goto L_0x0bc9;
        };
    L_0x0bc9:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bd3:
        r24 = 10;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c0c:
        r24 = 10;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c16:
        r24 = 7;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c20:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c2a:
        if (r37 == 0) goto L_0x0c3c;
    L_0x0c2c:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x0c3c:
        r24 = 2;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x0820;
    L_0x0c44:
        if (r36 == 0) goto L_0x0c6a;
    L_0x0c46:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r0 = r31;
        r0 = r0.tp;
        r25 = r0;
        r26 = 0;
        r0 = r38;
        r1 = r25;
        r2 = r26;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x0c6a:
        r24 = 2;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0c72:
        switch(r26) {
            case -1: goto L_0x0c83;
            case 10: goto L_0x0c83;
            case 39: goto L_0x0c7d;
            case 92: goto L_0x0c80;
            default: goto L_0x0c75;
        };
    L_0x0c75:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c7d:
        r24 = 12;
        goto L_0x0c75;
    L_0x0c80:
        r24 = 13;
        goto L_0x0c75;
    L_0x0c83:
        r24 = 10;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        goto L_0x0c75;
    L_0x0cb5:
        if (r36 == 0) goto L_0x0cdb;
    L_0x0cb7:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r0 = r31;
        r0 = r0.tp;
        r25 = r0;
        r26 = 0;
        r0 = r38;
        r1 = r25;
        r2 = r26;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x0cdb:
        r24 = 2;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ce3:
        switch(r26) {
            case -1: goto L_0x0cf0;
            case 48: goto L_0x0d29;
            case 49: goto L_0x0d29;
            case 50: goto L_0x0d29;
            case 51: goto L_0x0d29;
            case 52: goto L_0x0d33;
            case 53: goto L_0x0d33;
            case 54: goto L_0x0d33;
            case 55: goto L_0x0d33;
            default: goto L_0x0ce6;
        };
    L_0x0ce6:
        r24 = 11;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0cf0:
        r24 = 10;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d29:
        r24 = 14;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d33:
        r24 = 15;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d3d:
        switch(r26) {
            case 39: goto L_0x0d83;
            case 40: goto L_0x0d40;
            case 41: goto L_0x0d40;
            case 42: goto L_0x0d40;
            case 43: goto L_0x0d40;
            case 44: goto L_0x0d40;
            case 45: goto L_0x0d40;
            case 46: goto L_0x0d40;
            case 47: goto L_0x0d40;
            case 48: goto L_0x0d79;
            case 49: goto L_0x0d79;
            case 50: goto L_0x0d79;
            case 51: goto L_0x0d79;
            case 52: goto L_0x0d79;
            case 53: goto L_0x0d79;
            case 54: goto L_0x0d79;
            case 55: goto L_0x0d79;
            default: goto L_0x0d40;
        };
    L_0x0d40:
        r24 = 0;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d79:
        r24 = 15;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d83:
        r24 = 16;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d8d:
        switch(r26) {
            case 39: goto L_0x0dd3;
            case 40: goto L_0x0d90;
            case 41: goto L_0x0d90;
            case 42: goto L_0x0d90;
            case 43: goto L_0x0d90;
            case 44: goto L_0x0d90;
            case 45: goto L_0x0d90;
            case 46: goto L_0x0d90;
            case 47: goto L_0x0d90;
            case 48: goto L_0x0dc9;
            case 49: goto L_0x0dc9;
            case 50: goto L_0x0dc9;
            case 51: goto L_0x0dc9;
            case 52: goto L_0x0dc9;
            case 53: goto L_0x0dc9;
            case 54: goto L_0x0dc9;
            case 55: goto L_0x0dc9;
            default: goto L_0x0d90;
        };
    L_0x0d90:
        r24 = 0;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0dc9:
        r24 = 11;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0dd3:
        r24 = 16;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ddd:
        if (r36 == 0) goto L_0x0e03;
    L_0x0ddf:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r0 = r31;
        r0 = r0.tp;
        r25 = r0;
        r26 = 0;
        r0 = r38;
        r1 = r25;
        r2 = r26;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x0e03:
        r24 = 3;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e0b:
        r24 = 8;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e13:
        r24 = 9;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e1b:
        r24 = 10;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e23:
        r24 = 11;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e2b:
        r24 = 12;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e33:
        r24 = 13;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e3b:
        r24 = 14;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e43:
        r24 = 15;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e4b:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0e5b;
    L_0x0e53:
        r24 = 17;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e5b:
        r24 = 27;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0e65:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0e75;
    L_0x0e6d:
        r24 = 18;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e75:
        r24 = 85;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0e7f:
        r24 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e87:
        r24 = 20;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e8f:
        switch(r26) {
            case 43: goto L_0x0e9a;
            case 61: goto L_0x0ea4;
            default: goto L_0x0e92;
        };
    L_0x0e92:
        r24 = 21;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0e9a:
        r24 = 30;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ea4:
        r24 = 31;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0eae:
        r24 = 22;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0eb6:
        r24 = 23;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ebe:
        r24 = 24;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ec6:
        r24 = 25;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ece:
        r24 = 26;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ed6:
        switch(r26) {
            case 45: goto L_0x0ee1;
            case 61: goto L_0x0eeb;
            default: goto L_0x0ed9;
        };
    L_0x0ed9:
        r24 = 27;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ee1:
        r24 = 36;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0eeb:
        r24 = 37;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ef5:
        r24 = 28;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0efd:
        r24 = 29;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f05:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f15;
    L_0x0f0d:
        r24 = 30;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f15:
        r24 = 39;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f1f:
        r24 = 31;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f27:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f37;
    L_0x0f2f:
        r24 = 32;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f37:
        r24 = 41;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f41:
        r24 = 33;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f49:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f59;
    L_0x0f51:
        r24 = 34;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f59:
        r24 = 43;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f63:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f73;
    L_0x0f6b:
        r24 = 35;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f73:
        r24 = 86;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f7d:
        r24 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f85:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f95;
    L_0x0f8d:
        r24 = 36;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0f95:
        r24 = 45;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f9f:
        r24 = 37;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0fa7:
        switch(r26) {
            case 38: goto L_0x0fb2;
            case 61: goto L_0x0fbc;
            default: goto L_0x0faa;
        };
    L_0x0faa:
        r24 = 41;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0fb2:
        r24 = 47;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0fbc:
        r24 = 48;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0fc6:
        r24 = 42;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0fce:
        r24 = 43;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0fd6:
        switch(r26) {
            case 61: goto L_0x0feb;
            case 124: goto L_0x0fe1;
            default: goto L_0x0fd9;
        };
    L_0x0fd9:
        r24 = 38;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0fe1:
        r24 = 50;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0feb:
        r24 = 51;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ff5:
        r24 = 39;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x0ffd:
        r24 = 40;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1005:
        switch(r26) {
            case 48: goto L_0x1010;
            case 49: goto L_0x1010;
            case 50: goto L_0x1010;
            case 51: goto L_0x1010;
            case 52: goto L_0x1010;
            case 53: goto L_0x1010;
            case 54: goto L_0x1010;
            case 55: goto L_0x1010;
            case 56: goto L_0x1010;
            case 57: goto L_0x1010;
            default: goto L_0x1008;
        };
    L_0x1008:
        r24 = 16;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1010:
        r24 = 65;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x101a:
        switch(r26) {
            case 60: goto L_0x1025;
            case 61: goto L_0x102f;
            default: goto L_0x101d;
        };
    L_0x101d:
        r24 = 44;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1025:
        r24 = 54;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x102f:
        r24 = 53;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1039:
        r24 = 45;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1041:
        switch(r26) {
            case 61: goto L_0x104c;
            default: goto L_0x1044;
        };
    L_0x1044:
        r24 = 46;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x104c:
        r24 = 55;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1056:
        r24 = 47;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x105e:
        switch(r26) {
            case 61: goto L_0x1073;
            case 62: goto L_0x1069;
            default: goto L_0x1061;
        };
    L_0x1061:
        r24 = 48;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1069:
        r24 = 58;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1073:
        r24 = 57;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x107d:
        r24 = 49;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1085:
        switch(r26) {
            case 61: goto L_0x1090;
            case 62: goto L_0x109a;
            default: goto L_0x1088;
        };
    L_0x1088:
        r24 = 50;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1090:
        r24 = 59;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x109a:
        r24 = 60;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10a4:
        r24 = 52;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x10ac:
        switch(r26) {
            case 61: goto L_0x10b7;
            default: goto L_0x10af;
        };
    L_0x10af:
        r24 = 51;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x10b7:
        r24 = 61;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10c1:
        r24 = 53;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x10c9:
        switch(r26) {
            case 46: goto L_0x10fa;
            case 48: goto L_0x10e6;
            case 49: goto L_0x10e6;
            case 50: goto L_0x10e6;
            case 51: goto L_0x10e6;
            case 52: goto L_0x10e6;
            case 53: goto L_0x10e6;
            case 54: goto L_0x10e6;
            case 55: goto L_0x10e6;
            case 56: goto L_0x10e6;
            case 57: goto L_0x10e6;
            case 68: goto L_0x1118;
            case 69: goto L_0x1104;
            case 70: goto L_0x110e;
            case 76: goto L_0x1122;
            case 88: goto L_0x10f0;
            case 100: goto L_0x1118;
            case 101: goto L_0x1104;
            case 102: goto L_0x110e;
            case 108: goto L_0x1122;
            case 120: goto L_0x10f0;
            default: goto L_0x10cc;
        };
    L_0x10cc:
        if (r36 == 0) goto L_0x10de;
    L_0x10ce:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x10de:
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x10e6:
        r24 = 63;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10f0:
        r24 = 64;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10fa:
        r24 = 65;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1104:
        r24 = 66;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x110e:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1118:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1122:
        r24 = 67;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x112c:
        switch(r26) {
            case 46: goto L_0x1151;
            case 48: goto L_0x1149;
            case 49: goto L_0x1149;
            case 50: goto L_0x1149;
            case 51: goto L_0x1149;
            case 52: goto L_0x1149;
            case 53: goto L_0x1149;
            case 54: goto L_0x1149;
            case 55: goto L_0x1149;
            case 56: goto L_0x1149;
            case 57: goto L_0x1149;
            case 68: goto L_0x116f;
            case 69: goto L_0x115b;
            case 70: goto L_0x1165;
            case 76: goto L_0x1179;
            case 100: goto L_0x116f;
            case 101: goto L_0x115b;
            case 102: goto L_0x1165;
            case 108: goto L_0x1179;
            default: goto L_0x112f;
        };
    L_0x112f:
        if (r36 == 0) goto L_0x1141;
    L_0x1131:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x1141:
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1149:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1151:
        r24 = 65;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x115b:
        r24 = 66;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1165:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x116f:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1179:
        r24 = 67;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1183:
        switch(r26) {
            case 48: goto L_0x11a0;
            case 49: goto L_0x11a0;
            case 50: goto L_0x11a0;
            case 51: goto L_0x11a0;
            case 52: goto L_0x11a0;
            case 53: goto L_0x11a0;
            case 54: goto L_0x11a0;
            case 55: goto L_0x11a0;
            case 56: goto L_0x11a0;
            case 57: goto L_0x11a0;
            case 65: goto L_0x11a0;
            case 66: goto L_0x11a0;
            case 67: goto L_0x11a0;
            case 68: goto L_0x11a0;
            case 69: goto L_0x11a0;
            case 70: goto L_0x11a0;
            case 76: goto L_0x11a8;
            case 97: goto L_0x11a0;
            case 98: goto L_0x11a0;
            case 99: goto L_0x11a0;
            case 100: goto L_0x11a0;
            case 101: goto L_0x11a0;
            case 102: goto L_0x11a0;
            case 108: goto L_0x11a8;
            default: goto L_0x1186;
        };
    L_0x1186:
        if (r36 == 0) goto L_0x1198;
    L_0x1188:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x1198:
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x11a0:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11a8:
        r24 = 67;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11b2:
        switch(r26) {
            case 48: goto L_0x11cf;
            case 49: goto L_0x11cf;
            case 50: goto L_0x11cf;
            case 51: goto L_0x11cf;
            case 52: goto L_0x11cf;
            case 53: goto L_0x11cf;
            case 54: goto L_0x11cf;
            case 55: goto L_0x11cf;
            case 56: goto L_0x11cf;
            case 57: goto L_0x11cf;
            case 68: goto L_0x11eb;
            case 69: goto L_0x11d7;
            case 70: goto L_0x11e1;
            case 100: goto L_0x11eb;
            case 101: goto L_0x11d7;
            case 102: goto L_0x11e1;
            default: goto L_0x11b5;
        };
    L_0x11b5:
        if (r36 == 0) goto L_0x11c7;
    L_0x11b7:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x11c7:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x11cf:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11d7:
        r24 = 66;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11e1:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11eb:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11f5:
        switch(r26) {
            case 43: goto L_0x1212;
            case 44: goto L_0x11f8;
            case 45: goto L_0x1212;
            case 46: goto L_0x11f8;
            case 47: goto L_0x11f8;
            case 48: goto L_0x1212;
            case 49: goto L_0x1212;
            case 50: goto L_0x1212;
            case 51: goto L_0x1212;
            case 52: goto L_0x1212;
            case 53: goto L_0x1212;
            case 54: goto L_0x1212;
            case 55: goto L_0x1212;
            case 56: goto L_0x1212;
            case 57: goto L_0x1212;
            default: goto L_0x11f8;
        };
    L_0x11f8:
        if (r36 == 0) goto L_0x120a;
    L_0x11fa:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x120a:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1212:
        r24 = 70;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x121c:
        if (r36 == 0) goto L_0x122e;
    L_0x121e:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x122e:
        r24 = 5;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1236:
        if (r36 == 0) goto L_0x1248;
    L_0x1238:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x1248:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1250:
        if (r36 == 0) goto L_0x1262;
    L_0x1252:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x1262:
        r24 = 6;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x126a:
        switch(r26) {
            case 48: goto L_0x1287;
            case 49: goto L_0x1287;
            case 50: goto L_0x1287;
            case 51: goto L_0x1287;
            case 52: goto L_0x1287;
            case 53: goto L_0x1287;
            case 54: goto L_0x1287;
            case 55: goto L_0x1287;
            case 56: goto L_0x1287;
            case 57: goto L_0x1287;
            case 68: goto L_0x1299;
            case 70: goto L_0x128f;
            case 100: goto L_0x1299;
            case 102: goto L_0x128f;
            default: goto L_0x126d;
        };
    L_0x126d:
        if (r36 == 0) goto L_0x127f;
    L_0x126f:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x127f:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x1287:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x128f:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1299:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x12a3:
        r24 = java.lang.Character.isJavaIdentifierStart(r27);
        if (r24 == 0) goto L_0x12b1;
    L_0x12a9:
        r24 = 77;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x12b1:
        r24 = 0;
        r0 = r31;
        r0 = r0.J0;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J0;
        r28 = r0;
        r29 = 1;
        r0 = r28;
        r1 = r21;
        r2 = r29;
        r28 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r27;
        r2 = r28;
        r3 = r26;
        r0.j6(r1, r2, r3);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x12ea:
        r26 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r26 != 0) goto L_0x140d;
    L_0x12f0:
        r24 = r22 - r25;
        r0 = r31;
        r0 = r0.DW;
        r26 = r0;
        r0 = r26;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
        r24 = 1;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x0820;
    L_0x130e:
        r21 = r23 - r24;
        r0 = r19;
        r0 = r0.length;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        if (r0 != r1) goto L_0x1407;
    L_0x131b:
        r0 = r19;
        r0 = r0.length;
        r22 = r0;
        r22 = r22 * 2;
        r22 = r22 + 1;
        r0 = r22;
        r0 = new char[r0];
        r22 = r0;
        r23 = 0;
        r27 = 0;
        r0 = r19;
        r1 = r23;
        r2 = r22;
        r3 = r27;
        r4 = r21;
        java.lang.System.arraycopy(r0, r1, r2, r3, r4);
        r0 = r20;
        r0 = r0.length;
        r19 = r0;
        r19 = r19 * 2;
        r19 = r19 + 1;
        r0 = r19;
        r0 = new int[r0];
        r19 = r0;
        r23 = 0;
        r27 = 0;
        r0 = r20;
        r1 = r23;
        r2 = r19;
        r3 = r27;
        r4 = r21;
        java.lang.System.arraycopy(r0, r1, r2, r3, r4);
        r20 = r22;
        r22 = r19;
    L_0x135f:
        if (r24 == 0) goto L_0x137f;
    L_0x1361:
        r19 = 0;
        r0 = r22;
        r1 = r24;
        r2 = r22;
        r3 = r19;
        r4 = r21;
        java.lang.System.arraycopy(r0, r1, r2, r3, r4);
        r19 = 0;
        r0 = r20;
        r1 = r24;
        r2 = r20;
        r3 = r19;
        r4 = r21;
        java.lang.System.arraycopy(r0, r1, r2, r3, r4);
    L_0x137f:
        r0 = r31;
        r0 = r0.we;
        r19 = r0;
        r0 = r20;
        r0 = r0.length;
        r23 = r0;
        r23 = r23 - r21;
        r0 = r19;
        r1 = r22;
        r2 = r20;
        r3 = r21;
        r4 = r23;
        r19 = r0.j6(r1, r2, r3, r4);
        r23 = -1;
        r0 = r19;
        r1 = r23;
        if (r0 != r1) goto L_0x13ae;
    L_0x13a2:
        r19 = r21;
    L_0x13a4:
        r24 = 0;
        r23 = r19;
        r19 = r20;
        r20 = r22;
        goto L_0x0125;
    L_0x13ae:
        r19 = r19 + r21;
        goto L_0x13a4;
    L_0x13b1:
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 0;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r15[r12] = r24;
        r0 = r31;
        r0 = r0.J0;
        r24 = r0;
        r25 = 0;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r13[r12] = r24;
        r12 = r12 + 1;
        r0 = r15.length;
        r24 = r0;
        r0 = r24;
        if (r12 < r0) goto L_0x0088;
    L_0x13e2:
        r0 = r38;
        r0.j6(r12);
        r0 = r38;
        r0 = r0.j6;
        r18 = r0;
        r0 = r38;
        r0 = r0.DW;
        r17 = r0;
        r0 = r38;
        r0 = r0.FH;
        r16 = r0;
        r0 = r38;
        r15 = r0.Hw;
        r0 = r38;
        r14 = r0.v5;
        r0 = r38;
        r13 = r0.Zo;
        goto L_0x0088;
    L_0x1407:
        r22 = r20;
        r20 = r19;
        goto L_0x135f;
    L_0x140d:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
        */
        throw new UnsupportedOperationException("Method not decompiled: hs.j6(bv, java.io.Reader, boolean, boolean, boolean, boolean, cm, cm):void");
    }

    private int j6(char[] cArr, int i, int i2) {
        if (i2 >= this.tp.length) {
            Object obj = new char[Math.max((this.tp.length * 2) + 1, i2)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 < i + i2) {
            int i5;
            char c = cArr[i3];
            if (c == '\\') {
                switch (cArr[i3 + 1]) {
                    case '\"':
                        i5 = i4 + 1;
                        this.tp[i4] = '\"';
                        i3++;
                        break;
                    case '\'':
                        i5 = i4 + 1;
                        this.tp[i4] = '\'';
                        i3++;
                        break;
                    case '0':
                    case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        i5 = 0;
                        int i6 = 0;
                        while (i5 < 3) {
                            char c2 = cArr[i3 + 1];
                            switch (c2) {
                                case '0':
                                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                    i6 = (i6 * 8) + (c2 - 48);
                                    i5++;
                                    i3++;
                                default:
                                    break;
                            }
                            i5 = i4 + 1;
                            this.tp[i4] = (char) i6;
                            break;
                        }
                        i5 = i4 + 1;
                        this.tp[i4] = (char) i6;
                    case '\\':
                        i5 = i4 + 1;
                        this.tp[i4] = '\\';
                        i3++;
                        break;
                    case 'b':
                        i5 = i4 + 1;
                        this.tp[i4] = '\b';
                        i3++;
                        break;
                    case 'f':
                        i5 = i4 + 1;
                        this.tp[i4] = '\f';
                        i3++;
                        break;
                    case 'n':
                        i5 = i4 + 1;
                        this.tp[i4] = '\n';
                        i3++;
                        break;
                    case 'r':
                        i5 = i4 + 1;
                        this.tp[i4] = '\r';
                        i3++;
                        break;
                    case 't':
                        i5 = i4 + 1;
                        this.tp[i4] = '\t';
                        i3++;
                        break;
                    default:
                        i5 = i4;
                        break;
                }
            }
            i5 = i4 + 1;
            this.tp[i4] = c;
            i3++;
            i4 = i5;
        }
        return i4 - 0;
    }

    private int DW(char[] cArr, int i, int i2) {
        switch (i2) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                switch (cArr[i]) {
                    case 'd':
                        if (cArr[i + 1] == 'o') {
                            return 54;
                        }
                        break;
                    case 'i':
                        if (cArr[i + 1] == 'f') {
                            return 55;
                        }
                        if (cArr[i + 1] == 'n') {
                            return 114;
                        }
                        break;
                    default:
                        break;
                }
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                switch (cArr[i]) {
                    case 'f':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'r') {
                            return 56;
                        }
                    case 'n':
                        if (cArr[i + 1] == 'e' && cArr[i + 2] == 'w') {
                            return 58;
                        }
                    case 't':
                        if (cArr[i + 1] == 'r' && cArr[i + 2] == 'y') {
                            return 59;
                        }
                    case 'v':
                        if (cArr[i + 1] == 'a' && cArr[i + 2] == 'r') {
                            return 98;
                        }
                    default:
                        break;
                }
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                switch (cArr[i]) {
                    case 'c':
                        switch (cArr[i + 1]) {
                            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                if (cArr[i + 2] == 's' && cArr[i + 3] == 'e') {
                                    return 61;
                                }
                            default:
                                break;
                        }
                    case 'e':
                        switch (cArr[i + 1]) {
                            case 'l':
                                if (cArr[i + 2] == 's' && cArr[i + 3] == 'e') {
                                    return 63;
                                }
                            default:
                                break;
                        }
                    case 'g':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 't' && cArr[i + 3] == 'o') {
                            return 64;
                        }
                    case 'n':
                        if (cArr[i + 1] == 'u' && cArr[i + 2] == 'l' && cArr[i + 3] == 'l') {
                            return 66;
                        }
                    case 't':
                        switch (cArr[i + 1]) {
                            case 'h':
                                if (cArr[i + 2] == 'i' && cArr[i + 3] == 's') {
                                    return 67;
                                }
                            case 'r':
                                if (cArr[i + 2] == 'u' && cArr[i + 3] == 'e') {
                                    return 68;
                                }
                            default:
                                break;
                        }
                    case 'v':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'i' && cArr[i + 3] == 'd') {
                            return 69;
                        }
                    case 'w':
                        if (cArr[i + 1] == 'i' && cArr[i + 2] == 't' && cArr[i + 3] == 'h') {
                            return 106;
                        }
                    default:
                        break;
                }
            case 5:
                switch (cArr[i]) {
                    case 'b':
                        if (cArr[i + 1] == 'r' && cArr[i + 2] == 'e' && cArr[i + 3] == 'a' && cArr[i + 4] == 'k') {
                            return 70;
                        }
                    case 'c':
                        switch (cArr[i + 1]) {
                            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                if (cArr[i + 2] == 't' && cArr[i + 3] == 'c' && cArr[i + 4] == 'h') {
                                    return 71;
                                }
                            default:
                                break;
                        }
                    case 'f':
                        switch (cArr[i + 1]) {
                            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                if (cArr[i + 2] == 'l' && cArr[i + 3] == 's' && cArr[i + 4] == 'e') {
                                    return 74;
                                }
                            case 'l':
                                if (cArr[i + 2] == 'o' && cArr[i + 3] == 'a' && cArr[i + 4] == 't') {
                                    return 76;
                                }
                            default:
                                break;
                        }
                    case 't':
                        if (cArr[i + 1] == 'h' && cArr[i + 2] == 'r' && cArr[i + 3] == 'o' && cArr[i + 4] == 'w') {
                            return 79;
                        }
                    case 'w':
                        if (cArr[i + 1] == 'h' && cArr[i + 2] == 'i' && cArr[i + 3] == 'l' && cArr[i + 4] == 'e') {
                            return 80;
                        }
                    default:
                        break;
                }
            case 6:
                switch (cArr[i]) {
                    case 'd':
                        switch (cArr[i + 1]) {
                            case 'e':
                                if (cArr[i + 2] == 'l' && cArr[i + 3] == 'e' && cArr[i + 4] == 't' && cArr[i + 5] == 'e') {
                                    return 118;
                                }
                            default:
                                break;
                        }
                    case 'i':
                        if (cArr[i + 1] == 'm' && cArr[i + 2] == 'p' && cArr[i + 3] == 'o' && cArr[i + 4] == 'r' && cArr[i + 5] == 't') {
                            return 82;
                        }
                    case 'r':
                        if (cArr[i + 1] == 'e' && cArr[i + 2] == 't' && cArr[i + 3] == 'u' && cArr[i + 4] == 'r' && cArr[i + 5] == 'n') {
                            return 85;
                        }
                    case 's':
                        switch (cArr[i + 1]) {
                            case 'w':
                                if (cArr[i + 2] == 'i' && cArr[i + 3] == 't' && cArr[i + 4] == 'c' && cArr[i + 5] == 'h') {
                                    return 87;
                                }
                            default:
                                break;
                        }
                    case 't':
                        switch (cArr[i + 1]) {
                            case 'y':
                                if (cArr[i + 2] == 'p' && cArr[i + 3] == 'e' && cArr[i + 4] == 'o') {
                                    if (cArr[i + 5] != 'f') {
                                        break;
                                    }
                                    return 105;
                                }
                            default:
                                break;
                        }
                    default:
                        break;
                }
            case 7:
                switch (cArr[i]) {
                    case 'd':
                        if (cArr[i + 1] == 'e' && cArr[i + 2] == 'f' && cArr[i + 3] == 'a' && cArr[i + 4] == 'u' && cArr[i + 5] == 'l' && cArr[i + 6] == 't') {
                            return 90;
                        }
                    case 'e':
                        if (cArr[i + 1] == 'x' && cArr[i + 2] == 't' && cArr[i + 3] == 'e' && cArr[i + 4] == 'n' && cArr[i + 5] == 'd' && cArr[i + 6] == 's') {
                            return 91;
                        }
                    case 'f':
                        if (cArr[i + 1] == 'i' && cArr[i + 2] == 'n' && cArr[i + 3] == 'a' && cArr[i + 4] == 'l' && cArr[i + 5] == 'l' && cArr[i + 6] == 'y') {
                            return 92;
                        }
                    default:
                        break;
                }
            case 8:
                switch (cArr[i]) {
                    case 'f':
                        if (cArr[i + 1] == 'u' && cArr[i + 2] == 'n' && cArr[i + 3] == 'c' && cArr[i + 4] == 't' && cArr[i + 5] == 'i' && cArr[i + 6] == 'o' && cArr[i + 7] == 'n') {
                            return 97;
                        }
                    default:
                        break;
                }
            case 10:
                switch (cArr[i]) {
                    case 'i':
                        switch (cArr[i + 1]) {
                            case 'n':
                                if (cArr[i + 2] == 's' && cArr[i + 3] == 't' && cArr[i + 4] == 'a' && cArr[i + 5] == 'n' && cArr[i + 6] == 'c' && cArr[i + 7] == 'e' && cArr[i + 8] == 'o' && cArr[i + 9] == 'f') {
                                    return 103;
                                }
                            default:
                                break;
                        }
                    default:
                        break;
                }
            case 12:
                if (cArr[i] == 's' && cArr[i + 1] == 'y' && cArr[i + 2] == 'n' && cArr[i + 3] == 'c' && cArr[i + 4] == 'h' && cArr[i + 5] == 'r' && cArr[i + 6] == 'o' && cArr[i + 7] == 'n' && cArr[i + 8] == 'i' && cArr[i + 9] == 'z' && cArr[i + 10] == 'e' && cArr[i + 11] == 'd') {
                    return 104;
                }
        }
        return -1;
    }

    private void j6(int i, int i2, int i3) {
        if (!this.VH) {
            return;
        }
        if (i3 == -1) {
            this.j6.Zo(this.u7, this.FH, i, i2, i, i2 + 1, "Unexpected end of file", 0);
        } else if (i3 == 10) {
            this.j6.Zo(this.u7, this.FH, i, i2, i, i2 + 1, "Unexpected end of line", 0);
        } else {
            this.j6.Zo(this.u7, this.FH, i, i2, i, i2 + 1, "Unexpected " + ((char) i3), 0);
            this.j6.j6(this.u7, this.FH, i, i2, i, i2 + 1, "", "Delete");
        }
    }

    private void DW(int i, int i2, int i3) {
        if (!this.gn) {
            return;
        }
        if (i3 == -1) {
            this.j6.Zo(this.u7, this.Hw, i, i2, i, i2 + 1, "Unexpected end of file", 0);
        } else if (i3 == 10) {
            this.j6.Zo(this.u7, this.Hw, i, i2, i, i2 + 1, "Unexpected end of line", 0);
        } else {
            this.j6.Zo(this.u7, this.Hw, i, i2, i, i2 + 1, "Unexpected " + ((char) i3), 0);
            this.j6.j6(this.u7, this.Hw, i, i2, i, i2 + 1, "", "Delete");
        }
    }
}
