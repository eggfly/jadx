public final class aak extends aah {
    private final aak$a j6;

    public aak(aak$a aak_a) {
        if (aak_a == null) {
            throw new NullPointerException("list == null");
        }
        aak_a.J0();
        this.j6 = aak_a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof aak) {
            return this.j6.equals(((aak) obj).j6);
        }
        return false;
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    protected int DW(aah aah) {
        return this.j6.j6(((aak) aah).j6);
    }

    public String toString() {
        return this.j6.j6("array{", ", ", "}");
    }

    public String gn() {
        return "array";
    }

    public boolean VH() {
        return false;
    }

    public String Hw() {
        return this.j6.DW("{", ", ", "}");
    }

    public aak$a j6() {
        return this.j6;
    }
}
