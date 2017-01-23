class apq extends apv {
    private final int DW;
    private final aql FH;
    private final aqe Hw;
    private final aps j6;
    private final aqe v5;

    apq(apr apr, apv apv) {
        this.j6 = new aps();
        this.FH = (aql) apr;
        this.DW = apr.j6();
        this.Hw = apr.DW();
        this.v5 = apr.FH();
        apv.j6(this.j6);
        while (true) {
            aqc j6 = apv.j6();
            if (j6 != null) {
                if (((apr$a) j6).VH() == 0) {
                    this.j6.j6(j6);
                }
            } else {
                return;
            }
        }
    }

    int DW() {
        return this.j6.DW() | 16;
    }

    void j6(apm apm) {
        this.j6.j6(apm);
    }

    aqc j6() {
        apr$a apr_a;
        Object obj;
        do {
            apr_a = (apr$a) this.j6.j6();
            if (apr_a == null) {
                return null;
            }
            if ((apr_a.we & 1) == 0) {
                apr_a.j6(this.FH);
            }
            int i = apr_a.VH + 1;
            for (aqc aqc : apr_a.u7) {
                apr$a apr_a2 = (apr$a) aqc;
                if (apr_a2.VH == -1) {
                    apr_a2.VH = i;
                    if (i <= this.DW) {
                        this.j6.j6(aqc);
                    }
                }
                if (apr_a.DW(this.Hw) || apr_a.DW(this.v5)) {
                    aqc.FH(this.v5);
                    aqc.we &= -5;
                }
            }
            obj = apr_a.VH <= this.DW ? 1 : null;
            if (!((apr_a.we & 4) == 0 || apr_a.DW(this.Hw))) {
                obj = null;
                continue;
            }
        } while (obj == null);
        return apr_a;
    }
}
