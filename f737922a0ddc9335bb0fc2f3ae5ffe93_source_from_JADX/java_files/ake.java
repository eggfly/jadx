import java.io.InputStream;
import java.io.OutputStream;

public class ake extends akh {
    public static final ake j6;
    protected final byte[] DW;
    protected final awy FH;

    static {
        j6 = new ake(new byte[0]);
    }

    public ake(byte[] bArr) {
        this.DW = bArr;
        this.FH = axe.DW(this.DW, 0, this.DW.length);
    }

    public int j6() {
        return this.FH.j6() - 2;
    }

    public void j6(OutputStream outputStream, int i) {
        int j6 = j6(i);
        int DW = DW(i);
        if (this.DW[DW - 1] == 10) {
            DW--;
        }
        outputStream.write(this.DW, j6, DW - j6);
    }

    public boolean DW() {
        int j6 = this.FH.j6(this.FH.j6() - 1);
        if (j6 != 0 && this.DW[j6 - 1] == 10) {
            return false;
        }
        return true;
    }

    private int j6(int i) {
        return this.FH.j6(i + 1);
    }

    private int DW(int i) {
        return this.FH.j6(i + 2);
    }

    public static boolean j6(byte[] bArr) {
        return j6(bArr, bArr.length);
    }

    public static boolean j6(InputStream inputStream) {
        byte[] bArr = new byte[8000];
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (read == -1) {
                break;
            }
            i += read;
        }
        return j6(bArr, i);
    }

    public static boolean j6(byte[] bArr, int i) {
        if (i > 8000) {
            i = 8000;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] == null) {
                return true;
            }
        }
        return false;
    }
}
