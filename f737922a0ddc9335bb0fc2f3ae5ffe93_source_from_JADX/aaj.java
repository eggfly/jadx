public final class aaj extends aah {
    private final zc j6;

    public aaj(zc zcVar) {
        if (zcVar == null) {
            throw new NullPointerException("annotation == null");
        }
        zcVar.J0();
        this.j6 = zcVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof aaj) {
            return this.j6.equals(((aaj) obj).j6);
        }
        return false;
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    protected int DW(aah aah) {
        return this.j6.j6(((aaj) aah).j6);
    }

    public String toString() {
        return this.j6.toString();
    }

    public String gn() {
        return "annotation";
    }

    public boolean VH() {
        return false;
    }

    public String Hw() {
        return this.j6.toString();
    }

    public zc j6() {
        return this.j6;
    }
}
