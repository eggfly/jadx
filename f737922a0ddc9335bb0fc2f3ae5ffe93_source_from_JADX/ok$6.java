import android.widget.Toast;
import com.aide.common.y;
import com.aide.ui.e;

class ok$6 implements y<String> {
    final /* synthetic */ ok DW;
    final /* synthetic */ String j6;

    ok$6(ok okVar, String str) {
        this.DW = okVar;
        this.j6 = str;
    }

    public void j6(String str) {
        ((iw) new iw().J0(oh.BT(this.j6))).we(str);
        e.a8().aM();
        Toast.makeText(e.u7(), "Library has been added", 0).show();
    }
}
