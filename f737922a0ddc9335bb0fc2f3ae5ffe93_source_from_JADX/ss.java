final class ss {
    private final int DW;
    private final int FH;
    private final sr Hw;
    private ti VH;
    private int Zo;
    private final su j6;
    private final tj v5;

    public ss(su suVar, int i, int i2, sr srVar) {
        if (suVar == null) {
            throw new NullPointerException("cf == null");
        } else if (srVar == null) {
            throw new NullPointerException("attributeFactory == null");
        } else {
            int Zo = suVar.j6().Zo(i2);
            this.j6 = suVar;
            this.DW = i;
            this.FH = i2;
            this.Hw = srVar;
            this.v5 = new tj(Zo);
            this.Zo = -1;
        }
    }

    public void j6(ti tiVar) {
        this.VH = tiVar;
    }

    public int j6() {
        FH();
        return this.Zo;
    }

    public tj DW() {
        FH();
        return this.v5;
    }

    private void FH() {
        if (this.Zo < 0) {
            Hw();
        }
    }

    private void Hw() {
        int m_ = this.v5.m_();
        int i = this.FH + 2;
        acu j6 = this.j6.j6();
        if (this.VH != null) {
            this.VH.j6(j6, this.FH, 2, "attributes_count: " + add.FH(m_));
        }
        int i2 = i;
        i = 0;
        while (i < m_) {
            try {
                if (this.VH != null) {
                    this.VH.j6(j6, i2, 0, "\nattributes[" + i + "]:\n");
                    this.VH.j6(1);
                }
                sz j62 = this.Hw.j6(this.j6, this.DW, i2, this.VH);
                int j63 = j62.j6() + i2;
                this.v5.j6(i, j62);
                if (this.VH != null) {
                    this.VH.j6(-1);
                    this.VH.j6(j6, j63, 0, "end attributes[" + i + "]\n");
                }
                i++;
                i2 = j63;
            } catch (th e) {
                e.j6("...while parsing attributes[" + i + "]");
                throw e;
            } catch (Throwable e2) {
                th thVar = new th(e2);
                thVar.j6("...while parsing attributes[" + i + "]");
                throw thVar;
            }
        }
        this.Zo = i2;
    }
}
