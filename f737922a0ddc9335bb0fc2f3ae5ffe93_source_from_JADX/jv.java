import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class jv implements qm {
    public boolean DW() {
        m.j6(e.u7(), (int) R.f.command_files_create_new_folder, (int) R.f.dialog_create_message, "", new jv$1(this, e.er().j6()));
        return true;
    }

    public boolean j6(boolean z) {
        return g_();
    }

    public boolean g_() {
        String j6 = e.er().j6();
        return (j6 == null || e.er().Hw() != null || qh.tp(j6)) ? false : true;
    }

    public int f_() {
        return R.b.filebrowserMenuNewDir;
    }
}
