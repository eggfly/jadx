import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

class ns$4 implements TextWatcher {
    final /* synthetic */ ns DW;
    final /* synthetic */ AlertDialog j6;

    ns$4(ns nsVar, AlertDialog alertDialog) {
        this.DW = nsVar;
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
