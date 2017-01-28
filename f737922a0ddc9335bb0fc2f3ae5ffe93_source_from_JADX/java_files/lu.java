import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class lu implements qa {
    public boolean j6(boolean z) {
        String j6 = e.er().j6();
        return e.a8().we(j6) && !j6.equals(e.a8().u7());
    }

    public boolean DW() {
        j6(e.er().j6());
        return true;
    }

    private void j6(String str) {
        if (e.j3().we()) {
            m.j6(e.u7(), (int) R.f.dialog_save_files_title, (int) R.f.dialog_save_files_message, new lu$1(this, str), new lu$2(this, str));
        } else {
            e.a8().Ws(str);
        }
    }

    public int j6() {
        return R.drawable.project_open;
    }

    public int FH() {
        return e.a8().J0(e.er().j6());
    }
}
