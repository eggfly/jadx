import java.security.MessageDigest;
import java.security.Signature;

public class bfv implements bfw {
    public MessageDigest j6(String str) {
        return MessageDigest.getInstance(str);
    }

    public Signature DW(String str) {
        return Signature.getInstance(str);
    }
}
