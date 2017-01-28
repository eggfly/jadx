import com.aide.uidesigner.ProxyTextView;
import java.io.Reader;

class ayc {
    private static final char[] DW;
    private static final int[] FH;
    private static final int[] Hw;
    private static final int[] VH;
    private static final String[] Zo;
    private static final int[] j6;
    private static final int[] v5;
    private char[] EQ;
    private int J0;
    private int J8;
    private boolean Mr;
    private int QX;
    private StringBuffer U2;
    private int Ws;
    private int XL;
    private int aM;
    private Reader gn;
    private boolean j3;
    private int tp;
    private int u7;
    private int we;

    static {
        j6 = new int[]{0, 0, 1, 1};
        DW = j6("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016\uff82\u0000");
        FH = Hw();
        Hw = v5();
        v5 = new int[]{2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
        Zo = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
        VH = Zo();
    }

    ayc(Reader reader) {
        this.tp = 0;
        this.EQ = new char[16384];
        this.j3 = true;
        this.U2 = new StringBuffer();
        this.gn = reader;
    }

    private static int DW(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2) << 16;
            i2 = i + 1;
            int i4 = i3 + 1;
            iArr[i] = str.charAt(i3) | charAt;
            i = i2;
            i2 = i4;
        }
        return i;
    }

    private static int FH(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        int i3 = i;
        while (i2 < length) {
            int i4 = i2 + 1;
            i2 = str.charAt(i2);
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            while (true) {
                i4 = i3 + 1;
                iArr[i3] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i3 = i4;
            }
            i3 = i4;
            i2 = i5;
        }
        return i3;
    }

    private void FH(int i) {
        String str;
        try {
            str = Zo[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            str = Zo[0];
        }
        throw new Error(str);
    }

    private static int[] Hw() {
        int[] iArr = new int[45];
        j6("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", 0, iArr);
        return iArr;
    }

    private boolean VH() {
        if (this.J8 > 0) {
            System.arraycopy(this.EQ, this.J8, this.EQ, 0, this.Ws - this.J8);
            this.Ws -= this.J8;
            this.J0 -= this.J8;
            this.we -= this.J8;
            this.J8 = 0;
        }
        if (this.J0 >= this.EQ.length) {
            Object obj = new char[(this.J0 * 2)];
            System.arraycopy(this.EQ, 0, obj, 0, this.EQ.length);
            this.EQ = obj;
        }
        int read = this.gn.read(this.EQ, this.Ws, this.EQ.length - this.Ws);
        if (read > 0) {
            this.Ws += read;
            return false;
        } else if (read != 0) {
            return true;
        } else {
            read = this.gn.read();
            if (read == -1) {
                return true;
            }
            char[] cArr = this.EQ;
            int i = this.Ws;
            this.Ws = i + 1;
            cArr[i] = (char) read;
            return false;
        }
    }

    private static int[] Zo() {
        int[] iArr = new int[45];
        FH("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", 0, iArr);
        return iArr;
    }

    private static int j6(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        int i3 = i;
        while (i2 < length) {
            int i4 = i2 + 1;
            i2 = str.charAt(i2);
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            while (true) {
                i4 = i3 + 1;
                iArr[i3] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i3 = i4;
            }
            i3 = i4;
            i2 = i5;
        }
        return i3;
    }

    private static char[] j6(String str) {
        int i = 0;
        char[] cArr = new char[65536];
        int i2 = 0;
        while (i2 < 90) {
            int i3 = i2 + 1;
            i2 = str.charAt(i2);
            int i4 = i3 + 1;
            char charAt = str.charAt(i3);
            while (true) {
                i3 = i + 1;
                cArr[i] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i = i3;
            }
            i = i3;
            i2 = i4;
        }
        return cArr;
    }

    private static int[] v5() {
        int[] iArr = new int[45];
        DW("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000\u00a2\u0000\u00bd\u0000\u00d8\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u00f3\u0000\u010e\u00006\u0000\u0129\u0000\u0144\u0000\u015f\u0000\u017a\u0000\u0195\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u01b0\u0000\u01cb\u0000\u01e6\u0000\u01e6\u0000\u0201\u0000\u021c\u0000\u0237\u0000\u0252\u00006\u00006\u0000\u026d\u0000\u0288\u00006", 0, iArr);
        return iArr;
    }

    public final char DW(int i) {
        return this.EQ[this.J8 + i];
    }

    public final String DW() {
        return new String(this.EQ, this.J8, this.we - this.J8);
    }

    public ayd FH() {
        int i = this.Ws;
        char[] cArr = this.EQ;
        char[] cArr2 = DW;
        int[] iArr = v5;
        int[] iArr2 = Hw;
        int[] iArr3 = VH;
        while (true) {
            int i2 = this.we;
            this.XL += i2 - this.J8;
            int i3 = -1;
            this.J8 = i2;
            this.J0 = i2;
            this.u7 = j6[this.tp];
            int i4 = i2;
            while (true) {
                int i5;
                if (i4 < i) {
                    i5 = i4 + 1;
                    i4 = cArr[i4];
                } else {
                    if (this.Mr) {
                        i4 = -1;
                    } else {
                        this.J0 = i4;
                        this.we = i2;
                        boolean VH = VH();
                        i4 = this.J0;
                        i2 = this.we;
                        cArr = this.EQ;
                        i = this.Ws;
                        if (VH) {
                            i4 = -1;
                        } else {
                            i5 = i4 + 1;
                            i4 = cArr[i4];
                        }
                    }
                    this.we = i2;
                    if (i3 >= 0) {
                        i3 = FH[i3];
                    }
                    switch (i3) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            throw new ayb(this.XL, 0, new Character(DW(0)));
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            return new ayd(0, Long.valueOf(DW()));
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                        case 34:
                        case 35:
                        case ProxyTextView.INPUTTYPE_time /*36*/:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                            break;
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            this.U2.delete(0, this.U2.length());
                            j6(2);
                            break;
                        case 5:
                            return new ayd(1, null);
                        case 6:
                            return new ayd(2, null);
                        case 7:
                            return new ayd(3, null);
                        case 8:
                            return new ayd(4, null);
                        case 9:
                            return new ayd(5, null);
                        case 10:
                            return new ayd(6, null);
                        case 11:
                            this.U2.append(DW());
                            break;
                        case 12:
                            this.U2.append('\\');
                            break;
                        case 13:
                            j6(0);
                            return new ayd(0, this.U2.toString());
                        case 14:
                            this.U2.append('\"');
                            break;
                        case 15:
                            this.U2.append('/');
                            break;
                        case 16:
                            this.U2.append('\b');
                            break;
                        case ProxyTextView.INPUTTYPE_textUri /*17*/:
                            this.U2.append('\f');
                            break;
                        case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                            this.U2.append('\n');
                            break;
                        case 19:
                            this.U2.append('\r');
                            break;
                        case ProxyTextView.INPUTTYPE_date /*20*/:
                            this.U2.append('\t');
                            break;
                        case 21:
                            return new ayd(0, Double.valueOf(DW()));
                        case 22:
                            return new ayd(0, null);
                        case 23:
                            return new ayd(0, Boolean.valueOf(DW()));
                        case 24:
                            try {
                                this.U2.append((char) Integer.parseInt(DW().substring(2), 16));
                                break;
                            } catch (Exception e) {
                                throw new ayb(this.XL, 2, e);
                            }
                        default:
                            if (i4 == -1 || this.J8 != this.J0) {
                                FH(1);
                                break;
                            }
                            this.Mr = true;
                            return null;
                    }
                }
                int i6 = iArr[iArr2[this.u7] + cArr2[i4]];
                if (i6 != -1) {
                    this.u7 = i6;
                    i6 = iArr3[this.u7];
                    if ((i6 & 1) == 1) {
                        i2 = this.u7;
                        if ((i6 & 8) == 8) {
                            i3 = i2;
                            i2 = i5;
                        } else {
                            i4 = i2;
                            i2 = i5;
                        }
                    } else {
                        i4 = i3;
                    }
                    i3 = i4;
                    i4 = i5;
                }
                this.we = i2;
                if (i3 >= 0) {
                    i3 = FH[i3];
                }
                switch (i3) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        throw new ayb(this.XL, 0, new Character(DW(0)));
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        return new ayd(0, Long.valueOf(DW()));
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    case 34:
                    case 35:
                    case ProxyTextView.INPUTTYPE_time /*36*/:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        this.U2.delete(0, this.U2.length());
                        j6(2);
                        break;
                    case 5:
                        return new ayd(1, null);
                    case 6:
                        return new ayd(2, null);
                    case 7:
                        return new ayd(3, null);
                    case 8:
                        return new ayd(4, null);
                    case 9:
                        return new ayd(5, null);
                    case 10:
                        return new ayd(6, null);
                    case 11:
                        this.U2.append(DW());
                        break;
                    case 12:
                        this.U2.append('\\');
                        break;
                    case 13:
                        j6(0);
                        return new ayd(0, this.U2.toString());
                    case 14:
                        this.U2.append('\"');
                        break;
                    case 15:
                        this.U2.append('/');
                        break;
                    case 16:
                        this.U2.append('\b');
                        break;
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        this.U2.append('\f');
                        break;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.U2.append('\n');
                        break;
                    case 19:
                        this.U2.append('\r');
                        break;
                    case ProxyTextView.INPUTTYPE_date /*20*/:
                        this.U2.append('\t');
                        break;
                    case 21:
                        return new ayd(0, Double.valueOf(DW()));
                    case 22:
                        return new ayd(0, null);
                    case 23:
                        return new ayd(0, Boolean.valueOf(DW()));
                    case 24:
                        this.U2.append((char) Integer.parseInt(DW().substring(2), 16));
                        break;
                    default:
                        if (i4 == -1) {
                            break;
                        }
                        FH(1);
                        break;
                }
            }
        }
    }

    int j6() {
        return this.XL;
    }

    public final void j6(int i) {
        this.tp = i;
    }

    public final void j6(Reader reader) {
        this.gn = reader;
        this.j3 = true;
        this.Mr = false;
        this.J8 = 0;
        this.Ws = 0;
        this.we = 0;
        this.J0 = 0;
        this.aM = 0;
        this.XL = 0;
        this.QX = 0;
        this.tp = 0;
    }
}
