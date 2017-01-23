import java.util.Map.Entry;

class axg$a implements Entry<String, aoc> {
    private aoc DW;
    final /* synthetic */ axg j6;

    public /* synthetic */ Object getKey() {
        return j6();
    }

    public /* synthetic */ Object getValue() {
        return DW();
    }

    public /* synthetic */ Object setValue(Object obj) {
        return j6((aoc) obj);
    }

    axg$a(axg axg, aoc aoc) {
        this.j6 = axg;
        this.DW = aoc;
    }

    public String j6() {
        return this.j6.j6(this.DW);
    }

    public aoc DW() {
        return this.DW;
    }

    public aoc j6(aoc aoc) {
        aoc j6 = this.j6.j6(j6(), aoc);
        this.DW = aoc;
        return j6;
    }

    public int hashCode() {
        return j6().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Entry) {
            Object key = ((Entry) obj).getKey();
            Object value = ((Entry) obj).getValue();
            if ((key instanceof String) && (value instanceof aoc)) {
                aoc aoc = (aoc) value;
                if (aoc.j6().equals(this.DW.j6())) {
                    anb v5 = aoc.v5();
                    anb v52 = this.DW.v5();
                    if (!(v5 == null || v52 == null || !anb.j6(v5, v52))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return this.DW.toString();
    }
}
