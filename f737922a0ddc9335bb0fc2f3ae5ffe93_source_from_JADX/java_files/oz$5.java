import android.app.Activity;

class oz$5 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ oz FH;
    final /* synthetic */ Activity j6;

    oz$5(oz ozVar, Activity activity, String str) {
        this.FH = ozVar;
        this.j6 = activity;
        this.DW = str;
    }

    public void run() {
        this.FH.FH(this.j6, this.DW);
    }
}
