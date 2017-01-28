import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nn$2 implements OnClickListener {
    final /* synthetic */ nn j6;

    nn$2(nn nnVar) {
        this.j6 = nnVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        r0.DW(r1);
        alertDialog.dismiss();
        this.j6.j6(this.j6.DW(), this.j6.Hw(alertDialog), this.j6.Zo(alertDialog), this.j6.FH(alertDialog));
    }
}
