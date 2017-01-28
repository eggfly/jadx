import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.aide.common.m;
import com.aide.ui.R;

public class nu extends m {
    protected Dialog j6(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.c.gitcommitdata, null);
        Builder builder = new Builder(activity);
        builder.setTitle("Git commit").setView(inflate).setCancelable(true).setPositiveButton("Commit", new nu$2(this, activity)).setNegativeButton("Cancel", new nu$1(this));
        Dialog create = builder.create();
        ((EditText) inflate.findViewById(R.b.gitcommitdatamessage)).addTextChangedListener(new nu$3(this, create));
        create.setOnShowListener(new nu$4(this));
        return create;
    }

    private void DW(AlertDialog alertDialog) {
        ((InputMethodManager) alertDialog.getContext().getSystemService("input_method")).hideSoftInputFromWindow(Hw(alertDialog).getWindowToken(), 0);
    }

    private void FH(AlertDialog alertDialog) {
        Button button = alertDialog.getButton(-1);
        if (button != null) {
            boolean z = true;
            if (j6(alertDialog).length() == 0) {
                z = false;
            }
            button.setEnabled(z);
        }
    }

    public String j6(AlertDialog alertDialog) {
        return Hw(alertDialog).getText().toString().trim();
    }

    private EditText Hw(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.gitcommitdatamessage);
    }
}
