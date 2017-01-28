public class bbf {
    private int DW;
    private String j6;

    public bbf(String str) {
        this.j6 = str;
        this.DW = 0;
    }

    public boolean j6() {
        return this.DW != -1;
    }

    public String DW() {
        if (this.DW == -1) {
            return null;
        }
        int indexOf = this.j6.indexOf(46, this.DW);
        if (indexOf == -1) {
            String substring = this.j6.substring(this.DW);
            this.DW = -1;
            return substring;
        }
        substring = this.j6.substring(this.DW, indexOf);
        this.DW = indexOf + 1;
        return substring;
    }
}
