import java.io.File;
import java.util.concurrent.Callable;

public class aif implements Callable<aid> {
    private boolean DW;
    private File j6;

    public /* synthetic */ Object call() {
        return j6();
    }

    public aid j6() {
        try {
            aoi aoi = new aoi();
            if (this.DW) {
                aoi.v5();
            }
            aoi.tp();
            File file;
            File file2;
            if (this.j6 != null) {
                file = this.j6;
                if (this.DW) {
                    file2 = file;
                } else {
                    file2 = new File(file, ".git");
                }
                aoi.j6(file2);
            } else if (aoi.DW() == null) {
                file = new File(".");
                if (file.getParentFile() != null) {
                    file = file.getParentFile();
                }
                if (this.DW) {
                    file2 = file;
                } else {
                    file2 = new File(file, ".git");
                }
                aoi.j6(file2);
            }
            aoh we = aoi.we();
            if (!we.FH().j6()) {
                we.j6(this.DW);
            }
            return new aid(we);
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        }
    }

    public aif j6(File file) {
        this.j6 = file;
        return this;
    }

    public aif j6(boolean z) {
        this.DW = z;
        return this;
    }
}
