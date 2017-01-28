import java.util.Set;

public class gv implements bj {
    private ha DW;
    private gz FH;
    private gb Hw;
    private hb VH;
    private gg Zo;
    private final cc j6;
    private hc v5;

    public /* synthetic */ bn VH() {
        return we();
    }

    public /* synthetic */ bk Zo() {
        return EQ();
    }

    public /* synthetic */ be gn() {
        return J8();
    }

    public /* synthetic */ bc u7() {
        return J0();
    }

    public gv(cc ccVar) {
        this.j6 = ccVar;
        if (ccVar != null) {
            this.DW = new ha(ccVar.ro);
            this.v5 = new hc(ccVar, this);
            this.Hw = new gb(ccVar, this);
            this.FH = new gz(ccVar, this);
            this.Zo = new gg(ccVar, this);
            this.VH = new hb(ccVar, this);
        }
    }

    public String j6() {
        return "Java";
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
        return gf.Hw();
    }

    public void DW() {
        this.FH.j6();
        this.Hw.j6();
    }

    public bl Hw() {
        return this.DW;
    }

    public bm v5() {
        return this.VH;
    }

    public hc we() {
        return this.v5;
    }

    public gb J0() {
        return this.Hw;
    }

    public gz EQ() {
        return this.FH;
    }

    public gg J8() {
        return this.Zo;
    }
}
