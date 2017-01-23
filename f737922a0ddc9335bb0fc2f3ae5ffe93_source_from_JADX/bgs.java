import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bgs {
    private static Set DW;
    private static final ayq EQ;
    private static Map FH;
    private static Set Hw;
    private static final ayq VH;
    private static final ayq Zo;
    private static final ayq gn;
    private static Map j6;
    private static final ayq tp;
    private static final ayq u7;
    private static Map v5;

    static {
        j6 = new HashMap();
        DW = new HashSet();
        FH = new HashMap();
        Hw = new HashSet();
        v5 = new HashMap();
        Zo = bce.b_;
        VH = bdj.x9;
        gn = bdj.u7;
        u7 = bce.EQ;
        tp = bbs.FH;
        EQ = bbs.Hw;
        j6.put("MD2WITHRSAENCRYPTION", bce.c_);
        j6.put("MD2WITHRSA", bce.c_);
        j6.put("MD5WITHRSAENCRYPTION", bce.v5);
        j6.put("MD5WITHRSA", bce.v5);
        j6.put("SHA1WITHRSAENCRYPTION", bce.d_);
        j6.put("SHA1WITHRSA", bce.d_);
        j6.put("SHA224WITHRSAENCRYPTION", bce.j_);
        j6.put("SHA224WITHRSA", bce.j_);
        j6.put("SHA256WITHRSAENCRYPTION", bce.g_);
        j6.put("SHA256WITHRSA", bce.g_);
        j6.put("SHA384WITHRSAENCRYPTION", bce.h_);
        j6.put("SHA384WITHRSA", bce.h_);
        j6.put("SHA512WITHRSAENCRYPTION", bce.i_);
        j6.put("SHA512WITHRSA", bce.i_);
        j6.put("SHA1WITHRSAANDMGF1", bce.EQ);
        j6.put("SHA224WITHRSAANDMGF1", bce.EQ);
        j6.put("SHA256WITHRSAANDMGF1", bce.EQ);
        j6.put("SHA384WITHRSAANDMGF1", bce.EQ);
        j6.put("SHA512WITHRSAANDMGF1", bce.EQ);
        j6.put("RIPEMD160WITHRSAENCRYPTION", bch.Zo);
        j6.put("RIPEMD160WITHRSA", bch.Zo);
        j6.put("RIPEMD128WITHRSAENCRYPTION", bch.VH);
        j6.put("RIPEMD128WITHRSA", bch.VH);
        j6.put("RIPEMD256WITHRSAENCRYPTION", bch.gn);
        j6.put("RIPEMD256WITHRSA", bch.gn);
        j6.put("SHA1WITHDSA", bdj.x9);
        j6.put("DSAWITHSHA1", bdj.x9);
        j6.put("SHA224WITHDSA", bca.vy);
        j6.put("SHA256WITHDSA", bca.P8);
        j6.put("SHA384WITHDSA", bca.ei);
        j6.put("SHA512WITHDSA", bca.nw);
        j6.put("SHA1WITHECDSA", bdj.u7);
        j6.put("ECDSAWITHSHA1", bdj.u7);
        j6.put("SHA224WITHECDSA", bdj.J0);
        j6.put("SHA256WITHECDSA", bdj.J8);
        j6.put("SHA384WITHECDSA", bdj.Ws);
        j6.put("SHA512WITHECDSA", bdj.QX);
        j6.put("GOST3411WITHGOST3410", bbs.v5);
        j6.put("GOST3411WITHGOST3410-94", bbs.v5);
        j6.put("GOST3411WITHECGOST3410", bbs.Zo);
        j6.put("GOST3411WITHECGOST3410-2001", bbs.Zo);
        j6.put("GOST3411WITHGOST3410-2001", bbs.Zo);
        DW.add(bdj.u7);
        DW.add(bdj.J0);
        DW.add(bdj.J8);
        DW.add(bdj.Ws);
        DW.add(bdj.QX);
        DW.add(bdj.x9);
        DW.add(bca.vy);
        DW.add(bca.P8);
        DW.add(bca.ei);
        DW.add(bca.nw);
        DW.add(bbs.v5);
        DW.add(bbs.Zo);
        Hw.add(bce.d_);
        Hw.add(bce.j_);
        Hw.add(bce.g_);
        Hw.add(bce.h_);
        Hw.add(bce.i_);
        Hw.add(bch.VH);
        Hw.add(bch.Zo);
        Hw.add(bch.gn);
        FH.put("SHA1WITHRSAANDMGF1", j6(new bcp(bcc.u7, new bae()), 20));
        FH.put("SHA224WITHRSAANDMGF1", j6(new bcp(bca.v5, new bae()), 28));
        FH.put("SHA256WITHRSAANDMGF1", j6(new bcp(bca.DW, new bae()), 32));
        FH.put("SHA384WITHRSAANDMGF1", j6(new bcp(bca.FH, new bae()), 48));
        FH.put("SHA512WITHRSAANDMGF1", j6(new bcp(bca.Hw, new bae()), 64));
        v5.put(bce.j_, bca.v5);
        v5.put(bce.g_, bca.DW);
        v5.put(bce.h_, bca.FH);
        v5.put(bce.i_, bca.Hw);
        v5.put(bce.c_, bce.ei);
        v5.put(bce.Hw, bce.nw);
        v5.put(bce.v5, bce.SI);
        v5.put(bce.d_, bcc.u7);
        v5.put(bch.VH, bch.FH);
        v5.put(bch.Zo, bch.DW);
        v5.put(bch.gn, bch.Hw);
        v5.put(bbs.v5, bbs.j6);
        v5.put(bbs.Zo, bbs.j6);
    }

    private static bcp DW(String str) {
        String j6 = bhl.j6(str);
        ayq ayq = (ayq) j6.get(j6);
        if (ayq == null) {
            throw new IllegalArgumentException("Unknown signature type requested: " + j6);
        }
        bcp bcp;
        if (DW.contains(ayq)) {
            bcp = new bcp(ayq);
        } else if (FH.containsKey(j6)) {
            bcp = new bcp(ayq, (ayh) FH.get(j6));
        } else {
            bcp = new bcp(ayq, bae.j6);
        }
        if (Hw.contains(ayq)) {
            bcp bcp2 = new bcp(bce.b_, new bae());
        }
        if (bcp.FH().equals(bce.EQ)) {
            ((bcg) bcp.v5()).FH();
        } else {
            bcp2 = new bcp((ayq) v5.get(ayq), new bae());
        }
        return bcp;
    }

    private static bcg j6(bcp bcp, int i) {
        return new bcg(bcp, new bcp(bce.f_, (ayh) bcp), new ayn(i), new ayn(1));
    }

    public bcp j6(String str) {
        return DW(str);
    }
}
