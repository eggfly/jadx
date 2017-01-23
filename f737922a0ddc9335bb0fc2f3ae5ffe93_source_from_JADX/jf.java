import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class jf implements qm {
    public int f_() {
        return R.b.filebrowserMenuAddLibrary;
    }

    public boolean DW() {
        String Hw = e.er().Hw();
        m.DW(e.u7(), e.j6((int) R.f.command_files_add_library_to_project, new Object[0]), e.j6((int) R.f.dialog_add_library_message, Hw, e.a8().u7()), new jf$1(this, Hw), null);
        return true;
    }

    public boolean g_() {
        return j6(false);
    }

    public boolean j6(boolean z) {
        String Hw = e.er().Hw();
        return Hw != null && e.a8().Zo(Hw);
    }
}
