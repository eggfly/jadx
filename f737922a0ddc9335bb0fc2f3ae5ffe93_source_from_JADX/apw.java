public class apw extends apm {
    private apm$a Hw;

    apw(apv apv) {
        super(apv);
    }

    public void j6(aqc aqc) {
        apm$a apm_a = this.Hw;
        if (apm_a == null || !apm_a.FH()) {
            apm_a = this.FH.j6();
            apm_a.VH();
            apm_a.j6 = this.Hw;
            this.Hw = apm_a;
        }
        apm_a.DW(aqc);
    }

    public aqc j6() {
        apm$a apm_a = this.Hw;
        if (apm_a == null) {
            return null;
        }
        aqc Hw = apm_a.Hw();
        if (!apm_a.DW()) {
            return Hw;
        }
        this.Hw = apm_a.j6;
        this.FH.j6(apm_a);
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
