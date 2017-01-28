import android.util.Pair;
import com.aide.common.k;
import com.aide.engine.SyntaxError;
import com.aide.ui.e;

public class li implements qi {
    public k j6() {
        return new k(19, false, true, false);
    }

    public boolean g_() {
        return e.aM().FH() > 0;
    }

    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        Pair DW = e.aM().DW(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH);
        if (DW != null) {
            e.u7().j6((qg) DW.first);
            e.aM().j6((SyntaxError) DW.second);
        }
        return true;
    }

    public String v5() {
        return "GoTo Previous Error";
    }
}
