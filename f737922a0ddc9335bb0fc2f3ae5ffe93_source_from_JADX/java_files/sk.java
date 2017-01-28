import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;

final class sk extends so {
    private static final abb DW;
    private static final abf j6;
    private int EQ;
    private final sj FH;
    private final ry Hw;
    private boolean J0;
    private boolean J8;
    private zz QX;
    private final ArrayList<zo> VH;
    private si Ws;
    private aac XL;
    private final int Zo;
    private abn gn;
    private boolean tp;
    private boolean u7;
    private final aag v5;
    private int we;

    static {
        j6 = new abf(abl.FH("java/lang/reflect/Array"));
        DW = new abb(j6, new abc(new abe("newInstance"), new abe("(Ljava/lang/Class;[I)Ljava/lang/Object;")));
    }

    public sk(sj sjVar, ry ryVar, aag aag) {
        super(ryVar.VH());
        if (sjVar == null) {
            throw new NullPointerException("ropper == null");
        } else if (aag == null) {
            throw new NullPointerException("advice == null");
        } else {
            this.FH = sjVar;
            this.Hw = ryVar;
            this.v5 = aag;
            this.Zo = ryVar.tp();
            this.VH = new ArrayList(25);
            this.gn = null;
            this.u7 = false;
            this.tp = false;
            this.EQ = -1;
            this.we = 0;
            this.J8 = false;
            this.QX = null;
            this.XL = null;
        }
    }

    public ArrayList<zo> J0() {
        return this.VH;
    }

    public zz J8() {
        return this.QX;
    }

    public aac Ws() {
        return this.XL;
    }

    public void j6(abn abn) {
        this.gn = abn;
        this.VH.clear();
        this.u7 = false;
        this.tp = false;
        this.EQ = 0;
        this.we = 0;
        this.J8 = false;
        this.J0 = false;
        this.Ws = null;
    }

    public boolean QX() {
        return this.u7;
    }

    public boolean XL() {
        return this.tp;
    }

    public int aM() {
        return this.EQ;
    }

    public int j3() {
        return this.we;
    }

    public boolean Mr() {
        return this.J8;
    }

    public boolean U2() {
        return this.J0;
    }

    public boolean a8() {
        return this.Ws != null;
    }

    public si lg() {
        return this.Ws;
    }

    public void j6(sa saVar, int i, int i2) {
        abm gn;
        Object aae;
        zx j6;
        zo zuVar;
        zz zzVar;
        aah DW;
        int DW2 = saVar.Hw().DW() + this.Zo;
        zx j62 = j6(i2, DW2);
        int m_ = j62.m_();
        super.j6(saVar, i, i2);
        aac j63 = this.Hw.j6(i);
        zw DW3 = DW(i2 == 54);
        int we = we();
        if (we == 0) {
            DW3 = null;
            switch (i2) {
                case 87:
                case 88:
                    return;
            }
        } else if (DW3 == null) {
            if (we == 1) {
                DW3 = zw.j6(DW2, Hw(0));
            } else {
                int j64 = this.FH.j6();
                zw[] zwVarArr = new zw[m_];
                for (we = 0; we < m_; we++) {
                    zw DW4 = j62.DW(we);
                    gn = DW4.gn();
                    DW3 = DW4.DW(j64);
                    this.VH.add(new zu(aab.j6(gn), j63, DW3, DW4));
                    zwVarArr[we] = DW3;
                    j64 += DW4.EQ();
                }
                for (we = v5(); we != 0; we >>= 4) {
                    zw zwVar = zwVarArr[(we & 15) - 1];
                    abm gn2 = zwVar.gn();
                    this.VH.add(new zu(aab.j6(gn2), j63, zwVar.DW(DW2), zwVar));
                    DW2 += gn2.j6().tp();
                }
                return;
            }
        }
        if (DW3 != null) {
            gn = DW3;
        } else {
            Object obj = abl.u7;
        }
        aah Zo = Zo();
        if (i2 == 197) {
            this.J8 = true;
            this.we = 6;
            zw j65 = zw.j6(DW3.tp(), abl.SI);
            this.VH.add(new aae(aab.j6(abl.SI, m_), j63, j62, this.gn, abf.XL));
            this.VH.add(new zu(aab.Hw(abl.SI), j63, j65, zx.j6));
            we = 0;
            abl u7 = ((abf) Zo).u7();
            while (we < m_) {
                we++;
                u7 = u7.U2();
            }
            zw j66 = zw.j6(DW3.VH(), abl.J0);
            if (u7.J8()) {
                aae = new aae(aab.ir, j63, zx.j6, this.gn, aar.j6(u7));
            } else {
                aae = new aae(aab.XL, j63, zx.j6, this.gn, new abf(u7));
            }
            this.VH.add(aae);
            this.VH.add(new zu(aab.v5(j66.j6()), j63, j66, zx.j6));
            zw j67 = zw.j6(DW3.VH(), abl.Ws);
            this.VH.add(new aae(aab.j6(DW.u7()), j63, zx.j6(j66, j65), this.gn, DW));
            this.VH.add(new zu(aab.Hw(DW.u7().DW()), j63, j67, zx.j6));
            i2 = 192;
            j6 = zx.j6(j67);
        } else if (i2 == 168) {
            this.J0 = true;
            return;
        } else if (i2 == 169) {
            try {
                this.Ws = (si) FH(0);
                return;
            } catch (Throwable e) {
                throw new RuntimeException("Argument to RET was not a ReturnAddress", e);
            }
        } else {
            j6 = j62;
        }
        int j68 = j6(i2, Zo);
        zz j69 = aab.j6(j68, gn, j6, Zo);
        if (DW3 != null && j69.v5()) {
            this.we++;
            zuVar = new zu(aab.Hw(((abb) Zo).u7().DW()), j63, DW3, zx.j6);
            zwVar = null;
        } else if (DW3 == null || !j69.gn()) {
            zuVar = null;
            zwVar = DW3;
        } else {
            this.we++;
            zuVar = new zu(aab.v5(DW3.gn()), j63, DW3, zx.j6);
            zwVar = null;
        }
        if (j68 == 41) {
            zzVar = j69;
            DW = abf.DW(j69.DW());
        } else {
            if (Zo == null && m_ == 2) {
                abm gn3 = j6.DW(0).gn();
                abm gn4 = j6.DW(1).gn();
                if ((gn4.Zo() || gn3.Zo()) && this.v5.j6(j69, j6.DW(0), j6.DW(1))) {
                    aah j610;
                    aah aah;
                    if (gn4.Zo()) {
                        aah = (aah) gn4;
                        j6 = j6.VH();
                        if (j69.j6() == 15) {
                            we = 14;
                            j610 = aat.j6(-((aat) gn4).r_());
                        } else {
                            j610 = aah;
                            we = j68;
                        }
                    } else {
                        aah = (aah) gn3;
                        j6 = j6.Zo();
                        j610 = aah;
                        we = j68;
                    }
                    DW = j610;
                    zzVar = aab.j6(we, gn, j6, j610);
                    j68 = we;
                }
            }
            zzVar = j69;
            DW = Zo;
        }
        sn gn5 = gn();
        ArrayList u72 = u7();
        boolean gn6 = zzVar.gn();
        this.J8 |= gn6;
        if (gn5 != null) {
            if (gn5.j6() == 0) {
                aae = new zu(aab.j3, j63, null, zx.j6);
                this.EQ = 0;
            } else {
                adg v5 = gn5.v5();
                aae = new aad(zzVar, j63, zwVar, j6, v5);
                this.EQ = v5.DW();
            }
        } else if (j68 == 33) {
            if (j6.m_() != 0) {
                zw DW5 = j6.DW(0);
                abm gn7 = DW5.gn();
                if (DW5.VH() != 0) {
                    this.VH.add(new zu(aab.j6(gn7), j63, zw.j6(0, gn7), DW5));
                }
            }
            aae = new zu(aab.j3, j63, null, zx.j6);
            this.EQ = 0;
            j6(zzVar, j63);
            this.tp = true;
        } else if (DW != null) {
            if (gn6) {
                aae aae2 = new aae(zzVar, j63, j6, this.gn, DW);
                this.u7 = true;
                this.EQ = this.gn.m_();
                aae aae3 = aae2;
            } else {
                aae = new zt(zzVar, j63, zwVar, j6, DW);
            }
        } else if (gn6) {
            aae = new aaf(zzVar, j63, j6, this.gn);
            this.u7 = true;
            if (i2 == 191) {
                this.EQ = -1;
            } else {
                this.EQ = this.gn.m_();
            }
        } else {
            aae = new zu(zzVar, j63, zwVar, j6);
        }
        this.VH.add(aae);
        if (zuVar != null) {
            this.VH.add(zuVar);
        }
        if (u72 != null) {
            this.we++;
            this.VH.add(new zn(aab.J1, j63, zx.j6(zuVar.gn()), u72, DW));
        }
    }

    private zx j6(int i, int i2) {
        int FH = FH();
        if (FH == 0) {
            return zx.j6;
        }
        zx zxVar;
        int tp = tp();
        if (tp < 0) {
            zxVar = new zx(FH);
            for (tp = 0; tp < FH; tp++) {
                zw j6 = zw.j6(i2, FH(tp));
                zxVar.j6(tp, j6);
                i2 += j6.EQ();
            }
            zw DW;
            switch (i) {
                case 79:
                    if (FH == 3) {
                        DW = zxVar.DW(0);
                        zw DW2 = zxVar.DW(1);
                        zxVar.j6(0, zxVar.DW(2));
                        zxVar.j6(1, DW);
                        zxVar.j6(2, DW2);
                        break;
                    }
                    throw new RuntimeException("shouldn't happen");
                case 181:
                    if (FH == 2) {
                        DW = zxVar.DW(0);
                        zxVar.j6(0, zxVar.DW(1));
                        zxVar.j6(1, DW);
                        break;
                    }
                    throw new RuntimeException("shouldn't happen");
                default:
                    break;
            }
        }
        zxVar = new zx(1);
        zxVar.j6(0, zw.j6(tp, FH(0)));
        zxVar.l_();
        return zxVar;
    }

    private void j6(zz zzVar, aac aac) {
        if (zzVar == null) {
            throw new NullPointerException("op == null");
        } else if (aac == null) {
            throw new NullPointerException("pos == null");
        } else if (this.QX == null) {
            this.QX = zzVar;
            this.XL = aac;
        } else if (this.QX != zzVar) {
            throw new sl("return op mismatch: " + zzVar + ", " + this.QX);
        } else if (aac.j6() > this.XL.j6()) {
            this.XL = aac;
        }
    }

    private int j6(int i, aah aah) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return 1;
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return 5;
            case 21:
            case 54:
                return 2;
            case 46:
                return 38;
            case 79:
                return 39;
            case 96:
            case 132:
                return 14;
            case 100:
                return 15;
            case 104:
                return 16;
            case 108:
                return 17;
            case 112:
                return 18;
            case 116:
                return 19;
            case 120:
                return 23;
            case 122:
                return 24;
            case 124:
                return 25;
            case 126:
                return 20;
            case 128:
                return 21;
            case 130:
                return 22;
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
                return 29;
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                return 30;
            case 146:
                return 31;
            case 147:
                return 32;
            case 148:
            case 149:
            case 151:
                return 27;
            case 150:
            case 152:
                return 28;
            case 153:
            case 159:
            case 165:
            case 198:
                return 7;
            case 154:
            case 160:
            case 166:
            case 199:
                return 8;
            case 155:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                return 9;
            case 156:
            case 162:
                return 10;
            case 157:
            case 163:
                return 12;
            case 158:
            case 164:
                return 11;
            case 167:
                return 6;
            case 171:
                return 13;
            case 172:
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                return 33;
            case 178:
                return 46;
            case 179:
                return 48;
            case 180:
                return 45;
            case 181:
                return 47;
            case 182:
                return 50;
            case 183:
                abb abb = (abb) aah;
                if (abb.tp() || abb.J0() == this.Hw.Zo() || !this.Hw.gn()) {
                    return 52;
                }
                return 51;
            case 184:
                return 49;
            case 185:
                return 53;
            case 187:
                return 40;
            case 188:
            case 189:
                return 41;
            case 190:
                return 34;
            case 191:
                return 35;
            case 192:
                return 43;
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                return 44;
            case 194:
                return 36;
            case 195:
                return 37;
            default:
                throw new RuntimeException("shouldn't happen");
        }
    }
}
