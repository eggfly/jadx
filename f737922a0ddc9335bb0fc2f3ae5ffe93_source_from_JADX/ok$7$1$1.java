import android.widget.Toast;
import com.aide.ui.e;
import java.util.List;

class ok$7$1$1 implements Runnable {
    final /* synthetic */ ok$7$1 DW;
    final /* synthetic */ List j6;

    ok$7$1$1(ok$7$1 ok_7_1, List list) {
        this.DW = ok_7_1;
        this.j6 = list;
    }

    public void run() {
        e.j3().j6(this.j6);
        ((iw) new iw().J0(oh.BT(this.DW.FH.j6))).tp(this.DW.DW);
        e.a8().Zo();
        Toast.makeText(e.u7(), "Build flavor has been added", 0).show();
    }
}
