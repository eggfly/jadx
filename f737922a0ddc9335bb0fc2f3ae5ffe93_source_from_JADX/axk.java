import java.io.OutputStream;

public class axk extends OutputStream {
    private int DW;
    private byte[] FH;
    private int Hw;
    private final OutputStream j6;
    private boolean v5;

    public axk(OutputStream outputStream) {
        this.DW = -1;
        this.FH = new byte[8000];
        this.Hw = 0;
        this.j6 = outputStream;
    }

    public void write(int i) {
        if (j6((byte) i) < 0) {
            if (this.v5) {
                this.j6.write(i);
            } else if (i == 10) {
                if (this.DW == 13) {
                    this.j6.write(10);
                    this.DW = -1;
                } else if (this.DW == -1) {
                    this.j6.write(13);
                    this.j6.write(10);
                    this.DW = -1;
                }
            } else if (i == 13) {
                this.j6.write(i);
                this.DW = 13;
            } else {
                this.j6.write(i);
                this.DW = -1;
            }
        }
    }

    public void write(byte[] bArr) {
        int j6 = j6(bArr, 0, bArr.length);
        if (j6 > 0) {
            write(bArr, bArr.length - j6, j6);
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        int j6 = j6(bArr, i, i2);
        if (j6 >= 0) {
            int i3 = (i + i2) - j6;
            if (j6 == 0) {
                return;
            }
            if (this.v5) {
                this.j6.write(bArr, i3, j6);
                return;
            }
            int i4 = i3;
            for (int i5 = i3; i5 < i3 + j6; i5++) {
                byte b = bArr[i5];
                if (b == (byte) 13) {
                    this.DW = 13;
                } else if (b == 10) {
                    if (this.DW != 13) {
                        if (i4 < i5) {
                            this.j6.write(bArr, i4, i5 - i4);
                        }
                        this.j6.write(13);
                        i4 = i5;
                    }
                    this.DW = -1;
                } else {
                    this.DW = -1;
                }
            }
            if (i4 < i3 + j6) {
                this.j6.write(bArr, i4, (i3 + j6) - i4);
            }
            if (bArr[(i3 + j6) - 1] == (byte) 13) {
                this.DW = 13;
            }
        }
    }

    private int j6(byte b) {
        if (this.Hw > this.FH.length) {
            return 1;
        }
        byte[] bArr = this.FH;
        int i = this.Hw;
        this.Hw = i + 1;
        bArr[i] = b;
        if (this.Hw == this.FH.length) {
            j6();
        }
        return 0;
    }

    private int j6(byte[] bArr, int i, int i2) {
        if (this.Hw <= this.FH.length) {
            int min = Math.min(this.FH.length - this.Hw, i2);
            System.arraycopy(bArr, i, this.FH, this.Hw, min);
            this.Hw += min;
            i2 -= min;
            if (i2 > 0) {
                j6();
            }
        }
        return i2;
    }

    private void j6() {
        this.v5 = ake.j6(this.FH, this.Hw);
        int i = this.Hw;
        this.Hw = this.FH.length + 1;
        write(this.FH, 0, i);
    }

    public void flush() {
        if (this.Hw < this.FH.length) {
            j6();
        }
        this.DW = -1;
        this.j6.flush();
    }

    public void close() {
        flush();
        this.j6.close();
    }
}
