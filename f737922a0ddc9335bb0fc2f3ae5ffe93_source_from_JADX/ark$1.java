import java.io.File;
import java.io.FilenameFilter;

class ark$1 implements FilenameFilter {
    ark$1() {
    }

    public boolean accept(File file, String str) {
        return !str.endsWith(".lock");
    }
}
