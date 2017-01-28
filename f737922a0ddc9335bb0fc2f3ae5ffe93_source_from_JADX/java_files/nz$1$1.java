import com.aide.common.m;
import com.aide.ui.e;

class nz$1$1 implements Runnable {
    final /* synthetic */ nz$1 DW;
    final /* synthetic */ String j6;

    nz$1$1(nz$1 nz_1, String str) {
        this.DW = nz_1;
        this.j6 = str;
    }

    public void run() {
        m.j6(e.u7(), new np(this.j6));
    }
}
