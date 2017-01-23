import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import java.math.BigInteger;
import java.util.Date;

public class nl extends m {
    private CharSequence DW;
    private String FH;
    private String Hw;
    private nl$a j6;

    public nl(String str, String str2, String str3, nl$a nl_a) {
        this.DW = str;
        this.Hw = str2;
        this.FH = str3;
        this.j6 = nl_a;
    }

    protected Dialog j6(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.c.createkeystore, null);
        Builder builder = new Builder(activity);
        builder.setTitle("Create keystore").setView(inflate).setCancelable(true).setPositiveButton("Create", new nl$2(this)).setNegativeButton("Cancel", new nl$1(this));
        Dialog create = builder.create();
        TextWatcher nl_3 = new nl$3(this, create);
        EditText editText = (EditText) inflate.findViewById(R.b.createkeystorePath);
        editText.addTextChangedListener(nl_3);
        EditText editText2 = (EditText) inflate.findViewById(R.b.createkeystoreAlias);
        editText2.addTextChangedListener(nl_3);
        EditText editText3 = (EditText) inflate.findViewById(R.b.createkeystorePassword);
        editText3.addTextChangedListener(nl_3);
        EditText editText4 = (EditText) inflate.findViewById(R.b.createkeystorePassword2);
        editText4.addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreValidity)).addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreName)).addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreOrganizationalUnit)).addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreOrganization)).addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreState)).addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreLocation)).addTextChangedListener(nl_3);
        ((EditText) inflate.findViewById(R.b.createkeystoreCountry)).addTextChangedListener(nl_3);
        editText.setText(this.DW);
        editText2.setText(this.Hw);
        editText3.setText(this.FH);
        editText4.setText(this.FH);
        create.setOnShowListener(new nl$4(this));
        return create;
    }

    private void DW(AlertDialog alertDialog) {
        InputMethodManager inputMethodManager = (InputMethodManager) alertDialog.getContext().getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(v5(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(VH(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(U2(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(lg(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(er(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(u7(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(j3(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(XL(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(J0(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(EQ(alertDialog).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(Ws(alertDialog).getWindowToken(), 0);
    }

    protected void j6(AlertDialog alertDialog) {
        Button button = alertDialog.getButton(-1);
        if (button != null) {
            String Hw = Hw(alertDialog);
            boolean z = qh.rN(Hw) && !qh.VH(Hw) && gn(alertDialog).length() > 0 && rN(alertDialog) >= 20 && Zo(alertDialog).length() > 0 && Mr(alertDialog).length() >= 2 && Mr(alertDialog).equals(a8(alertDialog));
            button.setEnabled(z);
        }
    }

    private void FH(AlertDialog alertDialog) {
        String Hw = Hw(alertDialog);
        BigInteger bigInteger = BigInteger.ONE;
        String Zo = Zo(alertDialog);
        e.j6(new nl$5(this, Hw, Mr(alertDialog), Zo, Mr(alertDialog), new Date(), new Date(System.currentTimeMillis() + (((long) rN(alertDialog)) * 31536000000L)), bigInteger, gn(alertDialog), QX(alertDialog), aM(alertDialog), we(alertDialog), tp(alertDialog), J8(alertDialog)));
    }

    private String Hw(AlertDialog alertDialog) {
        return v5(alertDialog).getText().toString().trim();
    }

    private EditText v5(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystorePath);
    }

    private String Zo(AlertDialog alertDialog) {
        return VH(alertDialog).getText().toString().trim();
    }

    private EditText VH(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreAlias);
    }

    private String gn(AlertDialog alertDialog) {
        return u7(alertDialog).getText().toString().trim();
    }

    private EditText u7(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreName);
    }

    private String tp(AlertDialog alertDialog) {
        return EQ(alertDialog).getText().toString().trim();
    }

    private EditText EQ(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreState);
    }

    private String we(AlertDialog alertDialog) {
        return J0(alertDialog).getText().toString().trim();
    }

    private EditText J0(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreLocation);
    }

    private String J8(AlertDialog alertDialog) {
        return Ws(alertDialog).getText().toString().trim();
    }

    private EditText Ws(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreCountry);
    }

    private String QX(AlertDialog alertDialog) {
        return XL(alertDialog).getText().toString().trim();
    }

    private EditText XL(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreOrganization);
    }

    private String aM(AlertDialog alertDialog) {
        return j3(alertDialog).getText().toString().trim();
    }

    private EditText j3(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreOrganizationalUnit);
    }

    private String Mr(AlertDialog alertDialog) {
        return U2(alertDialog).getText().toString().trim();
    }

    private EditText U2(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystorePassword);
    }

    private String a8(AlertDialog alertDialog) {
        return lg(alertDialog).getText().toString().trim();
    }

    private EditText lg(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystorePassword2);
    }

    private int rN(AlertDialog alertDialog) {
        try {
            return Integer.parseInt(er(alertDialog).getText().toString().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private EditText er(AlertDialog alertDialog) {
        return (EditText) alertDialog.findViewById(R.b.createkeystoreValidity);
    }
}
