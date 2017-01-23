package org.spongycastle.jcajce.provider.asymmetric.dh;

import bej;
import bfg;
import bfi;
import bfm;
import bfo;
import bfp;
import bfq;
import bgk;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    private static Hashtable VH;
    bfg DW;
    int FH;
    int Hw;
    boolean Zo;
    bfm j6;
    SecureRandom v5;

    static {
        VH = new Hashtable();
    }

    public KeyPairGeneratorSpi() {
        super("DH");
        this.DW = new bfg();
        this.FH = 1024;
        this.Hw = 20;
        this.v5 = new SecureRandom();
        this.Zo = false;
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.FH = i;
        this.v5 = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.j6 = new bfm(secureRandom, new bfo(dHParameterSpec.getP(), dHParameterSpec.getG(), null, dHParameterSpec.getL()));
            this.DW.j6(this.j6);
            this.Zo = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.Zo) {
            Integer num = new Integer(this.FH);
            if (VH.containsKey(num)) {
                this.j6 = (bfm) VH.get(num);
            } else {
                DHParameterSpec j6 = bgk.DW.j6();
                if (j6 == null || j6.getP().bitLength() != this.FH) {
                    bfi bfi = new bfi();
                    bfi.j6(this.FH, this.Hw, this.v5);
                    this.j6 = new bfm(this.v5, bfi.j6());
                    VH.put(num, this.j6);
                } else {
                    this.j6 = new bfm(this.v5, new bfo(j6.getP(), j6.getG(), null, j6.getL()));
                }
            }
            this.DW.j6(this.j6);
            this.Zo = true;
        }
        bej j62 = this.DW.j6();
        return new KeyPair(new BCDHPublicKey((bfq) j62.j6()), new BCDHPrivateKey((bfp) j62.DW()));
    }
}
