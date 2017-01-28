import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class jx implements qa, qm {
    public int f_() {
        return R.b.filebrowserMenuNewProject;
    }

    public boolean DW() {
        m.j6(e.u7(), new nm(e.er().j6(), false));
        return true;
    }

    public boolean g_() {
        return j6(false);
    }

    public boolean j6(boolean z) {
        return e.er().Hw() == null && e.vy().FH(e.er().j6());
    }

    public int j6() {
        return R.drawable.project_new;
    }

    public int FH() {
        return R.f.command_files_create_new_project;
    }
}
