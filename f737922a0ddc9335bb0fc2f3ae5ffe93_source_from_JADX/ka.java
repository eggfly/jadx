import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class ka implements qi, qm {
    public int f_() {
        return R.b.editorMenuCut;
    }

    public boolean DW() {
        e.u7().sh().U2();
        return true;
    }

    public boolean g_() {
        if (e.j3().gn() && !e.u7().sh().getCurrentFileSpan().DW()) {
            return true;
        }
        return false;
    }

    public boolean j6(boolean z) {
        return !z && g_();
    }

    public k j6() {
        return new k(52, false, true, false);
    }

    public String v5() {
        return "Cut";
    }
}
