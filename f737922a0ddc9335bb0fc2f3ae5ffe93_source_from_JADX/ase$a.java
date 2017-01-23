class ase$a {
    final ase$c DW;
    volatile boolean FH;
    final ase$a j6;

    ase$a(ase$a ase_a, ase$c ase_c) {
        this.j6 = ase_a;
        this.DW = ase_c;
    }

    final void j6() {
        this.FH = true;
        this.DW.enqueue();
    }
}
