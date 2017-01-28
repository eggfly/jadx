import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ny$2 implements OnClickListener {
    final /* synthetic */ ny j6;

    ny$2(ny nyVar) {
        this.j6 = nyVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        this.j6.FH(alertDialog);
        alertDialog.dismiss();
        this.j6.j6(alertDialog);
    }
}
