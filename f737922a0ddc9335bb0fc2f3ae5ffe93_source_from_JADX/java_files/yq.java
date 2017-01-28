public final class yq implements Comparable<yq> {
    private final int DW;
    private final int FH;
    private final int Hw;
    private final yi j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((yq) obj);
    }

    public yq(yi yiVar, int i, int i2, int i3) {
        this.j6 = yiVar;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
    }

    public int j6(yq yqVar) {
        if (this.FH != yqVar.FH) {
            return ads.j6(this.FH, yqVar.FH);
        }
        return ads.j6(this.Hw, yqVar.Hw);
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

    public void j6(yt$a yt_a) {
        yt_a.v5(this.DW);
        yt_a.v5(this.FH);
        yt_a.v5(this.Hw);
    }

    public String toString() {
        if (this.j6 == null) {
            return this.DW + " " + this.FH + " " + this.Hw;
        }
        return ((String) this.j6.DW().get(this.DW)) + ": " + ((String) this.j6.FH().get(this.FH)) + " " + this.j6.DW(this.Hw);
    }

    public int hashCode() {
        return ((((this.Hw + 31) * 31) + this.FH) * 31) + this.DW;
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
        yq yqVar = (yq) obj;
        if (this.Hw != yqVar.Hw) {
            return false;
        }
        if (this.FH != yqVar.FH) {
            return false;
        }
        if (this.DW != yqVar.DW) {
            return false;
        }
        return true;
    }
}
