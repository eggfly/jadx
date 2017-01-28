import android.app.Activity;

class oz$10 implements Runnable {
    final /* synthetic */ oz DW;
    final /* synthetic */ Activity j6;

    oz$10(oz ozVar, Activity activity) {
        this.DW = ozVar;
        this.j6 = activity;
    }

    public void run() {
        this.DW.DW(this.j6, "Download support for native code (C/C++)", new oz$10$1(this));
    }
}
