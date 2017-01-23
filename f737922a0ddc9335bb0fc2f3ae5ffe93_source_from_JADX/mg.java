import com.aide.common.k;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class mg implements qi, qm {
    public boolean DW() {
        String Hw = e.er().Hw();
        m.j6(e.u7(), (int) R.f.dialog_rename_title, (int) R.f.dialog_rename_message, qh.Zo(Hw), new mg$1(this, Hw));
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
        return R.b.filebrowserMenuRename;
    }

    public k j6() {
        return new k(46, false, true, false);
    }

    public String v5() {
        return "Files - Rename";
    }
}
