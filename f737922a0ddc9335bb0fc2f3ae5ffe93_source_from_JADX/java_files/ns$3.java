import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.aide.ui.build.c;

class ns$3 implements OnClickListener {
    final /* synthetic */ ns j6;

    ns$3(ns nsVar) {
        this.j6 = nsVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        this.j6.DW(alertDialog);
        alertDialog.dismiss();
        this.j6.j6(this.j6.FH(alertDialog), this.j6.v5(alertDialog));
        c.j6.j6(this.j6.FH, this.j6.FH(alertDialog), this.j6.v5(alertDialog));
    }
}
