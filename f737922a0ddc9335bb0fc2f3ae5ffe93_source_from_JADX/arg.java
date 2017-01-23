import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

class arg extends anx {
    private final long DW;
    private final long FH;
    private final int Hw;
    private final arb Zo;
    private final int j6;
    private final aro v5;

    arg(int i, long j, long j2, int i2, aro aro, arb arb) {
        this.j6 = i;
        this.DW = j;
        this.FH = j2;
        this.Hw = i2;
        this.v5 = aro;
        this.Zo = arb;
    }

    public int DW() {
        return this.j6;
    }

    public long j6() {
        return this.DW;
    }

    public boolean Hw() {
        return true;
    }

    public byte[] v5() {
        try {
            throw new alf(Zo());
        } catch (Throwable e) {
            alf alf = new alf();
            alf.initCause(e);
            throw alf;
        }
    }

    public anz FH() {
        asg asg = new asg(this.Zo);
        try {
            return new anz$a(this.j6, this.DW, new BufferedInputStream(new InflaterInputStream(new arv(this.v5, this.FH + ((long) this.Hw), asg), asg.Zo(), 8192), 8192));
        } catch (IOException e) {
            return asg.FH(Zo(), this.j6).FH();
        }
    }

    private ans Zo() {
        return this.v5.j6(this.FH);
    }
}
