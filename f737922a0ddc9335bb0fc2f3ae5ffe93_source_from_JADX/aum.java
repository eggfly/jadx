public class aum {
    private final ans DW;
    private final String FH;
    private aum$b Hw;
    private String VH;
    private aum$a Zo;
    private final ans j6;
    private aoc v5;

    public aum(ans ans, ans ans2, String str) {
        this.j6 = ans;
        this.DW = ans2;
        this.FH = str;
        this.Hw = aum$b.UPDATE;
        if (ans.Zo().DW((anb) ans)) {
            this.Hw = aum$b.CREATE;
        }
        if (ans.Zo().DW((anb) ans2)) {
            this.Hw = aum$b.DELETE;
        }
        this.Zo = aum$a.NOT_ATTEMPTED;
    }

    public ans j6() {
        return this.j6;
    }

    public ans DW() {
        return this.DW;
    }

    public String FH() {
        return this.FH;
    }

    public aum$b Hw() {
        return this.Hw;
    }

    public aoc v5() {
        return this.v5;
    }

    public aum$a Zo() {
        return this.Zo;
    }

    public String VH() {
        return this.VH;
    }

    public void j6(aum$a aum_a) {
        j6(aum_a, null);
    }

    public void j6(aum$a aum_a, String str) {
        this.Zo = aum_a;
        this.VH = str;
    }

    void j6(aoc aoc) {
        this.v5 = aoc;
    }

    void j6(aum$b aum_b) {
        this.Hw = aum_b;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(Hw().name())).append(": ").append(j6().DW()).append(" ").append(DW().DW()).append(" ").append(FH()).toString();
    }
}
