import java.text.MessageFormat;
import java.util.Collection;
import org.eclipse.jgit.JGitText;

public final class axh {
    private static final char[] j6;

    static {
        j6 = new char[91];
        for (char c = '\u0000'; c < j6.length; c = (char) (c + 1)) {
            j6[c] = c;
        }
        for (int i = 65; i <= 90; i = (char) (i + 1)) {
            j6[i] = (char) ((i - 65) + 97);
        }
    }

    public static char j6(char c) {
        return c <= 'Z' ? j6[c] : c;
    }

    public static String j6(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(j6(str.charAt(i)));
        }
        return stringBuilder.toString();
    }

    public static boolean j6(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (j6(str.charAt(i)) != j6(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean DW(String str) {
        if (str == null) {
            throw new NullPointerException(JGitText.j6().expectedBooleanStringValue);
        }
        Boolean FH = FH(str);
        if (FH != null) {
            return FH.booleanValue();
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().notABoolean, new Object[]{str}));
    }

    public static Boolean FH(String str) {
        if (str == null) {
            return null;
        }
        if (j6("yes", str) || j6("true", str) || j6("1", str) || j6("on", str)) {
            return Boolean.TRUE;
        }
        if (j6("no", str) || j6("false", str) || j6("0", str) || j6("off", str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static String j6(Collection<String> collection, String str) {
        return j6(collection, str, str);
    }

    public static String j6(Collection<String> collection, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = collection.size() - 1;
        int i = 0;
        for (String append : collection) {
            stringBuilder.append(append);
            if (i == size - 1) {
                stringBuilder.append(str2);
            } else if (i != size) {
                stringBuilder.append(str);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static boolean Hw(String str) {
        return str == null || str.length() == 0;
    }
}
