import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

class nt$2 implements TextWatcher {
    final /* synthetic */ nt DW;
    final /* synthetic */ AlertDialog j6;

    nt$2(nt ntVar, AlertDialog alertDialog) {
        this.DW = ntVar;
        this.j6 = alertDialog;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.DW.j6(this.j6);
    }
}
