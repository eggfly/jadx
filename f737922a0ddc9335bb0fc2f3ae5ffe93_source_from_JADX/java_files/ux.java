import java.util.ArrayList;
import java.util.HashSet;

public final class ux implements tz {
    private final int[] DW;
    private final ty FH;
    private final aaa j6;

    public ux(aaa aaa, int[] iArr, ty tyVar) {
        if (aaa == null) {
            throw new NullPointerException("method == null");
        } else if (iArr == null) {
            throw new NullPointerException("order == null");
        } else if (tyVar == null) {
            throw new NullPointerException("addresses == null");
        } else {
            this.j6 = aaa;
            this.DW = iArr;
            this.FH = tyVar;
        }
    }

    public ub j6() {
        return j6(this.j6, this.DW, this.FH);
    }

    public boolean DW() {
        zj j6 = this.j6.j6();
        int m_ = j6.m_();
        for (int i = 0; i < m_; i++) {
            if (j6.j6(i).VH().DW().m_() != 0) {
                return true;
            }
        }
        return false;
    }

    public HashSet<abl> FH() {
        HashSet<abl> hashSet = new HashSet(20);
        zj j6 = this.j6.j6();
        int m_ = j6.m_();
        for (int i = 0; i < m_; i++) {
            abn DW = j6.j6(i).VH().DW();
            int m_2 = DW.m_();
            for (int i2 = 0; i2 < m_2; i2++) {
                hashSet.add(DW.j6(i2));
            }
        }
        return hashSet;
    }

    public static ub j6(aaa aaa, int[] iArr, ty tyVar) {
        zi ziVar = null;
        int length = iArr.length;
        zj j6 = aaa.j6();
        ArrayList arrayList = new ArrayList(length);
        ua uaVar = ua.j6;
        int i = 0;
        zi ziVar2 = null;
        while (i < length) {
            ua uaVar2;
            zi DW = j6.DW(iArr[i]);
            if (DW.gn()) {
                ua j62 = j6(DW, tyVar);
                if (uaVar.m_() == 0) {
                    ziVar = DW;
                    uaVar2 = j62;
                } else if (uaVar.equals(j62) && j6(ziVar2, DW, tyVar)) {
                    ziVar = DW;
                    DW = ziVar2;
                    uaVar2 = uaVar;
                } else {
                    if (uaVar.m_() != 0) {
                        arrayList.add(j6(ziVar2, ziVar, uaVar, tyVar));
                    }
                    ziVar = DW;
                    uaVar2 = j62;
                }
            } else {
                DW = ziVar2;
                uaVar2 = uaVar;
            }
            i++;
            uaVar = uaVar2;
            ziVar2 = DW;
        }
        if (uaVar.m_() != 0) {
            arrayList.add(j6(ziVar2, ziVar, uaVar, tyVar));
        }
        int size = arrayList.size();
        if (size == 0) {
            return ub.j6;
        }
        ub ubVar = new ub(size);
        for (int i2 = 0; i2 < size; i2++) {
            ubVar.j6(i2, (ub$a) arrayList.get(i2));
        }
        ubVar.l_();
        return ubVar;
    }

    private static ua j6(zi ziVar, ty tyVar) {
        int i = 0;
        adg FH = ziVar.FH();
        int DW = FH.DW();
        int Hw = ziVar.Hw();
        abn DW2 = ziVar.VH().DW();
        int m_ = DW2.m_();
        if (m_ == 0) {
            return ua.j6;
        }
        if ((Hw != -1 || DW == m_) && (Hw == -1 || (DW == m_ + 1 && Hw == FH.DW(m_)))) {
            for (DW = 0; DW < m_; DW++) {
                if (DW2.j6(DW).equals(abl.Ws)) {
                    m_ = DW + 1;
                    break;
                }
            }
            ua uaVar = new ua(m_);
            while (i < m_) {
                uaVar.j6(i, new abf(DW2.j6(i)), tyVar.j6(FH.DW(i)).VH());
                i++;
            }
            uaVar.l_();
            return uaVar;
        }
        throw new RuntimeException("shouldn't happen: weird successors list");
    }

    private static ub$a j6(zi ziVar, zi ziVar2, ua uaVar, ty tyVar) {
        return new ub$a(tyVar.DW(ziVar).VH(), tyVar.FH(ziVar2).VH(), uaVar);
    }

    private static boolean j6(zi ziVar, zi ziVar2, ty tyVar) {
        if (ziVar == null) {
            throw new NullPointerException("start == null");
        } else if (ziVar2 == null) {
            throw new NullPointerException("end == null");
        } else {
            return tyVar.FH(ziVar2).VH() - tyVar.DW(ziVar).VH() <= 65535;
        }
    }
}
