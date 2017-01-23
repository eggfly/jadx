import java.io.Writer;
import org.eclipse.jgit.JGitText;

class avi$b extends ati {
    final /* synthetic */ avi QX;
    private final Process XL;
    private axq aM;

    avi$b(avi avi) {
        this.QX = avi;
        super(avi);
        try {
            this.XL = avi.j6().j6(avi.FH(avi.v5()), avi.J0());
            Writer axo = new axo();
            j6(axo);
            this.aM = new axq(this.XL.getErrorStream(), axo.j6());
            this.aM.start();
            j6(this.XL.getInputStream(), this.XL.getOutputStream());
            try {
                VH();
            } catch (alk e) {
                String FH = FH();
                avi.j6(this.XL.exitValue(), avi.v5(), FH);
                throw avi.j6(e, FH);
            }
        } catch (amb e2) {
            u7();
            throw e2;
        } catch (Throwable e3) {
            u7();
            throw new amb(this.DW, JGitText.j6().remoteHungUpUnexpectedly, e3);
        }
    }

    public void u7() {
        tp();
        if (this.aM != null) {
            try {
                this.aM.DW();
            } catch (InterruptedException e) {
            } finally {
                this.aM = null;
            }
        }
        super.u7();
        if (this.XL != null) {
            this.XL.destroy();
        }
    }
}
