import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.aide.ui.e;

class np$3 implements OnClickListener {
    final /* synthetic */ np j6;

    np$3(np npVar) {
        this.j6 = npVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ((AlertDialog) dialogInterface).dismiss();
        e.nw().j6(this.j6.DW(), this.j6.Hw());
    }
}
