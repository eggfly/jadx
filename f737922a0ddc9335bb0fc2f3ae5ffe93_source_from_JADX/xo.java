import java.util.Collection;
import java.util.TreeMap;

public final class xo extends xx {
    private final TreeMap<abj, xn> j6;

    public xo(wq wqVar) {
        super("proto_ids", wqVar, 4);
        this.j6 = new TreeMap();
    }

    public Collection<? extends xc> j6() {
        return this.j6.values();
    }

    public void DW(acr acr) {
        u7();
        int size = this.j6.size();
        int VH = size == 0 ? 0 : VH();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many proto ids");
        }
        if (acr.j6()) {
            acr.j6(4, "proto_ids_size:  " + add.j6(size));
            acr.j6(4, "proto_ids_off:   " + add.j6(VH));
        }
        acr.Hw(size);
        acr.Hw(VH);
    }

    public xn j6(abj abj) {
        if (abj == null) {
            throw new NullPointerException("prototype == null");
        }
        tp();
        xn xnVar = (xn) this.j6.get(abj);
        if (xnVar != null) {
            return xnVar;
        }
        xnVar = new xn(abj);
        this.j6.put(abj, xnVar);
        return xnVar;
    }

    public int DW(abj abj) {
        if (abj == null) {
            throw new NullPointerException("prototype == null");
        }
        u7();
        xn xnVar = (xn) this.j6.get(abj);
        if (xnVar != null) {
            return xnVar.VH();
        }
        throw new IllegalArgumentException("not found");
    }

    protected void DW() {
        int i = 0;
        for (xn j6 : j6()) {
            j6.j6(i);
            i++;
        }
    }
}
