package org.spongycastle.jcajce.provider.asymmetric;

import bgc;
import bgg;

public class DH {

    public static class Mappings extends bgg {
        public void configure(bgc bgc) {
            bgc.j6("KeyPairGenerator.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi");
            bgc.j6("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
            bgc.j6("KeyAgreement.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi");
            bgc.j6("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
            bgc.j6("KeyFactory.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi");
            bgc.j6("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
            bgc.j6("AlgorithmParameters.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi");
            bgc.j6("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
            bgc.j6("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
            bgc.j6("AlgorithmParameterGenerator.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi");
        }
    }
}
