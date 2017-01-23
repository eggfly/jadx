import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;

class bhe {
    private static final Map DW;
    private static final Map FH;
    private static final Map Hw;
    private static final Map j6;
    private bfw v5;

    static {
        j6 = new HashMap();
        DW = new HashMap();
        FH = new HashMap();
        Hw = new HashMap();
        j6.put(new ayq("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        j6.put(bce.j_, "SHA224WITHRSA");
        j6.put(bce.g_, "SHA256WITHRSA");
        j6.put(bce.h_, "SHA384WITHRSA");
        j6.put(bce.i_, "SHA512WITHRSA");
        j6.put(bbs.v5, "GOST3411WITHGOST3410");
        j6.put(bbs.Zo, "GOST3411WITHECGOST3410");
        j6.put(new ayq("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        j6.put(new ayq("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        j6.put(new ayq("1.2.840.10040.4.3"), "SHA1WITHDSA");
        j6.put(bdj.u7, "SHA1WITHECDSA");
        j6.put(bdj.J0, "SHA224WITHECDSA");
        j6.put(bdj.J8, "SHA256WITHECDSA");
        j6.put(bdj.Ws, "SHA384WITHECDSA");
        j6.put(bdj.QX, "SHA512WITHECDSA");
        j6.put(bcc.EQ, "SHA1WITHRSA");
        j6.put(bcc.tp, "SHA1WITHDSA");
        j6.put(bca.vy, "SHA224WITHDSA");
        j6.put(bca.P8, "SHA256WITHDSA");
        DW.put(bce.b_, "RSA/ECB/PKCS1Padding");
        FH.put(bce.Lz, "DESEDEWrap");
        FH.put(bce.sT, "RC2Wrap");
        FH.put(bca.EQ, "AESWrap");
        FH.put(bca.aM, "AESWrap");
        FH.put(bca.er, "AESWrap");
        FH.put(bcb.Hw, "CamelliaWrap");
        FH.put(bcb.v5, "CamelliaWrap");
        FH.put(bcb.Zo, "CamelliaWrap");
        FH.put(bbv.DW, "SEEDWrap");
        FH.put(bce.BT, "DESede");
        Hw.put(bca.Zo, "AES");
        Hw.put(bca.gn, "AES");
        Hw.put(bca.Ws, "AES");
        Hw.put(bca.a8, "AES");
        Hw.put(bce.BT, "DESede");
        Hw.put(bce.vy, "RC2");
    }

    bhe(bfw bfw) {
        this.v5 = bfw;
    }

    MessageDigest j6(bcp bcp) {
        try {
            return this.v5.j6(j6(bcp.FH()));
        } catch (NoSuchAlgorithmException e) {
            if (j6.get(bcp.FH()) != null) {
                return this.v5.j6((String) j6.get(bcp.FH()));
            }
            throw e;
        }
    }

    Signature DW(bcp bcp) {
        try {
            return this.v5.DW(FH(bcp));
        } catch (NoSuchAlgorithmException e) {
            if (j6.get(bcp.FH()) != null) {
                return this.v5.DW((String) j6.get(bcp.FH()));
            }
            throw e;
        }
    }

    private static String FH(bcp bcp) {
        ayh v5 = bcp.v5();
        if (v5 != null && !bae.j6.equals(v5) && bcp.FH().equals(bce.EQ)) {
            return new StringBuilder(String.valueOf(j6(bcg.j6(v5).FH().FH()))).append("WITHRSAANDMGF1").toString();
        }
        if (j6.containsKey(bcp.FH())) {
            return (String) j6.get(bcp.FH());
        }
        return bcp.FH().FH();
    }

    private static String j6(ayq ayq) {
        if (bce.SI.equals(ayq)) {
            return "MD5";
        }
        if (bcc.u7.equals(ayq)) {
            return "SHA1";
        }
        if (bca.v5.equals(ayq)) {
            return "SHA224";
        }
        if (bca.DW.equals(ayq)) {
            return "SHA256";
        }
        if (bca.FH.equals(ayq)) {
            return "SHA384";
        }
        if (bca.Hw.equals(ayq)) {
            return "SHA512";
        }
        if (bch.FH.equals(ayq)) {
            return "RIPEMD128";
        }
        if (bch.DW.equals(ayq)) {
            return "RIPEMD160";
        }
        if (bch.Hw.equals(ayq)) {
            return "RIPEMD256";
        }
        if (bbs.j6.equals(ayq)) {
            return "GOST3411";
        }
        return ayq.FH();
    }
}
