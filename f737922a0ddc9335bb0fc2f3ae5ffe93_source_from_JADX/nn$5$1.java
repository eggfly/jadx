import com.aide.ui.e;
import com.aide.ui.h;
import java.util.Arrays;
import java.util.List;

class nn$5$1 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ nn$5 FH;
    final /* synthetic */ List j6;

    nn$5$1(nn$5 nn_5, List list, String str) {
        this.FH = nn_5;
        this.j6 = list;
        this.DW = str;
    }

    public void run() {
        if (this.FH.Hw.Zo.VH) {
            e.j3().j6(this.j6);
            if (this.DW != null) {
                e.er().j6(this.DW);
            }
            if (this.FH.v5.FH != null) {
                this.FH.v5.FH.j6(this.DW);
                return;
            }
            return;
        }
        String str;
        if (this.FH.Hw.Hw == null) {
            str = this.DW;
        } else {
            str = this.DW + "/" + this.FH.Hw.Hw;
        }
        if (str != null) {
            e.er().j6(str);
        }
        e.u7().v5(false);
        e.a8().XL(str);
        e.a8().QX("created");
        e.j3().j6(this.j6);
        if (!e.ei().FH(this.DW) && h.FH()) {
            e.ei().j6(this.DW, "Initial commit", Arrays.asList(new String[]{"bin/", "gen/", "obj/", "libs/*/*.so", ""}), new nn$5$1$1(this));
        } else if (this.FH.v5.FH != null) {
            this.FH.v5.FH.j6(this.DW);
        }
    }
}
