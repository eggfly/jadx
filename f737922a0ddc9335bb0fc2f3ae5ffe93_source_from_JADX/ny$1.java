import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ny$1 implements OnClickListener {
    final /* synthetic */ ny j6;

    ny$1(ny nyVar) {
        this.j6 = nyVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j6.FH((AlertDialog) dialogInterface);
        dialogInterface.cancel();
    }
}
