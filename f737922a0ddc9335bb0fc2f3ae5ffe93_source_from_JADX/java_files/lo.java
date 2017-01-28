import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class lo implements qi, qm {
    public k j6() {
        return new k(40, true, true, false);
    }

    public String v5() {
        return "Show Current File";
    }

    public int f_() {
        return R.b.filebrowserShowCurrent;
    }

    public boolean DW() {
        String Hw = e.j3().Hw();
        if (Hw != null) {
            e.er().j6(qh.v5(Hw));
            e.u7().rN();
        }
        return true;
    }

    public boolean j6(boolean z) {
        return g_() && !e.j6.equals("com.aide.web");
    }

    public boolean g_() {
        return e.er().Hw() == null && e.j3().VH() && !qh.v5(e.j3().Hw()).equals(e.er().j6());
    }
}
