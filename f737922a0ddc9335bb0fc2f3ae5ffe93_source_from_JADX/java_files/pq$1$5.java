import com.aide.ui.e;
import java.util.List;

class pq$1$5 implements Runnable {
    final /* synthetic */ pq$1 DW;
    final /* synthetic */ List j6;

    pq$1$5(pq$1 pq_1, List list) {
        this.DW = pq_1;
        this.j6 = list;
    }

    public void run() {
        e.u7().J0();
        this.DW.j6.j6(this.j6);
    }
}
