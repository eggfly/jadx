import android.app.AlertDialog;
import com.aide.common.m;
import com.aide.ui.e;
import java.util.List;

class np$5 implements nz$b {
    final /* synthetic */ np DW;
    final /* synthetic */ AlertDialog j6;

    np$5(np npVar, AlertDialog alertDialog) {
        this.DW = npVar;
        this.j6 = alertDialog;
    }

    public void j6(List<String> list) {
        this.DW.j6(this.j6, (List) list);
    }

    public void j6(aea aea) {
        this.j6.cancel();
        m.j6(e.u7(), "Dropbox", "Error: " + (aea == null ? "" : aea.getMessage()));
    }
}
