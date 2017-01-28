import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public class bht {
    private bag DW;
    private bcp FH;
    private String Hw;
    private bcz j6;
    private bdd v5;

    public bht() {
        this.j6 = new bcz();
        this.v5 = new bdd();
    }

    public void j6(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("serial number must be a positive integer");
        }
        this.j6.j6(new ayn(bigInteger));
    }

    public void j6(X500Principal x500Principal) {
        try {
            this.j6.j6(new bgi(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public void j6(Date date) {
        this.j6.j6(new bcy(date));
    }

    public void DW(Date date) {
        this.j6.DW(new bcy(date));
    }

    public void DW(X500Principal x500Principal) {
        try {
            this.j6.DW(new bgi(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public void j6(PublicKey publicKey) {
        try {
            this.j6.j6(bcv.j6(new aym(publicKey.getEncoded()).Hw()));
        } catch (Exception e) {
            throw new IllegalArgumentException("unable to process key - " + e.toString());
        }
    }

    public void j6(String str) {
        this.Hw = str;
        try {
            this.DW = bhs.j6(str);
            this.FH = bhs.j6(this.DW, str);
            this.j6.j6(this.FH);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown signature type requested: " + str);
        }
    }

    public X509Certificate j6(PrivateKey privateKey, String str) {
        return j6(privateKey, str, null);
    }

    public X509Certificate j6(PrivateKey privateKey, String str, SecureRandom secureRandom) {
        bcw j6 = j6();
        try {
            try {
                return j6(j6, bhs.j6(this.DW, this.Hw, str, privateKey, secureRandom, j6));
            } catch (Throwable e) {
                throw new bhr("exception producing certificate object", e);
            }
        } catch (Throwable e2) {
            throw new bhr("exception encoding TBS cert", e2);
        }
    }

    private bcw j6() {
        if (!this.v5.j6()) {
            this.j6.j6(this.v5.DW());
        }
        return this.j6.j6();
    }

    private X509Certificate j6(bcw bcw, byte[] bArr) {
        ayi ayi = new ayi();
        ayi.j6((ayh) bcw);
        ayi.j6(this.FH);
        ayi.j6(new azu(bArr));
        return new bgo(new bda(new bal(ayi)));
    }
}
