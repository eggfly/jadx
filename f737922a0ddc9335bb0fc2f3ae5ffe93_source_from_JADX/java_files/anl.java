import com.aide.uidesigner.ProxyTextView;
import java.io.OutputStream;

public abstract class anl {
    public static final anl DW;
    public static final anl FH;
    public static final anl Hw;
    public static final anl Zo;
    public static final anl j6;
    public static final anl v5;
    private final byte[] VH;
    private final int gn;
    private final int u7;

    public abstract boolean DW(int i);

    static {
        j6 = new anl$1(16384, 2);
        DW = new anl$2(40960, 3);
        FH = new anl$3(33188, 3);
        Hw = new anl$4(33261, 3);
        v5 = new anl$5(57344, 1);
        Zo = new anl$6(0, -1);
    }

    public static final anl j6(int i) {
        switch (61440 & i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                if (i == 0) {
                    return Zo;
                }
                break;
            case 16384:
                return j6;
            case 32768:
                if ((i & 73) != 0) {
                    return Hw;
                }
                return FH;
            case 40960:
                return DW;
            case 57344:
                return v5;
        }
        return new anl$7(i, -1, i);
    }

    private anl(int i, int i2) {
        int i3 = 0;
        this.gn = i;
        this.u7 = i2;
        if (i != 0) {
            byte[] bArr = new byte[10];
            int length = bArr.length;
            while (i != 0) {
                length--;
                bArr[length] = (byte) ((i & 7) + 48);
                i >>= 3;
            }
            this.VH = new byte[(bArr.length - length)];
            while (i3 < this.VH.length) {
                this.VH[i3] = bArr[length + i3];
                i3++;
            }
            return;
        }
        this.VH = new byte[]{(byte) 48};
    }

    public void j6(OutputStream outputStream) {
        outputStream.write(this.VH);
    }

    public void j6(byte[] bArr, int i) {
        System.arraycopy(this.VH, 0, bArr, i, this.VH.length);
    }

    public int j6() {
        return this.VH.length;
    }

    public int DW() {
        return this.u7;
    }

    public String toString() {
        return Integer.toOctalString(this.gn);
    }

    public int FH() {
        return this.gn;
    }
}
