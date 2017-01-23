import java.io.OutputStream;

class avj$d$b extends axj {
    final /* synthetic */ avj$d j6;

    avj$d$b(avj$d avj_d) {
        this.j6 = avj_d;
        super(avj_d.Hw.EQ.j6);
    }

    protected OutputStream j6() {
        this.j6.j6();
        this.j6.FH.setChunkedStreamingMode(0);
        return this.j6.FH.getOutputStream();
    }
}
