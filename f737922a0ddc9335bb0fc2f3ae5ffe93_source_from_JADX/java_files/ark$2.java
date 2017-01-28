import java.io.IOException;
import java.io.OutputStream;

class ark$2 extends OutputStream {
    private final /* synthetic */ OutputStream DW;
    final /* synthetic */ ark j6;

    ark$2(ark ark, OutputStream outputStream) {
        this.j6 = ark;
        this.DW = outputStream;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.DW.write(bArr, i, i2);
    }

    public void write(byte[] bArr) {
        this.DW.write(bArr);
    }

    public void write(int i) {
        this.DW.write(i);
    }

    public void close() {
        try {
            if (this.j6.VH) {
                this.j6.v5.getChannel().force(true);
            }
            this.DW.close();
            this.j6.v5 = null;
        } catch (IOException e) {
            this.j6.Zo();
            throw e;
        } catch (RuntimeException e2) {
            this.j6.Zo();
            throw e2;
        } catch (Error e3) {
            this.j6.Zo();
            throw e3;
        }
    }
}
