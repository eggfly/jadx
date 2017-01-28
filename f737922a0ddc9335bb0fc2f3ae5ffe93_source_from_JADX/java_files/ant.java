import java.util.Arrays;
import java.util.Iterator;

public class ant<V extends ant$a> implements Iterable<V> {
    private int DW;
    private int FH;
    private int Hw;
    private V[][] j6;
    private int v5;

    public ant() {
        this.Hw = 0;
        this.v5 = 0;
        this.FH = j6(this.Hw);
        this.j6 = new ant$a[1024][];
        this.j6[0] = Hw();
    }

    public void j6() {
        int i = 0;
        this.DW = 0;
        ant$a[][] ant_aArr = this.j6;
        int length = ant_aArr.length;
        while (i < length) {
            Object[] objArr = ant_aArr[i];
            if (objArr != null) {
                Arrays.fill(objArr, null);
                i++;
            } else {
                return;
            }
        }
    }

    public V j6(anb anb) {
        int i = anb.j6;
        for (V v = this.j6[this.v5 & i][i >>> 21]; v != null; v = v.Zo) {
            if (j6(v, anb)) {
                return v;
            }
        }
        return null;
    }

    public boolean DW(anb anb) {
        return j6(anb) != null;
    }

    public <Q extends V> void j6(Q q) {
        int i = this.DW + 1;
        this.DW = i;
        if (i == this.FH) {
            FH();
        }
        i = q.j6;
        ant$a[] ant_aArr = this.j6[this.v5 & i];
        i >>>= 21;
        q.Zo = ant_aArr[i];
        ant_aArr[i] = q;
    }

    public <Q extends V> V DW(Q q) {
        int i = q.j6;
        ant$a[] ant_aArr = this.j6[this.v5 & i];
        int i2 = i >>> 21;
        for (Q q2 = ant_aArr[i2]; q2 != null; q2 = q2.Zo) {
            if (j6(q2, q)) {
                return q2;
            }
        }
        q.Zo = ant_aArr[i2];
        ant_aArr[i2] = q;
        i = this.DW + 1;
        this.DW = i;
        if (i != this.FH) {
            return q;
        }
        FH();
        return q;
    }

    public int DW() {
        return this.DW;
    }

    public Iterator<V> iterator() {
        return new ant$1(this);
    }

    private void FH() {
        int i = 1 << this.Hw;
        int i2 = 1 << this.Hw;
        this.Hw++;
        this.v5 = (1 << this.Hw) - 1;
        this.FH = j6(this.Hw);
        int i3 = 1 << this.Hw;
        if (this.j6.length < i3) {
            Object obj = new ant$a[(i3 << 1)][];
            System.arraycopy(this.j6, 0, obj, 0, i);
            this.j6 = obj;
        }
        for (int i4 = 0; i4 < i; i4++) {
            ant$a[] ant_aArr = this.j6[i4];
            ant$a[] Hw = Hw();
            for (i3 = 0; i3 < ant_aArr.length; i3++) {
                ant$a ant_a = ant_aArr[i3];
                ant$a ant_a2 = null;
                ant$a ant_a3 = null;
                while (ant_a != null) {
                    ant$a ant_a4 = ant_a.Zo;
                    if ((ant_a.j6 & i2) == 0) {
                        ant_a.Zo = ant_a3;
                    } else {
                        ant_a.Zo = ant_a2;
                        ant_a2 = ant_a;
                        ant_a = ant_a3;
                    }
                    ant_a3 = ant_a;
                    ant_a = ant_a4;
                }
                ant_aArr[i3] = ant_a3;
                Hw[i3] = ant_a2;
            }
            this.j6[i + i4] = Hw;
        }
    }

    private final V[] Hw() {
        return new ant$a[2048];
    }

    private static final int j6(int i) {
        return 1 << (i + 11);
    }

    private static final boolean j6(anb anb, anb anb2) {
        return anb.DW == anb2.DW && anb.FH == anb2.FH && anb.Hw == anb2.Hw && anb.v5 == anb2.v5 && anb.j6 == anb2.j6;
    }
}
