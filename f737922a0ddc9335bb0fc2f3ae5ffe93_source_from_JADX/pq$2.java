import java.util.List;

class pq$2 implements Runnable {
    final /* synthetic */ pq DW;
    final /* synthetic */ List j6;

    pq$2(pq pqVar, List list) {
        this.DW = pqVar;
        this.j6 = list;
    }

    public void run() {
        this.DW.DW(this.j6);
    }
}
