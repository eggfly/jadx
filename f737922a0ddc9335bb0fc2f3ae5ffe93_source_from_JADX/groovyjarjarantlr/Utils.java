package groovyjarjarantlr;

public class Utils {
    private static boolean DW;
    private static boolean j6;

    static {
        j6 = true;
        DW = false;
        if ("true".equalsIgnoreCase(System.getProperty("ANTLR_DO_NOT_EXIT", "false"))) {
            j6 = false;
        }
        if ("true".equalsIgnoreCase(System.getProperty("ANTLR_USE_DIRECT_CLASS_LOADING", "false"))) {
            DW = true;
        }
    }

    public static Class j6(String str) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (DW || contextClassLoader == null) {
                return Class.forName(str);
            }
            return contextClassLoader.loadClass(str);
        } catch (Exception e) {
            return Class.forName(str);
        }
    }

    public static void DW(String str) {
        if (j6) {
            System.exit(1);
        }
        throw new RuntimeException(new StringBuffer().append("ANTLR Panic: ").append(str).toString());
    }
}
