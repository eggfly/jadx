import com.aide.uidesigner.ProxyTextView;

public class co extends bs {
    private int DW;
    private final bt j6;

    protected co(bw bwVar, bt btVar, int i) {
        super(bwVar, btVar);
        this.j6 = btVar;
        this.DW = i;
    }

    protected co(bw bwVar, bt btVar) {
        super(bwVar, btVar);
        this.j6 = btVar;
    }

    public boolean j6(bv bvVar, bj bjVar) {
        if (tp() != null) {
            return tp().j6(bvVar);
        }
        return true;
    }

    public co FH(bv bvVar, bj bjVar, int i, boolean z, bp bpVar, ea<bz> eaVar) {
        try {
            co sG = sG();
            sG.j6(bvVar, bjVar, i, z, (bp) sG.a_(), (ea) eaVar);
        } catch (ej e) {
        }
        return this;
    }

    public co Hw(bv bvVar, bj bjVar, int i, boolean z, bp bpVar, ea<bz> eaVar) {
        try {
            co sG = sG();
            sG.DW(bvVar, bjVar, i, z, (bp) sG.a_(), eaVar);
        } catch (ej e) {
        }
        return this;
    }

    public co j6(bp bpVar, ea<bz> eaVar) {
        if (!n5()) {
            return null;
        }
        if (((cf) this).gn().j6(bpVar, (ea) eaVar) == null) {
            return null;
        }
        return this;
    }

    public co DW(bv bvVar, bj bjVar, int i, boolean z, bp bpVar, ea<bz> eaVar) {
        eaVar.j6();
        if (n5()) {
            return ((cf) this).gn().DW(bvVar, bjVar, i, z, bpVar, (ea) eaVar) == null ? null : this;
        } else {
            if (AL()) {
                try {
                    bp Hw = this.j6.Hw(bvVar, bjVar);
                    return Hw.DW(bvVar, bjVar, i, z, Hw, (ea) eaVar);
                } catch (ej e) {
                }
            } else {
                int i2;
                co DW;
                if (q7()) {
                    if (((cg) this).DW() == 1) {
                        try {
                            return a_().DW(bvVar, bjVar, i, z, bpVar, eaVar);
                        } catch (ej e2) {
                        }
                    } else {
                        i2 = 0;
                        while (i2 < ((cg) this).DW()) {
                            try {
                                DW = ((cg) this).j6(i2).DW(bvVar, bjVar, i, z, bpVar, eaVar);
                                if (DW != null) {
                                    return DW;
                                }
                                i2++;
                            } catch (ej e3) {
                            }
                        }
                    }
                } else if (Z1()) {
                    if (((ca) this).Zo() == 1) {
                        try {
                            return a_().DW(bvVar, bjVar, i, z, bpVar, eaVar);
                        } catch (ej e4) {
                        }
                    } else {
                        i2 = 0;
                        while (i2 < ((ca) this).Zo()) {
                            try {
                                DW = ((ca) this).j6(i2).DW(bvVar, bjVar, i, z, bpVar, eaVar);
                                if (DW != null) {
                                    return DW;
                                }
                                i2++;
                            } catch (ej e5) {
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public co j6(bv bvVar, bj bjVar, int i, boolean z, bp bpVar, ea<bz> eaVar) {
        eaVar.j6();
        if (n5()) {
            return ((cf) this).gn().j6(bvVar, bjVar, i, z, bpVar, (ea) eaVar) == null ? null : this;
        } else {
            if (AL()) {
                try {
                    bp Hw = this.j6.Hw(bvVar, bjVar);
                    return Hw.j6(bvVar, bjVar, i, z, Hw, (ea) eaVar);
                } catch (ej e) {
                }
            } else {
                int i2;
                co j6;
                if (q7()) {
                    if (((cg) this).DW() == 1) {
                        try {
                            return a_().j6(bvVar, bjVar, i, z, bpVar, (ea) eaVar);
                        } catch (ej e2) {
                        }
                    } else {
                        i2 = 0;
                        while (i2 < ((cg) this).DW()) {
                            try {
                                j6 = ((cg) this).j6(i2).j6(bvVar, bjVar, i, z, bpVar, (ea) eaVar);
                                if (j6 != null) {
                                    return j6;
                                }
                                i2++;
                            } catch (ej e3) {
                            }
                        }
                    }
                } else if (Z1()) {
                    if (((ca) this).Zo() == 1) {
                        try {
                            return a_().j6(bvVar, bjVar, i, z, bpVar, (ea) eaVar);
                        } catch (ej e4) {
                        }
                    } else {
                        i2 = 0;
                        while (i2 < ((ca) this).Zo()) {
                            try {
                                j6 = ((ca) this).j6(i2).j6(bvVar, bjVar, i, z, bpVar, (ea) eaVar);
                                if (j6 != null) {
                                    return j6;
                                }
                                i2++;
                            } catch (ej e5) {
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public co j6(int i, boolean z, int i2, bs bsVar, bv bvVar, bj bjVar) {
        if (cT()) {
            return ((bp) this).DW(i, z, i2, bsVar, bvVar, bjVar);
        }
        if (n5()) {
            return ((cf) this).j6(i, z, i2, bsVar, bvVar, bjVar);
        }
        if (q7()) {
            if (((cg) this).DW() == 1) {
                return a_().j6(i, z, i2, bsVar, bvVar, bjVar);
            }
            return this.j6.v5(bvVar, bjVar).j6(i, z, i2, bsVar, bvVar, bjVar);
        } else if (!Z1()) {
            throw new ej();
        } else if (((ca) this).Zo() == 1) {
            return a_().j6(i, z, i2, bsVar, bvVar, bjVar);
        } else {
            return this.j6.v5(bvVar, bjVar).j6(i, z, i2, bsVar, bvVar, bjVar);
        }
    }

    public co sG() {
        if (n5()) {
            return ((cf) this).j6(((cf) this).gn().sG());
        }
        throw new ej();
    }

    public dr<bz> cn() {
        if (n5()) {
            return ((cf) this).gn().cn();
        }
        return null;
    }

    public boolean Hw(co coVar) {
        if (this == coVar) {
            return true;
        }
        if (Gj() != 16 && Gj() == coVar.Gj()) {
            return true;
        }
        if (AL() && coVar.AL()) {
            bo boVar = (bo) this;
            bo boVar2 = (bo) coVar;
            if (boVar.DW() == boVar2.DW() && boVar.FH().Hw(boVar2.FH())) {
                return true;
            }
        }
        return false;
    }

    public boolean e3() {
        return cT() && ((bp) this).XX() > 0;
    }

    public boolean j6(co coVar, bz bzVar, bz bzVar2) {
        if (this == coVar) {
            return true;
        }
        if (Z1() && coVar.Z1()) {
            if (((ca) this).DW() == bzVar && ((ca) coVar).DW() == bzVar2 && ((ca) this).FH() == ((ca) coVar).FH()) {
                return true;
            }
            return false;
        } else if (AL() && coVar.AL()) {
            if (((bo) this).DW() == ((bo) coVar).DW()) {
                return ((bo) this).FH().j6(((bo) coVar).FH(), bzVar, bzVar2);
            }
            return false;
        } else if (!n5() || !coVar.n5() || !((cf) this).gn().FH(((cf) coVar).gn())) {
            return false;
        } else {
            co[] DW = ((cf) this).DW();
            co[] DW2 = ((cf) coVar).DW();
            for (int i = 0; i < DW.length; i++) {
                if (!DW[i].DW(DW2[i], bzVar, bzVar2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean DW(co coVar, bz bzVar, bz bzVar2) {
        if (Hw(coVar)) {
            return true;
        }
        if (Z1() && coVar.Z1()) {
            if (((ca) this).DW() == bzVar && ((ca) coVar).DW() == bzVar2 && ((ca) this).FH() == ((ca) coVar).FH()) {
                return true;
            }
            return false;
        } else if (AL() && coVar.AL()) {
            return ((bo) this).FH().DW(((bo) coVar).FH(), bzVar, bzVar2);
        } else {
            if (!n5() || !coVar.n5() || ((cf) this).gn() != ((cf) coVar).gn()) {
                return false;
            }
            co[] DW = ((cf) this).DW();
            co[] DW2 = ((cf) coVar).DW();
            for (int i = 0; i < DW.length; i++) {
                if (!DW[i].DW(DW2[i], bzVar, bzVar2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean j6(bv bvVar, bj bjVar, co coVar) {
        ea FN;
        if (cT()) {
            FN = ((bp) this).FN();
        } else {
            FN = ((cf) this).Zo();
        }
        if (FN.FH((bs) coVar)) {
            return true;
        }
        FN.j6.j6();
        while (FN.j6.DW()) {
            try {
                co coVar2 = (co) FN.j6.FH();
                if (coVar2.n5() && coVar.n5()) {
                    if (((cf) coVar2).gn() == ((cf) coVar).gn()) {
                        int[] FH = ((cf) coVar2).FH();
                        int[] FH2 = ((cf) coVar).FH();
                        co[] DW = ((cf) coVar2).DW();
                        co[] DW2 = ((cf) coVar).DW();
                        for (int i = 0; i < FH2.length; i++) {
                            switch (FH[i]) {
                                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                    switch (FH2[i]) {
                                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                            if (DW[i].Hw(DW2[i])) {
                                                break;
                                            }
                                            return false;
                                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                            if (DW[i].FH(bvVar, bjVar, DW2[i])) {
                                                break;
                                            }
                                            return false;
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            if (DW2[i].FH(bvVar, bjVar, DW[i])) {
                                                break;
                                            }
                                            return false;
                                        default:
                                            break;
                                    }
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    switch (FH2[i]) {
                                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                            return false;
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                            if (DW[i].FH(bvVar, bjVar, DW2[i])) {
                                                break;
                                            }
                                            return false;
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            return false;
                                        default:
                                            break;
                                    }
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                    switch (FH2[i]) {
                                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                            return false;
                                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                            if (DW[i].FH(bvVar, bjVar, DW2[i])) {
                                                break;
                                            }
                                            return false;
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
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
                                            if (DW2[i] == this.j6.v5(bvVar, bjVar)) {
                                                break;
                                            }
                                            return false;
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            if (DW2[i].FH(bvVar, bjVar, DW[i])) {
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
            } catch (ej e) {
            }
        }
        return false;
    }

    public boolean DW(bv bvVar, bj bjVar, co coVar) {
        return this.j6.j6(bvVar, bjVar, this, coVar);
    }

    public boolean FH(bv bvVar, bj bjVar, co coVar) {
        return this.j6.DW(bvVar, bjVar, this, coVar);
    }

    public co Hw(bv bvVar, bj bjVar, co coVar) {
        if ((!cT() && !n5()) || (!coVar.cT() && !coVar.n5())) {
            return this.j6.v5(bvVar, bjVar);
        }
        ea Zo;
        bs v5 = this.j6.v5(bvVar, bjVar);
        ea jO = ((bp) a_()).jO();
        ea jO2 = ((bp) coVar.a_()).jO();
        jO.j6.j6();
        bs bsVar = v5;
        while (jO.j6.DW()) {
            bs bsVar2 = (bp) jO.j6.FH();
            if (!jO2.FH(bsVar2) || (!bsVar2.jO().FH(bsVar) && (!bsVar.g3() || bsVar2.g3() || bsVar2 == v5))) {
                bsVar2 = bsVar;
            }
            bsVar = bsVar2;
        }
        if (n5()) {
            Zo = ((cf) this).Zo();
        } else {
            Zo = ((bp) this).FN();
        }
        if (n5()) {
            jO = ((cf) this).Zo();
        } else {
            jO = ((bp) this).FN();
        }
        Zo.j6.j6();
        while (Zo.j6.DW()) {
            co coVar2 = (co) Zo.j6.FH();
            if (coVar2.a_() != r1 || !coVar.FH(bvVar, bjVar, coVar2)) {
                coVar2 = r1;
            }
            co coVar3 = coVar2;
        }
        jO.j6.j6();
        while (jO.j6.DW()) {
            coVar2 = (co) jO.j6.FH();
            if (coVar2.a_() == coVar3 && FH(bvVar, bjVar, coVar2)) {
                coVar3 = coVar2;
            }
        }
        if (n5() && coVar.n5() && coVar3.cT() && ((bp) coVar3).XX() > 0) {
            return this.j6.v5(bvVar, bjVar);
        }
        return coVar3;
    }

    public boolean v5(co coVar) {
        if (this == coVar) {
            return true;
        }
        if (AL()) {
            return ((bo) this).FH().v5(coVar);
        }
        if (!n5()) {
            return false;
        }
        co[] DW = ((cf) this).DW();
        for (co v5 : DW) {
            if (v5.v5(coVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean sE() {
        if (k2()) {
            return true;
        }
        if (AL()) {
            return ((bo) this).FH().sE();
        }
        if (!n5()) {
            return false;
        }
        co[] DW = ((cf) this).DW();
        for (co sE : DW) {
            if (sE.sE()) {
                return true;
            }
        }
        return false;
    }

    public co j6(bz bzVar, bz bzVar2) {
        if (Z1()) {
            ca caVar = (ca) this;
            if (caVar.DW() == bzVar2) {
                return caVar.DW(bzVar);
            }
            return this;
        } else if (AL()) {
            return this.j6.j6(((bo) this).FH().j6(bzVar, bzVar2), ((bo) this).DW());
        } else {
            if (!n5()) {
                return this;
            }
            co[] DW = ((cf) this).DW();
            int[] FH = ((cf) this).FH();
            co[] coVarArr = new co[DW.length];
            for (int i = 0; i < DW.length; i++) {
                coVarArr[i] = DW[i].j6(bzVar, bzVar2);
            }
            return this.j6.j6(((cf) this).gn(), coVarArr, FH);
        }
    }

    public co sg() {
        if (!sE()) {
            return this;
        }
        if (k2()) {
            return ((cb) this).j6().a_();
        }
        if (AL()) {
            return this.j6.j6(((bo) this).FH().sg(), ((bo) this).DW());
        }
        if (!n5()) {
            return this;
        }
        co[] DW = ((cf) this).DW();
        int[] FH = ((cf) this).FH();
        co[] coVarArr = new co[DW.length];
        for (int i = 0; i < DW.length; i++) {
            coVarArr[i] = DW[i].sg();
        }
        return this.j6.j6(((cf) this).gn(), coVarArr, FH);
    }

    public boolean pO() {
        if (!n5()) {
            return false;
        }
        int[] FH = ((cf) this).FH();
        for (int i : FH) {
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean fN() {
        if (!n5()) {
            return false;
        }
        int[] FH = ((cf) this).FH();
        for (int i : FH) {
            if (i != 1) {
                return false;
            }
        }
        return true;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.DW = eeVar.readInt();
    }

    protected void j6(ef efVar) {
        super.j6(efVar);
        efVar.writeInt(this.DW);
    }

    public int Gj() {
        return this.DW;
    }

    public boolean vJ() {
        return false;
    }

    public boolean g3() {
        return false;
    }

    public boolean I() {
        return false;
    }

    public boolean ca() {
        return false;
    }

    public boolean Mz() {
        return false;
    }

    public co a_() {
        if (n5()) {
            return ((cf) this).gn();
        }
        if (q7()) {
            return ((cg) this).a_().a_();
        }
        if (Z1()) {
            return ((ca) this).a_().a_();
        }
        if (AL()) {
            return this.j6.j6(((bo) this).FH().a_(), ((bo) this).DW());
        }
        return this;
    }

    public String toString() {
        return iW();
    }
}
