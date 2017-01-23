import android.widget.Toast;
import com.aide.ui.e;

class ok$5 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ ok FH;
    final /* synthetic */ String j6;

    ok$5(ok okVar, String str, String str2) {
        this.FH = okVar;
        this.j6 = str;
        this.DW = str2;
    }

    public void run() {
        if (oh.Hw(this.j6)) {
            ((iw) new iw().J0(oh.BT(this.j6))).EQ(this.DW);
            e.a8().aM();
            Toast.makeText(e.u7(), "Library has been added", 0).show();
            return;
        }
        this.FH.vJ(this.DW);
    }
}
