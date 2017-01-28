import com.aide.common.m;
import com.aide.ui.e;

class pq$1$4 implements Runnable {
    final /* synthetic */ pq$1 DW;
    final /* synthetic */ String j6;

    pq$1$4(pq$1 pq_1, String str) {
        this.DW = pq_1;
        this.j6 = str;
    }

    public void run() {
        e.u7().J0();
        m.j6(e.u7(), "Refactor", this.j6);
    }
}
