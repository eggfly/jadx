import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class aho extends InputStream {
    int DW;
    int FH;
    agz Hw;
    OutputStream VH;
    boolean Zo;
    RandomAccessFile j6;
    boolean v5;

    public aho(ahn ahn) {
        this.Zo = false;
        this.VH = null;
        this.Hw = aha.j6(getClass().getName());
        this.v5 = this.Hw.j6();
        this.FH = 0;
        this.DW = ahn.EQ();
        this.j6 = ahn.J8().FH;
        if (ahn.J0() >= 0) {
            if (this.v5) {
                this.Hw.Hw(String.format("Seeking to %d", new Object[]{Long.valueOf(ahn.J0())}));
            }
            this.j6.seek(ahn.J0());
            return;
        }
        ahn.DW();
    }

    public void j6(boolean z) {
        this.Zo = z;
    }

    public void j6(OutputStream outputStream) {
        this.VH = outputStream;
    }

    public void close() {
    }

    public boolean markSupported() {
        return false;
    }

    public int available() {
        int i = this.DW - this.FH;
        if (this.v5) {
            this.Hw.Hw(String.format("Available = %d", new Object[]{Integer.valueOf(i)}));
        }
        if (i == 0 && this.Zo) {
            return 1;
        }
        return i;
    }

    public int read() {
        if (this.DW - this.FH != 0) {
            int read = this.j6.read();
            if (read >= 0) {
                if (this.VH != null) {
                    this.VH.write(read);
                }
                if (this.v5) {
                    this.Hw.Hw("Read 1 byte");
                }
                this.FH++;
                return read;
            } else if (!this.v5) {
                return read;
            } else {
                this.Hw.Hw("Read 0 bytes");
                return read;
            }
        } else if (!this.Zo) {
            return -1;
        } else {
            this.Zo = false;
            return 0;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        return j6(bArr, i, i2);
    }

    private int j6(byte[] bArr, int i, int i2) {
        if (this.DW - this.FH != 0) {
            int read = this.j6.read(bArr, i, Math.min(i2, available()));
            if (read > 0) {
                if (this.VH != null) {
                    this.VH.write(bArr, i, read);
                }
                this.FH += read;
            }
            if (this.v5) {
                this.Hw.Hw(String.format("Read %d bytes for read(b,%d,%d)", new Object[]{Integer.valueOf(read), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            return read;
        } else if (!this.Zo) {
            return -1;
        } else {
            this.Zo = false;
            bArr[i] = (byte) 0;
            return 1;
        }
    }

    public int read(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public long skip(long j) {
        long min = Math.min(j, (long) available());
        this.j6.seek(this.j6.getFilePointer() + min);
        if (this.v5) {
            this.Hw.Hw(String.format("Skipped %d bytes", new Object[]{Long.valueOf(min)}));
        }
        return min;
    }
}
