import java.util.ArrayList;
import java.util.List;

public final class xm implements adq, Comparable<xm> {
    private final zf DW;
    private final xy<wg> FH;
    private final abb j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((xm) obj);
    }

    public xm(abb abb, zf zfVar) {
        if (abb == null) {
            throw new NullPointerException("method == null");
        } else if (zfVar == null) {
            throw new NullPointerException("annotationsList == null");
        } else {
            this.j6 = abb;
            this.DW = zfVar;
            int m_ = zfVar.m_();
            List arrayList = new ArrayList(m_);
            for (int i = 0; i < m_; i++) {
                arrayList.add(new wg(new wf(zfVar.j6(i))));
            }
            this.FH = new xy(xd.TYPE_ANNOTATION_SET_REF_LIST, arrayList);
        }
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof xm) {
            return this.j6.equals(((xm) obj).j6);
        }
        return false;
    }

    public int j6(xm xmVar) {
        return this.j6.j6(xmVar.j6);
    }

    public void j6(wq wqVar) {
        xj J0 = wqVar.J0();
        xk Hw = wqVar.Hw();
        J0.j6(this.j6);
        Hw.j6(this.FH);
    }

    public void j6(wq wqVar, acr acr) {
        int DW = wqVar.J0().DW(this.j6);
        int v5 = this.FH.v5();
        if (acr.j6()) {
            acr.j6(0, "    " + this.j6.Hw());
            acr.j6(4, "      method_idx:      " + add.j6(DW));
            acr.j6(4, "      annotations_off: " + add.j6(v5));
        }
        acr.Hw(DW);
        acr.Hw(v5);
    }

    public String Hw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j6.Hw());
        stringBuilder.append(": ");
        Object obj = 1;
        for (wg wgVar : this.FH.FH()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(wgVar.DW());
        }
        return stringBuilder.toString();
    }
}
