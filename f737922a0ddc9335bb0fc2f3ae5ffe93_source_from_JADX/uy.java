public final class uy extends va {
    private final adg DW;
    private final uc[] FH;
    private final boolean Hw;
    private final uc j6;

    public uy(aac aac, uc ucVar, adg adg, uc[] ucVarArr) {
        super(aac, zx.j6);
        if (ucVar == null) {
            throw new NullPointerException("user == null");
        } else if (adg == null) {
            throw new NullPointerException("cases == null");
        } else if (ucVarArr == null) {
            throw new NullPointerException("targets == null");
        } else {
            int DW = adg.DW();
            if (DW != ucVarArr.length) {
                throw new IllegalArgumentException("cases / targets mismatch");
            } else if (DW > 65535) {
                throw new IllegalArgumentException("too many cases");
            } else {
                this.j6 = ucVar;
                this.DW = adg;
                this.FH = ucVarArr;
                this.Hw = FH(adg);
            }
        }
    }

    public int j6() {
        return this.Hw ? (int) j6(this.DW) : (int) DW(this.DW);
    }

    public void j6(acr acr) {
        int i = 0;
        int VH = this.j6.VH();
        int j6 = ui.Mz.FH().j6();
        int length = this.FH.length;
        int i2;
        if (this.Hw) {
            int DW = length == 0 ? 0 : this.DW.DW(0);
            if (length == 0) {
                i2 = 0;
            } else {
                i2 = this.DW.DW(length - 1);
            }
            int i3 = (i2 - DW) + 1;
            acr.DW(256);
            acr.DW(i3);
            acr.Hw(DW);
            for (length = 0; length < i3; length++) {
                if (this.DW.DW(i) > DW + length) {
                    i2 = j6;
                } else {
                    i2 = this.FH[i].VH() - VH;
                    i++;
                }
                acr.Hw(i2);
            }
            return;
        }
        acr.DW(512);
        acr.DW(length);
        for (i2 = 0; i2 < length; i2++) {
            acr.Hw(this.DW.DW(i2));
        }
        while (i < length) {
            acr.Hw(this.FH[i].VH() - VH);
            i++;
        }
    }

    public uf j6(zx zxVar) {
        return new uy(u7(), this.j6, this.DW, this.FH);
    }

    public boolean FH() {
        return this.Hw;
    }

    protected String DW() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.FH.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(this.DW.DW(i));
            stringBuffer.append(": ");
            stringBuffer.append(this.FH[i]);
        }
        return stringBuffer.toString();
    }

    protected String j6(boolean z) {
        int VH = this.j6.VH();
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.FH.length;
        stringBuffer.append(this.Hw ? "packed" : "sparse");
        stringBuffer.append("-switch-payload // for switch @ ");
        stringBuffer.append(add.FH(VH));
        for (int i = 0; i < length; i++) {
            int VH2 = this.FH[i].VH();
            int i2 = VH2 - VH;
            stringBuffer.append("\n  ");
            stringBuffer.append(this.DW.DW(i));
            stringBuffer.append(": ");
            stringBuffer.append(add.j6(VH2));
            stringBuffer.append(" // ");
            stringBuffer.append(add.VH(i2));
        }
        return stringBuffer.toString();
    }

    private static long j6(adg adg) {
        long DW = (((((long) adg.DW(adg.DW() - 1)) - ((long) adg.DW(0))) + 1) * 2) + 4;
        return DW <= 2147483647L ? DW : -1;
    }

    private static long DW(adg adg) {
        return (((long) adg.DW()) * 4) + 2;
    }

    private static boolean FH(adg adg) {
        if (adg.DW() < 2) {
            return true;
        }
        long j6 = j6(adg);
        long DW = DW(adg);
        if (j6 < 0 || j6 > (DW * 5) / 4) {
            return false;
        }
        return true;
    }
}
