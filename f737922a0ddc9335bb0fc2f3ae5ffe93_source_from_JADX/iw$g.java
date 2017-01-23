public class iw$g extends iw$b {
    public String DW;
    public String Hw;
    public String Zo;
    public String j6;
    public String v5;

    public iw$g(int i) {
        super(i);
        this.j6 = "";
        this.DW = "";
        this.Hw = "+";
        this.v5 = "";
    }

    public iw$g(iw$g iw_g, String str) {
        super(iw_g.FH);
        this.j6 = "";
        this.DW = "";
        this.Hw = "+";
        this.v5 = "";
        this.Hw = str;
        this.j6 = iw_g.j6;
        this.DW = iw_g.DW;
        this.v5 = iw_g.v5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof iw$g)) {
            return false;
        }
        iw$g iw_g = (iw$g) obj;
        if (iw_g.j6.equals(this.j6) && iw_g.DW.equals(this.DW) && iw_g.Hw.equals(this.Hw) && iw_g.v5.equals(this.v5)) {
            return true;
        }
        return false;
    }

    public String j6() {
        return this.j6 + ":" + this.DW;
    }

    public int hashCode() {
        return this.j6.hashCode() + this.DW.hashCode();
    }

    public String toString() {
        return this.j6 + ":" + this.DW + ":" + this.Hw;
    }
}
