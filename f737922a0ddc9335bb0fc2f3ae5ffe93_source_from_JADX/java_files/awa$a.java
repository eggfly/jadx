import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class awa$a extends awd$a {
    private final anl Hw;
    private long Zo;
    final File j6;
    private long v5;

    awa$a(File file, awp awp) {
        this.v5 = -1;
        this.j6 = file;
        if (file.isDirectory()) {
            if (new File(file, ".git").exists()) {
                this.Hw = anl.v5;
            } else {
                this.Hw = anl.j6;
            }
        } else if (awp.j6(this.j6)) {
            this.Hw = anl.Hw;
        } else {
            this.Hw = anl.FH;
        }
    }

    public anl j6() {
        return this.Hw;
    }

    public String DW() {
        return this.j6.getName();
    }

    public long FH() {
        if (this.v5 < 0) {
            this.v5 = this.j6.length();
        }
        return this.v5;
    }

    public long Hw() {
        if (this.Zo == 0) {
            this.Zo = this.j6.lastModified();
        }
        return this.Zo;
    }

    public InputStream v5() {
        return new FileInputStream(this.j6);
    }
}
