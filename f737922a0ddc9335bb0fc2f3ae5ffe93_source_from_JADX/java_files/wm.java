import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

public final class wm extends xx {
    private ArrayList<wl> DW;
    private final TreeMap<abl, wl> j6;

    public wm(wq wqVar) {
        super("class_defs", wqVar, 4);
        this.j6 = new TreeMap();
        this.DW = null;
    }

    public Collection<? extends xc> j6() {
        if (this.DW != null) {
            return this.DW;
        }
        return this.j6.values();
    }

    public void j6(acr acr) {
        u7();
        int size = this.j6.size();
        int VH = size == 0 ? 0 : VH();
        if (acr.j6()) {
            acr.j6(4, "class_defs_size: " + add.j6(size));
            acr.j6(4, "class_defs_off:  " + add.j6(VH));
        }
        acr.Hw(size);
        acr.Hw(VH);
    }

    public void j6(wl wlVar) {
        try {
            abl u7 = wlVar.FH().u7();
            tp();
            if (this.j6.get(u7) != null) {
                throw new IllegalArgumentException("already added: " + u7);
            }
            this.j6.put(u7, wlVar);
        } catch (NullPointerException e) {
            throw new NullPointerException("clazz == null");
        }
    }

    protected void DW() {
        int size = this.j6.size();
        this.DW = new ArrayList(size);
        int i = 0;
        for (abl j6 : this.j6.keySet()) {
            i = j6(j6, i, size - i);
        }
    }

    private int j6(abl abl, int i, int i2) {
        wl wlVar = (wl) this.j6.get(abl);
        if (wlVar == null || wlVar.Zo()) {
            return i;
        }
        if (i2 < 0) {
            throw new RuntimeException("class circularity with " + abl);
        }
        int i3 = i2 - 1;
        abf Hw = wlVar.Hw();
        if (Hw != null) {
            i = j6(Hw.u7(), i, i3);
        }
        abn v5 = wlVar.v5();
        int m_ = v5.m_();
        for (int i4 = 0; i4 < m_; i4++) {
            i = j6(v5.j6(i4), i, i3);
        }
        wlVar.j6(i);
        this.DW.add(wlVar);
        return i + 1;
    }
}
