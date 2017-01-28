public class baf extends ayv implements azb {
    private byte[] j6;

    baf(byte[] bArr) {
        this.j6 = bArr;
    }

    public String j6() {
        return bhl.DW(this.j6);
    }

    public String toString() {
        return j6();
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return (bbg.j6(this.j6.length) + 1) + this.j6.length;
    }

    void j6(ayt ayt) {
        ayt.j6(18, this.j6);
    }

    public int hashCode() {
        return bhf.j6(this.j6);
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof baf)) {
            return false;
        }
        return bhf.j6(this.j6, ((baf) ayv).j6);
    }
}
