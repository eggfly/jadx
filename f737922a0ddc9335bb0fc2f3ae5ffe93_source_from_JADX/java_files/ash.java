class ash {
    static final ani$b<ash> j6;
    private final int DW;
    private final boolean FH;
    private final boolean Hw;

    static {
        j6 = new ash$1();
    }

    private ash(ani ani) {
        this.DW = ((ank) ani.j6(ank.j6)).j6();
        this.FH = ani.j6("core", "fsyncobjectfiles", false);
        this.Hw = ani.j6("core", "fsyncreffiles", false);
    }

    int j6() {
        return this.DW;
    }

    boolean DW() {
        return this.FH;
    }

    boolean FH() {
        return this.Hw;
    }
}
