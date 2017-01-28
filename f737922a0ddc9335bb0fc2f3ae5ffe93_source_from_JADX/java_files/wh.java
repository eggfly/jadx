import java.util.ArrayList;

public final class wh {
    private static final abf DW;
    private static final abf FH;
    private static final abf Hw;
    private static final abf VH;
    private static final abf Zo;
    private static final abe gn;
    private static final abf j6;
    private static final abe tp;
    private static final abe u7;
    private static final abf v5;

    static {
        j6 = abf.DW(abl.j6("Ldalvik/annotation/AnnotationDefault;"));
        DW = abf.DW(abl.j6("Ldalvik/annotation/EnclosingClass;"));
        FH = abf.DW(abl.j6("Ldalvik/annotation/EnclosingMethod;"));
        Hw = abf.DW(abl.j6("Ldalvik/annotation/InnerClass;"));
        v5 = abf.DW(abl.j6("Ldalvik/annotation/MemberClasses;"));
        Zo = abf.DW(abl.j6("Ldalvik/annotation/Signature;"));
        VH = abf.DW(abl.j6("Ldalvik/annotation/Throws;"));
        gn = new abe("accessFlags");
        u7 = new abe("name");
        tp = new abe("value");
    }

    public static zc j6(zc zcVar) {
        zc zcVar2 = new zc(j6, zd.SYSTEM);
        zcVar2.j6(new zg(tp, new aaj(zcVar)));
        zcVar2.l_();
        return zcVar2;
    }

    public static zc j6(abf abf) {
        zc zcVar = new zc(DW, zd.SYSTEM);
        zcVar.j6(new zg(tp, abf));
        zcVar.l_();
        return zcVar;
    }

    public static zc j6(abb abb) {
        zc zcVar = new zc(FH, zd.SYSTEM);
        zcVar.j6(new zg(tp, abb));
        zcVar.l_();
        return zcVar;
    }

    public static zc j6(abe abe, int i) {
        zc zcVar = new zc(Hw, zd.SYSTEM);
        if (abe == null) {
            abe = aav.j6;
        }
        zcVar.j6(new zg(u7, abe));
        zcVar.j6(new zg(gn, aat.j6(i)));
        zcVar.l_();
        return zcVar;
    }

    public static zc j6(abn abn) {
        aah FH = FH(abn);
        zc zcVar = new zc(v5, zd.SYSTEM);
        zcVar.j6(new zg(tp, FH));
        zcVar.l_();
        return zcVar;
    }

    public static zc j6(abe abe) {
        int i = 0;
        zc zcVar = new zc(Zo, zd.SYSTEM);
        String tp = abe.tp();
        int length = tp.length();
        ArrayList arrayList = new ArrayList(20);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (tp.charAt(i2) == 'L') {
                while (i3 < length) {
                    char charAt = tp.charAt(i3);
                    if (charAt != ';') {
                        if (charAt == '<') {
                            break;
                        }
                        i3++;
                    } else {
                        i3++;
                        break;
                    }
                }
            }
            while (i3 < length) {
                if (tp.charAt(i3) == 'L') {
                    break;
                }
                i3++;
            }
            arrayList.add(tp.substring(i2, i3));
            i2 = i3;
        }
        i2 = arrayList.size();
        aak$a aak_a = new aak$a(i2);
        while (i < i2) {
            aak_a.j6(i, new abe((String) arrayList.get(i)));
            i++;
        }
        aak_a.l_();
        zcVar.j6(new zg(tp, new aak(aak_a)));
        zcVar.l_();
        return zcVar;
    }

    public static zc DW(abn abn) {
        aah FH = FH(abn);
        zc zcVar = new zc(VH, zd.SYSTEM);
        zcVar.j6(new zg(tp, FH));
        zcVar.l_();
        return zcVar;
    }

    private static aak FH(abn abn) {
        int m_ = abn.m_();
        aak$a aak_a = new aak$a(m_);
        for (int i = 0; i < m_; i++) {
            aak_a.j6(i, abf.DW(abn.j6(i)));
        }
        aak_a.l_();
        return new aak(aak_a);
    }
}
