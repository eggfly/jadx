import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.widget.EditText;

class ny$7 implements OnShowListener {
    final /* synthetic */ ny DW;
    final /* synthetic */ EditText j6;

    ny$7(ny nyVar, EditText editText) {
        this.DW = nyVar;
        this.j6 = editText;
    }

    public void onShow(DialogInterface dialogInterface) {
        this.DW.DW((AlertDialog) dialogInterface);
        this.j6.selectAll();
    }
}
