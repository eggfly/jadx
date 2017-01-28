import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class nx$2 implements OnClickListener {
    final /* synthetic */ nx j6;

    nx$2(nx nxVar) {
        this.j6 = nxVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.j6.v5.run();
    }
}
