import java.io.OutputStream;

public class auf {
    private static final byte[] Hw;
    private final byte[] DW;
    private boolean FH;
    private final OutputStream j6;

    public auf(OutputStream outputStream) {
        this.j6 = outputStream;
        this.DW = new byte[5];
        this.FH = true;
    }

    public void j6(boolean z) {
        this.FH = z;
    }

    public void j6(String str) {
        j6(anj.DW(str));
    }

    public void j6(byte[] bArr) {
        j6(bArr.length + 4);
        this.j6.write(this.DW, 0, 4);
        this.j6.write(bArr);
    }

    public void j6() {
        j6(0);
        this.j6.write(this.DW, 0, 4);
        if (this.FH) {
            DW();
        }
    }

    public void DW() {
        this.j6.flush();
    }

    static {
        Hw = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    }

    private void j6(int i) {
        j6(this.DW, i);
    }

    static void j6(byte[] bArr, int i) {
        int i2 = 3;
        while (i2 >= 0 && i != 0) {
            int i3 = i2 - 1;
            bArr[i2] = Hw[i & 15];
            i >>>= 4;
            i2 = i3;
        }
        while (i2 >= 0) {
            i3 = i2 - 1;
            bArr[i2] = (byte) 48;
            i2 = i3;
        }
    }
}
