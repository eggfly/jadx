import java.util.Collection;
import java.util.TreeMap;

public final class xt extends xx {
    private final TreeMap<abe, xs> j6;

    public xt(wq wqVar) {
        super("string_ids", wqVar, 4);
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
        xb xbVar = (xb) this.j6.get((abe) aah);
        if (xbVar != null) {
            return xbVar;
        }
        throw new IllegalArgumentException("not found");
    }

    public void DW(acr acr) {
        u7();
        int size = this.j6.size();
        int VH = size == 0 ? 0 : VH();
        if (acr.j6()) {
            acr.j6(4, "string_ids_size: " + add.j6(size));
            acr.j6(4, "string_ids_off:  " + add.j6(VH));
        }
        acr.Hw(size);
        acr.Hw(VH);
    }

    public xs j6(abe abe) {
        return j6(new xs(abe));
    }

    public xs j6(xs xsVar) {
        if (xsVar == null) {
            throw new NullPointerException("string == null");
        }
        tp();
        abe FH = xsVar.FH();
        xs xsVar2 = (xs) this.j6.get(FH);
        if (xsVar2 != null) {
            return xsVar2;
        }
        this.j6.put(FH, xsVar);
        return xsVar;
    }

    public int DW(abe abe) {
        if (abe == null) {
            throw new NullPointerException("string == null");
        }
        u7();
        xs xsVar = (xs) this.j6.get(abe);
        if (xsVar != null) {
            return xsVar.VH();
        }
        throw new IllegalArgumentException("not found");
    }

    protected void DW() {
        int i = 0;
        for (xs j6 : this.j6.values()) {
            j6.j6(i);
            i++;
        }
    }
}
