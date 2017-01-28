import com.aide.common.m;
import com.aide.ui.e;

class pd$4$3 implements Runnable {
    final /* synthetic */ pd$4 DW;
    final /* synthetic */ String j6;

    pd$4$3(pd$4 pd_4, String str) {
        this.DW = pd_4;
        this.j6 = str;
    }

    public void run() {
        m.j6(e.u7(), "Run Error", "Could not run the App directly as root. Consider disabling direct running in the settings.\n\n" + this.j6);
    }
}
