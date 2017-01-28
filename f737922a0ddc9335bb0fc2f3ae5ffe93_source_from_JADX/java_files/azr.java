import java.io.InputStream;

class azr extends InputStream {
    private boolean DW;
    private InputStream FH;
    private final aza j6;

    azr(aza aza) {
        this.DW = true;
        this.j6 = aza;
    }

    public int read(byte[] bArr, int i, int i2) {
        ays ays;
        int i3 = 0;
        if (this.FH == null) {
            if (!this.DW) {
                return -1;
            }
            ays = (ays) this.j6.j6();
            if (ays == null) {
                return -1;
            }
            this.DW = false;
            this.FH = ays.FH();
        }
        while (true) {
            int read = this.FH.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                read += i3;
                if (read == i2) {
                    return read;
                }
                i3 = read;
            } else {
                ays = (ays) this.j6.j6();
                if (ays == null) {
                    break;
                }
                this.FH = ays.FH();
            }
        }
        this.FH = null;
        if (i3 < 1) {
            i3 = -1;
        }
        return i3;
    }

    public int read() {
        ays ays;
        if (this.FH == null) {
            if (!this.DW) {
                return -1;
            }
            ays = (ays) this.j6.j6();
            if (ays == null) {
                return -1;
            }
            this.DW = false;
            this.FH = ays.FH();
        }
        while (true) {
            int read = this.FH.read();
            if (read >= 0) {
                return read;
            }
            ays = (ays) this.j6.j6();
            if (ays == null) {
                this.FH = null;
                return -1;
            }
            this.FH = ays.FH();
        }
    }
}
