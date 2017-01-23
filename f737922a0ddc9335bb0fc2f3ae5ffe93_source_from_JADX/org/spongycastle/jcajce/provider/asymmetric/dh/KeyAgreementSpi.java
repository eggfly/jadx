package org.spongycastle.jcajce.provider.asymmetric.dh;

import bfl;
import bhl;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable v5;
    private BigInteger DW;
    private BigInteger FH;
    private BigInteger Hw;
    private BigInteger j6;

    static {
        v5 = new Hashtable();
        Integer num = new Integer(64);
        Integer num2 = new Integer(192);
        Integer num3 = new Integer(128);
        Integer num4 = new Integer(256);
        v5.put("DES", num);
        v5.put("DESEDE", num2);
        v5.put("BLOWFISH", num3);
        v5.put("AES", num4);
    }

    private byte[] j6(BigInteger bigInteger) {
        Object toByteArray = bigInteger.toByteArray();
        if (toByteArray[0] != null) {
            return toByteArray;
        }
        Object obj = new byte[(toByteArray.length - 1)];
        System.arraycopy(toByteArray, 1, obj, 0, obj.length);
        return obj;
    }

    protected Key engineDoPhase(Key key, boolean z) {
        if (this.j6 == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.FH) || !dHPublicKey.getParams().getP().equals(this.DW)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            } else if (z) {
                this.Hw = ((DHPublicKey) key).getY().modPow(this.j6, this.DW);
                return null;
            } else {
                this.Hw = ((DHPublicKey) key).getY().modPow(this.j6, this.DW);
                return new BCDHPublicKey(this.Hw, dHPublicKey.getParams());
            }
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    protected byte[] engineGenerateSecret() {
        if (this.j6 != null) {
            return j6(this.Hw);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    protected int engineGenerateSecret(byte[] bArr, int i) {
        if (this.j6 == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        Object j6 = j6(this.Hw);
        if (bArr.length - i < j6.length) {
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        System.arraycopy(j6, 0, bArr, i, j6.length);
        return j6.length;
    }

    protected SecretKey engineGenerateSecret(String str) {
        if (this.j6 == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        String j6 = bhl.j6(str);
        Object j62 = j6(this.Hw);
        if (!v5.containsKey(j6)) {
            return new SecretKeySpec(j62, str);
        }
        Object obj = new byte[(((Integer) v5.get(j6)).intValue() / 8)];
        System.arraycopy(j62, 0, obj, 0, obj.length);
        if (j6.startsWith("DES")) {
            bfl.j6(obj);
        }
        return new SecretKeySpec(obj, str);
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.DW = dHPrivateKey.getParams().getP();
                this.FH = dHPrivateKey.getParams().getG();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.DW = dHParameterSpec.getP();
                this.FH = dHParameterSpec.getG();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            BigInteger x = dHPrivateKey.getX();
            this.Hw = x;
            this.j6 = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    protected void engineInit(Key key, SecureRandom secureRandom) {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.DW = dHPrivateKey.getParams().getP();
            this.FH = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.Hw = x;
            this.j6 = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
