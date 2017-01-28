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
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;

public class nn extends m {
    private pn$a DW;
    private y<String> FH;
    private String j6;

    public nn(String str, pn$a pn_a, y<String> yVar) {
        this.j6 = str;
        this.DW = pn_a;
        this.FH = yVar;
    }

    protected Dialog j6(Activity activity) {
        int i = 0;
        View inflate = LayoutInflater.from(activity).inflate(R.c.createproject, null);
        Builder builder = new Builder(activity);
        builder.setTitle(R.f.dialog_create_project_title).setView(inflate).setCancelable(true).setPositiveButton(R.f.dialog_create_project_create, new nn$2(this)).setNegativeButton(R.f.dialog_cancel, new nn$1(this));
        Dialog create = builder.create();
        ((TextView) inflate.findViewById(R.b.createprojectType)).setText(activity.getResources().getString(R.f.dialog_create_project_new, new Object[]{this.DW.j6}));
        ((TextView) inflate.findViewById(R.b.createprojectLocation)).setText(activity.getResources().getString(R.f.dialog_create_project_in, new Object[]{this.j6}));
        EditText editText = (EditText) inflate.findViewById(R.b.createprojectName);
        Object j6 = e.vy().j6(this.j6, this.DW.Zo.v5);
        editText.setText(j6);
        editText.addTextChangedListener(new nn$3(this, create));
        editText = (EditText) inflate.findViewById(R.b.createprojectPackage);
        editText.setText(e.vy().DW(j6));
        editText.addTextChangedListener(new nn$4(this, create));
        editText.setVisibility(this.DW.Zo.Zo ? 0 : 8);
        TextView textView = (TextView) inflate.findViewById(R.b.createprojectPackageLabel);
        if (!this.DW.Zo.Zo) {
            i = 8;
        }
        textView.setVisibility(i);
        create.getWindow().setSoftInputMode(2);
        return create;
    }

    private String DW() {
        return this.j6;
    }

    private void DW(AlertDialog alertDialog) {
        InputMethodManager inputMethodManager = (InputMethodManager) alertDialog.getContext().getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(v5(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(VH(alertDialog).getWindowToken(), 0);
    }

    private void j6(String str, String str2, String str3, pn$a pn_a) {
        e.j6(e.u7(), "Creating Project ...", new nn$5(this, str, str2, str3, pn_a), null);
    }

    protected void j6(AlertDialog alertDialog) {
        Button button = alertDialog.getButton(-1);
        if (button != null) {
            boolean z = e.vy().Hw(DW(), Zo(alertDialog)) && e.vy().DW(DW(), Hw(alertDialog));
            button.setEnabled(z);
        }
    }

    private pn$a FH(AlertDialog alertDialog) {
        return this.DW;
    }

    private String Hw(AlertDialog alertDialog) {
        return v5(alertDialog).getText().toString().trim();
    }

    private EditText v5(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createprojectName);
    }

    private String Zo(AlertDialog alertDialog) {
        return VH(alertDialog).getText().toString().trim();
    }

    private EditText VH(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createprojectPackage);
    }
}
