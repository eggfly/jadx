class su$a implements abn {
    private final int DW;
    private final abg FH;
    private final acu j6;

    public su$a(acu acu, int i, int i2, abg abg, ti tiVar) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size < 0");
        }
        acu j6 = acu.j6(i, (i2 * 2) + i);
        this.j6 = j6;
        this.DW = i2;
        this.FH = abg;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * 2;
            try {
                abf abf = (abf) abg.j6(j6.Zo(i4));
                if (tiVar != null) {
                    tiVar.j6(j6, i4, 2, "  " + abf);
                }
                i3++;
            } catch (Throwable e) {
                throw new RuntimeException("bogus class cpi", e);
            }
        }
    }

    public boolean k_() {
        return false;
    }

    public int m_() {
        return this.DW;
    }

    public abl j6(int i) {
        return ((abf) this.FH.j6(this.j6.Zo(i * 2))).u7();
    }

    public abn j6(abl abl) {
        throw new UnsupportedOperationException("unsupported");
    }
}
