import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ns$1 implements OnClickListener {
    final /* synthetic */ ns j6;

    ns$1(ns nsVar) {
        this.j6 = nsVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j6.DW((AlertDialog) dialogInterface);
        dialogInterface.cancel();
    }
}
