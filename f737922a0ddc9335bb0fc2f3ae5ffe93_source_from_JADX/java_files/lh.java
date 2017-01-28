import android.util.Pair;
import com.aide.common.k;
import com.aide.engine.SyntaxError;
import com.aide.ui.e;

public class lh implements qi {
    public k j6() {
        return new k(20, false, true, false);
    }

    public boolean g_() {
        return e.aM().FH() > 0;
    }

    public boolean DW() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        Pair j6 = e.aM().j6(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH);
        if (j6 != null) {
            e.u7().j6((qg) j6.first);
            e.aM().j6((SyntaxError) j6.second);
        }
        return true;
    }

    public String v5() {
        return "GoTo Next Error";
    }
}
