import java.util.Arrays;

public final class ya implements Comparable<ya> {
    private final byte DW;
    private final int FH;
    private final int[] Hw;
    private final yi j6;
    private final yj[] v5;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ya) obj);
    }

    public ya(yi yiVar, byte b, int i, int[] iArr, yj[] yjVarArr) {
        this.j6 = yiVar;
        this.DW = b;
        this.FH = i;
        this.Hw = iArr;
        this.v5 = yjVarArr;
    }

    public byte j6() {
        return this.DW;
    }

    public int DW() {
        return this.FH;
    }

    public int[] FH() {
        return this.Hw;
    }

    public yj[] Hw() {
        return this.v5;
    }

    public void j6(yt$a yt_a) {
        yt_a.FH(this.DW);
        yt_a.Zo(this.FH);
        yt_a.Zo(this.Hw.length);
        for (int i = 0; i < this.Hw.length; i++) {
            yt_a.Zo(this.Hw[i]);
            this.v5[i].j6(yt_a);
        }
    }

    public int j6(ya yaVar) {
        if (this.FH != yaVar.FH) {
            return ads.j6(this.FH, yaVar.FH);
        }
        int min = Math.min(this.Hw.length, yaVar.Hw.length);
        for (int i = 0; i < min; i++) {
            if (this.Hw[i] != yaVar.Hw[i]) {
                return ads.j6(this.Hw[i], yaVar.Hw[i]);
            }
            int j6 = this.v5[i].j6(yaVar.v5[i]);
            if (j6 != 0) {
                return j6;
            }
        }
        return this.Hw.length - yaVar.Hw.length;
    }

    public String toString() {
        if (this.j6 == null) {
            return this.DW + " " + this.FH;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.DW);
        stringBuilder.append(" ");
        stringBuilder.append((String) this.j6.FH().get(this.FH));
        stringBuilder.append("[");
        for (int i = 0; i < this.Hw.length; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) this.j6.DW().get(this.Hw[i]));
            stringBuilder.append("=");
            stringBuilder.append(this.v5[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return ((((((Arrays.hashCode(this.Hw) + 31) * 31) + this.FH) * 31) + Arrays.hashCode(this.v5)) * 31) + this.DW;
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
        ya yaVar = (ya) obj;
        if (!Arrays.equals(this.Hw, yaVar.Hw)) {
            return false;
        }
        if (this.FH != yaVar.FH) {
            return false;
        }
        if (!Arrays.equals(this.v5, yaVar.v5)) {
            return false;
        }
        if (this.DW != yaVar.DW) {
            return false;
        }
        return true;
    }
}
