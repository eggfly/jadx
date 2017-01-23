final class aty<V> {
    private int DW;
    private int FH;
    private aty$a<V>[] j6;

    aty() {
        this.j6 = j6(64);
        this.FH = (int) (((float) this.j6.length) * 0.75f);
    }

    V j6(long j) {
        aty$a aty_a = this.j6[DW(j)];
        aty$a aty_a2 = null;
        while (aty_a != null) {
            if (aty_a.j6 == j) {
                if (aty_a2 == null) {
                    this.j6[DW(j)] = aty_a.FH;
                } else {
                    aty_a2.FH = aty_a.FH;
                }
                this.DW--;
                return aty_a.DW;
            }
            aty$a aty_a3 = aty_a;
            aty_a = aty_a.FH;
            aty_a2 = aty_a3;
        }
        return null;
    }

    V j6(long j, V v) {
        for (aty$a aty_a = this.j6[DW(j)]; aty_a != null; aty_a = aty_a.FH) {
            if (aty_a.j6 == j) {
                V v2 = aty_a.DW;
                aty_a.DW = v;
                return v2;
            }
        }
        int i = this.DW + 1;
        this.DW = i;
        if (i == this.FH) {
            j6();
        }
        j6(new aty$a(j, v));
        return null;
    }

    private void j6(aty$a<V> aty_a_V) {
        int DW = DW(aty_a_V.j6);
        aty_a_V.FH = this.j6[DW];
        this.j6[DW] = aty_a_V;
    }

    private void j6() {
        aty$a[] aty_aArr = this.j6;
        int length = this.j6.length;
        this.j6 = j6(length << 1);
        this.FH = (int) (((float) this.j6.length) * 0.75f);
        for (int i = 0; i < length; i++) {
            aty$a aty_a = aty_aArr[i];
            while (aty_a != null) {
                aty$a aty_a2 = aty_a.FH;
                j6(aty_a);
                aty_a = aty_a2;
            }
        }
    }

    private final int DW(long j) {
        int i = ((int) j) >>> 1;
        return (i ^ ((i >>> 20) ^ (i >>> 12))) & (this.j6.length - 1);
    }

    private static final <V> aty$a<V>[] j6(int i) {
        return new aty$a[i];
    }
}
