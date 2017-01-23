import java.util.BitSet;

public abstract class uf {
    private final uh DW;
    private final aac FH;
    private final zx Hw;
    private int j6;

    protected abstract String DW();

    public abstract uf Hw(int i);

    public abstract int j6();

    protected abstract String j6(boolean z);

    public abstract uf j6(uh uhVar);

    public abstract uf j6(zx zxVar);

    public abstract void j6(acr acr);

    public static uw j6(aac aac, zw zwVar, zw zwVar2) {
        Object obj = 1;
        if (zwVar.EQ() != 1) {
            obj = null;
        }
        boolean Ws = zwVar.j6().Ws();
        int VH = zwVar.VH();
        uh uhVar = (zwVar2.VH() | VH) < 16 ? Ws ? ui.u7 : obj != null ? ui.FH : ui.Zo : VH < 256 ? Ws ? ui.tp : obj != null ? ui.Hw : ui.VH : Ws ? ui.EQ : obj != null ? ui.v5 : ui.gn;
        return new uw(uhVar, aac, zx.j6(zwVar, zwVar2));
    }

    public uf(uh uhVar, aac aac, zx zxVar) {
        if (uhVar == null) {
            throw new NullPointerException("opcode == null");
        } else if (aac == null) {
            throw new NullPointerException("position == null");
        } else if (zxVar == null) {
            throw new NullPointerException("registers == null");
        } else {
            this.j6 = -1;
            this.DW = uhVar;
            this.FH = aac;
            this.Hw = zxVar;
        }
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(J0());
        stringBuffer.append(' ');
        stringBuffer.append(this.FH);
        stringBuffer.append(": ");
        stringBuffer.append(this.DW.v5());
        Object obj = null;
        if (this.Hw.m_() != 0) {
            stringBuffer.append(this.Hw.DW(" ", ", ", null));
            obj = 1;
        }
        String DW = DW();
        if (DW != null) {
            if (obj != null) {
                stringBuffer.append(',');
            }
            stringBuffer.append(' ');
            stringBuffer.append(DW);
        }
        return stringBuffer.toString();
    }

    public final boolean Zo() {
        return this.j6 >= 0;
    }

    public final int VH() {
        if (this.j6 >= 0) {
            return this.j6;
        }
        throw new RuntimeException("address not yet known");
    }

    public final uh gn() {
        return this.DW;
    }

    public final aac u7() {
        return this.FH;
    }

    public final zx tp() {
        return this.Hw;
    }

    public final boolean EQ() {
        return this.DW.Hw();
    }

    public final int j6(BitSet bitSet) {
        int i;
        boolean EQ = EQ();
        int m_ = this.Hw.m_();
        if (!EQ || bitSet.get(0)) {
            i = 0;
        } else {
            i = this.Hw.DW(0).EQ();
        }
        int i2 = 0;
        for (int i3 = EQ ? 1 : 0; i3 < m_; i3++) {
            if (!bitSet.get(i3)) {
                i2 += this.Hw.DW(i3).EQ();
            }
        }
        return Math.max(i2, i);
    }

    public uf we() {
        return j6(this.Hw.j6(0, EQ(), null));
    }

    public uf DW(BitSet bitSet) {
        zx zxVar = this.Hw;
        boolean z = bitSet.get(0);
        if (EQ()) {
            bitSet.set(0);
        }
        zx j6 = zxVar.j6(bitSet);
        if (EQ()) {
            bitSet.set(0, z);
        }
        if (j6.m_() == 0) {
            return null;
        }
        return new uk(this.FH, j6);
    }

    public uf FH(BitSet bitSet) {
        if (!EQ() || bitSet.get(0)) {
            return null;
        }
        zw DW = this.Hw.DW(0);
        return j6(this.FH, DW, DW.DW(0));
    }

    public uf Hw(BitSet bitSet) {
        return j6(this.Hw.j6(0, EQ(), bitSet));
    }

    public final String J0() {
        if (this.j6 == -1) {
            return add.j6(System.identityHashCode(this));
        }
        return String.format("%04x", new Object[]{Integer.valueOf(this.j6)});
    }

    public final String j6(String str, int i, boolean z) {
        String j6 = j6(z);
        if (j6 == null) {
            return null;
        }
        String str2 = str + J0() + ": ";
        int length = str2.length();
        return adr.j6(str2, length, "", j6, i == 0 ? j6.length() : i - length);
    }

    public final void FH(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        }
        this.j6 = i;
    }

    public final int J8() {
        return VH() + j6();
    }
}
