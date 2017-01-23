import java.util.Collection;
import java.util.TreeMap;

public final class xj extends xg {
    private final TreeMap<aal, xi> j6;

    public xj(wq wqVar) {
        super("method_ids", wqVar);
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
        xb xbVar = (xb) this.j6.get((aal) aah);
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
            acr.j6(4, "method_ids_size: " + add.j6(size));
            acr.j6(4, "method_ids_off:  " + add.j6(VH));
        }
        acr.Hw(size);
        acr.Hw(VH);
    }

    public xi j6(aal aal) {
        if (aal == null) {
            throw new NullPointerException("method == null");
        }
        tp();
        xi xiVar = (xi) this.j6.get(aal);
        if (xiVar != null) {
            return xiVar;
        }
        xiVar = new xi(aal);
        this.j6.put(aal, xiVar);
        return xiVar;
    }

    public int DW(aal aal) {
        if (aal == null) {
            throw new NullPointerException("ref == null");
        }
        u7();
        xi xiVar = (xi) this.j6.get(aal);
        if (xiVar != null) {
            return xiVar.VH();
        }
        throw new IllegalArgumentException("not found");
    }
}
