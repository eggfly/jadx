import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class axo extends Writer {
    private final OutputStreamWriter DW;
    private final ByteArrayOutputStream j6;

    public axo() {
        this.j6 = new ByteArrayOutputStream();
        this.DW = new OutputStreamWriter(j6(), anj.DW);
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.j6) {
            this.DW.write(cArr, i, i2);
            this.DW.flush();
        }
    }

    public OutputStream j6() {
        return this.j6;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return axe.DW(this.j6.toByteArray());
    }
}
