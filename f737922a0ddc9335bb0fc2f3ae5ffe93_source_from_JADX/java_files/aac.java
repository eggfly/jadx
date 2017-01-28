public final class aac {
    public static final aac j6;
    private final abe DW;
    private final int FH;
    private final int Hw;

    static {
        j6 = new aac(null, -1, -1);
    }

    public aac(abe abe, int i, int i2) {
        if (i < -1) {
            throw new IllegalArgumentException("address < -1");
        } else if (i2 < -1) {
            throw new IllegalArgumentException("line < -1");
        } else {
            this.DW = abe;
            this.FH = i;
            this.Hw = i2;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        if (this.DW != null) {
            stringBuffer.append(this.DW.Hw());
            stringBuffer.append(":");
        }
        if (this.Hw >= 0) {
            stringBuffer.append(this.Hw);
        }
        stringBuffer.append('@');
        if (this.FH < 0) {
            stringBuffer.append("????");
        } else {
            stringBuffer.append(add.FH(this.FH));
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aac)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        aac aac = (aac) obj;
        if (this.FH == aac.FH && DW(aac)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.DW.hashCode() + this.FH) + this.Hw;
    }

    public boolean j6(aac aac) {
        return this.Hw == aac.Hw;
    }

    public boolean DW(aac aac) {
        return this.Hw == aac.Hw && (this.DW == aac.DW || (this.DW != null && this.DW.equals(aac.DW)));
    }

    public int j6() {
        return this.Hw;
    }
}
