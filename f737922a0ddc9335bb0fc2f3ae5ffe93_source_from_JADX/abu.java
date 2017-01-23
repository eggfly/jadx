import java.util.ArrayList;

public class abu extends abo {
    private final acn DW;
    private final ArrayList<acs> j6;

    public abu(acn acn, int i) {
        super(i);
        this.j6 = new ArrayList();
        this.DW = acn;
    }

    public void j6(int i, int i2, int i3) {
        super.j6(i, i2, i3);
        j6(i2, i);
        if (i3 == 2) {
            j6(i2 + 1, i);
        }
    }

    public boolean DW(int i, int i2, int i3) {
        if (i2 >= this.j6.size()) {
            return false;
        }
        adh adh = (adh) this.j6.get(i2);
        if (adh == null) {
            return false;
        }
        if (i3 == 1) {
            return adh.DW(i);
        }
        boolean z = adh.DW(i) || DW(i, i2 + 1, i3 - 1);
        return z;
    }

    public boolean j6(zw zwVar, int i) {
        return DW(zwVar.VH(), i, zwVar.EQ());
    }

    private void j6(int i, int i2) {
        this.j6.ensureCapacity(i + 1);
        while (i >= this.j6.size()) {
            this.j6.add(new acs(i + 1));
        }
        this.DW.j6(i2, (adh) this.j6.get(i));
    }

    public boolean j6(zx zxVar, int i, int i2) {
        int m_ = zxVar.m_();
        for (int i3 = 0; i3 < m_; i3++) {
            zw DW = zxVar.DW(i3);
            int j6 = j6(DW.VH());
            if (j6 == i || ((DW.EQ() == 2 && j6 + 1 == i) || (i2 == 2 && j6 == i + 1))) {
                return true;
            }
        }
        return false;
    }
}
