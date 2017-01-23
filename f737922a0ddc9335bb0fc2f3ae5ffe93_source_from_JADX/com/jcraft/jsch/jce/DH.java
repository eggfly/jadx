package com.jcraft.jsch.jce;

import bgk;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class DH implements com.jcraft.jsch.DH {
    BigInteger DW;
    BigInteger FH;
    byte[] Hw;
    byte[] VH;
    BigInteger Zo;
    private KeyPairGenerator gn;
    BigInteger j6;
    private KeyAgreement u7;
    BigInteger v5;

    public void j6() {
        Security.addProvider(new bgk());
        this.gn = KeyPairGenerator.getInstance("DH", "SC");
        this.u7 = KeyAgreement.getInstance("DH", "SC");
    }

    public byte[] DW() {
        if (this.FH == null) {
            this.gn.initialize(new DHParameterSpec(this.j6, this.DW));
            KeyPair generateKeyPair = this.gn.generateKeyPair();
            this.u7.init(generateKeyPair.getPrivate());
            generateKeyPair.getPublic().getEncoded();
            this.FH = ((DHPublicKey) generateKeyPair.getPublic()).getY();
            this.Hw = this.FH.toByteArray();
        }
        return this.Hw;
    }

    public byte[] FH() {
        if (this.Zo == null) {
            this.u7.doPhase(KeyFactory.getInstance("DH").generatePublic(new DHPublicKeySpec(this.v5, this.j6, this.DW)), true);
            byte[] generateSecret = this.u7.generateSecret();
            this.Zo = new BigInteger(generateSecret);
            this.VH = this.Zo.toByteArray();
            this.VH = generateSecret;
        }
        return this.VH;
    }

    public void j6(byte[] bArr) {
        j6(new BigInteger(bArr));
    }

    public void DW(byte[] bArr) {
        DW(new BigInteger(bArr));
    }

    public void FH(byte[] bArr) {
        FH(new BigInteger(bArr));
    }

    void j6(BigInteger bigInteger) {
        this.j6 = bigInteger;
    }

    void DW(BigInteger bigInteger) {
        this.DW = bigInteger;
    }

    void FH(BigInteger bigInteger) {
        this.v5 = bigInteger;
    }
}
