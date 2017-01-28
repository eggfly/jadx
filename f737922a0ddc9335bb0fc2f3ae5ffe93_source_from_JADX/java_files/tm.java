public abstract class tm implements te {
    private final int DW;
    private final abc FH;
    private final ta Hw;
    private final abf j6;

    public tm(abf abf, int i, abc abc, ta taVar) {
        if (abf == null) {
            throw new NullPointerException("definingClass == null");
        } else if (abc == null) {
            throw new NullPointerException("nat == null");
        } else if (taVar == null) {
            throw new NullPointerException("attributes == null");
        } else {
            this.j6 = abf;
            this.DW = i;
            this.FH = abc;
            this.Hw = taVar;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.FH.Hw());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public final abf Zo() {
        return this.j6;
    }

    public final int Hw() {
        return this.DW;
    }

    public final abc j6() {
        return this.FH;
    }

    public final abe DW() {
        return this.FH.j6();
    }

    public final abe FH() {
        return this.FH.DW();
    }

    public final ta v5() {
        return this.Hw;
    }
}
