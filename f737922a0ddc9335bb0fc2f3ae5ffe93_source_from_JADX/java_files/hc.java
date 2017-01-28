import com.aide.engine.service.Native;
import com.aide.uidesigner.ProxyTextView;

public class hc implements bn {
    private int BT;
    private final by DW;
    private int EQ;
    private final bj FH;
    private final boolean Hw;
    private int I;
    private int J0;
    private int J8;
    private int KD;
    private int Mr;
    private int Mz;
    private int P8;
    private int QX;
    private int SI;
    private int Sf;
    private int U2;
    private int VH;
    private int Ws;
    private int XL;
    private int Zo;
    private int a8;
    private int aM;
    private int ca;
    private int cb;
    private int cn;
    private int dx;
    private int ef;
    private int ei;
    private int er;
    private int g3;
    private int gW;
    private int gn;
    private int j3;
    private final bt j6;
    private int lg;
    private int nw;
    private int rN;
    private int ro;
    private int sG;
    private int sh;
    private int tp;
    private int u7;
    private final boolean v5;
    private int vJ;
    private int vy;
    private int we;
    private int yS;

    public hc(cc ccVar, bj bjVar) {
        this.Hw = true;
        this.v5 = true;
        this.j6 = ccVar.cb;
        this.DW = ccVar.ro;
        this.FH = bjVar;
        this.Zo = this.DW.j6("length");
        this.VH = this.DW.j6("clone");
        this.u7 = this.DW.j6("lang");
        this.XL = this.DW.j6("Array");
        this.tp = this.DW.j6("java");
        this.we = this.DW.j6("Number");
        this.Ws = this.DW.j6("Boolean");
        this.j3 = this.DW.j6("Long");
        this.Mr = this.DW.j6("Integer");
        this.U2 = this.DW.j6("Short");
        this.a8 = this.DW.j6("Character");
        this.lg = this.DW.j6("Override");
        this.rN = this.DW.j6("Byte");
        this.er = this.DW.j6("Float");
        this.yS = this.DW.j6("Double");
        this.gW = this.DW.j6("Void");
        this.BT = this.DW.j6("Cloneable");
        this.vy = this.DW.j6("String");
        this.P8 = this.DW.j6("Class");
        this.ei = this.DW.j6("Exception");
        this.nw = this.DW.j6("Throwable");
        this.SI = this.DW.j6("RuntimeException");
        this.KD = this.DW.j6("Error");
        this.EQ = this.DW.j6("System");
        this.ro = this.DW.j6("getClass");
        this.QX = this.DW.j6("Object");
        this.aM = this.DW.j6("Iterable");
        this.J0 = this.DW.j6("util");
        this.cn = this.DW.j6("Enum");
        this.J8 = this.DW.j6("Collection");
        this.cb = this.DW.j6("io");
        this.sh = this.DW.j6("Serializable");
        this.gn = this.DW.j6("Invoke");
        this.sG = this.DW.j6("hashCode");
        this.dx = this.DW.j6("equals");
        this.ef = this.DW.j6("finalize");
        this.Sf = this.DW.j6("toString");
        this.vJ = this.DW.j6("junit");
        this.g3 = this.DW.j6("framework");
        this.Mz = this.DW.j6("TestCase");
        this.I = this.DW.j6("package-info");
        this.ca = this.DW.j6("AutoCloseable");
    }

    public boolean DW(bv bvVar, co coVar) {
        if (coVar == J8(bvVar) || coVar == Ws(bvVar) || coVar == XL(bvVar) || coVar == aM(bvVar) || coVar == j3(bvVar)) {
            return true;
        }
        return false;
    }

    public bp FH(bv bvVar) {
        return Mr().j6(bvVar, this.vJ, true).j6(bvVar, this.g3, true).DW(bvVar, this.FH, this.Mz, true, 0, Mr());
    }

    public int v5() {
        return this.ro;
    }

    public boolean FH(bv bvVar, co coVar) {
        try {
            if (coVar.FH(bvVar, this.FH, yS(bvVar))) {
                return true;
            }
        } catch (ej e) {
        }
        return false;
    }

    public boolean Hw(bv bvVar, co coVar) {
        try {
            if (coVar.FH(bvVar, this.FH, vy(bvVar)) || coVar.FH(bvVar, this.FH, BT(bvVar))) {
                return false;
            }
            return true;
        } catch (ej e) {
            return false;
        }
    }

    public boolean j6(bz bzVar) {
        return bzVar.aq() == this.VH && bzVar.lp() == 0;
    }

    public int Zo() {
        return this.VH;
    }

    public int VH() {
        return this.Zo;
    }

    public int gn() {
        return this.I;
    }

    public boolean j6(co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 16:
                return false;
            default:
                return true;
        }
    }

    public boolean DW(co coVar) {
        switch (coVar.Gj()) {
            case 16:
                return true;
            default:
                return false;
        }
    }

    public ce Hw(bv bvVar) {
        return Mr().j6(bvVar, this.tp, true).j6(bvVar, this.u7, true);
    }

    public bp v5(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.QX, true, 0, Mr());
    }

    public bp Zo(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.QX, true, 0, Mr());
    }

    public bp VH(bv bvVar) {
        return Mr().j6(bvVar, this.tp, true).j6(bvVar, this.J0, true).DW(bvVar, this.FH, this.J8, true, 0, Hw(bvVar));
    }

    public boolean gn(bv bvVar) {
        try {
            return Mr().j6(bvVar, this.tp, true).j6(bvVar, this.J0, true).FH(bvVar, this.FH, this.J8, true, 0, Hw(bvVar));
        } catch (ej e) {
            return false;
        }
    }

    public bp u7(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.aM, true, 0, Hw(bvVar));
    }

    public boolean tp(bv bvVar) {
        try {
            return Hw(bvVar).FH(bvVar, this.FH, this.aM, true, 0, Hw(bvVar));
        } catch (ej e) {
            return false;
        }
    }

    public bp EQ(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.Ws, true, 0, Hw(bvVar));
    }

    public bp we(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.ca, true, 0, Hw(bvVar));
    }

    public bp J0(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.cn, true, 0, Hw(bvVar));
    }

    public bp J8(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.rN, true, 0, Hw(bvVar));
    }

    public bp Ws(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.a8, true, 0, Hw(bvVar));
    }

    public bp QX(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.lg, true, 0, Hw(bvVar));
    }

    public bp XL(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.U2, true, 0, Hw(bvVar));
    }

    public bp aM(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.Mr, true, 0, Hw(bvVar));
    }

    public bp j3(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.j3, true, 0, Hw(bvVar));
    }

    public bp Mr(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.er, true, 0, Hw(bvVar));
    }

    public bp U2(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.yS, true, 0, Hw(bvVar));
    }

    public bp a8(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.gW, true, 0, Hw(bvVar));
    }

    public bp lg(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.vy, true, 0, Hw(bvVar));
    }

    public bp rN(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.vy, true, 0, Hw(bvVar));
    }

    public bp er(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.P8, true, 0, Hw(bvVar));
    }

    public bp yS(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.nw, true, 0, Hw(bvVar));
    }

    public bp gW(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.BT, true, 0, Hw(bvVar));
    }

    public bp BT(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.SI, true, 0, Hw(bvVar));
    }

    public bp vy(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.KD, true, 0, Hw(bvVar));
    }

    public bp P8(bv bvVar) {
        return Hw(bvVar).DW(bvVar, this.FH, this.ei, true, 0, Hw(bvVar));
    }

    public bp ei(bv bvVar) {
        return Mr().j6(bvVar, this.tp, true).j6(bvVar, this.cb, true).DW(bvVar, this.FH, this.sh, true, 0, Hw(bvVar));
    }

    public ci u7() {
        return this.j6.j6(this.FH, 8);
    }

    public ci tp() {
        return this.j6.j6(this.FH, 9);
    }

    public ci EQ() {
        return this.j6.j6(this.FH, 1);
    }

    public ci we() {
        return this.j6.j6(this.FH, 10);
    }

    public ci J0() {
        return this.j6.j6(this.FH, 4);
    }

    public ci J8() {
        return this.j6.j6(this.FH, 6);
    }

    public ci Ws() {
        return this.j6.j6(this.FH, 2);
    }

    public ci QX() {
        return this.j6.j6(this.FH, 3);
    }

    public ci XL() {
        return this.j6.j6(this.FH, 0);
    }

    public ci aM() {
        return this.j6.j6(this.FH, 5);
    }

    public ci j3() {
        return this.j6.j6(this.FH, 7);
    }

    public ce Mr() {
        return this.j6.Zo();
    }

    public int j6(ce ceVar, int i) {
        return 16;
    }

    public int j6(int i) {
        return Native.j6.c(i);
    }

    public bp j6(bv bvVar) {
        return Zo(bvVar);
    }

    public bp DW(bv bvVar) {
        return Zo(bvVar);
    }

    public boolean j6(bv bvVar, bp bpVar, bp bpVar2) {
        if (bpVar == bpVar2) {
            return true;
        }
        if (bpVar2.J0()) {
            return j6(bvVar, bpVar, bpVar2.Xa());
        }
        return false;
    }

    public boolean DW(bv bvVar, bp bpVar, bp bpVar2) {
        if (bpVar == bpVar2 || bpVar2.FH((co) bpVar)) {
            return true;
        }
        if (bpVar2.J0()) {
            return DW(bvVar, bpVar, bpVar2.Xa());
        }
        return false;
    }

    public boolean FH(co coVar) {
        return (coVar.Ev() & 536870912) != 0;
    }

    public boolean Hw(bv bvVar, co coVar, co coVar2) {
        if (coVar2.n5() && coVar.cT() && (coVar.e3() || !coVar.j6(bvVar, this.FH, coVar2))) {
            return true;
        }
        return false;
    }

    public boolean v5(bv bvVar, co coVar, co coVar2) {
        try {
            if (j6(coVar) && DW(coVar2)) {
                return j6(bvVar, coVar).FH(bvVar, this.FH, coVar2);
            }
        } catch (ej e) {
        }
        return false;
    }

    public boolean Zo(bv bvVar, co coVar, co coVar2) {
        try {
            if (j6(coVar2) && DW(coVar)) {
                if (this.v5 && coVar == v5(bvVar)) {
                    return true;
                }
                return v5(bvVar, coVar).FH(bvVar, this.FH, coVar2);
            }
        } catch (ej e) {
        }
        return false;
    }

    public boolean j6(bv bvVar, co coVar, co coVar2, boolean z) {
        if (!z || j6(coVar2) == j6(coVar)) {
            return coVar.FH(bvVar, this.FH, coVar2);
        }
        return false;
    }

    public boolean j6(bz bzVar, co coVar, co[] coVarArr, int i, int i2) {
        co DW;
        if (coVar.cT()) {
            DW = ((bp) coVar).DW(bzVar);
        } else if (!coVar.n5()) {
            return false;
        } else {
            DW = ((cf) coVar).gn().DW(bzVar);
        }
        int lp = bzVar.lp();
        int i3 = 0;
        while (i3 < lp) {
            try {
                co v5 = bzVar.v5(i3);
                if (v5.q7() && DW.n5() && coVar.n5()) {
                    v5 = ((cf) DW).j6(v5, false);
                    if (v5.q7()) {
                        if (((cg) v5).gn() == ((cf) coVar).gn()) {
                            if (((cf) coVar).FH()[((cg) v5).Zo()] != 2) {
                                if (((cf) coVar).FH()[((cg) v5).Zo()] != 1) {
                                    continue;
                                }
                            }
                            if (i2 > i3 && coVarArr[i + i3].Gj() != 2) {
                                return true;
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (ej e) {
            }
            i3++;
        }
        return false;
    }

    public boolean VH(bv bvVar, co coVar, co coVar2) {
        return coVar2.Z1() || coVar2.q7() || EQ(bvVar, coVar, coVar2);
    }

    public co j6(bv bvVar, co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return J8(bvVar);
            case 5:
                return XL(bvVar);
            case 7:
                return aM(bvVar);
            case 9:
                return j3(bvVar);
            case 11:
                return EQ(bvVar);
            case 12:
                return Ws(bvVar);
            case 13:
                return Mr(bvVar);
            case 14:
                return U2(bvVar);
            default:
                throw new ej();
        }
    }

    public co v5(bv bvVar, co coVar) {
        if (coVar == EQ(bvVar)) {
            return XL();
        }
        if (coVar == J8(bvVar)) {
            return EQ();
        }
        if (coVar == Ws(bvVar)) {
            return QX();
        }
        if (coVar == XL(bvVar)) {
            return Ws();
        }
        if (coVar == aM(bvVar)) {
            return J0();
        }
        if (coVar == j3(bvVar)) {
            return aM();
        }
        if (coVar == Mr(bvVar)) {
            return J8();
        }
        if (coVar == U2(bvVar)) {
            return j3();
        }
        throw new ej();
    }

    public co j6(bv bvVar, co coVar, co coVar2) {
        if (coVar.Hw(coVar2)) {
            return coVar;
        }
        if (this.Hw && coVar.Gj() == 2 && j6(coVar2)) {
            return j6(bvVar, coVar2);
        }
        if (this.Hw && coVar2.Gj() == 2 && j6(coVar)) {
            return j6(bvVar, coVar);
        }
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                switch (coVar2.Gj()) {
                    case 5:
                        return Ws();
                    case 12:
                        return EQ();
                    default:
                        return j6(bvVar, 9, coVar, coVar2);
                }
            case 5:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 12:
                        return Ws();
                    default:
                        return j6(bvVar, 9, coVar, coVar2);
                }
            case 7:
            case 9:
            case 13:
            case 14:
                return j6(bvVar, 9, coVar, coVar2);
            case 12:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        return EQ();
                    case 5:
                        return Ws();
                    default:
                        return j6(bvVar, 9, coVar, coVar2);
                }
            default:
                if (coVar.Gj() == 2 && DW(coVar2)) {
                    return coVar2;
                }
                if (coVar2.Gj() == 2 && DW(coVar)) {
                    return coVar;
                }
                if (coVar.FH(bvVar, this.FH, coVar2)) {
                    return coVar2;
                }
                if (coVar2.FH(bvVar, this.FH, coVar)) {
                    return coVar;
                }
                if (this.Hw) {
                    co v5;
                    co v52;
                    try {
                        if (DW(coVar)) {
                            v5 = v5(bvVar, coVar);
                        } else {
                            v5 = coVar;
                        }
                    } catch (ej e) {
                        v5 = coVar;
                    }
                    try {
                        if (DW(coVar2)) {
                            v52 = v5(bvVar, coVar2);
                        } else {
                            v52 = coVar2;
                        }
                    } catch (ej e2) {
                        v52 = coVar2;
                    }
                    if (v5.FH(bvVar, this.FH, v52)) {
                        return v52;
                    }
                    if (v52.FH(bvVar, this.FH, v5)) {
                        return v5;
                    }
                }
                if (this.Hw && ((coVar.cT() || coVar.n5()) && ((coVar2.cT() || coVar2.n5()) && coVar.a_() == er(bvVar) && coVar2.a_() == er(bvVar)))) {
                    return er(bvVar).j6(new co[]{Zo(bvVar)}, new int[]{1});
                } else if (this.Hw && DW(coVar) && DW(coVar2)) {
                    return coVar.Hw(bvVar, this.FH, coVar2);
                } else {
                    if (this.Hw && DW(coVar) && j6(coVar2)) {
                        return coVar.Hw(bvVar, this.FH, j6(bvVar, coVar2));
                    }
                    if (this.Hw && j6(coVar) && DW(coVar2)) {
                        return j6(bvVar, coVar).Hw(bvVar, this.FH, coVar2);
                    }
                    throw new ej();
                }
        }
    }

    public co j6(bv bvVar, int i, co coVar) {
        co v5;
        if (this.Hw && DW(coVar)) {
            v5 = v5(bvVar, coVar);
        } else {
            v5 = coVar;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                switch (v5.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        return J0();
                    case 9:
                    case 13:
                    case 14:
                        return v5;
                    default:
                        throw new ej();
                }
            case ProxyTextView.INPUTTYPE_date /*20*/:
                switch (v5.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        return J0();
                    case 9:
                        return v5;
                    default:
                        throw new ej();
                }
            case 21:
                if (v5.Gj() == 11) {
                    return v5;
                }
                throw new ej();
            case 23:
            case 24:
                switch (v5.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 9:
                    case 12:
                    case 13:
                    case 14:
                        return v5;
                    default:
                        throw new ej();
                }
            default:
                throw new ej();
        }
    }

    public boolean gn(bv bvVar, co coVar, co coVar2) {
        if (j6(coVar) && j6(coVar2)) {
            return true;
        }
        if (!this.Hw) {
            return false;
        }
        if (!j6(coVar) && !j6(coVar2)) {
            return false;
        }
        try {
            if (this.Hw && DW(coVar)) {
                v5(bvVar, coVar);
            }
            if (!this.Hw || !DW(coVar2)) {
                return true;
            }
            v5(bvVar, coVar2);
            return true;
        } catch (ej e) {
            return false;
        }
    }

    public co DW(bv bvVar, int i, co coVar, co coVar2) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (coVar == lg(bvVar) && coVar2.Gj() != 1) {
                    return coVar;
                }
                if (coVar2 != lg(bvVar) || coVar.Gj() == 1) {
                    return j6(bvVar, i, coVar, coVar2);
                }
                return coVar2;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
                return j6(bvVar, i, coVar, coVar2);
            case 6:
            case 7:
            case 8:
                if (this.Hw && DW(coVar)) {
                    coVar = v5(bvVar, coVar);
                }
                if (this.Hw && DW(coVar2)) {
                    coVar2 = v5(bvVar, coVar2);
                }
                if (coVar.Gj() == 11) {
                    if (coVar2.Gj() == 11) {
                        return XL();
                    }
                    throw new ej();
                } else if (coVar2.Gj() != 11) {
                    coVar = j6(bvVar, i, coVar, coVar2);
                    if (coVar.Gj() == 13) {
                        throw new ej();
                    } else if (coVar.Gj() != 14) {
                        return coVar;
                    } else {
                        throw new ej();
                    }
                } else if (coVar.Gj() == 11) {
                    return XL();
                } else {
                    throw new ej();
                }
            case 9:
            case 10:
                if (j6(coVar) != j6(coVar2)) {
                    if (this.Hw) {
                        try {
                            if (!j6(coVar)) {
                                coVar = v5(bvVar, coVar);
                            }
                            if (!j6(coVar2)) {
                                coVar2 = v5(bvVar, coVar2);
                            }
                            return DW(bvVar, i, coVar, coVar2);
                        } catch (ej e) {
                        }
                    } else {
                        throw new ej();
                    }
                }
                if (coVar.DW(bvVar, this.FH, coVar2)) {
                    return XL();
                }
                if (coVar2.DW(bvVar, this.FH, coVar)) {
                    return XL();
                }
                if (coVar.a_().DW(bvVar, this.FH, coVar2.a_())) {
                    return XL();
                }
                if (coVar2.a_().DW(bvVar, this.FH, coVar.a_())) {
                    return XL();
                }
                throw new ej();
            case 11:
            case 12:
            case 13:
            case 14:
                j6(bvVar, i, coVar, coVar2);
                return XL();
            case 15:
            case 16:
                if (this.Hw && DW(coVar)) {
                    coVar = v5(bvVar, coVar);
                }
                if (this.Hw && DW(coVar2)) {
                    coVar2 = v5(bvVar, coVar2);
                }
                if (coVar.Gj() != 11) {
                    throw new ej();
                } else if (coVar2.Gj() == 11) {
                    return XL();
                } else {
                    throw new ej();
                }
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case 19:
                if (this.Hw && DW(coVar)) {
                    coVar = v5(bvVar, coVar);
                }
                if (this.Hw && DW(coVar2)) {
                    coVar2 = v5(bvVar, coVar2);
                }
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 9:
                    case 12:
                        switch (coVar.Gj()) {
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 7:
                            case 12:
                                return J0();
                            case 9:
                                return coVar;
                            default:
                                break;
                        }
                }
                throw new ej();
            case 22:
                try {
                    if (coVar2.FH(bvVar, this.FH, coVar)) {
                        return coVar;
                    }
                    throw new ej();
                } catch (ej e2) {
                    break;
                }
            case 25:
            case 26:
            case 27:
            case 28:
                if (DW(bvVar, 3, coVar, coVar2).DW(bvVar, this.FH, coVar)) {
                    return coVar;
                }
                throw new ej();
            case 29:
                if (DW(bvVar, 1, coVar, coVar2).DW(bvVar, this.FH, coVar)) {
                    return coVar;
                }
                throw new ej();
            case 30:
            case 31:
            case 32:
                if (DW(bvVar, 7, coVar, coVar2).DW(bvVar, this.FH, coVar)) {
                    return coVar;
                }
                throw new ej();
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
            case 34:
            case 35:
                if (DW(bvVar, 17, coVar, coVar2).DW(bvVar, this.FH, coVar)) {
                    return coVar;
                }
                throw new ej();
            default:
                throw new ej();
        }
        throw new ej();
    }

    public co j6(bv bvVar, int i, co coVar, co coVar2) {
        if (this.Hw && DW(coVar)) {
            coVar = v5(bvVar, coVar);
        }
        if (this.Hw && DW(coVar2)) {
            coVar2 = v5(bvVar, coVar2);
        }
        return j6(coVar, coVar2);
    }

    private co j6(co coVar, co coVar2) {
        int Gj = coVar.Gj();
        int Gj2 = coVar2.Gj();
        int j6 = j6(Gj, Gj2);
        if (j6 == 7) {
            return J0();
        }
        if (j6 == Gj) {
            return coVar;
        }
        if (j6 == Gj2) {
            return coVar2;
        }
        throw new ej();
    }

    private int j6(int i, int i2) {
        return Native.j6.a(i, i2);
    }

    public boolean FH(bv bvVar, co coVar, co coVar2) {
        if (this.Hw && Zo(bvVar, coVar, coVar2)) {
            return true;
        }
        if (this.Hw && v5(bvVar, coVar, coVar2)) {
            return true;
        }
        try {
            if (coVar2.Hw(coVar)) {
                return true;
            }
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case 11:
                    return false;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    return DW(coVar2);
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 13:
                        case 14:
                            return true;
                        default:
                            return false;
                    }
                default:
                    if (!DW(coVar2)) {
                        return false;
                    }
                    co sg;
                    if (coVar.sE()) {
                        sg = coVar.sg();
                    } else {
                        sg = coVar;
                    }
                    if (coVar2 == Zo(bvVar)) {
                        return true;
                    }
                    if (sg.g3()) {
                        if (coVar2.g3()) {
                            return true;
                        }
                        if (!coVar2.vJ()) {
                            return true;
                        }
                    }
                    if (coVar2.g3() && !sg.vJ()) {
                        return true;
                    }
                    if (sg.cT()) {
                        if (sg == Zo(bvVar)) {
                            return true;
                        }
                        if (coVar2.cT()) {
                            if (((bp) sg).FH((bp) coVar2) || ((bp) coVar2).FH((bp) sg)) {
                                return true;
                            }
                        } else if (!coVar2.AL()) {
                            return coVar2.n5() ? FH(bvVar, sg, coVar2.a_()) : true;
                        } else {
                            if (sg == gW(bvVar)) {
                                return true;
                            }
                            if (sg == ei(bvVar)) {
                                return true;
                            }
                        }
                    } else if (sg.n5()) {
                        if (coVar2.cT()) {
                            return FH(bvVar, sg.a_(), coVar2);
                        }
                        return coVar2.n5() ? FH(bvVar, sg.a_(), coVar2.a_()) : true;
                    } else if (!sg.AL()) {
                        return true;
                    } else {
                        if (coVar2.cT()) {
                            if (coVar2 == gW(bvVar)) {
                                return true;
                            }
                            if (coVar2 == ei(bvVar)) {
                                return true;
                            }
                        } else if (coVar2.n5()) {
                            return false;
                        } else {
                            if (!coVar2.AL()) {
                                return true;
                            }
                            co FH = ((bo) sg).FH();
                            if (!DW(FH)) {
                                return false;
                            }
                            sg = ((bo) coVar2).FH();
                            if (DW(sg)) {
                                return FH(bvVar, FH, sg);
                            }
                            return false;
                        }
                    }
                    break;
            }
            return false;
        } catch (ej e) {
        }
    }

    public boolean DW(bz bzVar) {
        if (bzVar.I()) {
            return false;
        }
        int lp = bzVar.lp();
        int i = 0;
        while (i < lp) {
            try {
                co v5 = bzVar.v5(i);
                if (v5.a_() != v5) {
                    return true;
                }
                i++;
            } catch (ej e) {
            }
        }
        return false;
    }

    public boolean FH() {
        return this.Hw;
    }

    public ea<co> j6(bv bvVar, bo boVar) {
        return null;
    }

    public boolean DW(bv bvVar, co coVar, co coVar2) {
        if (this.Hw && v5(bvVar, coVar, coVar2)) {
            return true;
        }
        if (this.Hw && Zo(bvVar, coVar, coVar2)) {
            return true;
        }
        if (coVar2.Hw(coVar)) {
            return true;
        }
        if (u7(bvVar, coVar, coVar2)) {
            return true;
        }
        if (coVar.Gj() == 2) {
            return DW(coVar2);
        }
        try {
            if (coVar2 == Zo(bvVar) && DW(coVar)) {
                return true;
            }
        } catch (ej e) {
        }
        co FH;
        if (coVar.AL()) {
            try {
                if (coVar2 == gW(bvVar)) {
                    return true;
                }
                if (coVar2 == ei(bvVar)) {
                    return true;
                }
                if (!coVar2.AL()) {
                    return false;
                }
                if (((bo) coVar).DW() != ((bo) coVar2).DW()) {
                    return false;
                }
                FH = ((bo) coVar).FH();
                co FH2 = ((bo) coVar2).FH();
                if (FH2.Hw(FH)) {
                    return true;
                }
                if (!DW(FH)) {
                    return false;
                }
                if (DW(FH2)) {
                    return FH.FH(bvVar, this.FH, FH2);
                }
                return false;
            } catch (ej e2) {
            }
        } else {
            if (coVar.cT()) {
                if (coVar2.cT()) {
                    if (((bp) coVar).FH((bp) coVar2)) {
                        return true;
                    }
                } else if (coVar2.n5()) {
                    if (coVar == ((cf) coVar2).gn()) {
                        return true;
                    }
                    if (coVar.j6(bvVar, this.FH, coVar2)) {
                        return true;
                    }
                    if (coVar.j6(bvVar, this.FH, ((cf) coVar2).gn())) {
                        return true;
                    }
                    if (coVar.e3() && ((bp) coVar).FH(((cf) coVar2).gn())) {
                        return true;
                    }
                    return tp(bvVar, coVar, coVar2);
                } else if (coVar2.k2()) {
                    return true;
                }
            } else if (coVar.n5()) {
                if (coVar2.cT()) {
                    FH = ((cf) coVar).gn();
                    if (FH == coVar2) {
                        return true;
                    }
                    if (FH.jO().FH((bs) coVar2)) {
                        return true;
                    }
                } else if (coVar2.n5()) {
                    if (coVar.j6(bvVar, this.FH, coVar2)) {
                        return true;
                    }
                    return tp(bvVar, coVar, coVar2);
                } else if (coVar2.k2()) {
                    return true;
                }
            } else if (coVar.q7()) {
                try {
                    r5 = ((cg) coVar).DW();
                    for (r4 = 0; r4 < r5; r4++) {
                        if (((cg) coVar).j6(r4).FH(bvVar, this.FH, coVar2)) {
                            return true;
                        }
                    }
                } catch (ej e3) {
                }
            } else if (coVar.Z1()) {
                try {
                    r5 = ((ca) coVar).Zo();
                    for (r4 = 0; r4 < r5; r4++) {
                        if (((ca) coVar).j6(r4).FH(bvVar, this.FH, coVar2)) {
                            return true;
                        }
                    }
                } catch (ej e4) {
                }
            } else if (coVar.k2()) {
                return DW(coVar2);
            }
            return false;
        }
    }

    private boolean u7(bv bvVar, co coVar, co coVar2) {
        return Native.j6.b(coVar.Gj(), coVar2.Gj());
    }

    private boolean tp(bv bvVar, co coVar, co coVar2) {
        if (!coVar.sE() && !coVar2.sE()) {
            return false;
        }
        dt dtVar = new dt();
        if (coVar.n5() && coVar2.n5() && j6(bvVar, coVar, coVar2, dtVar)) {
            return true;
        }
        ea Zo;
        co coVar3;
        if (coVar.n5()) {
            Zo = ((cf) coVar).Zo();
            Zo.j6.j6();
            while (Zo.j6.DW()) {
                coVar3 = (co) Zo.j6.FH();
                dtVar.DW();
                if (coVar3.n5() && coVar2.n5() && j6(bvVar, coVar3, coVar2, dtVar)) {
                    return true;
                }
            }
        }
        if (coVar.cT()) {
            Zo = ((bp) coVar).FN();
            Zo.j6.j6();
            while (Zo.j6.DW()) {
                coVar3 = (co) Zo.j6.FH();
                dtVar.DW();
                if (coVar3.n5() && coVar2.n5() && j6(bvVar, coVar3, coVar2, dtVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean j6(bv bvVar, co coVar, co coVar2, dt dtVar) {
        if (coVar.k2()) {
            if (coVar == coVar2) {
                return true;
            }
            if (dtVar.FH(coVar.v5()) && dtVar.Hw(coVar.v5()) != coVar2.v5()) {
                return false;
            }
            dtVar.j6(coVar.v5(), coVar2.v5());
            return true;
        } else if (coVar2.k2()) {
            if (coVar == coVar2) {
                return true;
            }
            if (dtVar.FH(coVar2.v5()) && dtVar.Hw(coVar2.v5()) != coVar.v5()) {
                return false;
            }
            dtVar.j6(coVar2.v5(), coVar.v5());
            return true;
        } else if (coVar.AL() && coVar2.AL()) {
            return j6(bvVar, ((bo) coVar).FH(), ((bo) coVar2).FH(), dtVar);
        } else {
            if (!coVar.n5() || !coVar2.n5()) {
                return coVar.FH(bvVar, this.FH, coVar2);
            }
            if (((cf) coVar).gn() != ((cf) coVar2).gn()) {
                return false;
            }
            int[] FH = ((cf) coVar).FH();
            int[] FH2 = ((cf) coVar2).FH();
            co[] DW = ((cf) coVar).DW();
            co[] DW2 = ((cf) coVar2).DW();
            for (int i = 0; i < FH2.length; i++) {
                switch (FH[i]) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        switch (FH2[i]) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                if (j6(bvVar, DW[i], DW2[i], dtVar)) {
                                    break;
                                }
                                return false;
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                if (j6(bvVar, DW[i], DW2[i], dtVar)) {
                                    break;
                                }
                                return false;
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                if (j6(bvVar, DW2[i], DW[i], dtVar)) {
                                    break;
                                }
                                return false;
                            default:
                                break;
                        }
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        switch (FH2[i]) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                return false;
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                if (j6(bvVar, DW[i], DW2[i], dtVar)) {
                                    break;
                                }
                                return false;
                            default:
                                break;
                        }
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        switch (FH2[i]) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                return false;
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                try {
                                    if (DW2[i] == Zo(bvVar)) {
                                        return true;
                                    }
                                    return false;
                                } catch (ej e) {
                                    break;
                                }
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                if (j6(bvVar, DW2[i], DW[i], dtVar)) {
                                    break;
                                }
                                return false;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
            return true;
        }
    }

    public boolean FH(bz bzVar) {
        ea cb = bzVar.cb();
        cb.j6.j6();
        while (cb.j6.DW()) {
            if (!j6(bzVar, (bz) cb.j6.FH())) {
                return false;
            }
        }
        return true;
    }

    public boolean j6(bz bzVar, bz bzVar2) {
        int Ev = bzVar2.Ev();
        int Ev2 = bzVar.Ev();
        if (cd.Zo(Ev) || cd.aM(Ev) != cd.aM(Ev2)) {
            return false;
        }
        if (cd.J0(Ev)) {
            if (cd.J0(Ev2)) {
                return true;
            }
            return false;
        } else if (cd.QX(Ev)) {
            return true;
        } else {
            if (cd.J8(Ev)) {
                if (cd.J0(Ev2)) {
                    return true;
                }
                if (cd.J8(Ev2)) {
                    return true;
                }
                return false;
            } else if (cd.QX(Ev2)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean j6(bv bvVar, bz bzVar) {
        bp Xa = bzVar.Xa();
        ea cb = bzVar.cb();
        cb.j6.j6();
        while (cb.j6.DW()) {
            if (!j6(bvVar, Xa, bzVar, (bz) cb.j6.FH())) {
                return false;
            }
        }
        return true;
    }

    public boolean j6(bv bvVar, bp bpVar, bz bzVar, bz bzVar2) {
        try {
            co j3 = bpVar.j3();
            int rN = bzVar.rN();
            int rN2 = bzVar2.rN();
            for (int i = 0; i < rN; i++) {
                co DW = bzVar.DW(i);
                if (Hw(bvVar, DW)) {
                    int i2;
                    for (i2 = 0; i2 < rN2; i2++) {
                        if (DW == bzVar2.j6(i2, j3)) {
                            break;
                        }
                    }
                    for (i2 = 0; i2 < rN2; i2++) {
                        if (DW.FH(bvVar, this.FH, bzVar2.j6(i2, j3))) {
                            break;
                        }
                    }
                    if (!this.Hw) {
                        return false;
                    }
                    i2 = 0;
                    while (i2 < rN2) {
                        if (!DW.DW(bzVar2.j6(i2, j3), bzVar, bzVar2)) {
                            i2++;
                        }
                    }
                    return false;
                }
            }
        } catch (ej e) {
        }
        return true;
    }

    public boolean DW(bv bvVar, bz bzVar) {
        bp Xa = bzVar.Xa();
        ea cb = bzVar.cb();
        cb.j6.j6();
        while (cb.j6.DW()) {
            if (!DW(bvVar, Xa, bzVar, (bz) cb.j6.FH())) {
                return false;
            }
        }
        return true;
    }

    public boolean DW(bv bvVar, bp bpVar, bz bzVar, bz bzVar2) {
        try {
            co j3 = bpVar.j3();
            if (!this.Hw) {
                return bzVar2.Mz().Hw(bzVar.Mz());
            }
            if (bzVar2.Mz() == bzVar.Mz()) {
                return true;
            }
            co DW = bzVar.DW(j3);
            j3 = bzVar2.DW(j3);
            if (DW.DW(j3, bzVar, bzVar2)) {
                return true;
            }
            if (!DW(DW)) {
                return false;
            }
            if (DW.e3()) {
                return DW.a_().FH(bvVar, this.FH, j3.a_());
            }
            return DW.FH(bvVar, this.FH, j3);
        } catch (ej e) {
            return true;
        }
    }

    private boolean EQ(bv bvVar, co coVar, co coVar2) {
        if (coVar2.n5()) {
            if (coVar.cT()) {
                if (coVar.j6(bvVar, this.FH, coVar2)) {
                    return false;
                }
                return true;
            } else if (coVar.n5()) {
                bp gn = ((cf) coVar).gn();
                bp gn2 = ((cf) coVar2).gn();
                ea FN = gn2.FN();
                FN.j6.j6();
                while (FN.j6.DW()) {
                    co coVar3 = (co) FN.j6.FH();
                    if (coVar3.n5() && ((cf) coVar3).gn() == gn) {
                        int XX = gn2.XX();
                        int i = 0;
                        while (i < XX) {
                            try {
                                if (!coVar3.v5(gn2.j6(i))) {
                                    return true;
                                }
                                i++;
                            } catch (ej e) {
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public long j6(String str) {
        return this.j6.Hw(str.charAt(1));
    }

    public long DW(String str) {
        int i;
        int i2 = 2;
        int i3 = 0;
        if (str.contains("_")) {
            str = str.replace("_", "");
        }
        if (str.startsWith("0x") || str.startsWith("0X")) {
            i = 0;
            while (i2 < str.length()) {
                i3 = i2 + 1;
                i2 = Character.digit(str.charAt(i2), 16);
                if (i2 < 0) {
                    throw new ej();
                }
                i = i2 + (i * 16);
                i2 = i3;
            }
        } else if (str.startsWith("0b") || str.startsWith("0B")) {
            int i4 = 0;
            i3 = 2;
            while (i3 < str.length()) {
                i = i3 + 1;
                i3 = Character.digit(str.charAt(i3), 2);
                if (i3 < 0) {
                    throw new ej();
                }
                i4 = i3 + (i4 * 2);
                i3 = i;
            }
            i = i4;
        } else if (str.startsWith("0") && str.length() > 1) {
            i2 = 1;
            i = 0;
            while (i2 < str.length()) {
                i3 = i2 + 1;
                i2 = Character.digit(str.charAt(i2), 8);
                if (i2 < 0) {
                    throw new ej();
                } else if ((-536870912 & i) != 0) {
                    throw new ej();
                } else {
                    i = i2 + (i * 8);
                    i2 = i3;
                }
            }
        } else if (str.length() > 0) {
            i = 0;
            while (i3 < str.length()) {
                i2 = i3 + 1;
                i3 = Character.digit(str.charAt(i3), 10);
                if (i3 < 0) {
                    throw new ej();
                } else if (i > 214748364) {
                    throw new ej();
                } else if (i == 214748364 && i3 == 9) {
                    throw new ej();
                } else {
                    i = i3 + (i * 10);
                    i3 = i2;
                }
            }
        } else {
            throw new ej();
        }
        return this.j6.Hw(i);
    }

    public long FH(String str) {
        long j;
        int i = 2;
        long j2 = 0;
        if (str.contains("_")) {
            str = str.replace("_", "");
        }
        int i2;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            while (i < str.length() - 1) {
                i2 = i + 1;
                i = Character.digit(str.charAt(i), 16);
                if (i < 0) {
                    throw new ej();
                }
                j2 = (j2 * 16) + ((long) i);
                i = i2;
            }
            j = j2;
        } else if (str.startsWith("0b") || str.startsWith("0B")) {
            i2 = 2;
            j = 0;
            while (i2 < str.length() - 1) {
                int i3 = i2 + 1;
                i2 = Character.digit(str.charAt(i2), 2);
                if (i2 < 0) {
                    throw new ej();
                }
                j = (j * 2) + ((long) i2);
                i2 = i3;
            }
        } else if (str.startsWith("0") && str.length() > 1) {
            i = 1;
            j = 0;
            while (i < str.length() - 1) {
                i2 = i + 1;
                i = Character.digit(str.charAt(i), 8);
                if (i < 0) {
                    throw new ej();
                } else if ((-2305843009213693952L & j) != 0) {
                    throw new ej();
                } else {
                    j = (j * 8) + ((long) i);
                    i = i2;
                }
            }
        } else if (str.length() > 0) {
            i = 0;
            while (i < str.length() - 1) {
                i2 = i + 1;
                i = Character.digit(str.charAt(i), 10);
                if (i < 0) {
                    throw new ej();
                } else if (j2 > 922337203685477580L) {
                    throw new ej();
                } else if (j2 == 922337203685477580L && i == 9) {
                    throw new ej();
                } else {
                    j2 = (j2 * 10) + ((long) i);
                    i = i2;
                }
            }
            j = j2;
        } else {
            throw new ej();
        }
        return this.j6.Zo(j);
    }

    public long Hw(String str) {
        try {
            float j6;
            if (str.contains("_")) {
                str = str.replace("_", "");
            }
            if (em.j6() != null) {
                j6 = em.j6().j6(str);
            } else {
                j6 = (float) Double.parseDouble(str);
            }
            return this.j6.j6(j6);
        } catch (NumberFormatException e) {
            throw new ej();
        }
    }

    public long v5(String str) {
        try {
            if (str.contains("_")) {
                str = str.replace("_", "");
            }
            return this.j6.j6(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            throw new ej();
        }
    }

    public co j6(bv bvVar, co coVar, co coVar2, long j) {
        if (coVar2.Gj() == 7) {
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    if (this.j6.v5(j) >= -128 && this.j6.v5(j) <= 127) {
                        return EQ();
                    }
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    if (this.j6.v5(j) >= 0 && this.j6.v5(j) <= 255) {
                        return EQ();
                    }
                case 5:
                    if (this.j6.v5(j) >= -32768 && this.j6.v5(j) <= 32767) {
                        return Ws();
                    }
                case 12:
                    if (this.j6.v5(j) >= 0 && this.j6.v5(j) <= 65535) {
                        return QX();
                    }
            }
        }
        return j6(bvVar, coVar, coVar2);
    }

    public co j6(bv bvVar, int i, co coVar, co coVar2, long j) {
        if (i != 22) {
            return DW(bvVar, i, coVar, coVar2);
        }
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        if (this.j6.v5(j) <= 127 && this.j6.v5(j) >= -128) {
                            return coVar;
                        }
                        throw new ej();
                    default:
                        break;
                }
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        if (this.j6.v5(j) <= 255 && this.j6.v5(j) >= 0) {
                            return coVar;
                        }
                        throw new ej();
                    default:
                        break;
                }
            case 5:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        if (this.j6.v5(j) <= 32767 && this.j6.v5(j) >= -32768) {
                            return coVar;
                        }
                        throw new ej();
                    default:
                        break;
                }
            case 12:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        if (this.j6.v5(j) <= 65535 && this.j6.v5(j) >= 0) {
                            return coVar;
                        }
                        throw new ej();
                    default:
                        break;
                }
        }
        if (coVar2.FH(bvVar, this.FH, coVar)) {
            return coVar;
        }
        if (this.Hw) {
            if (v5(bvVar, coVar2, coVar)) {
                return coVar;
            }
            try {
                if (coVar != Ws(bvVar)) {
                    if (coVar != Ws(bvVar)) {
                        if (coVar != J8(bvVar)) {
                            if (coVar == XL(bvVar)) {
                                switch (coVar2.Gj()) {
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                    case 5:
                                    case 7:
                                    case 12:
                                        if (this.j6.v5(j) <= 32767 && this.j6.v5(j) >= -32768) {
                                            return coVar;
                                        }
                                        throw new ej();
                                    default:
                                        break;
                                }
                            }
                        }
                        switch (coVar2.Gj()) {
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 7:
                            case 12:
                                if (this.j6.v5(j) <= 127 && this.j6.v5(j) >= -128) {
                                    return coVar;
                                }
                                throw new ej();
                            default:
                                break;
                        }
                    }
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 7:
                        case 12:
                            if (this.j6.v5(j) <= 32767 && this.j6.v5(j) >= -32768) {
                                return coVar;
                            }
                            throw new ej();
                        default:
                            break;
                    }
                }
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        if (this.j6.v5(j) <= 65535 && this.j6.v5(j) >= 0) {
                            return coVar;
                        }
                        throw new ej();
                }
            } catch (ej e) {
            }
        }
        throw new ej();
    }

    public boolean j6(bv bvVar, bz bzVar, bz bzVar2, co coVar, int i) {
        if (this.Hw) {
            return DW(bvVar, bzVar, bzVar2, coVar, i) && !DW(bvVar, bzVar2, bzVar, coVar, i);
        } else {
            return DW(bvVar, bzVar, bzVar2, coVar, i);
        }
    }

    public boolean DW(bv bvVar, bz bzVar, bz bzVar2, co coVar, int i) {
        try {
            int lp = bzVar.lp();
            int lp2 = bzVar2.lp();
            int i2 = 0;
            while (i2 < i) {
                co FH = i2 >= lp ? bzVar.FH(coVar, lp - 1) : bzVar.FH(coVar, i2);
                co FH2 = i2 >= lp2 ? bzVar2.FH(coVar, lp2 - 1) : bzVar2.FH(coVar, i2);
                if ((FH.Z1() || !FH2.Z1()) && !FH.j6(FH2, bzVar, bzVar2)) {
                    co FH3;
                    if (i2 >= lp - 1 && bzVar.sh() && FH.AL()) {
                        FH3 = ((bo) FH).FH();
                    } else {
                        FH3 = FH;
                    }
                    if (i2 >= lp2 - 1 && bzVar2.sh() && FH2.AL()) {
                        FH2 = ((bo) FH2).FH();
                    }
                    if (!j6(bvVar, FH3, FH2, false)) {
                        return false;
                    }
                }
                i2++;
            }
            if (this.Hw || bzVar.Xa().FH(bvVar, this.FH, bzVar2.Xa())) {
                return true;
            }
            return false;
        } catch (ej e) {
            return false;
        }
    }

    public boolean j6() {
        return false;
    }

    public boolean DW() {
        return false;
    }

    public boolean Hw() {
        return true;
    }

    public void j6(bv bvVar, ea<bz> eaVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4, boolean z, ea<bz> eaVar2) {
        j6(bvVar, eaVar, coVar, coVarArr, i, i2, coVarArr2, i3, i4, true, true, eaVar2);
        if (eaVar2.Hw() == 0) {
            j6(bvVar, eaVar, coVar, coVarArr, i, i2, coVarArr2, i3, i4, false, true, eaVar2);
        }
        if (!z) {
            if (eaVar2.Hw() == 0) {
                j6(bvVar, eaVar, coVar, coVarArr, i, i2, coVarArr2, i3, i4, true, false, eaVar2);
            }
            if (eaVar2.Hw() == 0) {
                j6(bvVar, eaVar, coVar, coVarArr, i, i2, coVarArr2, i3, i4, false, false, eaVar2);
            }
        }
    }

    private void j6(bv bvVar, ea<bz> eaVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4, boolean z, boolean z2, ea<bz> eaVar2) {
        eaVar2.j6();
        eaVar.j6.j6();
        while (eaVar.j6.DW()) {
            bs bsVar = (bz) eaVar.j6.FH();
            if (j6(bvVar, (bz) bsVar, coVar, coVarArr, i, i2, coVarArr2, i3, i4, z, z2)) {
                eaVar2.j6(bsVar);
            }
        }
    }

    public boolean j6(bv bvVar, bz bzVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4, boolean z, boolean z2) {
        try {
            co sg = coVar.sg();
            if (i4 > 0 && bzVar.FH(sg) != i4) {
                return false;
            }
            int lp = bzVar.lp();
            if (i2 < lp - 1) {
                return false;
            }
            if (i2 != lp && (z || !bzVar.sh())) {
                return false;
            }
            if (j6(bzVar, sg, coVarArr, i, i2)) {
                return false;
            }
            int i5;
            co FH;
            if (!z && bzVar.sh()) {
                for (i5 = 0; i5 < lp - 1; i5++) {
                    FH = bzVar.FH(sg, i5);
                    if (bzVar.FH(sg) > 0) {
                        if (!j6(bvVar, coVarArr[i5 + i].sg().a_(), FH.a_(), z2)) {
                            return false;
                        }
                    } else {
                        if (!j6(bvVar, coVarArr[i5 + i].sg(), FH, z2)) {
                            return false;
                        }
                    }
                }
                co FH2 = bzVar.FH(sg, lp - 1);
                if (!FH2.AL()) {
                    return false;
                }
                if (lp == i2) {
                    if (j6(bvVar, coVarArr[(lp - 1) + i].sg(), FH2, z2)) {
                        return true;
                    }
                }
                FH = ((bo) FH2).FH();
                if (FH.Z1()) {
                    return true;
                }
                for (i5 = lp - 1; i5 < i2; i5++) {
                    if (!j6(bvVar, coVarArr[i5 + i].sg(), FH, z2)) {
                        return false;
                    }
                }
                return true;
            } else if (bzVar.FH(sg) > 0) {
                return bzVar.DW(bvVar, this.FH, sg, coVarArr, i, i2, coVarArr2, i3, i4);
            } else {
                i5 = 0;
                while (i5 < lp) {
                    if (j6(bvVar, coVarArr[i5 + i].sg(), bzVar.FH(sg, i5), z2)) {
                        i5++;
                    } else {
                        if (this.Hw) {
                            boolean e3 = sg.e3();
                            for (int i6 = 0; i6 < lp; i6++) {
                                if (bzVar.FH(sg, i6).e3()) {
                                    e3 = true;
                                }
                            }
                            if (e3) {
                                for (i5 = 0; i5 < lp; i5++) {
                                    FH = bzVar.FH(sg, i5);
                                    co a_ = FH.a_();
                                    co sg2 = coVarArr[i5 + i].sg();
                                    co a_2 = sg2.a_();
                                    if (FH.n5() && sg2.n5()) {
                                        return false;
                                    }
                                    if (!j6(bvVar, a_2, a_, z2)) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return true;
            }
        } catch (ej e) {
            return false;
        }
    }
}
