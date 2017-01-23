import java.io.File;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class awq extends awp {
    protected File VH() {
        File j6 = awp.j6(axi.FH().j6("PATH"), "git");
        if (j6 != null) {
            return j6.getParentFile().getParentFile();
        }
        if (!gn()) {
            return null;
        }
        String j62 = awp.j6(FH(), new String[]{"bash", "--login", "-c", "which git"}, Charset.defaultCharset().name());
        if (j62 == null || j62.length() == 0) {
            return null;
        }
        j6 = new File(j62).getParentFile();
        if (j6 != null) {
            return j6.getParentFile();
        }
        return null;
    }

    awq() {
    }

    public ProcessBuilder DW(String str, String[] strArr) {
        List arrayList = new ArrayList(strArr.length + 4);
        arrayList.add("sh");
        arrayList.add("-c");
        arrayList.add(new StringBuilder(String.valueOf(str)).append(" \"$@\"").toString());
        arrayList.add(str);
        arrayList.addAll(Arrays.asList(strArr));
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command(arrayList);
        return processBuilder;
    }

    private static boolean gn() {
        return "Mac OS X".equals((String) AccessController.doPrivileged(new awq$1()));
    }
}
