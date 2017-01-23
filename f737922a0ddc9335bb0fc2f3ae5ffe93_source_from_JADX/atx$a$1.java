import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class atx$a$1 extends PipedOutputStream {
    private final /* synthetic */ axq DW;
    final /* synthetic */ atx$a j6;

    atx$a$1(atx$a atx_a, PipedInputStream pipedInputStream, axq axq) {
        this.j6 = atx_a;
        this.DW = axq;
        super(pipedInputStream);
    }

    public void flush() {
        super.flush();
        this.DW.j6();
    }

    public void close() {
        super.close();
        try {
            this.DW.join((long) (this.j6.FH * 1000));
        } catch (InterruptedException e) {
        }
    }
}
