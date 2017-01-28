import android.app.Activity;
import com.aide.common.m;
import com.aide.common.w;
import java.io.IOException;

class oz$9 implements Runnable {
    final /* synthetic */ Activity DW;
    final /* synthetic */ String FH;
    final /* synthetic */ Runnable Hw;
    final /* synthetic */ oz Zo;
    final /* synthetic */ String j6;
    final /* synthetic */ Runnable v5;

    oz$9(oz ozVar, String str, Activity activity, String str2, Runnable runnable, Runnable runnable2) {
        this.Zo = ozVar;
        this.j6 = str;
        this.DW = activity;
        this.FH = str2;
        this.Hw = runnable;
        this.v5 = runnable2;
    }

    public void run() {
        try {
            if (this.j6 != null) {
                m.j6(this.DW, "Download Google Libraries", w.j6(this.DW.getAssets().open(this.j6)).replaceAll("\\s+([1-9]+\\.)", "\n\n$1"), true, "Accept", new oz$9$1(this), "Decline", this.v5);
                return;
            }
            this.Zo.j6(this.DW, this.FH, this.Hw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
