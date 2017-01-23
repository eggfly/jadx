import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nt$1 implements OnClickListener {
    final /* synthetic */ nt j6;

    nt$1(nt ntVar) {
        this.j6 = ntVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j6.DW((AlertDialog) dialogInterface);
        dialogInterface.cancel();
    }
}
