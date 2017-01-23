import android.os.Build.VERSION;

public final class agb {
    public static boolean DW() {
        return j6(13);
    }

    public static boolean FH() {
        return j6(14);
    }

    public static boolean Hw() {
        return j6(16);
    }

    public static boolean VH() {
        return j6(19);
    }

    public static boolean Zo() {
        return j6(18);
    }

    public static boolean gn() {
        return j6(20);
    }

    public static boolean j6() {
        return j6(11);
    }

    private static boolean j6(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean tp() {
        return j6(21);
    }

    @Deprecated
    public static boolean u7() {
        return tp();
    }

    public static boolean v5() {
        return j6(17);
    }
}
