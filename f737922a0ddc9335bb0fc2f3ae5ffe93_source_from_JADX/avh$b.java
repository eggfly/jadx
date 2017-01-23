import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import org.eclipse.jgit.JGitText;

class avh$b extends atj {
    final /* synthetic */ avh J0;
    private Socket J8;

    avh$b(avh avh) {
        this.J0 = avh;
        super(avh);
        this.J8 = avh.j6();
        try {
            j6(new BufferedInputStream(this.J8.getInputStream()), new axp(this.J8.getOutputStream()));
            avh.j6("git-receive-pack", this.u7);
            VH();
        } catch (Throwable e) {
            u7();
            throw new amb(this.DW, JGitText.j6().remoteHungUpUnexpectedly, e);
        }
    }

    public void u7() {
        super.u7();
        if (this.J8 != null) {
            try {
                this.J8.close();
            } catch (IOException e) {
            } finally {
                this.J8 = null;
            }
        }
    }
}
