import com.aide.common.m;
import com.aide.ui.e;
import java.io.IOException;

class kb$1$1$2 implements Runnable {
    final /* synthetic */ kb$1$1 DW;
    final /* synthetic */ IOException j6;

    kb$1$1$2(kb$1$1 kb_1_1, IOException iOException) {
        this.DW = kb_1_1;
        this.j6 = iOException;
    }

    public void run() {
        m.j6(e.u7(), "Delete", this.j6);
    }
}
