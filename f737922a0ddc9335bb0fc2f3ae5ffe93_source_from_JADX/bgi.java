import java.io.IOException;
import java.security.Principal;

public class bgi extends bde implements Principal {
    private static ayw j6(aym aym) {
        try {
            return ayw.j6(aym.Hw());
        } catch (IllegalArgumentException e) {
            throw new IOException("not an ASN.1 Sequence: " + e);
        }
    }

    public bgi(byte[] bArr) {
        super(j6(new aym(bArr)));
    }

    public bgi(bcl bcl) {
        super((ayw) bcl.w_());
    }

    public String getName() {
        return toString();
    }

    public byte[] DW() {
        try {
            return j6("DER");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }
}
