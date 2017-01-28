import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

class bhs {
    private static Hashtable DW;
    private static Set FH;
    private static Hashtable j6;

    static {
        j6 = new Hashtable();
        DW = new Hashtable();
        FH = new HashSet();
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
        FH.add(bdj.u7);
        FH.add(bdj.J0);
        FH.add(bdj.J8);
        FH.add(bdj.Ws);
        FH.add(bdj.QX);
        FH.add(bdj.x9);
        FH.add(bca.vy);
        FH.add(bca.P8);
        FH.add(bca.ei);
        FH.add(bca.nw);
        FH.add(bbs.v5);
        FH.add(bbs.Zo);
        DW.put("SHA1WITHRSAANDMGF1", j6(new bcp(bcc.u7, new bae()), 20));
        DW.put("SHA224WITHRSAANDMGF1", j6(new bcp(bca.v5, new bae()), 28));
        DW.put("SHA256WITHRSAANDMGF1", j6(new bcp(bca.DW, new bae()), 32));
        DW.put("SHA384WITHRSAANDMGF1", j6(new bcp(bca.FH, new bae()), 48));
        DW.put("SHA512WITHRSAANDMGF1", j6(new bcp(bca.Hw, new bae()), 64));
    }

    private static bcg j6(bcp bcp, int i) {
        return new bcg(bcp, new bcp(bce.f_, (ayh) bcp), new ayn(i), new ayn(1));
    }

    static bag j6(String str) {
        String j6 = bhl.j6(str);
        if (j6.containsKey(j6)) {
            return (bag) j6.get(j6);
        }
        return new bag(j6);
    }

    static bcp j6(bag bag, String str) {
        if (FH.contains(bag)) {
            return new bcp(bag);
        }
        String j6 = bhl.j6(str);
        if (DW.containsKey(j6)) {
            return new bcp(bag, (ayh) DW.get(j6));
        }
        return new bcp(bag, new bae());
    }

    static Signature j6(String str, String str2) {
        if (str2 != null) {
            return Signature.getInstance(str, str2);
        }
        return Signature.getInstance(str);
    }

    static byte[] j6(bag bag, String str, String str2, PrivateKey privateKey, SecureRandom secureRandom, ayh ayh) {
        if (bag == null) {
            throw new IllegalStateException("no signature algorithm specified");
        }
        Signature j6 = j6(str, str2);
        if (secureRandom != null) {
            j6.initSign(privateKey, secureRandom);
        } else {
            j6.initSign(privateKey);
        }
        j6.update(ayh.w_().j6("DER"));
        return j6.sign();
    }
}
