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

public class ny extends m {
    protected Dialog j6(Activity activity) {
        CharSequence trim;
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        String str = "";
        if (currentFileSpan.DW != currentFileSpan.Hw || currentFileSpan.FH == currentFileSpan.v5) {
            Object obj = str;
        } else {
            trim = e.u7().sh().getSelectionContent().trim();
        }
        View inflate = LayoutInflater.from(activity).inflate(R.c.replace, null);
        Builder builder = new Builder(activity);
        builder.setTitle(R.f.command_replace_textually).setView(inflate).setCancelable(true).setPositiveButton(R.f.dialog_replace, new ny$2(this)).setNegativeButton(R.f.dialog_cancel, new ny$1(this));
        Dialog create = builder.create();
        EditText editText = (EditText) inflate.findViewById(R.b.replaceFindText);
        EditText editText2 = (EditText) inflate.findViewById(R.b.replaceWithText);
        TextView textView = (TextView) inflate.findViewById(R.b.replaceScope);
        if (currentFileSpan.DW == currentFileSpan.Hw) {
            textView.setText(R.f.dialog_replace_message_in_this_file);
        } else {
            textView.setText(R.f.dialog_replace_message_in_selected_lines);
        }
        editText.setText(trim);
        editText.setOnKeyListener(new ny$3(this, editText2));
        editText.addTextChangedListener(new ny$4(this, create));
        editText2.setText(trim);
        editText2.setOnKeyListener(new ny$5(this, create));
        editText2.addTextChangedListener(new ny$6(this, create));
        create.getWindow().setSoftInputMode(2);
        create.setOnShowListener(new ny$7(this, editText));
        return create;
    }

    protected void j6(AlertDialog alertDialog) {
        qg qgVar;
        String v5 = v5(alertDialog);
        String VH = VH(alertDialog);
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        if (currentFileSpan.DW == currentFileSpan.Hw) {
            qgVar = new qg(currentFileSpan.j6, 1, 1, Integer.MAX_VALUE, 1);
        } else {
            qgVar = currentFileSpan;
        }
        e.XL().j6(qgVar.j6, qgVar.DW, qgVar.FH, qgVar.Hw, qgVar.v5, v5, VH);
    }

    private void FH(AlertDialog alertDialog) {
        InputMethodManager inputMethodManager = (InputMethodManager) alertDialog.getContext().getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(Zo(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(gn(alertDialog).getWindowToken(), 0);
    }

    protected void DW(AlertDialog alertDialog) {
        Button button = alertDialog.getButton(-1);
        if (button != null) {
            button.setEnabled(Hw(alertDialog));
        }
    }

    private boolean Hw(AlertDialog alertDialog) {
        return (v5(alertDialog).length() == 0 || VH(alertDialog).equals(v5(alertDialog))) ? false : true;
    }

    private String v5(AlertDialog alertDialog) {
        return Zo(alertDialog).getText().toString();
    }

    private EditText Zo(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.replaceFindText);
    }

    private String VH(AlertDialog alertDialog) {
        return gn(alertDialog).getText().toString();
    }

    private EditText gn(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.replaceWithText);
    }
}
