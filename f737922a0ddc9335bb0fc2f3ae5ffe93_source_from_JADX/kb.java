import com.aide.common.k;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class kb implements qi, qm {
    public boolean DW() {
        String Hw = e.er().Hw();
        m.DW(e.u7(), e.j6((int) R.f.dialog_delete_file_title, new Object[0]), e.j6((int) R.f.dialog_delete_file_message, Hw), new kb$1(this, Hw), null);
        return true;
    }

    public boolean g_() {
        return j6(false);
    }

    public boolean j6(boolean z) {
        String Hw = e.er().Hw();
        return (Hw == null || qh.tp(Hw)) ? false : true;
    }

    public int f_() {
        return R.b.filebrowserMenuDelete;
    }

    public k j6() {
        return new k(67, false, false, false);
    }

    public String v5() {
        return "Files - Delete";
    }
}
