import java.util.List;

class asy$3 implements Runnable {
    private final /* synthetic */ asq DW;
    private final /* synthetic */ List FH;
    final /* synthetic */ asy j6;

    asy$3(asy asy, asq asq, List list) {
        this.j6 = asy;
        this.DW = asq;
        this.FH = list;
    }

    public void run() {
        try {
            this.DW.call();
        } catch (Throwable th) {
            this.FH.add(th);
        }
    }
}
