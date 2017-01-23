public abstract class aqt {
    public static final aqt DW;
    public static final aqt FH;
    public static final aqt Hw;
    public static final aqt v5;

    public /* synthetic */ Object clone() {
        return j6();
    }

    public abstract aqt j6();

    public abstract boolean j6(aql aql, aqc aqc);

    static {
        DW = new aqt$a();
        FH = new aqt$d();
        Hw = new aqt$c();
        v5 = new aqt$b();
    }

    public boolean DW() {
        return true;
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
