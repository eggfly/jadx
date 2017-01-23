public final class abc extends aah {
    public static final abc j6;
    private final abe DW;
    private final abe FH;

    static {
        j6 = new abc(new abe("TYPE"), new abe("Ljava/lang/Class;"));
    }

    public abc(abe abe, abe abe2) {
        if (abe == null) {
            throw new NullPointerException("name == null");
        } else if (abe2 == null) {
            throw new NullPointerException("descriptor == null");
        } else {
            this.DW = abe;
            this.FH = abe2;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof abc)) {
            return false;
        }
        abc abc = (abc) obj;
        if (this.DW.equals(abc.DW) && this.FH.equals(abc.FH)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.DW.hashCode() * 31) ^ this.FH.hashCode();
    }

    protected int DW(aah aah) {
        abc abc = (abc) aah;
        int j6 = this.DW.j6(abc.DW);
        return j6 != 0 ? j6 : this.FH.j6(abc.FH);
    }

    public String toString() {
        return "nat{" + Hw() + '}';
    }

    public String gn() {
        return "nat";
    }

    public boolean VH() {
        return false;
    }

    public abe j6() {
        return this.DW;
    }

    public abe DW() {
        return this.FH;
    }

    public String Hw() {
        return this.DW.Hw() + ':' + this.FH.Hw();
    }

    public abl FH() {
        return abl.j6(this.FH.tp());
    }

    public final boolean v5() {
        return this.DW.tp().equals("<init>");
    }

    public final boolean Zo() {
        return this.DW.tp().equals("<clinit>");
    }
}
