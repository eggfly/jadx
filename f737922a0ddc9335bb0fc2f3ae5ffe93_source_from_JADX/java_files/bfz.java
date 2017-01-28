import java.io.IOException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public abstract class bfz extends KeyFactorySpi implements bgh {
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return generatePrivate(bcf.j6(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            } catch (IOException e) {
                throw new InvalidKeySpecException("encoded key spec not recognised");
            }
        }
        throw new InvalidKeySpecException("key spec not recognised");
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return generatePublic(bcv.j6(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (IOException e) {
                throw new InvalidKeySpecException("encoded key spec not recognised");
            }
        }
        throw new InvalidKeySpecException("key spec not recognised");
    }

    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        throw new InvalidKeySpecException("not implemented yet " + key + " " + cls);
    }
}
