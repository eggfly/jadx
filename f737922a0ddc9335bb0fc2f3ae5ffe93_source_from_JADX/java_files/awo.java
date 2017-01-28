import java.util.regex.Pattern;

public class awo {
    private static final Pattern DW;
    private static final Pattern FH;
    private static final Pattern j6;

    static String j6(String str) {
        return str.replaceAll("(?i)(?m)^Signed-off-by:.*$\n?", "").replaceAll("(?m)^#.*$\n?", "").replaceAll("(?m)\n\n\n+", "\\\n").replaceAll("\\n*$", "").replaceAll("(?s)\ndiff --git.*", "").trim();
    }

    public static ans j6(ans ans, ans ans2, aoa aoa, aoa aoa2, String str) {
        String j6 = j6(str);
        if (j6.length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tree ");
        stringBuilder.append(ans.j6(ans));
        stringBuilder.append("\n");
        if (ans2 != null) {
            stringBuilder.append("parent ");
            stringBuilder.append(ans.j6(ans2));
            stringBuilder.append("\n");
        }
        stringBuilder.append("author ");
        stringBuilder.append(aoa.Hw());
        stringBuilder.append("\n");
        stringBuilder.append("committer ");
        stringBuilder.append(aoa2.Hw());
        stringBuilder.append("\n\n");
        stringBuilder.append(j6);
        return new anw$a().j6(1, stringBuilder.toString().getBytes("UTF-8"));
    }

    static {
        j6 = Pattern.compile("^(Bug|Issue)[a-zA-Z0-9-]*:.*$");
        DW = Pattern.compile("(^[a-zA-Z0-9-]+:(?!//).*$)");
        FH = Pattern.compile("^[ \\[].*$");
    }

    public static String j6(String str, ans ans) {
        return j6(str, ans, false);
    }

    public static String j6(String str, ans ans, boolean z) {
        int length;
        if (str.indexOf("Change-Id:") <= 0) {
            String[] split = str.split("\n");
            length = split.length;
            int length2 = split.length - 1;
            while (length2 > 1) {
                if (!DW.matcher(split[length2]).matches()) {
                    if (length != split.length && split[length2].length() == 0) {
                        break;
                    } else if (length == split.length || !FH.matcher(split[length2]).matches()) {
                        length = split.length;
                        break;
                    } else {
                        length = length2 + 1;
                    }
                } else {
                    length = length2;
                }
                length2--;
            }
            length2 = length;
            int i = length;
            while (length2 < split.length && j6.matcher(split[length2]).matches()) {
                i = length2 + 1;
                length2++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            length2 = 0;
            while (length2 < i) {
                stringBuilder.append(split[length2]);
                stringBuilder.append("\n");
                length2++;
            }
            if (i == split.length && i == length) {
                stringBuilder.append("\n");
            }
            stringBuilder.append("Change-Id:");
            stringBuilder.append(" I");
            stringBuilder.append(ans.j6(ans));
            stringBuilder.append("\n");
            for (length = length2; length < split.length; length++) {
                stringBuilder.append(split[length]);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        } else if (!z) {
            return str;
        } else {
            length = str.indexOf("Change-Id:") + 10;
            while (str.charAt(length) == ' ') {
                length++;
            }
            return str.replace(str.length() == length + 40 ? str.substring(length) : str.substring(length, length + 41), "I" + ans.FH());
        }
    }
}
