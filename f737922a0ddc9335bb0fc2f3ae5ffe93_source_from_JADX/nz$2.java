import com.aide.common.m;
import com.aide.ui.e;
import com.dropbox.client2.android.a;

class nz$2 implements Runnable {
    final /* synthetic */ nz j6;

    nz$2(nz nzVar) {
        this.j6 = nzVar;
    }

    public void run() {
        if (this.j6.gn) {
            this.j6.FH = true;
            ((a) this.j6.DW.j6()).j6(e.u7());
            return;
        }
        m.DW(e.u7(), "Dropbox", "Do you want to connect to your Dropbox?", new nz$2$1(this), null);
    }
}
