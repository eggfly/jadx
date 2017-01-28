import java.io.BufferedInputStream;

class ajq$d$1 extends anx {
    final /* synthetic */ ajq$d j6;

    ajq$d$1(ajq$d ajq_d) {
        this.j6 = ajq_d;
    }

    public long j6() {
        return this.j6.Hw.QX();
    }

    public int DW() {
        return this.j6.Hw.we().DW();
    }

    public anz FH() {
        return new anz$a(DW(), j6(), new BufferedInputStream(this.j6.Hw.aM()));
    }

    public boolean Hw() {
        return true;
    }

    public byte[] v5() {
        throw new alf();
    }
}
