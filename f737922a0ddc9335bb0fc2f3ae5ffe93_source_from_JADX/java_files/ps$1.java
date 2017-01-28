import com.aide.ui.e;

class ps$1 implements Runnable {
    final /* synthetic */ ps$a DW;
    final /* synthetic */ boolean FH;
    final /* synthetic */ String Hw;
    final /* synthetic */ boolean j6;
    final /* synthetic */ ps v5;

    ps$1(ps psVar, boolean z, ps$a ps_a, boolean z2, String str) {
        this.v5 = psVar;
        this.j6 = z;
        this.DW = ps_a;
        this.FH = z2;
        this.Hw = str;
    }

    public void run() {
        if (this.j6) {
            this.DW.j6(this.FH);
            e.Mr().j6(Long.MAX_VALUE);
            this.v5.j6(this.Hw);
            return;
        }
        this.DW.DW(this.FH);
    }
}
