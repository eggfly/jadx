import com.google.android.gms.ads.d;

@Deprecated
public final class aep {
    public static final aep DW;
    public static final aep FH;
    public static final aep Hw;
    public static final aep Zo;
    public static final aep j6;
    public static final aep v5;
    private final d VH;

    static {
        j6 = new aep(-1, -2, "mb");
        DW = new aep(320, 50, "mb");
        FH = new aep(300, 250, "as");
        Hw = new aep(468, 60, "as");
        v5 = new aep(728, 90, "as");
        Zo = new aep(160, 600, "as");
    }

    private aep(int i, int i2, String str) {
        this(new d(i, i2));
    }

    public aep(d dVar) {
        this.VH = dVar;
    }

    public int DW() {
        return this.VH.j6();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aep)) {
            return false;
        }
        return this.VH.equals(((aep) obj).VH);
    }

    public int hashCode() {
        return this.VH.hashCode();
    }

    public int j6() {
        return this.VH.DW();
    }

    public String toString() {
        return this.VH.toString();
    }
}
