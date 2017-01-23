import android.app.Activity;
import java.io.File;

class oz$11 implements Runnable {
    final /* synthetic */ File DW;
    final /* synthetic */ oz FH;
    final /* synthetic */ Activity j6;

    oz$11(oz ozVar, Activity activity, File file) {
        this.FH = ozVar;
        this.j6 = activity;
        this.DW = file;
    }

    public void run() {
        this.FH.j6(this.j6, this.DW);
    }
}
