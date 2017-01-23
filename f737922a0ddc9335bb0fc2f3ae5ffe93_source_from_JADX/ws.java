public final class ws extends wt implements Comparable<ws> {
    private final aar j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ws) obj);
    }

    public ws(aar aar, int i) {
        super(i);
        if (aar == null) {
            throw new NullPointerException("field == null");
        }
        this.j6 = aar;
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ws) && j6((ws) obj) == 0) {
            return true;
        }
        return false;
    }

    public int j6(ws wsVar) {
        return this.j6.j6(wsVar.j6);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(add.FH(DW()));
        stringBuffer.append(' ');
        stringBuffer.append(this.j6);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void j6(wq wqVar) {
        wqVar.we().j6(this.j6);
    }

    public String Hw() {
        return this.j6.Hw();
    }

    public aar j6() {
        return this.j6;
    }

    public int j6(wq wqVar, acr acr, int i, int i2) {
        int DW = wqVar.we().DW(this.j6);
        int i3 = DW - i;
        int DW2 = DW();
        if (acr.j6()) {
            acr.j6(0, String.format("  [%x] %s", new Object[]{Integer.valueOf(i2), this.j6.Hw()}));
            acr.j6(adk.j6(i3), "    field_idx:    " + add.j6(DW));
            acr.j6(adk.j6(DW2), "    access_flags: " + zh.FH(DW2));
        }
        acr.v5(i3);
        acr.v5(DW2);
        return DW;
    }
}
