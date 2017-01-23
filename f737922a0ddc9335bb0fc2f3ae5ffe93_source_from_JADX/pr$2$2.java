import android.widget.Toast;
import com.aide.common.b;
import com.aide.ui.activities.a;
import com.aide.ui.e;

class pr$2$2 implements Runnable {
    final /* synthetic */ pr$2 DW;
    final /* synthetic */ String j6;

    pr$2$2(pr$2 pr_2, String str) {
        this.DW = pr_2;
        this.j6 = str;
    }

    public void run() {
        e.u7().J0();
        if (this.DW.j6.FH) {
            if (this.j6.toLowerCase().endsWith(".js")) {
                e.u7().sh().QX();
                b.j6(e.u7(), null, a.PHONEGAP_API.toString());
                return;
            }
            e.u7().sh().QX();
            b.j6(e.u7(), null, a.EQ().toString());
        } else if (this.DW.j6.Zo != null) {
            this.DW.j6.j6(this.DW.j6.Zo);
        } else {
            Toast.makeText(e.u7(), "The selected code can not be identified", 0).show();
        }
    }
}
