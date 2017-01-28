import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

protected abstract class awd$a {
    byte[] DW;
    int FH;

    public abstract String DW();

    public abstract long FH();

    public abstract long Hw();

    public abstract anl j6();

    public abstract InputStream v5();

    protected awd$a() {
    }

    void j6(CharsetEncoder charsetEncoder) {
        try {
            ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(DW()));
            this.FH = encode.limit();
            if (encode.hasArray() && encode.arrayOffset() == 0) {
                this.DW = encode.array();
                return;
            }
            byte[] bArr = new byte[this.FH];
            this.DW = bArr;
            encode.get(bArr);
        } catch (CharacterCodingException e) {
            throw new RuntimeException(MessageFormat.format(JGitText.j6().unencodeableFile, new Object[]{DW()}));
        }
    }

    public String toString() {
        return new StringBuilder(String.valueOf(j6().toString())).append(" ").append(DW()).toString();
    }
}
