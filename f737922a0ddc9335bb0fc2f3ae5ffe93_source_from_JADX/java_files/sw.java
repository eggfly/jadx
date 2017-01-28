abstract class sw {
    private final abf DW;
    private final int FH;
    private final sr Hw;
    private ti Zo;
    private final su j6;
    private int v5;

    protected abstract String DW();

    protected abstract int FH();

    protected abstract String j6(int i);

    protected abstract te j6(int i, int i2, abc abc, ta taVar);

    public sw(su suVar, abf abf, int i, sr srVar) {
        if (suVar == null) {
            throw new NullPointerException("cf == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        } else if (srVar == null) {
            throw new NullPointerException("attributeFactory == null");
        } else {
            this.j6 = suVar;
            this.DW = abf;
            this.FH = i;
            this.Hw = srVar;
            this.v5 = -1;
        }
    }

    public int Hw() {
        v5();
        return this.v5;
    }

    public final void j6(ti tiVar) {
        this.Zo = tiVar;
    }

    protected final void v5() {
        if (this.v5 < 0) {
            j6();
        }
    }

    protected final int Zo() {
        return this.j6.j6().Zo(this.FH);
    }

    protected final abf VH() {
        return this.DW;
    }

    private void j6() {
        int FH = FH();
        int Zo = Zo();
        int i = this.FH + 2;
        acu j6 = this.j6.j6();
        aai Zo2 = this.j6.Zo();
        if (this.Zo != null) {
            this.Zo.j6(j6, this.FH, 2, DW() + "s_count: " + add.FH(Zo));
        }
        int i2 = 0;
        while (i2 < Zo) {
            try {
                int Zo3 = j6.Zo(i);
                int Zo4 = j6.Zo(i + 2);
                int Zo5 = j6.Zo(i + 4);
                abe abe = (abe) Zo2.j6(Zo4);
                abe abe2 = (abe) Zo2.j6(Zo5);
                if (this.Zo != null) {
                    this.Zo.j6(j6, i, abe.tp(), abe2.tp());
                    this.Zo.j6(j6, i, 0, "\n" + DW() + "s[" + i2 + "]:\n");
                    this.Zo.j6(1);
                    this.Zo.j6(j6, i, 2, "access_flags: " + j6(Zo3));
                    this.Zo.j6(j6, i + 2, 2, "name: " + abe.Hw());
                    this.Zo.j6(j6, i + 4, 2, "descriptor: " + abe2.Hw());
                }
                ss ssVar = new ss(this.j6, FH, i + 6, this.Hw);
                ssVar.j6(this.Zo);
                i = ssVar.j6();
                ta DW = ssVar.DW();
                DW.l_();
                te j62 = j6(i2, Zo3, new abc(abe, abe2), DW);
                if (this.Zo != null) {
                    this.Zo.j6(-1);
                    this.Zo.j6(j6, i, 0, "end " + DW() + "s[" + i2 + "]\n");
                    this.Zo.j6(j6, i, abe.tp(), abe2.tp(), j62);
                }
                i2++;
            } catch (th e) {
                e.j6("...while parsing " + DW() + "s[" + i2 + "]");
                throw e;
            } catch (Throwable e2) {
                th thVar = new th(e2);
                thVar.j6("...while parsing " + DW() + "s[" + i2 + "]");
                throw thVar;
            }
        }
        this.v5 = i;
    }
}
