import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ara extends aol {
    private final awp DW;
    private volatile are FH;
    private volatile ans Hw;
    private final File j6;

    public ara(File file, awp awp) {
        this(null, file, awp);
    }

    public ara(ani ani, File file, awp awp) {
        super(ani);
        this.j6 = file;
        this.DW = awp;
        this.FH = are.j6;
        this.Hw = ans.Zo();
    }

    protected boolean j6() {
        return false;
    }

    public final File Zo() {
        return this.j6;
    }

    public void VH() {
        are are = this.FH;
        are j6 = are.j6(Zo());
        try {
            byte[] j62 = awx.j6(Zo());
            anb j63 = j6(j62);
            if (!this.Hw.DW(j63)) {
                j6(axe.DW(j62));
                this.FH = j6;
                this.Hw = j63;
            } else if (are.DW(j6)) {
                are.j6(j6);
            } else {
                this.FH = j6;
            }
        } catch (FileNotFoundException e) {
            Hw();
            this.FH = j6;
        } catch (Throwable e2) {
            IOException iOException = new IOException(MessageFormat.format(JGitText.j6().cannotReadFile, new Object[]{Zo()}));
            iOException.initCause(e2);
            throw iOException;
        } catch (Throwable e22) {
            throw new akz(MessageFormat.format(JGitText.j6().cannotReadFile, new Object[]{Zo()}), e22);
        }
    }

    public void v5() {
        byte[] DW = anj.DW(FH());
        ark ark = new ark(Zo(), this.DW);
        if (ark.j6()) {
            try {
                ark.DW(true);
                ark.j6(DW);
                if (ark.Hw()) {
                    this.FH = ark.v5();
                    this.Hw = j6(DW);
                    DW();
                    return;
                }
                throw new IOException(MessageFormat.format(JGitText.j6().cannotCommitWriteTo, new Object[]{Zo()}));
            } finally {
                ark.Zo();
            }
        } else {
            throw new alg(Zo());
        }
    }

    public void Hw() {
        this.Hw = j6(new byte[0]);
        super.Hw();
    }

    private static ans j6(byte[] bArr) {
        return ans.j6(anj.j6().digest(bArr));
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("[").append(Zo().getPath()).append("]").toString();
    }

    public boolean gn() {
        return this.FH.DW(Zo());
    }
}
