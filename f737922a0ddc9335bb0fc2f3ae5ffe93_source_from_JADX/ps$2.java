class ps$2 implements Runnable {
    final /* synthetic */ Exception DW;
    final /* synthetic */ ps FH;
    final /* synthetic */ ps$a j6;

    ps$2(ps psVar, ps$a ps_a, Exception exception) {
        this.FH = psVar;
        this.j6 = ps_a;
        this.DW = exception;
    }

    public void run() {
        this.j6.j6(this.DW.getMessage());
    }
}
