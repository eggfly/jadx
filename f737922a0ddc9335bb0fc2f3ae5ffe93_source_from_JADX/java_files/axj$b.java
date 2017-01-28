import java.io.InputStream;

class axj$b extends InputStream {
    private byte[] DW;
    private int FH;
    private axj$a Hw;
    final /* synthetic */ axj j6;
    private int v5;

    axj$b(axj axj) {
        this.j6 = axj;
        this.Hw = (axj$a) axj.j6.get(this.FH);
    }

    public int read() {
        if (this.DW == null) {
            this.DW = new byte[1];
        }
        return read(this.DW) == 1 ? this.DW[0] & 255 : -1;
    }

    public long skip(long j) {
        long j2 = 0;
        while (0 < j) {
            int min = (int) Math.min((long) (this.Hw.DW - this.v5), j);
            if (min <= 0) {
                if (!j6()) {
                    break;
                }
            } else {
                this.v5 += min;
                j2 += (long) min;
                j -= (long) min;
            }
        }
        return j2;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int min = Math.min(this.Hw.DW - this.v5, i2);
            if (min <= 0) {
                if (!j6()) {
                    break;
                }
            } else {
                System.arraycopy(this.Hw.j6, this.v5, bArr, i, min);
                this.v5 += min;
                i += min;
                i2 -= min;
                i3 += min;
            }
        }
        if (i3 <= 0) {
            return -1;
        }
        return i3;
    }

    private boolean j6() {
        int i = this.FH + 1;
        this.FH = i;
        if (i >= this.j6.j6.size()) {
            return false;
        }
        this.Hw = (axj$a) this.j6.j6.get(this.FH);
        this.v5 = 0;
        return true;
    }
}
