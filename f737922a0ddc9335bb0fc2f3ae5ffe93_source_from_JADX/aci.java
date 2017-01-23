public abstract class aci implements adq, Cloneable {
    private zw DW;
    private final acg j6;

    public abstract zx DW();

    public abstract boolean EQ();

    public abstract zo FH();

    public abstract boolean J0();

    public abstract zo Zo();

    public abstract void j6(acd acd);

    public abstract void j6(aci$a aci_a);

    public abstract zz v5();

    public abstract boolean we();

    public /* synthetic */ Object clone() {
        return J8();
    }

    protected aci(zw zwVar, acg acg) {
        if (acg == null) {
            throw new NullPointerException("block == null");
        }
        this.j6 = acg;
        this.DW = zwVar;
    }

    public static aci j6(zo zoVar, acg acg) {
        return new abz(zoVar, acg);
    }

    public aci J8() {
        try {
            return (aci) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException("unexpected", e);
        }
    }

    public zw Ws() {
        return this.DW;
    }

    protected void DW(zw zwVar) {
        if (zwVar == null) {
            throw new NullPointerException("result == null");
        }
        this.DW = zwVar;
    }

    public acg QX() {
        return this.j6;
    }

    public boolean DW(int i) {
        return this.DW != null && this.DW.VH() == i;
    }

    public void FH(int i) {
        if (this.DW != null) {
            this.DW = this.DW.DW(i);
        }
    }

    public final void j6(zq zqVar) {
        if (zqVar == this.DW.u7()) {
            return;
        }
        if (zqVar == null || !zqVar.equals(this.DW.u7())) {
            this.DW = zw.DW(this.DW.VH(), this.DW.j6(), zqVar);
        }
    }

    public final void DW(acd acd) {
        zw zwVar = this.DW;
        this.DW = acd.j6(this.DW);
        this.j6.Ws().j6(this, zwVar);
        j6(acd);
    }

    public zw VH() {
        if (this.DW == null || this.DW.u7() == null) {
            return null;
        }
        return this.DW;
    }

    public boolean u7() {
        return false;
    }

    public boolean tp() {
        return false;
    }
}
