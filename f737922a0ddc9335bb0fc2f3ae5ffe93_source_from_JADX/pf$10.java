import android.widget.Toast;
import com.aide.ui.e;

class pf$10 implements Runnable {
    final /* synthetic */ pf DW;
    final /* synthetic */ String j6;

    pf$10(pf pfVar, String str) {
        this.DW = pfVar;
        this.j6 = str;
    }

    public void run() {
        Toast.makeText(e.tp(), this.j6, 1).show();
    }
}
