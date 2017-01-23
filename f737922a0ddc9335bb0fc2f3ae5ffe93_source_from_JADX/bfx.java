import java.security.MessageDigest;
import java.security.Signature;

public class bfx implements bfw {
    protected final String j6;

    public bfx(String str) {
        this.j6 = str;
    }

    public MessageDigest j6(String str) {
        return MessageDigest.getInstance(str, this.j6);
    }

    public Signature DW(String str) {
        return Signature.getInstance(str, this.j6);
    }
}
