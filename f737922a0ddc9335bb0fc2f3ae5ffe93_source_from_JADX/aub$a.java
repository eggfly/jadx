class aub$a extends ant$a {
    aub$f VH;

    aub$a(anb anb) {
        super(anb);
    }

    aub$f VH() {
        aub$f aub_f = this.VH;
        if (aub_f != null) {
            this.VH = null;
        }
        return aub_f;
    }

    void j6(aub$f aub_f) {
        aub_f.FH = this.VH;
        this.VH = aub_f;
    }
}
