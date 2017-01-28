import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class kt implements qi, qk {
    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        e.u7().we();
        int i = currentFileSpan.DW;
        int i2 = currentFileSpan.Hw;
        if (i == i2) {
            i2 = e.u7().sh().getCurrentFileLineCount();
            i = 1;
        }
        e.XL().Hw(e.j3().Hw(), i, i2, e.u7().sh().getTabSize());
        return true;
    }

    public boolean g_() {
        return e.j3().tp() && e.j3().gn();
    }

    public int f_() {
        return R.b.editorMenuFormatCode;
    }

    public k j6() {
        return new k(34, true, true, false);
    }

    public String v5() {
        return "Format Code";
    }
}
