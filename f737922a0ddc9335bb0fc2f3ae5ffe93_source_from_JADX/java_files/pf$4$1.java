import android.app.PendingIntent;
import java.util.Map;

class pf$4$1 implements Runnable {
    final /* synthetic */ PendingIntent DW;
    final /* synthetic */ pf$4 FH;
    final /* synthetic */ Map j6;

    pf$4$1(pf$4 pf_4, Map map, PendingIntent pendingIntent) {
        this.FH = pf_4;
        this.j6 = map;
        this.DW = pendingIntent;
    }

    public void run() {
        this.FH.FH.er.putAll(this.j6);
        this.FH.FH.j6(this.DW);
    }
}
