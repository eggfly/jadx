import java.util.ArrayList;
import java.util.List;

public final class xe extends xl {
    private final xp DW;
    private final xc FH;
    private final xc Hw;
    private final xd j6;
    private final int v5;

    public static void j6(xp[] xpVarArr, xk xkVar) {
        if (xpVarArr == null) {
            throw new NullPointerException("sections == null");
        } else if (xkVar.j6().size() != 0) {
            throw new IllegalArgumentException("mapSection.items().size() != 0");
        } else {
            List arrayList = new ArrayList(50);
            for (xp xpVar : xpVarArr) {
                int i = 0;
                xc xcVar = null;
                xc xcVar2 = null;
                xd xdVar = null;
                for (xc xcVar3 : xpVar.j6()) {
                    xd j6 = xcVar3.j6();
                    if (j6 != xdVar) {
                        if (i != 0) {
                            arrayList.add(new xe(xdVar, xpVar, xcVar2, xcVar, i));
                        }
                        i = 0;
                        xcVar2 = xcVar3;
                        xdVar = j6;
                    }
                    i++;
                    xcVar = xcVar3;
                }
                if (i != 0) {
                    arrayList.add(new xe(xdVar, xpVar, xcVar2, xcVar, i));
                } else if (xpVar == xkVar) {
                    arrayList.add(new xe(xkVar));
                }
            }
            xkVar.j6(new xy(xd.TYPE_MAP_LIST, arrayList));
        }
    }

    private xe(xd xdVar, xp xpVar, xc xcVar, xc xcVar2, int i) {
        super(4, 12);
        if (xdVar == null) {
            throw new NullPointerException("type == null");
        } else if (xpVar == null) {
            throw new NullPointerException("section == null");
        } else if (xcVar == null) {
            throw new NullPointerException("firstItem == null");
        } else if (xcVar2 == null) {
            throw new NullPointerException("lastItem == null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("itemCount <= 0");
        } else {
            this.j6 = xdVar;
            this.DW = xpVar;
            this.FH = xcVar;
            this.Hw = xcVar2;
            this.v5 = i;
        }
    }

    private xe(xp xpVar) {
        super(4, 12);
        if (xpVar == null) {
            throw new NullPointerException("section == null");
        }
        this.j6 = xd.TYPE_MAP_LIST;
        this.DW = xpVar;
        this.FH = null;
        this.Hw = null;
        this.v5 = 1;
    }

    public xd j6() {
        return xd.TYPE_MAP_ITEM;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.DW.toString());
        stringBuffer.append(' ');
        stringBuffer.append(this.j6.Hw());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void j6(wq wqVar) {
    }

    public final String DW() {
        return toString();
    }

    protected void a_(wq wqVar, acr acr) {
        int VH;
        int j6 = this.j6.j6();
        if (this.FH == null) {
            VH = this.DW.VH();
        } else {
            VH = this.DW.j6(this.FH);
        }
        if (acr.j6()) {
            acr.j6(0, VH() + ' ' + this.j6.DW() + " map");
            acr.j6(2, "  type:   " + add.FH(j6) + " // " + this.j6.toString());
            acr.j6(2, "  unused: 0");
            acr.j6(4, "  size:   " + add.j6(this.v5));
            acr.j6(4, "  offset: " + add.j6(VH));
        }
        acr.DW(j6);
        acr.DW(0);
        acr.Hw(this.v5);
        acr.Hw(VH);
    }
}
