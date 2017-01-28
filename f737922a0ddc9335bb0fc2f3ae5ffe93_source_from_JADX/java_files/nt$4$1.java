import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.aide.ui.e;
import java.net.URISyntaxException;
import java.util.Locale;

class nt$4$1 implements OnClickListener {
    final /* synthetic */ nt$4 DW;
    final /* synthetic */ AlertDialog j6;

    nt$4$1(nt$4 nt_4, AlertDialog alertDialog) {
        this.DW = nt_4;
        this.j6 = alertDialog;
    }

    public void onClick(View view) {
        try {
            avn avn = new avn(this.DW.DW.v5(this.j6));
            for (avl avl : avd.FH()) {
                if (avl.j6().toUpperCase(Locale.US).contains("SSH") && avl.j6(avn)) {
                    if (avn.v5() == null || avn.v5().trim().length() == 0) {
                        Toast.makeText(this.DW.j6, "You must specify a username in the URL in this form: " + avn.Hw("user").toString(), 1).show();
                        return;
                    }
                }
            }
            String toLowerCase = avn.toString().toLowerCase(Locale.US);
            if (toLowerCase.startsWith("https://github.com/") && !toLowerCase.endsWith(".git")) {
                this.DW.DW.Zo(this.j6).setText(avn.toString() + ".git");
            }
        } catch (URISyntaxException e) {
        }
        this.DW.DW.DW(this.j6);
        this.j6.dismiss();
        e.ei().j6(this.DW.DW.DW(), this.DW.DW.FH(this.j6), this.DW.DW.v5(this.j6));
    }
}
