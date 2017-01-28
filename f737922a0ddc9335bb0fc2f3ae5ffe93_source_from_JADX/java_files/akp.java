public class akp extends aku {
    private final akq J0;

    public akp(akq akq) {
        super(akq.j6());
        this.J0 = akq;
    }

    akp(akp akp, akv akv) {
        super(akp, akv);
        this.J0 = akp.J0;
    }

    public avx j6(any any) {
        if (this.Hw != null) {
            return new akp(this, this.Hw);
        }
        throw new alb(EQ(), "tree");
    }

    public void j6() {
        if (this.Hw != null) {
            this.J0.DW(this.DW, this.Hw.DW());
        } else {
            this.J0.DW(this.DW, 1);
        }
        j6(1);
    }

    public void DW() {
        int i = this.DW;
        int tp = this.j6.tp();
        if (i < tp) {
            this.J0.DW(i, tp - i);
        }
    }
}
