import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.aide.ui.e;
import java.io.File;
import java.net.URISyntaxException;

class nt$3 implements TextWatcher {
    final /* synthetic */ EditText DW;
    final /* synthetic */ nt FH;
    private String Hw;
    final /* synthetic */ AlertDialog j6;

    nt$3(nt ntVar, AlertDialog alertDialog, EditText editText) {
        this.FH = ntVar;
        this.j6 = alertDialog;
        this.DW = editText;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.Hw = charSequence.toString().trim();
    }

    public void afterTextChanged(Editable editable) {
        if (this.FH.FH(this.j6).length() == 0 || this.FH.FH(this.j6).equals(j6(this.Hw))) {
            CharSequence charSequence;
            String j6 = j6(editable.toString().trim());
            if (!e.ei().j6(this.FH.DW(), j6)) {
                for (int i = 2; i <= 20; i++) {
                    charSequence = j6 + "-" + i;
                    if (e.ei().j6(this.FH.DW(), (String) charSequence)) {
                        break;
                    }
                }
            }
            Object obj = j6;
            this.DW.setText(charSequence);
        }
        this.FH.j6(this.j6);
    }

    private String j6(String str) {
        try {
            String FH = new avn(str).FH();
            if (FH == null) {
                return "";
            }
            if (FH.endsWith("/.git")) {
                FH = FH.substring(0, FH.length() - "/.git".length());
            } else if (FH.endsWith(".git")) {
                FH = FH.substring(0, FH.length() - ".git".length());
            }
            return new File(FH).getName();
        } catch (URISyntaxException e) {
            return "";
        }
    }
}
