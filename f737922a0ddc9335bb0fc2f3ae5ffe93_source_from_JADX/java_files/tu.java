import com.aide.uidesigner.ProxyTextView;

public class tu {
    public static wl j6(String str, byte[] bArr, tt ttVar, tq tqVar) {
        try {
            return DW(str, bArr, ttVar, tqVar);
        } catch (Throwable e) {
            throw ada.j6(e, "...while processing " + str);
        }
    }

    private static wl DW(String str, byte[] bArr, tt ttVar, tq tqVar) {
        su suVar = new su(bArr, str, ttVar.FH);
        suVar.j6(sy.j6);
        suVar.DW();
        tw.j6(ttVar.v5, ttVar.Zo);
        wl wlVar = new wl(suVar.Hw(), suVar.FH() & -33, suVar.v5(), suVar.VH(), ttVar.j6 == 1 ? null : suVar.EQ());
        ze j6 = ts.j6(suVar, ttVar);
        if (j6.DW() != 0) {
            wlVar.j6(j6);
        }
        j6(suVar, wlVar);
        j6(suVar, ttVar, tqVar, wlVar);
        return wlVar;
    }

    private static void j6(su suVar, wl wlVar) {
        abf Hw = suVar.Hw();
        td gn = suVar.gn();
        int m_ = gn.m_();
        int i = 0;
        while (i < m_) {
            tc j6 = gn.j6(i);
            try {
                aar aar = new aar(Hw, j6.j6());
                int Hw2 = j6.Hw();
                if (zh.Zo(Hw2)) {
                    aah VH = j6.VH();
                    ws wsVar = new ws(aar, Hw2);
                    if (VH != null) {
                        VH = j6((abh) VH, aar.j6());
                    }
                    wlVar.j6(wsVar, VH);
                } else {
                    wlVar.j6(new ws(aar, Hw2));
                }
                ze j62 = ts.j6(j6.v5());
                if (j62.DW() != 0) {
                    wlVar.j6(aar, j62);
                }
                i++;
            } catch (Throwable e) {
                throw ada.j6(e, "...while processing " + j6.DW().Hw() + " " + j6.FH().Hw());
            }
        }
    }

    private static abh j6(abh abh, abl abl) {
        if (abh.j6().equals(abl)) {
            return abh;
        }
        switch (abl.FH()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return aam.j6(((aat) abh).r_());
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return aan.j6(((aat) abh).r_());
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return aao.j6(((aat) abh).r_());
            case 8:
                return abd.j6(((aat) abh).r_());
            default:
                throw new UnsupportedOperationException("can't coerce " + abh + " to " + abl);
        }
    }

    private static void j6(su suVar, tt ttVar, tq tqVar, wl wlVar) {
        abf Hw = suVar.Hw();
        tg u7 = suVar.u7();
        int m_ = u7.m_();
        int i = 0;
        while (i < m_) {
            tf j6 = u7.j6(i);
            try {
                ue ueVar;
                int i2;
                abb abb = new abb(Hw, j6.j6());
                int Hw2 = j6.Hw();
                boolean Zo = zh.Zo(Hw2);
                boolean v5 = zh.v5(Hw2);
                boolean u72 = zh.u7(Hw2);
                boolean gn = zh.gn(Hw2);
                Object obj = (abb.tp() || abb.EQ()) ? 1 : null;
                if (u72 || gn) {
                    ueVar = null;
                } else {
                    aaa j62;
                    ry ryVar = new ry(j6, suVar, ttVar.j6 != 1, ttVar.DW);
                    aag aag = zl.j6;
                    aaa j63 = sj.j6(ryVar, aag);
                    int DW = abb.DW(Zo);
                    String str = Hw.u7().gn() + "." + j6.DW().tp();
                    if (ttVar.Hw && tw.j6(str)) {
                        j62 = aca.j6(j63, DW, Zo, ttVar.DW, aag);
                        if (ttVar.VH) {
                            tv.j6(j63, j62);
                        }
                    } else {
                        j62 = j63;
                        j63 = null;
                    }
                    zs zsVar = null;
                    if (ttVar.DW) {
                        zsVar = zr.j6(j62);
                    }
                    ue j64 = uv.j6(j62, ttVar.j6, zsVar, DW, tqVar);
                    if (ttVar.VH && j63 != null) {
                        j6(ttVar, tqVar, j62, j63, zsVar, DW, ryVar.EQ().DW());
                    }
                    ueVar = j64;
                }
                if (zh.VH(Hw2)) {
                    i2 = 131072 | Hw2;
                    if (!u72) {
                        i2 &= -33;
                    }
                } else {
                    i2 = Hw2;
                }
                if (obj != null) {
                    i2 |= 65536;
                }
                wu wuVar = new wu(abb, i2, ueVar, ts.j6(j6));
                if (abb.tp() || abb.EQ() || Zo || v5) {
                    wlVar.j6(wuVar);
                } else {
                    wlVar.DW(wuVar);
                }
                ze DW2 = ts.DW(j6);
                if (DW2.DW() != 0) {
                    wlVar.j6(abb, DW2);
                }
                zf FH = ts.FH(j6);
                if (FH.m_() != 0) {
                    wlVar.j6(abb, FH);
                }
                i++;
            } catch (Throwable e) {
                throw ada.j6(e, "...while processing " + j6.DW().Hw() + " " + j6.FH().Hw());
            }
        }
    }

    private static void j6(tt ttVar, tq tqVar, aaa aaa, aaa aaa2, zs zsVar, int i, int i2) {
        ue j6 = uv.j6(aaa, ttVar.j6, zsVar, i, tqVar);
        ue j62 = uv.j6(aaa2, ttVar.j6, zsVar, i, tqVar);
        ue$a tu_1 = new tu$1();
        j6.j6(tu_1);
        j62.j6(tu_1);
        tv.j6(j62, j6);
        tv.j6(i2);
    }
}
