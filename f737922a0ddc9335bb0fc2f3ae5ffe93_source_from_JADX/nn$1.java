import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nn$1 implements OnClickListener {
    final /* synthetic */ nn j6;

    nn$1(nn nnVar) {
        this.j6 = nnVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j6.DW((AlertDialog) dialogInterface);
        dialogInterface.cancel();
    }
}
