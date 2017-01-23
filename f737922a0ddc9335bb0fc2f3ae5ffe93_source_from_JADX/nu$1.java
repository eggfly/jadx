import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nu$1 implements OnClickListener {
    final /* synthetic */ nu j6;

    nu$1(nu nuVar) {
        this.j6 = nuVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j6.DW((AlertDialog) dialogInterface);
        dialogInterface.cancel();
    }
}
