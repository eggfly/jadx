import java.util.Enumeration;

class azj$1 implements Enumeration {
    final /* synthetic */ azj DW;
    int j6;

    azj$1(azj azj) {
        this.DW = azj;
        this.j6 = 0;
    }

    public boolean hasMoreElements() {
        return this.j6 < this.DW.DW.length;
    }

    public Object nextElement() {
        ayr[] j6 = this.DW.DW;
        int i = this.j6;
        this.j6 = i + 1;
        return j6[i];
    }
}
