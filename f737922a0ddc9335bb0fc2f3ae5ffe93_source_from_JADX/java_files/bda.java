public class bda extends ayp implements bce, bdg {
    ayw E4;
    azu PH;
    bcp hp;
    bcx xg;

    public bda(ayw ayw) {
        this.E4 = ayw;
        if (ayw.v5() == 3) {
            this.xg = bcx.j6(ayw.j6(0));
            this.hp = bcp.j6(ayw.j6(1));
            this.PH = azu.j6(ayw.j6(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public bcx FH() {
        return this.xg;
    }

    public int Hw() {
        return this.xg.FH();
    }

    public ayn v5() {
        return this.xg.Hw();
    }

    public bcl Zo() {
        return this.xg.Zo();
    }

    public bcy VH() {
        return this.xg.VH();
    }

    public bcy gn() {
        return this.xg.gn();
    }

    public bcl u7() {
        return this.xg.u7();
    }

    public bcv tp() {
        return this.xg.tp();
    }

    public bcp EQ() {
        return this.hp;
    }

    public azu we() {
        return this.PH;
    }

    public ayv w_() {
        return this.E4;
    }
}
