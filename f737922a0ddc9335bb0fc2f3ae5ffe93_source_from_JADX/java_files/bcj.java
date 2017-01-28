public class bcj extends ayp {
    private ayh DW;
    private ayq j6;

    private bcj(ayw ayw) {
        this.j6 = (ayq) ayw.j6(0);
        this.DW = ayw.j6(1);
    }

    public static bcj j6(Object obj) {
        if (obj instanceof bcj) {
            return (bcj) obj;
        }
        if (obj != null) {
            return new bcj(ayw.j6(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    public ayq FH() {
        return this.j6;
    }

    public ayh Hw() {
        return this.DW;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        return new bal(ayi);
    }
}
