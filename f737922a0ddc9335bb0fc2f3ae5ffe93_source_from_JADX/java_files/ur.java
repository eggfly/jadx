import java.util.ArrayList;

public final class ur {
    private ArrayList<uf> DW;
    private final us j6;

    public ur(tq tqVar, int i, int i2, int i3) {
        this.j6 = new us(tqVar, i, i3);
        this.DW = new ArrayList(i2);
    }

    public void j6(uf ufVar) {
        this.j6.j6(ufVar);
    }

    public void j6(int i, uc ucVar) {
        this.j6.j6(i, ucVar);
    }

    public void DW(uf ufVar) {
        this.DW.add(ufVar);
    }

    public us j6() {
        if (this.DW == null) {
            throw new UnsupportedOperationException("already processed");
        }
        DW();
        return this.j6;
    }

    private void DW() {
        int size = this.DW.size();
        for (int i = 0; i < size; i++) {
            this.j6.j6((uf) this.DW.get(i));
        }
        this.DW = null;
    }
}
