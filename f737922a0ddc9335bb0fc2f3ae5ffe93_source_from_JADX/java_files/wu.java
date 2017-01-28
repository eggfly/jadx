public final class wu extends wt implements Comparable<wu> {
    private final wn DW;
    private final abb j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((wu) obj);
    }

    public wu(abb abb, int i, ue ueVar, abn abn) {
        super(i);
        if (abb == null) {
            throw new NullPointerException("method == null");
        }
        this.j6 = abb;
        if (ueVar == null) {
            this.DW = null;
        } else {
            this.DW = new wn(abb, ueVar, (i & 8) != 0, abn);
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof wu) && j6((wu) obj) == 0) {
            return true;
        }
        return false;
    }

    public int j6(wu wuVar) {
        return this.j6.j6(wuVar.j6);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(add.FH(DW()));
        stringBuffer.append(' ');
        stringBuffer.append(this.j6);
        if (this.DW != null) {
            stringBuffer.append(' ');
            stringBuffer.append(this.DW);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void j6(wq wqVar) {
        xj J0 = wqVar.J0();
        xk Hw = wqVar.Hw();
        J0.j6(this.j6);
        if (this.DW != null) {
            Hw.j6(this.DW);
        }
    }

    public final String Hw() {
        return this.j6.Hw();
    }

    public int j6(wq wqVar, acr acr, int i, int i2) {
        int i3;
        int DW = wqVar.J0().DW(this.j6);
        int i4 = DW - i;
        int DW2 = DW();
        int DW3 = xl.DW(this.DW);
        int i5 = DW3 != 0 ? 1 : 0;
        if ((DW2 & 1280) == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i5 != i3) {
            throw new UnsupportedOperationException("code vs. access_flags mismatch");
        }
        if (acr.j6()) {
            acr.j6(0, String.format("  [%x] %s", new Object[]{Integer.valueOf(i2), this.j6.Hw()}));
            acr.j6(adk.j6(i4), "    method_idx:   " + add.j6(DW));
            acr.j6(adk.j6(DW2), "    access_flags: " + zh.Hw(DW2));
            acr.j6(adk.j6(DW3), "    code_off:     " + add.j6(DW3));
        }
        acr.v5(i4);
        acr.v5(DW2);
        acr.v5(DW3);
        return DW;
    }
}
