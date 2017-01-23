import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class ju implements qi, qk {
    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.u7().we();
        e.XL().j6(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5);
        return true;
    }

    public boolean g_() {
        return e.j3().u7() && e.j3().gn();
    }

    public int f_() {
        return R.b.editorMenuCreateConstructor;
    }

    public k j6() {
        return new k(31, true, true, false);
    }

    public String v5() {
        return "Create Constructor";
    }
}
