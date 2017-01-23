import java.util.ArrayList;

public class acn {
    private final ArrayList<adh> j6;

    public acn(int i) {
        this.j6 = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.j6.add(acf.DW(i));
        }
    }

    public void j6(int i, int i2) {
        j6(Math.max(i, i2) + 1);
        ((adh) this.j6.get(i)).j6(i2);
        ((adh) this.j6.get(i2)).j6(i);
    }

    public void j6(int i, adh adh) {
        if (i < this.j6.size()) {
            adh.j6((adh) this.j6.get(i));
        }
    }

    private void j6(int i) {
        this.j6.ensureCapacity(i);
        for (int size = this.j6.size(); size < i; size++) {
            this.j6.add(acf.DW(i));
        }
    }
}
