import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;

class bgp {
    private static final ayo j6;

    static {
        j6 = new bae();
    }

    static void j6(Signature signature, ayh ayh) {
        if (ayh != null && !j6.equals(ayh)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(ayh.w_().DW());
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e) {
                        throw new SignatureException("Exception extracting parameters: " + e.getMessage());
                    }
                }
            } catch (IOException e2) {
                throw new SignatureException("IOException decoding parameters: " + e2.getMessage());
            }
        }
    }

    static String j6(bcp bcp) {
        Object v5 = bcp.v5();
        if (!(v5 == null || j6.equals(v5))) {
            if (bcp.Hw().equals(bce.EQ)) {
                return new StringBuilder(String.valueOf(j6(bcg.j6(v5).FH().Hw()))).append("withRSAandMGF1").toString();
            }
            if (bcp.Hw().equals(bdj.we)) {
                return new StringBuilder(String.valueOf(j6((bag) ayw.j6(v5).j6(0)))).append("withECDSA").toString();
            }
        }
        return bcp.Hw().FH();
    }

    private static String j6(bag bag) {
        if (bce.SI.equals(bag)) {
            return "MD5";
        }
        if (bcc.u7.equals(bag)) {
            return "SHA1";
        }
        if (bca.v5.equals(bag)) {
            return "SHA224";
        }
        if (bca.DW.equals(bag)) {
            return "SHA256";
        }
        if (bca.FH.equals(bag)) {
            return "SHA384";
        }
        if (bca.Hw.equals(bag)) {
            return "SHA512";
        }
        if (bch.FH.equals(bag)) {
            return "RIPEMD128";
        }
        if (bch.DW.equals(bag)) {
            return "RIPEMD160";
        }
        if (bch.Hw.equals(bag)) {
            return "RIPEMD256";
        }
        if (bbs.j6.equals(bag)) {
            return "GOST3411";
        }
        return bag.FH();
    }
}
