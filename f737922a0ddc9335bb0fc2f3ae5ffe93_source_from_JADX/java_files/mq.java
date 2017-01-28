import com.aide.common.b;
import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.activities.a;
import com.aide.ui.e;

public class mq implements qi, qm {
    public boolean j6(boolean z) {
        return !z && g_();
    }

    public boolean DW() {
        if (e.j3().EQ()) {
            qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
            e.yS().FH(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5);
        } else {
            b.j6(e.u7(), null, a.tp().toString());
        }
        return true;
    }

    public boolean g_() {
        if (!e.j3().EQ()) {
            return true;
        }
        if (e.j3().tp() && e.u7().sh().getCurrentFileSpan().j6()) {
            return true;
        }
        return false;
    }

    public int f_() {
        return R.b.editorMenuHelp;
    }

    public k j6() {
        return new k(36, false, true, false);
    }

    public String v5() {
        return "Show Code Help";
    }
}
