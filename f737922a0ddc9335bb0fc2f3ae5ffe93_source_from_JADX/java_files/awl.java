public abstract class awl {
    public static final awl FH;
    public static final awl Hw;

    public abstract awl DW();

    public /* synthetic */ Object clone() {
        return DW();
    }

    public abstract boolean j6();

    public abstract boolean j6(awc awc);

    static {
        FH = new awl$a();
        Hw = new awl$b();
    }

    public String toString() {
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        return name.replace('$', '.');
    }
}
