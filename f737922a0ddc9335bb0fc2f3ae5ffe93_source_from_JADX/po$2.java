import com.aide.ui.e;
import java.io.IOException;

class po$2 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ po FH;
    final /* synthetic */ String j6;

    po$2(po poVar, String str, String str2) {
        this.FH = poVar;
        this.j6 = str;
        this.DW = str2;
    }

    public void run() {
        this.FH.Ws(this.j6);
        try {
            e.j3().j6(this.DW, true);
        } catch (IOException e) {
        }
    }
}
