import android.widget.Toast;
import com.aide.ui.e;
import com.aide.ui.h;
import java.util.List;

class pq$1$6 implements Runnable {
    final /* synthetic */ List DW;
    final /* synthetic */ pq$1 FH;
    final /* synthetic */ String j6;

    pq$1$6(pq$1 pq_1, String str, List list) {
        this.FH = pq_1;
        this.j6 = str;
        this.DW = list;
    }

    public void run() {
        h.j6(this.j6, this.DW);
        e.u7().FH(2);
        Toast.makeText(e.gn(), "Code Style settings have been updated", 0).show();
    }
}
