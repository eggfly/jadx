public class zq implements Comparable<zq> {
    private final abe DW;
    private final abe j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((zq) obj);
    }

    public static zq j6(abe abe, abe abe2) {
        if (abe == null && abe2 == null) {
            return null;
        }
        return new zq(abe, abe2);
    }

    private zq(abe abe, abe abe2) {
        this.j6 = abe;
        this.DW = abe2;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof zq) && j6((zq) obj) == 0) {
            return true;
        }
        return false;
    }

    private static int DW(abe abe, abe abe2) {
        if (abe == abe2) {
            return 0;
        }
        if (abe == null) {
            return -1;
        }
        if (abe2 == null) {
            return 1;
        }
        return abe.j6(abe2);
    }

    public int j6(zq zqVar) {
        int DW = DW(this.j6, zqVar.j6);
        if (DW != 0) {
            return DW;
        }
        return DW(this.DW, zqVar.DW);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.j6 == null ? 0 : this.j6.hashCode()) * 31;
        if (this.DW != null) {
            i = this.DW.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        if (this.j6 != null && this.DW == null) {
            return this.j6.u7();
        }
        if (this.j6 == null && this.DW == null) {
            return "";
        }
        return "[" + (this.j6 == null ? "" : this.j6.u7()) + "|" + (this.DW == null ? "" : this.DW.u7());
    }

    public abe j6() {
        return this.j6;
    }

    public abe DW() {
        return this.DW;
    }
}
