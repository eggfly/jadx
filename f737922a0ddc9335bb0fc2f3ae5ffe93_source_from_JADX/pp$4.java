import com.aide.ui.e;
import com.aide.ui.trainer.c.j;
import java.io.IOException;
import java.util.List;

class pp$4 implements Runnable {
    final /* synthetic */ boolean DW;
    final /* synthetic */ Runnable FH;
    final /* synthetic */ pp Hw;
    final /* synthetic */ j j6;

    pp$4(pp ppVar, j jVar, boolean z, Runnable runnable) {
        this.Hw = ppVar;
        this.j6 = jVar;
        this.DW = z;
        this.FH = runnable;
    }

    public void run() {
        String j6 = this.Hw.FH(this.j6);
        List list = null;
        if (this.DW) {
            try {
                qh.j3(j6);
            } catch (IOException e) {
            }
            try {
                list = this.Hw.DW(this.j6);
            } catch (IOException e2) {
            }
        }
        e.j6(new pp$4$1(this, j6, list));
    }
}
