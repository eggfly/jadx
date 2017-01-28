import com.aide.uidesigner.ProxyTextView;

public class gy {
    private by DW;
    private char[] EQ;
    private final boolean FH;
    private bj Hw;
    private gy$a J0;
    private ev J8;
    private int[] VH;
    private char[] Zo;
    private bv gn;
    private bu j6;
    private boolean tp;
    private boolean u7;
    private bj v5;
    private boolean we;

    public gy(by byVar, bu buVar, boolean z, bj bjVar, bj bjVar2) {
        this.Zo = new char[10000];
        this.VH = new int[10000];
        this.EQ = new char[1000];
        this.we = true;
        this.J0 = new gy$a();
        this.J8 = new ev();
        this.j6 = buVar;
        this.DW = byVar;
        this.FH = z;
        this.Hw = bjVar;
        this.v5 = bjVar2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(bv r32, java.io.Reader r33, boolean r34, boolean r35, boolean r36, boolean r37, cm r38, cm r39) {
        /*
        r31 = this;
        r0 = r34;
        r1 = r31;
        r1.u7 = r0;
        r0 = r35;
        r1 = r31;
        r1.tp = r0;
        r0 = r32;
        r1 = r31;
        r1.gn = r0;
        r0 = r31;
        r5 = r0.J8;
        r0 = r33;
        r5.j6(r0);
        r0 = r31;
        r5 = r0.J0;
        r0 = r31;
        r6 = r0.J8;
        r0 = r31;
        r7 = r0.we;
        r5.j6(r6, r7);
        r0 = r31;
        r5 = r0.J0;
        r0 = r31;
        r6 = r0.VH;
        r0 = r31;
        r7 = r0.Zo;
        r8 = 0;
        r0 = r31;
        r9 = r0.Zo;
        r9 = r9.length;
        r23 = r5.j6(r6, r7, r8, r9);
        r22 = 0;
        r21 = 0;
        r0 = r31;
        r0 = r0.VH;
        r20 = r0;
        r0 = r31;
        r0 = r0.Zo;
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
            case 1: goto L_0x0946;
            case 2: goto L_0x0993;
            case 3: goto L_0x09bc;
            case 4: goto L_0x09e1;
            case 5: goto L_0x0a38;
            case 6: goto L_0x0aa2;
            case 7: goto L_0x0ae5;
            case 8: goto L_0x0b78;
            case 9: goto L_0x0bdc;
            case 10: goto L_0x0c5a;
            case 11: goto L_0x0c88;
            case 12: goto L_0x0cd8;
            case 13: goto L_0x0d1e;
            case 14: goto L_0x0d78;
            case 15: goto L_0x0dc8;
            case 16: goto L_0x0e18;
            case 17: goto L_0x0e46;
            case 18: goto L_0x0e4e;
            case 19: goto L_0x0e56;
            case 20: goto L_0x0e5e;
            case 21: goto L_0x0e66;
            case 22: goto L_0x0e6e;
            case 23: goto L_0x0e76;
            case 24: goto L_0x0e7e;
            case 25: goto L_0x0867;
            case 26: goto L_0x0e86;
            case 27: goto L_0x0ea0;
            case 28: goto L_0x0ea8;
            case 29: goto L_0x0eb0;
            case 30: goto L_0x0ecf;
            case 31: goto L_0x0ed7;
            case 32: goto L_0x0edf;
            case 33: goto L_0x0ee7;
            case 34: goto L_0x0eef;
            case 35: goto L_0x0ef7;
            case 36: goto L_0x0f16;
            case 37: goto L_0x0f1e;
            case 38: goto L_0x0f26;
            case 39: goto L_0x0f40;
            case 40: goto L_0x0f48;
            case 41: goto L_0x0f62;
            case 42: goto L_0x0f6a;
            case 43: goto L_0x0f84;
            case 44: goto L_0x0f8c;
            case 45: goto L_0x0fa6;
            case 46: goto L_0x0fae;
            case 47: goto L_0x0fcd;
            case 48: goto L_0x0fd5;
            case 49: goto L_0x0fdd;
            case 50: goto L_0x0ffc;
            case 51: goto L_0x1004;
            case 52: goto L_0x1077;
            case 53: goto L_0x1096;
            case 54: goto L_0x109e;
            case 55: goto L_0x10b3;
            case 56: goto L_0x10bb;
            case 57: goto L_0x10da;
            case 58: goto L_0x10e2;
            case 59: goto L_0x1101;
            case 60: goto L_0x1109;
            case 61: goto L_0x111e;
            case 62: goto L_0x1126;
            case 63: goto L_0x1193;
            case 64: goto L_0x11ea;
            case 65: goto L_0x1262;
            case 66: goto L_0x12a5;
            case 67: goto L_0x12cc;
            case 68: goto L_0x12e6;
            case 69: goto L_0x1300;
            case 70: goto L_0x131a;
            case 71: goto L_0x100c;
            case 72: goto L_0x102b;
            case 73: goto L_0x106f;
            case 74: goto L_0x1353;
            case 75: goto L_0x0099;
            case 76: goto L_0x135b;
            case 77: goto L_0x13a2;
            case 78: goto L_0x0099;
            case 79: goto L_0x0099;
            case 80: goto L_0x0c40;
            case 81: goto L_0x1219;
            case 82: goto L_0x1248;
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
            case 64: goto L_0x0766;
            case 65: goto L_0x0800;
            case 66: goto L_0x0800;
            case 67: goto L_0x0800;
            case 68: goto L_0x0800;
            case 69: goto L_0x0800;
            case 70: goto L_0x0800;
            case 71: goto L_0x0800;
            case 72: goto L_0x0800;
            case 73: goto L_0x0800;
            case 74: goto L_0x0800;
            case 75: goto L_0x0800;
            case 76: goto L_0x0800;
            case 77: goto L_0x0800;
            case 78: goto L_0x0800;
            case 79: goto L_0x0800;
            case 80: goto L_0x0800;
            case 81: goto L_0x0800;
            case 82: goto L_0x0800;
            case 83: goto L_0x0800;
            case 84: goto L_0x0800;
            case 85: goto L_0x0800;
            case 86: goto L_0x0800;
            case 87: goto L_0x0800;
            case 88: goto L_0x0800;
            case 89: goto L_0x0800;
            case 90: goto L_0x0800;
            case 91: goto L_0x02e6;
            case 92: goto L_0x00be;
            case 93: goto L_0x0318;
            case 94: goto L_0x0604;
            case 95: goto L_0x00be;
            case 96: goto L_0x00be;
            case 97: goto L_0x07d0;
            case 98: goto L_0x07d0;
            case 99: goto L_0x07d0;
            case 100: goto L_0x07d0;
            case 101: goto L_0x07d0;
            case 102: goto L_0x07d0;
            case 103: goto L_0x07d0;
            case 104: goto L_0x07d0;
            case 105: goto L_0x07d0;
            case 106: goto L_0x07d0;
            case 107: goto L_0x07d0;
            case 108: goto L_0x07d0;
            case 109: goto L_0x07d0;
            case 110: goto L_0x07d0;
            case 111: goto L_0x07d0;
            case 112: goto L_0x07d0;
            case 113: goto L_0x07d0;
            case 114: goto L_0x07d0;
            case 115: goto L_0x07d0;
            case 116: goto L_0x07d0;
            case 117: goto L_0x07d0;
            case 118: goto L_0x07d0;
            case 119: goto L_0x07d0;
            case 120: goto L_0x07d0;
            case 121: goto L_0x07d0;
            case 122: goto L_0x07d0;
            case 123: goto L_0x0282;
            case 124: goto L_0x0668;
            case 125: goto L_0x02b4;
            case 126: goto L_0x04a6;
            default: goto L_0x00be;
        };
    L_0x00be:
        r27 = java.lang.Character.isJavaIdentifierStart(r27);
        if (r27 == 0) goto L_0x0830;
    L_0x00c4:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        if (r0 != r1) goto L_0x13c6;
    L_0x0108:
        r0 = r31;
        r0 = r0.J0;
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
        r10 = r0.J8;
        r17 = 1;
        r0 = r21;
        r1 = r17;
        r10 = r10.j6(r0, r1);
        r16[r12] = r10;
        r0 = r31;
        r10 = r0.J8;
        r16 = 1;
        r0 = r21;
        r1 = r16;
        r10 = r10.DW(r0, r1);
        r14[r12] = r10;
        r0 = r31;
        r10 = r0.J8;
        r14 = 1;
        r0 = r21;
        r10 = r10.j6(r0, r14);
        r15[r12] = r10;
        r0 = r31;
        r10 = r0.J8;
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
        r10 = r0.J8;
        r11 = 1;
        r0 = r21;
        r10 = r10.j6(r0, r11);
        r9[r5] = r10;
        r0 = r31;
        r9 = r0.J8;
        r10 = 1;
        r0 = r21;
        r9 = r9.DW(r0, r10);
        r7[r5] = r9;
        r0 = r31;
        r7 = r0.J8;
        r9 = 1;
        r0 = r21;
        r7 = r7.j6(r0, r9);
        r8[r5] = r7;
        r0 = r31;
        r7 = r0.J8;
        r8 = 1;
        r0 = r21;
        r7 = r7.DW(r0, r8);
        r6[r5] = r7;
        r5 = r5 + 1;
        r0 = r39;
        r0.u7 = r5;
        r0 = r20;
        r1 = r31;
        r1.VH = r0;
        r0 = r19;
        r1 = r31;
        r1.Zo = r0;
        r0 = r31;
        r5 = r0.J0;
        r5.j6();
        r5 = 0;
        r0 = r31;
        r0.gn = r5;
        return;
    L_0x01ca:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r9[r5] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
        r0 = r0.FH;
        r24 = r0;
        if (r24 == 0) goto L_0x079e;
    L_0x076e:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 76;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x079e:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r26 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r26;
        r24 = r0.DW(r1, r2);
        r14[r12] = r24;
        r24 = 74;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x07d0:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0800:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r16[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0830:
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0867:
        switch(r26) {
            case 32: goto L_0x08ee;
            case 33: goto L_0x086a;
            case 34: goto L_0x086a;
            case 35: goto L_0x086a;
            case 36: goto L_0x086a;
            case 37: goto L_0x086a;
            case 38: goto L_0x086a;
            case 39: goto L_0x086a;
            case 40: goto L_0x08ee;
            case 41: goto L_0x086a;
            case 42: goto L_0x086a;
            case 43: goto L_0x086a;
            case 44: goto L_0x08ee;
            case 45: goto L_0x086a;
            case 46: goto L_0x08ee;
            case 47: goto L_0x086a;
            case 48: goto L_0x086a;
            case 49: goto L_0x086a;
            case 50: goto L_0x086a;
            case 51: goto L_0x086a;
            case 52: goto L_0x086a;
            case 53: goto L_0x086a;
            case 54: goto L_0x086a;
            case 55: goto L_0x086a;
            case 56: goto L_0x086a;
            case 57: goto L_0x086a;
            case 58: goto L_0x086a;
            case 59: goto L_0x086a;
            case 60: goto L_0x086a;
            case 61: goto L_0x086a;
            case 62: goto L_0x086a;
            case 63: goto L_0x086a;
            case 64: goto L_0x086a;
            case 65: goto L_0x08e4;
            case 66: goto L_0x08e4;
            case 67: goto L_0x08e4;
            case 68: goto L_0x08e4;
            case 69: goto L_0x08e4;
            case 70: goto L_0x08e4;
            case 71: goto L_0x08e4;
            case 72: goto L_0x08e4;
            case 73: goto L_0x08e4;
            case 74: goto L_0x08e4;
            case 75: goto L_0x08e4;
            case 76: goto L_0x08e4;
            case 77: goto L_0x08e4;
            case 78: goto L_0x08e4;
            case 79: goto L_0x08e4;
            case 80: goto L_0x08e4;
            case 81: goto L_0x08e4;
            case 82: goto L_0x08e4;
            case 83: goto L_0x08e4;
            case 84: goto L_0x08e4;
            case 85: goto L_0x08e4;
            case 86: goto L_0x08e4;
            case 87: goto L_0x08e4;
            case 88: goto L_0x08e4;
            case 89: goto L_0x08e4;
            case 90: goto L_0x08e4;
            case 91: goto L_0x08ee;
            case 92: goto L_0x086a;
            case 93: goto L_0x086a;
            case 94: goto L_0x086a;
            case 95: goto L_0x086a;
            case 96: goto L_0x086a;
            case 97: goto L_0x08dc;
            case 98: goto L_0x08dc;
            case 99: goto L_0x08dc;
            case 100: goto L_0x08dc;
            case 101: goto L_0x08dc;
            case 102: goto L_0x08dc;
            case 103: goto L_0x08dc;
            case 104: goto L_0x08dc;
            case 105: goto L_0x08dc;
            case 106: goto L_0x08dc;
            case 107: goto L_0x08dc;
            case 108: goto L_0x08dc;
            case 109: goto L_0x08dc;
            case 110: goto L_0x08dc;
            case 111: goto L_0x08dc;
            case 112: goto L_0x08dc;
            case 113: goto L_0x08dc;
            case 114: goto L_0x08dc;
            case 115: goto L_0x08dc;
            case 116: goto L_0x08dc;
            case 117: goto L_0x08dc;
            case 118: goto L_0x08dc;
            case 119: goto L_0x08dc;
            case 120: goto L_0x08dc;
            case 121: goto L_0x08dc;
            case 122: goto L_0x08dc;
            default: goto L_0x086a;
        };
    L_0x086a:
        r24 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r24 != 0) goto L_0x093c;
    L_0x0870:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r26 = r0.DW(r1, r2, r3);
        r27 = -1;
        r0 = r26;
        r1 = r27;
        if (r0 == r1) goto L_0x0922;
    L_0x0886:
        r18[r12] = r26;
    L_0x0888:
        r24 = 0;
    L_0x088a:
        if (r24 == 0) goto L_0x1469;
    L_0x088c:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 0;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r8[r5] = r24;
        r0 = r31;
        r0 = r0.J8;
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
    L_0x08bd:
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
    L_0x08dc:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x08e4:
        r24 = 1;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x08ee:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r26 = r0.DW(r1, r2, r3);
        r27 = -1;
        r0 = r26;
        r1 = r27;
        if (r0 == r1) goto L_0x0909;
    L_0x0904:
        r18[r12] = r26;
    L_0x0906:
        r24 = 0;
        goto L_0x088a;
    L_0x0909:
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
        goto L_0x0906;
    L_0x0922:
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
        goto L_0x0888;
    L_0x093c:
        r24 = 1;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0946:
        switch(r26) {
            case 32: goto L_0x0975;
            case 33: goto L_0x0949;
            case 34: goto L_0x0949;
            case 35: goto L_0x0949;
            case 36: goto L_0x0949;
            case 37: goto L_0x0949;
            case 38: goto L_0x0949;
            case 39: goto L_0x0949;
            case 40: goto L_0x0975;
            case 41: goto L_0x0949;
            case 42: goto L_0x0949;
            case 43: goto L_0x0949;
            case 44: goto L_0x0975;
            case 45: goto L_0x0949;
            case 46: goto L_0x0975;
            case 47: goto L_0x0949;
            case 48: goto L_0x0949;
            case 49: goto L_0x0949;
            case 50: goto L_0x0949;
            case 51: goto L_0x0949;
            case 52: goto L_0x0949;
            case 53: goto L_0x0949;
            case 54: goto L_0x0949;
            case 55: goto L_0x0949;
            case 56: goto L_0x0949;
            case 57: goto L_0x0949;
            case 58: goto L_0x0949;
            case 59: goto L_0x0949;
            case 60: goto L_0x0949;
            case 61: goto L_0x0949;
            case 62: goto L_0x0949;
            case 63: goto L_0x0949;
            case 64: goto L_0x0949;
            case 65: goto L_0x096d;
            case 66: goto L_0x096d;
            case 67: goto L_0x096d;
            case 68: goto L_0x096d;
            case 69: goto L_0x096d;
            case 70: goto L_0x096d;
            case 71: goto L_0x096d;
            case 72: goto L_0x096d;
            case 73: goto L_0x096d;
            case 74: goto L_0x096d;
            case 75: goto L_0x096d;
            case 76: goto L_0x096d;
            case 77: goto L_0x096d;
            case 78: goto L_0x096d;
            case 79: goto L_0x096d;
            case 80: goto L_0x096d;
            case 81: goto L_0x096d;
            case 82: goto L_0x096d;
            case 83: goto L_0x096d;
            case 84: goto L_0x096d;
            case 85: goto L_0x096d;
            case 86: goto L_0x096d;
            case 87: goto L_0x096d;
            case 88: goto L_0x096d;
            case 89: goto L_0x096d;
            case 90: goto L_0x096d;
            case 91: goto L_0x0975;
            case 92: goto L_0x0949;
            case 93: goto L_0x0949;
            case 94: goto L_0x0949;
            case 95: goto L_0x0949;
            case 96: goto L_0x0949;
            case 97: goto L_0x096d;
            case 98: goto L_0x096d;
            case 99: goto L_0x096d;
            case 100: goto L_0x096d;
            case 101: goto L_0x096d;
            case 102: goto L_0x096d;
            case 103: goto L_0x096d;
            case 104: goto L_0x096d;
            case 105: goto L_0x096d;
            case 106: goto L_0x096d;
            case 107: goto L_0x096d;
            case 108: goto L_0x096d;
            case 109: goto L_0x096d;
            case 110: goto L_0x096d;
            case 111: goto L_0x096d;
            case 112: goto L_0x096d;
            case 113: goto L_0x096d;
            case 114: goto L_0x096d;
            case 115: goto L_0x096d;
            case 116: goto L_0x096d;
            case 117: goto L_0x096d;
            case 118: goto L_0x096d;
            case 119: goto L_0x096d;
            case 120: goto L_0x096d;
            case 121: goto L_0x096d;
            case 122: goto L_0x096d;
            default: goto L_0x0949;
        };
    L_0x0949:
        r26 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r26 != 0) goto L_0x14c5;
    L_0x094f:
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
        goto L_0x088a;
    L_0x096d:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0975:
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
        goto L_0x088a;
    L_0x0993:
        switch(r26) {
            case 42: goto L_0x09a8;
            case 47: goto L_0x099e;
            case 61: goto L_0x09b2;
            default: goto L_0x0996;
        };
    L_0x0996:
        r24 = 19;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x099e:
        r24 = 3;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09a8:
        r24 = 4;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09b2:
        r24 = 28;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09bc:
        switch(r26) {
            case -1: goto L_0x09c7;
            case 10: goto L_0x09c7;
            default: goto L_0x09bf;
        };
    L_0x09bf:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09c7:
        if (r37 == 0) goto L_0x09d9;
    L_0x09c9:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x09d9:
        r24 = 1;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x088a;
    L_0x09e1:
        switch(r26) {
            case -1: goto L_0x09ef;
            case 42: goto L_0x09ec;
            default: goto L_0x09e4;
        };
    L_0x09e4:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x09ec:
        r24 = 5;
        goto L_0x09e4;
    L_0x09ef:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r27 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r27;
        r24 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
        if (r37 == 0) goto L_0x0a30;
    L_0x0a20:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x0a30:
        r24 = 2;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x088a;
    L_0x0a38:
        switch(r26) {
            case -1: goto L_0x0a59;
            case 42: goto L_0x0a4f;
            case 47: goto L_0x0a45;
            default: goto L_0x0a3b;
        };
    L_0x0a3b:
        r24 = 4;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a45:
        r24 = 80;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a4f:
        r24 = 5;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0a59:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r27 = 1;
        r0 = r24;
        r1 = r21;
        r2 = r27;
        r24 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
        if (r37 == 0) goto L_0x0a9a;
    L_0x0a8a:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x0a9a:
        r24 = 2;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x088a;
    L_0x0aa2:
        switch(r26) {
            case -1: goto L_0x0ab3;
            case 10: goto L_0x0ab3;
            case 34: goto L_0x0aad;
            case 92: goto L_0x0ab0;
            default: goto L_0x0aa5;
        };
    L_0x0aa5:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0aad:
        r24 = 10;
        goto L_0x0aa5;
    L_0x0ab0:
        r24 = 7;
        goto L_0x0aa5;
    L_0x0ab3:
        r24 = 10;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
        goto L_0x0aa5;
    L_0x0ae5:
        switch(r26) {
            case -1: goto L_0x0b21;
            case 10: goto L_0x0b21;
            case 34: goto L_0x0b5a;
            case 39: goto L_0x0b5a;
            case 48: goto L_0x0b64;
            case 49: goto L_0x0b64;
            case 50: goto L_0x0b64;
            case 51: goto L_0x0b64;
            case 52: goto L_0x0b6e;
            case 53: goto L_0x0b6e;
            case 54: goto L_0x0b6e;
            case 55: goto L_0x0b6e;
            case 92: goto L_0x0b5a;
            case 98: goto L_0x0b5a;
            case 102: goto L_0x0b5a;
            case 110: goto L_0x0b5a;
            case 114: goto L_0x0b5a;
            case 116: goto L_0x0b5a;
            default: goto L_0x0ae8;
        };
    L_0x0ae8:
        r24 = 6;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0b21:
        r24 = 10;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0b5a:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b64:
        r24 = 8;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b6e:
        r24 = 9;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b78:
        switch(r26) {
            case -1: goto L_0x0b85;
            case 10: goto L_0x0b85;
            case 34: goto L_0x0bbe;
            case 48: goto L_0x0bd2;
            case 49: goto L_0x0bd2;
            case 50: goto L_0x0bd2;
            case 51: goto L_0x0bd2;
            case 52: goto L_0x0bd2;
            case 53: goto L_0x0bd2;
            case 54: goto L_0x0bd2;
            case 55: goto L_0x0bd2;
            case 92: goto L_0x0bc8;
            default: goto L_0x0b7b;
        };
    L_0x0b7b:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0b85:
        r24 = 10;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0bbe:
        r24 = 10;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bc8:
        r24 = 7;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bd2:
        r24 = 9;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0bdc:
        switch(r26) {
            case -1: goto L_0x0be9;
            case 10: goto L_0x0be9;
            case 34: goto L_0x0c22;
            case 48: goto L_0x0c36;
            case 49: goto L_0x0c36;
            case 50: goto L_0x0c36;
            case 51: goto L_0x0c36;
            case 52: goto L_0x0c36;
            case 53: goto L_0x0c36;
            case 54: goto L_0x0c36;
            case 55: goto L_0x0c36;
            case 92: goto L_0x0c2c;
            default: goto L_0x0bdf;
        };
    L_0x0bdf:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0be9:
        r24 = 10;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0c22:
        r24 = 10;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c2c:
        r24 = 7;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c36:
        r24 = 6;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c40:
        if (r37 == 0) goto L_0x0c52;
    L_0x0c42:
        r24 = r22 - r25;
        r0 = r39;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r10[r5] = r24;
    L_0x0c52:
        r24 = 2;
        r11[r5] = r24;
        r24 = 1;
        goto L_0x088a;
    L_0x0c5a:
        if (r36 == 0) goto L_0x0c80;
    L_0x0c5c:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r0 = r31;
        r0 = r0.EQ;
        r25 = r0;
        r26 = 0;
        r0 = r38;
        r1 = r25;
        r2 = r26;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x0c80:
        r24 = 2;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0c88:
        switch(r26) {
            case 39: goto L_0x0c9f;
            case 92: goto L_0x0c95;
            default: goto L_0x0c8b;
        };
    L_0x0c8b:
        r24 = 12;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c95:
        r24 = 13;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0c9f:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0cd8:
        switch(r26) {
            case 39: goto L_0x0d14;
            default: goto L_0x0cdb;
        };
    L_0x0cdb:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0d14:
        r24 = 16;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d1e:
        switch(r26) {
            case 34: goto L_0x0d5a;
            case 39: goto L_0x0d5a;
            case 48: goto L_0x0d64;
            case 49: goto L_0x0d64;
            case 50: goto L_0x0d64;
            case 51: goto L_0x0d64;
            case 52: goto L_0x0d6e;
            case 53: goto L_0x0d6e;
            case 54: goto L_0x0d6e;
            case 55: goto L_0x0d6e;
            case 92: goto L_0x0d5a;
            case 98: goto L_0x0d5a;
            case 102: goto L_0x0d5a;
            case 110: goto L_0x0d5a;
            case 114: goto L_0x0d5a;
            case 116: goto L_0x0d5a;
            default: goto L_0x0d21;
        };
    L_0x0d21:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0d5a:
        r24 = 12;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d64:
        r24 = 14;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d6e:
        r24 = 15;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0d78:
        switch(r26) {
            case 39: goto L_0x0dbe;
            case 40: goto L_0x0d7b;
            case 41: goto L_0x0d7b;
            case 42: goto L_0x0d7b;
            case 43: goto L_0x0d7b;
            case 44: goto L_0x0d7b;
            case 45: goto L_0x0d7b;
            case 46: goto L_0x0d7b;
            case 47: goto L_0x0d7b;
            case 48: goto L_0x0db4;
            case 49: goto L_0x0db4;
            case 50: goto L_0x0db4;
            case 51: goto L_0x0db4;
            case 52: goto L_0x0db4;
            case 53: goto L_0x0db4;
            case 54: goto L_0x0db4;
            case 55: goto L_0x0db4;
            default: goto L_0x0d7b;
        };
    L_0x0d7b:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0db4:
        r24 = 15;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0dbe:
        r24 = 16;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0dc8:
        switch(r26) {
            case 39: goto L_0x0e0e;
            case 40: goto L_0x0dcb;
            case 41: goto L_0x0dcb;
            case 42: goto L_0x0dcb;
            case 43: goto L_0x0dcb;
            case 44: goto L_0x0dcb;
            case 45: goto L_0x0dcb;
            case 46: goto L_0x0dcb;
            case 47: goto L_0x0dcb;
            case 48: goto L_0x0e04;
            case 49: goto L_0x0e04;
            case 50: goto L_0x0e04;
            case 51: goto L_0x0e04;
            case 52: goto L_0x0e04;
            case 53: goto L_0x0e04;
            case 54: goto L_0x0e04;
            case 55: goto L_0x0e04;
            default: goto L_0x0dcb;
        };
    L_0x0dcb:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x0e04:
        r24 = 12;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0e0e:
        r24 = 16;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0e18:
        if (r36 == 0) goto L_0x0e3e;
    L_0x0e1a:
        r24 = r22 - r25;
        r0 = r31;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r0 = r31;
        r0 = r0.EQ;
        r25 = r0;
        r26 = 0;
        r0 = r38;
        r1 = r25;
        r2 = r26;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x0e3e:
        r24 = 3;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e46:
        r24 = 8;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e4e:
        r24 = 9;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e56:
        r24 = 10;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e5e:
        r24 = 11;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e66:
        r24 = 12;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e6e:
        r24 = 13;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e76:
        r24 = 14;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e7e:
        r24 = 15;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e86:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0e96;
    L_0x0e8e:
        r24 = 17;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0e96:
        r24 = 27;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ea0:
        r24 = 18;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0ea8:
        r24 = 20;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0eb0:
        switch(r26) {
            case 43: goto L_0x0ebb;
            case 61: goto L_0x0ec5;
            default: goto L_0x0eb3;
        };
    L_0x0eb3:
        r24 = 21;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0ebb:
        r24 = 30;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ec5:
        r24 = 31;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ecf:
        r24 = 22;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0ed7:
        r24 = 23;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0edf:
        r24 = 24;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0ee7:
        r24 = 25;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0eef:
        r24 = 26;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0ef7:
        switch(r26) {
            case 45: goto L_0x0f02;
            case 61: goto L_0x0f0c;
            default: goto L_0x0efa;
        };
    L_0x0efa:
        r24 = 27;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f02:
        r24 = 36;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f0c:
        r24 = 37;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f16:
        r24 = 28;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f1e:
        r24 = 29;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f26:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f36;
    L_0x0f2e:
        r24 = 30;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f36:
        r24 = 39;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f40:
        r24 = 31;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f48:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f58;
    L_0x0f50:
        r24 = 32;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f58:
        r24 = 41;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f62:
        r24 = 33;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f6a:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f7a;
    L_0x0f72:
        r24 = 34;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f7a:
        r24 = 43;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0f84:
        r24 = 35;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f8c:
        r24 = 61;
        r0 = r26;
        r1 = r24;
        if (r0 == r1) goto L_0x0f9c;
    L_0x0f94:
        r24 = 36;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0f9c:
        r24 = 45;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0fa6:
        r24 = 37;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0fae:
        switch(r26) {
            case 38: goto L_0x0fb9;
            case 61: goto L_0x0fc3;
            default: goto L_0x0fb1;
        };
    L_0x0fb1:
        r24 = 41;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0fb9:
        r24 = 47;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0fc3:
        r24 = 48;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0fcd:
        r24 = 42;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0fd5:
        r24 = 43;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0fdd:
        switch(r26) {
            case 61: goto L_0x0ff2;
            case 124: goto L_0x0fe8;
            default: goto L_0x0fe0;
        };
    L_0x0fe0:
        r24 = 38;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x0fe8:
        r24 = 50;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ff2:
        r24 = 51;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x0ffc:
        r24 = 39;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1004:
        r24 = 40;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x100c:
        switch(r26) {
            case 46: goto L_0x1021;
            case 47: goto L_0x100f;
            case 48: goto L_0x1017;
            case 49: goto L_0x1017;
            case 50: goto L_0x1017;
            case 51: goto L_0x1017;
            case 52: goto L_0x1017;
            case 53: goto L_0x1017;
            case 54: goto L_0x1017;
            case 55: goto L_0x1017;
            case 56: goto L_0x1017;
            case 57: goto L_0x1017;
            default: goto L_0x100f;
        };
    L_0x100f:
        r24 = 16;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1017:
        r24 = 65;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1021:
        r24 = 72;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x102b:
        switch(r26) {
            case 46: goto L_0x1065;
            default: goto L_0x102e;
        };
    L_0x102e:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r26 = r0;
        r27 = 1;
        r0 = r26;
        r1 = r21;
        r2 = r27;
        r26 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.DW(r1, r2);
        r0 = r31;
        r1 = r26;
        r2 = r27;
        r0.j6(r1, r2);
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1065:
        r24 = 73;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x106f:
        r24 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1077:
        switch(r26) {
            case 60: goto L_0x1082;
            case 61: goto L_0x108c;
            default: goto L_0x107a;
        };
    L_0x107a:
        r24 = 44;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1082:
        r24 = 54;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x108c:
        r24 = 53;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1096:
        r24 = 45;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x109e:
        switch(r26) {
            case 61: goto L_0x10a9;
            default: goto L_0x10a1;
        };
    L_0x10a1:
        r24 = 46;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x10a9:
        r24 = 55;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10b3:
        r24 = 47;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x10bb:
        switch(r26) {
            case 61: goto L_0x10d0;
            case 62: goto L_0x10c6;
            default: goto L_0x10be;
        };
    L_0x10be:
        r24 = 48;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x10c6:
        r24 = 58;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10d0:
        r24 = 57;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10da:
        r24 = 49;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x10e2:
        switch(r26) {
            case 61: goto L_0x10ed;
            case 62: goto L_0x10f7;
            default: goto L_0x10e5;
        };
    L_0x10e5:
        r24 = 50;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x10ed:
        r24 = 59;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x10f7:
        r24 = 60;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1101:
        r24 = 52;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1109:
        switch(r26) {
            case 61: goto L_0x1114;
            default: goto L_0x110c;
        };
    L_0x110c:
        r24 = 51;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1114:
        r24 = 61;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x111e:
        r24 = 53;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1126:
        switch(r26) {
            case 46: goto L_0x1161;
            case 48: goto L_0x1143;
            case 49: goto L_0x1143;
            case 50: goto L_0x1143;
            case 51: goto L_0x1143;
            case 52: goto L_0x1143;
            case 53: goto L_0x1143;
            case 54: goto L_0x1143;
            case 55: goto L_0x1143;
            case 56: goto L_0x1143;
            case 57: goto L_0x1143;
            case 66: goto L_0x1157;
            case 68: goto L_0x117f;
            case 69: goto L_0x116b;
            case 70: goto L_0x1175;
            case 76: goto L_0x1189;
            case 88: goto L_0x114d;
            case 95: goto L_0x1143;
            case 98: goto L_0x1157;
            case 100: goto L_0x117f;
            case 101: goto L_0x116b;
            case 102: goto L_0x1175;
            case 108: goto L_0x1189;
            case 120: goto L_0x114d;
            default: goto L_0x1129;
        };
    L_0x1129:
        if (r36 == 0) goto L_0x113b;
    L_0x112b:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x113b:
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1143:
        r24 = 63;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x114d:
        r24 = 64;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1157:
        r24 = 81;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1161:
        r24 = 65;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x116b:
        r24 = 66;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1175:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x117f:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1189:
        r24 = 67;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1193:
        switch(r26) {
            case 46: goto L_0x11b8;
            case 48: goto L_0x11b0;
            case 49: goto L_0x11b0;
            case 50: goto L_0x11b0;
            case 51: goto L_0x11b0;
            case 52: goto L_0x11b0;
            case 53: goto L_0x11b0;
            case 54: goto L_0x11b0;
            case 55: goto L_0x11b0;
            case 56: goto L_0x11b0;
            case 57: goto L_0x11b0;
            case 68: goto L_0x11d6;
            case 69: goto L_0x11c2;
            case 70: goto L_0x11cc;
            case 76: goto L_0x11e0;
            case 95: goto L_0x11b0;
            case 100: goto L_0x11d6;
            case 101: goto L_0x11c2;
            case 102: goto L_0x11cc;
            case 108: goto L_0x11e0;
            default: goto L_0x1196;
        };
    L_0x1196:
        if (r36 == 0) goto L_0x11a8;
    L_0x1198:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x11a8:
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x11b0:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11b8:
        r24 = 65;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11c2:
        r24 = 66;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11cc:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11d6:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11e0:
        r24 = 67;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x11ea:
        switch(r26) {
            case 48: goto L_0x1207;
            case 49: goto L_0x1207;
            case 50: goto L_0x1207;
            case 51: goto L_0x1207;
            case 52: goto L_0x1207;
            case 53: goto L_0x1207;
            case 54: goto L_0x1207;
            case 55: goto L_0x1207;
            case 56: goto L_0x1207;
            case 57: goto L_0x1207;
            case 58: goto L_0x11ed;
            case 59: goto L_0x11ed;
            case 60: goto L_0x11ed;
            case 61: goto L_0x11ed;
            case 62: goto L_0x11ed;
            case 63: goto L_0x11ed;
            case 64: goto L_0x11ed;
            case 65: goto L_0x1207;
            case 66: goto L_0x1207;
            case 67: goto L_0x1207;
            case 68: goto L_0x1207;
            case 69: goto L_0x1207;
            case 70: goto L_0x1207;
            case 71: goto L_0x11ed;
            case 72: goto L_0x11ed;
            case 73: goto L_0x11ed;
            case 74: goto L_0x11ed;
            case 75: goto L_0x11ed;
            case 76: goto L_0x120f;
            case 77: goto L_0x11ed;
            case 78: goto L_0x11ed;
            case 79: goto L_0x11ed;
            case 80: goto L_0x11ed;
            case 81: goto L_0x11ed;
            case 82: goto L_0x11ed;
            case 83: goto L_0x11ed;
            case 84: goto L_0x11ed;
            case 85: goto L_0x11ed;
            case 86: goto L_0x11ed;
            case 87: goto L_0x11ed;
            case 88: goto L_0x11ed;
            case 89: goto L_0x11ed;
            case 90: goto L_0x11ed;
            case 91: goto L_0x11ed;
            case 92: goto L_0x11ed;
            case 93: goto L_0x11ed;
            case 94: goto L_0x11ed;
            case 95: goto L_0x1207;
            case 96: goto L_0x11ed;
            case 97: goto L_0x1207;
            case 98: goto L_0x1207;
            case 99: goto L_0x1207;
            case 100: goto L_0x1207;
            case 101: goto L_0x1207;
            case 102: goto L_0x1207;
            case 103: goto L_0x11ed;
            case 104: goto L_0x11ed;
            case 105: goto L_0x11ed;
            case 106: goto L_0x11ed;
            case 107: goto L_0x11ed;
            case 108: goto L_0x120f;
            default: goto L_0x11ed;
        };
    L_0x11ed:
        if (r36 == 0) goto L_0x11ff;
    L_0x11ef:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x11ff:
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1207:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x120f:
        r24 = 67;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1219:
        switch(r26) {
            case 48: goto L_0x1236;
            case 49: goto L_0x1236;
            case 76: goto L_0x123e;
            case 95: goto L_0x1236;
            case 108: goto L_0x123e;
            default: goto L_0x121c;
        };
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
        r24 = 4;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1236:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x123e:
        r24 = 82;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1248:
        if (r36 == 0) goto L_0x125a;
    L_0x124a:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x125a:
        r24 = 5;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1262:
        switch(r26) {
            case 48: goto L_0x127f;
            case 49: goto L_0x127f;
            case 50: goto L_0x127f;
            case 51: goto L_0x127f;
            case 52: goto L_0x127f;
            case 53: goto L_0x127f;
            case 54: goto L_0x127f;
            case 55: goto L_0x127f;
            case 56: goto L_0x127f;
            case 57: goto L_0x127f;
            case 68: goto L_0x129b;
            case 69: goto L_0x1287;
            case 70: goto L_0x1291;
            case 95: goto L_0x127f;
            case 100: goto L_0x129b;
            case 101: goto L_0x1287;
            case 102: goto L_0x1291;
            default: goto L_0x1265;
        };
    L_0x1265:
        if (r36 == 0) goto L_0x1277;
    L_0x1267:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x1277:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x127f:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1287:
        r24 = 66;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1291:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x129b:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x12a5:
        switch(r26) {
            case 43: goto L_0x12c2;
            case 45: goto L_0x12c2;
            case 48: goto L_0x12c2;
            case 49: goto L_0x12c2;
            case 50: goto L_0x12c2;
            case 51: goto L_0x12c2;
            case 52: goto L_0x12c2;
            case 53: goto L_0x12c2;
            case 54: goto L_0x12c2;
            case 55: goto L_0x12c2;
            case 56: goto L_0x12c2;
            case 57: goto L_0x12c2;
            case 95: goto L_0x12c2;
            default: goto L_0x12a8;
        };
    L_0x12a8:
        if (r36 == 0) goto L_0x12ba;
    L_0x12aa:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x12ba:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x12c2:
        r24 = 70;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x12cc:
        if (r36 == 0) goto L_0x12de;
    L_0x12ce:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x12de:
        r24 = 5;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x12e6:
        if (r36 == 0) goto L_0x12f8;
    L_0x12e8:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x12f8:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1300:
        if (r36 == 0) goto L_0x1312;
    L_0x1302:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x1312:
        r24 = 6;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x131a:
        switch(r26) {
            case 48: goto L_0x1337;
            case 49: goto L_0x1337;
            case 50: goto L_0x1337;
            case 51: goto L_0x1337;
            case 52: goto L_0x1337;
            case 53: goto L_0x1337;
            case 54: goto L_0x1337;
            case 55: goto L_0x1337;
            case 56: goto L_0x1337;
            case 57: goto L_0x1337;
            case 68: goto L_0x1349;
            case 70: goto L_0x133f;
            case 95: goto L_0x1337;
            case 100: goto L_0x1349;
            case 102: goto L_0x133f;
            default: goto L_0x131d;
        };
    L_0x131d:
        if (r36 == 0) goto L_0x132f;
    L_0x131f:
        r24 = r22 - r25;
        r0 = r38;
        r1 = r19;
        r2 = r25;
        r3 = r24;
        r24 = r0.j6(r1, r2, r3);
        r17[r12] = r24;
    L_0x132f:
        r24 = 7;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x1337:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x133f:
        r24 = 69;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1349:
        r24 = 68;
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
    L_0x1353:
        r24 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r18[r12] = r24;
        r24 = 0;
        goto L_0x088a;
    L_0x135b:
        r24 = java.lang.Character.isJavaIdentifierStart(r27);
        if (r24 == 0) goto L_0x1369;
    L_0x1361:
        r24 = 77;
        r25 = r24;
        r24 = r22;
        goto L_0x00f2;
    L_0x1369:
        r24 = 0;
        r0 = r31;
        r0 = r0.J8;
        r27 = r0;
        r28 = 1;
        r0 = r27;
        r1 = r21;
        r2 = r28;
        r27 = r0.j6(r1, r2);
        r0 = r31;
        r0 = r0.J8;
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
    L_0x13a2:
        r26 = java.lang.Character.isJavaIdentifierPart(r27);
        if (r26 != 0) goto L_0x14c5;
    L_0x13a8:
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
        goto L_0x088a;
    L_0x13c6:
        r21 = r23 - r24;
        r0 = r19;
        r0 = r0.length;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        if (r0 != r1) goto L_0x14bf;
    L_0x13d3:
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
    L_0x1417:
        if (r24 == 0) goto L_0x1437;
    L_0x1419:
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
    L_0x1437:
        r0 = r31;
        r0 = r0.J0;
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
        if (r0 != r1) goto L_0x1466;
    L_0x145a:
        r19 = r21;
    L_0x145c:
        r24 = 0;
        r23 = r19;
        r19 = r20;
        r20 = r22;
        goto L_0x0125;
    L_0x1466:
        r19 = r19 + r21;
        goto L_0x145c;
    L_0x1469:
        r0 = r31;
        r0 = r0.J8;
        r24 = r0;
        r25 = 0;
        r0 = r24;
        r1 = r21;
        r2 = r25;
        r24 = r0.j6(r1, r2);
        r15[r12] = r24;
        r0 = r31;
        r0 = r0.J8;
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
    L_0x149a:
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
    L_0x14bf:
        r22 = r20;
        r20 = r19;
        goto L_0x1417;
    L_0x14c5:
        r30 = r25;
        r25 = r24;
        r24 = r30;
        goto L_0x00f2;
        */
        throw new UnsupportedOperationException("Method not decompiled: gy.j6(bv, java.io.Reader, boolean, boolean, boolean, boolean, cm, cm):void");
    }

    private int j6(char[] cArr, int i, int i2) {
        if (i2 >= this.EQ.length) {
            Object obj = new char[Math.max((this.EQ.length * 2) + 1, i2)];
            System.arraycopy(this.EQ, 0, obj, 0, this.EQ.length);
            this.EQ = obj;
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
                        this.EQ[i4] = '\"';
                        i3++;
                        break;
                    case '\'':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\'';
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
                            this.EQ[i4] = (char) i6;
                            break;
                        }
                        i5 = i4 + 1;
                        this.EQ[i4] = (char) i6;
                    case '\\':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\\';
                        i3++;
                        break;
                    case 'b':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\b';
                        i3++;
                        break;
                    case 'f':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\f';
                        i3++;
                        break;
                    case 'n':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\n';
                        i3++;
                        break;
                    case 'r':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\r';
                        i3++;
                        break;
                    case 't':
                        i5 = i4 + 1;
                        this.EQ[i4] = '\t';
                        i3++;
                        break;
                    default:
                        i5 = i4;
                        break;
                }
            }
            i5 = i4 + 1;
            this.EQ[i4] = c;
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
                    case 'i':
                        if (cArr[i + 1] == 'n' && cArr[i + 2] == 't') {
                            return 57;
                        }
                    case 'n':
                        if (cArr[i + 1] == 'e' && cArr[i + 2] == 'w') {
                            return 58;
                        }
                    case 't':
                        if (cArr[i + 1] == 'r' && cArr[i + 2] == 'y') {
                            return 59;
                        }
                    default:
                        break;
                }
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                switch (cArr[i]) {
                    case 'b':
                        if (cArr[i + 1] == 'y' && cArr[i + 2] == 't' && cArr[i + 3] == 'e') {
                            return 60;
                        }
                    case 'c':
                        switch (cArr[i + 1]) {
                            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                if (cArr[i + 2] == 's' && cArr[i + 3] == 'e') {
                                    return 61;
                                }
                            case 'h':
                                if (cArr[i + 2] == 'a' && cArr[i + 3] == 'r') {
                                    return 62;
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
                    case 'l':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'n' && cArr[i + 3] == 'g') {
                            return 65;
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
                            case 'l':
                                if (cArr[i + 2] == 'a' && cArr[i + 3] == 's' && cArr[i + 4] == 's') {
                                    return 72;
                                }
                            case 'o':
                                if (cArr[i + 2] == 'n' && cArr[i + 3] == 's' && cArr[i + 4] == 't') {
                                    return 73;
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
                            case 'i':
                                if (cArr[i + 2] == 'n' && cArr[i + 3] == 'a' && cArr[i + 4] == 'l') {
                                    return 75;
                                }
                            case 'l':
                                if (cArr[i + 2] == 'o' && cArr[i + 3] == 'a' && cArr[i + 4] == 't') {
                                    return 76;
                                }
                            default:
                                break;
                        }
                    case 's':
                        switch (cArr[i + 1]) {
                            case 'h':
                                if (cArr[i + 2] == 'o' && cArr[i + 3] == 'r' && cArr[i + 4] == 't') {
                                    return 77;
                                }
                            case 'u':
                                if (cArr[i + 2] == 'p' && cArr[i + 3] == 'e' && cArr[i + 4] == 'r') {
                                    return 78;
                                }
                            default:
                                break;
                        }
                    case 't':
                        if (cArr[i + 1] == 'h' && cArr[i + 2] == 'r' && cArr[i + 3] == 'o' && cArr[i + 4] == 'w') {
                            return 79;
                        }
                    case 'u':
                        if (this.FH && cArr[i + 1] == 'b' && cArr[i + 2] == 'y' && cArr[i + 3] == 't') {
                            if (cArr[i + 4] != 'e') {
                                break;
                            }
                            return 114;
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
                    case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                        if (cArr[i + 1] == 's' && cArr[i + 2] == 's' && cArr[i + 3] == 'e' && cArr[i + 4] == 'r' && cArr[i + 5] == 't') {
                            return 105;
                        }
                    case 'd':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'u' && cArr[i + 3] == 'b' && cArr[i + 4] == 'l' && cArr[i + 5] == 'e') {
                            return 81;
                        }
                    case 'i':
                        if (cArr[i + 1] == 'm' && cArr[i + 2] == 'p' && cArr[i + 3] == 'o' && cArr[i + 4] == 'r' && cArr[i + 5] == 't') {
                            return 82;
                        }
                    case 'n':
                        if (cArr[i + 1] == 'a' && cArr[i + 2] == 't' && cArr[i + 3] == 'i' && cArr[i + 4] == 'v' && cArr[i + 5] == 'e') {
                            return 83;
                        }
                    case 'p':
                        if (cArr[i + 1] == 'u' && cArr[i + 2] == 'b' && cArr[i + 3] == 'l' && cArr[i + 4] == 'i' && cArr[i + 5] == 'c') {
                            return 84;
                        }
                    case 'r':
                        if (cArr[i + 1] == 'e' && cArr[i + 2] == 't' && cArr[i + 3] == 'u' && cArr[i + 4] == 'r' && cArr[i + 5] == 'n') {
                            return 85;
                        }
                    case 's':
                        switch (cArr[i + 1]) {
                            case 't':
                                if (cArr[i + 2] == 'a' && cArr[i + 3] == 't' && cArr[i + 4] == 'i' && cArr[i + 5] == 'c') {
                                    return 86;
                                }
                            case 'w':
                                if (cArr[i + 2] == 'i' && cArr[i + 3] == 't' && cArr[i + 4] == 'c' && cArr[i + 5] == 'h') {
                                    return 87;
                                }
                            default:
                                break;
                        }
                    case 't':
                        if (cArr[i + 1] == 'h' && cArr[i + 2] == 'r' && cArr[i + 3] == 'o' && cArr[i + 4] == 'w' && cArr[i + 5] == 's') {
                            return 88;
                        }
                    default:
                        break;
                }
            case 7:
                switch (cArr[i]) {
                    case 'b':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'o' && cArr[i + 3] == 'l' && cArr[i + 4] == 'e' && cArr[i + 5] == 'a' && cArr[i + 6] == 'n') {
                            return 89;
                        }
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
                    case 'p':
                        switch (cArr[i + 1]) {
                            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                if (cArr[i + 2] == 'c' && cArr[i + 3] == 'k' && cArr[i + 4] == 'a' && cArr[i + 5] == 'g' && cArr[i + 6] == 'e') {
                                    return 93;
                                }
                            case 'r':
                                if (cArr[i + 2] == 'i' && cArr[i + 3] == 'v' && cArr[i + 4] == 'a' && cArr[i + 5] == 't' && cArr[i + 6] == 'e') {
                                    return 94;
                                }
                            default:
                                break;
                        }
                    default:
                        break;
                }
            case 8:
                switch (cArr[i]) {
                    case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                        if (cArr[i + 1] == 'b' && cArr[i + 2] == 's' && cArr[i + 3] == 't' && cArr[i + 4] == 'r' && cArr[i + 5] == 'a' && cArr[i + 6] == 'c' && cArr[i + 7] == 't') {
                            return 95;
                        }
                    case 'c':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'n' && cArr[i + 3] == 't' && cArr[i + 4] == 'i' && cArr[i + 5] == 'n' && cArr[i + 6] == 'u' && cArr[i + 7] == 'e') {
                            return 96;
                        }
                    case 'd':
                        if (this.FH && cArr[i + 1] == 'e' && cArr[i + 2] == 'l' && cArr[i + 3] == 'e' && cArr[i + 4] == 'g' && cArr[i + 5] == 'a' && cArr[i + 6] == 't' && cArr[i + 7] == 'e') {
                            return 118;
                        }
                    case 's':
                        if (cArr[i + 1] == 't' && cArr[i + 2] == 'r' && cArr[i + 3] == 'i' && cArr[i + 4] == 'c' && cArr[i + 5] == 't' && cArr[i + 6] == 'f' && cArr[i + 7] == 'p') {
                            return 97;
                        }
                    case 'v':
                        if (cArr[i + 1] == 'o' && cArr[i + 2] == 'l' && cArr[i + 3] == 'a' && cArr[i + 4] == 't' && cArr[i + 5] == 'i' && cArr[i + 6] == 'l' && cArr[i + 7] == 'e') {
                            return 98;
                        }
                    default:
                        break;
                }
            case 9:
                switch (cArr[i]) {
                    case 'i':
                        if (cArr[i + 1] == 'n' && cArr[i + 2] == 't' && cArr[i + 3] == 'e' && cArr[i + 4] == 'r' && cArr[i + 5] == 'f' && cArr[i + 6] == 'a' && cArr[i + 7] == 'c' && cArr[i + 8] == 'e') {
                            return 99;
                        }
                    case 'm':
                        if (this.FH && cArr[i + 1] == 'u' && cArr[i + 2] == 'l' && cArr[i + 3] == 't' && cArr[i + 4] == 'i' && cArr[i + 5] == 'c' && cArr[i + 6] == 'a' && cArr[i + 7] == 's' && cArr[i + 8] == 't') {
                            return 119;
                        }
                    case 'p':
                        if (cArr[i + 1] == 'r' && cArr[i + 2] == 'o' && cArr[i + 3] == 't' && cArr[i + 4] == 'e' && cArr[i + 5] == 'c' && cArr[i + 6] == 't' && cArr[i + 7] == 'e' && cArr[i + 8] == 'd') {
                            return 100;
                        }
                    case 't':
                        if (cArr[i + 1] == 'r' && cArr[i + 2] == 'a' && cArr[i + 3] == 'n' && cArr[i + 4] == 's' && cArr[i + 5] == 'i' && cArr[i + 6] == 'e' && cArr[i + 7] == 'n' && cArr[i + 8] == 't') {
                            return 101;
                        }
                    default:
                        break;
                }
            case 10:
                switch (cArr[i]) {
                    case 'i':
                        switch (cArr[i + 1]) {
                            case 'm':
                                if (cArr[i + 2] == 'p' && cArr[i + 3] == 'l' && cArr[i + 4] == 'e' && cArr[i + 5] == 'm' && cArr[i + 6] == 'e' && cArr[i + 7] == 'n' && cArr[i + 8] == 't' && cArr[i + 9] == 's') {
                                    return 102;
                                }
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

    private void j6(int i, int i2) {
        if (this.u7) {
            this.j6.Zo(this.gn, this.Hw, i, i2, i, i2 + 1, "Missing .", 0);
        }
    }

    private void j6(int i, int i2, int i3) {
        if (!this.u7) {
            return;
        }
        if (i3 == -1) {
            this.j6.Zo(this.gn, this.Hw, i, i2, i, i2 + 1, "Unexpected end of file", 0);
        } else if (i3 == 10) {
            this.j6.Zo(this.gn, this.Hw, i, i2, i, i2 + 1, "Unexpected end of line", 0);
        } else {
            this.j6.Zo(this.gn, this.Hw, i, i2, i, i2 + 1, "Unexpected " + ((char) i3), 0);
            this.j6.j6(this.gn, this.Hw, i, i2, i, i2 + 1, "", "Delete");
        }
    }

    private void DW(int i, int i2, int i3) {
        if (!this.tp) {
            return;
        }
        if (i3 == -1) {
            this.j6.Zo(this.gn, this.v5, i, i2, i, i2 + 1, "Unexpected end of file", 0);
        } else if (i3 == 10) {
            this.j6.Zo(this.gn, this.v5, i, i2, i, i2 + 1, "Unexpected end of line", 0);
        } else {
            this.j6.Zo(this.gn, this.v5, i, i2, i, i2 + 1, "Unexpected " + ((char) i3), 0);
            this.j6.j6(this.gn, this.v5, i, i2, i, i2 + 1, "", "Delete");
        }
    }
}
