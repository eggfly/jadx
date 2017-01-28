import com.aide.ui.R;
import com.aide.ui.e;

public class jy implements qa, qm {
    public int f_() {
        return R.b.filebrowserMenuNewItem;
    }

    public boolean DW() {
        e.a8().j6(e.er().j6(), new jy$1(this));
        return true;
    }

    public boolean g_() {
        return j6(false);
    }

    public boolean j6(boolean z) {
        String j6 = e.er().j6();
        return j6 != null && e.er().Hw() == null && !qh.tp(j6) && e.a8().U2(j6);
    }

    public int j6() {
        return e.a8().lg(e.er().j6());
    }

    public int FH() {
        return e.a8().a8(e.er().j6());
    }
}
