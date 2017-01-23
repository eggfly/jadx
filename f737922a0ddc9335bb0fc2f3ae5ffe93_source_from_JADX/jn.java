import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class jn implements qm {
    public int f_() {
        return R.b.editorMenuClose;
    }

    public boolean DW() {
        String Hw = e.j3().Hw();
        if (e.j3().DW(Hw).gn()) {
            m.j6(e.u7(), (int) R.f.dialog_close_file_title, (int) R.f.dialog_close_file_message, new jn$1(this, Hw), null);
        } else {
            e.j3().Hw(Hw);
        }
        return true;
    }

    public boolean g_() {
        return e.j3().VH();
    }

    public boolean j6(boolean z) {
        return (z || !g_() || e.VH()) ? false : true;
    }
}
