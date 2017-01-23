import java.util.Set;

public class ih implements bj {
    private ik DW;
    private il FH;
    private ic Hw;
    private final cc j6;
    private boolean v5;

    public ih(cc ccVar, boolean z) {
        this.j6 = ccVar;
        this.v5 = z;
        if (ccVar != null) {
            this.Hw = new ic(ccVar.sG, ccVar.ro);
            this.DW = new ik();
            this.FH = new il(ccVar, this, z);
        }
    }

    public String j6() {
        return this.v5 ? "XML" : "HTML";
    }

    public Set<? extends bd> FH() {
        return if.j6(this.v5);
    }

    public boolean j6(char c) {
        return c == '>' || c == '%' || c == '/';
    }

    public void DW() {
    }

    public bl Hw() {
        return this.DW;
    }

    public bm v5() {
        return this.FH;
    }

    public bk Zo() {
        return null;
    }

    public bn VH() {
        return null;
    }

    public be gn() {
        return null;
    }

    public bc u7() {
        return this.Hw;
    }
}
