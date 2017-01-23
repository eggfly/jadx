import com.aide.common.j;
import com.aide.common.m;
import com.aide.engine.SyntaxError;
import com.aide.ui.R;
import com.aide.ui.e;

public class jj implements qm {
    public int f_() {
        return R.b.editorMenuChooseColor;
    }

    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        SyntaxError DW = e.u7().sh().DW(currentFileSpan.DW, currentFileSpan.FH);
        m.j6(e.u7(), new j("Choose Color", DW.DW, new jj$1(this, DW)));
        return true;
    }

    public boolean g_() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        return (currentFileSpan.j6 == null || e.u7().sh().DW(currentFileSpan.DW, currentFileSpan.FH) == null) ? false : true;
    }

    public boolean j6(boolean z) {
        return g_();
    }
}
