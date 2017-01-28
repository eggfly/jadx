import java.util.HashMap;
import java.util.List;

public class abx extends adm {
    private final zy DW;
    private final zy[] FH;
    private final HashMap<aci, zw> Hw;
    private final int j6;

    public abx(acj acj) {
        if (acj == null) {
            throw new NullPointerException("method == null");
        }
        List tp = acj.tp();
        this.j6 = acj.VH();
        this.DW = new zy(this.j6);
        this.FH = new zy[tp.size()];
        this.Hw = new HashMap();
        this.DW.l_();
    }

    public void j6(int i, zy zyVar) {
        we();
        if (zyVar == null) {
            throw new NullPointerException("specs == null");
        }
        try {
            this.FH[i] = zyVar;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus index");
        }
    }

    public boolean DW(int i, zy zyVar) {
        zy FH = FH(i);
        if (FH == null) {
            j6(i, zyVar);
            return true;
        }
        zy v5 = FH.v5();
        v5.j6(zyVar, true);
        if (FH.equals(v5)) {
            return false;
        }
        v5.l_();
        j6(i, v5);
        return true;
    }

    public zy j6(int i) {
        zy FH = FH(i);
        return FH != null ? FH : this.DW;
    }

    public zy DW(int i) {
        zy FH = FH(i);
        return FH != null ? FH.v5() : new zy(this.j6);
    }

    public void j6(aci aci, zw zwVar) {
        we();
        if (aci == null) {
            throw new NullPointerException("insn == null");
        } else if (zwVar == null) {
            throw new NullPointerException("spec == null");
        } else {
            this.Hw.put(aci, zwVar);
        }
    }

    private zy FH(int i) {
        try {
            return this.FH[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus index");
        }
    }
}
