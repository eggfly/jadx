import android.app.Activity;

class oz$1 implements Runnable {
    final /* synthetic */ oz DW;
    final /* synthetic */ Activity j6;

    oz$1(oz ozVar, Activity activity) {
        this.DW = ozVar;
        this.j6 = activity;
    }

    public void run() {
        this.DW.Hw(this.j6);
    }
}
