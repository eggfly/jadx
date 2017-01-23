import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class ahg {
    X509Certificate DW;
    PrivateKey FH;
    byte[] Hw;
    String j6;

    public ahg() {
        this.DW = null;
        this.FH = null;
        this.Hw = null;
    }

    public ahg(String str, X509Certificate x509Certificate, PrivateKey privateKey, byte[] bArr) {
        this.DW = null;
        this.FH = null;
        this.Hw = null;
        this.j6 = str;
        this.DW = x509Certificate;
        this.FH = privateKey;
        this.Hw = bArr;
    }

    public String j6() {
        return this.j6;
    }

    public void j6(String str) {
        this.j6 = str;
    }

    public X509Certificate DW() {
        return this.DW;
    }

    public void j6(X509Certificate x509Certificate) {
        this.DW = x509Certificate;
    }

    public PrivateKey FH() {
        return this.FH;
    }

    public void j6(PrivateKey privateKey) {
        this.FH = privateKey;
    }

    public byte[] Hw() {
        return this.Hw;
    }

    public void j6(byte[] bArr) {
        this.Hw = bArr;
    }
}
