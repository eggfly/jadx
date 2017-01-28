import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nl$1 implements OnClickListener {
    final /* synthetic */ nl j6;

    nl$1(nl nlVar) {
        this.j6 = nlVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j6.DW((AlertDialog) dialogInterface);
        dialogInterface.cancel();
    }
}
