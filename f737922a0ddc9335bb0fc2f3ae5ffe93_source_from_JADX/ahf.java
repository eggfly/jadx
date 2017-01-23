import java.io.OutputStream;

public class ahf {
    protected final byte[] DW;
    protected final byte[] j6;

    protected void j6() {
        for (int i = 0; i < this.j6.length; i++) {
            this.DW[this.j6[i]] = (byte) i;
        }
        this.DW[65] = this.DW[97];
        this.DW[66] = this.DW[98];
        this.DW[67] = this.DW[99];
        this.DW[68] = this.DW[100];
        this.DW[69] = this.DW[101];
        this.DW[70] = this.DW[102];
    }

    public ahf() {
        this.j6 = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
        this.DW = new byte[128];
        j6();
    }

    public int j6(byte[] bArr, int i, int i2, OutputStream outputStream) {
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4 = bArr[i3] & 255;
            outputStream.write(this.j6[i4 >>> 4]);
            outputStream.write(this.j6[i4 & 15]);
        }
        return i2 * 2;
    }
}
