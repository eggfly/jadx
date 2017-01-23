import java.io.InputStream;

public class axm extends InputStream {
    private final byte[] DW;
    private final InputStream FH;
    private int Hw;
    private boolean VH;
    private boolean Zo;
    private final byte[] j6;
    private int v5;

    public axm(InputStream inputStream) {
        this.j6 = new byte[1];
        this.DW = new byte[8096];
        this.FH = inputStream;
    }

    public int read() {
        return read(this.j6, 0, 1) == 1 ? this.j6[0] & 255 : -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.Hw == -1) {
            return -1;
        }
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3 && (this.v5 != this.Hw || j6())) {
            byte[] bArr2 = this.DW;
            int i5 = this.v5;
            this.v5 = i5 + 1;
            byte b = bArr2[i5];
            int i6;
            if (!this.Zo && b == (byte) 13) {
                if (this.v5 == this.Hw && !j6()) {
                    i6 = i4 + 1;
                    bArr[i4] = (byte) 13;
                    i4 = i6;
                    break;
                } else if (this.DW[this.v5] == (byte) 10) {
                    i6 = i4 + 1;
                    bArr[i4] = (byte) 10;
                    this.v5++;
                    i4 = i6;
                } else {
                    i6 = i4 + 1;
                    bArr[i4] = (byte) 13;
                    i4 = i6;
                }
            } else {
                i6 = i4 + 1;
                bArr[i4] = b;
                i4 = i6;
            }
        }
        if (i != i4) {
            return i4 - i;
        }
        return -1;
    }

    public void close() {
        this.FH.close();
    }

    private boolean j6() {
        this.Hw = this.FH.read(this.DW, 0, this.DW.length);
        if (this.Hw < 1) {
            return false;
        }
        if (!this.VH) {
            this.Zo = ake.j6(this.DW, this.Hw);
            this.VH = true;
        }
        this.v5 = 0;
        return true;
    }
}
