import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.TextView;

class nx$3 implements OnShowListener {
    final /* synthetic */ nx DW;
    final /* synthetic */ Activity j6;

    nx$3(nx nxVar, Activity activity) {
        this.DW = nxVar;
        this.j6 = activity;
    }

    public void onShow(DialogInterface dialogInterface) {
        View findViewById = this.DW.j6.findViewById(this.j6.getResources().getIdentifier("android:id/title_template", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(-1);
        }
        if (VERSION.SDK_INT >= 20) {
            findViewById = this.DW.j6.findViewById(this.j6.getResources().getIdentifier("android:id/buttonPanel", null, null));
            if (findViewById != null) {
                findViewById.setBackgroundColor(-1);
            }
        }
        findViewById = this.DW.j6.findViewById(this.j6.getResources().getIdentifier("android:id/alertTitle", null, null));
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setTextColor(-13421773);
        }
    }
}
