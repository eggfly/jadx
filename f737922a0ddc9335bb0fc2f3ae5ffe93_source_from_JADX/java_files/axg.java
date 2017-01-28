import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class axg extends AbstractMap<String, aoc> {
    private axf<aoc> DW;
    private axf<aoc> FH;
    private axf<aoc> Hw;
    private Set<Entry<String, aoc>> VH;
    private boolean Zo;
    private final String j6;
    private int v5;

    public /* synthetic */ Object get(Object obj) {
        return j6(obj);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return j6((String) obj, (aoc) obj2);
    }

    public /* synthetic */ Object remove(Object obj) {
        return DW(obj);
    }

    public axg() {
        this.j6 = "";
        this.DW = axf.j6();
        this.FH = axf.j6();
        this.Hw = axf.j6();
    }

    public axg(String str, axf<? extends aoc> axf__extends_aoc, axf<? extends aoc> axf__extends_aoc2, axf<? extends aoc> axf__extends_aoc3) {
        this.j6 = str;
        this.DW = axf__extends_aoc;
        this.FH = axf__extends_aoc2;
        this.Hw = axf__extends_aoc3;
    }

    public boolean containsKey(Object obj) {
        return j6(obj) != null;
    }

    public aoc j6(Object obj) {
        String j6 = j6((String) obj);
        aoc FH = this.Hw.FH(j6);
        if (FH == null) {
            FH = this.FH.FH(j6);
        }
        if (FH == null) {
            return this.DW.FH(j6);
        }
        return FH;
    }

    public aoc j6(String str, aoc aoc) {
        String j6 = j6(str);
        if (j6.equals(aoc.j6())) {
            if (!this.Hw.Hw()) {
                Iterator it = this.Hw.iterator();
                while (it.hasNext()) {
                    this.FH = this.FH.j6((aoc) it.next());
                }
                this.Hw = axf.j6();
            }
            int j62 = this.FH.j6(j6);
            aoc FH;
            if (j62 >= 0) {
                FH = this.FH.FH(j6);
                this.FH = this.FH.j6(j62, aoc);
                return FH;
            }
            FH = j6((Object) str);
            this.FH = this.FH.DW(j62, aoc);
            this.Zo = false;
            return FH;
        }
        throw new IllegalArgumentException();
    }

    public aoc DW(Object obj) {
        String j6 = j6((String) obj);
        aoc aoc = null;
        int j62 = this.DW.j6(j6);
        if (j62 >= 0) {
            aoc = this.DW.FH(j6);
            this.DW = this.DW.FH(j62);
            this.Zo = false;
        }
        j62 = this.FH.j6(j6);
        if (j62 >= 0) {
            aoc = this.FH.FH(j6);
            this.FH = this.FH.FH(j62);
            this.Zo = false;
        }
        j62 = this.Hw.j6(j6);
        if (j62 < 0) {
            return aoc;
        }
        aoc = this.Hw.FH(j6);
        this.Hw = this.Hw.FH(j62);
        this.Zo = false;
        return aoc;
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public Set<Entry<String, aoc>> entrySet() {
        if (this.VH == null) {
            this.VH = new axg$1(this);
        }
        return this.VH;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Object obj = 1;
        for (aoc aoc : values()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(aoc);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private String j6(String str) {
        if (this.j6.length() > 0) {
            return this.j6 + str;
        }
        return str;
    }

    private String j6(aoc aoc) {
        String j6 = aoc.j6();
        if (this.j6.length() > 0) {
            return j6.substring(this.j6.length());
        }
        return j6;
    }
}
