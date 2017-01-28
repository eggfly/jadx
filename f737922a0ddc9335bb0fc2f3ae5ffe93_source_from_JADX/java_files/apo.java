public class apo extends apj {
    private apo$a FH;
    private apo$a Hw;

    apo(apv apv) {
        while (true) {
            aqc j6 = apv.j6();
            if (j6 != null) {
                j6(j6);
            } else {
                return;
            }
        }
    }

    public void j6(aqc aqc) {
        apo$a apo_a = this.FH;
        long j = (long) aqc.tp;
        apo$a DW = DW(aqc);
        if (apo_a == null || j > ((long) apo_a.DW.tp)) {
            DW.j6 = apo_a;
            this.FH = DW;
            return;
        }
        apo$a apo_a2 = apo_a.j6;
        while (apo_a2 != null && ((long) apo_a2.DW.tp) > j) {
            apo_a = apo_a2;
            apo_a2 = apo_a2.j6;
        }
        DW.j6 = apo_a.j6;
        apo_a.j6 = DW;
    }

    public aqc j6() {
        apo$a apo_a = this.FH;
        if (apo_a == null) {
            return null;
        }
        this.FH = apo_a.j6;
        j6(apo_a);
        return apo_a.DW;
    }

    public aqc FH() {
        return this.FH != null ? this.FH.DW : null;
    }

    public void Hw() {
        this.FH = null;
        this.Hw = null;
    }

    boolean j6(int i) {
        for (apo$a apo_a = this.FH; apo_a != null; apo_a = apo_a.j6) {
            if ((apo_a.DW.we & i) == 0) {
                return false;
            }
        }
        return true;
    }

    boolean DW(int i) {
        for (apo$a apo_a = this.FH; apo_a != null; apo_a = apo_a.j6) {
            if ((apo_a.DW.we & i) != 0) {
                return true;
            }
        }
        return false;
    }

    int DW() {
        return this.DW | 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (apo$a apo_a = this.FH; apo_a != null; apo_a = apo_a.j6) {
            apj.j6(stringBuilder, apo_a.DW);
        }
        return stringBuilder.toString();
    }

    private apo$a DW(aqc aqc) {
        apo$a apo_a = this.Hw;
        if (apo_a == null) {
            apo_a = new apo$a();
        } else {
            this.Hw = apo_a.j6;
        }
        apo_a.DW = aqc;
        return apo_a;
    }

    private void j6(apo$a apo_a) {
        apo_a.j6 = this.Hw;
        this.Hw = apo_a;
    }
}
