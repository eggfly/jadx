import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aoq {
    private static final ajv DW;
    private final ajr j6;

    public aoq() {
        this(new aka());
    }

    public aoq(ajr ajr) {
        this.j6 = ajr;
    }

    static {
        DW = new ajv(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public <S extends akh> aou<S> j6(aki<S> aki_S, S s, S s2, S s3) {
        List arrayList = new ArrayList(3);
        arrayList.add(s);
        arrayList.add(s2);
        arrayList.add(s3);
        aou<S> aou = new aou(arrayList);
        if (s2.j6() == 0) {
            if (s3.j6() == 0) {
                aou.j6(1, 0, 0, aor$a.NO_CONFLICT);
            } else if (this.j6.j6(aki_S, s, s3).isEmpty()) {
                aou.j6(1, 0, 0, aor$a.NO_CONFLICT);
            } else {
                aou.j6(1, 0, 0, aor$a.FIRST_CONFLICTING_RANGE);
                aou.j6(2, 0, s3.j6(), aor$a.NEXT_CONFLICTING_RANGE);
            }
            return aou;
        } else if (s3.j6() == 0) {
            if (this.j6.j6(aki_S, s, s2).isEmpty()) {
                aou.j6(2, 0, 0, aor$a.NO_CONFLICT);
            } else {
                aou.j6(1, 0, s2.j6(), aor$a.FIRST_CONFLICTING_RANGE);
                aou.j6(2, 0, 0, aor$a.NEXT_CONFLICTING_RANGE);
            }
            return aou;
        } else {
            Iterator it = this.j6.j6(aki_S, s, s2).iterator();
            Iterator it2 = this.j6.j6(aki_S, s, s3).iterator();
            int i = 0;
            ajv j6 = j6(it);
            ajv j62 = j6(it2);
            while (true) {
                if (j62 == DW && j6 == DW) {
                    break;
                } else if (j6.Hw() < j62.FH()) {
                    if (i != j6.FH()) {
                        aou.j6(0, i, j6.FH(), aor$a.NO_CONFLICT);
                    }
                    aou.j6(1, j6.v5(), j6.Zo(), aor$a.NO_CONFLICT);
                    i = j6.Hw();
                    j6 = j6(it);
                } else if (j62.Hw() < j6.FH()) {
                    if (i != j62.FH()) {
                        aou.j6(0, i, j62.FH(), aor$a.NO_CONFLICT);
                    }
                    aou.j6(2, j62.v5(), j62.Zo(), aor$a.NO_CONFLICT);
                    i = j62.Hw();
                    j62 = j6(it2);
                } else {
                    int i2;
                    int Hw;
                    if (!(j6.FH() == i || j62.FH() == i)) {
                        aou.j6(0, i, Math.min(j6.FH(), j62.FH()), aor$a.NO_CONFLICT);
                    }
                    int v5 = j6.v5();
                    i = j62.v5();
                    if (j6.FH() < j62.FH()) {
                        i -= j62.FH() - j6.FH();
                    } else {
                        v5 -= j6.FH() - j62.FH();
                    }
                    ajv ajv = j6;
                    j6 = j6(it);
                    ajv ajv2 = j62;
                    j62 = j6(it2);
                    while (true) {
                        if (ajv.Hw() < j62.FH()) {
                            if (ajv2.Hw() < j6.FH()) {
                                break;
                            }
                            ajv = j6;
                            j6 = j6(it);
                        } else {
                            ajv2 = j62;
                            j62 = j6(it2);
                        }
                    }
                    int Zo = ajv.Zo();
                    int Zo2 = ajv2.Zo();
                    if (ajv.Hw() < ajv2.Hw()) {
                        i2 = Zo2;
                        Hw = Zo + (ajv2.Hw() - ajv.Hw());
                    } else {
                        i2 = Zo2 + (ajv.Hw() - ajv2.Hw());
                        Hw = Zo;
                    }
                    Zo2 = Hw - v5;
                    int i3 = Zo2 - (i2 - i);
                    if (i3 > 0) {
                        Zo2 -= i3;
                    }
                    Zo = 0;
                    while (Zo < Zo2) {
                        if (!aki_S.j6(s2, v5 + Zo, s3, i + Zo)) {
                            break;
                        }
                        Zo++;
                    }
                    int i4 = Zo2 - Zo;
                    Zo2 = 0;
                    while (Zo2 < i4) {
                        if (!aki_S.j6(s2, (Hw - Zo2) - 1, s3, (i2 - Zo2) - 1)) {
                            break;
                        }
                        Zo2++;
                    }
                    i4 -= Zo2;
                    if (Zo > 0) {
                        aou.j6(1, v5, v5 + Zo, aor$a.NO_CONFLICT);
                    }
                    if (i4 > 0 || i3 != 0) {
                        int i5 = 1;
                        aou.j6(i5, v5 + Zo, Hw - Zo2, aor$a.FIRST_CONFLICTING_RANGE);
                        aou.j6(2, i + Zo, i2 - Zo2, aor$a.NEXT_CONFLICTING_RANGE);
                    }
                    if (Zo2 > 0) {
                        aou.j6(1, Hw - Zo2, Hw, aor$a.NO_CONFLICT);
                    }
                    i = Math.max(ajv.Hw(), ajv2.Hw());
                }
            }
            if (i < s.j6()) {
                aou.j6(0, i, s.j6(), aor$a.NO_CONFLICT);
            }
            return aou;
        }
    }

    private static ajv j6(Iterator<ajv> it) {
        return it.hasNext() ? (ajv) it.next() : DW;
    }
}
