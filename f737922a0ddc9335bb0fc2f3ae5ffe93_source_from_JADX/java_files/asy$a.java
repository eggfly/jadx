class asy$a {
    private final long DW;
    private volatile asy$b FH;
    final /* synthetic */ asy j6;

    asy$a(asy asy) {
        this.j6 = asy;
        this.FH = asy$b.COUNTING;
        if (asy.J0.Hw()) {
            int we = asy.J0.we();
            if (we <= 0) {
                we = Runtime.getRuntime().availableProcessors();
            }
            this.DW = (((long) we) * asy.J0.VH()) + ((long) asy.J0.tp());
            return;
        }
        this.DW = 0;
    }
}
