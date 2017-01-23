import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;

public final class wo {
    private final un DW;
    private acr EQ;
    private final acv FH;
    private final wq Hw;
    private String J0;
    private boolean J8;
    private final abj VH;
    private final un$b[] Ws;
    private final int Zo;
    private final boolean gn;
    private final ut j6;
    private int tp;
    private int u7;
    private final int v5;
    private PrintWriter we;

    public wo(ut utVar, un unVar, wq wqVar, int i, int i2, boolean z, abb abb) {
        this.u7 = 0;
        this.tp = 1;
        this.j6 = utVar;
        this.DW = unVar;
        this.Hw = wqVar;
        this.VH = abb.u7();
        this.gn = z;
        this.v5 = i;
        this.Zo = i2;
        this.FH = new acv();
        this.Ws = new un$b[i2];
    }

    private void j6(int i, String str) {
        if (this.J0 != null) {
            str = this.J0 + str;
        }
        if (this.EQ != null) {
            acr acr = this.EQ;
            if (!this.J8) {
                i = 0;
            }
            acr.j6(i, str);
        }
        if (this.we != null) {
            this.we.println(str);
        }
    }

    public byte[] j6() {
        try {
            return DW();
        } catch (Throwable e) {
            throw ada.j6(e, "...while encoding debug info");
        }
    }

    public byte[] j6(String str, PrintWriter printWriter, acr acr, boolean z) {
        this.J0 = str;
        this.we = printWriter;
        this.EQ = acr;
        this.J8 = z;
        return j6();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] DW() {
        /*
        r10 = this;
        r6 = 1;
        r0 = 0;
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r5 = r10.FH();
        r1 = r10.v5();
        r10.j6(r5, r1);
        r1 = r10.FH;
        r2 = 7;
        r1.FH(r2);
        r1 = r10.EQ;
        if (r1 != 0) goto L_0x001e;
    L_0x001a:
        r1 = r10.we;
        if (r1 == 0) goto L_0x0032;
    L_0x001e:
        r1 = "%04x: prologue end";
        r2 = new java.lang.Object[r6];
        r4 = r10.u7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r0] = r4;
        r1 = java.lang.String.format(r1, r2);
        r10.j6(r6, r1);
    L_0x0032:
        r6 = r5.size();
        r1 = r10.DW;
        r7 = r1.m_();
        r2 = r0;
    L_0x003d:
        r1 = r10.j6(r0);
        r4 = r10.j6(r2, r5);
        if (r1 >= r7) goto L_0x0092;
    L_0x0047:
        r0 = r10.DW;
        r0 = r0.j6(r1);
        r0 = r0.j6();
        r2 = r0;
    L_0x0052:
        if (r4 >= r6) goto L_0x0090;
    L_0x0054:
        r0 = r5.get(r4);
        r0 = (ut$a) r0;
        r0 = r0.j6();
    L_0x005e:
        r8 = java.lang.Math.min(r0, r2);
        if (r8 != r3) goto L_0x006e;
    L_0x0064:
        r10.Zo();
        r0 = r10.FH;
        r0 = r0.Zo();
        return r0;
    L_0x006e:
        r9 = r10.v5;
        if (r8 != r9) goto L_0x0076;
    L_0x0072:
        if (r2 != r3) goto L_0x0076;
    L_0x0074:
        if (r0 == r3) goto L_0x0064;
    L_0x0076:
        if (r8 != r0) goto L_0x0087;
    L_0x0078:
        r2 = r4 + 1;
        r0 = r5.get(r4);
        r0 = (ut$a) r0;
        r10.j6(r0);
        r0 = r2;
    L_0x0084:
        r2 = r0;
        r0 = r1;
        goto L_0x003d;
    L_0x0087:
        r0 = r10.u7;
        r0 = r8 - r0;
        r10.FH(r0);
        r0 = r4;
        goto L_0x0084;
    L_0x0090:
        r0 = r3;
        goto L_0x005e;
    L_0x0092:
        r2 = r3;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: wo.DW():byte[]");
    }

    private int j6(int i) {
        int m_ = this.DW.m_();
        while (i < m_ && this.DW.j6(i).j6() == this.u7) {
            int i2 = i + 1;
            un$b j6 = this.DW.j6(i);
            int VH = j6.VH();
            un$b un_b = this.Ws[VH];
            if (j6 == un_b) {
                i = i2;
            } else {
                this.Ws[VH] = j6;
                if (j6.FH()) {
                    if (un_b == null || !j6.DW(un_b)) {
                        FH(j6);
                    } else if (un_b.FH()) {
                        throw new RuntimeException("shouldn't happen");
                    } else {
                        DW(j6);
                    }
                } else if (j6.DW() != un$a.END_REPLACED) {
                    v5(j6);
                }
                i = i2;
            }
        }
        return i;
    }

    private int j6(int i, ArrayList<ut$a> arrayList) {
        int size = arrayList.size();
        while (i < size && ((ut$a) arrayList.get(i)).j6() == this.u7) {
            int i2 = i + 1;
            j6((ut$a) arrayList.get(i));
            i = i2;
        }
        return i;
    }

    private void j6(ArrayList<ut$a> arrayList, ArrayList<un$b> arrayList2) {
        int i;
        un$b un_b;
        int i2 = 0;
        int i3 = (this.EQ == null && this.we == null) ? 0 : 1;
        int VH = this.FH.VH();
        if (arrayList.size() > 0) {
            this.tp = ((ut$a) arrayList.get(0)).DW().j6();
        }
        this.FH.v5(this.tp);
        if (i3 != 0) {
            j6(this.FH.VH() - VH, "line_start: " + this.tp);
        }
        VH = Hw();
        abk FH = this.VH.FH();
        int m_ = FH.m_();
        if (this.gn) {
            i = VH;
        } else {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                un_b = (un$b) it.next();
                if (VH == un_b.VH()) {
                    this.Ws[VH] = un_b;
                    break;
                }
            }
            i = VH + 1;
        }
        VH = this.FH.VH();
        this.FH.v5(m_);
        if (i3 != 0) {
            j6(this.FH.VH() - VH, String.format("parameters_size: %04x", new Object[]{Integer.valueOf(m_)}));
        }
        VH = i;
        for (int i4 = 0; i4 < m_; i4++) {
            abl DW = FH.DW(i4);
            int VH2 = this.FH.VH();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String Hw;
                un_b = (un$b) it2.next();
                if (VH == un_b.VH()) {
                    if (un_b.v5() != null) {
                        j6(null);
                    } else {
                        j6(un_b.Hw());
                    }
                    this.Ws[VH] = un_b;
                    if (un_b == null) {
                        j6(null);
                    }
                    if (i3 == 0) {
                        if (un_b == null && un_b.v5() == null) {
                            Hw = un_b.Hw().Hw();
                        } else {
                            Hw = "<unnamed>";
                        }
                        j6(this.FH.VH() - VH2, "parameter " + Hw + " " + "v" + VH);
                    }
                    VH += DW.tp();
                }
            }
            un_b = null;
            if (un_b == null) {
                j6(null);
            }
            if (i3 == 0) {
                if (un_b == null) {
                }
                Hw = "<unnamed>";
                j6(this.FH.VH() - VH2, "parameter " + Hw + " " + "v" + VH);
            }
            VH += DW.tp();
        }
        un$b[] un_bArr = this.Ws;
        i3 = un_bArr.length;
        while (i2 < i3) {
            un$b un_b2 = un_bArr[i2];
            if (!(un_b2 == null || un_b2.v5() == null)) {
                Hw(un_b2);
            }
            i2++;
        }
    }

    private ArrayList<ut$a> FH() {
        int i = 0;
        int m_ = this.j6 == null ? 0 : this.j6.m_();
        Object arrayList = new ArrayList(m_);
        while (i < m_) {
            arrayList.add(this.j6.j6(i));
            i++;
        }
        Collections.sort(arrayList, new wo$1(this));
        return arrayList;
    }

    private int Hw() {
        return (this.Zo - this.VH.FH().v5()) - (this.gn ? 0 : 1);
    }

    private ArrayList<un$b> v5() {
        Object arrayList = new ArrayList(this.VH.FH().m_());
        int Hw = Hw();
        BitSet bitSet = new BitSet(this.Zo - Hw);
        int m_ = this.DW.m_();
        for (int i = 0; i < m_; i++) {
            un$b j6 = this.DW.j6(i);
            int VH = j6.VH();
            if (VH >= Hw && !bitSet.get(VH - Hw)) {
                bitSet.set(VH - Hw);
                arrayList.add(j6);
            }
        }
        Collections.sort(arrayList, new wo$2(this));
        return arrayList;
    }

    private String j6(un$b un_b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("v");
        stringBuilder.append(un_b.VH());
        stringBuilder.append(' ');
        abe Hw = un_b.Hw();
        if (Hw == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(Hw.Hw());
        }
        stringBuilder.append(' ');
        abf Zo = un_b.Zo();
        if (Zo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(Zo.Hw());
        }
        Hw = un_b.v5();
        if (Hw != null) {
            stringBuilder.append(' ');
            stringBuilder.append(Hw.Hw());
        }
        return stringBuilder.toString();
    }

    private void DW(un$b un_b) {
        int VH = this.FH.VH();
        this.FH.FH(6);
        Hw(un_b.VH());
        if (this.EQ != null || this.we != null) {
            j6(this.FH.VH() - VH, String.format("%04x: +local restart %s", new Object[]{Integer.valueOf(this.u7), j6(un_b)}));
        }
    }

    private void j6(abe abe) {
        if (abe == null || this.Hw == null) {
            this.FH.v5(0);
        } else {
            this.FH.v5(this.Hw.VH().DW(abe) + 1);
        }
    }

    private void j6(abf abf) {
        if (abf == null || this.Hw == null) {
            this.FH.v5(0);
        } else {
            this.FH.v5(this.Hw.tp().DW(abf) + 1);
        }
    }

    private void FH(un$b un_b) {
        if (un_b.v5() != null) {
            Hw(un_b);
            return;
        }
        int VH = this.FH.VH();
        this.FH.FH(3);
        Hw(un_b.VH());
        j6(un_b.Hw());
        j6(un_b.Zo());
        if (this.EQ != null || this.we != null) {
            j6(this.FH.VH() - VH, String.format("%04x: +local %s", new Object[]{Integer.valueOf(this.u7), j6(un_b)}));
        }
    }

    private void Hw(un$b un_b) {
        int VH = this.FH.VH();
        this.FH.FH(4);
        Hw(un_b.VH());
        j6(un_b.Hw());
        j6(un_b.Zo());
        j6(un_b.v5());
        if (this.EQ != null || this.we != null) {
            j6(this.FH.VH() - VH, String.format("%04x: +localx %s", new Object[]{Integer.valueOf(this.u7), j6(un_b)}));
        }
    }

    private void v5(un$b un_b) {
        int VH = this.FH.VH();
        this.FH.FH(5);
        this.FH.v5(un_b.VH());
        if (this.EQ != null || this.we != null) {
            j6(this.FH.VH() - VH, String.format("%04x: -local %s", new Object[]{Integer.valueOf(this.u7), j6(un_b)}));
        }
    }

    private void j6(ut$a ut_a) {
        int j6 = ut_a.DW().j6();
        j6 -= this.tp;
        int j62 = ut_a.j6() - this.u7;
        if (j62 < 0) {
            throw new RuntimeException("Position entries must be in ascending address order");
        }
        if (j6 < -4 || j6 > 10) {
            DW(j6);
            j6 = 0;
        }
        int j63 = j6(j6, j62);
        if ((j63 & -256) > 0) {
            FH(j62);
            j62 = j6(j6, 0);
            if ((j62 & -256) > 0) {
                DW(j6);
                j62 = 0;
                j63 = j6(0, 0);
                j6 = 0;
            } else {
                j63 = j62;
                j62 = j6;
                j6 = 0;
            }
        } else {
            int i = j62;
            j62 = j6;
            j6 = i;
        }
        this.FH.FH(j63);
        this.tp = j62 + this.tp;
        this.u7 = j6 + this.u7;
        if (this.EQ != null || this.we != null) {
            j6(1, String.format("%04x: line %d", new Object[]{Integer.valueOf(this.u7), Integer.valueOf(this.tp)}));
        }
    }

    private static int j6(int i, int i2) {
        if (i >= -4 && i <= 10) {
            return ((i + 4) + (i2 * 15)) + 10;
        }
        throw new RuntimeException("Parameter out of range");
    }

    private void DW(int i) {
        int VH = this.FH.VH();
        this.FH.FH(2);
        this.FH.Zo(i);
        this.tp += i;
        if (this.EQ != null || this.we != null) {
            j6(this.FH.VH() - VH, String.format("line = %d", new Object[]{Integer.valueOf(this.tp)}));
        }
    }

    private void FH(int i) {
        int VH = this.FH.VH();
        this.FH.FH(1);
        this.FH.v5(i);
        this.u7 += i;
        if (this.EQ != null || this.we != null) {
            j6(this.FH.VH() - VH, String.format("%04x: advance pc", new Object[]{Integer.valueOf(this.u7)}));
        }
    }

    private void Hw(int i) {
        if (i < 0) {
            throw new RuntimeException("Signed value where unsigned required: " + i);
        }
        this.FH.v5(i);
    }

    private void Zo() {
        this.FH.FH(0);
        if (this.EQ != null || this.we != null) {
            j6(1, "end sequence");
        }
    }
}
