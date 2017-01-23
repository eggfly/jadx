import java.io.File;
import java.io.InputStream;

class arf$1 extends anz$a {
    private final /* synthetic */ arm DW;
    private final /* synthetic */ asg FH;
    private final /* synthetic */ File Hw;
    final /* synthetic */ arf j6;
    private final /* synthetic */ ans v5;

    arf$1(arf arf, int i, long j, InputStream inputStream, arm arm, asg asg, File file, ans ans) {
        this.j6 = arf;
        this.DW = arm;
        this.FH = asg;
        this.Hw = file;
        this.v5 = ans;
        super(i, j, inputStream);
    }

    public void close() {
        super.close();
        this.DW.Hw();
        this.FH.FH();
        this.j6.VH.j6(this.Hw, this.v5, true);
    }
}
