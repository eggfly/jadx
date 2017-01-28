import android.content.ClipboardManager;
import android.widget.Toast;
import com.aide.ui.R;
import com.aide.ui.e;

public class js implements qm {
    public boolean DW() {
        CharSequence Hw = e.er().Hw();
        if (Hw != null) {
            ((ClipboardManager) e.gn().getSystemService("clipboard")).setText(Hw);
            Toast.makeText(e.gn(), R.f.view_toast_copied_to_clipboard, 0).show();
        }
        return true;
    }

    public boolean g_() {
        return j6(false);
    }

    public boolean j6(boolean z) {
        return e.er().Hw() != null;
    }

    public int f_() {
        return R.b.filebrowserMenuCopyPath;
    }
}
