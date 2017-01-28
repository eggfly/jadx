import java.io.InputStream;

class arf$2 extends asp {
    private long DW;
    private final /* synthetic */ anx FH;
    private final /* synthetic */ asg Hw;
    final /* synthetic */ arf j6;

    arf$2(arf arf, InputStream inputStream, anx anx, asg asg) {
        this.j6 = arf;
        this.FH = anx;
        this.Hw = asg;
        super(inputStream);
        this.DW = -1;
    }

    protected InputStream j6() {
        InputStream j6;
        if (this.FH instanceof arf) {
            j6 = ((arf) this.FH).j6(this.Hw);
        } else {
            j6 = this.FH.FH();
        }
        if (this.DW == -1) {
            if (j6 instanceof asp) {
                this.DW = ((asp) j6).FH();
            } else if (j6 instanceof anz) {
                this.DW = ((anz) j6).j6();
            }
        }
        return j6;
    }

    protected long DW() {
        if (this.DW == -1) {
            this.DW = this.FH.j6();
        }
        return this.DW;
    }
}
