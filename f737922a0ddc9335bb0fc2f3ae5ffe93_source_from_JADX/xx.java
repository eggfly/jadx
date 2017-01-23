import java.util.Collection;

public abstract class xx extends xp {
    protected abstract void DW();

    public xx(String str, wq wqVar, int i) {
        super(str, wqVar, i);
    }

    public final int o_() {
        Collection j6 = j6();
        int size = j6.size();
        if (size == 0) {
            return 0;
        }
        return ((xc) j6.iterator().next()).n_() * size;
    }

    protected final void FH() {
        wq v5 = v5();
        DW();
        for (xc j6 : j6()) {
            j6.j6(v5);
        }
    }

    protected final void a_(acr acr) {
        wq v5 = v5();
        int Zo = Zo();
        for (xc j6 : j6()) {
            j6.j6(v5, acr);
            acr.gn(Zo);
        }
    }

    public final int j6(xc xcVar) {
        xb xbVar = (xb) xcVar;
        return FH(xbVar.VH() * xbVar.n_());
    }
}
