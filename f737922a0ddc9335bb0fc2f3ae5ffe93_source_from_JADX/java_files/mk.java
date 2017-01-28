import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.Arrays;
import java.util.List;

public class mk implements py, ql, qn {
    public boolean DW() {
        if (e.VH()) {
            e.QX().EQ();
        } else if (e.Sf().we()) {
            e.Sf().Hw();
        } else {
            e.a8().j6(false);
        }
        return true;
    }

    public boolean h_() {
        return true;
    }

    public boolean g_() {
        if (e.VH() || !e.Sf().we()) {
            return e.a8().a8();
        }
        return true;
    }

    public int f_() {
        return R.b.mainMenuRun;
    }

    public int Zo() {
        return f_();
    }

    public List<k> Hw() {
        return Arrays.asList(new k[]{new k(99, false, false, false), new k(85, false, false, false)});
    }

    public k j6() {
        return new k(33, false, true, false);
    }

    public String v5() {
        return "Run";
    }

    public String VH() {
        if (e.VH()) {
            return e.QX().a8();
        }
        return null;
    }
}
