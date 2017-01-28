public final class rz extends adm {
    private final boolean[] DW;
    private int FH;
    private final abm[] j6;

    public rz(int i) {
        boolean z;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        super(z);
        this.j6 = new abm[i];
        this.DW = new boolean[i];
        this.FH = 0;
    }

    public rz j6() {
        rz rzVar = new rz(this.j6.length);
        System.arraycopy(this.j6, 0, rzVar.j6, 0, this.j6.length);
        System.arraycopy(this.DW, 0, rzVar.DW, 0, this.DW.length);
        rzVar.FH = this.FH;
        return rzVar;
    }

    public void j6(ada ada) {
        int i = this.FH - 1;
        int i2 = 0;
        while (i2 <= i) {
            ada.j6("stack[" + (i2 == i ? "top0" : add.FH(i - i2)) + "]: " + DW(this.j6[i2]));
            i2++;
        }
    }

    public void j6(abl abl) {
        if (this.FH != 0) {
            we();
            abl j3 = abl.j3();
            for (int i = 0; i < this.FH; i++) {
                if (this.j6[i] == abl) {
                    this.j6[i] = j3;
                }
            }
        }
    }

    public int DW() {
        return this.FH;
    }

    public void FH() {
        we();
        for (int i = 0; i < this.FH; i++) {
            this.j6[i] = null;
            this.DW[i] = false;
        }
        this.FH = 0;
    }

    public void j6(abm abm) {
        we();
        try {
            abm DW = abm.DW();
            int tp = DW.j6().tp();
            if (this.FH + tp > this.j6.length) {
                j6("overflow");
                return;
            }
            if (tp == 2) {
                this.j6[this.FH] = null;
                this.FH++;
            }
            this.j6[this.FH] = DW;
            this.FH++;
        } catch (NullPointerException e) {
            throw new NullPointerException("type == null");
        }
    }

    public void Hw() {
        we();
        this.DW[this.FH] = true;
    }

    public abm j6(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        } else if (i >= this.FH) {
            return j6("underflow");
        } else {
            return this.j6[(this.FH - i) - 1];
        }
    }

    public boolean DW(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        } else if (i < this.FH) {
            return this.DW[(this.FH - i) - 1];
        } else {
            throw new sl("stack: underflow");
        }
    }

    public abl FH(int i) {
        return j6(i).j6();
    }

    public abm v5() {
        we();
        abm j6 = j6(0);
        this.j6[this.FH - 1] = null;
        this.DW[this.FH - 1] = false;
        this.FH -= j6.j6().tp();
        return j6;
    }

    public void j6(int i, abm abm) {
        we();
        try {
            abm DW = abm.DW();
            int i2 = (this.FH - i) - 1;
            abm abm2 = this.j6[i2];
            if (abm2 == null || abm2.j6().tp() != DW.j6().tp()) {
                j6("incompatible substitution: " + DW(abm2) + " -> " + DW(DW));
            }
            this.j6[i2] = DW;
        } catch (NullPointerException e) {
            throw new NullPointerException("type == null");
        }
    }

    public rz j6(rz rzVar) {
        try {
            return sg.j6(this, rzVar);
        } catch (ada e) {
            e.j6("underlay stack:");
            j6(e);
            e.j6("overlay stack:");
            rzVar.j6(e);
            throw e;
        }
    }

    private static String DW(abm abm) {
        if (abm == null) {
            return "<invalid>";
        }
        return abm.toString();
    }

    private static abm j6(String str) {
        throw new sl("stack: " + str);
    }
}
