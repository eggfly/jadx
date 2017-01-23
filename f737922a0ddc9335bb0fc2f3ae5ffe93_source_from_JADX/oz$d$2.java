import com.aide.common.m;

class oz$d$2 implements Runnable {
    final /* synthetic */ oz$d DW;
    final /* synthetic */ InterruptedException j6;

    oz$d$2(oz$d oz_d, InterruptedException interruptedException) {
        this.DW = oz_d;
        this.j6 = interruptedException;
    }

    public void run() {
        if (this.DW.j6.Hw == this.DW) {
            this.DW.j6.u7();
            this.DW.j6.Hw = null;
            m.j6(this.DW.DW, "Download error", this.j6);
        }
    }
}
