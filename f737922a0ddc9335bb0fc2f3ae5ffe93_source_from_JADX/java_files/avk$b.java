import java.io.BufferedInputStream;
import java.io.Writer;

class avk$b extends atj {
    final /* synthetic */ avk J0;
    private Process J8;
    private Thread Ws;

    avk$b(avk avk) {
        this.J0 = avk;
        super(avk);
        Writer axo = new axo();
        j6(axo);
        this.J8 = avk.FH(avk.u7());
        this.Ws = new axq(this.J8.getErrorStream(), axo.j6());
        this.Ws.start();
        j6(new BufferedInputStream(this.J8.getInputStream()), new axp(this.J8.getOutputStream()));
        VH();
    }

    public void u7() {
        super.u7();
        if (this.J8 != null) {
            try {
                this.J8.waitFor();
            } catch (InterruptedException e) {
            } finally {
                this.J8 = null;
            }
        }
        if (this.Ws != null) {
            try {
                this.Ws.join();
            } catch (InterruptedException e2) {
            } finally {
                this.Ws = null;
            }
        }
    }
}
