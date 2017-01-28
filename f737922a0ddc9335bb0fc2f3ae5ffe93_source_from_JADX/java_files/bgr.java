import java.util.HashMap;
import java.util.Map;

public class bgr implements bgt {
    private static Map DW;
    private static Map j6;

    static {
        j6 = new HashMap();
        DW = new HashMap();
        j6.put(bcc.FH, bce.nw);
        j6.put(bcc.j6, bce.nw);
        j6.put(bcc.EQ, bcc.u7);
        j6.put(bce.j_, bca.v5);
        j6.put(bce.g_, bca.DW);
        j6.put(bce.h_, bca.FH);
        j6.put(bce.i_, bca.Hw);
        j6.put(bce.c_, bce.ei);
        j6.put(bce.Hw, bce.nw);
        j6.put(bce.v5, bce.SI);
        j6.put(bce.d_, bcc.u7);
        j6.put(bdj.u7, bcc.u7);
        j6.put(bdj.J0, bca.v5);
        j6.put(bdj.J8, bca.DW);
        j6.put(bdj.Ws, bca.FH);
        j6.put(bdj.QX, bca.Hw);
        j6.put(bdj.x9, bcc.u7);
        j6.put(bca.vy, bca.v5);
        j6.put(bca.P8, bca.DW);
        j6.put(bca.ei, bca.FH);
        j6.put(bca.nw, bca.Hw);
        j6.put(bch.VH, bch.FH);
        j6.put(bch.Zo, bch.DW);
        j6.put(bch.gn, bch.Hw);
        j6.put(bbs.v5, bbs.j6);
        j6.put(bbs.Zo, bbs.j6);
        DW.put("SHA-1", bcc.u7);
        DW.put("SHA-224", bca.v5);
        DW.put("SHA-256", bca.DW);
        DW.put("SHA-384", bca.FH);
        DW.put("SHA-512", bca.Hw);
        DW.put("GOST3411", bbs.j6);
        DW.put("MD2", bce.ei);
        DW.put("MD4", bce.nw);
        DW.put("MD5", bce.SI);
        DW.put("RIPEMD128", bch.FH);
        DW.put("RIPEMD160", bch.DW);
        DW.put("RIPEMD256", bch.Hw);
    }

    public bcp j6(bcp bcp) {
        if (bcp.FH().equals(bce.EQ)) {
            return ((bcg) bcp.v5()).FH();
        }
        return new bcp((ayq) j6.get(bcp.FH()), new bae());
    }
}
