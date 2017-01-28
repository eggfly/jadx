import java.security.MessageDigest;
import java.security.PrivateKey;
import javax.crypto.Cipher;

public class ahk {
    byte[] DW;
    byte[] FH;
    Cipher Hw;
    byte[] j6;
    MessageDigest v5;

    public ahk() {
        this.j6 = new byte[]{(byte) 48, (byte) 33};
        this.DW = new byte[]{(byte) 48, (byte) 9, (byte) 6, (byte) 5, (byte) 43, (byte) 14, (byte) 3, (byte) 2, (byte) 26, (byte) 5, (byte) 0};
        this.FH = new byte[]{(byte) 4, (byte) 20};
        this.v5 = MessageDigest.getInstance("SHA1");
        this.Hw = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }

    public void j6(PrivateKey privateKey) {
        this.Hw.init(1, privateKey);
    }

    public void j6(byte[] bArr) {
        this.v5.update(bArr);
    }

    public byte[] j6() {
        this.Hw.update(this.j6);
        this.Hw.update(this.DW);
        this.Hw.update(this.FH);
        this.Hw.update(this.v5.digest());
        return this.Hw.doFinal();
    }
}
