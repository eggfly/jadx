import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bdy {
    private static final String BT;
    public static final String DW;
    public static final String EQ;
    public static final String FH;
    public static final String Hw;
    public static final String J0;
    public static final String J8;
    private static final Map P8;
    public static final String QX;
    public static final String VH;
    public static final String Ws;
    public static final String XL;
    public static final String Zo;
    private static final String er;
    private static final String gW;
    public static final String gn;
    public static final String j6;
    private static final String rN;
    public static final String tp;
    public static final String u7;
    public static final String v5;
    private static final Set vy;
    public static final String we;
    private static final String yS;
    protected List Mr;
    protected List U2;
    protected Map a8;
    protected List aM;
    protected List j3;
    protected final SecureRandom lg;

    static {
        j6 = bbl.j6.FH();
        DW = bcc.u7.FH();
        FH = bca.v5.FH();
        Hw = bca.DW.FH();
        v5 = bca.FH.FH();
        Zo = bca.Hw.FH();
        VH = bce.SI.FH();
        gn = bbs.j6.FH();
        u7 = bch.FH.FH();
        tp = bch.DW.FH();
        EQ = bch.Hw.FH();
        we = bce.b_.FH();
        J0 = bdj.x9.FH();
        J8 = bdj.u7.FH();
        Ws = bce.EQ.FH();
        QX = bbs.FH.FH();
        XL = bbs.Hw.FH();
        rN = bdj.u7.FH();
        er = bdj.J0.FH();
        yS = bdj.J8.FH();
        gW = bdj.Ws.FH();
        BT = bdj.QX.FH();
        vy = new HashSet();
        P8 = new HashMap();
        vy.add(J0);
        vy.add(J8);
        vy.add(rN);
        vy.add(er);
        vy.add(yS);
        vy.add(gW);
        vy.add(BT);
        P8.put(DW, rN);
        P8.put(FH, er);
        P8.put(Hw, yS);
        P8.put(v5, gW);
        P8.put(Zo, BT);
    }

    protected bdy() {
        this(new SecureRandom());
    }

    protected bdy(SecureRandom secureRandom) {
        this.aM = new ArrayList();
        this.j3 = new ArrayList();
        this.Mr = new ArrayList();
        this.U2 = new ArrayList();
        this.a8 = new HashMap();
        this.lg = secureRandom;
    }

    public void j6(bhj bhj) {
        this.aM.addAll(beb.j6(bhj));
    }

    public void j6(bef bef) {
        this.U2.add(bef);
    }
}
