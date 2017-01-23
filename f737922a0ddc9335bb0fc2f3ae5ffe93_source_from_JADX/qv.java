public final class qv extends rm {
    private final int DW;
    private final rx FH;
    private final rv Hw;
    private final int j6;
    private final ta v5;

    public qv(int i, int i2, rx rxVar, rv rvVar, ta taVar) {
        super("Code");
        if (i < 0) {
            throw new IllegalArgumentException("maxStack < 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("maxLocals < 0");
        } else if (rxVar == null) {
            throw new NullPointerException("code == null");
        } else {
            try {
                if (rvVar.k_()) {
                    throw new adn("catches.isMutable()");
                }
                try {
                    if (taVar.k_()) {
                        throw new adn("attributes.isMutable()");
                    }
                    this.j6 = i;
                    this.DW = i2;
                    this.FH = rxVar;
                    this.Hw = rvVar;
                    this.v5 = taVar;
                } catch (NullPointerException e) {
                    throw new NullPointerException("attributes == null");
                }
            } catch (NullPointerException e2) {
                throw new NullPointerException("catches == null");
            }
        }
    }

    public int j6() {
        return ((this.FH.FH() + 10) + this.Hw.j6()) + this.v5.DW();
    }

    public int DW() {
        return this.j6;
    }

    public int FH() {
        return this.DW;
    }

    public rx Hw() {
        return this.FH;
    }

    public rv v5() {
        return this.Hw;
    }

    public ta Zo() {
        return this.v5;
    }
}
