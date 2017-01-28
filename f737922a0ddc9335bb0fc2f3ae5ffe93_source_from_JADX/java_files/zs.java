import java.util.HashMap;

public final class zs extends adm {
    private final zy DW;
    private final zy[] FH;
    private final HashMap<zo, zw> Hw;
    private final int j6;

    public zs(aaa aaa) {
        if (aaa == null) {
            throw new NullPointerException("method == null");
        }
        zj j6 = aaa.j6();
        int tp = j6.tp();
        this.j6 = j6.v5();
        this.DW = new zy(this.j6);
        this.FH = new zy[tp];
        this.Hw = new HashMap(j6.Zo());
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
            throw new IllegalArgumentException("bogus label");
        }
    }

    public boolean DW(int i, zy zyVar) {
        zy FH = FH(i);
        if (FH == null) {
            j6(i, zyVar);
            return true;
        }
        zy v5 = FH.v5();
        if (FH.Hw() != 0) {
            v5.j6(zyVar, true);
        } else {
            v5 = zyVar.v5();
        }
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

    public zy j6(zi ziVar) {
        return j6(ziVar.j6());
    }

    public zy DW(int i) {
        zy FH = FH(i);
        return FH != null ? FH.v5() : new zy(this.j6);
    }

    public void j6(zo zoVar, zw zwVar) {
        we();
        if (zoVar == null) {
            throw new NullPointerException("insn == null");
        } else if (zwVar == null) {
            throw new NullPointerException("spec == null");
        } else {
            this.Hw.put(zoVar, zwVar);
        }
    }

    public zw j6(zo zoVar) {
        return (zw) this.Hw.get(zoVar);
    }

    public int DW() {
        return this.Hw.size();
    }

    private zy FH(int i) {
        try {
            return this.FH[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus label");
        }
    }
}
