public class adl implements adh {
    final adg j6;

    public adl() {
        this.j6 = new adg();
        this.j6.VH();
    }

    public void j6(int i) {
        int VH = this.j6.VH(i);
        if (VH < 0) {
            this.j6.FH(-(VH + 1), i);
        }
    }

    public boolean DW(int i) {
        return this.j6.Zo(i) >= 0;
    }

    public void j6(adh adh) {
        int i = 0;
        if (adh instanceof adl) {
            adl adl = (adl) adh;
            int DW = this.j6.DW();
            int DW2 = adl.j6.DW();
            int i2 = 0;
            while (i < DW2 && r1 < DW) {
                while (i < DW2 && adl.j6.DW(i) < this.j6.DW(r1)) {
                    int i3 = i + 1;
                    j6(adl.j6.DW(i));
                    i = i3;
                }
                if (i == DW2) {
                    break;
                }
                while (i2 < DW && adl.j6.DW(i) >= this.j6.DW(i2)) {
                    i2++;
                }
            }
            while (i < DW2) {
                i2 = i + 1;
                j6(adl.j6.DW(i));
                i = i2;
            }
            this.j6.VH();
        } else if (adh instanceof acs) {
            acs acs = (acs) adh;
            while (i >= 0) {
                this.j6.FH(i);
                i = act.Hw(acs.j6, i + 1);
            }
            this.j6.VH();
        } else {
            adf DW3 = adh.DW();
            while (DW3.j6()) {
                j6(DW3.DW());
            }
        }
    }

    public int j6() {
        return this.j6.DW();
    }

    public adf DW() {
        return new adl$1(this);
    }

    public String toString() {
        return this.j6.toString();
    }
}
