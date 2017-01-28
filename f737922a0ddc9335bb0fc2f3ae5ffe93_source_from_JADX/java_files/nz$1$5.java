import com.aide.analytics.a;
import com.aide.ui.e;

class nz$1$5 implements Runnable {
    final /* synthetic */ nz$1 j6;

    nz$1$5(nz$1 nz_1) {
        this.j6 = nz_1;
    }

    public void run() {
        a.DW("Dropbox sync completed");
        e.u7().g3();
    }
}
