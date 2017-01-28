public class bcz {
    ayn DW;
    private azu EQ;
    bcp FH;
    bcl Hw;
    bcl VH;
    bcy Zo;
    bcv gn;
    baq j6;
    private boolean tp;
    bct u7;
    bcy v5;
    private azu we;

    public bcz() {
        this.j6 = new baq(true, 0, new ayn(2));
    }

    public void j6(ayn ayn) {
        this.DW = ayn;
    }

    public void j6(bcp bcp) {
        this.FH = bcp;
    }

    public void j6(bde bde) {
        this.Hw = bcl.j6(bde);
    }

    public void j6(bcy bcy) {
        this.v5 = bcy;
    }

    public void DW(bcy bcy) {
        this.Zo = bcy;
    }

    public void DW(bde bde) {
        this.VH = bcl.j6(bde.w_());
    }

    public void j6(bcv bcv) {
        this.gn = bcv;
    }

    public void j6(bdc bdc) {
        j6(bct.j6((Object) bdc));
    }

    public void j6(bct bct) {
        this.u7 = bct;
        if (bct != null) {
            bcs j6 = bct.j6(bcs.v5);
            if (j6 != null && j6.j6()) {
                this.tp = true;
            }
        }
    }

    public bcw j6() {
        if (this.DW == null || this.FH == null || this.Hw == null || this.v5 == null || this.Zo == null || ((this.VH == null && !this.tp) || this.gn == null)) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        ayi.j6(this.FH);
        ayi.j6(this.Hw);
        ayi ayi2 = new ayi();
        ayi2.j6(this.v5);
        ayi2.j6(this.Zo);
        ayi.j6(new bal(ayi2));
        if (this.VH != null) {
            ayi.j6(this.VH);
        } else {
            ayi.j6(new bal());
        }
        ayi.j6(this.gn);
        if (this.EQ != null) {
            ayi.j6(new baq(false, 1, this.EQ));
        }
        if (this.we != null) {
            ayi.j6(new baq(false, 2, this.we));
        }
        if (this.u7 != null) {
            ayi.j6(new baq(true, 3, this.u7));
        }
        return bcw.j6(new bal(ayi));
    }
}
