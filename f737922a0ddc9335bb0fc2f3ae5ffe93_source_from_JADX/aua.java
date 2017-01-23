import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class aua {
    avn DW;
    final SortedMap<String, avb> FH;
    StringBuilder Hw;
    Map<String, aoc> j6;

    public aua() {
        this.j6 = Collections.emptyMap();
        this.FH = new TreeMap();
    }

    public Collection<aoc> j6() {
        return Collections.unmodifiableCollection(this.j6.values());
    }

    public final aoc j6(String str) {
        return (aoc) this.j6.get(str);
    }

    void j6(avn avn, Map<String, aoc> map) {
        this.DW = avn;
        this.j6 = map;
    }

    void j6(avb avb) {
        this.FH.put(avb.j6(), avb);
    }

    public String DW() {
        return this.Hw != null ? this.Hw.toString() : "";
    }

    void DW(String str) {
        if (str != null && str.length() > 0) {
            if (this.Hw == null) {
                this.Hw = new StringBuilder();
            }
            this.Hw.append(str);
            if (!str.endsWith("\n")) {
                this.Hw.append('\n');
            }
        }
    }
}
