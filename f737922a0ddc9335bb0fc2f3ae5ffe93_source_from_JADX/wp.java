import java.io.PrintWriter;

public class wp extends xl {
    private byte[] DW;
    private final boolean FH;
    private final abb Hw;
    private final ue j6;

    public wp(ue ueVar, boolean z, abb abb) {
        super(1, -1);
        if (ueVar == null) {
            throw new NullPointerException("code == null");
        }
        this.j6 = ueVar;
        this.FH = z;
        this.Hw = abb;
    }

    public xd j6() {
        return xd.TYPE_DEBUG_INFO_ITEM;
    }

    public void j6(wq wqVar) {
    }

    protected void j6(xp xpVar, int i) {
        try {
            this.DW = j6(xpVar.v5(), null, null, null, false);
            j6(this.DW.length);
        } catch (Throwable e) {
            throw ada.j6(e, "...while placing debug info for " + this.Hw.Hw());
        }
    }

    public String DW() {
        throw new RuntimeException("unsupported");
    }

    public void j6(wq wqVar, acr acr, String str) {
        j6(wqVar, str, null, acr, false);
    }

    protected void a_(wq wqVar, acr acr) {
        if (acr.j6()) {
            acr.j6(VH() + " debug info");
            j6(wqVar, null, null, acr, true);
        }
        acr.j6(this.DW);
    }

    private byte[] j6(wq wqVar, String str, PrintWriter printWriter, acr acr, boolean z) {
        return DW(wqVar, str, printWriter, acr, z);
    }

    private byte[] DW(wq wqVar, String str, PrintWriter printWriter, acr acr, boolean z) {
        ut gn = this.j6.gn();
        un u7 = this.j6.u7();
        ug Zo = this.j6.Zo();
        wo woVar = new wo(gn, u7, wqVar, Zo.v5(), Zo.Zo(), this.FH, this.Hw);
        if (printWriter == null && acr == null) {
            return woVar.j6();
        }
        return woVar.j6(str, printWriter, acr, z);
    }
}
