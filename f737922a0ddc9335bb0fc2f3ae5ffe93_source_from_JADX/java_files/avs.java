import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

abstract class avs {
    static final avs j6;

    abstract void DW(HttpURLConnection httpURLConnection, String str);

    abstract InputStream j6(InputStream inputStream);

    abstract OutputStream j6(OutputStream outputStream);

    abstract void j6(HttpURLConnection httpURLConnection, String str);

    avs() {
    }

    static {
        j6 = new avs$a();
    }

    protected void j6(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        Object headerField = httpURLConnection.getHeaderField(new StringBuilder(String.valueOf(str)).append("jets3t-crypto-ver").toString());
        if (headerField == null) {
            headerField = "";
        }
        if (str2.equals(headerField)) {
            String headerField2 = httpURLConnection.getHeaderField(new StringBuilder(String.valueOf(str)).append("jets3t-crypto-alg").toString());
            if (headerField2 == null) {
                headerField2 = "";
            }
            if (!str3.equals(headerField2)) {
                throw new IOException(new StringBuilder(String.valueOf(JGitText.j6().unsupportedEncryptionAlgorithm)).append(headerField2).toString());
            }
            return;
        }
        throw new IOException(MessageFormat.format(JGitText.j6().unsupportedEncryptionVersion, new Object[]{headerField}));
    }

    IOException j6(Throwable th) {
        IOException iOException = new IOException(MessageFormat.format(JGitText.j6().encryptionError, new Object[]{th.getMessage()}));
        iOException.initCause(th);
        return iOException;
    }
}
