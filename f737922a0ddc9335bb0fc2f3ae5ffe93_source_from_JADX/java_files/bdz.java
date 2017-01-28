import java.util.HashMap;
import java.util.Map;

class bdz {
    private static final Map DW;
    private static final Map FH;
    private static final Map Hw;
    static final bdz j6;

    bdz() {
    }

    static {
        j6 = new bdz();
        DW = new HashMap();
        FH = new HashMap();
        Hw = new HashMap();
        j6(bca.vy, "SHA224", "DSA");
        j6(bca.P8, "SHA256", "DSA");
        j6(bca.ei, "SHA384", "DSA");
        j6(bca.nw, "SHA512", "DSA");
        j6(bcc.tp, "SHA1", "DSA");
        j6(bcc.j6, "MD4", "RSA");
        j6(bcc.FH, "MD4", "RSA");
        j6(bcc.DW, "MD5", "RSA");
        j6(bcc.EQ, "SHA1", "RSA");
        j6(bce.c_, "MD2", "RSA");
        j6(bce.Hw, "MD4", "RSA");
        j6(bce.v5, "MD5", "RSA");
        j6(bce.d_, "SHA1", "RSA");
        j6(bce.j_, "SHA224", "RSA");
        j6(bce.g_, "SHA256", "RSA");
        j6(bce.h_, "SHA384", "RSA");
        j6(bce.i_, "SHA512", "RSA");
        j6(bdj.u7, "SHA1", "ECDSA");
        j6(bdj.J0, "SHA224", "ECDSA");
        j6(bdj.J8, "SHA256", "ECDSA");
        j6(bdj.Ws, "SHA384", "ECDSA");
        j6(bdj.QX, "SHA512", "ECDSA");
        j6(bdj.x9, "SHA1", "DSA");
        j6(bbt.j3, "SHA1", "ECDSA");
        j6(bbt.Mr, "SHA224", "ECDSA");
        j6(bbt.U2, "SHA256", "ECDSA");
        j6(bbt.a8, "SHA384", "ECDSA");
        j6(bbt.lg, "SHA512", "ECDSA");
        j6(bbt.we, "SHA1", "RSA");
        j6(bbt.J0, "SHA256", "RSA");
        j6(bbt.J8, "SHA1", "RSAandMGF1");
        j6(bbt.Ws, "SHA256", "RSAandMGF1");
        DW.put(bdj.ca.FH(), "DSA");
        DW.put(bce.b_.FH(), "RSA");
        DW.put(bch.v5, "RSA");
        DW.put(bdg.we.FH(), "RSA");
        DW.put(bdx.Ws, "RSAandMGF1");
        DW.put(bbs.FH.FH(), "GOST3410");
        DW.put(bbs.Hw.FH(), "ECGOST3410");
        DW.put("1.3.6.1.4.1.5849.1.6.2", "ECGOST3410");
        DW.put("1.3.6.1.4.1.5849.1.1.5", "GOST3410");
        DW.put(bbs.Zo.FH(), "ECGOST3410");
        DW.put(bbs.v5.FH(), "GOST3410");
        FH.put(bce.ei.FH(), "MD2");
        FH.put(bce.nw.FH(), "MD4");
        FH.put(bce.SI.FH(), "MD5");
        FH.put(bcc.u7.FH(), "SHA1");
        FH.put(bca.v5.FH(), "SHA224");
        FH.put(bca.DW.FH(), "SHA256");
        FH.put(bca.FH.FH(), "SHA384");
        FH.put(bca.Hw.FH(), "SHA512");
        FH.put(bch.FH.FH(), "RIPEMD128");
        FH.put(bch.DW.FH(), "RIPEMD160");
        FH.put(bch.Hw.FH(), "RIPEMD256");
        FH.put(bbs.j6.FH(), "GOST3411");
        FH.put("1.3.6.1.4.1.5849.1.2.1", "GOST3411");
        Hw.put("SHA1", new String[]{"SHA-1"});
        Hw.put("SHA224", new String[]{"SHA-224"});
        Hw.put("SHA256", new String[]{"SHA-256"});
        Hw.put("SHA384", new String[]{"SHA-384"});
        Hw.put("SHA512", new String[]{"SHA-512"});
    }

    private static void j6(bag bag, String str, String str2) {
        FH.put(bag.FH(), str);
        DW.put(bag.FH(), str2);
    }

    String j6(String str) {
        String str2 = (String) FH.get(str);
        return str2 != null ? str2 : str;
    }

    String DW(String str) {
        String str2 = (String) DW.get(str);
        return str2 != null ? str2 : str;
    }

    bcp j6(bcp bcp) {
        if (bcp.v5() == null) {
            return new bcp(bcp.Hw(), bae.j6);
        }
        return bcp;
    }
}
