import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

class nu$3 implements TextWatcher {
    final /* synthetic */ nu DW;
    final /* synthetic */ AlertDialog j6;

    nu$3(nu nuVar, AlertDialog alertDialog) {
        this.DW = nuVar;
        this.j6 = alertDialog;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.DW.FH(this.j6);
    }
}
