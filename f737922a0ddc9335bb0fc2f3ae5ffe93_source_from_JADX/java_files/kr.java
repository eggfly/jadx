import com.aide.ui.R;
import com.aide.ui.e;

public class kr implements qk {
    public boolean DW() {
        e.yS().j6(e.u7().sh().getSelectionContent().trim());
        return true;
    }

    public boolean g_() {
        if (!e.a8().J0() || !e.j3().VH()) {
            return false;
        }
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        if (currentFileSpan.DW != currentFileSpan.Hw || currentFileSpan.v5 - currentFileSpan.FH <= 2) {
            return false;
        }
        return true;
    }

    public int f_() {
        return R.b.editorMenuFindTextually;
    }
}
