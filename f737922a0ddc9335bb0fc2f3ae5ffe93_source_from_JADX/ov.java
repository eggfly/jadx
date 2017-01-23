public class ov {
    public static boolean j6(String str) {
        return (FH(str) == null || Hw(str) || v5(str)) ? false : true;
    }

    public static boolean DW(String str) {
        return str.toLowerCase().endsWith(".html") || str.toLowerCase().endsWith(".htm");
    }

    private static boolean Hw(String str) {
        return "www".equals(qh.Zo(str)) && Zo(qh.v5(str));
    }

    private static boolean v5(String str) {
        return "www".equals(qh.Zo(str)) && "assets".equals(qh.Zo(qh.v5(str)));
    }

    private static boolean Zo(String str) {
        return qh.VH(new StringBuilder().append(str).append("/www").toString()) && qh.VH(str + "/.cordova");
    }

    public static String FH(String str) {
        if (qh.VH(str + "/index.html")) {
            return str + "/index.html";
        }
        if (qh.VH(str + "/index.htm")) {
            return str + "/index.htm";
        }
        return null;
    }
}
