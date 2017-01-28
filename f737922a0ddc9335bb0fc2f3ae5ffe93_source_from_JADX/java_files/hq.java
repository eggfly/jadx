import java.util.Set;

public class hq implements bj {
    private hu DW;
    private hv FH;
    private he Hw;
    private hi VH;
    private ht Zo;
    private final cc j6;
    private hw v5;

    public hq(cc ccVar) {
        this.j6 = ccVar;
        if (ccVar != null) {
            this.DW = new hu(ccVar.ro);
            this.FH = new hv(ccVar, this);
            this.Hw = new he(ccVar, this);
            this.v5 = new hw(ccVar, this);
            this.Zo = new ht(ccVar, this);
            this.VH = new hi(ccVar);
        }
    }

    public String j6() {
        return "JavaScript";
    }

    public boolean j6(char c) {
        switch (c) {
            case '(':
            case ':':
            case ';':
            case '[':
            case '{':
            case '}':
                return true;
            default:
                return false;
        }
    }

    public Set<? extends bd> FH() {
        return hh.Hw();
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
        return this.Zo;
    }

    public bn VH() {
        return this.v5;
    }

    public be gn() {
        return this.VH;
    }

    public bc u7() {
        return this.Hw;
    }
}
