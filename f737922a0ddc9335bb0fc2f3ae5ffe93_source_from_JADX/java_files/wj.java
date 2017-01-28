import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class wj {
    private ub DW;
    private byte[] FH;
    private int Hw;
    private final ue j6;
    private TreeMap<ua, Integer> v5;

    public wj(ue ueVar) {
        this.j6 = ueVar;
        this.DW = null;
        this.FH = null;
        this.Hw = 0;
        this.v5 = null;
    }

    private void FH() {
        if (this.DW == null) {
            this.DW = this.j6.VH();
        }
    }

    public int j6() {
        FH();
        return this.DW.m_();
    }

    public void j6(wq wqVar) {
        int i;
        FH();
        xv tp = wqVar.tp();
        int m_ = this.DW.m_();
        this.v5 = new TreeMap();
        for (i = 0; i < m_; i++) {
            this.v5.put(this.DW.j6(i).FH(), null);
        }
        if (this.v5.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        acv acv = new acv();
        this.Hw = acv.v5(this.v5.size());
        for (Entry entry : this.v5.entrySet()) {
            ua uaVar = (ua) entry.getKey();
            int m_2 = uaVar.m_();
            boolean v5 = uaVar.v5();
            entry.setValue(Integer.valueOf(acv.VH()));
            if (v5) {
                acv.Zo(-(m_2 - 1));
                i = m_2 - 1;
            } else {
                acv.Zo(m_2);
                i = m_2;
            }
            for (m_2 = 0; m_2 < i; m_2++) {
                ua$a j6 = uaVar.j6(m_2);
                acv.v5(tp.DW(j6.j6()));
                acv.v5(j6.DW());
            }
            if (v5) {
                acv.v5(uaVar.j6(i).DW());
            }
        }
        this.FH = acv.Zo();
    }

    public int DW() {
        return (j6() * 8) + this.FH.length;
    }

    public void j6(wq wqVar, acr acr) {
        FH();
        if (acr.j6()) {
            j6("  ", null, acr);
        }
        int m_ = this.DW.m_();
        for (int i = 0; i < m_; i++) {
            ub$a j6 = this.DW.j6(i);
            int j62 = j6.j6();
            int DW = j6.DW();
            int i2 = DW - j62;
            if (i2 >= 65536) {
                throw new UnsupportedOperationException("bogus exception range: " + add.j6(j62) + ".." + add.j6(DW));
            }
            acr.Hw(j62);
            acr.DW(i2);
            acr.DW(((Integer) this.v5.get(j6.FH())).intValue());
        }
        acr.j6(this.FH);
    }

    private void j6(String str, PrintWriter printWriter, acr acr) {
        int i;
        int i2;
        int i3 = 0;
        FH();
        int i4 = acr != null ? 1 : 0;
        if (i4 != 0) {
            i = 6;
        } else {
            i = 0;
        }
        if (i4 != 0) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int m_ = this.DW.m_();
        String str2 = str + "  ";
        if (i4 != 0) {
            acr.j6(0, str + "tries:");
        } else {
            printWriter.println(str + "tries:");
        }
        for (int i5 = 0; i5 < m_; i5++) {
            ub$a j6 = this.DW.j6(i5);
            ua FH = j6.FH();
            String str3 = str2 + "try " + add.Hw(j6.j6()) + ".." + add.Hw(j6.DW());
            String j62 = FH.j6(str2, "");
            if (i4 != 0) {
                acr.j6(i, str3);
                acr.j6(i2, j62);
            } else {
                printWriter.println(str3);
                printWriter.println(j62);
            }
        }
        if (i4 != 0) {
            acr.j6(0, str + "handlers:");
            acr.j6(this.Hw, str2 + "size: " + add.FH(this.v5.size()));
            ua uaVar = null;
            for (Entry entry : this.v5.entrySet()) {
                ua uaVar2 = (ua) entry.getKey();
                int intValue = ((Integer) entry.getValue()).intValue();
                if (uaVar != null) {
                    j6(uaVar, i3, intValue - i3, str2, printWriter, acr);
                }
                uaVar = uaVar2;
                i3 = intValue;
            }
            j6(uaVar, i3, this.FH.length - i3, str2, printWriter, acr);
        }
    }

    private static void j6(ua uaVar, int i, int i2, String str, PrintWriter printWriter, acr acr) {
        String j6 = uaVar.j6(str, add.FH(i) + ": ");
        if (printWriter != null) {
            printWriter.println(j6);
        }
        acr.j6(i2, j6);
    }
}
