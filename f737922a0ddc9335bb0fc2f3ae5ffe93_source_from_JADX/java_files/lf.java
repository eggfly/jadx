import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class lf implements qi, qm {
    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.yS().j6(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5, null);
        return true;
    }

    public boolean j6(boolean z) {
        return !z && g_();
    }

    public boolean g_() {
        return e.j3().tp() && e.u7().sh().getCurrentFileSpan().j6();
    }

    public int f_() {
        return R.b.editorMenuGotoDefinition;
    }

    public k j6() {
        return new k(66, false, true, false);
    }

    public String v5() {
        return "GoTo Definition";
    }
}
