import java.io.OutputStream;
import java.io.Writer;

public abstract class anb implements Comparable {
    private static final char[] VH;
    private static final byte[] Zo;
    int DW;
    int FH;
    int Hw;
    int j6;
    int v5;

    public abstract ans v5();

    public static boolean j6(anb anb, anb anb2) {
        if (anb == anb2) {
            return true;
        }
        if (anb.DW == anb2.DW && anb.FH == anb2.FH && anb.Hw == anb2.Hw && anb.v5 == anb2.v5 && anb.j6 == anb2.j6) {
            return true;
        }
        return false;
    }

    public final int j6() {
        return this.j6 >>> 24;
    }

    public final int j6(anb anb) {
        if (this == anb) {
            return 0;
        }
        int j6 = axb.j6(this.j6, anb.j6);
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.DW, anb.DW);
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.FH, anb.FH);
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.Hw, anb.Hw);
        return j6 == 0 ? axb.j6(this.v5, anb.v5) : j6;
    }

    public final int compareTo(Object obj) {
        return j6((anb) obj);
    }

    public final int j6(byte[] bArr, int i) {
        int j6 = axb.j6(this.j6, axb.DW(bArr, i));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.DW, axb.DW(bArr, i + 4));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.FH, axb.DW(bArr, i + 8));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.Hw, axb.DW(bArr, i + 12));
        return j6 == 0 ? axb.j6(this.v5, axb.DW(bArr, i + 16)) : j6;
    }

    public final int j6(int[] iArr, int i) {
        int j6 = axb.j6(this.j6, iArr[i]);
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.DW, iArr[i + 1]);
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.FH, iArr[i + 2]);
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.Hw, iArr[i + 3]);
        return j6 == 0 ? axb.j6(this.v5, iArr[i + 4]) : j6;
    }

    public final int hashCode() {
        return this.DW;
    }

    public final boolean DW(anb anb) {
        return anb != null ? j6(this, anb) : false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof anb) {
            return DW((anb) obj);
        }
        return false;
    }

    public void DW(byte[] bArr, int i) {
        axb.DW(bArr, i, this.j6);
        axb.DW(bArr, i + 4, this.DW);
        axb.DW(bArr, i + 8, this.FH);
        axb.DW(bArr, i + 12, this.Hw);
        axb.DW(bArr, i + 16, this.v5);
    }

    public void j6(OutputStream outputStream) {
        j6(outputStream, this.j6);
        j6(outputStream, this.DW);
        j6(outputStream, this.FH);
        j6(outputStream, this.Hw);
        j6(outputStream, this.v5);
    }

    private static void j6(OutputStream outputStream, int i) {
        outputStream.write(i >>> 24);
        outputStream.write(i >>> 16);
        outputStream.write(i >>> 8);
        outputStream.write(i);
    }

    public void DW(OutputStream outputStream) {
        outputStream.write(Zo());
    }

    public void FH(byte[] bArr, int i) {
        j6(bArr, i + 0, this.j6);
        j6(bArr, i + 8, this.DW);
        j6(bArr, i + 16, this.FH);
        j6(bArr, i + 24, this.Hw);
        j6(bArr, i + 32, this.v5);
    }

    private byte[] Zo() {
        byte[] bArr = new byte[40];
        j6(bArr, 0, this.j6);
        j6(bArr, 8, this.DW);
        j6(bArr, 16, this.FH);
        j6(bArr, 24, this.Hw);
        j6(bArr, 32, this.v5);
        return bArr;
    }

    static {
        Zo = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
        VH = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private static void j6(byte[] bArr, int i, int i2) {
        int i3 = i + 7;
        while (i3 >= i && i2 != 0) {
            int i4 = i3 - 1;
            bArr[i3] = Zo[i2 & 15];
            i2 >>>= 4;
            i3 = i4;
        }
        while (i3 >= i) {
            i4 = i3 - 1;
            bArr[i3] = (byte) 48;
            i3 = i4;
        }
    }

    public void j6(char[] cArr, Writer writer) {
        j6(cArr);
        writer.write(cArr, 0, 40);
    }

    public void j6(char[] cArr, StringBuilder stringBuilder) {
        j6(cArr);
        stringBuilder.append(cArr, 0, 40);
    }

    private char[] VH() {
        char[] cArr = new char[40];
        j6(cArr);
        return cArr;
    }

    private void j6(char[] cArr) {
        j6(cArr, 0, this.j6);
        j6(cArr, 8, this.DW);
        j6(cArr, 16, this.FH);
        j6(cArr, 24, this.Hw);
        j6(cArr, 32, this.v5);
    }

    static void j6(char[] cArr, int i, int i2) {
        int i3 = i + 7;
        while (i3 >= i && i2 != 0) {
            int i4 = i3 - 1;
            cArr[i3] = VH[i2 & 15];
            i2 >>>= 4;
            i3 = i4;
        }
        while (i3 >= i) {
            i4 = i3 - 1;
            cArr[i3] = '0';
            i3 = i4;
        }
    }

    public String toString() {
        return "AnyObjectId[" + DW() + "]";
    }

    public final String DW() {
        return new String(VH());
    }

    public final String FH() {
        return DW();
    }

    public amz j6(int i) {
        return new amz(i, amz.j6(i, 1, this.j6), amz.j6(i, 2, this.DW), amz.j6(i, 3, this.FH), amz.j6(i, 4, this.Hw), amz.j6(i, 5, this.v5));
    }

    public final ans Hw() {
        if (getClass() == ans.class) {
            return (ans) this;
        }
        return new ans(this);
    }
}
