public final class ce extends bs {
    private final bt DW;
    private ec EQ;
    private final by FH;
    private final bw Hw;
    private dr<bp> J0;
    private dr<bp> J8;
    private dr<bz> QX;
    private boolean VH;
    private dr<bp> Ws;
    private ce Zo;
    private dr<ce> gn;
    private int j6;
    private eb tp;
    private dr<bp> u7;
    private int v5;
    private dr<bp> we;

    protected ce(bt btVar, by byVar, bw bwVar) {
        super(bwVar, btVar);
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = bwVar;
    }

    protected ce(bt btVar, by byVar, bw bwVar, int i, ce ceVar) {
        super(bwVar, btVar);
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = bwVar;
        this.v5 = i;
        this.j6 = btVar.DW((bs) this);
        this.Zo = ceVar;
        this.VH = ceVar == null;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.v5 = eeVar.readInt();
        this.j6 = eeVar.readInt();
        this.Zo = (ce) this.DW.FH(eeVar.readInt());
        this.VH = eeVar.readBoolean();
        if (eeVar.readBoolean()) {
            this.gn = new dr(this.DW, eeVar);
        }
        if (eeVar.readBoolean()) {
            this.u7 = new dr(this.DW, eeVar);
        }
        if (eeVar.readBoolean()) {
            this.tp = new eb(this.Hw, eeVar);
        }
        if (eeVar.readBoolean()) {
            this.EQ = new ec(eeVar);
        }
    }

    protected void j6(ef efVar) {
        boolean z;
        boolean z2 = true;
        super.j6(efVar);
        efVar.writeInt(this.v5);
        efVar.writeInt(this.j6);
        efVar.writeInt(this.DW.j6(this.Zo));
        efVar.writeBoolean(this.VH);
        efVar.writeBoolean(this.gn != null);
        if (this.gn != null) {
            this.gn.j6(efVar);
        }
        if (this.u7 != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.u7 != null) {
            this.u7.j6(efVar);
        }
        if (this.tp != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.tp != null) {
            this.tp.j6(efVar);
        }
        if (this.EQ == null) {
            z2 = false;
        }
        efVar.writeBoolean(z2);
        if (this.EQ != null) {
            this.EQ.j6(efVar);
        }
    }

    public void j6() {
        this.J8 = null;
        this.Ws = null;
        this.J0 = null;
        this.QX = null;
    }

    public void DW() {
        if (this.tp != null) {
            this.tp.j6();
        }
        if (this.u7 != null) {
            this.u7.DW();
        }
        if (this.EQ != null) {
            this.EQ.j6();
        }
        this.VH = false;
        this.we = null;
    }

    public int aq() {
        return this.v5;
    }

    protected void j6(bv bvVar) {
        int gn = bvVar.gn();
        for (ce ceVar = this.Zo; ceVar != null; ceVar = ceVar.Zo) {
            ceVar.VH = true;
            if (ceVar.EQ == null) {
                ceVar.EQ = new ec();
            }
            ceVar.EQ.j6(gn);
        }
        if (this.tp == null) {
            this.tp = new eb(this.Hw);
        }
        this.tp.j6(bvVar);
        if (this.EQ == null) {
            this.EQ = new ec();
        }
        this.EQ.j6(gn);
        this.VH = true;
    }

    protected void j6(int i, bp bpVar) {
        if (this.u7 == null) {
            this.u7 = new dr(this.DW);
        }
        this.u7.DW(i, (bs) bpVar);
    }

    public ce j6(int i) {
        if (this.gn == null) {
            this.gn = new dr(this.DW);
        }
        if (this.gn.j6(i)) {
            return (ce) this.gn.FH(i);
        }
        bs ceVar = new ce(this.DW, this.FH, this.Hw, i, this);
        this.gn.j6(i, ceVar);
        return ceVar;
    }

    public ce FH() {
        return this.Zo;
    }

    public bj Hw() {
        bj J0 = J0();
        if (J0 != null) {
            return J0;
        }
        for (bh bhVar : this.Hw.DW()) {
            if (bhVar.Zo().size() > 0) {
                return (bj) bhVar.Zo().get(0);
            }
        }
        return null;
    }

    private bj J0() {
        this.DW.u7();
        if (this.tp != null && this.tp.FH() > 0 && this.tp.DW().BT() != null && this.tp.DW().BT().Zo().size() > 0) {
            return (bj) this.tp.DW().BT().Zo().get(0);
        }
        if (this.gn != null && this.gn.FH() > 0) {
            this.gn.j6.j6();
            while (this.gn.j6.DW()) {
                bj J0 = ((ce) this.gn.j6.Hw()).J0();
                if (J0 != null) {
                    return J0;
                }
            }
        }
        return null;
    }

    public String iW() {
        String iW = super.iW();
        if (iW.length() != 0) {
            return iW;
        }
        if (Zo()) {
            return "";
        }
        if (FH().Zo()) {
            return this.FH.j6(aq());
        }
        return FH().iW() + "." + this.FH.j6(aq());
    }

    public String eU() {
        String eU = super.eU();
        if (eU.length() == 0) {
            return this.FH.j6(aq());
        }
        return eU;
    }

    public boolean Zo() {
        return this.Zo == null;
    }

    public ea<ce> VH() {
        this.DW.u7();
        ea<ce> eaVar = new ea(this.DW);
        if (this.gn != null) {
            this.gn.j6.j6();
            while (this.gn.j6.DW()) {
                bs bsVar = (ce) this.gn.j6.Hw();
                if (bsVar.VH) {
                    eaVar.j6(bsVar);
                }
            }
        }
        return eaVar;
    }

    public dr<bp> gn() {
        this.DW.u7();
        if (this.u7 == null) {
            this.u7 = new dr(this.DW);
        }
        return this.u7;
    }

    public eb u7() {
        this.DW.u7();
        if (this.tp == null) {
            return new eb(this.Hw);
        }
        return this.tp;
    }

    public ea<bp> j6(bv bvVar, bj bjVar, int i) {
        ea<bp> eaVar;
        ea<bp> eaVar2;
        ea<bp> eaVar3 = null;
        this.DW.u7();
        Object obj = null;
        if (this.u7 != null) {
            this.u7.j6.j6(i);
            eaVar = null;
            while (this.u7.j6.DW()) {
                bs bsVar = (bp) this.u7.j6.Hw();
                if (bsVar.ef() && bsVar.j6(bvVar, bjVar)) {
                    if (bsVar.Sf()) {
                        obj = 1;
                    }
                    if (bsVar.tp() == bvVar) {
                        if (eaVar3 == null) {
                            eaVar3 = new ea(this.DW);
                        }
                        eaVar3.j6(bsVar);
                    }
                    if (eaVar == null) {
                        eaVar = new ea(this.DW);
                    }
                    eaVar.j6(bsVar);
                }
                eaVar3 = eaVar3;
                eaVar = eaVar;
                obj = obj;
            }
            eaVar2 = eaVar3;
        } else {
            eaVar2 = null;
            eaVar = null;
        }
        return obj != null ? eaVar2 : eaVar;
    }

    public ec we() {
        if (this.EQ == null) {
            return new ec();
        }
        return this.EQ;
    }

    public bs j6(bv bvVar, bj bjVar, int i, boolean z, int i2, ce ceVar) {
        this.DW.u7();
        bs Hw = Hw(bvVar, bjVar, i, z, i2, ceVar);
        return Hw != null ? Hw : j6(bvVar, i, z);
    }

    public bp DW(bv bvVar, bj bjVar, int i, boolean z, int i2, ce ceVar) {
        this.DW.u7();
        bp Hw = Hw(bvVar, bjVar, i, z, i2, ceVar);
        if (Hw != null) {
            return Hw;
        }
        throw new ej();
    }

    private bp Hw(bv bvVar, bj bjVar, int i, boolean z, int i2, ce ceVar) {
        bp bpVar = null;
        if (this.u7 != null) {
            dr drVar;
            dr drVar2 = this.u7;
            if (z) {
                drVar = drVar2;
            } else {
                if (this.we == null) {
                    this.we = new dr(this.DW);
                    this.u7.j6.j6();
                    while (this.u7.j6.DW()) {
                        this.we.DW(this.FH.FH(this.u7.j6.FH()), (bp) this.u7.j6.Hw());
                    }
                }
                i = this.FH.FH(i);
                drVar = this.we;
            }
            if (drVar.j6(i)) {
                drVar.j6.j6(i);
                while (drVar.j6.DW()) {
                    bp bpVar2 = (bp) drVar.j6.Hw();
                    if (bpVar2.j6((bs) ceVar) && bpVar2.j6(bvVar, bjVar)) {
                        if (bpVar != null) {
                            if (this.Hw.j6(bvVar, bpVar.tp(), bpVar2.tp())) {
                                bpVar2 = bpVar;
                            } else if (this.Hw.j6(bvVar, bpVar2.tp(), bpVar.tp())) {
                            }
                        }
                        bpVar = bpVar2;
                    }
                    bpVar2 = bpVar;
                    bpVar = bpVar2;
                }
            }
        }
        return bpVar;
    }

    public boolean FH(bv bvVar, bj bjVar, int i, boolean z, int i2, ce ceVar) {
        this.DW.u7();
        if (this.u7 == null) {
            return false;
        }
        dr drVar;
        dr drVar2 = this.u7;
        if (z) {
            drVar = drVar2;
        } else {
            if (this.we == null) {
                this.we = new dr(this.DW);
                this.u7.j6.j6();
                while (this.u7.j6.DW()) {
                    this.we.DW(this.FH.FH(this.u7.j6.FH()), (bp) this.u7.j6.Hw());
                }
            }
            i = this.FH.FH(i);
            drVar = this.we;
        }
        if (drVar.j6(i)) {
            drVar.j6.j6(i);
            while (drVar.j6.DW()) {
                bp bpVar = (bp) drVar.j6.Hw();
                if (bpVar.j6((bs) ceVar) && bpVar.j6(bvVar, bjVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean j6(int i, boolean z) {
        this.DW.u7();
        if (this.u7 == null) {
            return false;
        }
        dr drVar = this.u7;
        if (!z) {
            if (this.we == null) {
                this.we = new dr(this.DW);
                this.u7.j6.j6();
                while (this.u7.j6.DW()) {
                    this.we.DW(this.FH.FH(this.u7.j6.FH()), (bp) this.u7.j6.Hw());
                }
            }
            i = this.FH.FH(i);
            drVar = this.we;
        }
        return drVar.j6(i);
    }

    public ce j6(bv bvVar, int i, boolean z) {
        ce ceVar;
        this.DW.u7();
        if (z) {
            if (this.gn != null && this.gn.j6(i)) {
                ceVar = (ce) this.gn.FH(i);
                if (ceVar.VH) {
                    ec we = ceVar.we();
                    we.j6.j6();
                    while (we.j6.DW()) {
                        if (this.Hw.DW(we.j6.FH(), bvVar.gn())) {
                        }
                    }
                }
            }
            throw new ej();
        }
        if (this.gn != null) {
            int FH = this.FH.FH(i);
            this.gn.j6.j6();
            while (this.gn.j6.DW()) {
                ceVar = (ce) this.gn.j6.Hw();
                if (ceVar.VH && this.FH.FH(ceVar.aq()) == FH) {
                    ec we2 = ceVar.we();
                    we2.j6.j6();
                    while (we2.j6.DW()) {
                        if (this.Hw.DW(we2.j6.FH(), bvVar.gn())) {
                        }
                    }
                    continue;
                }
            }
        }
        throw new ej();
        return ceVar;
    }

    public int v5() {
        return this.j6;
    }
}
