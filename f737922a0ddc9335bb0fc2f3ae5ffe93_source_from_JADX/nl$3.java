import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

class nl$3 implements TextWatcher {
    final /* synthetic */ nl DW;
    final /* synthetic */ AlertDialog j6;

    nl$3(nl nlVar, AlertDialog alertDialog) {
        this.DW = nlVar;
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
