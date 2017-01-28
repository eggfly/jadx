import com.aide.ui.e;

class po$4 implements Runnable {
    final /* synthetic */ po DW;
    final /* synthetic */ boolean j6;

    po$4(po poVar, boolean z) {
        this.DW = poVar;
        this.j6 = z;
    }

    public void run() {
        this.DW.ei();
        e.Sf().j6(this.DW.DW.u7(), false);
        if (this.j6) {
            this.DW.j6(null, false);
        }
        e.nw().j6(this.DW.we());
        e.u7().u7();
        e.er().FH();
        this.DW.gn();
    }
}
