class aub$b {
    ans DW;
    byte[] FH;
    aub$b Hw;
    final aub$f j6;
    aub$f v5;

    aub$b() {
        this.j6 = null;
    }

    aub$b(aub$b aub_b) {
        this.Hw = aub_b;
        this.j6 = aub_b.v5;
        aub_b.v5 = this.j6.FH;
    }

    aub$b j6() {
        if (this.Hw != null && this.Hw.v5 == null) {
            this.Hw.FH = null;
            this.Hw = this.Hw.Hw;
        }
        if (this.v5 != null) {
            return new aub$b(this);
        }
        if (this.Hw != null) {
            return new aub$b(this.Hw);
        }
        return null;
    }
}
