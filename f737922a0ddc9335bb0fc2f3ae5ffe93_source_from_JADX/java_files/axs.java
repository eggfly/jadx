import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class axs extends FilterInputStream {
    private int DW;
    private final axn j6;

    public axs(InputStream inputStream, axn axn) {
        super(inputStream);
        this.j6 = axn;
    }

    public int j6() {
        return this.DW;
    }

    public void j6(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidTimeout, new Object[]{Integer.valueOf(i)}));
        }
        this.DW = i;
    }

    public int read() {
        try {
            DW();
            int read = super.read();
            FH();
            return read;
        } catch (InterruptedIOException e) {
            throw Hw();
        } catch (Throwable th) {
            FH();
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            DW();
            int read = super.read(bArr, i, i2);
            FH();
            return read;
        } catch (InterruptedIOException e) {
            throw Hw();
        } catch (Throwable th) {
            FH();
        }
    }

    public long skip(long j) {
        try {
            DW();
            long skip = super.skip(j);
            FH();
            return skip;
        } catch (InterruptedIOException e) {
            throw Hw();
        } catch (Throwable th) {
            FH();
        }
    }

    private void DW() {
        this.j6.j6(this.DW);
    }

    private void FH() {
        this.j6.j6();
    }

    private static InterruptedIOException Hw() {
        return new InterruptedIOException(JGitText.j6().readTimedOut);
    }
}
