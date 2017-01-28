import java.io.IOException;

class ari extends asz {
    long DW;
    long FH;
    private long Hw;
    aro j6;
    private ans v5;

    ari() {
    }

    static ari j6(aro aro, long j, long j2) {
        ari ari_1 = new ari$1();
        ari_1.j6 = aro;
        ari_1.DW = j;
        ari_1.FH = j2;
        return ari_1;
    }

    static ari j6(aro aro, long j, long j2, ans ans) {
        ari ari_a = new ari$a();
        ari_a.j6 = aro;
        ari_a.DW = j;
        ari_a.FH = j2;
        ari_a.v5 = ans;
        return ari_a;
    }

    static ari j6(aro aro, long j, long j2, long j3) {
        ari ari_a = new ari$a();
        ari_a.j6 = aro;
        ari_a.DW = j;
        ari_a.FH = j2;
        ari_a.Hw = j3;
        return ari_a;
    }

    public int j6() {
        return (int) Math.min(this.FH, 2147483647L);
    }

    public ans DW() {
        if (this.v5 == null && FH() == 0) {
            try {
                this.v5 = this.j6.j6(this.Hw);
            } catch (IOException e) {
                return null;
            }
        }
        return this.v5;
    }
}
