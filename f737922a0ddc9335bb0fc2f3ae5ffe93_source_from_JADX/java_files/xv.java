import java.util.Collection;
import java.util.TreeMap;

public final class xv extends xx {
    private final TreeMap<abl, xu> j6;

    public xv(wq wqVar) {
        super("type_ids", wqVar, 4);
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
        xb xbVar = (xb) this.j6.get(((abf) aah).u7());
        if (xbVar != null) {
            return xbVar;
        }
        throw new IllegalArgumentException("not found: " + aah);
    }

    public void DW(acr acr) {
        u7();
        int size = this.j6.size();
        int VH = size == 0 ? 0 : VH();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many type ids");
        }
        if (acr.j6()) {
            acr.j6(4, "type_ids_size:   " + add.j6(size));
            acr.j6(4, "type_ids_off:    " + add.j6(VH));
        }
        acr.Hw(size);
        acr.Hw(VH);
    }

    public xu j6(abl abl) {
        if (abl == null) {
            throw new NullPointerException("type == null");
        }
        tp();
        xu xuVar = (xu) this.j6.get(abl);
        if (xuVar != null) {
            return xuVar;
        }
        xuVar = new xu(new abf(abl));
        this.j6.put(abl, xuVar);
        return xuVar;
    }

    public xu j6(abf abf) {
        if (abf == null) {
            throw new NullPointerException("type == null");
        }
        tp();
        abl u7 = abf.u7();
        xu xuVar = (xu) this.j6.get(u7);
        if (xuVar != null) {
            return xuVar;
        }
        xuVar = new xu(abf);
        this.j6.put(u7, xuVar);
        return xuVar;
    }

    public int DW(abl abl) {
        if (abl == null) {
            throw new NullPointerException("type == null");
        }
        u7();
        xu xuVar = (xu) this.j6.get(abl);
        if (xuVar != null) {
            return xuVar.VH();
        }
        throw new IllegalArgumentException("not found: " + abl);
    }

    public int DW(abf abf) {
        if (abf != null) {
            return DW(abf.u7());
        }
        throw new NullPointerException("type == null");
    }

    protected void DW() {
        int i = 0;
        for (xu j6 : j6()) {
            j6.j6(i);
            i++;
        }
    }
}
