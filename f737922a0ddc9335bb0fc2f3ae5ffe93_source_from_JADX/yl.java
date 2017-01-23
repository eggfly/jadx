public final class yl implements Comparable<yl> {
    private final int DW;
    private final int FH;
    private final int Hw;
    private final yi j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((yl) obj);
    }

    public yl(yi yiVar, int i, int i2, int i3) {
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

    public int j6(yl ylVar) {
        if (this.DW != ylVar.DW) {
            return ads.j6(this.DW, ylVar.DW);
        }
        if (this.Hw != ylVar.Hw) {
            return ads.j6(this.Hw, ylVar.Hw);
        }
        return ads.j6(this.FH, ylVar.FH);
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
        return ((String) this.j6.FH().get(this.FH)) + "." + ((String) this.j6.DW().get(this.Hw));
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
        yl ylVar = (yl) obj;
        if (this.DW != ylVar.DW) {
            return false;
        }
        if (this.Hw != ylVar.Hw) {
            return false;
        }
        if (this.FH != ylVar.FH) {
            return false;
        }
        return true;
    }
}
