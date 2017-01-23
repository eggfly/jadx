import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class axt extends OutputStream {
    private final axn DW;
    private int FH;
    private final OutputStream j6;

    public axt(OutputStream outputStream, axn axn) {
        this.j6 = outputStream;
        this.DW = axn;
    }

    public void j6(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidTimeout, new Object[]{Integer.valueOf(i)}));
        }
        this.FH = i;
    }

    public void write(int i) {
        try {
            j6();
            this.j6.write(i);
            DW();
        } catch (InterruptedIOException e) {
            throw FH();
        } catch (Throwable th) {
            DW();
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            j6();
            this.j6.write(bArr, i, i2);
            DW();
        } catch (InterruptedIOException e) {
            throw FH();
        } catch (Throwable th) {
            DW();
        }
    }

    public void flush() {
        try {
            j6();
            this.j6.flush();
            DW();
        } catch (InterruptedIOException e) {
            throw FH();
        } catch (Throwable th) {
            DW();
        }
    }

    public void close() {
        try {
            j6();
            this.j6.close();
            DW();
        } catch (InterruptedIOException e) {
            throw FH();
        } catch (Throwable th) {
            DW();
        }
    }

    private void j6() {
        this.DW.j6(this.FH);
    }

    private void DW() {
        this.DW.j6();
    }

    private static InterruptedIOException FH() {
        return new InterruptedIOException(JGitText.j6().writeTimedOut);
    }
}
