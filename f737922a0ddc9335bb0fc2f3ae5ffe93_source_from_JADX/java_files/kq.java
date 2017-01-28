import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class kq implements qi, qk {
    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.yS().DW(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5);
        return true;
    }

    public boolean g_() {
        return e.j3().tp() && e.u7().sh().getCurrentFileSpan().j6();
    }

    public int f_() {
        return R.b.editorMenuFindExtendedUsages;
    }

    public k j6() {
        return new k(35, true, true, false);
    }

    public String v5() {
        return "Find Extended Usages";
    }
}
