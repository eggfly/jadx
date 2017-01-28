import com.aide.uidesigner.ProxyTextView;

public class by {
    private static final int[] j6;
    private int[] DW;
    private dg EQ;
    private int[] FH;
    private int Hw;
    private char[] J0;
    private char[] J8;
    private int VH;
    private byte[] Zo;
    private int[] gn;
    private dg tp;
    private char[] u7;
    private int v5;
    private char[] we;

    static {
        j6 = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public by() {
        int i = 1;
        int i2 = 0;
        this.tp = new dg();
        this.EQ = new dg();
        this.we = new char[100];
        this.J0 = new char[1000];
        this.J8 = new char[1000];
        this.v5 = 0;
        this.DW = new int[j6[this.v5]];
        this.FH = new int[j6[this.v5]];
        this.Hw = 0;
        this.Zo = new byte[10000];
        this.VH = 1;
        this.gn = new int[123];
        int i3 = 97;
        while (i3 <= 122) {
            int i4 = i + 1;
            this.gn[i3] = i;
            i3++;
            i = i4;
        }
        i3 = 65;
        while (i3 <= 90) {
            i4 = i + 1;
            this.gn[i3] = i;
            i3++;
            i = i4;
        }
        i3 = 48;
        while (i3 <= 57) {
            i4 = i + 1;
            this.gn[i3] = i;
            i3++;
            i = i4;
        }
        int i5 = i + 1;
        this.gn[95] = i;
        this.u7 = new char[64];
        while (i2 < this.gn.length) {
            this.u7[this.gn[i2]] = (char) i2;
            i2++;
        }
    }

    protected void j6(ee eeVar) {
        int i;
        int i2 = 0;
        this.v5 = eeVar.readInt();
        this.Hw = eeVar.readInt();
        this.DW = new int[j6[this.v5]];
        this.FH = new int[j6[this.v5]];
        for (i = 0; i < this.DW.length; i++) {
            this.DW[i] = eeVar.readInt();
        }
        for (i = 0; i < this.DW.length; i++) {
            this.FH[i] = eeVar.readInt();
        }
        this.VH = eeVar.readInt();
        this.Zo = new byte[((this.VH * 5) / 4)];
        while (i2 < this.VH) {
            this.Zo[i2] = eeVar.readByte();
            i2++;
        }
    }

    protected void j6(ef efVar) {
        int i;
        int i2 = 0;
        efVar.writeInt(this.v5);
        efVar.writeInt(this.Hw);
        for (int writeInt : this.DW) {
            efVar.writeInt(writeInt);
        }
        for (i = 0; i < this.DW.length; i++) {
            efVar.writeInt(this.FH[i]);
        }
        efVar.writeInt(this.VH);
        while (i2 < this.VH) {
            efVar.writeByte(this.Zo[i2]);
            i2++;
        }
    }

    public void j6() {
        if (this.Hw > 0) {
            for (int i = 0; i < this.DW.length; i++) {
                this.DW[i] = 0;
            }
            this.Hw = 0;
        }
        this.VH = 1;
    }

    public int j6(String str) {
        return j6(str, 0, str.length());
    }

    public int j6(String str, int i, int i2) {
        return j6(str.toCharArray(), i, i2);
    }

    public int j6(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        switch (i2) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
                i3 = 0;
                for (i4 = 0; i4 < i2; i4++) {
                    char c = cArr[i + i4];
                    if (c >= this.gn.length) {
                        break;
                    }
                    i5 = this.gn[c];
                    if (i5 == 0) {
                        break;
                    }
                    i3 = (i3 << 6) | i5;
                }
                return 1073741824 | i3;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return Integer.MIN_VALUE | cArr[i];
        }
        if (i2 < 4) {
            i4 = i2;
            i3 = i;
            while (i4 > 0) {
                i5 = i3 + 1;
                i4--;
                i6 = cArr[i3] + (i6 * 37);
                i3 = i5;
            }
        } else {
            int i7 = i2 / 4;
            i4 = i2;
            i3 = i;
            while (i4 > 0) {
                i5 = cArr[i3] + (i6 * 39);
                i3 += i7;
                i4 -= i7;
                i6 = i5;
            }
        }
        i5 = ((i6 & Integer.MAX_VALUE) % (this.DW.length - 2)) + 1;
        i3 = (i6 & Integer.MAX_VALUE) % this.DW.length;
        i4 = this.DW[i3];
        while (i4 != 0) {
            if (i4 == i6) {
                i4 = this.FH[i3];
                if (j6(i4, cArr, i, i2)) {
                    return i4;
                }
            }
            i3 = (i3 + i5) % this.DW.length;
            i4 = this.DW[i3];
        }
        i4 = this.VH;
        v5(i6);
        DW(cArr, i, i2);
        return i4;
    }

    private void v5(int i) {
        int length = (i & Integer.MAX_VALUE) % this.DW.length;
        int length2 = ((i & Integer.MAX_VALUE) % (this.DW.length - 2)) + 1;
        int i2 = this.DW[length];
        while (i2 != 0) {
            length = (length + length2) % this.DW.length;
            i2 = this.DW[length];
        }
        this.DW[length] = i;
        this.FH[length] = this.VH;
        this.Hw++;
        if (this.Hw * 2 > this.DW.length) {
            DW();
        }
    }

    private void DW() {
        int i = 0;
        this.v5++;
        int[] iArr = new int[j6[this.v5]];
        int[] iArr2 = new int[j6[this.v5]];
        int i2 = 0;
        while (i < this.DW.length) {
            int i3 = this.DW[i];
            if (i3 != 0) {
                int length = ((i3 & Integer.MAX_VALUE) % (iArr.length - 2)) + 1;
                int length2 = (i3 & Integer.MAX_VALUE) % iArr.length;
                while (iArr[length2] != 0) {
                    length2 = (length2 + length) % iArr.length;
                }
                iArr[length2] = i3;
                iArr2[length2] = this.FH[i];
                i2++;
            }
            i++;
        }
        this.DW = iArr;
        this.FH = iArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void DW(char[] r10, int r11, int r12) {
        /*
        r9 = this;
        r8 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r7 = 1;
        r6 = 0;
    L_0x0004:
        r0 = r9.VH;
        r1 = r12 * 3;
        r0 = r0 + r1;
        r0 = r0 + 1;
        r1 = r9.Zo;
        r1 = r1.length;
        if (r0 < r1) goto L_0x0024;
    L_0x0010:
        r0 = r9.Zo;
        r0 = r0.length;
        r0 = r0 * 2;
        r0 = r0 + 1;
        r0 = new byte[r0];
        r1 = r9.Zo;
        r2 = r9.Zo;
        r2 = r2.length;
        java.lang.System.arraycopy(r1, r6, r0, r6, r2);
        r9.Zo = r0;
        goto L_0x0004;
    L_0x0024:
        r1 = r11 + r12;
        r0 = r11;
    L_0x0027:
        if (r0 >= r1) goto L_0x002f;
    L_0x0029:
        r2 = r10[r0];
        if (r2 < r7) goto L_0x002f;
    L_0x002d:
        if (r2 <= r8) goto L_0x0045;
    L_0x002f:
        if (r0 >= r1) goto L_0x00ae;
    L_0x0031:
        r2 = r10[r0];
        if (r2 < r7) goto L_0x0053;
    L_0x0035:
        if (r2 > r8) goto L_0x0053;
    L_0x0037:
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r2 = (byte) r2;
        r3[r4] = r2;
    L_0x0042:
        r0 = r0 + 1;
        goto L_0x002f;
    L_0x0045:
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r2 = (byte) r2;
        r3[r4] = r2;
        r0 = r0 + 1;
        goto L_0x0027;
    L_0x0053:
        r3 = 2047; // 0x7ff float:2.868E-42 double:1.0114E-320;
        if (r2 <= r3) goto L_0x008b;
    L_0x0057:
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r5 = r2 >> 12;
        r5 = r5 & 15;
        r5 = r5 | 224;
        r5 = (byte) r5;
        r3[r4] = r5;
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r5 = r2 >> 6;
        r5 = r5 & 63;
        r5 = r5 | 128;
        r5 = (byte) r5;
        r3[r4] = r5;
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r2 = r2 >> 0;
        r2 = r2 & 63;
        r2 = r2 | 128;
        r2 = (byte) r2;
        r3[r4] = r2;
        goto L_0x0042;
    L_0x008b:
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r5 = r2 >> 6;
        r5 = r5 & 31;
        r5 = r5 | 192;
        r5 = (byte) r5;
        r3[r4] = r5;
        r3 = r9.Zo;
        r4 = r9.VH;
        r5 = r4 + 1;
        r9.VH = r5;
        r2 = r2 >> 0;
        r2 = r2 & 63;
        r2 = r2 | 128;
        r2 = (byte) r2;
        r3[r4] = r2;
        goto L_0x0042;
    L_0x00ae:
        r0 = r9.Zo;
        r1 = r9.VH;
        r2 = r1 + 1;
        r9.VH = r2;
        r0[r1] = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: by.DW(char[], int, int):void");
    }

    private boolean j6(int i, char[] cArr, int i2, int i3) {
        int i4;
        int i5 = i2 + i3;
        int i6 = i2;
        int i7 = i;
        while (i6 < i5) {
            char c = cArr[i6];
            if (c != '\u0000') {
                if (c < '\u0001') {
                    break;
                } else if (c > '\u007f') {
                    i4 = i7;
                    i7 = i6;
                    break;
                } else {
                    i = i7 + 1;
                    if (((byte) c) != this.Zo[i7]) {
                        return false;
                    }
                    i6++;
                    i7 = i;
                }
            } else {
                return false;
            }
        }
        i4 = i7;
        i7 = i6;
        while (i7 < i5) {
            char c2 = cArr[i7];
            if (c2 == '\u0000') {
                return false;
            }
            if (c2 >= '\u0001' && c2 <= '\u007f') {
                byte b = (byte) c2;
                i6 = i4 + 1;
                if (b != this.Zo[i4]) {
                    return false;
                }
            } else if (c2 > '\u07ff') {
                r8 = i4 + 1;
                if (((byte) (((c2 >> 12) & 15) | 224)) != this.Zo[i4]) {
                    return false;
                }
                int i8 = r8 + 1;
                if (((byte) (((c2 >> 6) & 63) | 128)) != this.Zo[r8]) {
                    return false;
                }
                r4 = (byte) (((c2 >> 0) & 63) | 128);
                i6 = i8 + 1;
                if (r4 != this.Zo[i8]) {
                    return false;
                }
            } else {
                r8 = i4 + 1;
                if (((byte) (((c2 >> 6) & 31) | 192)) != this.Zo[i4]) {
                    return false;
                }
                r4 = (byte) (((c2 >> 0) & 63) | 128);
                i6 = r8 + 1;
                if (r4 != this.Zo[r8]) {
                    return false;
                }
            }
            i7++;
            i4 = i6;
        }
        i7 = i4 + 1;
        return this.Zo[i4] == null;
    }

    public String j6(int i) {
        int i2 = 0;
        if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            return String.valueOf((char) (Integer.MAX_VALUE & i));
        }
        int i3;
        int i4;
        if ((i & 1073741824) == 1073741824) {
            char[] cArr = new char[5];
            i3 = -1073741825 & i;
            int i5 = 0;
            while (i2 < 5) {
                i4 = i3 & 63;
                if (i4 == 0) {
                    break;
                }
                i5++;
                cArr[5 - i5] = this.u7[i4];
                i3 >>= 6;
                i2++;
            }
            return new String(cArr, 5 - i5, i5);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i < this.VH) {
            i2 = i + 1;
            i3 = this.Zo[i] & 255;
            if (i3 == 0) {
                return stringBuffer.toString();
            }
            switch (i3 >> 4) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 6:
                case 7:
                    stringBuffer.append((char) i3);
                    i = i2;
                    break;
                case 12:
                case 13:
                    if (i2 < this.VH) {
                        i = i2 + 1;
                        stringBuffer.append((char) (((this.Zo[i2] & 255) & 63) | ((i3 & 31) << 6)));
                        break;
                    }
                    throw new RuntimeException("End index not on boundary");
                case 14:
                    if (i2 + 1 < this.VH) {
                        i4 = i2 + 1;
                        i = i4 + 1;
                        stringBuffer.append((char) (((((this.Zo[i2] & 255) & 63) << 6) | ((i3 & 15) << 12)) | (((this.Zo[i4] & 255) & 63) << 0)));
                        break;
                    }
                    throw new RuntimeException("End index not on boundary");
                default:
                    throw new RuntimeException("Malformed input");
            }
        }
        return stringBuffer.toString();
    }

    public int j6(int i, char[] cArr, int i2) {
        int i3 = 0;
        if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            if (i2 + 1 >= cArr.length) {
                return -1;
            }
            i3 = i2 + 1;
            cArr[i2] = (char) (Integer.MAX_VALUE & i);
            return i3;
        } else if ((i & 1073741824) == 1073741824) {
            r1 = -1073741825 & i;
            r4 = 0;
            int i4 = r1;
            for (r3 = 0; r3 < 5 && i4 != 0; r3++) {
                r4++;
                i4 >>= 6;
            }
            if (i2 + r4 >= cArr.length) {
                return -1;
            }
            while (i3 < r4) {
                int i5 = r1 & 63;
                if (i5 == 0) {
                    break;
                }
                cArr[((i2 + r4) - i3) - 1] = this.u7[i5];
                r1 >>= 6;
                i3++;
            }
            return i2 + r4;
        } else {
            while (i < this.VH) {
                i3 = i + 1;
                r3 = this.Zo[i] & 255;
                if (r3 == 0) {
                    return i2;
                }
                if (i2 >= cArr.length) {
                    return -1;
                }
                switch (r3 >> 4) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                        r1 = i2 + 1;
                        cArr[i2] = (char) r3;
                        i = i3;
                        i2 = r1;
                        break;
                    case 12:
                    case 13:
                        if (i3 < this.VH) {
                            i = i3 + 1;
                            r1 = this.Zo[i3] & 255;
                            i3 = i2 + 1;
                            cArr[i2] = (char) ((r1 & 63) | ((r3 & 31) << 6));
                            i2 = i3;
                            break;
                        }
                        throw new RuntimeException("End index not on boundary");
                    case 14:
                        if (i3 + 1 < this.VH) {
                            r4 = i3 + 1;
                            r1 = this.Zo[i3] & 255;
                            i = r4 + 1;
                            i3 = i2 + 1;
                            r1 = (r1 & 63) << 6;
                            cArr[i2] = (char) ((r1 | ((r3 & 15) << 12)) | (((this.Zo[r4] & 255) & 63) << 0));
                            i2 = i3;
                            break;
                        }
                        throw new RuntimeException("End index not on boundary");
                    default:
                        throw new RuntimeException("Malformed input");
                }
            }
            return i2;
        }
    }

    public int DW(int i) {
        while (true) {
            int j6 = j6(i, this.J0, 0);
            if (j6 != -1) {
                return j6;
            }
            this.J0 = new char[((this.J0.length * 2) + 1)];
        }
    }

    public int j6(int i, int i2, int i3) {
        while (j6(i, this.J0, 0) == -1) {
            this.J0 = new char[((this.J0.length * 2) + 1)];
        }
        return j6(this.J0, i2, i3 - i2);
    }

    public int FH(int i) {
        int FH = this.tp.FH(i);
        if (FH != -1) {
            return FH;
        }
        int j6;
        while (true) {
            j6 = j6(i, this.we, 0);
            if (j6 != -1) {
                break;
            }
            this.we = new char[((this.we.length * 2) + 1)];
        }
        for (FH = 0; FH < j6; FH++) {
            this.we[FH] = Character.toUpperCase(this.we[FH]);
        }
        FH = j6(this.we, 0, j6);
        this.tp.j6(i, FH);
        return FH;
    }

    public int Hw(int i) {
        int FH = this.EQ.FH(i);
        if (FH != -1) {
            return FH;
        }
        int j6;
        while (true) {
            j6 = j6(i, this.we, 0);
            if (j6 != -1) {
                break;
            }
            this.we = new char[((this.we.length * 2) + 1)];
        }
        for (FH = 0; FH < j6; FH++) {
            this.we[FH] = Character.toLowerCase(this.we[FH]);
        }
        FH = j6(this.we, 0, j6);
        this.EQ.j6(i, FH);
        return FH;
    }
}
