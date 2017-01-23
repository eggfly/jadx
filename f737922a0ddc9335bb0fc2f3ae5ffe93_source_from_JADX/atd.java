import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class atd {
    private final awc DW;
    private aol FH;
    private ara Hw;
    private final aoh j6;
    private String v5;

    public static atd j6(aoh aoh) {
        atd atd = new atd(aoh);
        atd.j6(new aku(aoh.QX()));
        return atd;
    }

    public static File j6(aoh aoh, String str) {
        return new File(aoh.Mr(), str);
    }

    public static aoh DW(aoh aoh, String str) {
        return j6(aoh.Mr(), str);
    }

    public static aoh j6(File file, String str) {
        if (!new File(file, str).isDirectory()) {
            return null;
        }
        try {
            return ((aoi) ((aoi) ((aoi) new aoi().j6(true)).j6(awp.j6)).Hw(new File(file, str))).we();
        } catch (als e) {
            return null;
        }
    }

    public static String FH(aoh aoh, String str) {
        if (!str.startsWith("./") && !str.startsWith("../")) {
            return str;
        }
        String j6;
        aoc FH = aoh.FH("HEAD");
        if (FH != null) {
            if (FH.DW()) {
                FH = FH.FH();
            }
            j6 = aoh.VH().j6("branch", aoh.v5(FH.j6()), "remote");
        } else {
            j6 = null;
        }
        if (j6 == null) {
            j6 = "origin";
        }
        j6 = aoh.VH().j6("remote", j6, "url");
        if (j6 == null) {
            j6 = aoh.Mr().getAbsolutePath();
            if ('\\' == File.separatorChar) {
                j6 = j6.replace('\\', '/');
            }
        }
        if (j6.charAt(j6.length() - 1) == '/') {
            j6 = j6.substring(0, j6.length() - 1);
        }
        String str2 = j6;
        char c = '/';
        while (str.length() > 0) {
            if (!str.startsWith("./")) {
                if (!str.startsWith("../")) {
                    break;
                }
                int lastIndexOf = str2.lastIndexOf(47);
                if (lastIndexOf < 1) {
                    lastIndexOf = str2.lastIndexOf(58);
                    c = ':';
                }
                if (lastIndexOf < 1) {
                    throw new IOException(MessageFormat.format(JGitText.j6().submoduleParentRemoteUrlInvalid, new Object[]{str2}));
                }
                str2 = str2.substring(0, lastIndexOf);
                str = str.substring(3);
            } else {
                str = str.substring(2);
            }
        }
        return new StringBuilder(String.valueOf(str2)).append(c).append(str).toString();
    }

    public atd(aoh aoh) {
        this.j6 = aoh;
        this.FH = aoh.VH();
        this.DW = new awc(aoh);
        this.DW.j6(true);
    }

    private void we() {
        if (this.Hw == null) {
            ara ara = new ara(new File(this.j6.Mr(), ".gitmodules"), this.j6.gn());
            ara.VH();
            this.Hw = ara;
        }
    }

    public atd j6(awl awl) {
        this.DW.j6(awl);
        return this;
    }

    public atd j6(avx avx) {
        this.DW.j6(avx);
        return this;
    }

    public File j6() {
        return j6(this.j6, this.v5);
    }

    public boolean DW() {
        while (this.DW.EQ()) {
            if (anl.v5 == this.DW.DW(0)) {
                this.v5 = this.DW.we();
                return true;
            }
        }
        this.v5 = null;
        return false;
    }

    public String FH() {
        return this.v5;
    }

    public ans Hw() {
        return this.DW.FH(0);
    }

    public String v5() {
        we();
        return this.Hw.j6("submodule", this.v5, "path");
    }

    public String Zo() {
        return this.FH.j6("submodule", this.v5, "url");
    }

    public String VH() {
        we();
        return this.Hw.j6("submodule", this.v5, "url");
    }

    public String gn() {
        return this.FH.j6("submodule", this.v5, "update");
    }

    public String u7() {
        we();
        return this.Hw.j6("submodule", this.v5, "update");
    }

    public aoh tp() {
        return DW(this.j6, this.v5);
    }

    public String EQ() {
        String VH = VH();
        return VH != null ? FH(this.j6, VH) : null;
    }
}
