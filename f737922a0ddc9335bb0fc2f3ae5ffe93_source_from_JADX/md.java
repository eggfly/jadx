import com.aide.common.k;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class md implements qi, qm {
    public boolean DW() {
        m.j6(e.u7(), (int) R.f.command_refresh_build, (int) R.f.dialog_refresh_build_message, new md$1(this), null);
        return true;
    }

    public boolean g_() {
        return e.a8().U2();
    }

    public int f_() {
        return R.b.mainMenuRebuild;
    }

    public k j6() {
        return new k(33, true, true, false);
    }

    public String v5() {
        return "Refresh Build";
    }

    public boolean j6(boolean z) {
        return true;
    }
}
