public abstract class xl extends xc implements Comparable<xl> {
    private int DW;
    private xp FH;
    private int Hw;
    private final int j6;

    public abstract String DW();

    protected abstract void a_(wq wqVar, acr acr);

    public /* synthetic */ int compareTo(Object obj) {
        return FH((xl) obj);
    }

    public static int DW(xl xlVar) {
        if (xlVar == null) {
            return 0;
        }
        return xlVar.v5();
    }

    public xl(int i, int i2) {
        xp.j6(i);
        if (i2 < -1) {
            throw new IllegalArgumentException("writeSize < -1");
        }
        this.j6 = i;
        this.DW = i2;
        this.FH = null;
        this.Hw = -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        xl xlVar = (xl) obj;
        if (j6() != xlVar.j6()) {
            return false;
        }
        if (j6(xlVar) != 0) {
            return false;
        }
        return true;
    }

    public final int FH(xl xlVar) {
        if (this == xlVar) {
            return 0;
        }
        Enum j6 = j6();
        Enum j62 = xlVar.j6();
        if (j6 != j62) {
            return j6.compareTo(j62);
        }
        return j6(xlVar);
    }

    public final void j6(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeSize < 0");
        } else if (this.DW >= 0) {
            throw new UnsupportedOperationException("writeSize already set");
        } else {
            this.DW = i;
        }
    }

    public final int n_() {
        if (this.DW >= 0) {
            return this.DW;
        }
        throw new UnsupportedOperationException("writeSize is unknown");
    }

    public final void j6(wq wqVar, acr acr) {
        acr.gn(this.j6);
        try {
            if (this.DW < 0) {
                throw new UnsupportedOperationException("writeSize is unknown");
            }
            acr.j6(v5());
            a_(wqVar, acr);
        } catch (Throwable e) {
            throw ada.j6(e, "...while writing " + this);
        }
    }

    public final int v5() {
        if (this.Hw >= 0) {
            return this.FH.FH(this.Hw);
        }
        throw new RuntimeException("offset not yet known");
    }

    public final int DW(xp xpVar, int i) {
        if (xpVar == null) {
            throw new NullPointerException("addedTo == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        } else if (this.FH != null) {
            throw new RuntimeException("already written");
        } else {
            int i2 = this.j6 - 1;
            i2 = (i2 ^ -1) & (i + i2);
            this.FH = xpVar;
            this.Hw = i2;
            j6(xpVar, i2);
            return i2;
        }
    }

    public final int Zo() {
        return this.j6;
    }

    public final String VH() {
        return '[' + Integer.toHexString(v5()) + ']';
    }

    protected int j6(xl xlVar) {
        throw new UnsupportedOperationException("unsupported");
    }

    protected void j6(xp xpVar, int i) {
    }
}
