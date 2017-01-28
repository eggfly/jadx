import com.aide.uidesigner.ProxyTextView;

public final class rx {
    public static final rx$c j6;
    private final acu DW;
    private final aai FH;

    static {
        j6 = new rx$a();
    }

    public rx(acu acu, aai aai) {
        if (acu == null) {
            throw new NullPointerException("bytes == null");
        } else if (aai == null) {
            throw new NullPointerException("pool == null");
        } else {
            this.DW = acu;
            this.FH = aai;
        }
    }

    public acu j6() {
        return this.DW;
    }

    public int DW() {
        return this.DW.j6();
    }

    public int FH() {
        return this.DW.j6() + 4;
    }

    public void j6(rx$c rx_c) {
        int i = 0;
        while (i < this.DW.j6()) {
            i += j6(i, rx_c);
        }
    }

    public void j6(int[] iArr, rx$c rx_c) {
        if (rx_c == null) {
            throw new NullPointerException("visitor == null");
        }
        while (true) {
            int Hw = act.Hw(iArr, 0);
            if (Hw >= 0) {
                act.FH(iArr, Hw);
                j6(Hw, rx_c);
                rx_c.j6(Hw);
            } else {
                return;
            }
        }
    }

    public int j6(int i, rx$c rx_c) {
        rx$c rx_c2;
        int i2 = 0;
        if (rx_c == null) {
            rx_c2 = j6;
        } else {
            rx_c2 = rx_c;
        }
        try {
            int v5 = this.DW.v5(i);
            int DW = rw.DW(v5) & 31;
            aah j6;
            switch (v5) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    rx_c2.j6(v5, i, 1, abl.u7);
                    return 1;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    rx_c2.j6(18, i, 1, aav.j6, 0);
                    return 1;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    rx_c2.j6(18, i, 1, aat.j6, -1);
                    return 1;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    rx_c2.j6(18, i, 1, aat.DW, 0);
                    return 1;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    rx_c2.j6(18, i, 1, aat.FH, 1);
                    return 1;
                case 5:
                    rx_c2.j6(18, i, 1, aat.Hw, 2);
                    return 1;
                case 6:
                    rx_c2.j6(18, i, 1, aat.v5, 3);
                    return 1;
                case 7:
                    rx_c2.j6(18, i, 1, aat.Zo, 4);
                    return 1;
                case 8:
                    rx_c2.j6(18, i, 1, aat.VH, 5);
                    return 1;
                case 9:
                    rx_c2.j6(18, i, 1, aaz.j6, 0);
                    return 1;
                case 10:
                    rx_c2.j6(18, i, 1, aaz.DW, 0);
                    return 1;
                case 11:
                    rx_c2.j6(18, i, 1, aas.j6, 0);
                    return 1;
                case 12:
                    rx_c2.j6(18, i, 1, aas.DW, 0);
                    return 1;
                case 13:
                    rx_c2.j6(18, i, 1, aas.FH, 0);
                    return 1;
                case 14:
                    rx_c2.j6(18, i, 1, aap.j6, 0);
                    return 1;
                case 15:
                    rx_c2.j6(18, i, 1, aap.DW, 0);
                    return 1;
                case 16:
                    i2 = this.DW.j6(i + 1);
                    rx_c2.j6(18, i, 2, aat.j6(i2), i2);
                    return 2;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    i2 = this.DW.DW(i + 1);
                    rx_c2.j6(18, i, 3, aat.j6(i2), i2);
                    return 3;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    j6 = this.FH.j6(this.DW.v5(i + 1));
                    if (j6 instanceof aat) {
                        i2 = ((aat) j6).r_();
                    }
                    rx_c2.j6(18, i, 2, j6, i2);
                    return 2;
                case 19:
                    j6 = this.FH.j6(this.DW.Zo(i + 1));
                    if (j6 instanceof aat) {
                        i2 = ((aat) j6).r_();
                    }
                    rx_c2.j6(18, i, 3, j6, i2);
                    return 3;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    rx_c2.j6(20, i, 3, this.FH.j6(this.DW.Zo(i + 1)), 0);
                    return 3;
                case 21:
                    rx_c2.j6(21, i, 2, this.DW.v5(i + 1), abl.Zo, 0);
                    return 2;
                case 22:
                    rx_c2.j6(21, i, 2, this.DW.v5(i + 1), abl.VH, 0);
                    return 2;
                case 23:
                    rx_c2.j6(21, i, 2, this.DW.v5(i + 1), abl.v5, 0);
                    return 2;
                case 24:
                    rx_c2.j6(21, i, 2, this.DW.v5(i + 1), abl.Hw, 0);
                    return 2;
                case 25:
                    rx_c2.j6(21, i, 2, this.DW.v5(i + 1), abl.Ws, 0);
                    return 2;
                case 26:
                case 27:
                case 28:
                case 29:
                    rx_c2.j6(21, i, 1, v5 - 26, abl.Zo, 0);
                    return 1;
                case 30:
                case 31:
                case 32:
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    rx_c2.j6(21, i, 1, v5 - 30, abl.VH, 0);
                    return 1;
                case 34:
                case 35:
                case ProxyTextView.INPUTTYPE_time /*36*/:
                case 37:
                    rx_c2.j6(21, i, 1, v5 - 34, abl.v5, 0);
                    return 1;
                case 38:
                case 39:
                case 40:
                case 41:
                    rx_c2.j6(21, i, 1, v5 - 38, abl.Hw, 0);
                    return 1;
                case 42:
                case 43:
                case 44:
                case 45:
                    rx_c2.j6(21, i, 1, v5 - 42, abl.Ws, 0);
                    return 1;
                case 46:
                    rx_c2.j6(46, i, 1, abl.Zo);
                    return 1;
                case 47:
                    rx_c2.j6(46, i, 1, abl.VH);
                    return 1;
                case 48:
                    rx_c2.j6(46, i, 1, abl.v5);
                    return 1;
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                    rx_c2.j6(46, i, 1, abl.Hw);
                    return 1;
                case 50:
                    rx_c2.j6(46, i, 1, abl.Ws);
                    return 1;
                case 51:
                    rx_c2.j6(46, i, 1, abl.DW);
                    return 1;
                case 52:
                    rx_c2.j6(46, i, 1, abl.FH);
                    return 1;
                case 53:
                    rx_c2.j6(46, i, 1, abl.gn);
                    return 1;
                case 54:
                    rx_c2.j6(54, i, 2, this.DW.v5(i + 1), abl.Zo, 0);
                    return 2;
                case 55:
                    rx_c2.j6(54, i, 2, this.DW.v5(i + 1), abl.VH, 0);
                    return 2;
                case 56:
                    rx_c2.j6(54, i, 2, this.DW.v5(i + 1), abl.v5, 0);
                    return 2;
                case 57:
                    rx_c2.j6(54, i, 2, this.DW.v5(i + 1), abl.Hw, 0);
                    return 2;
                case 58:
                    rx_c2.j6(54, i, 2, this.DW.v5(i + 1), abl.Ws, 0);
                    return 2;
                case 59:
                case 60:
                case 61:
                case 62:
                    rx_c2.j6(54, i, 1, v5 - 59, abl.Zo, 0);
                    return 1;
                case 63:
                case 64:
                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                case 66:
                    rx_c2.j6(54, i, 1, v5 - 63, abl.VH, 0);
                    return 1;
                case 67:
                case 68:
                case 69:
                case 70:
                    rx_c2.j6(54, i, 1, v5 - 67, abl.v5, 0);
                    return 1;
                case 71:
                case 72:
                case 73:
                case 74:
                    rx_c2.j6(54, i, 1, v5 - 71, abl.Hw, 0);
                    return 1;
                case 75:
                case 76:
                case 77:
                case 78:
                    rx_c2.j6(54, i, 1, v5 - 75, abl.Ws, 0);
                    return 1;
                case 79:
                    rx_c2.j6(79, i, 1, abl.Zo);
                    return 1;
                case 80:
                    rx_c2.j6(79, i, 1, abl.VH);
                    return 1;
                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                    rx_c2.j6(79, i, 1, abl.v5);
                    return 1;
                case 82:
                    rx_c2.j6(79, i, 1, abl.Hw);
                    return 1;
                case 83:
                    rx_c2.j6(79, i, 1, abl.Ws);
                    return 1;
                case 84:
                    rx_c2.j6(79, i, 1, abl.DW);
                    return 1;
                case 85:
                    rx_c2.j6(79, i, 1, abl.FH);
                    return 1;
                case 86:
                    rx_c2.j6(79, i, 1, abl.gn);
                    return 1;
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    rx_c2.j6(v5, i, 1, abl.u7);
                    return 1;
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 116:
                case 120:
                case 122:
                case 124:
                case 126:
                case 128:
                case 130:
                    rx_c2.j6(v5, i, 1, abl.Zo);
                    return 1;
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 101:
                case 105:
                case 109:
                case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                case 117:
                case 121:
                case 123:
                case 125:
                case 127:
                case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                case 131:
                    rx_c2.j6(v5 - 1, i, 1, abl.VH);
                    return 1;
                case 98:
                case 102:
                case 106:
                case 110:
                case 114:
                case 118:
                    rx_c2.j6(v5 - 2, i, 1, abl.v5);
                    return 1;
                case 99:
                case 103:
                case 107:
                case 111:
                case 115:
                case 119:
                    rx_c2.j6(v5 - 3, i, 1, abl.Hw);
                    return 1;
                case 132:
                    rx_c2.j6(v5, i, 3, this.DW.v5(i + 1), abl.Zo, this.DW.j6(i + 2));
                    return 3;
                case 133:
                case 140:
                case 143:
                    rx_c2.j6(v5, i, 1, abl.VH);
                    return 1;
                case 134:
                case 137:
                case 144:
                    rx_c2.j6(v5, i, 1, abl.v5);
                    return 1;
                case 135:
                case 138:
                case 141:
                    rx_c2.j6(v5, i, 1, abl.Hw);
                    return 1;
                case 136:
                case 139:
                case 142:
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 190:
                    rx_c2.j6(v5, i, 1, abl.Zo);
                    return 1;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 198:
                case 199:
                    rx_c2.j6(v5, i, 3, this.DW.DW(i + 1) + i);
                    return 3;
                case 169:
                    rx_c2.j6(v5, i, 2, this.DW.v5(i + 1), abl.EQ, 0);
                    return 2;
                case 170:
                    return DW(i, rx_c2);
                case 171:
                    return FH(i, rx_c2);
                case 172:
                    rx_c2.j6(172, i, 1, abl.Zo);
                    return 1;
                case 173:
                    rx_c2.j6(172, i, 1, abl.VH);
                    return 1;
                case 174:
                    rx_c2.j6(172, i, 1, abl.v5);
                    return 1;
                case 175:
                    rx_c2.j6(172, i, 1, abl.Hw);
                    return 1;
                case 176:
                    rx_c2.j6(172, i, 1, abl.Ws);
                    return 1;
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                case 191:
                case 194:
                case 195:
                    rx_c2.j6(v5, i, 1, abl.u7);
                    return 1;
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    rx_c2.j6(v5, i, 3, this.FH.j6(this.DW.Zo(i + 1)), 0);
                    return 3;
                case 185:
                    rx_c2.j6(v5, i, 5, this.FH.j6(this.DW.Zo(i + 1)), this.DW.v5(i + 3) | (this.DW.v5(i + 4) << 8));
                    return 5;
                case 188:
                    return Hw(i, rx_c2);
                case 196:
                    return v5(i, rx_c2);
                case 197:
                    DW = this.DW.Zo(i + 1);
                    rx_c2.j6(v5, i, 4, this.FH.j6(DW), this.DW.v5(i + 3));
                    return 4;
                case 200:
                case 201:
                    rx_c2.j6(v5 == 200 ? 167 : 168, i, 5, this.DW.FH(i + 1) + i);
                    return 5;
                default:
                    rx_c2.j6(v5, i, 1);
                    return 1;
            }
        } catch (sl e) {
            e.j6("...at bytecode offset " + add.j6(i));
            throw e;
        } catch (Throwable e2) {
            sl slVar = new sl(e2);
            slVar.j6("...at bytecode offset " + add.j6(i));
            throw slVar;
        }
    }

    private int DW(int i, rx$c rx_c) {
        int i2;
        int i3 = 0;
        int i4 = (i + 4) & -4;
        int i5 = 0;
        for (i2 = i + 1; i2 < i4; i2++) {
            i5 = (i5 << 8) | this.DW.v5(i2);
        }
        int FH = i + this.DW.FH(i4);
        int FH2 = this.DW.FH(i4 + 4);
        int FH3 = this.DW.FH(i4 + 8);
        int i6 = (FH3 - FH2) + 1;
        i2 = i4 + 12;
        if (FH2 > FH3) {
            throw new sl("low / high inversion");
        }
        sn snVar = new sn(i6);
        while (i3 < i6) {
            i2 += 4;
            snVar.j6(FH2 + i3, this.DW.FH(i2) + i);
            i3++;
        }
        snVar.FH(FH);
        snVar.Zo();
        snVar.l_();
        FH = i2 - i;
        rx_c.j6(171, i, FH, snVar, i5);
        return FH;
    }

    private int FH(int i, rx$c rx_c) {
        int i2;
        int i3 = 0;
        int i4 = (i + 4) & -4;
        int i5 = 0;
        for (i2 = i + 1; i2 < i4; i2++) {
            i5 = (i5 << 8) | this.DW.v5(i2);
        }
        int FH = i + this.DW.FH(i4);
        int FH2 = this.DW.FH(i4 + 4);
        i2 = i4 + 8;
        sn snVar = new sn(FH2);
        while (i3 < FH2) {
            i2 += 8;
            snVar.j6(this.DW.FH(i2), this.DW.FH(i2 + 4) + i);
            i3++;
        }
        snVar.FH(FH);
        snVar.Zo();
        snVar.l_();
        FH = i2 - i;
        rx_c.j6(171, i, FH, snVar, i5);
        return FH;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int Hw(int r14, rx$c r15) {
        /*
        r13 = this;
        r6 = 2;
        r2 = 0;
        r8 = 1;
        r0 = r13.DW;
        r1 = r14 + 1;
        r9 = r0.v5(r1);
        switch(r9) {
            case 4: goto L_0x002c;
            case 5: goto L_0x006a;
            case 6: goto L_0x0070;
            case 7: goto L_0x006d;
            case 8: goto L_0x0073;
            case 9: goto L_0x0076;
            case 10: goto L_0x0079;
            case 11: goto L_0x007c;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = new sl;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "bad newarray code ";
        r1 = r1.append(r2);
        r2 = add.v5(r9);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x002c:
        r0 = abf.EQ;
    L_0x002e:
        r1 = r15.j6();
        r10 = new rx$b;
        r10.<init>(r13);
        if (r1 < 0) goto L_0x00f3;
    L_0x0039:
        r13.j6(r1, r10);
        r3 = r10.j6;
        r3 = r3 instanceof aat;
        if (r3 == 0) goto L_0x00f3;
    L_0x0042:
        r3 = r10.DW;
        r1 = r1 + r3;
        if (r1 != r14) goto L_0x00f3;
    L_0x0047:
        r1 = r10.FH;
    L_0x0049:
        r3 = r14 + 2;
        r11 = new java.util.ArrayList;
        r11.<init>();
        if (r1 == 0) goto L_0x00f0;
    L_0x0052:
        r4 = r3;
        r5 = r2;
    L_0x0054:
        r7 = r13.DW;
        r12 = r4 + 1;
        r4 = r7.v5(r4);
        r7 = 89;
        if (r4 == r7) goto L_0x007f;
    L_0x0060:
        if (r5 < r6) goto L_0x0064;
    L_0x0062:
        if (r5 == r1) goto L_0x00e5;
    L_0x0064:
        r1 = 0;
        r15.j6(r14, r6, r0, r1);
        r0 = r6;
    L_0x0069:
        return r0;
    L_0x006a:
        r0 = abf.J0;
        goto L_0x002e;
    L_0x006d:
        r0 = abf.J8;
        goto L_0x002e;
    L_0x0070:
        r0 = abf.Ws;
        goto L_0x002e;
    L_0x0073:
        r0 = abf.we;
        goto L_0x002e;
    L_0x0076:
        r0 = abf.aM;
        goto L_0x002e;
    L_0x0079:
        r0 = abf.XL;
        goto L_0x002e;
    L_0x007c:
        r0 = abf.QX;
        goto L_0x002e;
    L_0x007f:
        r13.j6(r12, r10);
        r4 = r10.DW;
        if (r4 == 0) goto L_0x0060;
    L_0x0086:
        r4 = r10.j6;
        r4 = r4 instanceof aat;
        if (r4 == 0) goto L_0x0060;
    L_0x008c:
        r4 = r10.FH;
        if (r4 != r5) goto L_0x0060;
    L_0x0090:
        r4 = r10.DW;
        r4 = r4 + r12;
        r13.j6(r4, r10);
        r7 = r10.DW;
        if (r7 == 0) goto L_0x0060;
    L_0x009a:
        r7 = r10.j6;
        r7 = r7 instanceof aay;
        if (r7 == 0) goto L_0x0060;
    L_0x00a0:
        r7 = r10.DW;
        r7 = r7 + r4;
        r4 = r10.j6;
        r11.add(r4);
        r12 = r13.DW;
        r4 = r7 + 1;
        r7 = r12.v5(r7);
        switch(r9) {
            case 4: goto L_0x00bb;
            case 5: goto L_0x00c1;
            case 6: goto L_0x00cd;
            case 7: goto L_0x00c7;
            case 8: goto L_0x00bb;
            case 9: goto L_0x00d3;
            case 10: goto L_0x00d9;
            case 11: goto L_0x00df;
            default: goto L_0x00b3;
        };
    L_0x00b3:
        r7 = r8;
    L_0x00b4:
        if (r7 != 0) goto L_0x0060;
    L_0x00b6:
        r3 = r5 + 1;
        r5 = r3;
        r3 = r4;
        goto L_0x0054;
    L_0x00bb:
        r12 = 84;
        if (r7 == r12) goto L_0x00ee;
    L_0x00bf:
        r7 = r8;
        goto L_0x00b4;
    L_0x00c1:
        r12 = 85;
        if (r7 == r12) goto L_0x00ee;
    L_0x00c5:
        r7 = r8;
        goto L_0x00b4;
    L_0x00c7:
        r12 = 82;
        if (r7 == r12) goto L_0x00ee;
    L_0x00cb:
        r7 = r8;
        goto L_0x00b4;
    L_0x00cd:
        r12 = 81;
        if (r7 == r12) goto L_0x00ee;
    L_0x00d1:
        r7 = r8;
        goto L_0x00b4;
    L_0x00d3:
        r12 = 86;
        if (r7 == r12) goto L_0x00ee;
    L_0x00d7:
        r7 = r8;
        goto L_0x00b4;
    L_0x00d9:
        r12 = 79;
        if (r7 == r12) goto L_0x00ee;
    L_0x00dd:
        r7 = r8;
        goto L_0x00b4;
    L_0x00df:
        r12 = 80;
        if (r7 == r12) goto L_0x00ee;
    L_0x00e3:
        r7 = r8;
        goto L_0x00b4;
    L_0x00e5:
        r1 = r3 - r14;
        r15.j6(r14, r1, r0, r11);
        r0 = r3 - r14;
        goto L_0x0069;
    L_0x00ee:
        r7 = r2;
        goto L_0x00b4;
    L_0x00f0:
        r5 = r2;
        goto L_0x0060;
    L_0x00f3:
        r1 = r2;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.Hw(int, rx$c):int");
    }

    private int v5(int i, rx$c rx_c) {
        int v5 = this.DW.v5(i + 1);
        int Zo = this.DW.Zo(i + 2);
        switch (v5) {
            case 21:
                rx_c.j6(21, i, 4, Zo, abl.Zo, 0);
                return 4;
            case 22:
                rx_c.j6(21, i, 4, Zo, abl.VH, 0);
                return 4;
            case 23:
                rx_c.j6(21, i, 4, Zo, abl.v5, 0);
                return 4;
            case 24:
                rx_c.j6(21, i, 4, Zo, abl.Hw, 0);
                return 4;
            case 25:
                rx_c.j6(21, i, 4, Zo, abl.Ws, 0);
                return 4;
            case 54:
                rx_c.j6(54, i, 4, Zo, abl.Zo, 0);
                return 4;
            case 55:
                rx_c.j6(54, i, 4, Zo, abl.VH, 0);
                return 4;
            case 56:
                rx_c.j6(54, i, 4, Zo, abl.v5, 0);
                return 4;
            case 57:
                rx_c.j6(54, i, 4, Zo, abl.Hw, 0);
                return 4;
            case 58:
                rx_c.j6(54, i, 4, Zo, abl.Ws, 0);
                return 4;
            case 132:
                rx$c rx_c2 = rx_c;
                int i2 = v5;
                v5 = i;
                rx_c2.j6(i2, v5, 6, Zo, abl.Zo, this.DW.DW(i + 4));
                return 6;
            case 169:
                rx_c.j6(v5, i, 4, Zo, abl.EQ, 0);
                return 4;
            default:
                rx_c.j6(196, i, 1);
                return 1;
        }
    }
}
