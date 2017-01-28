import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class nt$4 implements OnShowListener {
    final /* synthetic */ nt DW;
    final /* synthetic */ Activity j6;

    nt$4(nt ntVar, Activity activity) {
        this.DW = ntVar;
        this.j6 = activity;
    }

    public void onShow(DialogInterface dialogInterface) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        this.DW.j6(alertDialog);
        alertDialog.getButton(-1).setOnClickListener(new nt$4$1(this, alertDialog));
    }
}
