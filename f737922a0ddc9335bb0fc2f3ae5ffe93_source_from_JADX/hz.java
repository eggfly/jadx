import com.aide.uidesigner.ProxyTextView;
import java.io.Reader;

public class hz {
    private final int DW;
    private hz$a EQ;
    private final int FH;
    private final ec Hw;
    private boolean J0;
    private cm J8;
    private int QX;
    private final int VH;
    private int Ws;
    private int XL;
    private final int Zo;
    private int aM;
    private final int gn;
    private int j3;
    private final cc j6;
    private hz$a tp;
    private final int u7;
    private final ec v5;
    private cj we;

    public hz(cc ccVar) {
        this.j6 = ccVar;
        this.tp = new hz$a(this, ccVar);
        this.EQ = new hz$a(this, ccVar);
        this.DW = ccVar.ro.j6("RUNAT");
        this.FH = ccVar.ro.j6("SERVER");
        this.Zo = ccVar.ro.j6("SRC");
        this.VH = ccVar.ro.j6("SCRIPT");
        this.gn = ccVar.ro.j6("TYPE");
        this.u7 = ccVar.ro.j6("LANGUAGE");
        this.v5 = new ec();
        this.v5.j6(ccVar.ro.FH(ccVar.ro.j6("onclientclick")));
        this.Hw = new ec();
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onabort")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onblur")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onchange")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onclick")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("ondblclick")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onerror")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onfocus")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onkeydown")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onkeypress")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onkeyup")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onload")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onmousedown")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onmousemove")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onmouseout")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onmouseover")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onmouseup")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onreset")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onselect")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onsubmit")));
        this.Hw.j6(ccVar.ro.FH(ccVar.ro.j6("onunload")));
        this.Ws = ccVar.ro.FH(ccVar.ro.j6("amp"));
        this.QX = ccVar.ro.FH(ccVar.ro.j6("apos"));
        this.XL = ccVar.ro.FH(ccVar.ro.j6("quot"));
        this.aM = ccVar.ro.FH(ccVar.ro.j6("lt"));
        this.j3 = ccVar.ro.FH(ccVar.ro.j6("gt"));
    }

    public void j6(cj cjVar, cm cmVar, boolean z) {
        this.we = cjVar;
        this.J8 = cmVar;
        this.J0 = z;
        this.tp.j6();
        j6(cjVar.Ws());
        this.we = null;
        this.J8 = null;
    }

    public Reader j6() {
        return this.tp.Hw();
    }

    private void j6(int i) {
        if (!this.we.er(i)) {
            int a8;
            int Hw;
            int lg;
            int Hw2;
            switch (this.we.rN(i)) {
                case 203:
                    a8 = ik.a8(this.we, i);
                    if ((this.Hw.FH(a8) && !FH(this.we.aM(this.we.aM(i)))) || (this.v5.FH(a8) && FH(this.we.aM(this.we.aM(i))))) {
                        Hw = this.we.Hw(i, this.we.lg(i) - 1);
                        if (this.J8 != null) {
                            this.J8.j6(46, 0, this.we.nw(Hw), this.we.KD(Hw), this.we.SI(Hw), this.we.ro(Hw));
                        }
                        lg = this.we.lg(Hw);
                        if (lg == 1) {
                            a8 = this.we.Hw(Hw, 0);
                            this.tp.FH(a8);
                            this.tp.j6(this.we.gW(a8));
                        } else {
                            for (a8 = 1; a8 < lg - 1; a8++) {
                                Hw2 = this.we.Hw(Hw, a8);
                                switch (this.we.rN(Hw2)) {
                                    case 16:
                                        this.tp.FH(Hw2);
                                        this.tp.FH("'");
                                        break;
                                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                                        this.tp.FH(Hw2);
                                        this.tp.j6('\"');
                                        break;
                                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                                        this.tp.FH(Hw2);
                                        this.tp.j6(this.we.j3(Hw2), this.we.Mr(Hw2), this.we.U2(Hw2));
                                        break;
                                    case 205:
                                        this.tp.FH(Hw2);
                                        Hw2 = this.j6.ro.FH(this.we.gW(this.we.Hw(Hw2, 1)));
                                        if (Hw2 != this.aM) {
                                            if (Hw2 != this.j3) {
                                                if (Hw2 != this.XL) {
                                                    if (Hw2 != this.QX) {
                                                        if (Hw2 != this.Ws) {
                                                            break;
                                                        }
                                                        this.tp.j6('&');
                                                        break;
                                                    }
                                                    this.tp.FH("'");
                                                    break;
                                                }
                                                this.tp.j6('\"');
                                                break;
                                            }
                                            this.tp.j6('>');
                                            break;
                                        }
                                        this.tp.j6('<');
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        this.tp.DW();
                        this.tp.j6('\n');
                        this.tp.j6(';');
                    }
                case 210:
                    lg = this.we.Hw(i, 0);
                    if (this.j6.ro.FH(this.we.gW(this.we.Hw(this.we.Hw(lg, 1), 2))) == this.VH && DW(i)) {
                        int Hw3;
                        for (a8 = 0; a8 < this.we.lg(lg); a8++) {
                            Hw2 = this.we.Hw(lg, a8);
                            if (this.j6.ro.FH(this.we.gW(this.we.Hw(Hw2, 0))) == this.Zo) {
                                Hw2 = this.we.Hw(Hw2, this.we.lg(Hw2) - 1);
                                if (this.we.lg(Hw2) == 3) {
                                    Hw3 = this.we.Hw(Hw2, 0);
                                    Hw2 = this.we.Hw(Hw2, 1);
                                    switch (this.we.rN(Hw3)) {
                                        case 16:
                                            if (this.we.rN(Hw2) != 18) {
                                                break;
                                            }
                                            this.tp.DW();
                                            this.tp.FH(":'");
                                            this.tp.FH(this.we.a8(Hw2));
                                            this.tp.FH("'");
                                            break;
                                        case ProxyTextView.INPUTTYPE_textUri /*17*/:
                                            if (this.we.rN(Hw2) != 18) {
                                                break;
                                            }
                                            this.tp.DW();
                                            this.tp.FH(":\"");
                                            this.tp.FH(this.we.a8(Hw2));
                                            this.tp.FH("\"");
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        int Hw4 = this.we.Hw(i, 1);
                        if (this.we.lg(Hw4) <= 0) {
                            return;
                        }
                        if (this.we.rN(this.we.Hw(Hw4, 0)) == 46 || this.we.rN(this.we.Hw(Hw4, 0)) == 47) {
                            for (a8 = 0; a8 < this.we.lg(Hw4); a8++) {
                                Hw = this.we.Hw(Hw4, a8);
                                switch (this.we.rN(Hw)) {
                                    case 46:
                                        char[] j3 = this.we.j3(Hw);
                                        int Mr = this.we.Mr(Hw);
                                        Hw3 = (this.we.U2(Hw) + Mr) - 1;
                                        Object obj = null;
                                        Hw2 = Mr;
                                        while (Hw2 < Hw3 && (j3[Hw2] == ' ' || j3[Hw2] == '\t' || j3[Hw2] == '\n')) {
                                            Hw2++;
                                        }
                                        if (Hw2 < Hw3 && j3[Hw2] == '<') {
                                            Hw2++;
                                            if (Hw2 < Hw3 && j3[Hw2] == '!') {
                                                Hw2++;
                                                if (Hw2 < Hw3 && j3[Hw2] == '-') {
                                                    Hw2++;
                                                    if (Hw2 < Hw3 && j3[Hw2] == '-') {
                                                        Hw2++;
                                                        obj = 1;
                                                    }
                                                }
                                            }
                                        }
                                        int i2 = Hw3;
                                        while (Mr < i2 && (j3[i2] == ' ' || j3[i2] == '\t' || j3[i2] == '\n')) {
                                            i2--;
                                        }
                                        if (Mr < i2 && j3[i2] == '>') {
                                            i2--;
                                            if (Mr < i2 && j3[i2] == '-') {
                                                i2--;
                                                if (Mr < i2 && j3[i2] == '-') {
                                                    Hw3 = i2 - 1;
                                                }
                                            }
                                        }
                                        this.tp.FH(Hw);
                                        if (obj != null) {
                                            while (Mr < Hw2) {
                                                if (j3[Mr] == '\n') {
                                                    this.tp.j6('\n');
                                                } else {
                                                    this.tp.j6(' ');
                                                }
                                                Mr++;
                                            }
                                        } else {
                                            Hw2 = Mr;
                                        }
                                        this.tp.j6(j3, Hw2, (Hw3 - Hw2) + 1);
                                        break;
                                    case 47:
                                        this.tp.FH("</");
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.tp.j6('\n');
                            this.tp.DW();
                            return;
                        }
                        return;
                    }
                    lg = this.we.lg(i);
                    for (a8 = 0; a8 < lg; a8++) {
                        j6(this.we.Hw(i, a8));
                    }
                default:
                    lg = this.we.lg(i);
                    for (a8 = 0; a8 < lg; a8++) {
                        j6(this.we.Hw(i, a8));
                    }
            }
        }
    }

    private boolean DW(int i) {
        if (FH(i)) {
            return false;
        }
        int Hw = this.we.Hw(i, 0);
        for (int i2 = 0; i2 < this.we.lg(Hw); i2++) {
            int Hw2 = this.we.Hw(Hw, i2);
            if (this.we.rN(Hw2) == 203) {
                int a8 = ik.a8(this.we, Hw2);
                if (a8 == this.gn || a8 == this.u7) {
                    Zo(Hw2);
                    this.EQ.Zo();
                    if (this.EQ.DW("JAVASCRIPT") == -1 && this.EQ.DW("JSCRIPT") == -1) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return true;
    }

    private boolean FH(int i) {
        return Hw(this.we.Hw(i, 0));
    }

    private boolean Hw(int i) {
        for (int i2 = 0; i2 < this.we.lg(i); i2++) {
            int Hw = this.we.Hw(i, i2);
            if (this.we.rN(Hw) == 203 && v5(Hw)) {
                return true;
            }
        }
        return false;
    }

    private boolean v5(int i) {
        boolean z = true;
        if (ik.a8(this.we, i) != this.DW) {
            return false;
        }
        int Hw = this.we.Hw(i, this.we.lg(i) - 1);
        int Hw2 = this.we.Hw(Hw, 0);
        switch (this.we.rN(Hw2)) {
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                int Hw3 = this.we.Hw(Hw, 1);
                if (this.we.rN(Hw3) == 18 && this.we.lg(Hw) == 3) {
                    return j6("SERVER", this.we.j3(Hw3), this.we.Mr(Hw3), this.we.U2(Hw3));
                }
                return false;
            case 26:
            case 50:
                if (this.j6.ro.FH(this.we.gW(Hw2)) != this.FH) {
                    z = false;
                }
                return z;
            default:
                return false;
        }
    }

    private boolean j6(String str, char[] cArr, int i, int i2) {
        if (str.length() != i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (str.charAt(i3) != Character.toUpperCase(cArr[i + i3])) {
                return false;
            }
        }
        return true;
    }

    private void Zo(int i) {
        this.EQ.j6();
        int Hw = this.we.Hw(i, this.we.lg(i) - 1);
        int Hw2 = this.we.Hw(Hw, 0);
        switch (this.we.rN(Hw2)) {
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                for (Hw2 = 1; Hw2 < this.we.lg(Hw) - 1; Hw2++) {
                    int Hw3 = this.we.Hw(Hw, Hw2);
                    if (this.we.rN(Hw3) == 18) {
                        this.EQ.j6(this.we.j3(Hw3), this.we.Mr(Hw3), this.we.U2(Hw3));
                    }
                }
            case 26:
            case 50:
                this.EQ.j6(this.we.gW(Hw2));
            default:
        }
    }
}
