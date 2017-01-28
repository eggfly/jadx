import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aide.common.m;
import com.aide.ui.R;

public class nx extends m {
    private View DW;
    private String FH;
    private String Hw;
    private AlertDialog j6;
    private Runnable v5;

    public nx(Context context, String str) {
        this.FH = str;
        this.DW = LayoutInflater.from(context).inflate(R.c.promo_dialog, null);
    }

    public void j6(String str, Runnable runnable) {
        this.Hw = str;
        this.v5 = runnable;
    }

    public void j6(String str, String str2, int i, boolean z, Runnable runnable) {
        LinearLayout linearLayout = (LinearLayout) this.DW.findViewById(R.b.promoDialogLayout);
        View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.c.promo_dialog_entry, null);
        linearLayout.addView(inflate);
        ((ImageView) inflate.findViewById(R.b.promoListEntryLogo)).setImageResource(i);
        ((TextView) inflate.findViewById(R.b.promoListEntryText1)).setText(str);
        ((TextView) inflate.findViewById(R.b.promoListEntryText2)).setText(str2);
        inflate.findViewById(R.b.promoListEntryLayout).setOnClickListener(new nx$1(this, z, runnable));
    }

    protected Dialog j6(Activity activity) {
        Builder cancelable = new Builder(activity).setTitle(this.FH).setView(this.DW).setCancelable(false);
        if (this.Hw != null) {
            cancelable.setNegativeButton(this.Hw, new nx$2(this));
        }
        this.j6 = cancelable.create();
        this.j6.setOnShowListener(new nx$3(this, activity));
        return this.j6;
    }
}
