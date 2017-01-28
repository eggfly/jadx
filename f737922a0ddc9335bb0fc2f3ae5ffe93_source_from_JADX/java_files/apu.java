public class apu extends awl {
    private aqa DW;
    private final awi j6;

    public static apu j6(String str) {
        return new apu(awi.j6(str));
    }

    apu(awi awi) {
        this.j6 = awi;
    }

    public String FH() {
        return this.j6.FH();
    }

    public boolean j6(awc awc) {
        return this.j6.j6(awc) && Hw.j6(awc);
    }

    public boolean j6() {
        return this.j6.j6() || Hw.j6();
    }

    public awl DW() {
        return new apu(this.j6.Hw());
    }

    public String toString() {
        return "(FOLLOW(" + this.j6.toString() + ")" + " AND " + Hw.toString() + ")";
    }

    public aqa Hw() {
        return this.DW;
    }

    public void j6(aqa aqa) {
        this.DW = aqa;
    }
}
