import java.util.TimeZone;

public abstract class axi {
    static final /* synthetic */ boolean FH;
    private static axi j6;

    public abstract long DW();

    public abstract ara DW(ani ani, awp awp);

    public abstract String DW(String str);

    public abstract int j6(long j);

    public abstract ara j6(ani ani, awp awp);

    public abstract String j6();

    public abstract String j6(String str);

    static {
        FH = !axi.class.desiredAssertionStatus();
        j6 = new axi$1();
    }

    public static axi FH() {
        return j6;
    }

    public static void j6(axi axi) {
        j6 = axi;
    }

    public TimeZone Hw() {
        return TimeZone.getDefault();
    }
}
