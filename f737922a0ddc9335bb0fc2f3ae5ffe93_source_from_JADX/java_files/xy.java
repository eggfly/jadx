import java.util.List;

public final class xy<T extends xl> extends xl {
    private final List<T> DW;
    private final xd j6;

    public xy(xd xdVar, List<T> list) {
        super(j6((List) list), DW(list));
        if (xdVar == null) {
            throw new NullPointerException("itemType == null");
        }
        this.DW = list;
        this.j6 = xdVar;
    }

    private static int j6(List<? extends xl> list) {
        try {
            return Math.max(4, ((xl) list.get(0)).Zo());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("items.size() == 0");
        } catch (NullPointerException e2) {
            throw new NullPointerException("items == null");
        }
    }

    private static int DW(List<? extends xl> list) {
        xl xlVar = (xl) list.get(0);
        return (xlVar.n_() * list.size()) + j6((List) list);
    }

    public xd j6() {
        return this.j6;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append(this.DW);
        return stringBuffer.toString();
    }

    public void j6(wq wqVar) {
        for (xl j6 : this.DW) {
            j6.j6(wqVar);
        }
    }

    public final String DW() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("{");
        Object obj = 1;
        for (xl xlVar : this.DW) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(xlVar.DW());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public final List<T> FH() {
        return this.DW;
    }

    protected void j6(xp xpVar, int i) {
        int Hw = i + Hw();
        Object obj = 1;
        int i2 = Hw;
        int i3 = -1;
        Hw = -1;
        for (xl xlVar : this.DW) {
            int n_ = xlVar.n_();
            if (obj != null) {
                i3 = xlVar.Zo();
                obj = null;
                Hw = n_;
            } else if (n_ != Hw) {
                throw new UnsupportedOperationException("item size mismatch");
            } else if (xlVar.Zo() != i3) {
                throw new UnsupportedOperationException("item alignment mismatch");
            }
            i2 = xlVar.DW(xpVar, i2) + n_;
        }
    }

    protected void a_(wq wqVar, acr acr) {
        int size = this.DW.size();
        if (acr.j6()) {
            acr.j6(0, VH() + " " + u7());
            acr.j6(4, "  size: " + add.j6(size));
        }
        acr.Hw(size);
        for (xl j6 : this.DW) {
            j6.j6(wqVar, acr);
        }
    }

    private int Hw() {
        return Zo();
    }
}
