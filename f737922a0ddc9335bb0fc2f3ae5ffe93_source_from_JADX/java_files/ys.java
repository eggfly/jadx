import java.util.Arrays;

public final class ys implements Comparable<ys> {
    public static final ys j6;
    private final yi DW;
    private final short[] FH;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ys) obj);
    }

    static {
        j6 = new ys(null, new short[0]);
    }

    public ys(yi yiVar, short[] sArr) {
        this.DW = yiVar;
        this.FH = sArr;
    }

    public short[] j6() {
        return this.FH;
    }

    public int j6(ys ysVar) {
        int i = 0;
        while (i < this.FH.length && i < ysVar.FH.length) {
            if (this.FH[i] != ysVar.FH[i]) {
                return ads.j6(this.FH[i], ysVar.FH[i]);
            }
            i++;
        }
        return ads.j6(this.FH.length, ysVar.FH.length);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        int length = this.FH.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(this.DW != null ? this.DW.FH().get(this.FH[i]) : Short.valueOf(this.FH[i]));
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(this.FH) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (Arrays.equals(this.FH, ((ys) obj).FH)) {
            return true;
        }
        return false;
    }
}
