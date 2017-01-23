public abstract class apc extends aow {
    private aqk VH;

    protected apc(aoh aoh) {
        super(aoh);
    }

    public void DW(anb anb) {
        if (anb != null) {
            this.VH = this.FH.VH(anb);
        } else {
            this.VH = null;
        }
    }

    public boolean j6(anb... anbArr) {
        if (anbArr.length != 2) {
            return false;
        }
        return super.j6(anbArr);
    }

    protected avx u7() {
        if (this.VH != null) {
            return j6(this.VH);
        }
        return j6(0, 1);
    }
}
