class oz$b$1 implements Runnable {
    final /* synthetic */ oz$b DW;
    final /* synthetic */ boolean j6;

    oz$b$1(oz$b oz_b, boolean z) {
        this.DW = oz_b;
        this.j6 = z;
    }

    public void run() {
        this.DW.j6.u7();
        if (this.j6) {
            this.DW.FH.run();
        }
    }
}
