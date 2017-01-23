import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class jp implements qk {
    public boolean DW() {
        Hw();
        return true;
    }

    public boolean g_() {
        return e.a8().J0();
    }

    public int f_() {
        return R.b.mainMenuCloseProject;
    }

    private void Hw() {
        if (e.j3().we()) {
            m.j6(e.u7(), (int) R.f.dialog_save_files_title, (int) R.f.dialog_save_files_message, new jp$1(this), new jp$2(this));
        } else {
            v5();
        }
    }

    private void v5() {
        e.a8().J8();
        e.er().FH();
    }
}
