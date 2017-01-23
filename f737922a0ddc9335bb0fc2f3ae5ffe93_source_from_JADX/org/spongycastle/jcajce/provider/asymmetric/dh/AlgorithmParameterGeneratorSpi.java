package org.spongycastle.jcajce.provider.asymmetric.dh;

import bfi;
import bfo;
import bgk;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public class AlgorithmParameterGeneratorSpi extends java.security.AlgorithmParameterGeneratorSpi {
    protected int DW;
    private int FH;
    protected SecureRandom j6;

    public AlgorithmParameterGeneratorSpi() {
        this.DW = 1024;
        this.FH = 0;
    }

    protected void engineInit(int i, SecureRandom secureRandom) {
        this.DW = i;
        this.j6 = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.DW = dHGenParameterSpec.getPrimeSize();
            this.FH = dHGenParameterSpec.getExponentSize();
            this.j6 = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }

    protected AlgorithmParameters engineGenerateParameters() {
        bfi bfi = new bfi();
        if (this.j6 != null) {
            bfi.j6(this.DW, 20, this.j6);
        } else {
            bfi.j6(this.DW, 20, new SecureRandom());
        }
        bfo j6 = bfi.j6();
        try {
            AlgorithmParameters instance = AlgorithmParameters.getInstance("DH", bgk.j6);
            instance.init(new DHParameterSpec(j6.j6(), j6.DW(), this.FH));
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
