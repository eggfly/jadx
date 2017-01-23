import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public class bb {
    private final by DW;
    private final bw FH;
    private final bt Hw;
    private final ap Zo;
    private final ba j6;
    private final cl v5;

    public bb(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cn;
        this.Hw = baVar.cb;
        this.v5 = baVar.sh;
        this.Zo = baVar.j6;
    }

    public void j6(String str) {
        String toLowerCase = str.toLowerCase();
        this.j6.er.j6();
        eb Hw = this.j6.cn.Hw();
        Hw.j6.j6();
        while (Hw.j6.DW()) {
            bv FH = Hw.j6.FH();
            List lg = FH.lg();
            for (int i = 1; i < lg.size(); i++) {
                int indexOf = ((String) lg.get(i)).toLowerCase().indexOf(toLowerCase);
                if (indexOf >= 0) {
                    this.j6.er.j6(FH, i, indexOf + 1, i, (indexOf + toLowerCase.length()) + 1);
                }
            }
        }
        this.j6.er.DW();
    }

    public void j6(bv bvVar, boolean z) {
        this.j6.er.j6();
        dq FH = this.Hw.FH(bvVar);
        if (FH.DW() != null) {
            bp bpVar = (bp) FH.DW();
            j6(this.v5.DW(bpVar.tp(), bpVar.Hw()), bvVar.Zo(), 7, FH.DW(), z);
        }
        this.j6.er.DW();
    }

    public void j6(bv bvVar, int i, int i2, boolean z) {
        this.j6.er.j6();
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            int gW = DW.gW(gn);
            DW.tp().u7().DW(DW, gn);
            int J8 = DW.J8(gn);
            switch (J8) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    break;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case 32:
                    J8 = DW.Ws(gn);
                    this.j6.er.j6("variable " + this.DW.j6(gW));
                    DW.tp().u7().j6(DW, gW);
                    j6(DW, DW.Ws(), bvVar, gW, J8);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                    J8 = DW.Ws(gn);
                    this.j6.er.j6("label " + this.DW.j6(gW));
                    DW.tp().u7().j6(DW, gW);
                    j6(DW, DW.Ws(), bvVar, gW, J8);
                    break;
                default:
                    j6(DW, gW, J8, DW.QX(gn), z);
                    break;
            }
            this.j6.er.DW();
            return;
        }
        this.v5.j6(DW);
        this.j6.er.DW();
    }

    private void j6(cj cjVar, int i, int i2, bs bsVar, boolean z) {
        bv we = cjVar.we();
        bv FH;
        switch (i2) {
            case 6:
                this.j6.er.j6("package " + bsVar.iW());
                for (cj cjVar2 : this.v5.j6(cjVar.we())) {
                    cjVar2.tp().u7().j6(cjVar2, i);
                    j6(cjVar2, cjVar2.Ws(), we, i, (ce) bsVar);
                }
                if (!bsVar.Q6()) {
                    this.Zo.DW(i);
                    while (true) {
                        FH = this.Zo.FH();
                        if (FH == null) {
                            return;
                        }
                        if (FH != we) {
                            if (!this.j6.P8.v5()) {
                                for (cj cjVar3 : this.v5.j6(FH)) {
                                    cjVar3.tp().u7().j6(cjVar3, i);
                                    j6(cjVar3, cjVar3.Ws(), FH, i, (ce) bsVar);
                                    this.v5.j6(cjVar3);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            case 7:
            case 8:
            case 9:
            case 10:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                this.j6.er.j6("class " + bsVar.iW());
                ec ecVar = new ec();
                ea eaVar = new ea(this.Hw);
                ea eaVar2 = new ea(this.Hw);
                ea eaVar3 = new ea(this.Hw);
                bs bsVar2 = (bp) bsVar;
                eaVar3.j6(bsVar2);
                if (bsVar2.ef()) {
                    eaVar3.j6(bsVar2.aM());
                }
                ecVar.j6(i);
                if (z) {
                    eaVar3.j6.j6();
                    while (eaVar3.j6.DW()) {
                        bp bpVar = (bp) eaVar3.j6.FH();
                        dr sh = bpVar.sh();
                        sh.j6.j6();
                        while (sh.j6.DW()) {
                            if (!((bz) sh.j6.Hw()).Q6()) {
                                ecVar.j6(sh.j6.FH());
                                eaVar.j6(sh.j6.Hw());
                            }
                        }
                        dr cb = bpVar.cb();
                        cb.j6.j6();
                        while (cb.j6.DW()) {
                            if (!((bz) cb.j6.Hw()).Q6()) {
                                ecVar.j6(cb.j6.FH());
                                eaVar2.j6(cb.j6.Hw());
                            }
                        }
                    }
                }
                for (cj cjVar22 : this.v5.j6(cjVar.we())) {
                    cjVar22.tp().u7().j6(cjVar22, ecVar);
                    j6(cjVar22, cjVar22.Ws(), we, ecVar, eaVar, eaVar2, eaVar3, z);
                }
                if (!bsVar.Q6()) {
                    this.Zo.FH(ecVar);
                    while (true) {
                        bv FH2 = this.Zo.FH();
                        if (FH2 == null) {
                            return;
                        }
                        if (FH2 != we) {
                            if (!this.j6.P8.v5()) {
                                for (cj cjVar4 : this.v5.j6(FH2)) {
                                    cjVar4.tp().u7().j6(cjVar4, ecVar);
                                    j6(cjVar4, cjVar4.Ws(), FH2, ecVar, eaVar, eaVar2, eaVar3, z);
                                    this.v5.j6(cjVar4);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            case 11:
            case 12:
            case 13:
            case 14:
                this.j6.er.j6("parametertype " + bsVar.iW());
                cjVar.tp().u7().j6(cjVar, i);
                j6(cjVar, cjVar.Ws(), we, i, bsVar);
            case 15:
            case 16:
                this.j6.er.j6("field " + bsVar.iW());
                for (cj cjVar222 : this.v5.j6(cjVar.we())) {
                    cjVar222.tp().u7().j6(cjVar222, i);
                    DW(cjVar222, cjVar222.Ws(), we, i, (bz) bsVar, z);
                }
                if (!bsVar.kf()) {
                    this.Zo.DW(i);
                    while (true) {
                        FH = this.Zo.FH();
                        if (FH != null) {
                            if (FH != we) {
                                if (!this.j6.P8.v5()) {
                                    for (cj cjVar32 : this.v5.j6(FH)) {
                                        cjVar32.tp().u7().j6(cjVar32, i);
                                        DW(cjVar32, cjVar32.Ws(), FH, i, (bz) bsVar, z);
                                        this.v5.j6(cjVar32);
                                    }
                                }
                            }
                        }
                        if (this.FH.v5(bsVar.tp())) {
                            j6((bz) bsVar);
                            return;
                        }
                        return;
                    }
                }
            case 19:
            case ProxyTextView.INPUTTYPE_date /*20*/:
                this.j6.er.j6("method " + bsVar.iW());
                for (cj cjVar2222 : this.v5.j6(cjVar.we())) {
                    cjVar2222.tp().u7().j6(cjVar2222, i);
                    j6(cjVar2222, cjVar2222.Ws(), we, i, (bz) bsVar, z);
                }
                if (!bsVar.kf()) {
                    this.Zo.DW(i);
                    while (true) {
                        FH = this.Zo.FH();
                        if (FH == null) {
                            return;
                        }
                        if (FH != we) {
                            if (!this.j6.P8.v5()) {
                                for (cj cjVar322 : this.v5.j6(FH)) {
                                    cjVar322.tp().u7().j6(cjVar322, i);
                                    j6(cjVar322, cjVar322.Ws(), FH, i, (bz) bsVar, z);
                                    this.v5.j6(cjVar322);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                this.j6.er.j6("constructor " + bsVar.iW());
                ec ecVar2 = new ec();
                ecVar2.j6(i);
                ecVar2.j6(this.DW.j6(""));
                for (cj cjVar22222 : this.v5.j6(cjVar.we())) {
                    cjVar22222.tp().u7().j6(cjVar22222, ecVar2);
                    DW(cjVar22222, cjVar22222.Ws(), we, i, bsVar);
                }
                if (!bsVar.Q6()) {
                    this.Zo.DW(i);
                    while (true) {
                        FH = this.Zo.FH();
                        if (FH == null) {
                            return;
                        }
                        if (FH != we) {
                            if (!this.j6.P8.v5()) {
                                for (cj cjVar3222 : this.v5.j6(FH)) {
                                    cjVar3222.tp().u7().j6(cjVar3222, ecVar2);
                                    DW(cjVar3222, cjVar3222.Ws(), FH, i, bsVar);
                                    this.v5.j6(cjVar3222);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            default:
        }
    }

    private void j6(bz bzVar) {
        String str = "@+id/" + bzVar.eU();
        eb Hw = this.j6.cn.Hw();
        Hw.j6.j6();
        while (Hw.j6.DW()) {
            bv FH = Hw.j6.FH();
            if (FH.Hw().toLowerCase().equals(".xml")) {
                List lg = FH.lg();
                for (int i = 1; i < lg.size(); i++) {
                    int indexOf = ((String) lg.get(i)).indexOf(str);
                    if (indexOf >= 0) {
                        this.j6.er.j6(FH, i, indexOf + 1, i, (indexOf + str.length()) + 1);
                    }
                }
            }
        }
    }

    private void j6(cj cjVar, int i, bv bvVar, ec ecVar, ea<bz> eaVar, ea<bz> eaVar2, ea<bp> eaVar3, boolean z) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), bvVar, ecVar, eaVar, eaVar2, eaVar3, z);
        }
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    if (cjVar.KD(i) != cjVar.ro(i)) {
                        if (eaVar3.FH(cjVar.QX(i))) {
                            this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        }
                    }
                case 16:
                    if (z && cjVar.KD(i) != cjVar.ro(i) && !cjVar.QX(i).Q6()) {
                        if (eaVar2.FH(cjVar.QX(i))) {
                            this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        }
                    }
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    if (z && cjVar.KD(i) != cjVar.ro(i) && !cjVar.QX(i).Q6()) {
                        if (eaVar.FH(cjVar.QX(i))) {
                            this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        }
                    }
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    if (z && cjVar.KD(i) != cjVar.ro(i)) {
                        if (eaVar3.FH(((bz) cjVar.QX(i)).Xa())) {
                            this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        }
                    }
                default:
            }
        }
    }

    private void j6(cj cjVar, int i, bv bvVar, int i2, bs bsVar) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            j6(cjVar, cjVar.Hw(i, i3), bvVar, i2, bsVar);
        }
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 19:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                case 32:
                default:
                    if (cjVar.KD(i) != cjVar.ro(i) && cjVar.QX(i) == bsVar) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
            }
        }
    }

    private void DW(cj cjVar, int i, bv bvVar, int i2, bs bsVar) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            DW(cjVar, cjVar.Hw(i, i3), bvVar, i2, bsVar);
        }
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    if (cjVar.QX(i) == bsVar) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
                default:
            }
        }
    }

    private void j6(cj cjVar, int i, bv bvVar, int i2, bz bzVar, boolean z) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            j6(cjVar, cjVar.Hw(i, i3), bvVar, i2, bzVar, z);
        }
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 19:
                    if (cjVar.KD(i) != cjVar.ro(i) && bzVar == cjVar.QX(i)) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    } else if (z && cjVar.KD(i) != cjVar.ro(i) && ((bz) cjVar.QX(i)).ef().FH((bs) bzVar)) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    if (cjVar.KD(i) != cjVar.ro(i) && bzVar == cjVar.QX(i)) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    } else if (z && cjVar.KD(i) != cjVar.ro(i) && bzVar.ef().FH(cjVar.QX(i))) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
                default:
            }
        }
    }

    private void DW(cj cjVar, int i, bv bvVar, int i2, bz bzVar, boolean z) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            DW(cjVar, cjVar.Hw(i, i3), bvVar, i2, bzVar, z);
        }
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 15:
                    if (cjVar.KD(i) != cjVar.ro(i) && bzVar == cjVar.QX(i)) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    } else if (cjVar.KD(i) != cjVar.ro(i) && z && ((bz) cjVar.QX(i)).ef().FH((bs) bzVar)) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
                case 16:
                    if (cjVar.KD(i) != cjVar.ro(i) && bzVar == cjVar.QX(i)) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    } else if (z && cjVar.KD(i) != cjVar.ro(i) && bzVar.ef().FH(cjVar.QX(i))) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
                default:
            }
        }
    }

    private void j6(cj cjVar, int i, bv bvVar, int i2, int i3) {
        int lg = cjVar.lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            j6(cjVar, cjVar.Hw(i, i4), bvVar, i2, i3);
        }
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 32:
                    if (cjVar.Ws(i) == i3) {
                        this.j6.er.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    }
                default:
            }
        }
    }
}
