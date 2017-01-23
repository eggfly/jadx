public final class uo extends vb {
    private final zy j6;

    public uo(aac aac, zy zyVar) {
        super(aac);
        if (zyVar == null) {
            throw new NullPointerException("locals == null");
        }
        this.j6 = zyVar;
    }

    public uf Hw(int i) {
        return new uo(u7(), this.j6.DW(i));
    }

    public uf j6(zx zxVar) {
        return new uo(u7(), this.j6);
    }

    public zy FH() {
        return this.j6;
    }

    protected String DW() {
        return this.j6.toString();
    }

    protected String j6(boolean z) {
        int Hw = this.j6.Hw();
        int DW = this.j6.DW();
        StringBuffer stringBuffer = new StringBuffer((Hw * 40) + 100);
        stringBuffer.append("local-snapshot");
        for (Hw = 0; Hw < DW; Hw++) {
            zw j6 = this.j6.j6(Hw);
            if (j6 != null) {
                stringBuffer.append("\n  ");
                stringBuffer.append(up.j6(j6));
            }
        }
        return stringBuffer.toString();
    }
}
