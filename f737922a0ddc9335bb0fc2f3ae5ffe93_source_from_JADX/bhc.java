import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;

public class bhc {
    private SecureRandom DW;
    private String FH;
    private bcp Hw;
    private bhe j6;

    public bhc(String str) {
        this.j6 = new bhe(new bfv());
        this.FH = str;
        this.Hw = new bgs().j6(str);
    }

    public bhc j6(Provider provider) {
        this.j6 = new bhe(new bfy(provider));
        return this;
    }

    public bhc j6(SecureRandom secureRandom) {
        this.DW = secureRandom;
        return this;
    }

    public bgq j6(PrivateKey privateKey) {
        try {
            Signature DW = this.j6.DW(this.Hw);
            if (this.DW != null) {
                DW.initSign(privateKey, this.DW);
            } else {
                DW.initSign(privateKey);
            }
            return new bhc$1(this, DW);
        } catch (Throwable e) {
            throw new bgw("cannot create signer: " + e.getMessage(), e);
        }
    }
}
