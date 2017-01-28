import android.widget.Toast;
import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.e;

public class ml implements qi, qk {
    public boolean DW() {
        if (e.j3().J0()) {
            e.a8().Ws();
        } else {
            e.j3().j6(true, true);
            Toast.makeText(e.gn(), R.f.view_toast_files_saved, 0).show();
        }
        return true;
    }

    public boolean g_() {
        return e.j3().we();
    }

    public int f_() {
        return R.b.mainMenuSave;
    }

    public k j6() {
        return new k(47, false, true, false);
    }

    public String v5() {
        return "Save Files";
    }
}
