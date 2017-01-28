import java.io.Writer;
import org.eclipse.jgit.JGitText;

class avi$c extends atj {
    final /* synthetic */ avi J0;
    private final Process J8;
    private axq Ws;

    avi$c(avi avi) {
        this.J0 = avi;
        super(avi);
        try {
            this.J8 = avi.j6().j6(avi.FH(avi.u7()), avi.J0());
            Writer axo = new axo();
            j6(axo);
            this.Ws = new axq(this.J8.getErrorStream(), axo.j6());
            this.Ws.start();
            j6(this.J8.getInputStream(), this.J8.getOutputStream());
            try {
                VH();
            } catch (alk e) {
                String FH = FH();
                avi.j6(this.J8.exitValue(), avi.u7(), FH);
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
        if (this.Ws != null) {
            try {
                this.Ws.DW();
            } catch (InterruptedException e) {
            } finally {
                this.Ws = null;
            }
        }
        super.u7();
        if (this.J8 != null) {
            this.J8.destroy();
        }
    }
}
