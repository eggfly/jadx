public class fo {
    public fo$c DW;
    public boolean FH;
    public String j6;

    public fo(String str) {
        this.j6 = str;
    }

    public fo(String str, fo$d fo_d) {
        this.j6 = str;
        this.DW = new fo$c(fo_d);
        this.FH = false;
    }

    public fo(String str, fo$c fo_c) {
        this.j6 = str;
        this.DW = fo_c;
        this.FH = false;
    }

    public fo(String str, fo$b fo_b) {
        this.j6 = str;
        this.DW = fo_b.j6;
        this.FH = true;
    }
}
