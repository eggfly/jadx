package org.spongycastle.jcajce.provider.asymmetric.dh;

import bcd;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    DHParameterSpec j6;

    protected boolean j6(String str) {
        return str == null || str.equals("ASN.1");
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return j6(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    protected byte[] engineGetEncoded() {
        try {
            return new bcd(this.j6.getP(), this.j6.getG(), this.j6.getL()).j6("DER");
        } catch (IOException e) {
            throw new RuntimeException("Error encoding DHParameters");
        }
    }

    protected byte[] engineGetEncoded(String str) {
        if (j6(str)) {
            return engineGetEncoded();
        }
        return null;
    }

    protected AlgorithmParameterSpec j6(Class cls) {
        if (cls == DHParameterSpec.class) {
            return this.j6;
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            this.j6 = (DHParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
    }

    protected void engineInit(byte[] bArr) {
        try {
            bcd j6 = bcd.j6(bArr);
            if (j6.v5() != null) {
                this.j6 = new DHParameterSpec(j6.FH(), j6.Hw(), j6.v5().intValue());
            } else {
                this.j6 = new DHParameterSpec(j6.FH(), j6.Hw());
            }
        } catch (ClassCastException e) {
            throw new IOException("Not a valid DH Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IOException("Not a valid DH Parameter encoding.");
        }
    }

    protected void engineInit(byte[] bArr, String str) {
        if (j6(str)) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format " + str);
    }

    protected String engineToString() {
        return "Diffie-Hellman Parameters";
    }
}
