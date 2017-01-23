import java.util.concurrent.Callable;

final class asq implements Callable<Object> {
    private final any DW;
    private final asl FH;
    private final aon Hw;
    private final asv[] VH;
    private final int Zo;
    private final asw j6;
    private final int v5;

    asq(asw asw, any any, asl asl, aon aon, int i, int i2, asv[] asvArr) {
        this.j6 = asw;
        this.DW = any;
        this.FH = asl;
        this.Hw = aon;
        this.v5 = i;
        this.Zo = i2;
        this.VH = asvArr;
    }

    public Object call() {
        any j6 = this.DW.j6();
        try {
            new asr(this.j6, this.FH, j6).j6(this.Hw, this.VH, this.Zo, this.v5);
            return null;
        } finally {
            j6.FH();
            this.Hw.FH();
        }
    }
}
