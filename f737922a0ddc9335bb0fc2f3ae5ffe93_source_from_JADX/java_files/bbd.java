import java.util.Enumeration;

class bbd extends ayw {
    private byte[] DW;

    bbd(byte[] bArr) {
        this.DW = bArr;
    }

    private void tp() {
        Enumeration bbc = new bbc(this.DW);
        while (bbc.hasMoreElements()) {
            this.j6.addElement(bbc.nextElement());
        }
        this.DW = null;
    }

    public synchronized ayh j6(int i) {
        if (this.DW != null) {
            tp();
        }
        return super.j6(i);
    }

    public synchronized Enumeration Hw() {
        Enumeration Hw;
        if (this.DW == null) {
            Hw = super.Hw();
        } else {
            Hw = new bbc(this.DW);
        }
        return Hw;
    }

    public synchronized int v5() {
        if (this.DW != null) {
            tp();
        }
        return super.v5();
    }

    ayv Zo() {
        if (this.DW != null) {
            tp();
        }
        return super.Zo();
    }

    ayv VH() {
        if (this.DW != null) {
            tp();
        }
        return super.VH();
    }

    int u7() {
        if (this.DW != null) {
            return (bbg.j6(this.DW.length) + 1) + this.DW.length;
        }
        return super.VH().u7();
    }

    void j6(ayt ayt) {
        if (this.DW != null) {
            ayt.j6(48, this.DW);
        } else {
            super.VH().j6(ayt);
        }
    }
}
