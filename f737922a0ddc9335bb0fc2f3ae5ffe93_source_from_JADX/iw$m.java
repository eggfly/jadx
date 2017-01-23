public class iw$m extends iw$i {
    public String j6;

    public iw$m(int i, String str) {
        super(i);
        this.j6 = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof iw$m) {
            return this.j6.equals(((iw$m) obj).j6);
        }
        return false;
    }
}
