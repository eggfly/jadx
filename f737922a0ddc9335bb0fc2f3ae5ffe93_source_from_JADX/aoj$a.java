import java.io.File;
import java.io.IOException;

public class aoj$a implements aoj$b {
    private final awp DW;
    private final File j6;

    public static aoj$a j6(File file, awp awp) {
        return new aoj$a(file, awp);
    }

    public static aoj$a DW(File file, awp awp) {
        File Hw = Hw(file, awp);
        if (Hw != null) {
            file = Hw;
        }
        return new aoj$a(file, awp);
    }

    protected aoj$a(File file, awp awp) {
        this.j6 = j6(file);
        this.DW = awp;
    }

    private static File j6(File file) {
        try {
            return file.getCanonicalFile();
        } catch (IOException e) {
            return file.getAbsoluteFile();
        }
    }

    public final File j6() {
        return this.j6;
    }

    public aoh j6(boolean z) {
        if (!z || FH(this.j6, this.DW)) {
            return new arc(this.j6);
        }
        throw new als(this.j6);
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof aoj$a) && this.j6.equals(((aoj$a) obj).j6);
    }

    public String toString() {
        return this.j6.toString();
    }

    public static boolean FH(File file, awp awp) {
        return awp.j6(file, "objects").exists() && awp.j6(file, "refs").exists() && DW(new File(file, "HEAD"));
    }

    private static boolean DW(File file) {
        String FH = FH(file);
        return FH != null && (FH.startsWith("ref: refs/") || ans.j6(FH));
    }

    private static String FH(File file) {
        String str = null;
        try {
            byte[] DW = awx.DW(file, 4096);
            int length = DW.length;
            if (length != 0) {
                if (DW[length - 1] == 10) {
                    length--;
                }
                str = axe.FH(DW, 0, length);
            }
        } catch (IOException e) {
        }
        return str;
    }

    public static File Hw(File file, awp awp) {
        if (FH(file, awp)) {
            return file;
        }
        if (FH(new File(file, ".git"), awp)) {
            return new File(file, ".git");
        }
        String name = file.getName();
        File parentFile = file.getParentFile();
        if (FH(new File(parentFile, new StringBuilder(String.valueOf(name)).append(".git").toString()), awp)) {
            return new File(parentFile, new StringBuilder(String.valueOf(name)).append(".git").toString());
        }
        return null;
    }
}
