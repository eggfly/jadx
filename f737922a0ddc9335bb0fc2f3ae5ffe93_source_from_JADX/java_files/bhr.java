import java.security.cert.CertificateEncodingException;

class bhr extends CertificateEncodingException {
    Throwable j6;

    bhr(String str, Throwable th) {
        super(str);
        this.j6 = th;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
