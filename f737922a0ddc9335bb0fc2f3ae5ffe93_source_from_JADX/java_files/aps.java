public class aps extends apm {
    private apm$a Hw;
    private apm$a v5;

    aps(apv apv) {
        super(apv);
    }

    public void j6(aqc aqc) {
        apm$a apm_a = this.v5;
        if (apm_a == null) {
            apm_a = this.FH.j6();
            apm_a.j6(aqc);
            this.Hw = apm_a;
            this.v5 = apm_a;
            return;
        }
        if (apm_a.j6()) {
            apm_a = this.FH.j6();
            this.v5.j6 = apm_a;
            this.v5 = apm_a;
        }
        apm_a.j6(aqc);
    }

    public void DW(aqc aqc) {
        apm$a apm_a = this.Hw;
        if (apm_a == null) {
            apm_a = this.FH.j6();
            apm_a.Zo();
            apm_a.j6(aqc);
            this.Hw = apm_a;
            this.v5 = apm_a;
        } else if (apm_a.FH()) {
            apm_a.DW(aqc);
        } else {
            apm_a = this.FH.j6();
            apm_a.VH();
            apm_a.DW(aqc);
            apm_a.j6 = this.Hw;
            this.Hw = apm_a;
        }
    }

    public aqc j6() {
        apm$a apm_a = this.Hw;
        if (apm_a == null) {
            return null;
        }
        aqc Hw = apm_a.Hw();
        if (apm_a.DW()) {
            this.Hw = apm_a.j6;
            if (this.Hw == null) {
                this.v5 = null;
            }
            this.FH.j6(apm_a);
        }
        return Hw;
    }

    boolean j6(int i) {
        for (apm$a apm_a = this.Hw; apm_a != null; apm_a = apm_a.j6) {
            for (int i2 = apm_a.FH; i2 < apm_a.Hw; i2++) {
                if ((apm_a.DW[i2].we & i) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean DW(int i) {
        for (apm$a apm_a = this.Hw; apm_a != null; apm_a = apm_a.j6) {
            for (int i2 = apm_a.FH; i2 < apm_a.Hw; i2++) {
                if ((apm_a.DW[i2].we & i) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    void FH(int i) {
        int i2 = i ^ -1;
        for (apm$a apm_a = this.Hw; apm_a != null; apm_a = apm_a.j6) {
            for (int i3 = apm_a.FH; i3 < apm_a.Hw; i3++) {
                aqc aqc = apm_a.DW[i3];
                aqc.we &= i2;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (apm$a apm_a = this.Hw; apm_a != null; apm_a = apm_a.j6) {
            for (int i = apm_a.FH; i < apm_a.Hw; i++) {
                apj.j6(stringBuilder, apm_a.DW[i]);
            }
        }
        return stringBuilder.toString();
    }
}
