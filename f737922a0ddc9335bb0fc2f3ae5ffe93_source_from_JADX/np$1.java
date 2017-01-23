import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.aide.ui.e;

class np$1 implements OnClickListener {
    final /* synthetic */ np j6;

    np$1(np npVar) {
        this.j6 = npVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        e.nw().j6();
    }
}
