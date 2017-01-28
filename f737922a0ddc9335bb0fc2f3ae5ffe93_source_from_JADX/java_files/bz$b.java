import com.aide.uidesigner.ProxyTextView;

protected class bz$b {
    private ea<ca> DW;
    private boolean EQ;
    private dg FH;
    private dq<ca, co> Hw;
    private dq<ca, co> VH;
    private dq<ca, co> Zo;
    private dq<ca, co> gn;
    private bt j6;
    private bj tp;
    private bv u7;
    private dg v5;

    public bz$b(bt btVar) {
        this.v5 = new dg();
        this.j6 = btVar;
        this.FH = new dg();
        this.Hw = new dq(btVar);
        this.Zo = new dq(btVar);
        this.VH = new dq(btVar);
        this.gn = new dq(btVar);
    }

    public co j6(bv bvVar, bj bjVar, bz bzVar, int i, co coVar, co[] coVarArr, int i2, int i3, co[] coVarArr2, int i4, int i5) {
        this.u7 = bvVar;
        this.tp = bjVar;
        this.EQ = false;
        if (i3 != bzVar.lp()) {
            throw new ej();
        } else if (j6(bzVar, coVar, coVarArr, i3, i2, coVarArr2, i4, i5)) {
            return j6(bzVar.j6(i, coVar));
        } else {
            throw new ej();
        }
    }

    public co j6(bv bvVar, bj bjVar, bz bzVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4) {
        this.u7 = bvVar;
        this.tp = bjVar;
        this.EQ = false;
        if (i2 != bzVar.lp()) {
            throw new ej();
        } else if (j6(bzVar, coVar, coVarArr, i2, i, coVarArr2, i3, i4)) {
            return j6(bzVar.DW(coVar));
        } else {
            throw new ej();
        }
    }

    public co DW(bv bvVar, bj bjVar, bz bzVar, int i, co coVar, co[] coVarArr, int i2, int i3, co[] coVarArr2, int i4, int i5) {
        this.u7 = bvVar;
        this.tp = bjVar;
        this.EQ = false;
        if (i3 != bzVar.lp()) {
            throw new ej();
        } else if (j6(bzVar, coVar, coVarArr, i3, i2, coVarArr2, i4, i5)) {
            return j6(bzVar.FH(coVar, i));
        } else {
            throw new ej();
        }
    }

    public boolean DW(bv bvVar, bj bjVar, bz bzVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4) {
        try {
            this.u7 = bvVar;
            this.tp = bjVar;
            this.EQ = false;
            if (i2 != bzVar.lp()) {
                return false;
            }
            if (!j6(bzVar, coVar, coVarArr, i2, i, coVarArr2, i3, i4)) {
                return false;
            }
            if (i4 == 0) {
                return true;
            }
            for (int i5 = 0; i5 < i2; i5++) {
                co j6 = j6(bzVar.FH(coVar, i5));
                if (coVarArr[i5 + i] != null) {
                    if (!j6(bvVar, bjVar, coVarArr[i5 + i].sg(), j6, this.EQ)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ej e) {
            return false;
        }
    }

    private boolean j6(bv bvVar, bj bjVar, co coVar, co coVar2, boolean z) {
        return coVar.FH(bvVar, bjVar, coVar2);
    }

    private co j6(co coVar) {
        if (coVar.Z1()) {
            return this.Hw.DW((ca) coVar) ? (co) this.Hw.Hw((ca) coVar) : coVar;
        } else {
            if (coVar.n5()) {
                co[] DW = ((cf) coVar).DW();
                co[] coVarArr = new co[DW.length];
                int[] FH = ((cf) coVar).FH();
                int[] iArr = new int[DW.length];
                for (int i = 0; i < DW.length; i++) {
                    coVarArr[i] = j6(DW[i]);
                    iArr[i] = FH[i];
                    if (this.v5.DW(DW[i].v5())) {
                        iArr[i] = this.v5.FH(DW[i].v5());
                    }
                }
                return this.j6.j6(((cf) coVar).gn(), coVarArr, iArr);
            } else if (coVar.AL()) {
                return this.j6.j6(j6(((bo) coVar).FH()), 1);
            } else {
                return coVar;
            }
        }
    }

    private boolean j6(bz bzVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4) {
        if (i4 > 0 && bzVar.OW() != i4) {
            return false;
        }
        this.v5.j6();
        int i5;
        if (i4 > 0) {
            this.DW = bzVar.br();
            this.Hw.j6();
            for (i5 = 0; i5 < i4; i5++) {
                if (coVarArr2[i3 + i5] != null) {
                    this.Hw.j6(bzVar.gn(i5), coVarArr2[i3 + i5]);
                }
            }
            return j6(bzVar, coVar);
        }
        try {
            co FH;
            this.DW = bzVar.br();
            this.Zo.j6();
            this.VH.j6();
            this.gn.j6();
            this.FH.j6();
            int lp = bzVar.lp();
            this.DW.j6.j6();
            while (this.DW.j6.DW()) {
                co coVar2 = (ca) this.DW.j6.FH();
                for (int i6 = 0; i6 < lp; i6++) {
                    FH = bzVar.FH(coVar, i6);
                    if (FH.n5()) {
                        co[] DW = ((cf) FH).DW();
                        for (co coVar3 : DW) {
                            if (coVar2 == coVar3) {
                                if (!this.FH.DW(coVar2.v5())) {
                                    this.FH.j6(coVar2.v5(), 0);
                                }
                                this.FH.j6(coVar2.v5(), this.FH.FH(coVar2.v5()) + 1);
                            }
                        }
                    } else if (FH.v5(coVar2)) {
                        this.FH.j6(coVar2.v5(), 2);
                    }
                }
            }
            i5 = 0;
            while (i5 < lp) {
                FH = bzVar.FH(coVar, i5);
                if (coVarArr[i5 + i2] != null && !j6(coVarArr[i5 + i2].sg(), FH)) {
                    return false;
                }
                i5++;
            }
            return j6() && j6(bzVar, coVar);
        } catch (ej e) {
            return false;
        }
    }

    private boolean j6(co coVar, co coVar2) {
        int i = 0;
        if (coVar.Gj() == 2) {
            return true;
        }
        if (coVar == coVar2) {
            return true;
        }
        if (coVar2.Z1()) {
            if (this.DW.FH((bs) coVar2)) {
                return FH((ca) coVar2, coVar);
            }
            return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
        } else if (coVar2.n5()) {
            if (coVar.n5()) {
                co gn = ((cf) coVar2).gn();
                if (gn == ((cf) coVar).gn()) {
                    co[] DW = ((cf) coVar2).DW();
                    co[] DW2 = ((cf) coVar).DW();
                    int[] FH = ((cf) coVar2).FH();
                    int[] FH2 = ((cf) coVar).FH();
                    int i2 = 0;
                    while (i2 < DW.length) {
                        switch (FH2[i2]) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                switch (FH[i2]) {
                                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                        if (FH(DW2[i2], DW[i2])) {
                                            break;
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        if (j6(DW2[i2], DW[i2])) {
                                            break;
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        if (DW(DW2[i2], DW[i2])) {
                                            break;
                                        }
                                        return false;
                                    default:
                                        break;
                                }
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                switch (FH[i2]) {
                                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                        if (DW[i2].Z1() && this.DW.FH(DW[i2]) && j6(DW[i2], FH2[i2])) {
                                            return j6((ca) DW[i2], DW2[i2]);
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        if (j6(DW2[i2], DW[i2])) {
                                            break;
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        return false;
                                    default:
                                        break;
                                }
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                switch (FH[i2]) {
                                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                        if (DW[i2].Z1() && this.DW.FH(DW[i2]) && j6(DW[i2], FH2[i2])) {
                                            return j6((ca) DW[i2], DW2[i2]);
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        try {
                                            if (DW[i2] == this.j6.v5(this.u7, this.tp)) {
                                                return true;
                                            }
                                            return false;
                                        } catch (ej e) {
                                            break;
                                        }
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        if (DW(DW2[i2], DW[i2])) {
                                            break;
                                        }
                                        return false;
                                    default:
                                        break;
                                }
                            default:
                                break;
                        }
                        i2++;
                    }
                    return true;
                }
                ea Zo = ((cf) coVar).Zo();
                Zo.j6.j6();
                while (Zo.j6.DW()) {
                    r1 = (co) Zo.j6.FH();
                    if (r1 == coVar2) {
                        return true;
                    }
                    if (r1.cT()) {
                        if (r1 == gn) {
                            return true;
                        }
                    } else if (((cf) r1).gn() == gn) {
                        try {
                            return j6(((cf) coVar).j6(r1), coVar2);
                        } catch (ej e2) {
                        }
                    } else {
                        continue;
                    }
                }
                return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
            } else if (coVar.cT()) {
                if (coVar == ((cf) coVar2).gn()) {
                    return true;
                }
                if (coVar.j6(this.u7, this.tp, coVar2)) {
                    return true;
                }
                if (coVar.j6(this.u7, this.tp, ((cf) coVar2).gn())) {
                    return true;
                }
                if (coVar.e3() && ((bp) coVar).FH(((cf) coVar2).gn())) {
                    return true;
                }
                ea FN = ((bp) coVar).FN();
                FN.j6.j6();
                while (FN.j6.DW()) {
                    r1 = (co) FN.j6.FH();
                    if (r1 == coVar2) {
                        return true;
                    }
                    if (r1.n5() && ((cf) r1).gn() == ((cf) coVar2).gn()) {
                        return j6(r1, coVar2);
                    }
                }
                return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
            } else if (coVar.q7()) {
                r8 = ((cg) coVar).DW();
                while (i < r8) {
                    try {
                        co j6 = ((cg) coVar).j6(i);
                        if (j6(this.u7, this.tp, j6.a_(), coVar2.a_(), this.EQ)) {
                            return j6(j6, coVar2);
                        }
                        i++;
                    } catch (ej e3) {
                    }
                }
                return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
            } else if (coVar.Z1()) {
                int Zo2 = ((ca) coVar).Zo();
                r8 = 0;
                while (r8 < Zo2) {
                    try {
                        co j62 = ((ca) coVar).j6(r8);
                        if (j6(this.u7, this.tp, j62.a_(), coVar2.a_(), this.EQ)) {
                            return j6(j62, coVar2);
                        }
                        r8++;
                    } catch (ej e4) {
                    }
                }
                return false;
            } else if (coVar.AL()) {
                ea j63 = this.j6.j6(this.u7, this.tp, (bo) coVar);
                if (j63 != null) {
                    j63.j6.j6();
                    while (j63.j6.DW()) {
                        if (!j6((co) j63.j6.FH(), coVar2)) {
                            return false;
                        }
                    }
                    return true;
                }
                return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
            } else {
                return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
            }
        } else if (!coVar2.AL()) {
            return j6(this.u7, this.tp, coVar, coVar2, this.EQ);
        } else if (!coVar.AL()) {
            return false;
        } else {
            r1 = ((bo) coVar).FH();
            co FH3 = ((bo) coVar2).FH();
            if (!r1.hK() || FH3.hK()) {
                return j6(r1, FH3);
            }
            return false;
        }
    }

    private boolean DW(co coVar, co coVar2) {
        if (coVar.Gj() == 2) {
            return true;
        }
        if (coVar == coVar2) {
            return true;
        }
        if (coVar2.Z1()) {
            if (this.DW.FH((bs) coVar2)) {
                return DW((ca) coVar2, coVar);
            }
            return j6(this.u7, this.tp, coVar2, coVar, this.EQ);
        } else if (coVar2.n5()) {
            ea Zo;
            if (coVar.n5()) {
                co gn = ((cf) coVar2).gn();
                co gn2 = ((cf) coVar).gn();
                if (gn == gn2) {
                    co[] DW = ((cf) coVar2).DW();
                    co[] DW2 = ((cf) coVar).DW();
                    int[] FH = ((cf) coVar2).FH();
                    int[] FH2 = ((cf) coVar).FH();
                    for (int i = 0; i < DW.length; i++) {
                        switch (FH[i]) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                switch (FH2[i]) {
                                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                        if (FH(DW2[i], DW[i])) {
                                            break;
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        if (DW(DW2[i], DW[i])) {
                                            break;
                                        }
                                        return false;
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        if (j6(DW2[i], DW[i])) {
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
                                        if (DW(DW2[i], DW[i])) {
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
                                            if (DW2[i] == this.j6.v5(this.u7, this.tp)) {
                                                return true;
                                            }
                                            return false;
                                        } catch (ej e) {
                                            break;
                                        }
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        if (j6(DW2[i], DW[i])) {
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
                Zo = ((cf) coVar2).Zo();
                Zo.j6.j6();
                while (Zo.j6.DW()) {
                    r1 = (co) Zo.j6.FH();
                    if (r1 == coVar) {
                        return true;
                    }
                    if (r1.cT()) {
                        if (r1 == gn2) {
                            return true;
                        }
                    } else if (((cf) r1).gn() == gn2) {
                        try {
                            return DW(coVar, ((cf) coVar2).j6(r1));
                        } catch (ej e2) {
                        }
                    } else {
                        continue;
                    }
                }
                return j6(this.u7, this.tp, coVar2, coVar, this.EQ);
            } else if (!coVar.cT()) {
                return j6(this.u7, this.tp, coVar2, coVar, this.EQ);
            } else if (coVar == ((cf) coVar2).gn()) {
                return true;
            } else {
                Zo = ((cf) coVar2).Zo();
                Zo.j6.j6();
                while (Zo.j6.DW()) {
                    r1 = (co) Zo.j6.FH();
                    if (r1 == coVar) {
                        return true;
                    }
                    if (r1.cT()) {
                        if (r1 == coVar) {
                            return true;
                        }
                    } else if (((cf) r1).gn() == coVar) {
                        try {
                            return DW(coVar, ((cf) coVar2).j6(r1));
                        } catch (ej e3) {
                        }
                    } else {
                        continue;
                    }
                }
                return j6(this.u7, this.tp, coVar2, coVar, this.EQ);
            }
        } else if (!coVar2.AL()) {
            return j6(this.u7, this.tp, coVar2, coVar, this.EQ);
        } else if (coVar.AL()) {
            r1 = ((bo) coVar).FH();
            co FH3 = ((bo) coVar2).FH();
            if (!r1.hK() || FH3.hK()) {
                return DW(r1, FH3);
            }
            return false;
        } else {
            return j6(this.u7, this.tp, coVar2, coVar, this.EQ);
        }
    }

    private boolean FH(co coVar, co coVar2) {
        if (coVar.Gj() == 2 || coVar == coVar2) {
            return true;
        }
        if (coVar2.Z1()) {
            if (this.DW.FH((bs) coVar2)) {
                return j6((ca) coVar2, coVar);
            }
            return coVar == coVar2;
        } else if (coVar2.AL()) {
            return coVar.AL() ? FH(((bo) coVar).FH(), ((bo) coVar2).FH()) : false;
        } else {
            if (coVar2.n5()) {
                if (!coVar.n5() || ((cf) coVar2).gn() != ((cf) coVar).gn()) {
                    return false;
                }
                co[] DW = ((cf) coVar2).DW();
                co[] DW2 = ((cf) coVar).DW();
                int[] FH = ((cf) coVar2).FH();
                int[] FH2 = ((cf) coVar).FH();
                for (int i = 0; i < DW2.length; i++) {
                    if (FH[i] != FH2[i]) {
                        return false;
                    }
                    if (!FH(DW2[i], DW[i])) {
                        return false;
                    }
                }
                return true;
            } else if (coVar != coVar2) {
                return false;
            } else {
                return true;
            }
        }
    }

    private boolean j6(ca caVar, co coVar) {
        if (coVar.Gj() == 2) {
            return true;
        }
        bs j6;
        if (coVar.hK()) {
            try {
                j6 = this.tp.VH().j6(this.u7, coVar);
            } catch (ej e) {
                j6 = coVar;
            }
        } else {
            j6 = coVar;
        }
        if (this.gn.DW((bs) caVar)) {
            return this.gn.Hw((bs) caVar) == j6;
        }
        this.Zo.j6.j6(caVar);
        while (this.Zo.j6.DW()) {
            if (!j6(this.u7, this.tp, (co) this.Zo.j6.Hw(), j6, this.EQ)) {
                return false;
            }
        }
        this.Zo.j6((bs) caVar);
        this.VH.j6.j6(caVar);
        while (this.VH.j6.DW()) {
            if (!j6(this.u7, this.tp, j6, (co) this.VH.j6.Hw(), this.EQ)) {
                return false;
            }
        }
        this.VH.j6((bs) caVar);
        this.gn.j6((bs) caVar, j6);
        return true;
    }

    private boolean j6(co coVar, int i) {
        if (!this.FH.DW(coVar.v5())) {
            return false;
        }
        if (this.v5.DW(coVar.v5()) && this.v5.FH(coVar.v5()) != i) {
            return false;
        }
        this.v5.j6(coVar.v5(), i);
        return true;
    }

    private boolean DW(ca caVar, co coVar) {
        if (coVar.Gj() == 2) {
            return true;
        }
        bs j6;
        if (coVar.hK()) {
            try {
                j6 = this.tp.VH().j6(this.u7, coVar);
            } catch (ej e) {
                j6 = coVar;
            }
        } else {
            j6 = coVar;
        }
        if (this.gn.DW((bs) caVar)) {
            return j6(this.u7, this.tp, (co) this.gn.Hw((bs) caVar), j6, this.EQ);
        }
        this.Zo.j6.j6(caVar);
        while (this.Zo.j6.DW()) {
            if (!j6(this.u7, this.tp, (co) this.Zo.j6.Hw(), j6, this.EQ)) {
                return false;
            }
        }
        this.VH.DW((bs) caVar, j6);
        return true;
    }

    private boolean FH(ca caVar, co coVar) {
        if (coVar.Gj() == 2) {
            return true;
        }
        bs j6;
        if (coVar.hK()) {
            try {
                j6 = this.tp.VH().j6(this.u7, coVar);
            } catch (ej e) {
                j6 = coVar;
            }
        } else {
            j6 = coVar;
        }
        if (this.gn.DW((bs) caVar)) {
            return j6(this.u7, this.tp, j6, (co) this.gn.Hw((bs) caVar), this.EQ);
        }
        this.VH.j6.j6(caVar);
        while (this.VH.j6.DW()) {
            if (!j6(this.u7, this.tp, j6, (co) this.VH.j6.Hw(), this.EQ)) {
                return false;
            }
        }
        this.Zo.DW((bs) caVar, j6);
        return true;
    }

    private boolean j6() {
        bs bsVar;
        bs bsVar2;
        this.Hw.j6();
        this.DW.j6.j6();
        while (this.DW.j6.DW()) {
            bs bsVar3;
            bs bsVar4 = (ca) this.DW.j6.FH();
            bs j6 = this.j6.j6((ca) bsVar4);
            if (this.gn.DW(bsVar4)) {
                bsVar3 = (co) this.gn.Hw(bsVar4);
            } else {
                co coVar;
                if (this.Zo.FH(bsVar4) == 0) {
                    if (this.VH.FH(bsVar4) == 1) {
                        coVar = (co) this.VH.Hw(bsVar4);
                    } else if (this.VH.FH(bsVar4) > 1) {
                        this.VH.j6.j6(bsVar4);
                        this.VH.j6.DW();
                        co coVar2 = (co) this.VH.j6.Hw();
                        while (this.VH.j6.DW()) {
                            co coVar3 = (co) this.VH.j6.Hw();
                            if (j6(this.u7, this.tp, coVar3, coVar2, this.EQ)) {
                                coVar2 = coVar3;
                            } else {
                                if (!j6(this.u7, this.tp, coVar2, coVar3, this.EQ)) {
                                    return false;
                                }
                            }
                        }
                        bsVar3 = coVar2;
                    }
                } else if (this.Zo.FH(bsVar4) == 1) {
                    coVar = (co) this.Zo.Hw(bsVar4);
                } else if (this.Zo.FH(bsVar4) > 1) {
                    int i = -1;
                    try {
                        int i2;
                        this.Zo.j6.j6(bsVar4);
                        bsVar = j6;
                        while (this.Zo.j6.DW()) {
                            try {
                                coVar = (co) this.Zo.j6.Hw();
                                if (coVar.AL()) {
                                    int DW = ((bo) coVar).DW();
                                    if (i == -1 || i == DW) {
                                        bsVar3 = bsVar;
                                    } else {
                                        bsVar3 = this.j6.v5(this.u7, this.tp);
                                    }
                                    bsVar = bsVar3;
                                    i2 = DW;
                                } else if (i != -1) {
                                    bsVar = this.j6.v5(this.u7, this.tp);
                                    i2 = i;
                                } else {
                                    i2 = i;
                                }
                                i = i2;
                            } catch (ej e) {
                            }
                        }
                        if (bsVar == j6) {
                            this.Zo.j6.j6(bsVar4);
                            bsVar2 = bsVar;
                            while (this.Zo.j6.DW()) {
                                try {
                                    bs FH;
                                    bsVar3 = (co) this.Zo.j6.Hw();
                                    if (bsVar3.AL()) {
                                        FH = ((bo) bsVar3).FH();
                                    } else {
                                        FH = bsVar3;
                                    }
                                    if (!(bsVar2 == null || j6(this.u7, this.tp, bsVar2, FH, this.EQ))) {
                                        if (j6(this.u7, this.tp, FH, bsVar2, this.EQ)) {
                                            FH = bsVar2;
                                        } else {
                                            FH = FH.Hw(this.u7, this.tp, bsVar2);
                                        }
                                    }
                                    bsVar2 = FH;
                                } catch (ej e2) {
                                    bsVar = bsVar2;
                                }
                            }
                            if (i != -1) {
                                for (i2 = 0; i2 < i; i2++) {
                                    bsVar2 = this.j6.j6((co) bsVar2, 1);
                                }
                            }
                        } else {
                            bsVar2 = bsVar;
                        }
                        bsVar3 = bsVar2;
                    } catch (ej e3) {
                        bsVar = j6;
                        bsVar3 = bsVar;
                        bsVar3 = bsVar4;
                        this.Hw.j6(bsVar4, bsVar3);
                    }
                }
                bsVar3 = j6;
            }
            if (bsVar3 == j6 && !this.tp.VH().FH()) {
                bsVar3 = bsVar4;
            }
            this.Hw.j6(bsVar4, bsVar3);
        }
        return true;
    }

    private boolean j6(bz bzVar, co coVar) {
        this.Hw.j6.j6();
        while (this.Hw.j6.DW()) {
            if (!j6(bzVar, coVar, (ca) this.Hw.j6.FH(), (co) this.Hw.j6.Hw())) {
                return false;
            }
        }
        return true;
    }

    private boolean j6(bz bzVar, co coVar, ca caVar, co coVar2) {
        try {
            int Zo = caVar.Zo();
            for (int i = 0; i < Zo; i++) {
                if (!j6(this.u7, this.tp, coVar2, j6(caVar.j6(coVar, i)), this.EQ)) {
                    return false;
                }
            }
        } catch (ej e) {
        }
        return true;
    }
}
