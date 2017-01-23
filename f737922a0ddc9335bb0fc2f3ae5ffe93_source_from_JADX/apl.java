class apl {
    private apl$a DW;
    private apl$a FH;
    private apl$b j6;

    apl() {
        this.j6 = new apl$b();
    }

    void j6(aqg aqg) {
        apl$a apl_a = this.FH;
        if (apl_a == null) {
            apl_a = this.j6.j6();
            apl_a.j6(aqg);
            this.DW = apl_a;
            this.FH = apl_a;
            return;
        }
        if (apl_a.j6()) {
            apl_a = this.j6.j6();
            this.FH.j6 = apl_a;
            this.FH = apl_a;
        }
        apl_a.j6(aqg);
    }

    aqg j6() {
        apl$a apl_a = this.DW;
        if (apl_a == null) {
            return null;
        }
        aqg FH = apl_a.FH();
        if (apl_a.DW()) {
            this.DW = apl_a.j6;
            if (this.DW == null) {
                this.FH = null;
            }
            this.j6.j6(apl_a);
        }
        return FH;
    }
}
