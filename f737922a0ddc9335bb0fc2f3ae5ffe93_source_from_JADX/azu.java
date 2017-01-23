import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class azu extends ayv implements azb {
    private static final char[] FH;
    protected int DW;
    protected byte[] j6;

    static {
        FH = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static azu j6(Object obj) {
        if (obj == null || (obj instanceof azu)) {
            return (azu) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static azu j6(azc azc, boolean z) {
        Object EQ = azc.EQ();
        if (z || (EQ instanceof azu)) {
            return j6(EQ);
        }
        return DW(((ayr) EQ).Hw());
    }

    public azu(byte[] bArr, int i) {
        this.j6 = bArr;
        this.DW = i;
    }

    public azu(byte[] bArr) {
        this(bArr, 0);
    }

    public azu(ayh ayh) {
        try {
            this.j6 = ayh.w_().j6("DER");
            this.DW = 0;
        } catch (IOException e) {
            throw new IllegalArgumentException("Error processing object : " + e.toString());
        }
    }

    public byte[] FH() {
        return this.j6;
    }

    public int Hw() {
        return this.DW;
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return ((bbg.j6(this.j6.length + 1) + 1) + this.j6.length) + 1;
    }

    void j6(ayt ayt) {
        byte[] bArr = new byte[(FH().length + 1)];
        bArr[0] = (byte) Hw();
        System.arraycopy(FH(), 0, bArr, 1, bArr.length - 1);
        ayt.j6(3, bArr);
    }

    public int hashCode() {
        return this.DW ^ bhf.j6(this.j6);
    }

    protected boolean j6(ayv ayv) {
        if (!(ayv instanceof azu)) {
            return false;
        }
        azu azu = (azu) ayv;
        if (this.DW == azu.DW && bhf.j6(this.j6, azu.j6)) {
            return true;
        }
        return false;
    }

    public String j6() {
        StringBuffer stringBuffer = new StringBuffer("#");
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ayt(byteArrayOutputStream).j6((ayh) this);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != toByteArray.length; i++) {
                stringBuffer.append(FH[(toByteArray[i] >>> 4) & 15]);
                stringBuffer.append(FH[toByteArray[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new RuntimeException("internal error encoding BitString");
        }
    }

    public String toString() {
        return j6();
    }

    static azu DW(byte[] bArr) {
        if (bArr.length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        byte b = bArr[0];
        Object obj = new byte[(bArr.length - 1)];
        if (obj.length != 0) {
            System.arraycopy(bArr, 1, obj, 0, bArr.length - 1);
        }
        return new azu(obj, b);
    }

    static azu j6(int i, InputStream inputStream) {
        if (i < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int read = inputStream.read();
        byte[] bArr = new byte[(i - 1)];
        if (bArr.length == 0 || bhp.j6(inputStream, bArr) == bArr.length) {
            return new azu(bArr, read);
        }
        throw new EOFException("EOF encountered in middle of BIT STRING");
    }
}
