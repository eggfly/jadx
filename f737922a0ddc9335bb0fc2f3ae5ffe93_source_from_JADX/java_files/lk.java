import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class lk implements qi, qk {
    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.u7().we();
        e.XL().DW(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH);
        return true;
    }

    public boolean g_() {
        return e.j3().tp() && e.u7().sh().getCurrentFileSpan().j6() && e.j3().gn();
    }

    public int f_() {
        return R.b.editorMenuInlineVariable;
    }

    public k j6() {
        return new k(37, false, true, false);
    }

    public String v5() {
        return "Inline Variable";
    }
}
