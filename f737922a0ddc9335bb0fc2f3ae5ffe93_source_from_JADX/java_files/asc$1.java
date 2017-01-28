import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import org.eclipse.jgit.JGitText;

class asc$1 extends InflaterInputStream {
    private final /* synthetic */ ans DW;
    private long j6;

    asc$1(InputStream inputStream, Inflater inflater, long j, ans ans) {
        this.DW = ans;
        super(inputStream, inflater);
        this.j6 = j;
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            int read = super.read(bArr, i, i2);
            if (read > 0) {
                this.j6 -= (long) read;
            }
            return read;
        } catch (ZipException e) {
            throw new ala(this.DW, JGitText.j6().corruptObjectBadStream);
        }
    }

    public void close() {
        try {
            if (this.j6 <= 0) {
                asc.DW(this.in, this.inf, this.DW, new byte[64]);
            }
            ann.j6(this.inf);
            super.close();
        } catch (Throwable th) {
            ann.j6(this.inf);
            super.close();
        }
    }
}
