package org.spongycastle.jcajce.provider.asymmetric.dh;

import ayn;
import ayq;
import ayw;
import bad;
import bcd;
import bce;
import bcp;
import bcv;
import bdh;
import bdj;
import bfq;
import bga;
import java.io.IOException;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class BCDHPublicKey implements DHPublicKey {
    private transient DHParameterSpec DW;
    private transient bcv FH;
    private BigInteger j6;

    BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.j6 = dHPublicKeySpec.getY();
        this.DW = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.j6 = dHPublicKey.getY();
        this.DW = dHPublicKey.getParams();
    }

    BCDHPublicKey(bfq bfq) {
        this.j6 = bfq.FH();
        this.DW = new DHParameterSpec(bfq.DW().j6(), bfq.DW().DW(), bfq.DW().v5());
    }

    BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.j6 = bigInteger;
        this.DW = dHParameterSpec;
    }

    public BCDHPublicKey(bcv bcv) {
        this.FH = bcv;
        try {
            this.j6 = ((ayn) bcv.Hw()).FH();
            Object j6 = ayw.j6(bcv.FH().v5());
            ayq FH = bcv.FH().FH();
            if (FH.equals(bce.XL) || j6(j6)) {
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
        } catch (IOException e) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] getEncoded() {
        if (this.FH != null) {
            return bga.j6(this.FH);
        }
        return bga.j6(new bcp(bce.XL, new bcd(this.DW.getP(), this.DW.getG(), this.DW.getL()).w_()), new ayn(this.j6));
    }

    public DHParameterSpec getParams() {
        return this.DW;
    }

    public BigInteger getY() {
        return this.j6;
    }

    private boolean j6(ayw ayw) {
        if (ayw.v5() == 2) {
            return true;
        }
        if (ayw.v5() > 3) {
            return false;
        }
        if (bad.j6((Object) ayw.j6(2)).FH().compareTo(BigInteger.valueOf((long) bad.j6((Object) ayw.j6(0)).FH().bitLength())) > 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        if (getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL()) {
            return true;
        }
        return false;
    }
}
