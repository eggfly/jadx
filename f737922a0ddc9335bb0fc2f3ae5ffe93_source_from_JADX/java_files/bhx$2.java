import android.os.Bundle;

class bhx$2 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ Bundle FH;
    final /* synthetic */ bhx Hw;
    final /* synthetic */ int j6;

    bhx$2(bhx bhx, int i, String str, Bundle bundle) {
        this.Hw = bhx;
        this.j6 = i;
        this.DW = str;
        this.FH = bundle;
    }

    public void run() {
        this.Hw.j6.j6(this.j6, this.DW, this.FH);
    }
}
