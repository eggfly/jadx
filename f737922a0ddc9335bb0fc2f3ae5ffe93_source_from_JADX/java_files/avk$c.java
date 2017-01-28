import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import org.eclipse.jgit.JGitText;

class avk$c extends ati {
    final /* synthetic */ avk QX;
    private Thread XL;

    avk$c(avk avk) {
        this.QX = avk;
        super(avk);
        try {
            aoh arc = new arc(avk.Zo);
            try {
                InputStream pipedInputStream = new PipedInputStream();
                PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
                PipedInputStream avk_c_1 = new avk$c$1(this);
                OutputStream pipedOutputStream2 = new PipedOutputStream(avk_c_1);
                this.XL = new avk$c$2(this, "JGit-Upload-Pack", avk_c_1, pipedOutputStream, arc);
                this.XL.start();
                j6(pipedInputStream, pipedOutputStream2);
                VH();
            } catch (Throwable e) {
                arc.tp();
                throw new amb(this.DW, JGitText.j6().cannotConnectPipes, e);
            }
        } catch (IOException e2) {
            throw new amb(this.DW, JGitText.j6().notAGitDirectory);
        }
    }

    public void u7() {
        super.u7();
        if (this.XL != null) {
            try {
                this.XL.join();
            } catch (InterruptedException e) {
            } finally {
                this.XL = null;
            }
        }
    }
}
