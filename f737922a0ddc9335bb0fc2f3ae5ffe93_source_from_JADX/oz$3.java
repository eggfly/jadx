class oz$3 implements Runnable {
    final /* synthetic */ int DW;
    final /* synthetic */ int FH;
    final /* synthetic */ oz Hw;
    final /* synthetic */ String j6;

    oz$3(oz ozVar, String str, int i, int i2) {
        this.Hw = ozVar;
        this.j6 = str;
        this.DW = i;
        this.FH = i2;
    }

    public void run() {
        this.Hw.gn = this.j6;
        this.Hw.v5 = this.DW;
        this.Hw.Zo = this.FH;
        this.Hw.gn();
    }
}
