class apz extends apv {
    private static final aqc DW;
    private final aql FH;
    private final apo Hw;
    private aqc VH;
    private final int Zo;
    private int gn;
    boolean j6;
    private final aqt v5;

    static {
        DW = new aqc(ans.Zo());
        DW.tp = Integer.MAX_VALUE;
    }

    apz(aql aql, apo apo, aqt aqt, int i) {
        this.VH = DW;
        this.gn = 6;
        this.FH = aql;
        this.Hw = apo;
        this.v5 = aqt;
        this.Zo = i;
        this.j6 = true;
    }

    int DW() {
        return this.Zo | 1;
    }

    aqc j6() {
        while (true) {
            try {
                aqc j6 = this.Hw.j6();
                if (j6 == null) {
                    this.FH.DW.DW();
                    return null;
                }
                boolean z;
                int i;
                if ((j6.we & 4) != 0) {
                    z = false;
                } else {
                    if (this.v5.DW()) {
                        j6.DW(this.FH);
                    }
                    z = this.v5.j6(this.FH, j6);
                }
                for (aqc aqc : j6.u7) {
                    if ((aqc.we & 2) == 0) {
                        if ((aqc.we & 1) == 0) {
                            aqc.j6(this.FH);
                        }
                        aqc.we |= 2;
                        this.Hw.j6(aqc);
                    }
                }
                this.FH.Hw(j6);
                if ((j6.we & 4) != 0) {
                    if (this.Hw.j6(4)) {
                        aqc FH = this.Hw.FH();
                        if (FH == null || FH.tp < this.VH.tp) {
                            i = this.gn - 1;
                            this.gn = i;
                            if (i == 0) {
                                break;
                            }
                        }
                        this.gn = 6;
                    } else {
                        this.gn = 6;
                    }
                    if (this.j6) {
                        j6.QX();
                    }
                } else if (z) {
                    this.VH = j6;
                    return j6;
                } else if (this.j6) {
                    j6.QX();
                }
            } catch (alv e) {
                this.FH.DW.DW();
                this.Hw.Hw();
                return null;
            }
        }
        throw alv.j6;
    }
}
