import java.io.File;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class awt extends awp {
    static boolean gn() {
        String str = (String) AccessController.doPrivileged(new awt$1());
        return (str == null || axh.j6(str).indexOf("windows") == -1) ? false : true;
    }

    awt() {
    }

    public boolean DW() {
        return false;
    }

    public boolean j6(File file) {
        return false;
    }

    public boolean j6(File file, boolean z) {
        return false;
    }

    public boolean Hw() {
        return true;
    }

    protected File VH() {
        File j6 = awp.j6(axi.FH().j6("PATH"), "git.exe", "git.cmd");
        if (j6 != null) {
            return j6.getParentFile().getParentFile();
        }
        String j62 = awp.j6(FH(), new String[]{"bash", "--login", "-c", "which git"}, Charset.defaultCharset().name());
        if (j62 == null) {
            return null;
        }
        j6 = j6(null, j62);
        if (j6 != null) {
            return j6.getParentFile().getParentFile();
        }
        return null;
    }

    protected File v5() {
        String j6 = axi.FH().j6("HOME");
        if (j6 != null) {
            return j6(null, j6);
        }
        String j62 = axi.FH().j6("HOMEDRIVE");
        if (j62 != null) {
            return new File(j62, axi.FH().j6("HOMEPATH"));
        }
        j62 = axi.FH().j6("HOMESHARE");
        if (j62 != null) {
            return new File(j62);
        }
        return super.v5();
    }

    public ProcessBuilder DW(String str, String[] strArr) {
        List arrayList = new ArrayList(strArr.length + 3);
        arrayList.add("cmd.exe");
        arrayList.add("/c");
        arrayList.add(str);
        arrayList.addAll(Arrays.asList(strArr));
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command(arrayList);
        return processBuilder;
    }
}
