import java.lang.ref.SoftReference;

class aqz {
    private static volatile int DW;
    private static final SoftReference<aqz$a> j6;
    private final int FH;
    private final aqz$b[] Hw;
    private int VH;
    private aqz$b Zo;
    private aqz$b v5;

    private static int j6(long j) {
        return (((int) j) << 22) >>> 22;
    }

    static {
        j6 = new SoftReference(null);
        j6(new asf());
    }

    static void j6(asf asf) {
        DW = asf.v5();
    }

    aqz() {
        this.FH = DW;
        this.Hw = new aqz$b[1024];
    }

    aqz$a j6(aro aro, long j) {
        aqz$b aqz_b = this.Hw[j6(j)];
        if (aqz_b == null) {
            return null;
        }
        if (aqz_b.FH == aro && aqz_b.Hw == j) {
            aqz$a aqz_a = (aqz$a) aqz_b.Zo.get();
            if (aqz_a != null) {
                j6(aqz_b);
                return aqz_a;
            }
        }
        return null;
    }

    void j6(aro aro, long j, byte[] bArr, int i) {
        if (bArr.length <= this.FH) {
            aqz$b aqz_b = this.Hw[j6(j)];
            if (aqz_b == null) {
                aqz_b = new aqz$b();
                this.Hw[j6(j)] = aqz_b;
            } else {
                FH(aqz_b);
            }
            this.VH += bArr.length;
            DW();
            aqz_b.FH = aro;
            aqz_b.Hw = j;
            aqz_b.v5 = bArr.length;
            aqz_b.Zo = new SoftReference(new aqz$a(bArr, i));
            j6(aqz_b);
        }
    }

    private void DW() {
        while (this.VH > this.FH && this.Zo != null) {
            aqz$b aqz_b = this.Zo;
            aqz$b aqz_b2 = aqz_b.j6;
            FH(aqz_b);
            aqz_b.j6 = null;
            aqz_b.DW = null;
            if (aqz_b2 == null) {
                this.v5 = null;
            } else {
                aqz_b2.DW = null;
            }
            this.Zo = aqz_b2;
        }
    }

    private void j6(aqz$b aqz_b) {
        DW(aqz_b);
        aqz_b.j6 = null;
        aqz_b.DW = this.v5;
        if (this.v5 != null) {
            this.v5.j6 = aqz_b;
        } else {
            this.Zo = aqz_b;
        }
        this.v5 = aqz_b;
    }

    private void DW(aqz$b aqz_b) {
        aqz$b aqz_b2 = aqz_b.j6;
        aqz$b aqz_b3 = aqz_b.DW;
        if (aqz_b2 != null) {
            aqz_b2.DW = aqz_b3;
        }
        if (aqz_b3 != null) {
            aqz_b3.j6 = aqz_b2;
        }
    }

    private void FH(aqz$b aqz_b) {
        this.VH -= aqz_b.v5;
        aqz_b.FH = null;
        aqz_b.Zo = j6;
        aqz_b.v5 = 0;
    }
}
