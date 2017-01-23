import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import java.util.Set;

class asi {
    private static final int DW;
    private static final int j6;
    private final ano EQ;
    private final aob FH;
    private final any Hw;
    private final List<asv> VH;
    private final ant<asv> Zo;
    private final ast gn;
    private final avy tp;
    private final ant<asi$a> u7;
    private final ans[] v5;

    static {
        j6 = anl.FH.FH();
        DW = anl.j6.FH();
    }

    asi(aob aob, Set<aqk> set, ant<asv> ant_asv, List<asv> list, any any) {
        this.FH = aob;
        this.Hw = any;
        this.v5 = (ans[]) set.toArray(new ans[set.size()]);
        this.Zo = ant_asv;
        this.VH = list;
        this.gn = new ast();
        this.u7 = new ant();
        this.tp = new avy();
        this.EQ = new ano();
    }

    void j6(int i, byte[] bArr, int i2, int i3) {
        int j6 = j6(i);
        if (j6 == 0 || !this.gn.j6(i3)) {
            return;
        }
        int i4;
        int i5;
        if (i2 == 0) {
            for (anb j62 : this.v5) {
                j6(j62, 2, i3);
            }
            return;
        }
        int j63 = j6(bArr, 0, i2);
        for (anb anb : this.v5) {
            if (j63 != i2) {
                i4 = DW;
            } else {
                i4 = j6;
            }
            this.tp.j6(j6(anb));
            int i6 = 0;
            i5 = j63;
            while (!this.tp.u7()) {
                int j64 = this.tp.j6(bArr, i6, i5, i4);
                if (j64 >= 0) {
                    if (j64 <= 0) {
                        if (i5 != i2) {
                            if (!anl.j6.DW(this.tp.J0())) {
                                break;
                            }
                            i6 = i5 + 1;
                            i5 = j6(bArr, i6, i2);
                            if (i5 != i2) {
                                i4 = DW;
                            } else {
                                i4 = j6;
                            }
                            this.EQ.Hw(this.tp.v5(), this.tp.Zo());
                            this.tp.j6(j6(this.EQ));
                        } else if (this.tp.we().DW() == i) {
                            this.EQ.Hw(this.tp.v5(), this.tp.Zo());
                            j6(this.EQ, i, i3);
                        }
                    } else {
                        break;
                    }
                }
                this.tp.tp();
            }
        }
    }

    private static int j6(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return DW;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return j6;
            default:
                return 0;
        }
    }

    private static int j6(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 47) {
            i++;
        }
        return i;
    }

    private void j6(anb anb, int i, int i2) {
        ant$a asv = new asv(anb, i);
        asv.a8();
        asv.Hw(i2);
        if (this.Zo.DW(asv) == asv) {
            this.VH.add(asv);
            this.FH.j6(1);
        }
    }

    private byte[] j6(anb anb) {
        asi$a asi_a = (asi$a) this.u7.j6(anb);
        if (asi_a != null) {
            return asi_a.VH;
        }
        byte[] DW = this.Hw.FH(anb, 2).DW(Integer.MAX_VALUE);
        this.u7.j6(new asi$a(anb, DW));
        return DW;
    }
}
