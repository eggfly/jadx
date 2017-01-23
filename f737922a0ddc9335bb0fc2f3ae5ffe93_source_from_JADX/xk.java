import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class xk extends xp {
    private static final Comparator<xl> j6;
    private final ArrayList<xl> DW;
    private final HashMap<xl, xl> FH;
    private final xk$a Hw;
    private int v5;

    static {
        j6 = new xk$1();
    }

    public xk(String str, wq wqVar, int i, xk$a xk_a) {
        super(str, wqVar, i);
        this.DW = new ArrayList(100);
        this.FH = new HashMap(100);
        this.Hw = xk_a;
        this.v5 = -1;
    }

    public Collection<? extends xc> j6() {
        return this.DW;
    }

    public int o_() {
        u7();
        return this.v5;
    }

    public int j6(xc xcVar) {
        return ((xl) xcVar).v5();
    }

    public void j6(xl xlVar) {
        tp();
        try {
            if (xlVar.Zo() > Zo()) {
                throw new IllegalArgumentException("incompatible item alignment");
            }
            this.DW.add(xlVar);
        } catch (NullPointerException e) {
            throw new NullPointerException("item == null");
        }
    }

    public <T extends xl> T DW(T t) {
        tp();
        xl xlVar = (xl) this.FH.get(t);
        if (xlVar != null) {
            return xlVar;
        }
        j6((xl) t);
        this.FH.put(t, t);
        return t;
    }

    public void j6(acr acr, xd xdVar, String str) {
        u7();
        TreeMap treeMap = new TreeMap();
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            xl xlVar = (xl) it.next();
            if (xlVar.j6() == xdVar) {
                treeMap.put(xlVar.DW(), xlVar);
            }
        }
        if (treeMap.size() != 0) {
            acr.j6(0, str);
            for (Entry entry : treeMap.entrySet()) {
                acr.j6(0, ((xl) entry.getValue()).VH() + ' ' + ((String) entry.getKey()) + '\n');
            }
        }
    }

    protected void FH() {
        wq v5 = v5();
        int i = 0;
        while (true) {
            int size = this.DW.size();
            if (i < size) {
                int i2 = i;
                while (i2 < size) {
                    ((xl) this.DW.get(i2)).j6(v5);
                    i2++;
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public void Hw() {
        u7();
        switch (xk$2.j6[this.Hw.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                Collections.sort(this.DW);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                Collections.sort(this.DW, j6);
                break;
        }
        int size = this.DW.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            xl xlVar = (xl) this.DW.get(i);
            try {
                int DW = xlVar.DW(this, i2);
                if (DW < i2) {
                    throw new RuntimeException("bogus place() result for " + xlVar);
                }
                i2 = DW + xlVar.n_();
                i++;
            } catch (Throwable e) {
                throw ada.j6(e, "...while placing " + xlVar);
            }
        }
        this.v5 = i2;
    }

    protected void a_(acr acr) {
        boolean j6 = acr.j6();
        wq v5 = v5();
        Iterator it = this.DW.iterator();
        int i = 0;
        int i2 = 1;
        while (it.hasNext()) {
            xl xlVar = (xl) it.next();
            if (j6) {
                if (i2 != 0) {
                    i2 = 0;
                } else {
                    acr.j6(0, "\n");
                }
            }
            int Zo = xlVar.Zo() - 1;
            Zo = (Zo ^ -1) & (i + Zo);
            if (i != Zo) {
                acr.VH(Zo - i);
                i = Zo;
            }
            xlVar.j6(v5, acr);
            i = xlVar.n_() + i;
        }
        if (i != this.v5) {
            throw new RuntimeException("output size mismatch");
        }
    }
}
