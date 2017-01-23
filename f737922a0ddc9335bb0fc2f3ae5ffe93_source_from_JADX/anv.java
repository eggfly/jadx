import java.util.Iterator;

public class anv<V extends ans> implements Iterable<V> {
    private int DW;
    private int FH;
    private V[] Hw;
    private int j6;

    public anv() {
        j6(2048);
    }

    public V j6(anb anb) {
        int i = this.FH;
        int i2 = anb.j6 & i;
        ans[] ansArr = this.Hw;
        while (true) {
            V v = ansArr[i2];
            if (v == null) {
                return null;
            }
            if (anb.j6((anb) v, anb)) {
                return v;
            }
            i2 = (i2 + 1) & i;
        }
    }

    public boolean DW(anb anb) {
        return j6(anb) != null;
    }

    public <Q extends V> void j6(Q q) {
        int i = this.j6 + 1;
        this.j6 = i;
        if (i == this.DW) {
            DW();
        }
        DW((ans) q);
    }

    public boolean j6() {
        return this.j6 == 0;
    }

    public Iterator<V> iterator() {
        return new anv$1(this);
    }

    private void DW(V v) {
        int i = this.FH;
        int i2 = v.j6 & i;
        ans[] ansArr = this.Hw;
        while (ansArr[i2] != null) {
            i2 = (i2 + 1) & i;
        }
        ansArr[i2] = v;
    }

    private void DW() {
        ans[] ansArr = this.Hw;
        int length = this.Hw.length;
        j6(length << 1);
        for (int i = 0; i < length; i++) {
            ans ans = ansArr[i];
            if (ans != null) {
                DW(ans);
            }
        }
    }

    private void j6(int i) {
        this.DW = i >> 1;
        this.FH = i - 1;
        this.Hw = DW(i);
    }

    private final V[] DW(int i) {
        return new ans[i];
    }
}
