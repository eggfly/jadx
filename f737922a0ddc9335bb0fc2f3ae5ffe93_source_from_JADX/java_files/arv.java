import java.io.InputStream;

class arv extends InputStream {
    private final aro DW;
    private long FH;
    private final asg j6;

    arv(aro aro, long j, asg asg) {
        this.DW = aro;
        this.FH = j;
        this.j6 = asg;
        asg.j6(aro, j);
    }

    public int read(byte[] bArr, int i, int i2) {
        int j6 = this.j6.j6(this.DW, this.FH, bArr, i, i2);
        this.FH += (long) j6;
        return j6;
    }

    public int read() {
        byte[] bArr = new byte[1];
        return read(bArr, 0, 1) == 1 ? bArr[0] & 255 : -1;
    }

    public void close() {
        this.j6.FH();
    }
}
