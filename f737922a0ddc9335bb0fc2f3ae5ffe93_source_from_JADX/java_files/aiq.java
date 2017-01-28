public class aiq extends aie<aip> {
    private awd DW;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected aiq(aoh aoh) {
        super(aoh);
    }

    public aip j6() {
        if (this.DW == null) {
            this.DW = new awa(this.j6);
        }
        anm anm = new anm(this.j6, "HEAD", this.DW);
        anm.j6();
        return new aip(anm);
    }
}
