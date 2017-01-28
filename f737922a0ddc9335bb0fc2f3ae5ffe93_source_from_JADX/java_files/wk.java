import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public final class wk extends xl {
    private final ArrayList<ws> DW;
    private final HashMap<ws, aah> FH;
    private final ArrayList<ws> Hw;
    private aak VH;
    private final ArrayList<wu> Zo;
    private byte[] gn;
    private final abf j6;
    private final ArrayList<wu> v5;

    public wk(abf abf) {
        super(1, -1);
        if (abf == null) {
            throw new NullPointerException("thisClass == null");
        }
        this.j6 = abf;
        this.DW = new ArrayList(20);
        this.FH = new HashMap(40);
        this.Hw = new ArrayList(20);
        this.v5 = new ArrayList(20);
        this.Zo = new ArrayList(20);
        this.VH = null;
    }

    public xd j6() {
        return xd.TYPE_CLASS_DATA_ITEM;
    }

    public String DW() {
        return toString();
    }

    public boolean FH() {
        return this.DW.isEmpty() && this.Hw.isEmpty() && this.v5.isEmpty() && this.Zo.isEmpty();
    }

    public void j6(ws wsVar, aah aah) {
        if (wsVar == null) {
            throw new NullPointerException("field == null");
        } else if (this.VH != null) {
            throw new UnsupportedOperationException("static fields already sorted");
        } else {
            this.DW.add(wsVar);
            this.FH.put(wsVar, aah);
        }
    }

    public void j6(ws wsVar) {
        if (wsVar == null) {
            throw new NullPointerException("field == null");
        }
        this.Hw.add(wsVar);
    }

    public void j6(wu wuVar) {
        if (wuVar == null) {
            throw new NullPointerException("method == null");
        }
        this.v5.add(wuVar);
    }

    public void DW(wu wuVar) {
        if (wuVar == null) {
            throw new NullPointerException("method == null");
        }
        this.Zo.add(wuVar);
    }

    public void j6(wq wqVar) {
        Iterator it;
        if (!this.DW.isEmpty()) {
            Hw();
            it = this.DW.iterator();
            while (it.hasNext()) {
                ((ws) it.next()).j6(wqVar);
            }
        }
        if (!this.Hw.isEmpty()) {
            Collections.sort(this.Hw);
            it = this.Hw.iterator();
            while (it.hasNext()) {
                ((ws) it.next()).j6(wqVar);
            }
        }
        if (!this.v5.isEmpty()) {
            Collections.sort(this.v5);
            it = this.v5.iterator();
            while (it.hasNext()) {
                ((wu) it.next()).j6(wqVar);
            }
        }
        if (!this.Zo.isEmpty()) {
            Collections.sort(this.Zo);
            it = this.Zo.iterator();
            while (it.hasNext()) {
                ((wu) it.next()).j6(wqVar);
            }
        }
    }

    public aak Hw() {
        if (this.VH == null && this.DW.size() != 0) {
            this.VH = gn();
        }
        return this.VH;
    }

    private aak gn() {
        Collections.sort(this.DW);
        int size = this.DW.size();
        while (size > 0) {
            aah aah = (aah) this.FH.get((ws) this.DW.get(size - 1));
            if (!(aah instanceof aay)) {
                if (aah != null) {
                    break;
                }
            } else if (((aay) aah).EQ() != 0) {
                break;
            }
            size--;
        }
        if (size == 0) {
            return null;
        }
        aak$a aak_a = new aak$a(size);
        for (int i = 0; i < size; i++) {
            ws wsVar = (ws) this.DW.get(i);
            aah aah2 = (aah) this.FH.get(wsVar);
            if (aah2 == null) {
                aah2 = abi.j6(wsVar.j6().j6());
            }
            aak_a.j6(i, aah2);
        }
        aak_a.l_();
        return new aak(aak_a);
    }

    protected void j6(xp xpVar, int i) {
        Object acv = new acv();
        DW(xpVar.v5(), acv);
        this.gn = acv.Zo();
        j6(this.gn.length);
    }

    private void DW(wq wqVar, acr acr) {
        boolean j6 = acr.j6();
        if (j6) {
            acr.j6(0, VH() + " class data for " + this.j6.Hw());
        }
        j6(wqVar, acr, "static_fields", this.DW.size());
        j6(wqVar, acr, "instance_fields", this.Hw.size());
        j6(wqVar, acr, "direct_methods", this.v5.size());
        j6(wqVar, acr, "virtual_methods", this.Zo.size());
        j6(wqVar, acr, "static_fields", this.DW);
        j6(wqVar, acr, "instance_fields", this.Hw);
        j6(wqVar, acr, "direct_methods", this.v5);
        j6(wqVar, acr, "virtual_methods", this.Zo);
        if (j6) {
            acr.FH();
        }
    }

    private static void j6(wq wqVar, acr acr, String str, int i) {
        if (acr.j6()) {
            acr.j6(String.format("  %-21s %08x", new Object[]{str + "_size:", Integer.valueOf(i)}));
        }
        acr.v5(i);
    }

    private static void j6(wq wqVar, acr acr, String str, ArrayList<? extends wt> arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (acr.j6()) {
                acr.j6(0, "  " + str + ":");
            }
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i = ((wt) arrayList.get(i2)).j6(wqVar, acr, i, i2);
            }
        }
    }

    public void a_(wq wqVar, acr acr) {
        if (acr.j6()) {
            DW(wqVar, acr);
        } else {
            acr.j6(this.gn);
        }
    }
}
