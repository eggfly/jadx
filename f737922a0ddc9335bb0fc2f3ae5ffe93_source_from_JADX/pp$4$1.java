import android.widget.Toast;
import com.aide.ui.e;
import java.io.IOException;
import java.util.List;

class pp$4$1 implements Runnable {
    final /* synthetic */ List DW;
    final /* synthetic */ pp$4 FH;
    final /* synthetic */ String j6;

    pp$4$1(pp$4 pp_4, String str, List list) {
        this.FH = pp_4;
        this.j6 = str;
        this.DW = list;
    }

    public void run() {
        String str = this.j6;
        if (this.FH.j6.VH().length() > 0) {
            str = str + "/" + this.FH.j6.VH();
        }
        e.a8().XL(str);
        e.er().j6(str);
        if (this.FH.DW) {
            e.u7().v5(false);
        } else {
            e.u7().rN();
        }
        if (this.FH.DW) {
            e.XL().Zo();
        }
        if (this.DW != null) {
            for (int i = 0; i < this.DW.size(); i++) {
                try {
                    boolean z;
                    pl j3 = e.j3();
                    str = (String) this.DW.get(i);
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    j3.j6(str, z);
                } catch (IOException e) {
                    Toast.makeText(e.gn(), ((String) this.DW.get(i)) + " could not be loaded!", 1).show();
                }
            }
        }
        this.FH.FH.run();
    }
}
