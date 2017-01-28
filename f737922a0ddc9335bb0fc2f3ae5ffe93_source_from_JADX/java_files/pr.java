import com.aide.engine.FindResult;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

public class pr {
    private boolean DW;
    private pr$a EQ;
    private boolean FH;
    private boolean Hw;
    private int VH;
    private String Zo;
    private int gn;
    private List<FindResult> j6;
    private int tp;
    private int u7;
    private boolean v5;

    public pr() {
        this.j6 = new ArrayList();
    }

    public void j6() {
        e.XL().j6(new pr$1(this));
        e.XL().j6(new pr$2(this));
    }

    public void j6(String str) {
        Hw();
        e.XL().DW(str);
    }

    private void Hw() {
        this.DW = true;
        v5();
        e.u7().er();
    }

    public void j6(pr$a pr_a) {
        this.EQ = pr_a;
    }

    public boolean DW() {
        return this.DW;
    }

    public List<FindResult> FH() {
        return this.j6;
    }

    private void v5() {
        e.j6(new pr$3(this));
    }

    public void j6(String str, int i, int i2, int i3, int i4) {
        j6(str, i, i2, i3, i4, null, true, false, false);
    }

    public void DW(String str, int i, int i2, int i3, int i4) {
        j6(str, i, i2, i3, i4, null, true, false, true);
    }

    public void j6(String str, int i, int i2, int i3, int i4, String str2) {
        j6(str, i, i2, i3, i4, str2, false, false, true);
    }

    public void FH(String str, int i, int i2, int i3, int i4) {
        j6(str, i, i2, i3, i4, null, false, true, true);
    }

    private void j6(String str, int i, int i2, int i3, int i4, String str2, boolean z, boolean z2, boolean z3) {
        this.FH = z2;
        this.Hw = z;
        this.v5 = z3;
        this.VH = i;
        this.gn = i2;
        this.u7 = i3;
        this.tp = i4;
        if (str2 == null || str2.length() < 3) {
            str2 = null;
        }
        this.Zo = str2;
        e.u7().we();
        e.XL().Zo(str, i, i2);
    }
}
