import com.aide.uidesigner.ProxyTextView;

public final class cf extends co {
    private int DW;
    private bp FH;
    private co[] Hw;
    private ea<co> Zo;
    private bt j6;
    private int[] v5;

    protected cf(bw bwVar, bt btVar) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
    }

    protected cf(bw bwVar, bt btVar, bp bpVar, co[] coVarArr, int[] iArr) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
        this.DW = btVar.DW((bs) this);
        this.FH = bpVar;
        this.Hw = coVarArr;
        this.v5 = iArr;
        this.Zo = null;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.DW = eeVar.readInt();
        this.FH = (bp) this.j6.FH(eeVar.readInt());
        int readInt = eeVar.readInt();
        this.Hw = new co[readInt];
        this.v5 = new int[readInt];
        for (int i = 0; i < this.Hw.length; i++) {
            this.Hw[i] = (co) this.j6.FH(eeVar.readInt());
            this.v5[i] = eeVar.readInt();
        }
        if (eeVar.readBoolean()) {
            this.Zo = new ea(this.j6, eeVar);
        }
    }

    protected void j6(ef efVar) {
        boolean z = false;
        super.j6(efVar);
        efVar.writeInt(this.DW);
        efVar.writeInt(this.j6.j6(this.FH));
        efVar.writeInt(this.Hw.length);
        for (int i = 0; i < this.Hw.length; i++) {
            efVar.writeInt(this.j6.j6(this.Hw[i]));
            efVar.writeInt(this.v5[i]);
        }
        if (this.Zo != null) {
            z = true;
        }
        efVar.writeBoolean(z);
        if (this.Zo != null) {
            this.Zo.j6(efVar);
        }
    }

    public void j6() {
        this.Zo = null;
    }

    public co[] DW() {
        return this.Hw;
    }

    public int[] FH() {
        return this.v5;
    }

    public boolean g3() {
        return gn().g3();
    }

    public bv tp() {
        return gn().tp();
    }

    public boolean vJ() {
        return gn().vJ();
    }

    public boolean I() {
        return gn().I();
    }

    public boolean ca() {
        return gn().ca();
    }

    public boolean Mz() {
        return gn().Mz();
    }

    public co j6(int i, boolean z, int i2, bs bsVar, bv bvVar, bj bjVar) {
        co j6 = gn().j6(i, z, i2, bsVar, bvVar, bjVar);
        if (j6.cT()) {
            j6 = ((bp) j6).j3();
        }
        return j6(j6);
    }

    public co j6(co[] coVarArr, int[] iArr) {
        bp gn = gn();
        int XX = gn.XX();
        int kQ = gn.kQ();
        if (XX < kQ) {
            int i;
            co[] DW = DW();
            int[] FH = FH();
            co[] coVarArr2 = new co[kQ];
            int[] iArr2 = new int[kQ];
            for (i = 0; i < kQ - XX; i++) {
                coVarArr2[i] = DW[i];
                iArr2[i] = FH[i];
            }
            for (i = kQ - XX; i < kQ; i++) {
                coVarArr2[i] = coVarArr[(i - kQ) + XX];
                iArr2[i] = iArr[(i - kQ) + XX];
            }
            iArr = this.v5;
            coVarArr = coVarArr2;
        }
        return this.j6.j6(gn, coVarArr, iArr);
    }

    public ea<co> Zo() {
        if (this.Zo == null) {
            this.Zo = new ea(this.j6);
            ea FN = this.FH.FN();
            FN.j6.j6();
            while (FN.j6.DW()) {
                try {
                    this.Zo.j6(j6((co) FN.j6.FH()));
                } catch (ej e) {
                }
            }
        }
        return this.Zo;
    }

    public co j6(co coVar) {
        return j6(coVar, true);
    }

    public co j6(co coVar, boolean z) {
        if (coVar.AL()) {
            return this.j6.j6(j6(((bo) coVar).FH()), ((bo) coVar).DW());
        }
        int i;
        if (coVar.q7()) {
            i = 0;
            while (i < this.Hw.length) {
                try {
                    if (this.FH.DW(i) == coVar) {
                        return this.Hw[i];
                    }
                    i++;
                } catch (ej e) {
                }
            }
            return coVar;
        } else if (!coVar.n5()) {
            return coVar;
        } else {
            co[] DW = ((cf) coVar).DW();
            int[] FH = ((cf) coVar).FH();
            int[] iArr = new int[DW.length];
            co[] coVarArr = new co[DW.length];
            for (i = 0; i < DW.length; i++) {
                co coVar2 = DW[i];
                int i2 = 0;
                while (i2 < this.Hw.length) {
                    if (this.FH.DW(i2) == coVar2) {
                        coVar2 = this.FH.DW(i2).a_();
                        coVarArr[i] = this.Hw[i2];
                        switch (FH[i]) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                if (!z) {
                                    switch (this.v5[i2]) {
                                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                            iArr[i] = this.v5[i2];
                                            break;
                                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            throw new ej();
                                        default:
                                            break;
                                    }
                                }
                                iArr[i] = this.v5[i2];
                                break;
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                if (!z) {
                                    switch (this.v5[i2]) {
                                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            iArr[i] = 2;
                                            if (coVar2 != this.Hw[i2]) {
                                                break;
                                            }
                                            iArr[i] = 1;
                                            break;
                                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                            throw new ej();
                                        default:
                                            break;
                                    }
                                }
                                switch (this.v5[i2]) {
                                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        iArr[i] = 2;
                                        if (coVar2 != this.Hw[i2]) {
                                            break;
                                        }
                                        iArr[i] = 1;
                                        break;
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        iArr[i] = 1;
                                        coVarArr[i] = coVar2;
                                        break;
                                    default:
                                        break;
                                }
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                if (!z) {
                                    switch (this.v5[i2]) {
                                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                            iArr[i] = 3;
                                            if (coVar2 != this.Hw[i2]) {
                                                break;
                                            }
                                            iArr[i] = 0;
                                            break;
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            iArr[i] = 0;
                                            coVarArr[i] = coVar2;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                switch (this.v5[i2]) {
                                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                        iArr[i] = 3;
                                        if (coVar2 != this.Hw[i2]) {
                                            break;
                                        }
                                        iArr[i] = 0;
                                        break;
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                        iArr[i] = 1;
                                        coVarArr[i] = coVar2;
                                        break;
                                    default:
                                        break;
                                }
                            default:
                                continue;
                        }
                    } else {
                        i2++;
                    }
                }
                coVarArr[i] = j6(coVar2, z);
                iArr[i] = FH[i];
            }
            return this.j6.j6(((cf) coVar).gn(), coVarArr, iArr);
        }
    }

    public bp gn() {
        return this.FH;
    }

    public int v5() {
        return this.DW;
    }

    public bj Hw() {
        return gn().Hw();
    }
}
