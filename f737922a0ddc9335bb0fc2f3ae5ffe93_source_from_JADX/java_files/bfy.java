import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;

public class bfy implements bfw {
    protected final Provider j6;

    public bfy(Provider provider) {
        this.j6 = provider;
    }

    public MessageDigest j6(String str) {
        return MessageDigest.getInstance(str, this.j6);
    }

    public Signature DW(String str) {
        return Signature.getInstance(str, this.j6);
    }
}
