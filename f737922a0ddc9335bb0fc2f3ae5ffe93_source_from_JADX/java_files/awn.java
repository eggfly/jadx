import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;

public class awn<T> extends AbstractList<T> {
    private int DW;
    private int FH;
    private int Hw;
    private T[][] j6;
    private T[] v5;

    public awn() {
        this.j6 = v5(256);
        this.j6[0] = DW();
        this.v5 = this.j6[0];
    }

    public awn(int i) {
        int FH = FH(i);
        if ((i & 1023) != 0 || FH == 0) {
            FH++;
        }
        this.j6 = v5(FH);
        this.j6[0] = DW();
        this.v5 = this.j6[0];
    }

    public int size() {
        return this.DW;
    }

    public void clear() {
        for (Object[] objArr : this.j6) {
            if (objArr != null) {
                Arrays.fill(objArr, null);
            }
        }
        this.DW = 0;
        this.FH = 0;
        this.Hw = 0;
        this.v5 = this.j6[0];
    }

    public T get(int i) {
        if (i >= 0 && this.DW > i) {
            return this.j6[FH(i)][Hw(i)];
        }
        throw new IndexOutOfBoundsException(String.valueOf(i));
    }

    public T set(int i, T t) {
        if (i < 0 || this.DW <= i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        Object[] objArr = this.j6[FH(i)];
        int Hw = Hw(i);
        T t2 = objArr[Hw];
        objArr[Hw] = t;
        return t2;
    }

    public void j6(awn<T> awn_T) {
        if (awn_T.DW != 0) {
            for (int i = 0; i < awn_T.FH; i++) {
                j6(awn_T.j6[i], 0, 1024);
            }
            if (awn_T.Hw != 0) {
                j6(awn_T.v5, 0, awn_T.Hw);
            }
        }
    }

    public void j6(T[] tArr, int i, int i2) {
        while (i2 > 0) {
            int i3 = this.Hw;
            int min = Math.min(i2, 1024 - i3);
            if (min == 0) {
                i3 = i + 1;
                add(tArr[i]);
                i2--;
                i = i3;
            } else {
                System.arraycopy(tArr, i, this.v5, i3, min);
                this.Hw += min;
                this.DW += min;
                i += min;
                i2 -= min;
            }
        }
    }

    public boolean add(T t) {
        int i = this.Hw;
        if (i < 1024) {
            this.v5[i] = t;
            this.Hw = i + 1;
            this.DW++;
        } else {
            i = this.FH + 1;
            this.FH = i;
            if (i == this.j6.length) {
                Object v5 = v5(this.j6.length << 1);
                System.arraycopy(this.j6, 0, v5, 0, this.j6.length);
                this.j6 = v5;
            }
            Object[] objArr = this.j6[this.FH];
            if (objArr == null) {
                objArr = DW();
                this.j6[this.FH] = objArr;
            }
            objArr[0] = t;
            this.v5 = objArr;
            this.Hw = 1;
            this.DW++;
        }
        return true;
    }

    public void add(int i, T t) {
        if (i == this.DW) {
            add(t);
        } else if (i < 0 || this.DW < i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        } else {
            add(null);
            for (int i2 = this.DW - 2; i <= i2; i2--) {
                set(i2 + 1, get(i2));
            }
            set(i, t);
        }
    }

    public T remove(int i) {
        T t;
        if (i == this.DW - 1) {
            Object[] objArr = this.j6[FH(i)];
            int Hw = Hw(i);
            t = objArr[Hw];
            objArr[Hw] = null;
            this.DW--;
            if (this.Hw > 0) {
                this.Hw--;
            } else {
                j6();
            }
        } else if (i < 0 || this.DW <= i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        } else {
            t = get(i);
            while (i < this.DW - 1) {
                set(i, get(i + 1));
                i++;
            }
            set(this.DW - 1, null);
            this.DW--;
            j6();
        }
        return t;
    }

    private void j6() {
        this.FH = FH(this.DW);
        this.Hw = Hw(this.DW);
        this.v5 = this.j6[this.FH];
    }

    public Iterator<T> iterator() {
        return new awn$a();
    }

    private static final int FH(int i) {
        return i >>> 10;
    }

    private static final int Hw(int i) {
        return i & 1023;
    }

    private static <T> T[][] v5(int i) {
        return new Object[i][];
    }

    private static <T> T[] DW() {
        return new Object[1024];
    }
}
