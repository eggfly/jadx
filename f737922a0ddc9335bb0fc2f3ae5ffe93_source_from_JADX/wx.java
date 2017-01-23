import java.util.Collection;
import java.util.TreeMap;

public final class wx extends xg {
    private final TreeMap<aar, ww> j6;

    public wx(wq wqVar) {
        super("field_ids", wqVar);
        this.j6 = new TreeMap();
    }

    public Collection<? extends xc> j6() {
        return this.j6.values();
    }

    public xb j6(aah aah) {
        if (aah == null) {
            throw new NullPointerException("cst == null");
        }
        u7();
        xb xbVar = (xb) this.j6.get((aar) aah);
        if (xbVar != null) {
            return xbVar;
        }
        throw new IllegalArgumentException("not found");
    }

    public void j6(acr acr) {
        u7();
        int size = this.j6.size();
        int VH = size == 0 ? 0 : VH();
        if (acr.j6()) {
            acr.j6(4, "field_ids_size:  " + add.j6(size));
            acr.j6(4, "field_ids_off:   " + add.j6(VH));
        }
        acr.Hw(size);
        acr.Hw(VH);
    }

    public ww j6(aar aar) {
        if (aar == null) {
            throw new NullPointerException("field == null");
        }
        tp();
        ww wwVar = (ww) this.j6.get(aar);
        if (wwVar != null) {
            return wwVar;
        }
        wwVar = new ww(aar);
        this.j6.put(aar, wwVar);
        return wwVar;
    }

    public int DW(aar aar) {
        if (aar == null) {
            throw new NullPointerException("ref == null");
        }
        u7();
        ww wwVar = (ww) this.j6.get(aar);
        if (wwVar != null) {
            return wwVar.VH();
        }
        throw new IllegalArgumentException("not found");
    }
}
