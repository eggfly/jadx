import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class np$4 implements OnShowListener {
    final /* synthetic */ np j6;

    np$4(np npVar) {
        this.j6 = npVar;
    }

    public void onShow(DialogInterface dialogInterface) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        this.j6.j6(alertDialog);
        this.j6.DW(alertDialog);
    }
}
