import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public final class axn {
    private final axn$a DW;
    private final axn$b FH;
    final axn$c j6;

    public axn() {
        this("JGit-InterruptTimer");
    }

    public axn(String str) {
        this.DW = new axn$a();
        this.j6 = new axn$c(this.DW);
        this.FH = new axn$b(str, this.DW);
        this.FH.start();
    }

    public void j6(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidTimeout, new Object[]{Integer.valueOf(i)}));
        }
        Thread.interrupted();
        this.DW.j6(i);
    }

    public void j6() {
        this.DW.j6();
    }

    public void DW() {
        this.DW.DW();
        try {
            this.FH.join();
        } catch (InterruptedException e) {
        }
    }
}
