import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ald extends IllegalArgumentException {
    public ald(byte[] bArr, int i, int i2) {
        super(MessageFormat.format(JGitText.j6().invalidId, new Object[]{j6(bArr, i, i2)}));
    }

    private static String j6(byte[] bArr, int i, int i2) {
        try {
            return ": " + new String(bArr, i, i2, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (StringIndexOutOfBoundsException e2) {
            return "";
        }
    }
}
