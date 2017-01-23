package org.spongycastle.jcajce.provider.asymmetric.dh;

import ayh;
import ayn;
import ayq;
import ayw;
import bag;
import bcd;
import bce;
import bcf;
import bcp;
import bdh;
import bdj;
import bfp;
import bgb;
import bgj;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

public class BCDHPrivateKey implements bgj, DHPrivateKey {
    private transient DHParameterSpec DW;
    private transient bcf FH;
    private transient bgb Hw;
    private BigInteger j6;

    protected BCDHPrivateKey() {
        this.Hw = new bgb();
    }

    BCDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.Hw = new bgb();
        this.j6 = dHPrivateKey.getX();
        this.DW = dHPrivateKey.getParams();
    }

    BCDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.Hw = new bgb();
        this.j6 = dHPrivateKeySpec.getX();
        this.DW = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public BCDHPrivateKey(bcf bcf) {
        this.Hw = new bgb();
        Object j6 = ayw.j6(bcf.FH().v5());
        ayn ayn = (ayn) bcf.Hw();
        ayq FH = bcf.FH().FH();
        this.FH = bcf;
        this.j6 = ayn.FH();
        if (FH.equals(bce.XL)) {
            bcd j62 = bcd.j6(j6);
            if (j62.v5() != null) {
                this.DW = new DHParameterSpec(j62.FH(), j62.Hw(), j62.v5().intValue());
            } else {
                this.DW = new DHParameterSpec(j62.FH(), j62.Hw());
            }
        } else if (FH.equals(bdj.br)) {
            bdh j63 = bdh.j6(j6);
            this.DW = new DHParameterSpec(j63.FH().FH(), j63.Hw().FH());
        } else {
            throw new IllegalArgumentException("unknown algorithm type: " + FH);
        }
    }

    BCDHPrivateKey(bfp bfp) {
        this.Hw = new bgb();
        this.j6 = bfp.FH();
        this.DW = new DHParameterSpec(bfp.DW().j6(), bfp.DW().DW(), bfp.DW().v5());
    }

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] getEncoded() {
        try {
            if (this.FH != null) {
                return this.FH.j6("DER");
            }
            return new bcf(new bcp(bce.XL, new bcd(this.DW.getP(), this.DW.getG(), this.DW.getL()).w_()), new ayn(getX())).j6("DER");
        } catch (Exception e) {
            return null;
        }
    }

    public DHParameterSpec getParams() {
        return this.DW;
    }

    public BigInteger getX() {
        return this.j6;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        if (getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public void setBagAttribute(ayq ayq, ayh ayh) {
        this.Hw.j6(ayq, ayh);
    }

    public ayh getBagAttribute(bag bag) {
        return this.Hw.j6(bag);
    }

    public Enumeration getBagAttributeKeys() {
        return this.Hw.j6();
    }
}
