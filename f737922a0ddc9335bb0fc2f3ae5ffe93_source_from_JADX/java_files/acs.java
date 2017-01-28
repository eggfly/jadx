public class acs implements adh {
    int[] j6;

    public acs(int i) {
        this.j6 = act.j6(i);
    }

    public void j6(int i) {
        FH(i);
        act.j6(this.j6, i, true);
    }

    private void FH(int i) {
        if (i >= act.j6(this.j6)) {
            Object j6 = act.j6(Math.max(i + 1, act.j6(this.j6) * 2));
            System.arraycopy(this.j6, 0, j6, 0, this.j6.length);
            this.j6 = j6;
        }
    }

    public boolean DW(int i) {
        return i < act.j6(this.j6) && act.j6(this.j6, i);
    }

    public void j6(adh adh) {
        if (adh instanceof acs) {
            acs acs = (acs) adh;
            FH(act.j6(acs.j6) + 1);
            act.j6(this.j6, acs.j6);
        } else if (adh instanceof adl) {
            adl adl = (adl) adh;
            int DW = adl.j6.DW();
            if (DW > 0) {
                FH(adl.j6.DW(DW - 1));
            }
            for (DW = 0; DW < adl.j6.DW(); DW++) {
                act.j6(this.j6, adl.j6.DW(DW), true);
            }
        } else {
            adf DW2 = adh.DW();
            while (DW2.j6()) {
                j6(DW2.DW());
            }
        }
    }

    public int j6() {
        return act.FH(this.j6);
    }

    public adf DW() {
        return new acs$1(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        int i = 1;
        int Hw = act.Hw(this.j6, 0);
        while (Hw >= 0) {
            if (i == 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(Hw);
            Hw = act.Hw(this.j6, Hw + 1);
            i = 0;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
