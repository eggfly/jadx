import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nl$2 implements OnClickListener {
    final /* synthetic */ nl j6;

    nl$2(nl nlVar) {
        this.j6 = nlVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        this.j6.DW(alertDialog);
        alertDialog.dismiss();
        this.j6.FH(alertDialog);
    }
}
