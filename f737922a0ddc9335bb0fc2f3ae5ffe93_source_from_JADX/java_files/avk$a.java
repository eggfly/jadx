import java.io.BufferedInputStream;
import java.io.Writer;

class avk$a extends ati {
    final /* synthetic */ avk QX;
    private Process XL;
    private Thread aM;

    avk$a(avk avk) {
        this.QX = avk;
        super(avk);
        Writer axo = new axo();
        j6(axo);
        this.XL = avk.FH(avk.v5());
        this.aM = new axq(this.XL.getErrorStream(), axo.j6());
        this.aM.start();
        j6(new BufferedInputStream(this.XL.getInputStream()), new axp(this.XL.getOutputStream()));
        VH();
    }

    public void u7() {
        super.u7();
        if (this.XL != null) {
            try {
                this.XL.waitFor();
            } catch (InterruptedException e) {
            } finally {
                this.XL = null;
            }
        }
        if (this.aM != null) {
            try {
                this.aM.join();
            } catch (InterruptedException e2) {
            } finally {
                this.aM = null;
            }
        }
    }
}
