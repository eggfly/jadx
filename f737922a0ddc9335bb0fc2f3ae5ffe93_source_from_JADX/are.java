import java.io.File;

public class are {
    public static final are DW;
    public static final are j6;
    private final long FH;
    private volatile long Hw;
    private boolean v5;

    static {
        j6 = new are(-1, -1);
        DW = new are$1(0, 0);
    }

    public static are j6(File file) {
        return new are(System.currentTimeMillis(), file.lastModified());
    }

    private are(long j, long j2) {
        this.Hw = j;
        this.FH = j2;
        this.v5 = j6(j);
    }

    public long j6() {
        return this.FH;
    }

    public boolean DW(File file) {
        return DW(file.lastModified());
    }

    public void j6(are are) {
        long j = are.Hw;
        if (j6(j)) {
            this.v5 = true;
        }
        this.Hw = j;
    }

    public boolean DW(are are) {
        return this.FH == are.FH;
    }

    public boolean equals(Object obj) {
        if (obj instanceof are) {
            return DW((are) obj);
        }
        return false;
    }

    public int hashCode() {
        return (int) this.FH;
    }

    private boolean j6(long j) {
        return j - this.FH > 2500;
    }

    private boolean DW(long j) {
        if (this.FH != j) {
            return true;
        }
        if (this.v5) {
            return false;
        }
        if (j6(this.Hw)) {
            return false;
        }
        this.Hw = System.currentTimeMillis();
        if (j6(this.Hw)) {
            return false;
        }
        return true;
    }
}
