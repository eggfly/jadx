import java.security.cert.X509Certificate;

public class bdn extends bdl {
    public bdn(X509Certificate x509Certificate) {
        super(bcr.j6(x509Certificate.getEncoded()));
    }
}
