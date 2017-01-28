import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class ll implements qi, qk {
    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.u7().we();
        e.XL().Zo(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5);
        return true;
    }

    public boolean g_() {
        return e.j3().tp() && e.j3().gn();
    }

    public int f_() {
        return R.b.editorMenuIntroduceVariable;
    }

    public k j6() {
        return new k(40, false, true, false);
    }

    public String v5() {
        return "Introduce Variable";
    }
}
