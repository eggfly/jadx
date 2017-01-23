import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class me implements qm {
    public int f_() {
        return R.b.filebrowserMenuRemoveLibrary;
    }

    public boolean DW() {
        String Hw = e.er().Hw();
        m.DW(e.u7(), e.j6((int) R.f.command_files_remove_library_from_project, new Object[0]), e.j6((int) R.f.dialog_remove_library_message, Hw, e.a8().u7()), new me$1(this, Hw), null);
        return true;
    }

    public boolean g_() {
        return j6(false);
    }

    public boolean j6(boolean z) {
        String Hw = e.er().Hw();
        return Hw != null && e.a8().VH(Hw);
    }
}
