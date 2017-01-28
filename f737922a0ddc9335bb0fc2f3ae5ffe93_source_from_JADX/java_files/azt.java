public class azt extends ayv implements azb {
    private char[] j6;

    azt(char[] cArr) {
        this.j6 = cArr;
    }

    public String j6() {
        return new String(this.j6);
    }

    public String toString() {
        return j6();
    }

    public int hashCode() {
        return bhf.j6(this.j6);
    }

    protected boolean j6(ayv ayv) {
        if (!(ayv instanceof azt)) {
            return false;
        }
        return bhf.j6(this.j6, ((azt) ayv).j6);
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return (bbg.j6(this.j6.length * 2) + 1) + (this.j6.length * 2);
    }

    void j6(ayt ayt) {
        ayt.DW(30);
        ayt.j6(this.j6.length * 2);
        for (int i = 0; i != this.j6.length; i++) {
            char c = this.j6[i];
            ayt.DW((byte) (c >> 8));
            ayt.DW((byte) c);
        }
    }
}
