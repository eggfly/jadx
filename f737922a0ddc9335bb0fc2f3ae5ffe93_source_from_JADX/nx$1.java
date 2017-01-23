import android.view.View;
import android.view.View.OnClickListener;

class nx$1 implements OnClickListener {
    final /* synthetic */ Runnable DW;
    final /* synthetic */ nx FH;
    final /* synthetic */ boolean j6;

    nx$1(nx nxVar, boolean z, Runnable runnable) {
        this.FH = nxVar;
        this.j6 = z;
        this.DW = runnable;
    }

    public void onClick(View view) {
        if (this.j6) {
            this.FH.j6.dismiss();
        }
        this.DW.run();
    }
}
