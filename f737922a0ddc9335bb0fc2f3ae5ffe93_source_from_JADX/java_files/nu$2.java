import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.aide.ui.activities.CommitActivity;

class nu$2 implements OnClickListener {
    final /* synthetic */ nu DW;
    final /* synthetic */ Activity j6;

    nu$2(nu nuVar, Activity activity) {
        this.DW = nuVar;
        this.j6 = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        this.DW.DW(alertDialog);
        ((CommitActivity) this.j6).j6(this.DW.j6(alertDialog));
    }
}
