import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class jg implements qa {
    public boolean j6(boolean z) {
        String j6 = e.er().j6();
        return e.a8().EQ().containsKey(j6) && e.a8().rN(j6) != null;
    }

    public boolean DW() {
        String j6 = e.er().j6();
        m.j6(e.u7(), e.j6((int) R.f.command_files_add_to_project, new Object[0]), e.a8().rN(j6), new jg$1(this, j6));
        return true;
    }

    public int j6() {
        return R.drawable.project_new;
    }

    public int FH() {
        return R.f.command_files_add_to_project;
    }
}
