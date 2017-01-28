import java.util.Comparator;

class asy$2 implements Comparator<asv> {
    final /* synthetic */ asy j6;

    asy$2(asy asy) {
        this.j6 = asy;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((asv) obj, (asv) obj2);
    }

    public int j6(asv asv, asv asv2) {
        int i;
        int i2 = 0;
        int i3 = asv.Mr() ? 1 : 0;
        if (asv2.Mr()) {
            i = 1;
        } else {
            i = 0;
        }
        i3 -= i;
        if (i3 != 0) {
            return i3;
        }
        i3 = asv.J8() - asv2.J8();
        if (i3 != 0) {
            return i3;
        }
        i3 = (asv.rN() >>> 1) - (asv2.rN() >>> 1);
        if (i3 != 0) {
            return i3;
        }
        i3 = (asv.rN() & 1) - (asv2.rN() & 1);
        if (i3 != 0) {
            return i3;
        }
        if (asv.U2()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (!asv2.U2()) {
            i2 = 1;
        }
        i3 -= i2;
        return i3 == 0 ? asv2.lg() - asv.lg() : i3;
    }
}
