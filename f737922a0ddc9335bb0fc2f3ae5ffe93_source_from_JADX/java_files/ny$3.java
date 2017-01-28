import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class ny$3 implements OnKeyListener {
    final /* synthetic */ ny DW;
    final /* synthetic */ EditText j6;

    ny$3(ny nyVar, EditText editText) {
        this.DW = nyVar;
        this.j6 = editText;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        this.j6.selectAll();
        this.j6.requestFocus();
        return true;
    }
}
