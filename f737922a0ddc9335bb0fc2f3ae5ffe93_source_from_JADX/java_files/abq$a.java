import java.util.BitSet;

class abq$a implements aci$a {
    BitSet j6;

    public abq$a(BitSet bitSet) {
        this.j6 = bitSet;
    }

    public void j6(abz abz) {
        if (!abq.DW(abz)) {
            this.j6.set(abz.Ws().VH());
        }
    }

    public void j6(acb acb) {
        if (!abq.DW(acb)) {
            this.j6.set(acb.Ws().VH());
        }
    }

    public void DW(abz abz) {
        zw Ws = abz.Ws();
        if (!abq.DW(abz) && Ws != null) {
            this.j6.set(Ws.VH());
        }
    }
}
