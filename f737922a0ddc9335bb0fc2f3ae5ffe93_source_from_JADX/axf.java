import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class axf<T extends aoc> implements Iterable<aoc> {
    private static final axf<aoc> j6;
    private final aoc[] DW;
    private final int FH;

    static {
        j6 = new axf(new aoc[0], 0);
    }

    public static <T extends aoc> axf<T> j6() {
        return j6;
    }

    axf(aoc[] aocArr, int i) {
        this.DW = aocArr;
        this.FH = i;
    }

    protected axf(axf<T> axf_T) {
        this.DW = axf_T.DW;
        this.FH = axf_T.FH;
    }

    public Iterator<aoc> iterator() {
        return new axf$1(this);
    }

    public final List<aoc> DW() {
        return Collections.unmodifiableList(Arrays.asList(this.DW).subList(0, this.FH));
    }

    public final int FH() {
        return this.FH;
    }

    public final boolean Hw() {
        return this.FH == 0;
    }

    public final int j6(String str) {
        int i = this.FH;
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        do {
            int i3 = (i2 + i) >>> 1;
            int j6 = aod.j6(this.DW[i3], str);
            if (j6 < 0) {
                i2 = i3 + 1;
                continue;
            } else if (j6 == 0) {
                return i3;
            } else {
                i = i3;
                continue;
            }
        } while (i2 < i);
        return -(i2 + 1);
    }

    public final boolean DW(String str) {
        return j6(str) >= 0;
    }

    public final T FH(String str) {
        int j6 = j6(str);
        return j6 >= 0 ? j6(j6) : null;
    }

    public final T j6(int i) {
        return this.DW[i];
    }

    public final axf$a<T> DW(int i) {
        axf$a<T> axf_a = new axf$a(Math.max(16, i));
        axf_a.j6(this.DW, 0, i);
        return axf_a;
    }

    public final axf<T> j6(int i, T t) {
        Object obj = new aoc[this.FH];
        System.arraycopy(this.DW, 0, obj, 0, this.FH);
        obj[i] = t;
        return new axf(obj, this.FH);
    }

    public final axf<T> DW(int i, T t) {
        if (i < 0) {
            i = -(i + 1);
        }
        Object obj = new aoc[(this.FH + 1)];
        if (i > 0) {
            System.arraycopy(this.DW, 0, obj, 0, i);
        }
        obj[i] = t;
        if (i < this.FH) {
            System.arraycopy(this.DW, i, obj, i + 1, this.FH - i);
        }
        return new axf(obj, this.FH + 1);
    }

    public final axf<T> FH(int i) {
        if (this.FH == 1) {
            return j6();
        }
        Object obj = new aoc[(this.FH - 1)];
        if (i > 0) {
            System.arraycopy(this.DW, 0, obj, 0, i);
        }
        if (i + 1 < this.FH) {
            System.arraycopy(this.DW, i + 1, obj, i, this.FH - (i + 1));
        }
        return new axf(obj, this.FH - 1);
    }

    public final axf<T> j6(T t) {
        int j6 = j6(t.j6());
        if (j6 >= 0) {
            return j6(j6, t);
        }
        return DW(j6, t);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        if (this.FH > 0) {
            stringBuilder.append(this.DW[0]);
            for (int i = 1; i < this.FH; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(this.DW[i]);
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
