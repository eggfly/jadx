import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

class ny$4 implements TextWatcher {
    final /* synthetic */ ny DW;
    final /* synthetic */ AlertDialog j6;

    ny$4(ny nyVar, AlertDialog alertDialog) {
        this.DW = nyVar;
        this.j6 = alertDialog;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.DW.DW(this.j6);
    }
}
