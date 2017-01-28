import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class ki implements qi, qm {
    public boolean DW() {
        e.u7().we();
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.XL().FH(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5);
        return false;
    }

    public boolean g_() {
        return e.j3().VH();
    }

    public int f_() {
        return R.b.editorMenuExpandSelection;
    }

    public k j6() {
        return new k(51, false, true, false);
    }

    public String v5() {
        return "Expand Selection";
    }

    public boolean j6(boolean z) {
        return !z && g_();
    }
}
