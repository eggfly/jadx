import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public abstract class auo {
    private final char[] DW;
    private final Set<String> FH;
    private final Set<ans> Hw;
    private boolean VH;
    private boolean Zo;
    private final StringBuilder j6;
    private aoh v5;

    protected abstract void DW();

    protected abstract void j6(CharSequence charSequence);

    public auo() {
        this.j6 = new StringBuilder(100);
        this.DW = new char[40];
        this.FH = new LinkedHashSet();
        this.Hw = new HashSet();
        this.VH = true;
    }

    public void j6(aoh aoh) {
        this.v5 = aoh;
    }

    public void j6(boolean z) {
        this.Zo = z;
    }

    public void j6(String str) {
        this.FH.add(str);
    }

    public Set<ans> j6(Map<String, aoc> map) {
        for (aoc aoc : DW(map)) {
            aoc aoc2;
            if (aoc2.v5() != null) {
                FH(aoc2.v5(), aoc2.j6());
                if (this.Zo) {
                    if (!aoc2.gn()) {
                        if (this.v5 != null) {
                            aoc2 = this.v5.j6(aoc2);
                        }
                    }
                    if (aoc2.VH() != null) {
                        FH(aoc2.VH(), aoc2.j6() + "^{}");
                    }
                }
            }
        }
        return this.Hw;
    }

    private Iterable<aoc> DW(Map<String, aoc> map) {
        if ((map instanceof axg) || ((map instanceof SortedMap) && ((SortedMap) map).comparator() == null)) {
            return map.values();
        }
        return aod.j6(map.values());
    }

    public void j6(anb anb) {
        DW(anb, ".have");
    }

    public boolean j6() {
        return this.VH;
    }

    private void DW(anb anb, String str) {
        if (!this.Hw.contains(anb)) {
            FH(anb, str);
        }
    }

    private void FH(anb anb, String str) {
        this.Hw.add(anb.v5());
        j6(anb, str);
    }

    public void j6(anb anb, String str) {
        this.j6.setLength(0);
        anb.j6(this.DW, this.j6);
        this.j6.append(' ');
        this.j6.append(str);
        if (this.VH) {
            this.VH = false;
            if (!this.FH.isEmpty()) {
                this.j6.append('\u0000');
                for (String str2 : this.FH) {
                    this.j6.append(' ');
                    this.j6.append(str2);
                }
                this.j6.append(' ');
            }
        }
        this.j6.append('\n');
        j6(this.j6);
    }
}
