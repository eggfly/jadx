import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class wi extends xl {
    private ArrayList<wv> DW;
    private ArrayList<xh> FH;
    private ArrayList<xm> Hw;
    private wf j6;

    public wi() {
        super(4, -1);
        this.j6 = null;
        this.DW = null;
        this.FH = null;
        this.Hw = null;
    }

    public xd j6() {
        return xd.TYPE_ANNOTATIONS_DIRECTORY_ITEM;
    }

    public boolean FH() {
        return this.j6 == null && this.DW == null && this.FH == null && this.Hw == null;
    }

    public boolean Hw() {
        return this.j6 != null && this.DW == null && this.FH == null && this.Hw == null;
    }

    public int hashCode() {
        if (this.j6 == null) {
            return 0;
        }
        return this.j6.hashCode();
    }

    public int j6(xl xlVar) {
        if (Hw()) {
            return this.j6.FH(((wi) xlVar).j6);
        }
        throw new UnsupportedOperationException("uninternable instance");
    }

    public void j6(ze zeVar) {
        if (zeVar == null) {
            throw new NullPointerException("annotations == null");
        } else if (this.j6 != null) {
            throw new UnsupportedOperationException("class annotations already set");
        } else {
            this.j6 = new wf(zeVar);
        }
    }

    public void j6(aar aar, ze zeVar) {
        if (this.DW == null) {
            this.DW = new ArrayList();
        }
        this.DW.add(new wv(aar, new wf(zeVar)));
    }

    public void j6(abb abb, ze zeVar) {
        if (this.FH == null) {
            this.FH = new ArrayList();
        }
        this.FH.add(new xh(abb, new wf(zeVar)));
    }

    public void j6(abb abb, zf zfVar) {
        if (this.Hw == null) {
            this.Hw = new ArrayList();
        }
        this.Hw.add(new xm(abb, zfVar));
    }

    public void j6(wq wqVar) {
        Iterator it;
        xk Hw = wqVar.Hw();
        if (this.j6 != null) {
            this.j6 = (wf) Hw.DW(this.j6);
        }
        if (this.DW != null) {
            it = this.DW.iterator();
            while (it.hasNext()) {
                ((wv) it.next()).j6(wqVar);
            }
        }
        if (this.FH != null) {
            it = this.FH.iterator();
            while (it.hasNext()) {
                ((xh) it.next()).j6(wqVar);
            }
        }
        if (this.Hw != null) {
            it = this.Hw.iterator();
            while (it.hasNext()) {
                ((xm) it.next()).j6(wqVar);
            }
        }
    }

    public String DW() {
        throw new RuntimeException("unsupported");
    }

    protected void j6(xp xpVar, int i) {
        j6((((j6(this.DW) + j6(this.FH)) + j6(this.Hw)) * 8) + 16);
    }

    protected void a_(wq wqVar, acr acr) {
        Iterator it;
        boolean j6 = acr.j6();
        int DW = xl.DW(this.j6);
        int j62 = j6(this.DW);
        int j63 = j6(this.FH);
        int j64 = j6(this.Hw);
        if (j6) {
            acr.j6(0, VH() + " annotations directory");
            acr.j6(4, "  class_annotations_off: " + add.j6(DW));
            acr.j6(4, "  fields_size:           " + add.j6(j62));
            acr.j6(4, "  methods_size:          " + add.j6(j63));
            acr.j6(4, "  parameters_size:       " + add.j6(j64));
        }
        acr.Hw(DW);
        acr.Hw(j62);
        acr.Hw(j63);
        acr.Hw(j64);
        if (j62 != 0) {
            Collections.sort(this.DW);
            if (j6) {
                acr.j6(0, "  fields:");
            }
            it = this.DW.iterator();
            while (it.hasNext()) {
                ((wv) it.next()).j6(wqVar, acr);
            }
        }
        if (j63 != 0) {
            Collections.sort(this.FH);
            if (j6) {
                acr.j6(0, "  methods:");
            }
            it = this.FH.iterator();
            while (it.hasNext()) {
                ((xh) it.next()).j6(wqVar, acr);
            }
        }
        if (j64 != 0) {
            Collections.sort(this.Hw);
            if (j6) {
                acr.j6(0, "  parameters:");
            }
            Iterator it2 = this.Hw.iterator();
            while (it2.hasNext()) {
                ((xm) it2.next()).j6(wqVar, acr);
            }
        }
    }

    private static int j6(ArrayList<?> arrayList) {
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
