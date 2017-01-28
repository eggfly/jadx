import java.io.File;
import java.io.FileNotFoundException;

class ajq$a extends ajq {
    private final File j6;

    ajq$a(File file) {
        this.j6 = file;
    }

    public long j6(String str, ans ans) {
        return new File(this.j6, str).length();
    }

    public anx DW(String str, ans ans) {
        File file = new File(this.j6, str);
        if (file.isFile()) {
            return new ajq$a$1(this, file);
        }
        throw new FileNotFoundException(str);
    }
}
