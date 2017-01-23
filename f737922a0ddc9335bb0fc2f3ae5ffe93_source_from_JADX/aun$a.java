class aun$a {
    static final ani$b<aun$a> j6;
    final boolean DW;
    final boolean FH;
    final boolean Hw;
    final boolean Zo;
    final boolean v5;

    static {
        j6 = new aun$a$1();
    }

    aun$a(ani ani) {
        boolean z = false;
        this.DW = ani.j6("receive", "fsckobjects", false);
        this.FH = true;
        this.Hw = !ani.j6("receive", "denydeletes", false);
        if (!ani.j6("receive", "denynonfastforwards", false)) {
            z = true;
        }
        this.v5 = z;
        this.Zo = ani.j6("repack", "usedeltabaseoffset", true);
    }
}
