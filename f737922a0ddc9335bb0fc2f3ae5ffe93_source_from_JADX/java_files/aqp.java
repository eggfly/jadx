class aqp extends apv {
    private final int DW;
    private final aps j6;

    aqp(apv apv) {
        this.j6 = new aps();
        this.DW = apv.DW() | 8;
        apv.j6(this.j6);
        while (true) {
            aqc j6 = apv.j6();
            if (j6 != null) {
                for (aqc aqc : j6.u7) {
                    aqc.EQ++;
                }
                this.j6.j6(j6);
            } else {
                return;
            }
        }
    }

    int DW() {
        return this.DW;
    }

    void j6(apm apm) {
        apm.j6(this.j6);
    }

    aqc j6() {
        aqc j6;
        while (true) {
            j6 = this.j6.j6();
            if (j6 != null) {
                if (j6.EQ <= 0) {
                    break;
                }
                j6.we |= 32;
            } else {
                return null;
            }
        }
        for (aqc aqc : j6.u7) {
            int i = aqc.EQ - 1;
            aqc.EQ = i;
            if (i == 0 && (aqc.we & 32) != 0) {
                aqc.we &= -33;
                this.j6.DW(aqc);
            }
        }
        return j6;
    }
}
