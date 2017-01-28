public final class yn implements Comparable<yn> {
    private final int DW;
    private final int FH;
    private final int Hw;
    private final yi j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((yn) obj);
    }

    public yn(yi yiVar, int i, int i2, int i3) {
        this.j6 = yiVar;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
    }

    public int j6() {
        return this.DW;
    }

    public int DW() {
        return this.FH;
    }

    public int FH() {
        return this.Hw;
    }

    public int j6(yn ynVar) {
        if (this.DW != ynVar.DW) {
            return ads.j6(this.DW, ynVar.DW);
        }
        if (this.Hw != ynVar.Hw) {
            return ads.j6(this.Hw, ynVar.Hw);
        }
        return ads.j6(this.FH, ynVar.FH);
    }

    public void j6(yt$a yt_a) {
        yt_a.Hw(this.DW);
        yt_a.Hw(this.FH);
        yt_a.v5(this.Hw);
    }

    public String toString() {
        if (this.j6 == null) {
            return this.DW + " " + this.FH + " " + this.Hw;
        }
        return ((String) this.j6.FH().get(this.DW)) + "." + ((String) this.j6.DW().get(this.Hw)) + this.j6.DW(((yq) this.j6.Hw().get(this.FH)).FH());
    }

    public int hashCode() {
        return ((((this.DW + 31) * 31) + this.Hw) * 31) + this.FH;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        yn ynVar = (yn) obj;
        if (this.DW != ynVar.DW) {
            return false;
        }
        if (this.Hw != ynVar.Hw) {
            return false;
        }
        if (this.FH != ynVar.FH) {
            return false;
        }
        return true;
    }
}
