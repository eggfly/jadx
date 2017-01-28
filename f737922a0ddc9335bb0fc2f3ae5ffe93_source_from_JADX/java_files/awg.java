import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class awg extends awl {
    private final int DW;
    private final LinkedList<String> VH;
    private final Set<String> Zo;
    private final LinkedList<String> gn;
    private final int j6;
    private final boolean v5;

    public awg(int i, int i2) {
        this(i, i2, true);
    }

    public awg(int i, int i2, boolean z) {
        this.Zo = new HashSet();
        this.VH = new LinkedList();
        this.gn = new LinkedList();
        this.j6 = i;
        this.DW = i2;
        this.v5 = z;
    }

    public boolean j6(awc awc) {
        int i;
        int i2 = 0;
        int tp = awc.tp();
        int j6 = awc.j6(this.DW);
        String we = awc.we();
        if (!awc.gn()) {
            if (anl.j6.DW(j6)) {
                j6(we);
                this.VH.addFirst(we);
            }
            for (i = 0; i < tp; i++) {
                int j62 = awc.j6(i);
                if (i != this.DW && j62 != 0 && anl.j6.DW(j62)) {
                    this.VH.clear();
                    break;
                }
            }
        }
        if (j6 == 0) {
            return true;
        }
        i = awc.j6(this.j6);
        awd DW = DW(awc);
        if (i == 0) {
            if (!this.v5 || !DW.j3()) {
                return true;
            }
            boolean z;
            this.Zo.add(DW.J8());
            i = 0;
            while (i < tp) {
                if (i != this.j6 && i != this.DW && awc.j6(i) != 0) {
                    break;
                }
                i++;
            }
            if (i != tp) {
                z = true;
            }
            return z;
        } else if (awc.Ws()) {
            return true;
        } else {
            while (i2 < tp) {
                if (!(i2 == this.j6 || i2 == this.DW)) {
                    if (awc.j6(i2) != i) {
                        return true;
                    }
                    if (!awc.j6(i2, this.j6)) {
                        return true;
                    }
                }
                i2++;
            }
            return DW.j6(((aku) awc.j6(this.j6, aku.class)).tp(), true);
        }
    }

    private void j6(String str) {
        String str2 = null;
        while (!this.VH.isEmpty() && !str.startsWith(new StringBuilder(String.valueOf((String) this.VH.getFirst())).append("/").toString())) {
            str2 = (String) this.VH.removeFirst();
        }
        if (str2 != null) {
            while (!this.gn.isEmpty() && ((String) this.gn.getLast()).startsWith(str2)) {
                this.gn.removeLast();
            }
            this.gn.addLast(str2);
        }
    }

    private awd DW(awc awc) {
        return (awd) awc.j6(this.DW, awd.class);
    }

    public boolean j6() {
        return true;
    }

    public awl DW() {
        return this;
    }

    public String toString() {
        return "INDEX_DIFF_FILTER";
    }

    public Set<String> FH() {
        return this.Zo;
    }
}
