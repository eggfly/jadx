import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class ajq$a$1 extends anx {
    private final /* synthetic */ File DW;
    final /* synthetic */ ajq$a j6;

    ajq$a$1(ajq$a ajq_a, File file) {
        this.j6 = ajq_a;
        this.DW = file;
    }

    public long j6() {
        return this.DW.length();
    }

    public int DW() {
        return 3;
    }

    public anz FH() {
        InputStream fileInputStream = new FileInputStream(this.DW);
        return new anz$a(DW(), fileInputStream.getChannel().size(), new BufferedInputStream(fileInputStream));
    }

    public boolean Hw() {
        return true;
    }

    public byte[] v5() {
        throw new alf();
    }
}
