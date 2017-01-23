import java.util.ArrayList;
import java.util.List;

public class qf<T> {
    private int DW;
    private int FH;
    private List<T> j6;

    public qf(int i) {
        this.j6 = new ArrayList();
        this.FH = i;
    }

    public T j6(T t) {
        if (this.j6.size() < this.FH) {
            this.j6.add(t);
            return null;
        }
        T t2 = this.j6.get(this.DW);
        this.j6.set(this.DW, t);
        this.DW++;
        if (this.DW < this.j6.size()) {
            return t2;
        }
        this.DW = 0;
        return t2;
    }

    public int j6() {
        return this.j6.size();
    }

    public T j6(int i) {
        int i2 = this.DW + i;
        if (i2 >= this.j6.size()) {
            i2 -= this.j6.size();
        }
        return this.j6.get(i2);
    }

    public void DW() {
        this.j6.clear();
        this.DW = 0;
    }

    public int FH() {
        return this.FH;
    }

    public T Hw() {
        return j6(j6() - 1);
    }
}
