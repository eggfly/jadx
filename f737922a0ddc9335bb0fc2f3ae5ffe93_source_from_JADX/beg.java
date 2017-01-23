public class beg {
    private boolean DW;
    private bdq FH;
    private bdq Hw;
    private bgv j6;
    private bdv v5;

    public beg(bgv bgv) {
        this(bgv, new bec());
    }

    public beg(bgv bgv, bdv bdv) {
        this.j6 = bgv;
        this.v5 = bdv;
    }

    public beg j6(boolean z) {
        this.DW = z;
        return this;
    }

    public beg j6(bdq bdq) {
        this.FH = bdq;
        return this;
    }

    public beg DW(bdq bdq) {
        this.Hw = bdq;
        return this;
    }

    public bef j6(bgq bgq, bdl bdl) {
        bef j6 = j6(bgq, new bbp(new bbn(bdl.j6())));
        j6.j6(bdl);
        return j6;
    }

    public bef j6(bgq bgq, byte[] bArr) {
        return j6(bgq, new bbp(new bah(bArr)));
    }

    private bef j6(bgq bgq, bbp bbp) {
        if (this.DW) {
            return new bef(bbp, bgq, this.j6, this.v5, true);
        } else if (this.FH == null && this.Hw == null) {
            return new bef(bbp, bgq, this.j6, this.v5);
        } else {
            if (this.FH == null) {
                this.FH = new bed();
            }
            return new bef(bbp, bgq, this.j6, this.v5, this.FH, this.Hw);
        }
    }
}
