import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class lz implements qi, qm {
    public int f_() {
        return R.b.editorMenuPaste;
    }

    public boolean DW() {
        e.u7().sh().gW();
        return true;
    }

    public boolean g_() {
        return e.j3().gn();
    }

    public k j6() {
        return new k(50, false, true, false);
    }

    public String v5() {
        return "Paste";
    }

    public boolean j6(boolean z) {
        return !z && g_();
    }
}
