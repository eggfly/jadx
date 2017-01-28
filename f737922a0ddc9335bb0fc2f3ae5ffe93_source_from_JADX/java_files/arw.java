import java.io.File;

public class arw {
    private final awp DW;
    private final File j6;

    public arw(File file, awp awp) {
        File parentFile = file.getParentFile();
        String name = file.getName();
        this.j6 = new File(parentFile, name.substring(0, name.length() - 5) + ".keep");
        this.DW = awp;
    }

    public boolean j6(String str) {
        if (str == null) {
            return false;
        }
        if (!str.endsWith("\n")) {
            str = new StringBuilder(String.valueOf(str)).append("\n").toString();
        }
        ark ark = new ark(this.j6, this.DW);
        if (!ark.j6()) {
            return false;
        }
        ark.j6(anj.DW(str));
        return ark.Hw();
    }

    public void j6() {
        awv.j6(this.j6);
    }
}
