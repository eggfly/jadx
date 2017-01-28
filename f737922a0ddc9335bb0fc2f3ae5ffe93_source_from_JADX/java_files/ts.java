import java.util.ArrayList;

class ts {
    public static abn j6(tf tfVar) {
        qz qzVar = (qz) tfVar.v5().j6("Exceptions");
        if (qzVar == null) {
            return abk.j6;
        }
        return qzVar.DW();
    }

    public static ze j6(ta taVar) {
        ze DW = DW(taVar);
        zc FH = FH(taVar);
        if (FH != null) {
            return ze.j6(DW, FH);
        }
        return DW;
    }

    public static ze j6(su suVar, tt ttVar) {
        abf Hw = suVar.Hw();
        ta tp = suVar.tp();
        ze j6 = j6(tp);
        zc Hw2 = Hw(tp);
        try {
            ze j62 = j6(Hw, tp, Hw2 == null);
            if (j62 != null) {
                j6 = ze.j6(j6, j62);
            }
        } catch (adt e) {
            ttVar.gn.println("warning: " + e.getMessage());
        }
        if (Hw2 != null) {
            j6 = ze.j6(j6, Hw2);
        }
        if (!zh.tp(suVar.FH())) {
            return j6;
        }
        zc j63 = j6(suVar);
        if (j63 != null) {
            return ze.j6(j6, j63);
        }
        return j6;
    }

    public static ze DW(tf tfVar) {
        ze j6 = j6(tfVar.v5());
        abn j62 = j6(tfVar);
        if (j62.m_() != 0) {
            return ze.j6(j6, wh.DW(j62));
        }
        return j6;
    }

    private static ze DW(ta taVar) {
        rg rgVar = (rg) taVar.j6("RuntimeVisibleAnnotations");
        re reVar = (re) taVar.j6("RuntimeInvisibleAnnotations");
        if (rgVar == null) {
            if (reVar == null) {
                return ze.j6;
            }
            return reVar.DW();
        } else if (reVar == null) {
            return rgVar.DW();
        } else {
            return ze.j6(rgVar.DW(), reVar.DW());
        }
    }

    private static zc FH(ta taVar) {
        ri riVar = (ri) taVar.j6("Signature");
        if (riVar == null) {
            return null;
        }
        return wh.j6(riVar.DW());
    }

    private static zc Hw(ta taVar) {
        qy qyVar = (qy) taVar.j6("EnclosingMethod");
        if (qyVar == null) {
            return null;
        }
        abf DW = qyVar.DW();
        abc FH = qyVar.FH();
        if (FH == null) {
            return wh.j6(DW);
        }
        return wh.j6(new abb(DW, FH));
    }

    private static ze j6(abf abf, ta taVar, boolean z) {
        ra raVar = (ra) taVar.j6("InnerClasses");
        if (raVar == null) {
            return null;
        }
        rp DW = raVar.DW();
        int m_ = DW.m_();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        rp$a rp_a = null;
        while (i < m_) {
            rp$a j6 = DW.j6(i);
            abf j62 = j6.j6();
            if (!j62.equals(abf)) {
                if (abf.equals(j6.DW())) {
                    arrayList.add(j62.u7());
                }
                j6 = rp_a;
            }
            i++;
            rp_a = j6;
        }
        i = arrayList.size();
        if (rp_a == null && i == 0) {
            return null;
        }
        ze zeVar = new ze();
        if (rp_a != null) {
            zeVar.j6(wh.j6(rp_a.FH(), rp_a.Hw()));
            if (z) {
                if (rp_a.DW() == null) {
                    throw new adt("Ignoring InnerClasses attribute for an anonymous inner class\n(" + abf.Hw() + ") that doesn't come with an\n" + "associated EnclosingMethod attribute. " + "This class was probably produced by a\n" + "compiler that did not target the modern " + ".class file format. The recommended\n" + "solution is to recompile the class from " + "source, using an up-to-date compiler\n" + "and without specifying any \"-target\" type " + "options. The consequence of ignoring\n" + "this warning is that reflective operations " + "on this class will incorrectly\n" + "indicate that it is *not* an inner class.");
                }
                zeVar.j6(wh.j6(rp_a.DW()));
            }
        }
        if (i != 0) {
            abn abk = new abk(i);
            for (int i2 = 0; i2 < i; i2++) {
                abk.j6(i2, (abl) arrayList.get(i2));
            }
            abk.l_();
            zeVar.j6(wh.j6(abk));
        }
        zeVar.l_();
        return zeVar;
    }

    public static zf FH(tf tfVar) {
        ta v5 = tfVar.v5();
        rh rhVar = (rh) v5.j6("RuntimeVisibleParameterAnnotations");
        rf rfVar = (rf) v5.j6("RuntimeInvisibleParameterAnnotations");
        if (rhVar == null) {
            if (rfVar == null) {
                return zf.j6;
            }
            return rfVar.DW();
        } else if (rfVar == null) {
            return rhVar.DW();
        } else {
            return zf.j6(rhVar.DW(), rfVar.DW());
        }
    }

    private static zc j6(su suVar) {
        abf Hw = suVar.Hw();
        tg u7 = suVar.u7();
        int m_ = u7.m_();
        zc zcVar = new zc(Hw, zd.EMBEDDED);
        int i = 0;
        Object obj = null;
        while (i < m_) {
            Object obj2;
            tf j6 = u7.j6(i);
            qu quVar = (qu) j6.v5().j6("AnnotationDefault");
            if (quVar != null) {
                zcVar.DW(new zg(j6.j6().j6(), quVar.DW()));
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            return null;
        }
        zcVar.l_();
        return wh.j6(zcVar);
    }
}
