import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import java.net.URISyntaxException;

public class nt extends m {
    private String j6;

    public nt(String str) {
        this.j6 = str;
    }

    protected Dialog j6(Activity activity) {
        CharSequence DW = DW();
        View inflate = LayoutInflater.from(activity).inflate(R.c.gitclonerepository, null);
        Builder builder = new Builder(activity);
        builder.setTitle("Clone Git repository").setView(inflate).setCancelable(true).setPositiveButton("Clone", null).setNegativeButton("Cancel", new nt$1(this));
        Dialog create = builder.create();
        ((TextView) inflate.findViewById(R.b.gitclonerepositoryUrl)).setText("");
        ((TextView) inflate.findViewById(R.b.gitclonerepositoryLocation)).setText(DW);
        EditText editText = (EditText) inflate.findViewById(R.b.gitclonerepositoryDirectoryName);
        editText.setText("");
        editText.addTextChangedListener(new nt$2(this, create));
        ((EditText) inflate.findViewById(R.b.gitclonerepositoryUrl)).addTextChangedListener(new nt$3(this, create, editText));
        create.setOnShowListener(new nt$4(this, activity));
        return create;
    }

    private String DW() {
        return this.j6;
    }

    private void DW(AlertDialog alertDialog) {
        InputMethodManager inputMethodManager = (InputMethodManager) alertDialog.getContext().getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(Hw(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(Zo(alertDialog).getWindowToken(), 0);
    }

    protected void j6(AlertDialog alertDialog) {
        boolean z = false;
        Button button = alertDialog.getButton(-1);
        if (button != null) {
            boolean z2 = true;
            try {
                avn avn = new avn(v5(alertDialog));
            } catch (URISyntaxException e) {
                z2 = false;
            }
            if (e.ei().j6(DW(), FH(alertDialog))) {
                z = z2;
            }
            button.setEnabled(z);
        }
    }

    private String FH(AlertDialog alertDialog) {
        return Hw(alertDialog).getText().toString().trim();
    }

    private EditText Hw(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.gitclonerepositoryDirectoryName);
    }

    private String v5(AlertDialog alertDialog) {
        return Zo(alertDialog).getText().toString().trim();
    }

    private EditText Zo(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.gitclonerepositoryUrl);
    }
}
