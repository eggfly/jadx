package org.spongycastle.jcajce.provider.asymmetric.dh;

import ayq;
import bce;
import bcf;
import bcv;
import bdj;
import bfz;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;

public class KeyFactorySpi extends bfz {
    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
        }
    }

    protected Key engineTranslateKey(Key key) {
        if (key instanceof DHPublicKey) {
            return new BCDHPublicKey((DHPublicKey) key);
        }
        if (key instanceof DHPrivateKey) {
            return new BCDHPrivateKey((DHPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof DHPrivateKeySpec) {
            return new BCDHPrivateKey((DHPrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof DHPublicKeySpec) {
            return new BCDHPublicKey((DHPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }

    public PrivateKey generatePrivate(bcf bcf) {
        ayq FH = bcf.FH().FH();
        if (FH.equals(bce.XL)) {
            return new BCDHPrivateKey(bcf);
        }
        if (FH.equals(bdj.br)) {
            return new BCDHPrivateKey(bcf);
        }
        throw new IOException("algorithm identifier " + FH + " in key not recognised");
    }

    public PublicKey generatePublic(bcv bcv) {
        ayq FH = bcv.FH().FH();
        if (FH.equals(bce.XL)) {
            return new BCDHPublicKey(bcv);
        }
        if (FH.equals(bdj.br)) {
            return new BCDHPublicKey(bcv);
        }
        throw new IOException("algorithm identifier " + FH + " in key not recognised");
    }
}
