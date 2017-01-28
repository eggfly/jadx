import com.aide.ui.R;
import com.aide.ui.e;

public class jr implements qm {
    public int f_() {
        return R.b.editorMenuCopy;
    }

    public boolean DW() {
        e.u7().sh().Mr();
        return true;
    }

    public boolean g_() {
        if (e.j3().VH() && !e.u7().sh().getCurrentFileSpan().DW()) {
            return true;
        }
        return false;
    }

    public boolean j6(boolean z) {
        return !z && g_();
    }
}
