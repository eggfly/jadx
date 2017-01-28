import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import org.eclipse.jgit.JGitText;

class avh$a extends ati {
    final /* synthetic */ avh QX;
    private Socket XL;

    avh$a(avh avh) {
        this.QX = avh;
        super(avh);
        this.XL = avh.j6();
        try {
            j6(new BufferedInputStream(this.XL.getInputStream()), new axp(this.XL.getOutputStream()));
            avh.j6("git-upload-pack", this.u7);
            VH();
        } catch (Throwable e) {
            u7();
            throw new amb(this.DW, JGitText.j6().remoteHungUpUnexpectedly, e);
        }
    }

    public void u7() {
        super.u7();
        if (this.XL != null) {
            try {
                this.XL.close();
            } catch (IOException e) {
            } finally {
                this.XL = null;
            }
        }
    }
}
