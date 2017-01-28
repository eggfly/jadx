import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

final class asr$a extends OutputStream {
    private final byte[] DW;
    private int FH;
    private final Deflater j6;

    asr$a(Deflater deflater, byte[] bArr) {
        this.j6 = deflater;
        this.DW = bArr;
    }

    int j6() {
        this.j6.finish();
        while (this.FH != this.DW.length) {
            int deflate = this.j6.deflate(this.DW, this.FH, this.DW.length - this.FH);
            if (deflate != 0) {
                this.FH = deflate + this.FH;
            } else if (this.j6.finished()) {
                return this.FH;
            } else {
                throw new IOException();
            }
        }
        throw new EOFException();
    }

    public void write(byte[] bArr, int i, int i2) {
        this.j6.setInput(bArr, i, i2);
        while (this.FH != this.DW.length) {
            int deflate = this.j6.deflate(this.DW, this.FH, this.DW.length - this.FH);
            if (deflate != 0) {
                this.FH = deflate + this.FH;
            } else if (!this.j6.needsInput()) {
                throw new IOException();
            } else {
                return;
            }
        }
        throw new EOFException();
    }

    public void write(int i) {
        throw new UnsupportedOperationException();
    }
}
