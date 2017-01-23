package groovyjarjarantlr;

public class StringUtils {
    public static String j6(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        int lastIndexOf = str.lastIndexOf(str3);
        return (indexOf == -1 || lastIndexOf == -1) ? str : str.substring(indexOf + 1, lastIndexOf);
    }
}
