class apn$a extends apv {
    private final aql DW;
    private final aps FH;
    private final apv Hw;
    final /* synthetic */ apn j6;

    apn$a(apn apn, aql aql, apv apv) {
        this.j6 = apn;
        this.DW = aql;
        this.FH = new aps();
        this.Hw = apv;
        this.Hw.j6(this.FH);
    }

    int DW() {
        return this.Hw.DW();
    }

    void j6(apm apm) {
        apm.j6(this.FH);
    }

    aqc j6() {
        aqc j6 = this.Hw.j6();
        if (j6 != null) {
            for (aqc aqc : j6.u7) {
                if ((aqc.we & 4) != 0) {
                    this.FH.j6(aqc);
                }
            }
            return j6;
        }
        apv aps = new aps();
        aps.j6(this.FH);
        while (true) {
            aqc j62 = this.FH.j6();
            if (j62 == null) {
                aps.FH(16);
                this.j6.j6 = aps;
                return aps.j6();
            } else if ((j62.we & 16) == 0) {
                if ((j62.we & 1) == 0) {
                    j62.j6(this.DW);
                }
                j62.we |= 16;
                aps.j6(j62);
            }
        }
    }
}
