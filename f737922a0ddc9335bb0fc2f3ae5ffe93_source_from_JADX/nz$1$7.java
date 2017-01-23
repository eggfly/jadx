import com.aide.common.m;
import com.aide.ui.e;

class nz$1$7 implements Runnable {
    final /* synthetic */ nz$1 DW;
    final /* synthetic */ Exception j6;

    nz$1$7(nz$1 nz_1, Exception exception) {
        this.DW = nz_1;
        this.j6 = exception;
    }

    public void run() {
        e.u7().g3();
        if (this.DW.j6.gn) {
            m.j6(e.u7(), "Dropbox", "Error: " + (this.j6.getMessage() == null ? this.j6 : this.j6.getMessage()), "Disconnect", new nz$1$7$1(this));
        }
    }
}
