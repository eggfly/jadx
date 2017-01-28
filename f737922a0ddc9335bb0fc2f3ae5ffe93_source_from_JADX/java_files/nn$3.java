import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

class nn$3 implements TextWatcher {
    final /* synthetic */ nn DW;
    final /* synthetic */ AlertDialog j6;

    nn$3(nn nnVar, AlertDialog alertDialog) {
        this.DW = nnVar;
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
