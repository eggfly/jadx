import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public abstract class arp implements Iterable<arp$b> {
    protected byte[] j6;

    public abstract long DW();

    public abstract long DW(anb anb);

    public abstract long FH(anb anb);

    public abstract boolean FH();

    public abstract Iterator<arp$b> iterator();

    public abstract long j6();

    public abstract ans j6(long j);

    public abstract void j6(Set<ans> set, amz amz, int i);

    public static arp j6(File file) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            arp j6 = j6(fileInputStream);
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
            return j6;
        } catch (Throwable e2) {
            String absolutePath = file.getAbsolutePath();
            IOException iOException = new IOException(MessageFormat.format(JGitText.j6().unreadablePackIndex, new Object[]{absolutePath}));
            iOException.initCause(e2);
            throw iOException;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e3) {
            }
        }
    }

    public static arp j6(InputStream inputStream) {
        byte[] bArr = new byte[8];
        awx.j6(inputStream, bArr, 0, bArr.length);
        if (!j6(bArr)) {
            return new arq(inputStream, bArr);
        }
        switch (axb.DW(bArr, 4)) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return new arr(inputStream);
            default:
                throw new IOException(MessageFormat.format(JGitText.j6().unsupportedPackIndexVersion, new Object[]{Integer.valueOf(r0)}));
        }
    }

    private static boolean j6(byte[] bArr) {
        byte[] bArr2 = ars.j6;
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean j6(anb anb) {
        return DW(anb) != -1;
    }

    public final ans j6(int i) {
        if (i >= 0) {
            return j6((long) i);
        }
        return j6(((long) (i & 1)) | (((long) (i >>> 1)) << 1));
    }
}
