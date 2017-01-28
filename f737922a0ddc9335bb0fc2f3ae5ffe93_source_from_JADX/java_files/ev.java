import java.io.Reader;

public final class ev extends Reader {
    private char[] DW;
    private int EQ;
    private int FH;
    private int Hw;
    private boolean J0;
    private int VH;
    private int Zo;
    private int gn;
    private Reader j6;
    private int tp;
    private int u7;
    private int v5;
    private int we;

    public ev() {
        this.DW = new char[16384];
        this.VH = 1;
        this.gn = 1;
        this.u7 = -1;
        this.tp = -1;
    }

    public int read(char[] cArr, int i, int i2) {
        if (this.J0) {
            return -1;
        }
        if (this.Hw == this.FH) {
            DW();
            if (this.J0) {
                return -1;
            }
        }
        char[] cArr2 = this.DW;
        int i3 = this.Hw;
        int min = this.Hw + Math.min(this.FH - this.Hw, i2);
        int i4 = i;
        while (i3 < min) {
            int i5;
            char c = cArr2[i3];
            if (c != '\ufffe') {
                i5 = i4 + 1;
                cArr[i4] = c;
            } else {
                i3 += 8;
                if (i3 >= this.FH) {
                    int i6 = (i3 - this.FH) + 1;
                    for (i5 = 0; i5 < i6; i5++) {
                        int read = this.j6.read();
                        if (read < 0) {
                            throw new RuntimeException("EOF encountered while reading position");
                        }
                        int i7 = this.FH;
                        this.FH = i7 + 1;
                        cArr2[i7] = (char) read;
                    }
                }
                if (i3 >= min) {
                    min = i3 + 1;
                    i5 = i4;
                } else {
                    i5 = i4;
                }
            }
            i3++;
            i4 = i5;
        }
        this.Hw = min;
        if (i4 == i) {
            return read(cArr, i, i2);
        }
        return i4 - i;
    }

    public void close() {
        this.j6 = null;
    }

    public void j6(Reader reader) {
        this.j6 = reader;
        this.FH = 0;
        this.Hw = 0;
        this.v5 = 0;
        this.Zo = 0;
        this.VH = 1;
        this.gn = 1;
        this.tp = -1;
        this.J0 = false;
    }

    public void j6() {
        this.VH = 0;
        this.gn = 0;
    }

    public int j6(int i, boolean z) {
        FH(i, z);
        return z ? this.EQ : this.VH;
    }

    public int DW(int i, boolean z) {
        FH(i, z);
        return z ? this.we : this.gn;
    }

    private void DW() {
        int read;
        if (this.FH + 10 >= this.DW.length) {
            if (this.v5 > 10) {
                System.arraycopy(this.DW, this.v5, this.DW, 0, this.FH - this.v5);
                this.FH -= this.v5;
                this.Hw -= this.v5;
                this.u7 -= this.v5;
                this.v5 = 0;
            } else {
                Object obj = new char[(this.DW.length * 2)];
                System.arraycopy(this.DW, 0, obj, 0, this.FH);
                this.DW = obj;
            }
        }
        do {
            read = this.j6.read(this.DW, this.FH, (this.DW.length - this.FH) - 10);
        } while (read == 0);
        if (read < 0) {
            this.J0 = true;
        } else {
            this.FH = read + this.FH;
        }
    }

    private void FH(int i, boolean z) {
        if (i < this.Zo) {
            throw new IllegalArgumentException("getLine(), getColumn() must be called for monotonically increasing values");
        }
        if ((this.v5 + i) - this.Zo == this.FH + 1) {
            i--;
        }
        if ((this.v5 + i) - this.Zo > this.FH) {
            throw new IllegalArgumentException("Trying to advance to position not yet read");
        }
        int i2 = this.v5;
        int i3 = this.Zo;
        int i4 = i2;
        while (i3 < i) {
            i2 = i4 + 1;
            switch (this.DW[i4]) {
                case '\n':
                    if (this.VH <= 0) {
                        break;
                    }
                    this.VH++;
                    this.gn = 1;
                    break;
                case '\ufffe':
                    if (i2 + 7 < this.FH) {
                        this.VH = (((this.DW[i2] << 24) | (this.DW[i2 + 1] << 16)) | (this.DW[i2 + 2] << 8)) | this.DW[i2 + 3];
                        this.gn = (((this.DW[i2 + 4] << 24) | (this.DW[i2 + 5] << 16)) | (this.DW[i2 + 6] << 8)) | this.DW[i2 + 7];
                        i2 += 8;
                        i3--;
                        break;
                    }
                    throw new RuntimeException("Incomplete buffer while reading position");
                default:
                    if (this.VH <= 0) {
                        break;
                    }
                    this.gn++;
                    break;
            }
            i3++;
            i4 = i2;
        }
        this.Zo = i;
        this.v5 = i4;
        if (z && this.tp != i) {
            this.tp = i;
            this.EQ = this.VH;
            this.we = this.gn;
            this.u7 = this.v5;
            while (true) {
                if (this.u7 >= this.FH) {
                    if (!this.J0) {
                        DW();
                        if (this.J0) {
                            return;
                        }
                    }
                    return;
                }
                if (this.DW[this.u7] == '\ufffe') {
                    this.u7++;
                    if (this.u7 + 7 >= this.FH) {
                        throw new RuntimeException("Incomplete buffer while reading position");
                    }
                    this.EQ = (((this.DW[this.u7] << 24) | (this.DW[this.u7 + 1] << 16)) | (this.DW[this.u7 + 2] << 8)) | this.DW[this.u7 + 3];
                    this.we = (((this.DW[this.u7 + 4] << 24) | (this.DW[this.u7 + 5] << 16)) | (this.DW[this.u7 + 6] << 8)) | this.DW[this.u7 + 7];
                    this.u7 += 8;
                } else {
                    return;
                }
            }
        }
    }
}
