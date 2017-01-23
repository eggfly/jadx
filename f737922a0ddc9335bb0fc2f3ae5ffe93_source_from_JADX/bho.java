import java.io.OutputStream;

public class bho implements bhm {
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

    public bho() {
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

    private boolean j6(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    public int j6(String str, OutputStream outputStream) {
        int i = 0;
        int length = str.length();
        while (length > 0 && j6(str.charAt(length - 1))) {
            length--;
        }
        int i2 = 0;
        while (i < length) {
            int i3 = i;
            while (i3 < length && j6(str.charAt(i3))) {
                i3++;
            }
            i = i3 + 1;
            byte b = this.DW[str.charAt(i3)];
            while (i < length && j6(str.charAt(i))) {
                i++;
            }
            i3 = i + 1;
            outputStream.write(this.DW[str.charAt(i)] | (b << 4));
            i2++;
            i = i3;
        }
        return i2;
    }
}
