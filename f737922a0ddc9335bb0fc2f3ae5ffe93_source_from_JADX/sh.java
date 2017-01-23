public class sh extends sd {
    private final abm[] j6;

    public /* synthetic */ sd j6() {
        return v5();
    }

    public sh(int i) {
        super(i != 0);
        this.j6 = new abm[i];
    }

    public sh v5() {
        sh shVar = new sh(this.j6.length);
        System.arraycopy(this.j6, 0, shVar.j6, 0, this.j6.length);
        return shVar;
    }

    public void j6(ada ada) {
        for (int i = 0; i < this.j6.length; i++) {
            Object obj = this.j6[i];
            ada.j6("locals[" + add.FH(i) + "]: " + (obj == null ? "<invalid>" : obj.toString()));
        }
    }

    public String Hw() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.j6.length; i++) {
            Object obj = this.j6[i];
            stringBuilder.append("locals[" + add.FH(i) + "]: " + (obj == null ? "<invalid>" : obj.toString()) + "\n");
        }
        return stringBuilder.toString();
    }

    public void j6(abl abl) {
        int length = this.j6.length;
        if (length != 0) {
            we();
            abl j3 = abl.j3();
            for (int i = 0; i < length; i++) {
                if (this.j6[i] == abl) {
                    this.j6[i] = j3;
                }
            }
        }
    }

    public int Zo() {
        return this.j6.length;
    }

    public void j6(int i, abm abm) {
        we();
        try {
            abm DW = abm.DW();
            if (i < 0) {
                throw new IndexOutOfBoundsException("idx < 0");
            }
            if (DW.j6().we()) {
                this.j6[i + 1] = null;
            }
            this.j6[i] = DW;
            if (i != 0) {
                DW = this.j6[i - 1];
                if (DW != null && DW.j6().we()) {
                    this.j6[i - 1] = null;
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("type == null");
        }
    }

    public void j6(zw zwVar) {
        j6(zwVar.VH(), (abm) zwVar);
    }

    public void DW(int i) {
        we();
        this.j6[i] = null;
    }

    public abm FH(int i) {
        return this.j6[i];
    }

    public abm j6(int i) {
        abm abm = this.j6[i];
        if (abm == null) {
            return j6(i, "invalid");
        }
        return abm;
    }

    public sd j6(sd sdVar) {
        if (sdVar instanceof sh) {
            return j6((sh) sdVar);
        }
        return sdVar.j6((sd) this);
    }

    public sh j6(sh shVar) {
        try {
            return sg.j6(this, shVar);
        } catch (ada e) {
            e.j6("underlay locals:");
            j6(e);
            e.j6("overlay locals:");
            shVar.j6(e);
            throw e;
        }
    }

    public se j6(sd sdVar, int i) {
        return new se(Zo()).j6(sdVar, i);
    }

    protected sh DW() {
        return this;
    }

    private static abm j6(int i, String str) {
        throw new sl("local " + add.FH(i) + ": " + str);
    }
}
