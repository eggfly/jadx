public class aom implements aoc {
    private final aoc DW;
    private final String j6;

    public aom(String str, aoc aoc) {
        this.j6 = str;
        this.DW = aoc;
    }

    public String j6() {
        return this.j6;
    }

    public boolean DW() {
        return true;
    }

    public aoc FH() {
        aoc Hw = Hw();
        while (Hw.DW()) {
            Hw = Hw.Hw();
        }
        return Hw;
    }

    public aoc Hw() {
        return this.DW;
    }

    public ans v5() {
        return FH().v5();
    }

    public aoc$a Zo() {
        return aoc$a.LOOSE;
    }

    public ans VH() {
        return FH().VH();
    }

    public boolean gn() {
        return FH().gn();
    }

    public String toString() {
        aoc Hw;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SymbolicRef[");
        while (Hw.DW()) {
            stringBuilder.append(Hw.j6());
            stringBuilder.append(" -> ");
            Hw = Hw.Hw();
        }
        stringBuilder.append(Hw.j6());
        stringBuilder.append('=');
        stringBuilder.append(ans.j6(Hw.v5()));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
