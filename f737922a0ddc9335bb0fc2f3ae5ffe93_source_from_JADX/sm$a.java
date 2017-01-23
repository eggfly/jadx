import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;

class sm$a implements rx$c {
    private final sf DW;
    private sa FH;
    private int Hw;
    final /* synthetic */ sm j6;

    public sm$a(sm smVar) {
        this.j6 = smVar;
        this.DW = smVar.j6;
        this.FH = null;
    }

    public void j6(sa saVar) {
        if (saVar == null) {
            throw new NullPointerException("frame == null");
        }
        this.FH = saVar;
    }

    public void j6(int i, int i2, int i3) {
        throw new sl("invalid opcode " + add.v5(i));
    }

    public void j6(int i, int i2, int i3, abl abl) {
        int i4 = 2;
        abl j6;
        rz Hw;
        rz Hw2;
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.DW.DW();
                break;
            case 46:
                j6 = sm.DW(abl, this.FH.Hw().FH(1));
                abl = j6.U2();
                this.DW.j6(this.FH, j6, abl.Zo);
                break;
            case 79:
                Hw = this.FH.Hw();
                if (!abl.EQ()) {
                    i4 = 3;
                }
                abl FH = Hw.FH(i4);
                boolean DW = Hw.DW(i4);
                FH = sm.DW(abl, FH);
                if (DW) {
                    abl = FH.U2();
                }
                this.DW.j6(this.FH, FH, abl.Zo, abl);
                break;
            case 87:
                if (!this.FH.Hw().FH(0).we()) {
                    this.DW.j6(this.FH, 1);
                    break;
                }
                throw sm.DW();
            case 88:
            case 92:
                Hw2 = this.FH.Hw();
                if (Hw2.FH(0).we()) {
                    this.DW.j6(this.FH, 1);
                    i4 = 17;
                } else if (Hw2.FH(1).EQ()) {
                    this.DW.j6(this.FH, 2);
                    i4 = 8481;
                } else {
                    throw sm.DW();
                }
                if (i == 92) {
                    this.DW.j6(i4);
                    break;
                }
                break;
            case 89:
                if (!this.FH.Hw().FH(0).we()) {
                    this.DW.j6(this.FH, 1);
                    this.DW.j6(17);
                    break;
                }
                throw sm.DW();
            case 90:
                Hw2 = this.FH.Hw();
                if (Hw2.FH(0).EQ() && Hw2.FH(1).EQ()) {
                    this.DW.j6(this.FH, 2);
                    this.DW.j6(530);
                    break;
                }
                throw sm.DW();
                break;
            case 91:
                Hw = this.FH.Hw();
                if (Hw.FH(0).we()) {
                    throw sm.DW();
                } else if (Hw.FH(1).we()) {
                    this.DW.j6(this.FH, 2);
                    this.DW.j6(530);
                    break;
                } else if (Hw.FH(2).EQ()) {
                    this.DW.j6(this.FH, 3);
                    this.DW.j6(12819);
                    break;
                } else {
                    throw sm.DW();
                }
            case 93:
                Hw = this.FH.Hw();
                if (!Hw.FH(0).we()) {
                    if (!Hw.FH(1).we() && !Hw.FH(2).we()) {
                        this.DW.j6(this.FH, 3);
                        this.DW.j6(205106);
                        break;
                    }
                    throw sm.DW();
                } else if (!Hw.FH(2).we()) {
                    this.DW.j6(this.FH, 2);
                    this.DW.j6(530);
                    break;
                } else {
                    throw sm.DW();
                }
                break;
            case 94:
                Hw = this.FH.Hw();
                if (Hw.FH(0).we()) {
                    if (Hw.FH(2).we()) {
                        this.DW.j6(this.FH, 2);
                        this.DW.j6(530);
                        break;
                    } else if (Hw.FH(3).EQ()) {
                        this.DW.j6(this.FH, 3);
                        this.DW.j6(12819);
                        break;
                    } else {
                        throw sm.DW();
                    }
                } else if (!Hw.FH(1).EQ()) {
                    throw sm.DW();
                } else if (Hw.FH(2).we()) {
                    this.DW.j6(this.FH, 3);
                    this.DW.j6(205106);
                    break;
                } else if (Hw.FH(3).EQ()) {
                    this.DW.j6(this.FH, 4);
                    this.DW.j6(4399427);
                    break;
                } else {
                    throw sm.DW();
                }
            case 95:
                Hw2 = this.FH.Hw();
                if (Hw2.FH(0).EQ() && Hw2.FH(1).EQ()) {
                    this.DW.j6(this.FH, 2);
                    this.DW.j6(18);
                    break;
                }
                throw sm.DW();
                break;
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 126:
            case 128:
            case 130:
                this.DW.j6(this.FH, abl, abl);
                break;
            case 116:
                this.DW.j6(this.FH, abl);
                break;
            case 120:
            case 122:
            case 124:
                this.DW.j6(this.FH, abl, abl.Zo);
                break;
            case 133:
            case 134:
            case 135:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
                this.DW.j6(this.FH, abl.Zo);
                break;
            case 136:
            case 137:
            case 138:
                this.DW.j6(this.FH, abl.VH);
                break;
            case 139:
            case 140:
            case 141:
                this.DW.j6(this.FH, abl.v5);
                break;
            case 142:
            case 143:
            case 144:
                this.DW.j6(this.FH, abl.Hw);
                break;
            case 148:
                this.DW.j6(this.FH, abl.VH, abl.VH);
                break;
            case 149:
            case 150:
                this.DW.j6(this.FH, abl.v5, abl.v5);
                break;
            case 151:
            case 152:
                this.DW.j6(this.FH, abl.Hw, abl.Hw);
                break;
            case 172:
                if (abl == abl.Ws) {
                    j6 = this.FH.Hw().FH(0);
                } else {
                    j6 = abl;
                }
                this.DW.j6(this.FH, abl);
                j6(j6);
                break;
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                this.DW.DW();
                j6(abl.u7);
                break;
            case 190:
                j6 = this.FH.Hw().FH(0);
                if (j6.XL()) {
                    this.DW.j6(this.FH, abl.Ws);
                    break;
                }
                throw new sl("type mismatch: expected array type but encountered " + j6.Hw());
            case 191:
            case 194:
            case 195:
                this.DW.j6(this.FH, abl.Ws);
                break;
            default:
                j6(i, i2, i3);
                return;
        }
        this.DW.j6(abl);
        this.DW.j6(this.FH, i2, i);
    }

    private void j6(abl abl) {
        Object DW = this.DW.j6().DW();
        if (!sg.DW(DW, abl)) {
            throw new sl("return type mismatch: prototype indicates " + DW.Hw() + ", but encountered type " + abl.Hw());
        }
    }

    public void j6(int i, int i2, int i3, int i4, abl abl, int i5) {
        zq zqVar = null;
        sc$a j6 = this.j6.FH.j6(i == 54 ? i2 + i3 : i2, i4);
        if (j6 != null) {
            abm DW = j6.DW();
            if (DW.v5() != abl.v5()) {
                rr.j6((abm) abl, DW);
                return;
            }
            abm abm = DW;
        } else {
            abl abl2 = abl;
        }
        switch (i) {
            case 21:
            case 169:
                this.DW.DW(this.FH, i4);
                this.DW.j6(j6 != null);
                this.DW.j6(abl);
                break;
            case 54:
                zq j62 = j6 == null ? null : j6.j6();
                this.DW.j6(this.FH, abl);
                this.DW.j6(abl);
                this.DW.j6(i4, abl2, j62);
                break;
            case 132:
                if (j6 != null) {
                    zqVar = j6.j6();
                }
                this.DW.DW(this.FH, i4);
                this.DW.j6(i4, abl2, zqVar);
                this.DW.j6(abl);
                this.DW.j6(i5);
                this.DW.j6(aat.j6(i5));
                break;
            default:
                j6(i, i2, i3);
                return;
        }
        this.DW.j6(this.FH, i2, i);
    }

    public void j6(int i, int i2, int i3, aah aah, int i4) {
        aah aah2;
        switch (i) {
            case 179:
                this.DW.j6(this.FH, ((aar) aah).j6());
                break;
            case 180:
            case 192:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                this.DW.j6(this.FH, abl.Ws);
                break;
            case 181:
                this.DW.j6(this.FH, abl.Ws, ((aar) aah).j6());
                break;
            case 182:
            case 183:
                aah2 = aah;
                break;
            case 184:
                this.DW.j6(this.FH, ((abb) aah).j6(true));
                break;
            case 185:
                aah2 = ((aau) aah).we();
                break;
            case 189:
                this.DW.j6(this.FH, abl.Zo);
                break;
            case 197:
                this.DW.j6(this.FH, abj.j6(abl.u7, i4));
                break;
            default:
                this.DW.DW();
                break;
        }
        this.DW.j6(this.FH, ((abb) aah2).j6(false));
        aah = aah2;
        this.DW.j6(i4);
        this.DW.j6(aah);
        this.DW.j6(this.FH, i2, i);
    }

    public void j6(int i, int i2, int i3, int i4) {
        switch (i) {
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                this.DW.j6(this.FH, abl.Zo);
                break;
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 162:
            case 163:
            case 164:
                this.DW.j6(this.FH, abl.Zo, abl.Zo);
                break;
            case 165:
            case 166:
                this.DW.j6(this.FH, abl.Ws, abl.Ws);
                break;
            case 167:
            case 168:
            case 200:
            case 201:
                this.DW.DW();
                break;
            case 198:
            case 199:
                this.DW.j6(this.FH, abl.Ws);
                break;
            default:
                j6(i, i2, i3);
                return;
        }
        this.DW.DW(i4);
        this.DW.j6(this.FH, i2, i);
    }

    public void j6(int i, int i2, int i3, sn snVar, int i4) {
        this.DW.j6(this.FH, abl.Zo);
        this.DW.j6(i4);
        this.DW.j6(snVar);
        this.DW.j6(this.FH, i2, i);
    }

    public void j6(int i, int i2, abf abf, ArrayList<aah> arrayList) {
        this.DW.j6(this.FH, abl.Zo);
        this.DW.j6((ArrayList) arrayList);
        this.DW.j6((aah) abf);
        this.DW.j6(this.FH, i, 188);
    }

    public void j6(int i) {
        this.Hw = i;
    }

    public int j6() {
        return this.Hw;
    }
}
