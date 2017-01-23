import android.app.Activity;
import com.aide.ui.trainer.c.j;

class pp$2 implements Runnable {
    final /* synthetic */ j DW;
    final /* synthetic */ Runnable FH;
    final /* synthetic */ pp Hw;
    final /* synthetic */ Activity j6;

    pp$2(pp ppVar, Activity activity, j jVar, Runnable runnable) {
        this.Hw = ppVar;
        this.j6 = activity;
        this.DW = jVar;
        this.FH = runnable;
    }

    public void run() {
        this.Hw.j6(this.j6, this.DW, false, this.FH);
    }
}
