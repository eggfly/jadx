import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class ny$5 implements OnKeyListener {
    final /* synthetic */ ny DW;
    final /* synthetic */ AlertDialog j6;

    ny$5(ny nyVar, AlertDialog alertDialog) {
        this.DW = nyVar;
        this.j6 = alertDialog;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        if (!this.DW.Hw(this.j6)) {
            return true;
        }
        this.DW.FH(this.j6);
        this.j6.dismiss();
        this.DW.j6(this.j6);
        return true;
    }
}
