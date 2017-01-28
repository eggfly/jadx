import com.aide.common.k;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class mn implements qi, qk {
    public boolean DW() {
        String str = "";
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        if (currentFileSpan.DW == currentFileSpan.Hw) {
            str = e.u7().sh().getSelectionContent().trim();
        }
        m.j6(e.u7(), (int) R.f.command_find_in_project, (int) R.f.dialog_search_message, str, new mn$1(this));
        return true;
    }

    public boolean g_() {
        return e.a8().J0();
    }

    public int f_() {
        return R.b.mainMenuSearchInProject;
    }

    public k j6() {
        return new k(36, true, true, true);
    }

    public String v5() {
        return "Search in Project";
    }
}
