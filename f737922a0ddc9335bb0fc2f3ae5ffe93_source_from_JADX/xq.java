import java.util.HashMap;
import java.util.TreeMap;

public final class xq {
    private final HashMap<String, xq$a> j6;

    public xq() {
        this.j6 = new HashMap(50);
    }

    public void j6(xc xcVar) {
        String u7 = xcVar.u7();
        xq$a xq_a = (xq$a) this.j6.get(u7);
        if (xq_a == null) {
            this.j6.put(u7, new xq$a(xcVar, u7));
        } else {
            xq_a.j6(xcVar);
        }
    }

    public void j6(xp xpVar) {
        for (xc j6 : xpVar.j6()) {
            j6(j6);
        }
    }

    public final void j6(acr acr) {
        if (this.j6.size() != 0) {
            acr.j6(0, "\nstatistics:\n");
            TreeMap treeMap = new TreeMap();
            for (xq$a xq_a : this.j6.values()) {
                treeMap.put(xq_a.j6, xq_a);
            }
            for (xq$a xq_a2 : treeMap.values()) {
                xq_a2.j6(acr);
            }
        }
    }
}
