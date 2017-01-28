import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class acb extends aci {
    private final ArrayList<acb$a> DW;
    private zx FH;
    private final int j6;

    public /* synthetic */ aci J8() {
        return j6();
    }

    public /* synthetic */ Object clone() {
        return j6();
    }

    public acb(zw zwVar, acg acg) {
        super(zwVar, acg);
        this.DW = new ArrayList();
        this.j6 = zwVar.VH();
    }

    public acb(int i, acg acg) {
        super(zw.j6(i, abl.u7), acg);
        this.DW = new ArrayList();
        this.j6 = i;
    }

    public acb j6() {
        throw new UnsupportedOperationException("can't clone phi");
    }

    public void j6(acj acj) {
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            acb$a acb_a = (acb$a) it.next();
            acb_a.j6 = acb_a.j6.j6(acj.FH(acb_a.j6.VH()).Ws().j6());
        }
        this.FH = null;
    }

    public void j6(abm abm, zq zqVar) {
        DW(zw.DW(Ws().VH(), abm, zqVar));
    }

    public int gn() {
        return this.j6;
    }

    public void j6(zw zwVar, acg acg) {
        this.DW.add(new acb$a(zwVar, acg.v5(), acg.Zo()));
        this.FH = null;
    }

    public void j6(zw zwVar) {
        Collection arrayList = new ArrayList();
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            acb$a acb_a = (acb$a) it.next();
            if (acb_a.j6.VH() == zwVar.VH()) {
                arrayList.add(acb_a);
            }
        }
        this.DW.removeAll(arrayList);
        this.FH = null;
    }

    public int j6(int i) {
        return ((acb$a) this.DW.get(i)).DW;
    }

    public zz v5() {
        return null;
    }

    public zo Zo() {
        return null;
    }

    public boolean EQ() {
        return false;
    }

    public zx DW() {
        if (this.FH != null) {
            return this.FH;
        }
        if (this.DW.size() == 0) {
            return zx.j6;
        }
        int size = this.DW.size();
        this.FH = new zx(size);
        for (int i = 0; i < size; i++) {
            this.FH.j6(i, ((acb$a) this.DW.get(i)).j6);
        }
        this.FH.l_();
        return this.FH;
    }

    public final void j6(acd acd) {
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            acb$a acb_a = (acb$a) it.next();
            zw zwVar = acb_a.j6;
            acb_a.j6 = acd.j6(zwVar);
            if (zwVar != acb_a.j6) {
                QX().Ws().j6((aci) this, zwVar, acb_a.j6);
            }
        }
        this.FH = null;
    }

    public zo FH() {
        throw new IllegalArgumentException("Cannot convert phi insns to rop form");
    }

    public List<acg> j6(int i, acj acj) {
        List arrayList = new ArrayList();
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            acb$a acb_a = (acb$a) it.next();
            if (acb_a.j6.VH() == i) {
                arrayList.add(acj.tp().get(acb_a.DW));
            }
        }
        return arrayList;
    }

    public boolean we() {
        return true;
    }

    public boolean J0() {
        return aca.j6() && VH() != null;
    }

    public void j6(aci$a aci_a) {
        aci_a.j6(this);
    }

    public String Hw() {
        return j6(null);
    }

    protected final String j6(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(aac.j6);
        stringBuffer.append(": phi");
        if (str != null) {
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")");
        }
        zw Ws = Ws();
        if (Ws == null) {
            stringBuffer.append(" .");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(Ws.Hw());
        }
        stringBuffer.append(" <-");
        int m_ = DW().m_();
        if (m_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < m_; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.FH.DW(i).Hw() + "[b=" + add.FH(((acb$a) this.DW.get(i)).FH) + "]");
            }
        }
        return stringBuffer.toString();
    }
}
