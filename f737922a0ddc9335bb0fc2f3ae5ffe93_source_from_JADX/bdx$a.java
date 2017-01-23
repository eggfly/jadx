import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

class bdx$a {
    final Object DW;
    final String FH;
    final String Hw;
    final bdq Zo;
    final PrivateKey j6;
    final bdq v5;

    bef j6(SecureRandom secureRandom, Provider provider, boolean z) {
        String stringBuilder = new StringBuilder(String.valueOf(bdz.j6.j6(this.FH))).append("with").append(bdz.j6.DW(this.Hw)).toString();
        bei bei = new bei(new bha());
        if (z) {
            bei.j6(this.v5);
        }
        bei.j6(!z);
        bei.DW(this.Zo);
        try {
            bhc j6 = new bhc(stringBuilder).j6(secureRandom);
            if (provider != null) {
                j6.j6(provider);
            }
            bgq j62 = j6.j6(this.j6);
            if (this.DW instanceof X509Certificate) {
                return bei.j6(j62, (X509Certificate) this.DW);
            }
            return bei.j6(j62, (byte[]) this.DW);
        } catch (IllegalArgumentException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        }
    }
}
