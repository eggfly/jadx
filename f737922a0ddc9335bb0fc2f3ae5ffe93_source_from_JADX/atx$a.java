import com.jcraft.jsch.ChannelExec;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;

class atx$a extends Process {
    private ChannelExec DW;
    private final int FH;
    private InputStream Hw;
    private InputStream Zo;
    final /* synthetic */ atx j6;
    private OutputStream v5;

    private atx$a(atx atx, String str, int i) {
        this.j6 = atx;
        this.FH = i;
        try {
            this.DW = (ChannelExec) atx.j6.j6("exec");
            this.DW.DW(str);
            j6();
            this.DW.DW(this.FH > 0 ? this.FH * 1000 : 0);
            if (!this.DW.EQ()) {
                throw new amb(atx.DW, "connection failed");
            }
        } catch (Throwable e) {
            throw new amb(atx.DW, e.getMessage(), e);
        }
    }

    private void j6() {
        this.Hw = this.DW.Hw();
        OutputStream Zo = this.DW.Zo();
        if (this.FH <= 0) {
            this.v5 = Zo;
        } else {
            InputStream pipedInputStream = new PipedInputStream();
            axq axq = new axq(pipedInputStream, Zo);
            Zo = new atx$a$1(this, pipedInputStream, axq);
            axq.start();
            this.v5 = Zo;
        }
        this.Zo = this.DW.XL();
    }

    public InputStream getInputStream() {
        return this.Hw;
    }

    public OutputStream getOutputStream() {
        return this.v5;
    }

    public InputStream getErrorStream() {
        return this.Zo;
    }

    public int exitValue() {
        if (!DW()) {
            return this.DW.we();
        }
        throw new IllegalStateException();
    }

    private boolean DW() {
        return this.DW.we() < 0 && this.DW.EQ();
    }

    public void destroy() {
        if (this.DW.EQ()) {
            this.DW.tp();
        }
    }

    public int waitFor() {
        while (DW()) {
            Thread.sleep(100);
        }
        return exitValue();
    }
}
