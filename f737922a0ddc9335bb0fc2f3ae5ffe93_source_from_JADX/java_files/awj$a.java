import java.util.Arrays;
import java.util.Comparator;

class awj$a extends awl {
    private static final Comparator<awi> j6;
    private final awi[] DW;

    static {
        j6 = new awj$a$1();
    }

    private awj$a(awi[] awiArr) {
        this.DW = awiArr;
        Arrays.sort(this.DW, j6);
    }

    public boolean j6(awc awc) {
        int length = this.DW.length;
        int i = 0;
        do {
            byte[] bArr = this.DW[i].DW;
            int j6 = awc.j6(bArr, bArr.length);
            if (j6 == 0) {
                return true;
            }
            i++;
        } while (i < length);
        if (j6 <= 0) {
            return false;
        }
        throw alv.j6;
    }

    public boolean j6() {
        for (awi j6 : this.DW) {
            if (j6.j6()) {
                return true;
            }
        }
        return false;
    }

    public awl DW() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FAST(");
        for (int i = 0; i < this.DW.length; i++) {
            if (i > 0) {
                stringBuilder.append(" OR ");
            }
            stringBuilder.append(this.DW[i].toString());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
