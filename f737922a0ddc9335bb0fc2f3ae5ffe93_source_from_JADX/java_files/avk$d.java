import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import org.eclipse.jgit.JGitText;

class avk$d extends atj {
    final /* synthetic */ avk J0;
    private Thread J8;

    avk$d(avk avk) {
        this.J0 = avk;
        super(avk);
        try {
            aoh arc = new arc(avk.Zo);
            try {
                InputStream pipedInputStream = new PipedInputStream();
                PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
                PipedInputStream pipedInputStream2 = new PipedInputStream();
                OutputStream pipedOutputStream2 = new PipedOutputStream(pipedInputStream2);
                this.J8 = new avk$d$1(this, "JGit-Receive-Pack", pipedInputStream2, pipedOutputStream, arc);
                this.J8.start();
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
        if (this.J8 != null) {
            try {
                this.J8.join();
            } catch (InterruptedException e) {
            } finally {
                this.J8 = null;
            }
        }
    }
}
