import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class ahp extends OutputStream {
    CRC32 DW;
    int FH;
    OutputStream Hw;
    int j6;
    OutputStream v5;

    public ahp(int i, OutputStream outputStream) {
        this.j6 = 0;
        this.DW = new CRC32();
        this.FH = 0;
        this.Hw = outputStream;
        if (i != 0) {
            this.v5 = new DeflaterOutputStream(outputStream, new Deflater(9, true));
        } else {
            this.v5 = outputStream;
        }
    }

    public void close() {
        this.v5.flush();
        this.v5.close();
        this.FH = (int) this.DW.getValue();
    }

    public int j6() {
        return this.FH;
    }

    public void flush() {
        this.v5.flush();
    }

    public void write(byte[] bArr) {
        this.v5.write(bArr);
        this.DW.update(bArr);
        this.j6 += bArr.length;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.v5.write(bArr, i, i2);
        this.DW.update(bArr, i, i2);
        this.j6 += i2;
    }

    public void write(int i) {
        this.v5.write(i);
        this.DW.update(i);
        this.j6++;
    }

    public int DW() {
        return this.j6;
    }

    public OutputStream FH() {
        return this.Hw;
    }
}
