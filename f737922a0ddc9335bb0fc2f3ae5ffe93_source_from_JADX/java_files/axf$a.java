import java.util.Arrays;

public class axf$a<T extends aoc> {
    private int DW;
    private aoc[] j6;

    public axf$a() {
        this(16);
    }

    public axf$a(int i) {
        this.j6 = new aoc[i];
    }

    public int j6() {
        return this.DW;
    }

    public T j6(int i) {
        return this.j6[i];
    }

    public void DW(int i) {
        System.arraycopy(this.j6, i + 1, this.j6, i, this.DW - (i + 1));
        this.DW--;
    }

    public void j6(T t) {
        if (this.j6.length == this.DW) {
            Object obj = new aoc[(this.DW * 2)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        aoc[] aocArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        aocArr[i] = t;
    }

    public void j6(aoc[] aocArr, int i, int i2) {
        if (this.j6.length < this.DW + i2) {
            Object obj = new aoc[Math.max(this.DW * 2, this.DW + i2)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        System.arraycopy(aocArr, i, this.j6, this.DW, i2);
        this.DW += i2;
    }

    public void j6(int i, T t) {
        this.j6[i] = t;
    }

    public void DW() {
        Arrays.sort(this.j6, 0, this.DW, aod.j6);
    }

    public axf<T> FH() {
        return new axf(this.j6, this.DW);
    }

    public String toString() {
        return FH().toString();
    }
}
